package com.andrewmagid.gui;
import com.andrewmagid.algorithms.*;
import main.Helper;
import main.Main;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiActions {
    static class RunAlgoListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            //TODO: DECIDE WHICH ALGORITHM TO USE HERE!
            String algo = (String) ParentWindow.algoCombo.getSelectedItem();
            if (algo != null) {
                switch(algo){
//                    case "BubbleSort":
//                        Helper.sorted = BubbleSort.bubbleSort(Helper.unsortedArr);
//                        Helper.indicesHighlighted = BubbleSort.getBubbleSortHighlighted(Helper.unsortedArr);
//                        break;
                    case "SelectionSort":
                        SelectionSort selectionSort = new SelectionSort(Helper.unsortedArr);
                        Helper.sorted = selectionSort.getSortedArray();
                        Helper.indicesHighlighted = selectionSort.getHighlightedArray();
                        break;


                }
            }

            Helper.originalUnsortedSize = Helper.sorted.size();
            Helper.setRunningAlgoStateTrue();
            Helper.startLoop();
        }
    }

    static class GenerateDatasetListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            //TODO: have size and upperbd dependent on ui elements
            Helper.generateDatasetAndDisplay();
        }
    }

    static class FrameRateListener implements ChangeListener {
            public void stateChanged(ChangeEvent e) {
                if (((JSlider) e.getSource()).getValue() == 0) {
                    ((JSlider) e.getSource()).setValue(1);
                }

                JSlider source = (JSlider) e.getSource();
                if (!source.getValueIsAdjusting()) {
                    Main.frameRate = source.getValue();
                }
            }
    }

    static class UpperBdListener implements ChangeListener {
        public void stateChanged(ChangeEvent e) {
            if (((JSlider) e.getSource()).getValue() == 0) {
                ((JSlider) e.getSource()).setValue(1);
            }

            JSlider source = (JSlider) e.getSource();
            if (!source.getValueIsAdjusting()) {
                Helper.upperBd = source.getValue();
                Helper.generateDatasetAndDisplay();
            }
        }
    }

    static class CardinalityListener implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent e) {
            Helper.cardinality = (int) ((JSpinner) e.getSource()).getValue();
            Helper.generateDatasetAndDisplay();
        }
    }
}
