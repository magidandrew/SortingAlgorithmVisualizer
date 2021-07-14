package com.andrewmagid.algorithms;

import java.util.ArrayList;
import java.util.Map;

public abstract class AbstractSortAlgorithm {
    protected ArrayList<ArrayList<Integer>> sorted;
    protected ArrayList<ArrayList<Map.Entry<Integer, int[]>>> highlighted;

    public AbstractSortAlgorithm(ArrayList<Integer> unsorted) {
        sorted = new ArrayList<>();
        highlighted = new ArrayList<>();
        sorted = sortAlgo(unsorted);
    }

    public abstract ArrayList<ArrayList<Integer>> sortAlgo(ArrayList<Integer> unsorted);

    public void addSetPadding() {
        sorted.add(0, new ArrayList<>());
        sorted.add(sorted.size() - 1, new ArrayList<>());
        highlighted.add(0, new ArrayList<>());
        highlighted.add(highlighted.size() - 1, new ArrayList<>());
    }

    public void assertArrSizes() {
        assert sorted.size() == highlighted.size();
    }

    public ArrayList<ArrayList<Integer>> getSortedArray() {
        return sorted;
    }

    public ArrayList<ArrayList<Map.Entry<Integer, int[]>>> getHighlightedArray() {
        return highlighted;
    }
}
