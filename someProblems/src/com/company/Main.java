package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {





        List<List<String>> repo = new ArrayList<>();
        repo.add(Arrays.asList("add", "ed"));
        repo.add(Arrays.asList("add", "eddie"));
        repo.add(Arrays.asList("add", "edward"));
        repo.add(Arrays.asList("find", "ed"));
        repo.add(Arrays.asList("add", "edwina"));
        repo.add(Arrays.asList("find", "edw"));
        repo.add(Arrays.asList("find", "a"));


        List<List<String>> repo1 = new ArrayList<>();
        repo1.add(Arrays.asList("add", "hack"));
        repo1.add(Arrays.asList("add", "hackerrank"));
        repo1.add(Arrays.asList("find", "hac"));
        repo1.add(Arrays.asList("find", "hak"));


        System.out.println(Result.contacts(repo));

    }
}
