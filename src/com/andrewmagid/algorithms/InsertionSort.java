package com.andrewmagid.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class InsertionSort extends AbstractSortAlgorithm {
    public InsertionSort(ArrayList<Integer> unsorted) {
        super(unsorted);
    }

    @Override
    public ArrayList<ArrayList<Integer>> sortAlgo(ArrayList<Integer> unsorted) {
        ArrayList<Integer> unsortedInput = new ArrayList<>(unsorted);
        ArrayList<Map.Entry<Integer, int[]>> iterHighlight = new ArrayList<>();

        for(int i=1; i<unsortedInput.size(); i++){
            if(unsortedInput.get(i) < unsortedInput.get(i-1)){
                int tmp=unsortedInput.get(i), j=i-1;
                while(j >= 0 && unsortedInput.get(j) > tmp){
                    unsortedInput.set(j+1, unsortedInput.get(j));
                    j -= 1;
                }
                unsortedInput.set(j+1, tmp);
            }
        }

        addSetPadding();
        assertArrSizes();
        return sorted;
    }

    public static void main(String[] args) {
        ArrayList<Integer> test = new ArrayList<>(Arrays.asList(5,2,4,1, 3,2,10,15,22,3,5));
        InsertionSort is = new InsertionSort(test);
        is.sortAlgo(test);
    }
}
