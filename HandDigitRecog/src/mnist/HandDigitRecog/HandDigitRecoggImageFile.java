package HandDigitRecog;

import java.io.FileNotFoundException;
import java.io.IOException;


/**
 * 
 * Hand Digit Recognise 
 * @author Danishan
 * 
 */
public class HandDigitRecoggImageFile extends HDRecogFile {
    private int globalRows;
    private int globalCols;

    /**
     * 
     * @throws IOException
     * @throws FileNotFoundException
     */
    public HandDigitRecoggImageFile(String name, String mode) throws FileNotFoundException, IOException {
        super(name, mode);

        // read header information
        globalRows = readInt();
        globalCols = readInt();
    }

    /**
     * 
     * @throws IOException
     */
    public int[][] readImgFun() throws IOException {
        int[][] dat = new int[getRowsFun()][getColsFun()];
        for (int i = 0; i < getColsFun(); i++) {
            for (int j = 0; j < getRowsFun(); j++) {
                dat[i][j] = readUnsignedByte();
            }
        }
        return dat;
    }

    /**
     * 
     * @throws IOException
     */
    public void nextImgFun() throws IOException {
        super.next();
    }

    /**
     * 
     * @throws IOException
     */
    public void prevImgFun() throws IOException {
        super.previousFun();
    }

    @Override
    protected int getMyMagicNumFun() {
        return 2051;
    }

    /**
     * 
     * @return int
     */
    public int getRowsFun() {
        return globalRows;
    }

    /**
     * 
     * @return int
     */
    public int getColsFun() {
        return globalCols;
    }

    @Override
    public int getEntryLenFun() {
        return globalCols * globalRows;
    }

    @Override
    public int getHeaderSizeFun() {
        return super.getHeaderSizeFun() + 8; 
    }
}