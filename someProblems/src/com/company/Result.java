package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Result {


    public static int diagonalDifference(List<List<Integer>> arr) {

        int currentSum = 0;
        int currentIndex = 0;
        for (List<Integer> list : arr) {
            if(currentIndex >= arr.size()){
                break;
            }
            currentSum +=list.get(currentIndex);
            currentIndex++;
        }


        int column = 0;
        int secondSum =0;
        for (int i = arr.size() - 1; i >= 0 ; i--) {
            secondSum += arr.get(i).get(column);
            column++;

        }
        return Math.abs(currentSum - secondSum);
    }
    public static List<Integer> contacts(List<List<String>> queries) {

        List<String> repository = new ArrayList<>();
        List<Integer> resultSearch = new ArrayList<>();

        for (List<String> elements : queries) {

            String command = elements.get(0);
            String element = elements.get(1);

            if(command.equals("add")){
                repository.add(element);
            }else if(command.equals("find")){
                int counter = (int) repository.stream().filter(s -> s.startsWith(element)).count();

                resultSearch.add(counter);
            }

        }

        return resultSearch;
    }


}
