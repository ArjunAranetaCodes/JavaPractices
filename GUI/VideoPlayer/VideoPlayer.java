import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.media.*;
import javax.media.format.VideoFormat;
import javax.media.protocol.DataSource;

public class VideoPlayer extends JFrame {

    private Player player;
    private Component video;

    public VideoPlayer() {
        setTitle("Simple Video Player");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initUI();
    }

    private void initUI() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem openItem = new JMenuItem("Open");

        openItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openFile();
            }
        });

        fileMenu.add(openItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        setLayout(new BorderLayout());

        video = new Panel();
        add(video, BorderLayout.CENTER);

        setVisible(true);
    }

    private void openFile() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            playVideo(file);
        }
    }

    private void playVideo(File file) {
        if (player != null) {
            player.stop();
            player.close();
        }

        try {
            MediaLocator mediaLocator = new MediaLocator(file.toURI().toURL());

            player = Manager.createRealizedPlayer(mediaLocator);
            player.addControllerListener(new EventHandler());

            if (video instanceof Panel) {
                Component visualComponent = player.getVisualComponent();
                if (visualComponent != null) {
                    ((Panel) video).add(visualComponent, BorderLayout.CENTER);
                }
            }

            validate();
            player.start();
        } catch (MalformedURLException | NoPlayerException | CannotRealizeException | IOException e) {
            e.printStackTrace();
        }
    }

    private class EventHandler implements ControllerListener {
        public void controllerUpdate(ControllerEvent event) {
            if (event instanceof RealizeCompleteEvent) {
                Player player = (Player) event.getSource();
                Component vc = player.getVisualComponent();

                if (vc != null) {
                    video = vc;
                }

                Container c = getContentPane();
                c.add(video, BorderLayout.CENTER);
                validate();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VideoPlayer();
            }
        });
    }
}
