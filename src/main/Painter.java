package main;

import java.util.ArrayList;
import java.util.Collections;
import processing.core.*;

public class Painter {
    private final int padding;
    private PApplet p;
    public Painter(PApplet myclass, int padding){
        this.padding = padding;
        p = myclass;
    }

    public void drawBoxes(ArrayList<Integer> input) {
        p.background(255);
        p.fill(0,0,0);
        int boxWidth = (p.width - 2*padding) / input.size();
        int boxHeightScale = (p.height - 2*padding) / Collections.max(input);
        int startBoxLocation = padding;
        for(int item : input){
            p.rect(startBoxLocation,  p.height - padding, boxWidth, -item*boxHeightScale);
            startBoxLocation += boxWidth;
        }

    }
}
