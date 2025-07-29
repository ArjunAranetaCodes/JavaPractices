import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageViewer extends JFrame {
    private JLabel imageLabel;
    private BufferedImage currentImage;
    private int currentImageIndex;
    private File[] imageFiles;

    public ImageViewer() {
        setTitle("Image Viewer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        // Components
        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        add(new JScrollPane(imageLabel), BorderLayout.CENTER);

        JToolBar toolBar = new JToolBar();
        JButton prevButton = new JButton("Previous");
        JButton nextButton = new JButton("Next");
        JButton zoomInButton = new JButton("Zoom In");
        JButton zoomOutButton = new JButton("Zoom Out");
        JButton rotateButton = new JButton("Rotate");

        toolBar.add(prevButton);
        toolBar.add(nextButton);
        toolBar.addSeparator();
        toolBar.add(zoomInButton);
        toolBar.add(zoomOutButton);
        toolBar.addSeparator();
        toolBar.add(rotateButton);

        add(toolBar, BorderLayout.NORTH);

        // Event listeners
        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showImage(--currentImageIndex);
            }
        });

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showImage(++currentImageIndex);
            }
        });

        zoomInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zoomImage(1.2);
            }
        });

        zoomOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zoomImage(0.8);
            }
        });

        rotateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rotateImage(90);
            }
        });

        // Set initial state
        currentImageIndex = 0;
        loadImageFiles("C:\\Users\\Arjun\\Pictures"); // Set the actual path to your image folder
        showImage(currentImageIndex);
    }

    private void loadImageFiles(String folderPath) {
        File folder = new File(folderPath);
        imageFiles = folder.listFiles((dir, name) ->
                name.toLowerCase().endsWith(".jpg") || name.toLowerCase().endsWith(".png")
        );
    }

    private void showImage(int index) {
        if (imageFiles == null || index < 0 || index >= imageFiles.length) {
            return;
        }

        try {
            currentImage = ImageIO.read(imageFiles[index]);
            ImageIcon imageIcon = new ImageIcon(currentImage);
            imageLabel.setIcon(imageIcon);
            setTitle("Image Viewer - " + imageFiles[index].getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void zoomImage(double factor) {
        if (currentImage != null) {
            int newWidth = (int) (currentImage.getWidth() * factor);
            int newHeight = (int) (currentImage.getHeight() * factor);
            BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, currentImage.getType());
            Graphics2D g = resizedImage.createGraphics();
            AffineTransform at = AffineTransform.getScaleInstance(factor, factor);
            g.drawRenderedImage(currentImage, at);
            g.dispose();
            currentImage = resizedImage;
            imageLabel.setIcon(new ImageIcon(currentImage));
        }
    }

    private void rotateImage(double degrees) {
        if (currentImage != null) {
            AffineTransform at = AffineTransform.getRotateInstance(Math.toRadians(degrees),
                    currentImage.getWidth() / 2.0, currentImage.getHeight() / 2.0);
            BufferedImage rotatedImage = new BufferedImage(currentImage.getWidth(), currentImage.getHeight(),
                    currentImage.getType());
            Graphics2D g = rotatedImage.createGraphics();
            g.drawRenderedImage(currentImage, at);
            g.dispose();
            currentImage = rotatedImage;
            imageLabel.setIcon(new ImageIcon(currentImage));
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ImageViewer().setVisible(true);
        });
    }
}
