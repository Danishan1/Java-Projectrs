package GenZ.main;

public class Number {
    private String number[] = new String[30];
    private final int MAX_ArrLen = 13;
    private long digitsArr[] = new long[MAX_ArrLen], answer = 0;
    private long numArr[] = new long[MAX_ArrLen];
    private int numArrTop = 0, tensDigitFlag = 0;

    Number() {
        number[0] = "zero";
        number[1] = "one";
        number[2] = "two";
        number[3] = "three";
        number[4] = "four";
        number[5] = "five";
        number[6] = "six";
        number[7] = "seven";
        number[8] = "eight";
        number[9] = "nine";
        number[10] = "ten";
        number[11] = "eleven";
        number[12] = "twelve";
        number[13] = "thirteen";
        number[14] = "fourteen";
        number[15] = "fifteen";
        number[16] = "sixteen";
        number[17] = "seventeen";
        number[18] = "eighteen";
        number[19] = "nineteen";
        number[20] = "twenty";
        number[21] = "thirty";
        number[22] = "fourty";
        number[23] = "fifty";
        number[24] = "sixty";
        number[25] = "seventy";
        number[26] = "eighty";
        number[27] = "ninty";
        number[28] = "hundred";
        number[29] = "thousand";
    }

    long wordtoNumFun(String wordNum) {

        // String wordNum = "";
        int length = wordNum.length();
        wordNum = wordNum.toLowerCase();
        String seprateNumString[] = new String[MAX_ArrLen];
        int sepNumCount = 0;
        for (int i = 0; i < 10; i++) {
            seprateNumString[i] = "";
        }
        for (int i = 0; i < length; i++) {
            char C = wordNum.charAt(0);
            if (C == ' ') {
                sepNumCount++;
            } else {
                seprateNumString[sepNumCount] = seprateNumString[sepNumCount] + C;
            }
            wordNum = wordNum.substring(1);
        }
        for (int j = 0; j <= sepNumCount; j++) {
            digitsArr[j] = convertWordToNum(seprateNumString[j]);

        }
        for (int j = 0; j <= sepNumCount; j++) { // 2 1000 5 100 60 4

            if (digitsArr[0] == 100000) {
                numArr[numArrTop] = 100000;
                numArrTop++;
            } else if (digitsArr[0] == 1000) {
                numArr[numArrTop] = 1000;
                numArrTop++;
            } else if (digitsArr[0] == 100) {
                numArr[numArrTop] = 100;
                numArrTop++;
            } else if (digitsArr[j] == 100000) {
                numArr[numArrTop - 1] = numArr[numArrTop - 1] * 100000;

            } else if (digitsArr[j] == 1000) {
                numArr[numArrTop - 1] = numArr[numArrTop - 1] * 1000;

            } else if (digitsArr[j] == 100) {
                numArr[numArrTop - 1] = numArr[numArrTop - 1] * 100;

            } else if (digitsArr[j] % 10 == 0) {
                tensDigitFlag = 1;
                if (digitsArr[j + 1] == 0) {
                    numArr[numArrTop] = digitsArr[j];
                } else {
                    numArr[numArrTop] = digitsArr[j] / 10;

                }
            } else if (tensDigitFlag == 1) {
                numArr[numArrTop] = numArr[numArrTop] * 10 + digitsArr[j];
                tensDigitFlag = 0;
                numArrTop++;

            } else {
                numArr[numArrTop] = digitsArr[j];
                numArrTop++;
            }

        }
        for (int j = 0; j <= numArrTop; j++) {
            answer = answer + numArr[j];
        }

        return answer;
    }

    private long convertWordToNum(String A1) {

        switch (A1) {
            case "zero":
                return 0;
            case "one":
                return 1;
            case "two":
                return 2;
            case "three":
                return 3;
            case "four":
                return 4;
            case "five":
                return 5;
            case "six":
                return 6;
            case "seven":
                return 7;
            case "eight":
                return 8;
            case "nine":
                return 9;
            case "ten":
                return 10;
            case "eleven":
                return 11;
            case "twelve":
                return 12;
            case "thirteen":
                return 13;
            case "fourteen":
                return 14;
            case "fifteen":
                return 15;
            case "sixteen":
                return 16;
            case "seventeen":
                return 17;
            case "eighteen":
                return 18;
            case "nineteen":
                return 19;
            case "twenty":
                return 20;
            case "thirty":
                return 30;
            case "fourty":
                return 40;
            case "fifty":
                return 50;
            case "sixty":
                return 60;
            case "seventy":
                return 70;
            case "eighty":
                return 80;
            case "ninty":
                return 90;
            case "hundred":
                return 100;
            case "thousand":
                return 1000;
            case "lakh":
                return 100000;
        }

        return -1;
    }
}
