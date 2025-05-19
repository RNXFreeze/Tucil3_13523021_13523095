/* Kelompok   : Kelompok Tucil3_13523021_13523095                                */
/* Nama - 1   : Muhammad Raihan Nazhim Oktana                                    */
/* NIM - 1    : K01 - 13523021 - Teknik Informatika (IF-Ganesha) ITB             */
/* Nama - 2   : Rafif Farras                                                     */
/* NIM - 2    : K02 - 13523095 - Teknik Informatika (IF-Ganesha) ITB             */
/* Tanggal    : Senin, 19 Mei 2025                                               */
/* Tugas      : Tugas Kecil 3 - Strategi Algoritma (IF2211-24)                   */
/* File Path  : Tucil3_13523021_13523095/src/utils/DataStructure.java            */
/* Deskripsi  : F06A - Data Structure Utility                                    */
/* PIC F06A   : K01 - 13523021 - Muhammad Raihan Nazhim Oktana                   */

package utils;
import java.util.List;

public class DataStructure {
    private int width;
    private int height;
    private int pieceCount;
    private Point exit;
    private Board board;
    private List<Piece> pieces;
    
    public DataStructure(int width , int height , int pieceCount , Point exit , Board board , List<Piece> pieces) {
        this.width = width;
        this.height = height;
        this.pieceCount = pieceCount;
        this.exit = exit;
        this.board = board;
        this.pieces = pieces;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getPieceCount() {
        return pieceCount;
    }

    public Point getExit() {
        return exit;
    }

    public Board getBoard() {
        return board;
    }

    public List<Piece> getPieces() {
        return pieces;
    }
   
    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setPieceCount(int pieceCount) {
        this.pieceCount = pieceCount;
    }

    public void setExit(Point exit) {
        this.exit = exit;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setPieces(List<Piece> pieces) {
        this.pieces = pieces;
    }

    public void printDataStructure() {
        System.out.println("Width : " + this.width);
        System.out.println("Height : " + this.height);
        System.out.println("Piece Count : " + this.pieceCount);
        System.out.println("Keluar : " + this.exit);
        System.out.println("Pieces : ");
        for (Piece piece : this.pieces) {
            System.out.println("\tType : " + piece.getType() + " , Coordinates : " + piece.getCoordinates() + " , Orientation : " + piece.getOrientation());
        }
        System.out.println("Board : ");
        for (int i = 0 ; i < this.height ; i++) {
            for (int j = 0 ; j < this.width ; j++) {
                System.out.print(board.getCell(i , j) + " ");
            }
            System.out.println();
        }
    }
}