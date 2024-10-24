import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BoardPanel extends JPanel {
    final int rows = 8;
    final int cols = 8;
    Field[][] fields = new Field[rows][cols];
    Map<Colour, ArrayList<Piece>> material = new HashMap<>();

    public BoardPanel(Dimension boardSize) {
        Field.setFieldSize(Math.min(boardSize.height / rows, boardSize.width / cols));
        initFields();
        initPieces();
    }

    private void initPieces() {
        for (Colour colour : Colour.values()) {
            if (colour == Colour.WHITE) {
                ArrayList<Piece> pieces = new ArrayList<>();
                pieces.add(new Pawn("../Resources/pawn.png", colour, new Field(6, 1)));
                material.put(Colour.WHITE, pieces);
            }
        }
    }

    private void initFields() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                fields[row][col] = new Field(row, col);
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int row = 0, y = 0; row < rows; row++, y += Field.getFieldSize()) {
            for (int col = 0, x = 0; col < cols; col++, x += Field.getFieldSize()) {

                if ((row + col) % 2 == 0) {
                    g.setColor(new Color(238, 238, 210));
                } else {
                    g.setColor(new Color(118, 150, 86));
                }
                g.fillRect(x, y, Field.getFieldSize(), Field.getFieldSize());
            }
        }

        drawPieces(g);

        /*Piece piece = material.get(Colour.WHITE).getFirst();
        System.out.println(piece.getColour());
        System.out.println(piece.getCurrentField().getPosX());
        System.out.println(piece.getCurrentField().getPosY());*/
    }
    private void drawPieces(Graphics g) {
        for (Colour colour : Colour.values()) {
            ArrayList<Piece> pieces = material.get(colour);
            if (pieces != null) { //todo does not make sense, added just in case
                for (Piece piece : pieces) {
                    piece.draw(g);
                }
            }
        }
    }
}
