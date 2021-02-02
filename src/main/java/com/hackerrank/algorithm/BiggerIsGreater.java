package com.hackerrank.algorithm;

import java.io.IOException;
import java.util.Scanner;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2021/2/2 13:41
 * @Description:
 * Lexicographical order is often known as alphabetical order when dealing with strings. A string is greater than another string if it comes later in a
 * lexicographically sorted list.
 *
 * Given a word, create a new word by swapping some or all of its characters. This new word must meet two criteria:
 *
 * It must be greater than the original word
 * It must be the smallest word that meets the first condition
 * For example, given the word w=abcd, the next largest word is abdc.
 *
 * Complete the function biggerIsGreater below to create and return the new string meeting the criteria. If it is not possible, return no answer.
 *
 * Function Description
 *
 * Complete the biggerIsGreater function in the editor below. It should return the smallest lexicographically higher string possible from the given string or
 * no answer.
 *
 * biggerIsGreater has the following parameter(s):
 *
 * w: a string
 * Input Format
 *
 * The first line of input contains T, the number of test cases.
 * Each of the next T lines contains w.
 *
 * Constraints
 * 1<=T<=10^5
 * 1<=|w|<=100
 * w will contain only letters in the range ascii[a..z].
 * Output Format
 *
 * For each test case, output the string meeting the criteria. If no answer exists, print no answer.
 *
 * Sample Input 0
 *
 * 5
 * ab
 * bb
 * hefg
 * dhck
 * dkhc
 * Sample Output 0
 *
 * ba
 * no answer
 * hegf
 * dhkc
 * hcdk
 * Explanation 0
 *
 * Test case 1:
 * ba is the only string which can be made by rearranging ab. It is greater.
 * Test case 2:
 * It is not possible to rearrange bb and get a greater string.
 * Test case 3:
 * hegf is the next string greater than hefg.
 * Test case 4:
 * dhkc is the next string greater than dhck.
 * Test case 5:
 * hcdk is the next string greater than dkhc.
 * Sample Input 1
 *
 * 6
 * lmno
 * dcba
 * dcbb
 * abdc
 * abcd
 * fedcbabcd
 * Sample Output 1
 *
 * lmon
 * no answer
 * no answer
 * acbd
 * abdc
 * fedcbabdc
 */

public class BiggerIsGreater {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(BiggerIsGreater.class);

    static String biggerIsGreater(String w) {
        //String r = "";
        char[] inArr = w.toCharArray();
        //char[] copyInArr = Arrays.copyOf(inArr, inArr.length);

        //find out the edge of longest increaing sub-array from right to left
        boolean noAns = true;
        int pos;
        for (pos = inArr.length - 1; pos > 0; pos--) {
            if (inArr[pos] > inArr[pos - 1]) {
                noAns = false;
                break;
            }
        }
        if (noAns) {
            return "no answer";
        }


        //find out the mininal element in sub-array which > array[pos-1] and swap them
        char temp;
        for (int j = inArr.length - 1; j > pos - 1; j--) {
            if (inArr[j] > inArr[pos - 1]) {
                temp = inArr[pos - 1];
                inArr[pos - 1] = inArr[j];
                inArr[j] = temp;
                break;
            }
        }

        // reverse the sub-array
        for (int i = pos, j = inArr.length - 1; j > i; i++, j--) {
            temp = inArr[i];
            inArr[i] = inArr[j];
            inArr[j] = temp;
        }

        return new String(inArr);

    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int TItr = 0; TItr < T; TItr++) {
            String w = scanner.nextLine();

            String result = biggerIsGreater(w);
            System.out.println(result);
            //  bufferedWriter.write(result);
            //  bufferedWriter.newLine();
        }

        //bufferedWriter.close();

        scanner.close();
    }
}
