import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

public class App {
    public static void main(String[] args) {
        // Load the OpenCV native library
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        // Path to the image file
        String imagePath = "Image\\boy6.jpg"; // Replace with your image path

        // Load the image
        Mat image = Imgcodecs.imread(imagePath);

        if (image.empty()) {
            System.out.println("Could not open or find the image!");
            return;
        }

        // Path to the Haar cascade XML file
        String faceCascadePath = "models\\haarcascade_frontalface_default.xml";

        // Load the Haar cascade classifier for face detection
        CascadeClassifier faceCascade = new CascadeClassifier(faceCascadePath);

        if (faceCascade.empty()) {
            System.out.println("Could not load Haar cascade classifier!");
            return;
        }

        // Detect faces in the image
        MatOfRect faces = new MatOfRect();
        faceCascade.detectMultiScale(image, faces, 1.1, 3, 0, new Size(30, 30), new Size());

        // Draw rectangles around detected faces
        for (Rect face : faces.toArray()) {
            Imgproc.rectangle(image, face.tl(), face.br(), new Scalar(0, 255, 0), 3);
        }

        // Save the result image
        String outputPath = "output_image.jpg";
        Imgcodecs.imwrite(outputPath, image);

        System.out.println("Face detection complete. Result saved at: " + outputPath);
    }
}
