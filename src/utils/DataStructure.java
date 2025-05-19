/* Kelompok   : Kelompok Tucil3_13523021_13523095                                */
/* Nama - 1   : Muhammad Raihan Nazhim Oktana                                    */
/* NIM - 1    : K01 - 13523021 - Teknik Informatika (IF-Ganesha) ITB             */
/* Nama - 2   : Rafif Farras                                                     */
/* NIM - 2    : K02 - 13523095 - Teknik Informatika (IF-Ganesha) ITB             */
/* Tanggal    : Selasa, 20 Mei 2025                                              */
/* Tugas      : Tugas Kecil 3 - Strategi Algoritma (IF2211-24)                   */
/* File Path  : Tucil3_13523021_13523095/src/utils/DataStructure.java            */
/* Deskripsi  : F07A - Data Structure Utility                                    */
/* PIC F07A   : K01 - 13523021 - Muhammad Raihan Nazhim Oktana                   */

// Package & Import
package utils;
import java.util.List;

// Class Definition & Implementation
public class DataStructure {
    // DESKRIPSI
    // Public Class DataStructure
    
    // KAMUS
    // DataStructure : Constructor Class DataStructure
    // getWidth , getHeight , getPieceCount , getExit , getBoard , getPieces : Procedure
    // setWidth , setHeight , setPieceCount , setExit , setBoard , setPieces : Procedure
    // displayDataStructure : Procedure

    // PRIVATE ATTRIBUTES
    private int width;
    private int height;
    private int pieceCount;
    private Point exit;
    private Board board;
    private List<Piece> pieces;
    
    public DataStructure(int width , int height , int pieceCount , Point exit , Board board , List<Piece> pieces) {
        // DESKRIPSI LOKAL
        // Instansiasi Constructor Class DataStructure
        
        // KAMUS LOKAL
        // pieces : List Of Class Piece
        // board : Class Board
        // exit : Class Point
        // width , height , pieceCount : Integer

        // ALGORITMA LOKAL
        this.width = width;
        this.height = height;
        this.pieceCount = pieceCount;
        this.exit = exit;
        this.board = board;
        this.pieces = pieces;
    }

    public int getWidth() {
        // DESKRIPSI LOKAL
        // Getter Width
        
        // KAMUS LOKAL
        // width : Integer

        // ALGORITMA LOKAL
        return this.width;
    }

    public int getHeight() {
        // DESKRIPSI LOKAL
        // Getter Height
        
        // KAMUS LOKAL
        // height : Integer

        // ALGORITMA LOKAL
        return this.height;
    }

    public int getPieceCount() {
        // DESKRIPSI LOKAL
        // Getter Piece Count
        
        // KAMUS LOKAL
        // pieceCount : Integer

        // ALGORITMA LOKAL
        return this.pieceCount;
    }

    public Point getExit() {
        // DESKRIPSI LOKAL
        // Getter Exit
        
        // KAMUS LOKAL
        // exit : Class Point

        // ALGORITMA LOKAL
        return this.exit;
    }

    public Board getBoard() {
        // DESKRIPSI LOKAL
        // Getter Board
        
        // KAMUS LOKAL
        // board : Class Board

        // ALGORITMA LOKAL
        return this.board;
    }

    public List<Piece> getPieces() {
        // DESKRIPSI LOKAL
        // Getter Pieces
        
        // KAMUS LOKAL
        // pieces : List Of Class Piece

        // ALGORITMA LOKAL
        return this.pieces;
    }
   
    public void setWidth(int width) {
        // DESKRIPSI LOKAL
        // Setter Width
        
        // KAMUS LOKAL
        // width : Integer

        // ALGORITMA LOKAL
        this.width = width;
    }

    public void setHeight(int height) {
        // DESKRIPSI LOKAL
        // Setter Height
        
        // KAMUS LOKAL
        // height : Integer

        // ALGORITMA LOKAL
        this.height = height;
    }

    public void setPieceCount(int pieceCount) {
        // DESKRIPSI LOKAL
        // Setter Piece Count
        
        // KAMUS LOKAL
        // pieceCount : Integer

        // ALGORITMA LOKAL
        this.pieceCount = pieceCount;
    }

    public void setExit(Point exit) {
        // DESKRIPSI LOKAL
        // Setter Exit
        
        // KAMUS LOKAL
        // exit : Class Point

        // ALGORITMA LOKAL
        this.exit = exit;
    }

    public void setBoard(Board board) {
        // DESKRIPSI LOKAL
        // Setter Board
        
        // KAMUS LOKAL
        // board : Class Board

        // ALGORITMA LOKAL
        this.board = board;
    }

    public void setPieces(List<Piece> pieces) {
        // DESKRIPSI LOKAL
        // Setter Pieces
        
        // KAMUS LOKAL
        // pieces : List Of Class Piece

        // ALGORITMA LOKAL
        this.pieces = pieces;
    }

    public void displayDataStructure() {
        // DESKRIPSI LOKAL
        // Display Data Structure CLI Terminal
        
        // KAMUS LOKAL
        // pieces : List Of Class Piece
        // piece : Class Piece
        // board : Class Board
        // exit : Class Point
        // width , height , pieceCount , i , j : Integer

        // ALGORITMA LOKAL
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