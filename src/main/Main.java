package main;

import processing.core.PApplet;

import javax.swing.*;

import processing.awt.PSurfaceAWT.SmoothCanvas;
import processing.core.PImage;
import processing.core.PSurface;

import com.andrewmagid.gui.*;
//FIXME: this is import global variables. Do not want this to be like magic.
import static main.Helper.*;

public class Main extends PApplet {
    //TODO: THIS NEEDS TO BE CLEANED UP AND INITIALIZED
    private Painter p;
    private Helper helper;
    public static int frameRate = ParentWindow.INIT_FPS;
    private PImage icon;

    public void settings(){
        size(900,650);
    }

    public void setup(){
        background(255);
        p = new Painter(this, 50);
        helper = new Helper(this);
        Helper.generateDatasetAndDisplay();
        frameRate(ParentWindow.INIT_FPS);

//        sorted = Algorithms.mergeSort(unsortedArr);
    }

    public void draw(){
        if(isRunningAlgo) {
            if(sorted.size() == 0){
                isRunningAlgo = false;
                noLoop();
            }
            else{
                //update framerate!!
                frameRate(frameRate);
                //draw and remove
//                p.drawBoxes(sorted.get(0), indicesHighlighted.get(0));
                p.drawBoxes(sorted.get(0));
                sorted.remove(0);
//                indicesHighlighted.remove(0);

//                ParentWindow.progressBar.setValue(originalUnsortedSize - sorted.size());
//                System.out.println(originalUnsortedSize - sorted.size());
//                ParentWindow.progressBar.update(ParentWindow.progressBar.getGraphics());
//                ParentWindow.progressBar.repaint();
            }
        }
        //if not running, display the current unsorted arr
        else{
            p.drawBoxes(unsortedArr);
            noLoop();
        }
    }



    public static void main(String[] args) {
//        PApplet.main("main.Main");

        //create your JFrame
        JFrame frame = new JFrame("Algorithm Visualizer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//        frame.setIconImage(new ImageIcon("/Users/andrewmagid/IdeaProjects/ProcessingSetup/src/icon.png").getImage());
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

        //start your sketch
        ps.startThread();

    }
}
