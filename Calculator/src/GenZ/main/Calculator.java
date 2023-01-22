package GenZ.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.TimerTask;
import java.util.Timer;

public class Calculator implements ActionListener, MouseListener, KeyListener {

    // declaring all Global variables

    private Color d_darkBgColor, d_lightBgColor, d_btnColor, d_txtColor, d_lableColor; // dark Theame
    private Color l_darkBgColor, l_lightBgColor, l_btnColor, l_txtColor, l_lableColor; // light theame
    private Color l_btnHowerColor, l_btnClickedColor, d_btnHowerColor, d_btnClickedColor; // light theame
    private Color l_finalAnsColor, d_finalAnsColor;
    private Font ralewayFont = new Font("Raleway", Font.CENTER_BASELINE, 13);
    private Font ralewayFont15 = new Font("Raleway", Font.CENTER_BASELINE, 15);
    private Font ralewayFont20 = new Font("Raleway", Font.CENTER_BASELINE, 20);
    private Font ralewayFont25 = new Font("Raleway", Font.CENTER_BASELINE, 25);

    private int btnHeight = 50, btnLenght = 100, btnGapHeight = 30, btnGapLenght = 55;
    private int lenghtCount = 0, heightCount = 0, divideOccurFlag = 0;
    private int TotalButton = 20, zeroRemovalFlag = -1, pointCheckFlag = -1, themeChangeFlag = 1, moreLessFlag = 0;
    private int moreBtnFlag = 0, lcmbtnFlag = 0, hcfbtnFlag = 0, commaFlag = 0;

    private JFrame frame;
    private JLayeredPane calculatorPane;
    private JTextField dataTextField;
    private JLabel msgLabel, teamNameLabel, firstScreenLabel;
    private JPanel mainPanel, disButPanel, displayPanel, buttonPanel, msgPanel, iconPanel;
    private JPanel firstScreenPanel, hcfSubPanel;
    private JButton themeButton, lcmButton, hcfButton, comaButton, enter1Button;
    private JButton button[];

