package HandDigitRecog;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;


/**
 * 
 * Hand Digit Recognise 
 * @author Danishan
 * 
 */
public abstract class HDRecogFile extends RandomAccessFile {
    private int countFlag;

    /**
     *
     * @see RandomAccessFile
     * @throws FileNotFoundException
     * @throws IOException
     */
    public HDRecogFile(String name, String mode) throws IOException {
        super(name, mode);
        if (getMyMagicNumFun() != readInt()) {
            throw new RuntimeException(
                    "This MNIST DB file " + name + " should start with the number " + getMyMagicNumFun() + ".");
        }
        countFlag = readInt();
    }

    protected abstract int getMyMagicNumFun();

    /**
     * 
     * @throws IOException
     */
    public long getCurrIndexFun() throws IOException {
        return (getFilePointer() - getHeaderSizeFun()) / getEntryLenFun() + 1;
    }

    public void setCurrIndexFun(long current) {
        try {
            if (current < 0 || current > countFlag) {
                throw new RuntimeException(current + " is not in the range 0 to " + countFlag);
            }
            seek(getHeaderSizeFun() + (current - 1) * getEntryLenFun());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int getHeaderSizeFun() {
        return 8; // two integers
    }

    public int getEntryLenFun() {
        return 1;
    }

    /**
     * 
     * @throws IOException
     */
    public void next() throws IOException {
        if (getCurrIndexFun() < countFlag) {
            skipBytes(getEntryLenFun());
        }
    }

    /**
     * Move to the previous entry.
     * 
     * @throws IOException
     */
    public void previousFun() throws IOException {
        if (getCurrIndexFun() > 0) {
            seek(getFilePointer() - getEntryLenFun());
        }
    }

    public int getCountFun() {
        return countFlag;
    }
}