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
    private List<Piece> pieces;
    private char[][] board;
    private Point exit;
    
    public DataStructure(int width , int height , int pieceCount , List<Piece> pieces , char[][] board , Point exit) {
        this.width = width;
        this.height = height;
        this.pieceCount = pieceCount;
        this.pieces = pieces;
        this.board = board;
        this.exit = exit;
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

    public List<Piece> getPieces() {
        return pieces;
    }

    public char[][] getBoard() {
        return board;
    }

    public Point getExit() {
        return exit;
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

    public void setPieces(List<Piece> pieces) {
        this.pieces = pieces;
    }

    public void setBoard(char[][] board) {
        this.board = board;
    }

    public void setExit(Point exit) {
        this.exit = exit;
    }
}