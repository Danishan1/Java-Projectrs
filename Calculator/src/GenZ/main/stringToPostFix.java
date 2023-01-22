package GenZ.main;

public class stringToPostFix extends EvaluatePostFix {

    private int topOprator = -1, MAX_LenArr = 30, strLenght;
    private double answer;
    private char operatorStackArr[] = new char[MAX_LenArr];
    private char infixStackArr[] = new char[MAX_LenArr];
    private char postfixStackArr[] = new char[MAX_LenArr];
    private int topInfix = -1, topPostfix = -1;

    void convertStrIntoInfix(String S) {
        strLenght = S.length();
        for (int j = 0; j < strLenght; j++) {
            char letter = S.charAt(0);
            if (S.length() >= 2) // 56
                S = S.substring(1);
            pushInfixStackFun(letter);
        }
    }

    void convert_strIntoPostfix(String S, char[] finalArr) {
        convertStrIntoInfix(S);
        convert_InfixToPostFixFun();
        int i;
        for (i = 0; i <= topPostfix; i++) {
            finalArr[i] = postfixStackArr[i];
        }
        finalArr[i] = '\0';

    }

    double convertStrIntoNum(String S) {
        convert_strIntoPostfix(S, postfixStackArr);
        answer = solvePostFix(postfixStackArr);

        return answer;

    }

    private void pushInfixStackFun(char C) {
        if (topInfix == -1) {
            topInfix++;
            infixStackArr[topInfix] = '(';
            topInfix++;
            infixStackArr[topInfix] = C;
            if (strLenght == 1) {
                topInfix++;
                infixStackArr[topInfix] = ')';
            }

        } else if (topInfix == strLenght - 1) {
            topInfix++;
            infixStackArr[topInfix] = C;
            topInfix++;
            infixStackArr[topInfix] = ')';

        } else {
            topInfix++;
            infixStackArr[topInfix] = C;
        }
    }

    void convert_InfixToPostFixFun() {
        char C;
        for (int i = 0; i <= topInfix; i++) {
            C = infixStackArr[i];

            if (numVerifyFun(C) == 1) {
                pushPostfixStackFun(C);
            } else {
                if (topOprator == -1) {
                    pushOprFun(C);
                } else
                    oprtStackFun(C);
            }
        }
        while (topOprator != -1) {
            char tempC;
            int i = CheckCloseParenthes(operatorStackArr[topOprator]);
            if (i == 1) {
                while ((tempC = popOprFun()) != '(') {
                    pushPostfixStackFun(tempC);
                }
            }
        }
    }

    private int numVerifyFun(char C) {
        int i = 0;
        if (C != '+' && C != '-' && C != 'x' && C != '/' && C != '(' && C != ')')
            i++;

        return i;
    }

    private void oprtStackFun(char C) { // * - + / ( )

        if (operatorStackArr[topOprator] != '(' && operatorStackArr[topOprator] != ')' && C != '(' && C != ')') {
            if (checkOperPriroFun(operatorStackArr[topOprator]) == checkOperPriroFun(C)
                    || checkOperPriroFun(operatorStackArr[topOprator]) > checkOperPriroFun(C)) {

                pushPostfixStackFun(popOprFun());
                pushOprFun(C);

            } else if (checkOperPriroFun(operatorStackArr[topOprator]) < checkOperPriroFun(C)) {
                pushOprFun(C);
            }
        } else if (C == ')')

        {

            char tempC;
            while ((tempC = popOprFun()) != '(') {
                pushPostfixStackFun(tempC);
            }
        } else if (operatorStackArr[topOprator] == '(' || C == '(') {
            pushOprFun(C);
        }
        // }
    }

    // protected void if1stOper(char C) {
    // switch (C) {
    // case '+':
    // pushPostfixStackFun('0');
    // pushOprFun('+');

    // break;
    // case '-':
    // pushPostfixStackFun('0');
    // pushOprFun('-');

    // break;
    // case '*':
    // pushPostfixStackFun('1');
    // pushOprFun('*');

    // break;
    // case '/':
    // pushPostfixStackFun('#');

    // break;
    // }
    // }

    private int checkOperPriroFun(char C) {
        int i = 0;
        if (C == '+' || C == '-') {
            i = 0;
        } else if (C == 'x' || C == '/') {
            i = 1;
        }
        return i;
    }

    private void pushPostfixStackFun(char C) {
        topPostfix++;
        postfixStackArr[topPostfix] = C;
    }

    private void pushOprFun(char C) {

        if (C == '+' || C == '-' || C == 'x' || C == '/')
            pushPostfixStackFun('$'); // for Seprating Numbers

        topOprator++;
        operatorStackArr[topOprator] = C;

    }

    private char popOprFun() {
        char C = operatorStackArr[topOprator];
        topOprator--;
        return C;
    }

    private int CheckCloseParenthes(char C) {
        int i = 0;
        if (C == ')') {

            i = 1;
        }

        return i;
    }

}