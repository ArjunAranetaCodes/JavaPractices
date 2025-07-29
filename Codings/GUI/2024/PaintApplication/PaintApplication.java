import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class PaintApplication extends JFrame {
    private static final int DEFAULT_WIDTH = 800;
    private static final int DEFAULT_HEIGHT = 600;

    private Color currentColor = Color.BLACK;
    private int brushSize = 5;

    private BufferedImage canvas;
    private Graphics2D g2d;

    public PaintApplication() {
        setTitle("Paint Application");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        canvas = new BufferedImage(DEFAULT_WIDTH, DEFAULT_HEIGHT, BufferedImage.TYPE_INT_ARGB);
        g2d = canvas.createGraphics();
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT);
        g2d.setColor(currentColor);

        setupUI();
    }

    private void setupUI() {
        JPanel controlPanel = new JPanel();
        JButton colorButton = new JButton("Choose Color");
        JButton saveButton = new JButton("Save");
        JButton loadButton = new JButton("Load");
        JSlider sizeSlider = new JSlider(JSlider.HORIZONTAL, 1, 20, brushSize);

        colorButton.addActionListener(e -> chooseColor());
        saveButton.addActionListener(e -> saveDrawing());
        loadButton.addActionListener(e -> loadDrawing());
        sizeSlider.addChangeListener(e -> brushSize = sizeSlider.getValue());

        controlPanel.add(colorButton);
        controlPanel.add(saveButton);
        controlPanel.add(loadButton);
        controlPanel.add(new JLabel("Brush Size:"));
        controlPanel.add(sizeSlider);

        add(controlPanel, BorderLayout.NORTH);

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                g2d.setStroke(new BasicStroke(brushSize, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
                g2d.drawLine(e.getX(), e.getY(), e.getX(), e.getY());
                repaint();
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                g2d.drawLine(e.getX(), e.getY(), e.getX(), e.getY());
                repaint();
            }
        });
    }

    private void chooseColor() {
        currentColor = JColorChooser.showDialog(this, "Choose Color", currentColor);
        if (currentColor == null) {
            currentColor = Color.BLACK;
        }
        g2d.setColor(currentColor);
    }

    private void saveDrawing() {
        try {
            File file = new File("drawing.png");
            ImageIO.write(canvas, "png", file);
            JOptionPane.showMessageDialog(this, "Drawing saved successfully!");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error saving drawing");
        }
    }

    private void loadDrawing() {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                BufferedImage loadedImage = ImageIO.read(file);
                g2d.drawImage(loadedImage, 0, 0, this);
                repaint();
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error loading drawing");
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(canvas, 0, 0, this);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PaintApplication paintApp = new PaintApplication();
            paintApp.setVisible(true);
        });
    }
}
