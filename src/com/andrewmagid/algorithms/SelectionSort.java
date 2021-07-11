package com.andrewmagid.algorithms;

import javax.print.attribute.IntegerSyntax;
import java.util.ArrayList;
import java.util.Arrays;

//---Algo---
// Iterate over entire array and find the least element.
// Swap this with the element that's one past the "sorted" subarray.
public class SelectionSort {
    private ArrayList<ArrayList<Integer>> sorted;
    private ArrayList<ArrayList<Integer>> highlighted;

    public SelectionSort(ArrayList<Integer> unsorted){
        sorted = selectionSort(unsorted);
        highlighted = getHighlightedSelectionSort(unsorted);
    }

    //FIXME: show comparisons too, not just when an item gets swapped
    public ArrayList<ArrayList<Integer>> selectionSort(ArrayList<Integer> unsorted) {
        ArrayList<Integer> unsortedInput = new ArrayList<>(unsorted);
        ArrayList<ArrayList<Integer>> sorted = new ArrayList<>();

        for(int sortedPointer=0; sortedPointer<unsortedInput.size(); sortedPointer++){
            int min = unsortedInput.get(sortedPointer);
            int minLocation = sortedPointer;

            for(int leastElementPt=sortedPointer; leastElementPt<unsortedInput.size(); leastElementPt++){
                if(min > unsortedInput.get(leastElementPt)) {
                    min = unsortedInput.get(leastElementPt);
                    minLocation = leastElementPt;
                }
            }
            //swapping
            int tmp = unsortedInput.get(sortedPointer);
            unsortedInput.set(sortedPointer, min);
            unsortedInput.set(minLocation, tmp);
//            sorted.add(new ArrayList<>(unsortedInput));
            if(minLocation != sortedPointer){
                sorted.add(new ArrayList<>(unsortedInput));
            }
        }
        return sorted;
    }

    public ArrayList<ArrayList<Integer>> getHighlightedSelectionSort(ArrayList<Integer> unsorted) {
        ArrayList<ArrayList<Integer>> foo = new ArrayList<>();
        foo.add(new ArrayList<>(Arrays.asList(0)));
        return foo;
    }

    public ArrayList<ArrayList<Integer>> getSortedArray() {
        return sorted;
    }

    public ArrayList<ArrayList<Integer>> getHighlightedArray() {
        return highlighted;
    }
}
