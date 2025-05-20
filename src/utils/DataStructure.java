/* Kelompok   : Kelompok Tucil3_13523021_13523095                                */
/* Nama - 1   : Muhammad Raihan Nazhim Oktana                                    */
/* NIM - 1    : K01 - 13523021 - Teknik Informatika (IF-Ganesha) ITB             */
/* Nama - 2   : Rafif Farras                                                     */
/* NIM - 2    : K02 - 13523095 - Teknik Informatika (IF-Ganesha) ITB             */
/* Tanggal    : Rabu, 21 Mei 2025                                                */
/* Tugas      : Tugas Kecil 3 - Strategi Algoritma (IF2211-24)                   */
/* File Path  : Tucil3_13523021_13523095/src/utils/DataStructure.java            */
/* Deskripsi  : F07A - Data Structure Utility                                    */
/* PIC F07A   : K01 - 13523021 - Muhammad Raihan Nazhim Oktana                   */

// Package & Import
package utils;
import algorithm.Solution;
import java.util.*;

// Class Definition & Implementation
public class DataStructure {
    // DESKRIPSI
    // Public Class DataStructure
    
    // KAMUS
    // DataStructure : Constructor Class DataStructure
    // getWidth , getHeight , getPieceCount , getExit , getBoard , getPieces : Procedure
    // setWidth , setHeight , setPieceCount , setExit , setBoard , setPieces : Procedure
    // displayBoard , displayLastBoard , displayDataStructure : Procedure

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

    public void displayBoard() {
        // DESKRIPSI LOKAL
        // Display Board From Data Structure To CLI Terminal
        
        // KAMUS LOKAL
        // board : Class Board
        // exit : Class Point
        // width , height , i , j : Integer

        // ALGORITMA LOKAL
        if (this.exit.getX() == -1) {
            for (int i = 0 ; i < this.height ; i++) {
                if (this.height - 1 - this.exit.getY() == i) {
                    System.out.print("K ");
                } else {
                    System.out.print("  ");
                }
                for (int j = 0 ; j < this.width ; j++) {
                    System.out.print(this.board.getCell(j , i) + " ");
                }
                System.out.println();
            }
        } else if (this.exit.getY() == -1) {
            for (int i = 0 ; i < this.height ; i++) {
                for (int j = 0 ; j < this.width ; j++) {
                    System.out.print(this.board.getCell(j , i) + " ");
                }
                System.out.println();
            }
            for (int i = 0 ; i < this.exit.getX() ; i++) {
                System.out.print("  ");
            }
            System.out.println("K");
        } else if (this.exit.getY() == this.height) {
            for (int i = 0 ; i < this.exit.getX() ; i++) {
                System.out.print("  ");
            }
            System.out.println("K");
            for (int i = 0 ; i < this.height ; i++) {
                for (int j = 0 ; j < this.width ; j++) {
                    System.out.print(this.board.getCell(j , i) + " ");
                }
                System.out.println();
            }
        } else {
            for (int i = 0 ; i < this.height ; i++) {
                for (int j = 0 ; j < this.width ; j++) {
                    System.out.print(this.board.getCell(j , i) + " ");
                }
                if (this.height - 1 - this.exit.getY() == i) {
                    System.out.print("K");
                }
                System.out.println();
            }
        }
    }

