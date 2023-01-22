package GenZ.main;

public class LCM_Finder {

    public long arrToLCM_Fun(long[] numArr, int top) {
        long resultNum = 1;
        int divisor = 2;

        if (top == 0) {
            return -1;
        } else {
            while (true) {
                int counter = 0;
                boolean divisible = false;

                for (int i = 0; i <= top; i++) {
                    if (numArr[i] == 0) {
                        return 0;
                    } else if (numArr[i] < 0) {
                        numArr[i] = numArr[i] * (-1);
                    } else if (numArr[i] == 1) {
                        counter++;
                    }

                    if (numArr[i] % divisor == 0) {
                        divisible = true;
                        numArr[i] = numArr[i] / divisor;
                    }
                }

                if (divisible) {
                    resultNum = resultNum * divisor;
                } else {
                    divisor++;
                }

                if (counter == top + 1) {
                    return resultNum;
                }
            }
        }
    }

}
