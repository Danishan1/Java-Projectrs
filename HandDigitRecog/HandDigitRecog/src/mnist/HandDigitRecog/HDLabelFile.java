package HandDigitRecog;

import java.io.FileNotFoundException;
import java.io.IOException;


/**
 * 
 * Hand Digit Recognise 
 * @author Danishan
 * 
 */
public class HDLabelFile extends HDRecogFile {

    /**
     * 
     * @throws IOException
     * @throws FileNotFoundException
     */
    public HDLabelFile(String name, String mode) throws IOException {
        super(name, mode);
    }

    /**
     * @throws IOException
     */
    public int labelReadFun() throws IOException {
        return readUnsignedByte();
    }

    /** Read the specified number of labels from the current position*/
    public int[] LabelsReadFun(int number) throws IOException {
        int[] outArr = new int[number];
        for( int i=0; i<number; i++ ) outArr[i] = labelReadFun();
        return outArr;
    }

    @Override
    protected int getMyMagicNumFun() {
        return 2049;
    }
}