    public void displayLastBoard() {
        // DESKRIPSI LOKAL
        // Display Last Board From Data Structure To CLI Terminal
        
        // KAMUS LOKAL
        // board : Class Board
        // exit : Class Point
        // width , height , i , j : Integer

        // ALGORITMA LOKAL
        if (this.exit.getX() == -1) {
            for (int i = 0 ; i < this.height ; i++) {
                for (int j = 0 ; j < this.pieces.stream().filter(pc -> pc.getType() == 'P').findFirst().orElseThrow().solveSize() ; j++) {
                    if (this.height - 1 - this.exit.getY() == i) {
                        System.out.print(Solution.ANSI_BACKGROUND_GREEN + Solution.ANSI_BOLD + Solution.ANSI_CYAN + "P " + Solution.ANSI_RESET);
                    } else {
                        System.out.print("  ");
                    }
                }
                for (int j = 0 ; j < this.width ; j++) {
                    if (this.board.getCell(j , i) == 'P') {
                        System.out.print(Solution.ANSI_BACKGROUND_RED + "." + Solution.ANSI_RESET + " ");
                    } else {
                        System.out.print(this.board.getCell(j , i) + " ");
                    }
                }
                System.out.println();
            }
        } else if (this.exit.getY() == -1) {
            for (int i = 0 ; i < this.height ; i++) {
                for (int j = 0 ; j < this.width ; j++) {
                    if (this.board.getCell(j , i) == 'P') {
                        System.out.print(Solution.ANSI_BACKGROUND_RED + "." + Solution.ANSI_RESET + " ");
                    } else {
                        System.out.print(this.board.getCell(j , i) + " ");
                    }
                }
                System.out.println();
            }
            for (int i = 0 ; i < this.pieces.stream().filter(pc -> pc.getType() == 'P').findFirst().orElseThrow().solveSize() ; i++) {
                for (int j = 0 ; j < this.exit.getX() ; j++) {
                    System.out.print("  ");
                }
                System.out.println(Solution.ANSI_BACKGROUND_GREEN + Solution.ANSI_BOLD + Solution.ANSI_CYAN + "P " + Solution.ANSI_RESET);
            }
        } else if (this.exit.getY() == this.height) {
            for (int i = 0 ; i < this.pieces.stream().filter(pc -> pc.getType() == 'P').findFirst().orElseThrow().solveSize() ; i++) {
                for (int j = 0 ; j < this.exit.getX() ; j++) {
                    System.out.print("  ");
                }
                System.out.println(Solution.ANSI_BACKGROUND_GREEN + Solution.ANSI_BOLD + Solution.ANSI_CYAN + "P " + Solution.ANSI_RESET);
            }
            for (int i = 0 ; i < this.height ; i++) {
                for (int j = 0 ; j < this.width ; j++) {
                    if (this.board.getCell(j , i) == 'P') {
                        System.out.print(Solution.ANSI_BACKGROUND_RED + "." + Solution.ANSI_RESET + " ");
                    } else {
                        System.out.print(this.board.getCell(j , i) + " ");
                    }
                }
                System.out.println();
            }
        } else {
            for (int i = 0 ; i < this.height ; i++) {
                for (int j = 0 ; j < this.width ; j++) {
                    if (this.board.getCell(j , i) == 'P') {
                        System.out.print(Solution.ANSI_BACKGROUND_RED + "." + Solution.ANSI_RESET + " ");
                    } else {
                        System.out.print(this.board.getCell(j , i) + " ");
                    }
                }
                if (this.height - 1 - this.exit.getY() == i) {
                    for (int j = 0 ; j < this.pieces.stream().filter(pc -> pc.getType() == 'P').findFirst().orElseThrow().solveSize() ; j++) {
                        System.out.print(Solution.ANSI_BACKGROUND_GREEN + Solution.ANSI_BOLD + Solution.ANSI_CYAN + "P " + Solution.ANSI_RESET);
                    }
                }
                System.out.println();
            }
        }
        System.out.println("\nNotes :");
        System.out.println(Solution.ANSI_BACKGROUND_RED + " " + Solution.ANSI_RESET + "  : Old Position Piece P");
        System.out.println(Solution.ANSI_BACKGROUND_GREEN + "P " + Solution.ANSI_RESET + " : New Position Piece P");
        System.out.println(Solution.ANSI_BOLD + Solution.ANSI_CYAN + "P" + Solution.ANSI_RESET + "  : Primary Piece");
        System.out.println(Solution.ANSI_BOLD + Solution.ANSI_PURPLE + "K" + Solution.ANSI_RESET + "  : Exit Position");
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
        System.out.println("Width Size    : " + this.width);
        System.out.println("Height Size   : " + this.height);
        System.out.println("Piece Count   : " + this.pieceCount);
        Point exitPoint = new Point(this.exit.getX() , this.exit.getY());
        if (this.exit.getY() == -1) {
            exitPoint.setY(this.height);
        } else if (this.exit.getY() == this.height) {
            exitPoint.setY(-1);
        } else {
            exitPoint.setY(this.height - 1 - this.exit.getY());
        }
        System.out.println("Exit Position : " + exitPoint);
        System.out.println("Pieces :");
        for (Piece piece : this.pieces) {
            if (piece.getType() == '.') {
                System.out.println("  Type : " + piece.getType() + " , Coordinates : [Other]" + " , Orientation : Point Dot Blank Space (-)");
            } else {
                if (piece.getOrientation() == 0) {
                    System.out.println("  Type : " + piece.getType() + " , Coordinates : " + piece.getCoordinates() + " , Orientation : Horizontal (0)");
                } else {
                    System.out.println("  Type : " + piece.getType() + " , Coordinates : " + piece.getCoordinates() + " , Orientation : Vertical (1)");
                }
            }
        }
        System.out.println("Puzzle Board :");
        this.displayBoard();
    }
}