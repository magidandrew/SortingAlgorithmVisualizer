package com.andrewmagid.gui;

import main.Helper;
import processing.awt.PSurfaceAWT;
import javax.swing.*;
import java.awt.*;
import com.andrewmagid.gui.GuiActions;


public class ParentWindow extends JFrame {
    //panels
    private     JSplitPane  splitPane;
    private     JPanel graphicsPanel;
    private     JPanel controlPanel;

    //interface elements
    Button runBtn;
    Button generateBtn;
    JComboBox<String> algoCombo;
    JSlider fpsSlider;

    //information elements
    JLabel sliderLabel;
    public static JProgressBar progressBar;


    //Constants
    private static final int MIN_FPS = 0;
    private static final int MAX_FPS = 600;
    public static final int INIT_FPS = 300;

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

        parentFrame.pack();
        parentFrame.setSize(1100,650);
        parentFrame.setVisible(true);
        parentFrame.setResizable(false);
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
        //
        algoCombo = new JComboBox<>(main.Algorithms.getAlgorithmNames());
        //Create the label and align
        sliderLabel = new JLabel("Frames Per Second", JLabel.CENTER);
        sliderLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        fpsSlider = new JSlider(JSlider.HORIZONTAL, MIN_FPS, MAX_FPS, INIT_FPS);

        //progress bar
//        progressBar = new JProgressBar();
//        progressBar.setMinimum(0);
//        progressBar.setMaximum(Helper.unsortedArr.size());

        fpsSlider.setMajorTickSpacing(MAX_FPS/4);
        fpsSlider.setPaintTicks(true);
        fpsSlider.setPaintLabels(true);


        //bind ui elements to actions
        runBtn.addActionListener(new GuiActions.RunAlgoListener());
        generateBtn.addActionListener(new GuiActions.GenerateDatasetListener());
        fpsSlider.addChangeListener(new GuiActions.FrameRateListener());


        // add to panel
        controlPanel.add(algoCombo);
        controlPanel.add(runBtn);
        controlPanel.add(generateBtn);
        controlPanel.add(sliderLabel);
        controlPanel.add(fpsSlider);
//        controlPanel.add(progressBar);
    }


}
