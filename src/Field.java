public class Field {
    private Piece currentPiece;
    private static int fieldSize;
    private final int row, col;
    private final int posY, posX;

    /*public Field(int row, int col, Piece currentPiece) {
        this (row, col);
        this.currentPiece = currentPiece;
    }*/

    public Field(int row, int col) {
        this.row = row;
        this.col = col;
        this.posY = row * fieldSize;
        this.posX = col * fieldSize;
        currentPiece = null;
    }
    public static void setFieldSize(int size) {fieldSize = size;}
    public static int getFieldSize() {return fieldSize;}
    public boolean isOccupied() {return currentPiece != null;}
    public Piece getCurrentPiece() {return currentPiece;}
    public void setCurrentPiece(Piece currentPiece) {this.currentPiece = currentPiece;}
    public int getRow() {return row;}
    public int getCol() {return col;}
    public int getPosX() {return posX;}
    public int getPosY() {return posY;}
}
