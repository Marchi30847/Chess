import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class Game extends JPanel {
    private static JFrame frame;
    static {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(
                Toolkit.getDefaultToolkit().getScreenSize().width,
                Toolkit.getDefaultToolkit().getScreenSize().height);

    }
    public Colour currentTurn;
    private BoardPanel board;
    private HistoryPanel history;
    private PlayerPanel black;
    private PlayerPanel white;

    public Game() {
        this.setLayout(new BorderLayout());

        board = new BoardPanel(new Dimension(frame.getWidth(), 720));
        int tabHeight = (frame.getHeight() - 720) / 2;
        black = new PlayerPanel(new Dimension(frame.getWidth(), tabHeight));
        white = new PlayerPanel(new Dimension(frame.getWidth(), tabHeight));
        history = new HistoryPanel(new Dimension(frame.getWidth() - 770, 720));
        JPanel placeholder = new JPanel();
        placeholder.setPreferredSize(new Dimension(50, 720));
        placeholder.setBackground(new Color(29, 27, 26));


        this.add(board, BorderLayout.CENTER);
        this.add(black, BorderLayout.NORTH);
        this.add(white, BorderLayout.SOUTH);
        this.add(history, BorderLayout.EAST);
        this.add(placeholder, BorderLayout.WEST);

        frame.getContentPane().add(this);
    }
}
