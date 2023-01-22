
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quiz implements ActionListener {

    protected JFrame frame;
    protected JPanel mainPanel, q_quePanel, q_optionMainPanel, q_msgPanel, q_optionPanelA;
    protected JPanel q_optionPanelB, q_optionPanelC, q_optionPanelD;
    protected JPanel s_subMainPanel, s_imgPanel, s_infoPanel;
    protected JPanel f_subMainPanel, f_resultPanel;
    protected JTextField s_nameField, s_mobilField;
    protected JPasswordField s_passwordField;

    protected JLabel q_queLabel, timerLabel;
    protected JLabel successfullLabel, totalQueLabel, obainNumLabel, persentageLabel, correctAnsLabel;
    protected JLabel s_topicLabel, s_nameLabel, s_mobileLabel, s_passwordLabel, f_scoreLabel, f_persentageLabel;
    protected JRadioButton A_Rbtn, B_Rbtn, C_Rbtn, D_Rbtn;
    protected ButtonGroup optionButtonGroup;
    protected Color l_txtColor, l_darkBgColor, l_lightBgColor, l_labelColor;
    protected Color d_txtColor, d_darkBgColor, d_lightBgColor, d_labelColor;
    protected JButton startButton, finishButton, themeButton, previousButton, nextButton, clearAnsButton;
    protected Font aFont = new Font("", Font.CENTER_BASELINE, 18);
    protected Font fFont = new Font("", Font.CENTER_BASELINE, 28);
    protected Font bFont = new Font("", Font.CENTER_BASELINE, 21);
    protected int queCount = 0, themeFlag = 1, AnswerTrack = 0, screenFlag = 0, frameFlag = 0;
    protected int visitFag[], totalNum, obtainNum, restulLine = 5;
    protected String impQueFlag, resultString[];

    protected String question[] = {
            "Que 1. Number of primitive data in java are : ",
            "Que 2. What is the Size of float and double ?",
            "Que 3. Automatic type conversion is possible in",
            "Que 4. When array is passed to a method, what does the method recieve ?",
            "Que 5. Arrays in Java are : "

    };
    int noOfQue = question.length, preBtnFlag = 0, submitBtnFlag = 0;

    protected String topicString = "Java Questions";

    protected String options[][] = {
            { "6", "7", "8", "9" },
            { "32 and 64", "32 and 32", "64 and 64", "64 and 32" },
            { "Byte to int", "int to long", "long to int", "short to int" },
            { "The reference of Array", "A copy of the Array", "lenght of Array", "Copy of the first element" },
            { "Object Refrence", "object", "primitive data type", "None" }
    };
    // protected String answer[] = {
    // "Salman", "Danishan1", "Salman2", "Sahil3", "Shitij4"
    // };
    protected int answer[] = {
            3, 1, 2, 1, 2
    };
    protected int getAnswer[];

    Quiz() {
        mainPanel = new JPanel();
        q_quePanel = new JPanel();
        q_optionMainPanel = new JPanel();
        q_msgPanel = new JPanel();
        q_optionPanelA = new JPanel();
        q_optionPanelB = new JPanel();
        q_optionPanelC = new JPanel();
        q_optionPanelD = new JPanel();

        s_subMainPanel = new JPanel();
        s_imgPanel = new JPanel();
        s_infoPanel = new JPanel();
        f_subMainPanel = new JPanel();
        f_resultPanel = new JPanel();

        q_queLabel = new JLabel("Yes");
        timerLabel = new JLabel("Yes");
        successfullLabel = new JLabel();
        totalQueLabel = new JLabel();
        obainNumLabel = new JLabel();
        persentageLabel = new JLabel();
        correctAnsLabel = new JLabel();

        optionButtonGroup = new ButtonGroup();
        A_Rbtn = new JRadioButton("one");
        B_Rbtn = new JRadioButton("one");
        C_Rbtn = new JRadioButton("one");
        D_Rbtn = new JRadioButton("one");
        optionButtonGroup.add(A_Rbtn);
        optionButtonGroup.add(B_Rbtn);
        optionButtonGroup.add(C_Rbtn);
        optionButtonGroup.add(D_Rbtn);

        startButton = new JButton("Start");
        finishButton = new JButton("Submit");
        themeButton = new JButton("Theme");
        previousButton = new JButton("Previous");
        nextButton = new JButton("Next");
        clearAnsButton = new JButton("Clear");

        startButton.setFocusable(false);
        themeButton.setFocusable(false);
        finishButton.setFocusable(false);
        previousButton.setFocusable(false);
        nextButton.setFocusable(false);
        clearAnsButton.setFocusable(false);

        startButton.setBorder(null);
        themeButton.setBorder(null);
        finishButton.setBorder(null);
        previousButton.setBorder(null);
        nextButton.setBorder(null);
        clearAnsButton.setBorder(null);

        startButton.addActionListener(this);
        finishButton.addActionListener(this);
        themeButton.addActionListener(this);
        previousButton.addActionListener(this);
        nextButton.addActionListener(this);
        clearAnsButton.addActionListener(this);

        A_Rbtn.addActionListener(this);
        B_Rbtn.addActionListener(this);
        C_Rbtn.addActionListener(this);
        D_Rbtn.addActionListener(this);

        l_txtColor = new Color(0x000000);
        l_darkBgColor = new Color(0xFFFAFA);
        l_lightBgColor = new Color(0xF0FFF0);
        l_labelColor = new Color(0xDCDCDC);

        d_txtColor = new Color(0xffffff);
        d_darkBgColor = new Color(0x262626);
        d_lightBgColor = new Color(0x333333);
        d_labelColor = new Color(0x404040);

        s_topicLabel = new JLabel();
        s_nameLabel = new JLabel();
        s_mobileLabel = new JLabel();
        s_passwordLabel = new JLabel();
        f_scoreLabel = new JLabel();
        f_persentageLabel = new JLabel();

        s_nameField = new JTextField();
        s_mobilField = new JTextField();
        s_passwordField = new JPasswordField();

        frame = new JFrame();

        /** main panel which is reside in all the frames */
        themeButton.setFont(aFont);

        mainPanel.setLayout(null);
        mainPanel.setBounds(0, 0, 700, 600);
        mainPanel.add(themeButton);
        themeButton.setBounds(510, 25, 150, 30);
        mainPanel.setBackground(d_darkBgColor);
        // mainPanel.setComponentZOrder(themeButton, 1);

        // lightTheme();
        darkTheme();
        isFrameVisible();
        // nextButtonFun();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Quiz Game");
        frame.setLayout(null);
        frame.setSize(715, 639);
        frame.add(mainPanel);

        frame.setVisible(true);

    }

    void isFrameVisible() {
        if (frameFlag == 0) {
            s_subMainPanel.setVisible(true);
            s_imgPanel.setVisible(true);
            s_infoPanel.setVisible(true);

            q_msgPanel.setVisible(false);
            q_optionMainPanel.setVisible(false);
            q_quePanel.setVisible(false);
            f_subMainPanel.setVisible(false);
            f_resultPanel.setVisible(false);
            startFrameFun();

        } else if (frameFlag == 1) {
            s_subMainPanel.setVisible(false);
            s_imgPanel.setVisible(false);
            s_infoPanel.setVisible(false);

            q_msgPanel.setVisible(true);
            q_optionMainPanel.setVisible(true);
            q_quePanel.setVisible(true);
            f_subMainPanel.setVisible(false);
            f_resultPanel.setVisible(false);
            QueFrameFun();

        } else if (frameFlag == 2) {
            s_subMainPanel.setVisible(false);
            s_imgPanel.setVisible(false);
            s_infoPanel.setVisible(false);

            q_msgPanel.setVisible(false);
            q_optionMainPanel.setVisible(false);
            q_quePanel.setVisible(false);
            f_subMainPanel.setVisible(true);
            f_resultPanel.setVisible(true);
            finalFrameFun();
        }
    }

    void startFrameFun() {
        s_subMainPanel.setLayout(null);
        s_imgPanel.setLayout(null);
        s_infoPanel.setLayout(null);
        mainPanel.add(s_subMainPanel);
        s_subMainPanel.add(startButton);
        s_subMainPanel.add(s_topicLabel);
        // s_subMainPanel.setBackground(Color.CYAN);

        s_subMainPanel.setBounds(100, 150, 500, 300);
        s_topicLabel.setBounds(30, 120, 400, 50);
        // s_topicLabel.setVisible(true);
        startButton.setBounds(100, 240, 300, 30);
        s_topicLabel.setText(topicString);
        s_topicLabel.setFont(new Font("", Font.CENTER_BASELINE, 51));
        startButton.setFont(aFont);
    }

    void QueFrameFun() {

        visitFag = new int[noOfQue];
        getAnswer = new int[noOfQue];
        impQueFlag = "*";

        mainPanel.add(q_quePanel);
        mainPanel.add(q_optionMainPanel);
        mainPanel.add(q_msgPanel);
        q_optionMainPanel.add(q_optionPanelA);
        q_optionMainPanel.add(q_optionPanelB);
        q_optionMainPanel.add(q_optionPanelC);
        q_optionMainPanel.add(q_optionPanelD);
        q_optionMainPanel.add(clearAnsButton);

        q_quePanel.add(q_queLabel);
        q_msgPanel.add(timerLabel);
        q_msgPanel.add(nextButton);
        q_msgPanel.add(previousButton);
        q_msgPanel.add(finishButton);
        q_quePanel.add(themeButton);

        q_optionPanelA.add(A_Rbtn);
        q_optionPanelB.add(B_Rbtn);
        q_optionPanelC.add(C_Rbtn);
        q_optionPanelD.add(D_Rbtn);

        nextButton.setFont(aFont);
        previousButton.setFont(aFont);
        finishButton.setFont(aFont);
        clearAnsButton.setFont(aFont);
        previousButton.setVisible(false);
        finishButton.setVisible(false);

        mainPanel.setLayout(null);
        q_quePanel.setLayout(null);
        q_optionMainPanel.setLayout(null);
        q_msgPanel.setLayout(null);
        q_optionPanelA.setLayout(null);
        q_optionPanelB.setLayout(null);
        q_optionPanelC.setLayout(null);
        q_optionPanelD.setLayout(null);

        mainPanel.setBounds(0, 0, 700, 600);
        q_quePanel.setBounds(10, 10, 680, 100);
        q_optionMainPanel.setBounds(10, 120, 680, 350);
        clearAnsButton.setBounds(500, 20, 150, 30);
        q_optionPanelA.setBounds(30, 60, 620, 50);
        q_optionPanelB.setBounds(30, 120, 620, 50);
        q_optionPanelC.setBounds(30, 180, 620, 50);
        q_optionPanelD.setBounds(30, 240, 620, 50);
        q_msgPanel.setBounds(10, 480, 680, 100);

        themeButton.setBounds(520, 10, 150, 30);
        nextButton.setBounds(520, 20, 150, 30);
        finishButton.setBounds(520, 20, 150, 30);
        previousButton.setBounds(350, 20, 150, 30);

        q_queLabel.setFont(aFont);
        A_Rbtn.setFont(aFont);
        B_Rbtn.setFont(aFont);
        C_Rbtn.setFont(aFont);
        D_Rbtn.setFont(aFont);

        showQueFun();

        A_Rbtn.setBounds(5, 5, 650, 40);
        B_Rbtn.setBounds(5, 5, 650, 40);
        C_Rbtn.setBounds(5, 5, 650, 40);
        D_Rbtn.setBounds(5, 5, 650, 40);
        q_queLabel.setBounds(10, 20, 660, 60);

        A_Rbtn.setFocusable(false);
        B_Rbtn.setFocusable(false);
        C_Rbtn.setFocusable(false);
        D_Rbtn.setFocusable(false);
        // RbtnComboBox.setFocusable(false);
        // A_Rbtn.setBackground(null);

    }

    void finalFrameFun() {

        mainPanel.add(f_subMainPanel);
        f_subMainPanel.add(f_resultPanel);
        f_resultPanel.add(f_scoreLabel);
        f_resultPanel.add(f_persentageLabel);

        f_subMainPanel.setBounds(30, 30, 640, 540);
        f_resultPanel.setBounds(60, 150, 520, 240);
        f_scoreLabel.setBounds(20, 20, 480, 100);
        f_persentageLabel.setBounds(20, 140, 480, 100);
        f_subMainPanel.setLayout(null);
        f_resultPanel.setLayout(null);
        f_persentageLabel.setFont(fFont);
        f_scoreLabel.setFont(fFont);

        f_subMainPanel.add(themeButton);
        themeButton.setVisible(true);
        themeButton.setBounds(470, 20, 150, 30);

    }

    void darkTheme() {
        mainPanel.setBackground(d_darkBgColor);
        q_quePanel.setBackground(d_lightBgColor);
        q_queLabel.setForeground(d_txtColor);
        q_optionMainPanel.setBackground(d_lightBgColor);
        q_optionPanelA.setBackground(d_labelColor);
        q_optionPanelB.setBackground(d_labelColor);
        q_optionPanelC.setBackground(d_labelColor);
        q_optionPanelD.setBackground(d_labelColor);
        s_subMainPanel.setBackground(d_lightBgColor);
        s_infoPanel.setBackground(d_lightBgColor);
        s_imgPanel.setBackground(d_lightBgColor);
        f_resultPanel.setBackground(d_lightBgColor);
        clearAnsButton.setBackground(d_labelColor);
        nextButton.setBackground(d_labelColor);
        startButton.setBackground(d_labelColor);
        previousButton.setBackground(d_labelColor);
        finishButton.setBackground(d_labelColor);
        q_msgPanel.setBackground(d_lightBgColor);
        f_subMainPanel.setBackground(d_lightBgColor);
        f_resultPanel.setBackground(d_labelColor);
        nextButton.setForeground(d_txtColor);
        themeButton.setBackground(d_labelColor);
        themeButton.setForeground(d_txtColor);
        clearAnsButton.setForeground(d_txtColor);
        startButton.setForeground(d_txtColor);
        previousButton.setForeground(d_txtColor);
        finishButton.setForeground(d_txtColor);
        f_resultPanel.setForeground(d_txtColor);
        f_scoreLabel.setForeground(d_txtColor);
        f_persentageLabel.setForeground(d_txtColor);
        successfullLabel.setForeground(d_txtColor);
        totalQueLabel.setForeground(d_txtColor);
        obainNumLabel.setForeground(d_txtColor);
        persentageLabel.setForeground(d_txtColor);
        correctAnsLabel.setForeground(d_txtColor);
        s_topicLabel.setForeground(d_txtColor);

        A_Rbtn.setForeground(d_txtColor);
        B_Rbtn.setForeground(d_txtColor);
        C_Rbtn.setForeground(d_txtColor);
        D_Rbtn.setForeground(d_txtColor);

        A_Rbtn.setBackground(null);
        B_Rbtn.setBackground(null);
        C_Rbtn.setBackground(null);
        D_Rbtn.setBackground(null);
    }

    void lightTheme() {
        mainPanel.setBackground(l_darkBgColor);
        q_quePanel.setBackground(l_lightBgColor);
        q_queLabel.setForeground(l_txtColor);
        q_optionMainPanel.setBackground(l_lightBgColor);
        q_optionPanelA.setBackground(l_labelColor);
        q_optionPanelB.setBackground(l_labelColor);
        q_optionPanelC.setBackground(l_labelColor);
        q_optionPanelD.setBackground(l_labelColor);
        s_subMainPanel.setBackground(l_lightBgColor);
        s_infoPanel.setBackground(l_lightBgColor);
        s_imgPanel.setBackground(l_lightBgColor);
        f_resultPanel.setBackground(l_labelColor);
        f_subMainPanel.setBackground(l_lightBgColor);
        clearAnsButton.setBackground(l_labelColor);
        nextButton.setBackground(l_labelColor);
        startButton.setBackground(l_labelColor);
        previousButton.setBackground(l_labelColor);
        finishButton.setBackground(l_labelColor);
        q_msgPanel.setBackground(l_lightBgColor);
        themeButton.setBackground(l_labelColor);
        themeButton.setForeground(l_txtColor);
        nextButton.setForeground(l_txtColor);
        clearAnsButton.setForeground(l_txtColor);
        startButton.setForeground(l_txtColor);
        previousButton.setForeground(l_txtColor);
        finishButton.setForeground(l_txtColor);
        f_resultPanel.setForeground(l_txtColor);
        f_scoreLabel.setForeground(l_txtColor);
        f_persentageLabel.setForeground(l_txtColor);
        successfullLabel.setForeground(l_txtColor);
        totalQueLabel.setForeground(l_txtColor);
        obainNumLabel.setForeground(l_txtColor);
        persentageLabel.setForeground(l_txtColor);
        correctAnsLabel.setForeground(l_txtColor);
        s_topicLabel.setForeground(l_txtColor);

        A_Rbtn.setForeground(l_txtColor);
        B_Rbtn.setForeground(l_txtColor);
        C_Rbtn.setForeground(l_txtColor);
        D_Rbtn.setForeground(l_txtColor);

        A_Rbtn.setBackground(null);
        B_Rbtn.setBackground(null);
        C_Rbtn.setBackground(null);
        D_Rbtn.setBackground(null);

    }

    void showQueFun() {

        q_queLabel.setText(question[queCount]);

        if (visitFag[queCount] == 0) {
            visitFag[queCount] = 1;
            optionButtonGroup.clearSelection();
        } else {
            int i = getAnswer[queCount];
            switch (i) {
                case 0:
                    optionButtonGroup.clearSelection();
                    break;
                case 1:
                    A_Rbtn.setSelected(true);
                    break;
                case 2:
                    B_Rbtn.setSelected(true);
                    break;
                case 3:
                    C_Rbtn.setSelected(true);
                    break;
                case 4:
                    D_Rbtn.setSelected(true);
                    break;
            }

        }
        A_Rbtn.setText(options[queCount][0]);
        B_Rbtn.setText(options[queCount][1]);
        C_Rbtn.setText(options[queCount][2]);
        D_Rbtn.setText(options[queCount][3]);

    }

    void resultFun() {
        resultString = new String[5];
        int correctAns = 0;

        for (int i = 0; i < noOfQue; i++) {
            if (answer[i] == getAnswer[i]) {
                correctAns++;
            }
        }
        f_resultPanel.add(successfullLabel);
        f_resultPanel.add(totalQueLabel);
        f_resultPanel.add(obainNumLabel);
        f_resultPanel.add(persentageLabel);
        f_resultPanel.add(correctAnsLabel);

        successfullLabel.setBounds(190, 20, 480, 30);
        totalQueLabel.setBounds(20, 60, 480, 30);
        correctAnsLabel.setBounds(20, 90, 480, 30);
        obainNumLabel.setBounds(20, 120, 480, 30);
        persentageLabel.setBounds(20, 150, 480, 30);

        successfullLabel.setFont(bFont);
        totalQueLabel.setFont(bFont);
        correctAnsLabel.setFont(bFont);
        obainNumLabel.setFont(bFont);
        persentageLabel.setFont(bFont);

        totalNum = 4 * noOfQue;
        obtainNum = 4 * correctAns;
        double ans = ((obtainNum * 100 / totalNum));
        resultString[0] = "Successfully Submitted !";
        resultString[1] = "Total number of Question : " + noOfQue;
        resultString[2] = "Total Number of Correct answer : " + correctAns;
        resultString[3] = "You got " + obtainNum + " out of " + totalNum;
        resultString[4] = "Your Percentage : " + ans;

        successfullLabel.setText(resultString[0]);
        totalQueLabel.setText(resultString[1]);
        correctAnsLabel.setText(resultString[2]);
        obainNumLabel.setText(resultString[3]);
        persentageLabel.setText(resultString[4]);
    }

    void nextButtonFun() {

        if (queCount == 0) {
            previousButton.setVisible(true);
        }
        if (queCount < noOfQue) {
            queCount++;
            showQueFun();

        }
        if (queCount == noOfQue - 1) {
            nextButton.setVisible(false);
            finishButton.setVisible(true);

        }
    }

    void previousButtonFun() {
        if (queCount == 1) {
            previousButton.setVisible(false);
        }
        if (queCount != 0) {
            queCount--;
            showQueFun();
        } else {
            previousButton.setVisible(false);
        }
        if (queCount != noOfQue - 1) {
            nextButton.setVisible(true);
            finishButton.setVisible(false);

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            frameFlag++;
            isFrameVisible();

        } else if (e.getSource() == finishButton) {
            frameFlag++;
            isFrameVisible();
            resultFun();

        } else if (e.getSource() == nextButton) {
            nextButtonFun();

        } else if (e.getSource() == clearAnsButton) {
            optionButtonGroup.clearSelection();

        } else if (e.getSource() == previousButton) {
            previousButtonFun();

        } else if (e.getSource() == themeButton) {
            if (themeFlag == 1) {
                themeFlag = 0;
                darkTheme();

            } else {
                themeFlag = 1;
                lightTheme();
            }

        }

        if (e.getSource() == A_Rbtn) {
            getAnswer[queCount] = 1;

        }
        if (e.getSource() == B_Rbtn) {
            getAnswer[queCount] = 2;
        }
        if (e.getSource() == C_Rbtn) {
            getAnswer[queCount] = 3;
        }
        if (e.getSource() == D_Rbtn) {
            getAnswer[queCount] = 4;
        }

    }
}
