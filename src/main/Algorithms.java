package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Algorithms {

    public static ArrayList<ArrayList<Integer>> mergeSort(ArrayList<Integer> myinput){
        //input gets changed each iteration
        ArrayList<Integer> input = new ArrayList<>(myinput);
        //sorted is a list of 'input' lists
        ArrayList<ArrayList<Integer>> sorted = new ArrayList<>();

        //initial case, even if nothing gets sorted
        sorted.add(myinput);

        boolean swapped = true;
        while(swapped){
            swapped = false;
            for(int i = 0; i < input.size() - 1; i++){
                if(input.get(i) > input.get(i+1)){
                    int tmp = input.get(i);
                    input.set(i, input.get(i+1));
                    input.set(i+1, tmp);
                    sorted.add(new ArrayList<>(input));
                    swapped = true;
                }
            }
        }
        return sorted;
    }


    public static String[] getAlgorithmNames(){
        return new String[]{"MergeSort", "QuickSort", "BubbleSort", "BinarySort"};
    }


}
