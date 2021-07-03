package com.andrewmagid.gui;

import processing.awt.PSurfaceAWT;
import javax.swing.*;
import java.awt.*;


public class ParentWindow extends JFrame {
    //panels
    private     JSplitPane  splitPane;
    private     JPanel graphicsPanel;
    private     JPanel controlPanel;

    //interface elements
    Button runBtn;
    Button generateBtn;
    JComboBox<String> algoCombo;

    public ParentWindow(JFrame parentFrame, PSurfaceAWT.SmoothCanvas canvas){
        JPanel topPanel = new JPanel();
        topPanel.setLayout( new BorderLayout() );
        parentFrame.add(topPanel);

        // Create the panels
        createGraphicsPanel(canvas);
        createControlPanel();

        // Create a splitter pane
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        topPanel.add(splitPane, BorderLayout.CENTER);

        splitPane.setRightComponent(controlPanel);
        splitPane.setLeftComponent(graphicsPanel);
    }

    public void createGraphicsPanel(PSurfaceAWT.SmoothCanvas canvas){
        graphicsPanel = new JPanel();
        graphicsPanel.setLayout(new BorderLayout());

        graphicsPanel.add(canvas);
    }

    public void createControlPanel(){
        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        runBtn = new Button("Run");
        generateBtn = new Button("Generate");
        algoCombo = new JComboBox<String>(main.Algorithms.getAlgorithmNames());

        controlPanel.add(algoCombo);
        controlPanel.add(runBtn);
        controlPanel.add(generateBtn);
    }
}
