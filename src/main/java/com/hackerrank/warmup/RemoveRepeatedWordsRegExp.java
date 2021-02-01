package com.hackerrank.warmup;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2021/1/29 16:58
 * @Description: TODO
 */

public class RemoveRepeatedWordsRegExp {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(RemoveRepeatedWordsRegExp.class);

    public static void main(String[] args) {

        String regex = "\\b(\\w+)(\\b\\W+\\b\\1\\b)*";//"/* Write a RegEx matching repeated words here. */";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE /* Insert the correct Pattern flag here.*/);

        Scanner in = new Scanner(System.in);
        int numSentences = Integer.parseInt(in.nextLine());

        while (numSentences-- > 0) {
            String input = in.nextLine();

            Matcher m = p.matcher(input);

            // Check for subsequences of input that match the compiled pattern
            while (m.find()) {
                input = input.replaceAll(m.group(0)/* The regex to replace */, m.group(1) /* The replacement. */);
                logger.info("group0={},group1={}", m.group(0), m.group(1));
            }

            // Prints the modified sentence.
            System.out.println(input);
        }

        in.close();
    }

}
