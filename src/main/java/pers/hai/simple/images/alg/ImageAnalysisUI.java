package pers.hai.simple.images.alg;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MediaTracker;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class ImageAnalysisUI extends JComponent {
    private static final long serialVersionUID = 1518574788794973574L;
    private BufferedImage rawImg;
    private BufferedImage modImg;
    private MediaTracker tracker;
    private Dimension mySize;

    public ImageAnalysisUI(File f) {
        try {
            rawImg = ImageIO.read(f);
            HistogramAnalysisAlg filter = new HistogramAnalysisAlg(rawImg);
            modImg = filter.getHistogram();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        tracker = new MediaTracker(this);
        tracker.addImage(rawImg, 1);

        // blocked 10 seconds to load the image data
        try {
            if (!tracker.waitForID(1, 10000)) {
                System.out.println("Load error.");
                System.exit(1);
            } // end if
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.exit(1);
        } // end catch

        mySize = new Dimension(2 * rawImg.getWidth() + 20,
                rawImg.getHeight() * 2);
        JFrame imageFrame = new JFrame("Gloomyfish - Image Analysis");
        imageFrame.getContentPane().add(this);
        imageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        imageFrame.pack();
        imageFrame.setVisible(true);
    }

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(rawImg, 0, 0, rawImg.getWidth(), rawImg.getHeight(), null);
        g2.drawImage(modImg, rawImg.getWidth() + 10, 0, modImg.getWidth(),
                modImg.getHeight(), null);
        g2.drawString("source image", 10, rawImg.getHeight() + 10);
        g2.drawString("connected component labeled area",
                10 + modImg.getWidth(), rawImg.getHeight() + 10);
    }

    public Dimension getPreferredSize() {
        return mySize;
    }

    public Dimension getMinimumSize() {
        return mySize;
    }

    public Dimension getMaximumSize() {
        return mySize;
    }

    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        new ImageAnalysisUI(f);
    }
}