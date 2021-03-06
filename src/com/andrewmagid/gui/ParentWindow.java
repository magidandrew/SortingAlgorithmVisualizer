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
    //FIXME: bad design to make this public static
    public static JComboBox<String> algoCombo;
    JSlider fpsSlider;
    JSlider cardinalitySlider;
    JSpinner cardinalitySpinner;
    JSlider upperBdSlider;

    //information elements
    JLabel sliderLabel;
    JLabel cardinalityLabel;
    JLabel upperBdLabel;
    public static JProgressBar progressBar;

    //---Constants---
    //global - public
    public static final int INIT_FPS = 25;
    public static final int INIT_CARDINALITY = 50;
    public static final int INIT_UPPERBD = 50;

    //private
    private static final int MIN_FPS = 0;
    private static final int MAX_FPS = 400;
    private static final int MIN_CARDINALITY = 2;
    private static final int MAX_CARDINALITY = 5000;
    private static final int STEP_SIZE_CARDINALITY = 1;

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
        //remove divider
        splitPane.setDividerSize(0);

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

        cardinalityLabel= new JLabel("Cardinality", JLabel.CENTER);
        cardinalityLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        upperBdLabel= new JLabel("Upper Bound (Data Spread)", JLabel.CENTER);
        upperBdLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        //sliders
        fpsSlider = new JSlider(JSlider.HORIZONTAL, MIN_FPS, MAX_FPS, INIT_FPS);
        upperBdSlider = new JSlider(JSlider.HORIZONTAL, 0,100,50); //THIS SHOULD BE DEPENDENT ON CANVAS SIZE!!

        //progress bar
//        progressBar = new JProgressBar();
//        progressBar.setMinimum(0);
//        progressBar.setMaximum(Helper.unsortedArr.size());

        fpsSlider.setMajorTickSpacing(MAX_FPS/4);
        fpsSlider.setPaintTicks(true);
        fpsSlider.setPaintLabels(true);

        upperBdSlider.setMajorTickSpacing(25);
        upperBdSlider.setPaintTicks(true);
        upperBdSlider.setPaintLabels(true);

        //spinners
        cardinalitySpinner = new JSpinner(new SpinnerNumberModel(INIT_CARDINALITY, MIN_CARDINALITY,
                MAX_CARDINALITY, STEP_SIZE_CARDINALITY));

        //bind ui elements to listeners
        runBtn.addActionListener(new GuiActions.RunAlgoListener());
        generateBtn.addActionListener(new GuiActions.GenerateDatasetListener());
        fpsSlider.addChangeListener(new GuiActions.FrameRateListener());
        cardinalitySpinner.addChangeListener(new GuiActions.CardinalityListener());
        upperBdSlider.addChangeListener(new GuiActions.UpperBdListener());

        // add to panel
        controlPanel.add(algoCombo);
        controlPanel.add(runBtn);
        controlPanel.add(generateBtn);
        controlPanel.add(sliderLabel);
        controlPanel.add(fpsSlider);

        controlPanel.add(cardinalityLabel);
        controlPanel.add(cardinalitySpinner);

        controlPanel.add(upperBdLabel);
        controlPanel.add(upperBdSlider);
//        controlPanel.add(progressBar);
    }
}
