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
 * @Date : 2021/2/20 15:28
 * @Description: TODO
 */

public class DumbBellPairs {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(DumbBellPairs.class);

    /*
     * Complete the 'taskOfPairing' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts LONG_INTEGER_ARRAY freq as parameter.
     */

    public static long taskOfPairing(List<Long> freq) {
        // Write your code here
        long pairs = 0;
        boolean isOdd = false;
        boolean hasRemained = false;
        long curNum = 0;
        for (int weight = 1; weight <= freq.size(); weight++) {
            curNum = freq.get(weight - 1);
            pairs += (curNum / 2);
            if (curNum % 2 != 0) {
                if (hasRemained) {
                    pairs++;
                    hasRemained = false;
                } else {
                    hasRemained = true;
                }
                isOdd = true;
            } else {
                if (!isOdd) {
                    hasRemained = false;
                }
                isOdd = false;
            }

        }

        return pairs;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int freqCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Long> freq = IntStream.range(0, freqCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Long::parseLong)
                .collect(toList());

        long result = DumbBellPairs.taskOfPairing(freq);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
