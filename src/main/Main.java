package main;

import processing.core.PApplet;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

import processing.awt.PSurfaceAWT.SmoothCanvas;
import processing.core.PSurface;

import com.andrewmagid.gui.*;

public class Main extends PApplet {
    Painter p;
    ArrayList<Integer> arr = new ArrayList<>();
    Random r = new Random();
    //    ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(10,8,7,6,5,2,1));
    ArrayList<ArrayList<Integer>> sorted;

    public void settings(){
        size(900,650);
    }

    public void setup(){
        background(0);
        p = new Painter(this, 50);
        frameRate(300);
        for(int i=0; i<150; i++){
            arr.add(r.nextInt(100) + 1);
        }
        sorted = Algorithms.mergeSort(arr);
    }

    public void draw(){
        if(sorted.size() == 0){
            System.exit(0);
        }

        //draw and remove
        p.drawBoxes(sorted.get(0));
        sorted.remove(0);
    }

    public static void main(String[] args) {
//        PApplet.main("main.Main");

        //create your JFrame
        JFrame frame = new JFrame("Algorithm Visualizer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //create your sketch
        Main pt = new Main();

        //get the PSurface from the sketch
        PSurface ps = pt.initSurface();

        //initialize the PSurface
        ps.setSize(900, 650);

        //get the SmoothCanvas that holds the PSurface
        SmoothCanvas smoothCanvas = (SmoothCanvas)ps.getNative();

//        frame.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.BLACK));

        ParentWindow window = new ParentWindow(frame, smoothCanvas);
        frame.pack();
        frame.setSize(1100,650);
        frame.setVisible(true);
        frame.setResizable(false);

        //start your sketch
        ps.startThread();
    }


}