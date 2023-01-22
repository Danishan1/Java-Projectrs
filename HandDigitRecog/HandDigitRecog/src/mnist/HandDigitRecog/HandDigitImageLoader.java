package HandDigitRecog;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

/**
 * 
 * Hand Digit Recognise 
 * @author Danishan
 * 
 */
public class HandDigitImageLoader {
	
	public static BufferedImage imageLoadFun(String path) throws Exception{
		return imageResizeFun(ImageIO.read(new File(path)),28,28);
	}

	public static BufferedImage imageResizeFun(BufferedImage image, int newWidth, int newHeight) {
		Image tmp = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
		BufferedImage dImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);

		Graphics2D TempG2d = dImage.createGraphics();
		TempG2d.drawImage(tmp, 0, 0, null);
		TempG2d.dispose();

		return dImage;
}  

	public static int[][] bufferedImageToArrayFun(BufferedImage image) {
		int[][] tempArr = new int[image.getWidth()][image.getHeight()];

		for(int i = 0; i < image.getWidth(); i++)
		    for(int j = 0; j < image.getHeight(); j++)
		        tempArr[i][j] = image.getRGB(i, j);
		
		return tempArr;
	}

	public static int[][] bufferedImageRedToArrayFun(BufferedImage image) {
		int[][] tempArr = new int[image.getWidth()][image.getHeight()];
		
		for(int i = 0; i < image.getWidth(); i++)
		    for(int j = 0; j < image.getHeight(); j++)
		        tempArr[i][j] = new Color(image.getRGB(i, j)).getRed();
		
		return tempArr;
	}
	
	public static double[] intToDoubleArrayFun(int[][] arr) {
		double[] tempArr = new double[arr.length * arr[0].length];
		for(int j = 0 ; j < arr.length; j ++){
			for(int n = 0; n < arr[0].length; n++){
				tempArr[j * arr.length + n] = (double)arr[n][j] / (double)256;
			}
		}
		return tempArr;
	}
	
	public static double[] invertFun(double[] tempArr) {
		for(int j = 0 ; j < tempArr.length; j ++){
			tempArr[j] = 0.9999-tempArr[j];
		}
		return tempArr;
	}
	
}
