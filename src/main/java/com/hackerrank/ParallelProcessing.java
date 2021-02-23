package com.hackerrank;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2021/2/23 10:26
 * @Description: TODO
 */


public class ParallelProcessing {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(ParallelProcessing.class);

    /*
     * Complete the 'minTime' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY files
     *  2. INTEGER numCores
     *  3. INTEGER limit
     */

    public static long minTime(List<Integer> files, int numCores, int limit) {
        // Write your code here
        long result = 0;
        for (int lines : files) {
            if (lines % numCores == 0) {
                result += (lines / numCores);
            } else {
                result += lines;
            }
        }


        return result;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int filesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> files = IntStream.range(0, filesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int numCores = Integer.parseInt(bufferedReader.readLine().trim());

        int limit = Integer.parseInt(bufferedReader.readLine().trim());

        long result = minTime(files, numCores, limit);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

}
