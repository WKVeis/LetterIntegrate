package com.test.letter.model;

import java.util.*;

/**
 * Created by veis on 2020/12/28
 */
public class LetterInit {
    private final static LetterInit INSTANCE = new LetterInit();

    public static LetterInit getInstance() {

        return INSTANCE;
    }
    public Map<String, List<String>> LetterMap() {
        Hashtable<String, List<String>> map = new Hashtable<>();
        map.put("1", Arrays.asList(""));
        map.put("2", Arrays.asList("A", "B", "C"));
        map.put("3", Arrays.asList("D", "E", "F"));
        map.put("4", Arrays.asList("G", "H", "I"));
        map.put("5", Arrays.asList("J", "K", "L"));
        map.put("6", Arrays.asList("M", "N", "O"));
        map.put("7", Arrays.asList("P", "Q", "R", "S"));
        map.put("8", Arrays.asList("T", "U", "V"));
        map.put("9", Arrays.asList("W", "X", "Y", "Z"));
        map.put("0", Arrays.asList(""));
        return map;
    }

}