    Calculator() {

        // intansiating all possible elements
        button = new JButton[TotalButton];

        // Dark Theme Colors
        d_darkBgColor = new Color(0x262626);
        d_lightBgColor = new Color(0x333333);
        d_btnColor = new Color(0x404040);
        d_txtColor = new Color(0xffffff);
        d_lableColor = new Color(0x404040);
        d_btnHowerColor = new Color(0x8c8c8c);
        d_btnClickedColor = new Color(0xB0E0E6);

        // Light Theme Colors
        l_darkBgColor = new Color(0xf5f5f5); // whiteSmoke
        l_lightBgColor = new Color(0xf0fff0); // heneyDew
        l_btnColor = new Color(0xffffff); // lightSteel
        l_txtColor = new Color(0x000000); // black
        l_lableColor = new Color(0xfff5ee); // seaShell
        l_btnHowerColor = new Color(0xe5e5e5); // sea Color
        l_btnClickedColor = new Color(0xE7AA9D); // floral white
        l_finalAnsColor = new Color(0x336666);

        // initlzing frame, Lables and panels
        frame = new JFrame("Calculator");
        calculatorPane = new JLayeredPane();
        dataTextField = new JTextField("0");
        msgLabel = new JLabel("0");

        mainPanel = new JPanel();
        disButPanel = new JPanel();
        displayPanel = new JPanel();
        buttonPanel = new JPanel();
        msgPanel = new JPanel();
        iconPanel = new JPanel();
        firstScreenPanel = new JPanel();
        hcfSubPanel = new JPanel();

        // iniitilizing buttons
        button[0] = new JButton(); // zero
        button[1] = new JButton(); // one
        button[2] = new JButton(); // two
        button[3] = new JButton(); // three
        button[4] = new JButton(); // four
        button[5] = new JButton(); // five
        button[6] = new JButton(); // Six
        button[7] = new JButton(); // Seven
        button[8] = new JButton(); // Eight
        button[9] = new JButton(); // Nine
        button[10] = new JButton(); // +
        button[11] = new JButton(); // -
        button[12] = new JButton(); // *
        button[13] = new JButton(); // /
        button[14] = new JButton(); // .
        button[15] = new JButton(); // Enter
        button[16] = new JButton(); // +/-
        button[17] = new JButton(); // BackSpace
        button[18] = new JButton(); // Clear
        button[19] = new JButton(); // more
        themeButton = new JButton("Theme");
        lcmButton = new JButton("L.C.M");
        hcfButton = new JButton("H.C.F");
        comaButton = new JButton(" , ");
        enter1Button = new JButton("=");

        /** Adding Calculator panels */
        calculatorPane.add(mainPanel); // main panel for all other panel
        mainPanel.add(iconPanel); // panel for all other container
        mainPanel.add(disButPanel);
        disButPanel.add(displayPanel);
        disButPanel.add(buttonPanel);
        displayPanel.add(msgPanel);
        msgPanel.add(msgLabel);

        /** set Calculator panels location and size */
        calculatorPane.setBounds(0, 0, 600, 600);
        mainPanel.setBounds(0, 0, 600, 600);
        iconPanel.setBounds(30, 10, 540, 40);
        disButPanel.setBounds(20, 50, 560, 510);
        displayPanel.setBounds(10, 10, 540, 100);
        msgPanel.setBounds(10, 65, 520, 25);
        buttonPanel.setBounds(10, 120, 540, 420);

        /** Giving Layout to ous panels */
        firstScreenPanel.setLayout(null);
        calculatorPane.setLayout(null);
        mainPanel.setLayout(null);
        disButPanel.setLayout(null);
        displayPanel.setLayout(null);
        buttonPanel.setLayout(null);
        iconPanel.setLayout(null);

        /** Icon panel */
        iconPanel.setBackground(l_lightBgColor);
        teamNameLabel = new JLabel("Gen-Z");
        iconPanel.add(teamNameLabel);
        iconPanel.add(themeButton);
        teamNameLabel.setBounds(250, 5, 150, 30);
        teamNameLabel.setFont(ralewayFont15);

        themeButton.setBounds(5, 5, 70, 30);
        themeButton.addActionListener(this);
        themeButton.setFont(ralewayFont15);
        themeButton.setBorder(null);
        themeButton.setFocusable(false);

        /** Answer or msg Panel */
        msgPanel.setVisible(true);
        msgLabel.setFont(ralewayFont);

        /** Text Field */
        displayPanel.add(dataTextField);
        dataTextField.setBounds(10, 10, 520, 45);
        dataTextField.setFont(ralewayFont25);
        dataTextField.setBorder(null);
        dataTextField.setForeground(l_txtColor);
        dataTextField.setBackground(l_lightBgColor);

        /** Giving Default Layout to buttons and assigning location and size */
        button[19] = defaultButtonfun(button[19]);
        button[18] = defaultButtonfun(button[18]);
        button[17] = defaultButtonfun(button[17]);
        button[13] = defaultButtonfun(button[13]);
        button[7] = defaultButtonfun(button[7]);
        button[8] = defaultButtonfun(button[8]);
        button[9] = defaultButtonfun(button[9]);
        button[12] = defaultButtonfun(button[12]);
        button[4] = defaultButtonfun(button[4]);
        button[5] = defaultButtonfun(button[5]);
        button[6] = defaultButtonfun(button[6]);
        button[11] = defaultButtonfun(button[11]);
        button[1] = defaultButtonfun(button[1]);
        button[2] = defaultButtonfun(button[2]);
        button[3] = defaultButtonfun(button[3]);
        button[10] = defaultButtonfun(button[10]);
        button[16] = defaultButtonfun(button[16]);
        button[0] = defaultButtonfun(button[0]);
        button[14] = defaultButtonfun(button[14]);
        button[15] = defaultButtonfun(button[15]);

        /** Adding keyListener to TextBox */
        // dataTextField.addKeyListener(this);

        /** appling Action listener to buttons */
        button[1].addActionListener(this);
        button[2].addActionListener(this);
        button[3].addActionListener(this);
        button[10].addActionListener(this);
        button[4].addActionListener(this);
        button[5].addActionListener(this);
        button[6].addActionListener(this);
        button[11].addActionListener(this);
        button[7].addActionListener(this);
        button[8].addActionListener(this);
        button[9].addActionListener(this);
        button[12].addActionListener(this);
        button[15].addActionListener(this);
        button[0].addActionListener(this);
        button[14].addActionListener(this);
        button[13].addActionListener(this);
        button[16].addActionListener(this);
        button[17].addActionListener(this);
        button[18].addActionListener(this);
        button[19].addActionListener(this);

        /** Adding Mouse Listener */
        button[1].addMouseListener(this);
        button[2].addMouseListener(this);
        button[3].addMouseListener(this);
        button[10].addMouseListener(this);
        button[4].addMouseListener(this);
        button[5].addMouseListener(this);
        button[6].addMouseListener(this);
        button[11].addMouseListener(this);
        button[7].addMouseListener(this);
        button[8].addMouseListener(this);
        button[9].addMouseListener(this);
        button[12].addMouseListener(this);
        button[15].addMouseListener(this);
        button[0].addMouseListener(this);
        button[14].addMouseListener(this);
        button[13].addMouseListener(this);
        button[16].addMouseListener(this);
        button[17].addMouseListener(this);
        button[18].addMouseListener(this);
        button[19].addMouseListener(this);

        /** adding button to Panel */
        buttonPanel.add(button[1]);
        buttonPanel.add(button[2]);
        buttonPanel.add(button[3]);
        buttonPanel.add(button[10]);
        buttonPanel.add(button[4]);
        buttonPanel.add(button[5]);
        buttonPanel.add(button[6]);
        buttonPanel.add(button[11]);
        buttonPanel.add(button[7]);
        buttonPanel.add(button[8]);
        buttonPanel.add(button[9]);
        buttonPanel.add(button[12]);
        buttonPanel.add(button[15]);
        buttonPanel.add(button[0]);
        buttonPanel.add(button[14]);
        buttonPanel.add(button[13]);
        buttonPanel.add(button[16]);
        buttonPanel.add(button[17]);
        buttonPanel.add(button[18]);
        buttonPanel.add(button[19]);

        /** Setting Text to all the Button */
        button[1].setText("1");
        button[2].setText("2");
        button[3].setText("3");
        button[10].setText("+");
        button[4].setText("4");
        button[5].setText("5");
        button[6].setText("6");
        button[11].setText("-");
        button[7].setText("7");
        button[8].setText("8");
        button[9].setText("9");
        button[12].setText("X");
        button[15].setText("=");
        button[0].setText("0");
        button[14].setText(".");
        button[13].setText("/");
        button[16].setText("+/-");
        button[17].setText("BS");
        button[18].setText("C");
        button[19].setText("More");

        /** first Screen Panel */
        calculatorPane.add(firstScreenPanel);
        firstScreenPanel.setBounds(0, 0, 600, 600);
        firstScreenPanel.setBackground(Color.red);
        firstScreenLabel = new JLabel("Gen-Z");
        firstScreenPanel.add(firstScreenLabel);
        firstScreenLabel.setFont(ralewayFont20);
        firstScreenLabel.setBounds(265, 255, 150, 30);
        mainPanel.setVisible(false);
        firstScreenPanel.setVisible(true);

        // Timer timer = new Timer(TotalButton, null);
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {

            @Override
            public void run() {
                mainPanel.setVisible(true);
                firstScreenPanel.setVisible(false);

            }

        };
        timer.schedule(task, 3000);

        /** Setting Color to Enter Button */
        button[15].setBackground(d_darkBgColor); // enter btn
        button[15].setForeground(d_txtColor);
        themeChangeFun();

        /** Default Frame Layout */
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(150, 50, 616, 639);
        frame.add(calculatorPane);
        frame.addKeyListener(this);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);

    }

    /** Function to give Default values to buttons */
    private JButton defaultButtonfun(JButton B) {

        B.setBounds(btnGapLenght, btnGapHeight, btnLenght, btnHeight);
        btnGapLenght = btnGapLenght + btnLenght + 10;
        lenghtCount++;
        B.setFocusable(false);
        if (lenghtCount == 4) {
            btnGapHeight = btnGapHeight + btnHeight + 10;
            btnGapLenght = 55;
            lenghtCount = 0;
        }
        B.setBackground(l_btnColor); // all btn Background
        B.setForeground(l_txtColor);// all btn foreground
        B.setBorder(null);
        B.setFont(ralewayFont20);

        return B;
    }

    /** Verify on which Buttons does the mouse enter */
    int verifyButtensMouseFun(MouseEvent e) {
        int j = -1;
        if (e.getSource() == button[1]) {
            j = 1;
        } else if (e.getSource() == button[2]) {
            j = 2;
        } else if (e.getSource() == button[3]) {
            j = 3;
        } else if (e.getSource() == button[10]) {
            j = 10;
        } else if (e.getSource() == button[4]) {
            j = 4;
        } else if (e.getSource() == button[5]) {
            j = 5;
        } else if (e.getSource() == button[6]) {
            j = 6;
        } else if (e.getSource() == button[11]) {
            j = 11;
        } else if (e.getSource() == button[7]) {
            j = 7;
        } else if (e.getSource() == button[8]) {
            j = 8;
        } else if (e.getSource() == button[9]) {
            j = 9;
        } else if (e.getSource() == button[12]) {
            j = 12;
        } else if (e.getSource() == button[15]) {
            j = 15;
        } else if (e.getSource() == button[0]) {
            j = 0;
        } else if (e.getSource() == button[14]) {
            j = 14;
        } else if (e.getSource() == button[13]) {
            j = 13;
        } else if (e.getSource() == button[16]) {
            j = 16;
        } else if (e.getSource() == button[17]) {
            j = 17;
        } else if (e.getSource() == button[18]) {
            j = 18;
        } else if (e.getSource() == button[19]) {
            j = 19;
        }

        return j;
    }

    /** Verify on which Buttons does the mouse Clicked */
    int verifyButtensActionFun(ActionEvent e) {
        int j = -1;

        if (e.getSource() == button[1]) {
            j = 1;
        } else if (e.getSource() == button[2]) {
            j = 2;
        } else if (e.getSource() == button[3]) {
            j = 3;
        } else if (e.getSource() == button[10]) {
            j = 10;
        } else if (e.getSource() == button[4]) {
            j = 4;
        } else if (e.getSource() == button[5]) {
            j = 5;
        } else if (e.getSource() == button[6]) {
            j = 6;
        } else if (e.getSource() == button[11]) {
            j = 11;
        } else if (e.getSource() == button[7]) {
            j = 7;
        } else if (e.getSource() == button[8]) {
            j = 8;
        } else if (e.getSource() == button[9]) {
            j = 9;
        } else if (e.getSource() == button[12]) {
            j = 12;
        } else if (e.getSource() == button[15]) {
            j = 15;
        } else if (e.getSource() == button[0]) {
            j = 0;
        } else if (e.getSource() == button[14]) {
            j = 14;
        } else if (e.getSource() == button[13]) {
            j = 13;
        } else if (e.getSource() == button[16]) {
            j = 16;
        } else if (e.getSource() == button[17]) {
            j = 17;
        } else if (e.getSource() == button[18]) {
            j = 18;
        } else if (e.getSource() == button[19]) {
            j = 19;
        }

        return j;
    }

    /** to verify key Enetr and update that to the TexBox */
    void KeyEnterFun(char TypedChar) {
        String presentText = dataTextField.getText();
        // char TypedChar = e.getKeyChar(); // 8 BS 127 Delete

        if (zeroRemovalFlag == -1) {
            if (TypedChar == '0') {
                presentText = "" + TypedChar;
                dataTextField.setText(presentText);
                zeroRemovalFlag++;
            } else if (TypedChar == '.') {
                presentText = dataTextField.getText();
                presentText = presentText.substring(0, presentText.length() - 1);
                presentText = "0" + TypedChar;
                dataTextField.setText(presentText);
                zeroRemovalFlag++;
                pointCheckFlag = 0;

            } else {
                presentText = "" + TypedChar;
                dataTextField.setText(presentText);
                zeroRemovalFlag = 0;
            }
        } else {
            if (TypedChar == '+') {
                OperatorAddingFun(10, presentText);
            } else if (TypedChar == '-') {
                OperatorAddingFun(11, presentText);
            } else if (TypedChar == '*') {
                OperatorAddingFun(12, presentText);
            } else if (TypedChar == '/') {
                OperatorAddingFun(13, presentText);
            } else if (TypedChar == '.') {
                pointEnterFun();

            } else {
                presentText += TypedChar;
                dataTextField.setText(presentText);
                zeroRemovalFlag = 1;
            }
        }

    }

    /** Key Light Theam */
    void KeyLightThemeFun(char TypedChar) {

        if (TypedChar == '1') {
            button[1].setBackground(l_btnClickedColor); // keytyped color
        } else if (TypedChar == '2') {
            button[2].setBackground(l_btnClickedColor);
        } else if (TypedChar == '3') {
            button[3].setBackground(l_btnClickedColor);
        } else if (TypedChar == '4') {
            button[4].setBackground(l_btnClickedColor);
        } else if (TypedChar == '5') {
            button[5].setBackground(l_btnClickedColor);
        } else if (TypedChar == '6') {
            button[6].setBackground(l_btnClickedColor);
        } else if (TypedChar == '7') {
            button[7].setBackground(l_btnClickedColor);
        } else if (TypedChar == '8') {
            button[8].setBackground(l_btnClickedColor);
        } else if (TypedChar == '9') {
            button[9].setBackground(l_btnClickedColor);
        } else if (TypedChar == '0') {
            button[0].setBackground(l_btnClickedColor);
        } else if (TypedChar == '+') {
            pointCheckFlag = -1;
            button[10].setBackground(l_btnClickedColor);
        } else if (TypedChar == '-') {
            pointCheckFlag = -1;
            button[11].setBackground(l_btnClickedColor);
        } else if (TypedChar == '*') {
            pointCheckFlag = -1;
            button[12].setBackground(l_btnClickedColor);
        } else if (TypedChar == '/') {
            pointCheckFlag = -1;
            button[13].setBackground(l_btnClickedColor);
        } else if (TypedChar == '.') {
            button[14].setBackground(l_btnClickedColor);
        }
    }

    /** Key Light Theme */
    void KeyDarkThemeFun(char TypedChar) {

        if (TypedChar == '1') {
            button[1].setBackground(d_btnHowerColor); // keytyped color
        } else if (TypedChar == '2') {
            button[2].setBackground(d_btnHowerColor);
        } else if (TypedChar == '3') {
            button[3].setBackground(d_btnHowerColor);
        } else if (TypedChar == '4') {
            button[4].setBackground(d_btnHowerColor);
        } else if (TypedChar == '5') {
            button[5].setBackground(d_btnHowerColor);
        } else if (TypedChar == '6') {
            button[6].setBackground(d_btnHowerColor);
        } else if (TypedChar == '7') {
            button[7].setBackground(d_btnHowerColor);
        } else if (TypedChar == '8') {
            button[8].setBackground(d_btnHowerColor);
        } else if (TypedChar == '9') {
            button[9].setBackground(d_btnHowerColor);
        } else if (TypedChar == '0') {
            button[0].setBackground(d_btnHowerColor);
        } else if (TypedChar == '+') {
            pointCheckFlag = -1;
            button[10].setBackground(d_btnHowerColor);
        } else if (TypedChar == '-') {
            pointCheckFlag = -1;
            button[11].setBackground(d_btnHowerColor);
        } else if (TypedChar == '*') {
            pointCheckFlag = -1;
            button[12].setBackground(d_btnHowerColor);
        } else if (TypedChar == '/') {
            pointCheckFlag = -1;
            button[13].setBackground(d_btnHowerColor);
        } else if (TypedChar == '.') {
            button[14].setBackground(d_btnHowerColor);
        }
    }

    /** Back to normal Sttings after exit the Key */
    void KeyExitLightFun(KeyEvent e) {
        char TypedChar = e.getKeyChar(); // 8 BS 127 Delete

        if (TypedChar == '1') {
            button[1].setBackground(l_btnColor); // key exit
        } else if (TypedChar == '2') {
            button[2].setBackground(l_btnColor);
        } else if (TypedChar == '3') {
            button[3].setBackground(l_btnColor);
        } else if (TypedChar == '4') {
            button[4].setBackground(l_btnColor);
        } else if (TypedChar == '5') {
            button[5].setBackground(l_btnColor);
        } else if (TypedChar == '6') {
            button[6].setBackground(l_btnColor);
        } else if (TypedChar == '7') {
            button[7].setBackground(l_btnColor);
        } else if (TypedChar == '8') {
            button[8].setBackground(l_btnColor);
        } else if (TypedChar == '9') {
            button[9].setBackground(l_btnColor);
        } else if (TypedChar == '0') {
            button[0].setBackground(l_btnColor);
        } else if (TypedChar == '+') {
            button[10].setBackground(l_btnColor);
        } else if (TypedChar == '-') {
            button[11].setBackground(l_btnColor);
        } else if (TypedChar == '*') {
            button[12].setBackground(l_btnColor);
        } else if (TypedChar == '/') {
            button[13].setBackground(l_btnColor);
        } else if (TypedChar == '.') { // code for enter 0 backspace 8
            button[14].setBackground(l_btnColor);

            // } else if (e.getKeyCode() == 8) { // charcode for backspace
            // button[17].setBackground(l_btnColor);
            // // bS_BtnFun();
        }
    }

    /** Back to normal Sttings after exit the Key */
    void KeyExitDarkFun(KeyEvent e) {
        char TypedChar = e.getKeyChar(); // 8 BS 127 Delete

        if (TypedChar == '1') {
            button[1].setBackground(d_btnColor); // key exit
        } else if (TypedChar == '2') {
            button[2].setBackground(d_btnColor);
        } else if (TypedChar == '3') {
            button[3].setBackground(d_btnColor);
        } else if (TypedChar == '4') {
            button[4].setBackground(d_btnColor);
        } else if (TypedChar == '5') {
            button[5].setBackground(d_btnColor);
        } else if (TypedChar == '6') {
            button[6].setBackground(d_btnColor);
        } else if (TypedChar == '7') {
            button[7].setBackground(d_btnColor);
        } else if (TypedChar == '8') {
            button[8].setBackground(d_btnColor);
        } else if (TypedChar == '9') {
            button[9].setBackground(d_btnColor);
        } else if (TypedChar == '0') {
            button[0].setBackground(d_btnColor);
        } else if (TypedChar == '+') {
            button[10].setBackground(d_btnColor);
        } else if (TypedChar == '-') {
            button[11].setBackground(d_btnColor);
        } else if (TypedChar == '*') {
            button[12].setBackground(d_btnColor);
        } else if (TypedChar == '/') {
            button[13].setBackground(d_btnColor);
        } else if (TypedChar == '.') { // code for enter 0 backspace 8
            button[14].setBackground(d_btnColor);

            // } else if (e.getKeyCode() == 8) { // charcode for backspace
            // button[17].setBackground(l_btnColor);
            // // bS_BtnFun();
        }
    }

    /** Verifing is valid Key Enter by user or Not */
    boolean isValidKeyEnter(char C) {
        boolean i = false;
        if (C == '+' || C == '-' || C == '*' || C == '/' ||
                C == '0' || C == '1' || C == '2' || C == '3' ||
                C == '4' || C == '5' || C == '6' || C == '7' ||
                C == '8' || C == '9' || C == '.') {
            i = true;
        }

        return i;
    }

    /** Point Enter Funtion */
    void pointEnterFun() {
        String presentText = dataTextField.getText();
        if (pointCheckFlag == -1) {
            if (presentText.length() == 0) {
                presentText += "0.";
                pointCheckFlag++;

            } else {
                char c = presentText.charAt(presentText.length() - 1);
                if (c == '+' || c == '-' || c == 'x' || c == '/') {
                    presentText += "0.";
                } else
                    presentText += ".";
                pointCheckFlag++;
            }
        }
        dataTextField.setText(presentText);
    }

    /** Adding Operatos Values to the text Fiels */
    void OperatorAddingFun(int i, String presentText) {
        char c = presentText.charAt(presentText.length() - 1);
        if (c != '+' && c != '-' && c != 'x' && c != '/') {
            pointCheckFlag = -1;
            switch (i) {
                case 10:
                    presentText += "+";
                    dataTextField.setText(presentText);
                    break;
                case 11:
                    presentText += "-";
                    dataTextField.setText(presentText);
                    break;
                case 12:
                    presentText += "x";
                    dataTextField.setText(presentText);
                    break;
                case 13:
                    presentText += "/";
                    dataTextField.setText(presentText);
                    divideOccurFlag = 2;
                    break;
            }
        }

    }

    /** To Change the Theme */
    void themeChangeFun() {
        if (themeChangeFlag == 0) {
            darkTheame();
            themeChangeFlag = 1;
        } else {
            LightTheme();
            themeChangeFlag = 0;
        }
    }

    /** Theme Changer Light Theme */
    void LightTheme() {
        int i = 0;

        for (i = 0; i < TotalButton; i++)
            button[i].setForeground(l_txtColor); // All btn normal color
        button[15].setForeground(d_txtColor); // Enter Btn
        themeButton.setText("Dark");

        msgLabel.setForeground(d_darkBgColor); // msgLable
        dataTextField.setForeground(l_txtColor); // text Field
        mainPanel.setBackground(l_darkBgColor);
        disButPanel.setBackground(l_darkBgColor);
        teamNameLabel.setForeground(l_txtColor);
        firstScreenLabel.setForeground(l_txtColor);

        firstScreenPanel.setBackground(l_lightBgColor);
        hcfSubPanel.setBackground(l_lightBgColor);

        lcmButton.setBackground(l_btnColor);
        hcfButton.setBackground(l_btnColor);
        comaButton.setBackground(l_btnColor);
        lcmButton.setForeground(l_txtColor);
        hcfButton.setForeground(l_txtColor);
        comaButton.setForeground(l_txtColor);

        displayPanel.setBackground(l_lightBgColor);
        buttonPanel.setBackground(l_lightBgColor);
        dataTextField.setBackground(l_lightBgColor);
        iconPanel.setBackground(l_lightBgColor);
        themeButton.setBackground(l_btnColor);
        themeButton.setForeground(l_txtColor);

        enter1Button.setBackground(d_darkBgColor);
        enter1Button.setForeground(d_txtColor);

        for (i = 0; i < TotalButton; i++)
            button[i].setBackground(l_btnColor); // all btn Backgroung
        button[15].setBackground(d_darkBgColor); // enter btn

        msgPanel.setBackground(l_lableColor);

        if (moreLessFlag == 1) { // for enter when disable
            button[15].setBackground(l_btnColor);
        }

    }

    /** Theme Changer Dark Theme */
    void darkTheame() {
        int i = 0;

        msgLabel.setForeground(l_darkBgColor); // msgLable
        themeButton.setText("Light");

        for (i = 0; i < TotalButton; i++)
            button[i].setForeground(d_txtColor); // All btn normal color

        button[15].setForeground(l_txtColor); // Enter Btn
        dataTextField.setForeground(d_txtColor); // text Field
        mainPanel.setBackground(d_darkBgColor);
        disButPanel.setBackground(d_darkBgColor);
        teamNameLabel.setForeground(d_txtColor);
        firstScreenLabel.setForeground(d_txtColor);
        themeButton.setBackground(d_btnColor);
        themeButton.setForeground(d_txtColor);
        lcmButton.setForeground(d_txtColor);
        hcfButton.setForeground(d_txtColor);
        comaButton.setForeground(d_txtColor);
        // enter1Button.setForeground(d_txtColor);

        enter1Button.setBackground(l_darkBgColor);
        enter1Button.setForeground(l_txtColor);

        firstScreenPanel.setBackground(d_lightBgColor);
        hcfSubPanel.setBackground(d_lightBgColor);
        lcmButton.setBackground(d_btnColor);
        hcfButton.setBackground(d_btnColor);
        comaButton.setBackground(d_btnColor);
        // enter1Button.setBackground(d_btnColor);
        displayPanel.setBackground(d_lightBgColor);
        buttonPanel.setBackground(d_lightBgColor);
        dataTextField.setBackground(d_lightBgColor);
        iconPanel.setBackground(d_lightBgColor);

        for (i = 0; i < TotalButton; i++)
            button[i].setBackground(d_btnColor); // all btn Backgroung

        button[15].setBackground(l_darkBgColor); // enter btn
        msgPanel.setBackground(d_lableColor);

        if (moreLessFlag == 1) { // for enter when disable
            button[15].setBackground(d_btnColor);
        }

    }

    /*** to Display the Answer after entering any number */
    void displayDefaulFun() {

        displayPanel.setBounds(10, 10, 540, 100);
        msgPanel.setBounds(10, 65, 520, 25);
        dataTextField.setBounds(10, 10, 520, 45);
        dataTextField.setFont(ralewayFont25);
        msgLabel.setFont(ralewayFont);

    }

    /** Funcanalities of Enter Button */
    void enterBtnFun() {

        answerStrNumFun();
        enterbtnChangeDimFun();

    }

    void enterbtnChangeDimFun() {
        msgPanel.setBounds(10, 45, 520, 45);
        dataTextField.setBounds(10, 10, 520, 35);
        dataTextField.setFont(ralewayFont);
        if (themeChangeFlag == 1) {
            msgLabel.setForeground(d_txtColor);
        } else
            msgLabel.setForeground(d_darkBgColor);

        msgLabel.setFont(ralewayFont25);

    }

    /** For converting String Value to numbers and Find the answer */
    void answerStrNumFun() {
        if (divideOccurFlag == 1) {
            msgLabel.setText("Error : Divided by Zero");
        } else {
            stringToPostFix convert = new stringToPostFix();
            String presentText1 = dataTextField.getText();
            char C = presentText1.charAt(presentText1.length() - 1);
            if (C == '+' || C == '-' || C == 'x' || C == '/') {
                presentText1 = presentText1.substring(0, presentText1.length() - 1);
            }
            if (presentText1 == "0") { // 0 is not calculated by caculator
                msgLabel.setText("0");
            } else {
                double answer = convert.convertStrIntoNum(presentText1);
                String answerStr = String.valueOf(answer);
                msgLabel.setText(answerStr);
            }
        }
    }

    /** For converting String Value to numbers and Find the answer */
    void answerStrHcfLcmFun() {
        StrToHcfLcm strToHcfLcm = new StrToHcfLcm();
        String presentText1 = dataTextField.getText();
        char C = presentText1.charAt(presentText1.length() - 1); // 5+
        if (C == ',') {
            presentText1 = presentText1.substring(0, presentText1.length() - 1);
        }
        if (presentText1 == "0") { // 0 is not calculated by caculator
            msgLabel.setText("0");
        } else {
            if (hcfbtnFlag == 1) {
                long answer = strToHcfLcm.StrToHCF_Fun(presentText1);
                if (answer == -1) {
                    msgLabel.setText("Write atleast two number (Comma Seprated)");
                } else {
                    String answerStr = "HCF : " + String.valueOf(answer);
                    msgLabel.setText(answerStr);
                }
            } else if (lcmbtnFlag == 1) {
                long answer = strToHcfLcm.StrToLCM_Fun(presentText1);
                if (answer == -1) {
                    msgLabel.setText("Write atleast two number (Comma Seprated)");
                } else {
                    String answerStr = "LCM : " + String.valueOf(answer);
                    msgLabel.setText(answerStr);
                }

            }
        }

    }

    /** Funcanalitis of BackSpace */
    void bS_BtnFun() {
        String presentText1 = dataTextField.getText();
        presentText1 = dataTextField.getText();
        int len = presentText1.length();
        char c = presentText1.charAt(len - 1);
        if (c == '+' || c == '-' || c == 'x' || c == '/') {
            pointCheckFlag = 0;
        } else if (c == '.' || c == ',') {
            pointCheckFlag = -1;
            commaFlag = 0;
        } else if (c == '/') {
            divideOccurFlag = 0;
        }
        if (len == 1) {
            presentText1 = "0";
            dataTextField.setText(presentText1);

        } else {
            presentText1 = presentText1.substring(0, len - 1);
            dataTextField.setText(presentText1);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char C = e.getKeyChar();
        displayDefaulFun();

        if (isValidKeyEnter(C) == true) {
            KeyEnterFun(C);
            if (themeChangeFlag == 1) {
                KeyDarkThemeFun(C);
            } else {
                KeyLightThemeFun(C);
            }

        } else if (e.getKeyCode() == 0) { // 0 for enter
            button[15].setBackground(l_lightBgColor); // mouse Enter to enter
            button[15].setForeground(l_txtColor);
            enterBtnFun();

            // } else if (e.getKeyCode() == 8) { // charcode for backspace
            // button[17].setBackground(l_btnClickedColor);
            // bS_BtnFun();

        } else {
            dataTextField.setEditable(false);
        }
        answerStrNumFun();

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

        if (themeChangeFlag == 1) {
            button[15].setBackground(l_darkBgColor); // enter btn
            button[15].setForeground(l_txtColor); // Enter Btn
            KeyExitDarkFun(e);
        } else {
            button[15].setForeground(d_txtColor); // Enter Btn
            button[15].setBackground(d_darkBgColor); // enter btn
            KeyExitLightFun(e);

        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (verifyButtensMouseFun(e) == 1)
            // /
            ;
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        int i = verifyButtensMouseFun(e);
        if (themeChangeFlag == 0) {
            if (i == 15) {
                button[15].setBackground(d_lightBgColor); // mouse Enter to enter
                button[15].setForeground(d_txtColor);

            } else if (i != -1) {
                button[i].setBackground(l_btnHowerColor); // mouse enetr to other btn
            }
            if (moreLessFlag == 1) {
                button[10].setBackground(l_btnColor); // if btn is Disable
                button[11].setBackground(l_btnColor); // if btn is Disable
                button[12].setBackground(l_btnColor); // if btn is Disable
                button[13].setBackground(l_btnColor); // if btn is Disable
                button[14].setBackground(l_btnColor); // if btn is Disable
                button[15].setBackground(l_btnColor); // if btn is Disable
                button[16].setBackground(l_btnColor); // if btn is Disable

            }
            if (e.getSource() == lcmButton) {
                lcmButton.setBackground(l_btnHowerColor);
            } else if (e.getSource() == hcfButton) {
                hcfButton.setBackground(l_btnHowerColor);
            } else if (e.getSource() == comaButton) {
                comaButton.setBackground(l_btnHowerColor);
            } else if (e.getSource() == enter1Button) {
                enter1Button.setBackground(d_lightBgColor);
                enter1Button.setForeground(d_txtColor);
            }
        } else {
            if (i == 15) {
                button[15].setBackground(l_lightBgColor); // mouse Enter to enter
                button[15].setForeground(l_txtColor);

            } else if (i != -1) {
                button[i].setBackground(d_btnHowerColor); // mouse enetr to other btn
            }
            if (moreLessFlag == 1) {
                button[10].setBackground(d_btnColor); // if btn is Disable
                button[11].setBackground(d_btnColor); // if btn is Disable
                button[12].setBackground(d_btnColor); // if btn is Disable
                button[13].setBackground(d_btnColor); // if btn is Disable
                button[14].setBackground(d_btnColor); // if btn is Disable
                button[15].setBackground(d_btnColor); // if btn is Disable
                button[16].setBackground(d_btnColor); // if btn is Disable

            }
            if (e.getSource() == lcmButton) {
                lcmButton.setBackground(d_btnHowerColor);
            } else if (e.getSource() == hcfButton) {
                hcfButton.setBackground(d_btnHowerColor);
            } else if (e.getSource() == comaButton) {
                comaButton.setBackground(d_btnHowerColor);
            } else if (e.getSource() == enter1Button) {
                enter1Button.setBackground(l_lightBgColor);
                enter1Button.setForeground(l_txtColor);
            }
        }

    }

    @Override
    public void mouseExited(MouseEvent e) {
        int i = verifyButtensMouseFun(e);
        if (themeChangeFlag == 0) {
            if (i == 15) {
                button[15].setBackground(d_darkBgColor); // mouse Exit to enter
                button[15].setForeground(d_txtColor);

            } else if (i != -1)
                button[i].setBackground(l_btnColor); // mouse exit to other btn
            if (e.getSource() == lcmButton) {
                lcmButton.setBackground(l_btnColor);
            } else if (e.getSource() == hcfButton) {
                hcfButton.setBackground(l_btnColor);
            } else if (e.getSource() == comaButton) {
                comaButton.setBackground(l_btnColor);
            } else if (e.getSource() == enter1Button) {
                enter1Button.setBackground(d_darkBgColor);
                enter1Button.setForeground(d_txtColor);
            }
            if (moreLessFlag == 1) {
                button[15].setBackground(l_btnColor); // mouse Exit to enter
            }
        } else {
            if (i == 15) {
                button[15].setBackground(l_darkBgColor); // mouse Exit to enter
                button[15].setForeground(l_txtColor);

            } else if (i != -1)
                button[i].setBackground(d_btnColor); // mouse exit to other btn
            if (e.getSource() == lcmButton) {
                lcmButton.setBackground(d_btnColor);
            } else if (e.getSource() == hcfButton) {
                hcfButton.setBackground(d_btnColor);
            } else if (e.getSource() == comaButton) {
                comaButton.setBackground(d_btnColor);
            } else if (e.getSource() == enter1Button) {
                enter1Button.setBackground(l_darkBgColor);
                enter1Button.setForeground(l_txtColor);
            }
            if (moreLessFlag == 1) {
                button[15].setBackground(d_btnColor); // mouse Exit to enter
            }

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == themeButton) {
            themeChangeFun();

        } else if (e.getSource() == lcmButton) {
            hcfbtnFlag = 0;
            lcmbtnFlag = 1;
            answerStrHcfLcmFun();
            // String presentText =
            // lcm.

        } else if (e.getSource() == hcfButton) {
            hcfbtnFlag = 1;
            lcmbtnFlag = 0;
            answerStrHcfLcmFun();

        } else if (e.getSource() == comaButton) {
            String presentText = dataTextField.getText();
            if (commaFlag == 0) {
                char C = presentText.charAt(presentText.length() - 1);
                if (C != ',') {
                    presentText += ",";
                    commaFlag = 1;
                }
            }
            dataTextField.setText(presentText);

        } else if (e.getSource() == enter1Button) {
            enterbtnChangeDimFun();
            msgLabel.setText(msgLabel.getText());

        } else {
            int i = verifyButtensActionFun(e);
            String presentText = dataTextField.getText();
            if (zeroRemovalFlag == -1) {
                if (i == 0) {
                    presentText = "";
                } else if (i == 14) {
                    presentText = "0";
                    zeroRemovalFlag++;
                } else {
                    presentText = "";
                    zeroRemovalFlag++;
                }
            }
            switch (i) {
                case 0:
                    presentText += "0";
                    dataTextField.setText(presentText);
                    commaFlag = 0;
                    if (divideOccurFlag == 2)
                        divideOccurFlag = 1;// to confirm that user doesn't pass divided by zero
                    break;
                case 1:
                    presentText += "1";
                    dataTextField.setText(presentText);
                    commaFlag = 0;
                    if (divideOccurFlag == 1)
                        divideOccurFlag = 0;// to confirm that user doesn't pass divided by zero

                    break;
                case 2:
                    presentText += "2";
                    dataTextField.setText(presentText);
                    commaFlag = 0;
                    if (divideOccurFlag == 1)
                        divideOccurFlag = 0;// to confirm that user doesn't pass divided by zero
                    break;
                case 3:
                    presentText += "3";
                    dataTextField.setText(presentText);
                    commaFlag = 0;
                    if (divideOccurFlag == 1)
                        divideOccurFlag = 0;// to confirm that user doesn't pass divided by zero
                    break;
                case 4:
                    presentText += "4";
                    dataTextField.setText(presentText);
                    commaFlag = 0;
                    if (divideOccurFlag == 1)
                        divideOccurFlag = 0;// to confirm that user doesn't pass divided by zero
                    break;
                case 5:
                    presentText += "5";
                    dataTextField.setText(presentText);
                    commaFlag = 0;
                    if (divideOccurFlag == 1)
                        divideOccurFlag = 0;// to confirm that user doesn't pass divided by zero
                    break;
                case 6:
                    presentText += "6";
                    dataTextField.setText(presentText);
                    commaFlag = 0;
                    if (divideOccurFlag == 1)
                        divideOccurFlag = 0;// to confirm that user doesn't pass divided by zero
                    break;
                case 7:
                    presentText += "7";
                    dataTextField.setText(presentText);
                    commaFlag = 0;
                    if (divideOccurFlag == 1)
                        divideOccurFlag = 0;// to confirm that user doesn't pass divided by zero
                    break;
                case 8:
                    presentText += "8";
                    dataTextField.setText(presentText);
                    commaFlag = 0;
                    if (divideOccurFlag == 1)
                        divideOccurFlag = 0;// to confirm that user doesn't pass divided by zero
                    break;
                case 9:
                    presentText += "9";
                    dataTextField.setText(presentText);
                    commaFlag = 0;
                    if (divideOccurFlag == 1)
                        divideOccurFlag = 0;// to confirm that user doesn't pass divided by zero
                    break;
                case 10:
                    OperatorAddingFun(10, presentText);
                    break;
                case 11:
                    OperatorAddingFun(11, presentText);
                    break;
                case 12:
                    OperatorAddingFun(12, presentText);

                    break;
                case 13:
                    OperatorAddingFun(13, presentText);
                    break;
                case 14:
                    pointEnterFun();
                    break;
                case 15:
                    enterBtnFun();
                    // button[15] : Enter | button[16] : +/- | button[17] : BackSpace
                    // button[18] : Clear | button[19] : more |
                    break;
                case 16:
                    presentText = dataTextField.getText();
                    char firstLetter = presentText.charAt(0);
                    int len = presentText.length();

                    if (firstLetter == '-') {
                        presentText = presentText.substring(1, len);
                        presentText = "+" + presentText;
                    } else {
                        presentText = presentText.substring(1, len);
                        presentText = "-" + presentText;
                    }
                    dataTextField.setText(presentText);

                    break;
                case 17:
                    bS_BtnFun();
                    break;
                case 18:
                    presentText = "0";
                    zeroRemovalFlag = -1;
                    dataTextField.setText(presentText);
                    if (hcfbtnFlag == 1 || lcmbtnFlag == 1) {
                        msgLabel.setText("0");
                    }
                    break;
                case 19:
                    if (moreLessFlag == 0) {
                        moreLessFlag = 1;
                        moreBtnFun();
                    } else {
                        moreLessFlag = 0;
                        lessConvBtnFun();
                    }
                    break;

            }
        }
        if (moreLessFlag == 0) { // for Hcm and hcf option
            if (e.getSource() != button[15]) // disable for enetr btn
                displayDefaulFun();
            answerStrNumFun();
        } else if (e.getSource() != enter1Button) // disable for enetr btn
        {
            displayDefaulFun();

        }
    }

    /** Funcanality of more btn */
    void moreBtnFun() {
        lcmButton.setVisible(true);
        hcfButton.setVisible(true);
        comaButton.setVisible(true);
        enter1Button.setVisible(true);
        if (themeChangeFlag == 0)
            button[15].setBackground(d_btnColor); // for enter btn disable
        else
            button[15].setBackground(l_btnColor); // for enter btn disable

        if (moreBtnFlag == 0) {

            buttonPanel.add(lcmButton);
            buttonPanel.add(hcfButton);
            buttonPanel.add(comaButton);
            buttonPanel.add(enter1Button);

            lcmButton = defaultButtonfun(lcmButton);
            hcfButton = defaultButtonfun(hcfButton);
            comaButton = defaultButtonfun(comaButton);
            enter1Button = defaultButtonfun(enter1Button);
            if (themeChangeFlag == 0) {
                enter1Button.setBackground(d_darkBgColor);
                enter1Button.setForeground(d_txtColor);
                lcmButton.setBackground(l_btnColor);
                hcfButton.setBackground(l_btnColor);
                comaButton.setBackground(l_btnColor);
                lcmButton.setForeground(l_txtColor);
                hcfButton.setForeground(l_txtColor);
                comaButton.setForeground(l_txtColor);
            } else {
                enter1Button.setBackground(l_darkBgColor);
                enter1Button.setForeground(l_txtColor);
                lcmButton.setBackground(d_btnColor);
                hcfButton.setBackground(d_btnColor);
                comaButton.setBackground(d_btnColor);
                lcmButton.setForeground(d_txtColor);
                hcfButton.setForeground(d_txtColor);
                comaButton.setForeground(d_txtColor);
            }

            moreBtnFlag++;
        }
        button[19].setText("Less");

        zeroRemovalFlag = -1;
        dataTextField.setText("0");
        msgLabel.setText("0");
        button[10].setEnabled(false);
        button[11].setEnabled(false);
        button[12].setEnabled(false);
        button[13].setEnabled(false);
        button[14].setEnabled(false);
        button[15].setEnabled(false);
        button[16].setEnabled(false);

        // if (themeChangeFlag == 0) { // for enter when disable
        // button[15].setBackground(l_btnColor);
        // } else {
        // button[15].setBackground(d_btnColor);
        // }

        lcmButton.addActionListener(this);
        hcfButton.addActionListener(this);
        comaButton.addActionListener(this);
        enter1Button.addActionListener(this);
        lcmButton.addMouseListener(this);
        hcfButton.addMouseListener(this);
        comaButton.addMouseListener(this);
        enter1Button.addMouseListener(this);

    }

    /** Funcanality of again clicking more btn */
    void lessConvBtnFun() {

        button[10].setEnabled(true);
        button[11].setEnabled(true);
        button[12].setEnabled(true);
        button[13].setEnabled(true);
        button[14].setEnabled(true);
        button[15].setEnabled(true);
        button[16].setEnabled(true);

        lcmButton.setVisible(false);
        hcfButton.setVisible(false);
        comaButton.setVisible(false);
        enter1Button.setVisible(false);
        button[19].setText("More");
        zeroRemovalFlag = -1;
        dataTextField.setText("0");
        msgLabel.setText("0");

        if (themeChangeFlag == 1) {
            button[15].setBackground(l_darkBgColor); // enter btn
            button[15].setForeground(l_txtColor);
        } else {
            button[15].setBackground(d_darkBgColor); // enter btn
            button[15].setForeground(d_txtColor);

        }

    }

}