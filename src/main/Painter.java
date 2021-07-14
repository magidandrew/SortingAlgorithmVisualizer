package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

import processing.core.*;

public class Painter {
    private final int padding;
    private final PApplet p;
    public Painter(PApplet myclass, int padding){
        this.padding = padding;
        p = myclass;
    }

    public void drawBoxes(ArrayList<Integer> input) {
        if(input.size() == 0){
            return;
        }
        //TODO: WEIRD PADDING ON LEFT SIDE OF CANVAS
        p.background(255);
        p.fill(0,0,0);
        p.stroke(255);
        p.strokeWeight(0.4f);
        int boxWidth = (p.width - 2*padding) / input.size();
        //BE CAUTIOUS OF INTEGER DIVISION = 0 IF MAX IS LARGER THAN HEIGHT OF THE CANVAS!!
//        int boxHeightScale = (int) Math.ceil((double)(p.height - 2*padding) / Collections.max(input));
        int boxHeightScale = (p.height - 2*padding) / Collections.max(input);
        int startBoxLocation = padding;
        for(int item : input){
            p.rect(startBoxLocation,  p.height - padding, boxWidth, -item*boxHeightScale);
            startBoxLocation += boxWidth;
        }

    }

    public void drawBoxes(ArrayList<Integer> input, ArrayList<Map.Entry<Integer, int[]>> indicesToHighlight) {
//        public void drawBoxes(ArrayList<Integer> input, ArrayList<Integer> indicesToHighlight) {
        if(input.size() == 0){
            return;
        }
        //TODO: WEIRD PADDING ON LEFT SIDE OF CANVAS
        p.background(255);
        p.stroke(255);
        p.strokeWeight(0.4f);
        int boxWidth = (p.width - 2*padding) / input.size();
        //BE CAUTIOUS OF INTEGER DIVISION = 0 IF MAX IS LARGER THAN HEIGHT OF THE CANVAS!!
//        int boxHeightScale = (int) Math.ceil((double)(p.height - 2*padding) / Collections.max(input));
        int boxHeightScale = (p.height - 2*padding) / Collections.max(input);
        int startBoxLocation = padding;
        for(int i=0; i<input.size(); i++){
            p.fill(0,0,0);
            //look thru all and see if key contains
            for (Map.Entry<Integer, int[]> arr : indicesToHighlight){
                if (arr.getKey() == i){
                    //RGB tuple
                    p.fill(arr.getValue()[0], arr.getValue()[1], arr.getValue()[2]);
                }
            }
//            if(indicesToHighlight.contains(i)){
//                p.fill(0,0,255);
//            }
            p.rect(startBoxLocation,  p.height - padding, boxWidth, -input.get(i)*boxHeightScale);
            startBoxLocation += boxWidth;
        }

    }
}
