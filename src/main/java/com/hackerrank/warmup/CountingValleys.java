package com.hackerrank.warmup;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2021/1/24 20:13
 * @Description:
 * An avid hiker keeps meticulous records of their hikes. During the last hike that took exactly  steps, for every step it was noted if it was an uphill, ,
 * or a downhill,  step. Hikes always start and end at sea level, and each step up or down represents a  unit change in altitude. We define the following terms:
 *
 * A mountain is a sequence of consecutive steps above sea level, starting with a step up from sea level and ending with a step down to sea level.
 * A valley is a sequence of consecutive steps below sea level, starting with a step down from sea level and ending with a step up to sea level.
 * Given the sequence of up and down steps during a hike, find and print the number of valleys walked through.
 *
 * Example
 *
 *
 *
 * The hiker first enters a valley  units deep. Then they climb out and up onto a mountain  units high. Finally, the hiker returns to sea level and ends the
 * hike.
 *
 * Function Description
 *
 * Complete the countingValleys function in the editor below.
 *
 * countingValleys has the following parameter(s):
 *
 * int steps: the number of steps on the hike
 * string path: a string describing the path
 * Returns
 *
 * int: the number of valleys traversed
 * Input Format
 *
 * The first line contains an integer , the number of steps in the hike.
 * The second line contains a single string , of  characters that describe the path.
 *
 * Constraints
 *
 * Sample Input
 *
 * 8
 * UDDDUDUU
 * Sample Output
 *
 * 1
 * Explanation
 *
 * If we represent _ as sea level, a step up as /, and a step down as \, the hike can be drawn as:
 *
 * _/\      _
 *    \    /
 *     \/\/
 * The hiker enters and leaves one valley.
 */

public class CountingValleys {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(CountingValleys.class);


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int steps = Integer.parseInt(bufferedReader.readLine().trim());

        String path = bufferedReader.readLine();

        int result = Result.countingValleys(steps, path);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

class Result {


    /**
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */
    public static int countingValleys(int steps, String path) {
        // Write your code here
        int numV = 0;
        int at = 0;
        boolean inV = false;
        for (int i = 0; i < path.length(); i++) {
            if (path.substring(i, i + 1).equalsIgnoreCase("U")) {
                at++;
            } else {
                at--;
            }
            if (at < 0)
                inV = true;

            if (at == 0 && inV) {
                numV++;
                inV = false;
            }

        }
        return numV;
    }

}