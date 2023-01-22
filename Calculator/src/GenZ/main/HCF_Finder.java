package GenZ.main;

public class HCF_Finder {
    private long[] numArr;

    protected long passArrNumFun(long x, long y) {
        long temp;

        if (x < y)
            temp = gcdTwoNum(x, y);
        else
            temp = gcdTwoNum(y, x);

        return temp;
    }

    public long arrToHCF_Fun(long[] A, int top) {
        numArr = A;
        if (top == 0) {
            return -1;
        } else {
            long tempHcf = passArrNumFun(numArr[0], numArr[1]);
            for (int i = 2; i <= top; i++) {
                tempHcf = passArrNumFun(tempHcf, numArr[i]);

            }

            return tempHcf;
        }
    }

    protected long gcdTwoNum(long a, long b) {
        long i;
        for (i = a; i >= 1; i--) {

            if (a % i == 0 && b % i == 0)
                break; // exits the loop
        }
        return i;
    }

}
