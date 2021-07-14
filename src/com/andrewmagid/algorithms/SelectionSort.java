package com.andrewmagid.algorithms;

import java.util.ArrayList;
import java.util.Map;

//---Algo---
// Iterate over entire array and find the least element.
// Swap this with the element that's one past the "sorted" subarray.
public class SelectionSort extends AbstractSortAlgorithm {
    public SelectionSort(ArrayList<Integer> unsorted) {
        super(unsorted);
    }

    @Override
    public ArrayList<ArrayList<Integer>> sortAlgo(ArrayList<Integer> unsorted) {
        ArrayList<Integer> unsortedInput = new ArrayList<>(unsorted);
        ArrayList<Map.Entry<Integer, int[]>> iterHighlight = new ArrayList<>();

        for (int sortedPointer = 0; sortedPointer < unsortedInput.size(); sortedPointer++) {
            int min = unsortedInput.get(sortedPointer);
            int minLocation = sortedPointer;

            for (int leastElementPt = sortedPointer; leastElementPt < unsortedInput.size(); leastElementPt++) {
                //highlight this comparison between min val and second traveling pointer
                if (min > unsortedInput.get(leastElementPt)) {
                    min = unsortedInput.get(leastElementPt);
                    minLocation = leastElementPt;
                }

                this.sorted.add(new ArrayList<>(unsortedInput));
                iterHighlight.clear();
                iterHighlight.add(Map.entry(sortedPointer, new int[]{255, 0, 0}));
                iterHighlight.add(Map.entry(leastElementPt, new int[]{0, 0, 255}));
                iterHighlight.add(Map.entry(minLocation, new int[]{0, 255, 0}));
                this.highlighted.add(new ArrayList<>(iterHighlight));
            }

            //swapping
            int tmp = unsortedInput.get(sortedPointer);
            unsortedInput.set(sortedPointer, min);
            unsortedInput.set(minLocation, tmp);
            if (minLocation != sortedPointer) {
                this.sorted.add(new ArrayList<>(unsortedInput));
                iterHighlight.clear();
                iterHighlight.add(Map.entry(minLocation, new int[]{255, 255, 0}));
                iterHighlight.add(Map.entry(sortedPointer, new int[]{255, 255, 0}));
                this.highlighted.add(new ArrayList<>(iterHighlight));
            }
        }

        addSetPadding();
        assertArrSizes();
        return this.sorted;
    }
}
