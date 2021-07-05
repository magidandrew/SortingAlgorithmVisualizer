package com.andrewmagid.gui;
import main.Algorithms;
import main.Helper;
import main.Main;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiActions {
    static class RunAlgoListener extends AbstractAction{
        public void actionPerformed(ActionEvent e){
            Helper.sorted = Algorithms.mergeSort(Helper.unsortedArr).get(0);
            Helper.indicesHighlighted = Algorithms.mergeSort(Helper.unsortedArr).get(1);
            Helper.originalUnsortedSize = Helper.sorted.size();
            Helper.setRunningAlgoStateTrue();
            Helper.startLoop();
        }
    }

    static class GenerateDatasetListener extends AbstractAction{
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
