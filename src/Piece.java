import javax.swing.*;
import java.awt.*;

public abstract class Piece {

    //todo решить где хранить фигуры
    private final Colour colour;
    private final Image texture;

    private Field currentField;
    private boolean hasMoved;


    public Piece(String path, Colour colour, Field initialField) {
        this.colour = colour;
        this.texture = AssetManager.assetManager.getTexture(colour + "/" + path);
        this.currentField = initialField;
        this.addToField(initialField);
    }
    public void addToField(Field field) {
        field.setCurrentPiece(this);
        currentField = field;
    }
    public void draw(Graphics g) {
        g.drawImage(texture, currentField.getPosX(), currentField.getPosY(), null);
    }
    public abstract void move();

    public Field getCurrentField() {return currentField;}
    public Colour getColour() {return colour;}
    public boolean isHasMoved() {return hasMoved;}
}
