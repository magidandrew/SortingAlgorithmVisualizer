package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Algorithms {

    public static ArrayList<ArrayList<ArrayList<Integer>>> mergeSort(ArrayList<Integer> myinput){
        //input gets changed each iteration
        ArrayList<Integer> input = new ArrayList<>(myinput);
        //sorted is a list of 'input' lists
        ArrayList<ArrayList<Integer>> sorted = new ArrayList<>();
        ArrayList<ArrayList<Integer>> highlightedIndices = new ArrayList<>();

        //initial case, even if nothing gets sorted
        sorted.add(myinput);

        boolean swapped = true;
        while(swapped){
            swapped = false;
            for(int i = 0; i < input.size() - 1; i++){
                if(input.get(i) > input.get(i+1)){
                    highlightedIndices.add(new ArrayList<>(Arrays.asList(i,i+1)));
                    int tmp = input.get(i);
                    input.set(i, input.get(i+1));
                    input.set(i+1, tmp);
                    sorted.add(new ArrayList<>(input));
                    swapped = true;
                }
            }
        }
        //extra to make animations work (the right ones are swapped). i'm not sure why this is the case
        highlightedIndices.add(new ArrayList<>());

        ArrayList<ArrayList<ArrayList<Integer>>> result = new ArrayList<>();
        result.add(sorted);
        result.add(highlightedIndices);
        return result;
    }

    public static String[] getAlgorithmNames(){
        //TO IMPLEMENT:
        /*
        InsertionSort
        SelectionSort
        MergeSort
        HeapSort
        QuickSort
        ShellSort
        BubbleSort
        CombSort
        CountingSort
        BucketSort
        RadixSort
        TreeSort
        CubeSort
         */
        return new String[]{"MergeSort", "QuickSort", "BubbleSort", "BinarySort"};
    }

}
