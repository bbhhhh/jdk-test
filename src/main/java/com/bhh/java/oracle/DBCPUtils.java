/**   
 *
 */
package com.bhh.java.oracle;

import javax.sql.DataSource;

import java.io.FileInputStream;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bhh.java.log.Log4jConfig;

/**
 * @author haihuab
 * @date 2019年9月11日 下午2:36:41
 */
public class DBCPUtils {
    static{
        Log4jConfig.initLog4j2();
    }

    private static final Logger log = LoggerFactory.getLogger(DBCPUtils.class);

    public static final String DB_ORACLE = "oracle";

    private static Map<String, DataSource> dataSourceMap = new ConcurrentHashMap<String, DataSource>();

    public static final String GatewayDataSourceName = "GatewayDataSource";
    //static boolean isInited = false;

    static {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                log.debug("Shutdown hook running. ");
                com.bhh.java.oracle.DBCPUtils.shutdownDBCP();
            }
        });
    }

    public static synchronized void createDataSource(String dataSourceName, String dbcpPropertyFileName) {
        boolean result = true;
        Properties dbProps = new Properties();
        Connection conn = null;
        DataSource dataSource = null;

        if (StringUtils.isBlank(dataSourceName)) {
            log.error("dataSourceName can't be null or empty");
            return;
        }

        if (dataSourceMap.containsKey(dataSourceName)) {
            log.warn("datasource {} already created, can't create again.", dataSourceName);
            return;
        }

        if (StringUtils.isBlank(dbcpPropertyFileName)) {
            log.error("dbcpPropertyFileName can't be null or empty");
            return;
        }

        try {
            log.info("creating datasource {} by property file {} ...", dataSourceName, dbcpPropertyFileName);
            dbProps.load(new FileInputStream(dbcpPropertyFileName));
            dataSource = BasicDataSourceFactory.createDataSource(dbProps);

            conn = dataSource.getConnection();
        } catch (Exception e) {
            result = false;
            log.error(e.getMessage(), e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    result = false;
                    log.error(e.getMessage(), e);
                }
            } else {
                result = false;
            }
        }
        if (result) {
            dataSourceMap.put(dataSourceName, dataSource);
            log.info("datasource {} created successfully.", dataSourceName);
        } else {
            if (dataSource != null) {
                try {
                    ((BasicDataSource) dataSource).close();
                } catch (SQLException e) {
                    log.error(e.getMessage(), e);
                }
            }
            log.error("datasource {} created failed, system exit now.", dataSourceName);
            System.exit(1);
        }

        //isInited = true;

    }

    public static Connection getConnection(String dataSourceName) throws SQLException {
        Connection conn = null;

        if (StringUtils.isBlank(dataSourceName)) {
            throw new SQLException("dataSourceName can't be null or empty");
        }

        if (!dataSourceMap.containsKey(dataSourceName)) {
            throw new SQLException("datasource {} not created yet, no connection available.", dataSourceName);
        }

        if (dataSourceMap.get(dataSourceName) != null) {
            conn = dataSourceMap.get(dataSourceName).getConnection();
            if (conn == null) {
                throw new SQLException("a null connection returned from datasource {}, something is wrong.",
                        dataSourceName);
            }
        } else {
            throw new SQLException("datasource {} is null, no connection available.", dataSourceName);
        }

        return conn;
    }

    public static void printConnStatus(String dataSourceName) throws SQLException {
        if (StringUtils.isBlank(dataSourceName)) {
            throw new SQLException("dataSourceName can't be null or empty");
        }

        if (!dataSourceMap.containsKey(dataSourceName)) {
            throw new SQLException("datasource {} not created yet, no connection available.", dataSourceName);
        }

        if (dataSourceMap.get(dataSourceName) != null) {
            BasicDataSource ds  = (BasicDataSource)dataSourceMap.get(dataSourceName);
            log.info("ds url={}",ds.getUrl());
            log.info("init conn num={}",ds.getInitialSize());
            log.info("active conn num={}",ds.getNumActive());
            log.info("idle conn num={}",ds.getNumIdle());

        } else {
            throw new SQLException("datasource {} is null, no connection available.", dataSourceName);
        }


    }

    public static void shutdownDBCP() {

        for (Entry<String, DataSource> en : dataSourceMap.entrySet()) {
            if (en.getValue() != null) {
                try {
                    ((BasicDataSource) en.getValue()).close();
                    log.info("datasource {} closed successfully.", en.getKey());
                } catch (SQLException e) {
                    log.error(e.getMessage(), e);
                }
            }
        }
    }

    public static void close(ResultSet rs, Statement stmt, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        }
    }

    public static void close(Statement stmt, Connection conn) {
        close(null, stmt, conn);
    }

    public static void close(ResultSet rs, Statement stmt) {
        close(rs, stmt, null);
    }

    public static void close(Statement stmt) {
        close(null, stmt, null);
    }

    public static void close(Connection conn) {
        close(null, null, conn);
    }


    public static void main(String[] args){
        log.info("starting DBCPUtils ...");
        log.info("Initializing DB connetion pool ... ");

        DBCPUtils.createDataSource(DBCPUtils.GatewayDataSourceName,
                Paths.get(System.getProperty("conf.dir"), "gateway-dbcp2.properties").toString());


        try {
//            TimeUnit.SECONDS.sleep(5);
            for (int i=0;i<3;i++) {
                DBCPUtils.printConnStatus(DBCPUtils.GatewayDataSourceName);
                TimeUnit.SECONDS.sleep(5);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        DBCPUtils.shutdownDBCP();
    }
}
