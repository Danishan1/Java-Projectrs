package GenZ.main;

public class EvaluatePostFix {

    private int numArrPoint = -1, pointFlag = 0, MAX_ArrLen = 30, digitFlag = 0;
    private char postfixStackArr[];
    private double numArr[] = new double[MAX_ArrLen], answer, pointTrack = 10;
    private double A = 0, B, lastNum, secondLastNum;
    private boolean zeroOperationFlag = false;

    double solvePostFix(char[] charArr) {
        postfixStackArr = charArr;
        convertCharToNum();
        answer = numArr[0];
        return answer;
    }

    protected void convertCharToNum() {
        int i = 0;
        char C;

        for (i = 0; postfixStackArr[i] != '\0'; i++) {
            C = postfixStackArr[i];

            if (C != '+' && C != '-' && C != 'x' && C != '/' && C != '$') {
                if (C == '.') {
                    pointFlag = 1;
                }

                if (pointFlag == 0) {

                    B = C - '0';
                    A = A * 10 + B; // 24
                    zeroOperationFlag = true;
                } else {
                    if (C != '.') {
                        B = C - '0';
                        B = B / pointTrack; // 0.1
                        pointTrack *= 10;
                        A = A + B;
                        zeroOperationFlag = true;
                    }
                }
            } else if (C == '$' || C == '+' || C == '-' || C == 'x' || C == '/') {
                digitFlag = 1;
                // if (numArr[i - 1] == 0) {
                // numPushStack(0);
                // }
                // if (A !=0)
                if (zeroOperationFlag == true)
                    numPushStack(A);
                zeroOperationFlag = false;
                A = 0;
                pointFlag = 0;
                pointTrack = 10;
            }
            if (C == '+' || C == '-' || C == 'x' || C == '/') {
                solveNumFun(C);
            }

        }
        if (digitFlag == 0) { // if only one number present
            numPushStack(A);
        }

    }

    protected void numPushStack(double D) {
        numArr[++numArrPoint] = D;
    }

    protected double numPopStack() {
        double D = numArr[numArrPoint--];
        return D;

    }

    protected void solveNumFun(char C) {
        switch (C) {
            case '+':
                lastNum = numPopStack();
                secondLastNum = numPopStack();
                numPushStack(secondLastNum + lastNum);
                break;
            case '-':
                lastNum = numPopStack();
                secondLastNum = numPopStack();
                numPushStack(secondLastNum - lastNum);
                break;
            case 'x':
                lastNum = numPopStack();
                secondLastNum = numPopStack();
                numPushStack(secondLastNum * lastNum);
                break;
            case '/':
                lastNum = numPopStack();
                secondLastNum = numPopStack();
                // if (lastNum != 0)
                numPushStack(secondLastNum / lastNum);
                break;
        }
    }

}
