package com.bhh.java.concurrentutil.cyclicbarrier;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2020/7/31 9:51
 * @Description: TODO
 */

public class HorseRace {
    private static final Logger logger = LoggerFactory.getLogger(HorseRace.class);
    static final int FINISH_LINE = 15;
    private List<Horse> horses = new ArrayList<>();
    private ExecutorService exec = Executors.newCachedThreadPool();
    private CyclicBarrier barrier;

    public HorseRace(int nHorses, final int pause) {
        barrier = new CyclicBarrier(nHorses, new Runnable() {
            @Override
            public void run() {
                StringBuilder s = new StringBuilder();
                for (int i = 0; i < FINISH_LINE; i++) {
                    s.append("=");
                }
                logger.info(s.toString());
                for (Horse horse : horses) {
                    logger.info(horse.tracks());
                }
                for (Horse horse : horses) {
                    if (horse.getStrides() >= FINISH_LINE) {
                        logger.info(horse + " won!");
                        exec.shutdownNow();
                        return;
                    }
                }
                try {
                    TimeUnit.MILLISECONDS.sleep(pause);
                } catch (InterruptedException e) {
                    logger.info("barrier-action sleep interrupted");
                }
            }
        });
        for (int i = 0; i < nHorses; i++) {
            Horse horse = new Horse(barrier);
            horses.add(horse);
            exec.execute(horse);
        }
    }

    public static void main(String[] args) {
        int nHorses = 7;
        int pause = 2000;
        new HorseRace(nHorses, pause);
    }
}
