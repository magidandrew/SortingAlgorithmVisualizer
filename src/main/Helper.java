package main;

import com.andrewmagid.gui.ParentWindow;
import processing.core.PApplet;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class Helper {
    public static ArrayList<Integer> unsortedArr = new ArrayList<>();
    public static Random r = new Random();
    public static ArrayList<ArrayList<Integer>> sorted;
//    public static ArrayList<ArrayList<Integer>> indicesHighlighted;
    public static ArrayList<ArrayList<Map.Entry<Integer, int[]>>> indicesHighlighted;
    public static boolean isAlgoRunning = false;
    public static PApplet p;
    public static int originalUnsortedSize;

    //global arrays
    public static int cardinality = ParentWindow.INIT_CARDINALITY;
    public static int upperBd = ParentWindow.INIT_UPPERBD;

    Helper(PApplet p) {
        Helper.p = p;
    }

    public static void setRunningAlgoStateTrue() {
        isAlgoRunning = true;
    }

    public static void setRunningAlgoStateFalse() {
        isAlgoRunning = false;
    }

    public static void generateNewDataset(int size, int upperbd) {
        unsortedArr.clear();
        for (int i = 0; i < size; i++) {
            unsortedArr.add(r.nextInt(upperbd) + 1);
        }
    }

    public static void startLoop() {
        p.loop();
    }

    public static void generateDatasetAndDisplay() {
        Helper.setRunningAlgoStateFalse();
        Helper.generateNewDataset(Helper.cardinality, Helper.upperBd);
        Helper.startLoop();
    }

}
