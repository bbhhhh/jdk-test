package com.hackerrank;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2021/2/23 9:55
 * @Description: TODO
 */

public class StringAnagram {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(StringAnagram.class);



    /*
     * Complete the 'stringAnagram' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY dictionary
     *  2. STRING_ARRAY query
     */

    public static List<Integer> stringAnagram(List<String> dictionary, List<String> query) {
        // Write your code here
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> dictMap = new HashMap<>();
        String key;
        char[] wordCharArr;
        for (String word : dictionary) {
            wordCharArr = word.toCharArray();
            Arrays.sort(wordCharArr);
            key = Arrays.toString(wordCharArr);
            if (dictMap.containsKey(key)) {
                dictMap.put(key, dictMap.get(key) + 1);
            } else {
                dictMap.put(key, 1);
            }
        }

        for (String q : query) {
            wordCharArr = q.toCharArray();
            Arrays.sort(wordCharArr);
            key = Arrays.toString(wordCharArr);
            if (dictMap.containsKey(key)) {
                result.add(dictMap.get(key));
            } else {
                result.add(0);
            }
        }

        return result;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int dictionaryCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> dictionary = IntStream.range(0, dictionaryCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        int queryCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> query = IntStream.range(0, queryCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        List<Integer> result = stringAnagram(dictionary, query);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
