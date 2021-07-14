package com.andrewmagid.algorithms;

import java.util.ArrayList;
import java.util.Map;

public class BubbleSort extends AbstractSortAlgorithm {
    public BubbleSort(ArrayList<Integer> unsorted) {
        super(unsorted);
    }

    @Override
    public ArrayList<ArrayList<Integer>> sortAlgo(ArrayList<Integer> unsorted) {
        ArrayList<Integer> unsortedInput = new ArrayList<>(unsorted);
        ArrayList<Map.Entry<Integer, int[]>> iterHighlight = new ArrayList<>();

        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < unsortedInput.size() - 1; i++) {
                if (unsortedInput.get(i) > unsortedInput.get(i + 1)) {
                    iterHighlight.clear();
                    iterHighlight.add(Map.entry(i, new int[]{0, 0, 255}));
                    iterHighlight.add(Map.entry(i + 1, new int[]{0, 0, 255}));
                    highlighted.add(new ArrayList<>(iterHighlight));

                    int tmp = unsortedInput.get(i);
                    unsortedInput.set(i, unsortedInput.get(i + 1));
                    unsortedInput.set(i + 1, tmp);
                    sorted.add(new ArrayList<>(unsortedInput));
                    swapped = true;
                }
            }
        }
        addSetPadding();
        assertArrSizes();
        return sorted;
    }
}
