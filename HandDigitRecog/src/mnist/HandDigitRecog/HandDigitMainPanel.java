package HandDigitRecog;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 
 * Hand Digit Recognise 
 * @author Danishan
 * 
 */
public class HandDigitMainPanel extends JPanel {

	
	// private static final long serialVersionUID = 2789376983756851940L;
	private HandDigitRecoggImageFile globalImg;
	private HDLabelFile globalLabel;
	
	public int[] globalBufferImage = new int[784];
	public int globalBufferLabel = -1;

	public HandDigitMainPanel(HandDigitRecoggImageFile image, HDLabelFile label) {
		super();
		this.setImageFun(image);
		this.setLabelFun(label);
	}

	public void nextImageFun() {
		try {
			this.globalImg.next();
			this.globalLabel.next();
			
			for(int i = 0; i < 784; i++){
				globalBufferImage[i] = globalImg.read();
			}
			globalBufferLabel = globalLabel.labelReadFun();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public HandDigitRecoggImageFile getImageFun() {
		return globalImg;
	}

	public void setImageFun(HandDigitRecoggImageFile image) {
		this.globalImg = image;
	}

	public HDLabelFile getLabelFun() {
		return globalLabel;
	}

	public void setLabelFun(HDLabelFile label) {
		this.globalLabel = label;
	}
	
	public void paintComponent(Graphics g){
		Graphics2D tempG2d = (Graphics2D) g;
		
		int height = this.getHeight();
		int width = this.getWidth();
		g.clearRect(0, 0, width, height);
		for(int i = 0; i < 784; i++){
			int x = (i % 28) * width / 28;
			int y = ((int)i / (int)28) * height / 28;
			tempG2d.setColor(new Color(globalBufferImage[i]));
			tempG2d.fillRect(x, y, width / 28 + 1, height / 28 + 1);
		}
		Composite comp = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .3f);
	    tempG2d.setComposite(comp);
	    tempG2d.setPaint(Color.red);
	    tempG2d.setFont(new Font("Times Roman", Font.PLAIN, height));
	    tempG2d.drawString(""+globalBufferLabel,height / 2, width /2);
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException{
		
		String path = new File("").getAbsolutePath();

		HandDigitRecoggImageFile m = new HandDigitRecoggImageFile(path + "/res/trainImage.idx3-ubyte", "rw");
		HDLabelFile l = new HDLabelFile(path + "/res/trainLabel.idx1-ubyte", "rw");
		
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100, 100, 450, 300);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		HandDigitMainPanel p =new HandDigitMainPanel(m,l);
		p.nextImageFun();
		
		contentPane.add(p, BorderLayout.CENTER);
		
		f.setContentPane(contentPane);
		f.setVisible(true);
		
		for(int i = 0; i < 4000; i++){
			Thread.sleep(500);
			p.nextImageFun();
			f.repaint();
		}
	}

}
