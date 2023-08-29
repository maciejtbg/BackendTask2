package io.lsn;

import java.util.*;

public class PairsApp {
    public static void main(String[] args) {
        List<Integer> inputList = getIntegerList();
//        List<Integer> inputList = new ArrayList<>(Arrays.asList(1, 2, 10, 7, 5, 3, 6, 6, 13, 0));//uncomment this code to pass input list from here
        List<int[]> outputList = findPairs(inputList);
        outputList.sort(Comparator.comparingInt(pair -> pair[0]));
        printOutput(outputList);
    }

    static List<int[]> findPairs(List<Integer> inputList) {
        List<int[]> outputList = new ArrayList<>();
        Collections.sort(inputList); //sort list to optimize searching
        outerLoop:
        for (int i = 0; i < inputList.size(); i++) {
            int fulfilment = 13 - inputList.get(i);
            for (int j = inputList.size() - 1; j >= 0; j--) {
                if (i == j) {
                    //cursors are in the same place - break outer loop
                    break outerLoop;
                }
                if (inputList.get(j) < fulfilment) {
                    //it is too far, go to next iteration of outer loop
                    break;
                } else if (inputList.get(j) == fulfilment) {
                    //pair found but do not break, repetition are possible
                    int[] pair = {Math.min(inputList.get(i), inputList.get(j)), Math.max(inputList.get(i), inputList.get(j))};
                    outputList.add(pair);
                }
            }
        }
        return outputList;
    }

    private static void printOutput(List<int[]> outputList) {
        for (int[] pair : outputList) {
            System.out.println(pair[0] + " " + pair[1]);
        }
    }
    private static List<Integer> getIntegerList() {
        System.out.println("Enter any number of integers. When You finish, press Enter...");
        Scanner scanner = new Scanner(System.in);
        List<Integer> inputList = new ArrayList<>();
        String userInput;
        int variable;

        while (true) { // while loop can be broken from inside
            userInput = scanner.nextLine();
            if (userInput.isEmpty()) {
                break;
            }
            try {
                variable = Integer.parseInt(userInput);
                inputList.add(variable);
            } catch (NumberFormatException e) {
                System.err.println("Invalid format. Ignoring: " + userInput);
            }
        }
        return inputList;
    }
}