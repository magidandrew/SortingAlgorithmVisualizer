package main;

import processing.core.PApplet;

import java.util.ArrayList;
import java.util.Random;

public class Helper {
    public static ArrayList<Integer> unsortedArr = new ArrayList<>();
    public static Random r = new Random();
    public static ArrayList<ArrayList<Integer>> sorted;
    public static ArrayList<ArrayList<Integer>> indicesHighlighted;
    public static boolean isRunningAlgo = false;
    public static PApplet p;
    public static int originalUnsortedSize;

    Helper(PApplet p){
        Helper.p = p;
    }

    public static void setRunningAlgoStateTrue(){
        isRunningAlgo = true;
    }

    public static void setRunningAlgoStateFalse() {
        isRunningAlgo = false;
    }

    public static void generateNewDataset(int size, int upperbd){
        unsortedArr.clear();
        for(int i=0; i<size; i++){
            unsortedArr.add(r.nextInt(upperbd) + 1);
        }
    }

    public static void startLoop(){
        p.loop();
    }



}
