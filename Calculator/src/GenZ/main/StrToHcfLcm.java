package GenZ.main;

public class StrToHcfLcm {
    private int MAX_LenArr = 30, strLenght;

    private char infixStackArr[] = new char[MAX_LenArr];
    private long postfixStackArr[] = new long[MAX_LenArr];
    private int topInfix = -1;
    private int topPostfix = -1;

    private void convertStrIntoInfix(String S) {
        strLenght = S.length();
        for (int j = 0; j < strLenght; j++) {
            char letter = S.charAt(0);
            if (S.length() >= 2) // 56
                S = S.substring(1);
            pushInfixStackFun(letter);
        }
    }

    public long StrToLCM_Fun(String S) {

        convertStrIntoInfix(S);

        LCM_Finder lcm = new LCM_Finder();
        infixToNumArrFun();
        long A = lcm.arrToLCM_Fun(postfixStackArr, topPostfix);

        return A;
    }

    public long StrToHCF_Fun(String S) {

        convertStrIntoInfix(S);

        HCF_Finder hcf = new HCF_Finder();
        infixToNumArrFun();
        long A = hcf.arrToHCF_Fun(postfixStackArr, topPostfix);

        return A;
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

    private void infixToNumArrFun() {
        char C;
        long A = 0, B = 0;
        C = infixStackArr[0];
        for (int i = 1; i <= topInfix + 1; i++) {
            if (C != '(') {

                if (C == ',' || C == ')') {
                    postfixStackArr[++topPostfix] = A;
                    A = 0;
                } else {
                    B = C - '0';
                    A = A * 10 + B;
                }

            }
            C = infixStackArr[i];
        }
    }

    // public static void main(String[] args) {
    // StrToHcfLcm A = new StrToHcfLcm();
    // A.convertStrIntoInfix("45,60,59");
    // for (int i = 0; i < A.topInfix; i++)
    // System.out.println(A.infixStackArr[i]);

    // A.infixToNumFun();
    // for (int i = 0; i < A.topPostfix; i++)
    // System.out.println(A.postfixStackArr[i]);

    // }

}
