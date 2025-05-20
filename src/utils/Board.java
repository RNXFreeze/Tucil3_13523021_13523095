/* Kelompok   : Kelompok Tucil3_13523021_13523095                                */
/* Nama - 1   : Muhammad Raihan Nazhim Oktana                                    */
/* NIM - 1    : K01 - 13523021 - Teknik Informatika (IF-Ganesha) ITB             */
/* Nama - 2   : Rafif Farras                                                     */
/* NIM - 2    : K02 - 13523095 - Teknik Informatika (IF-Ganesha) ITB             */
/* Tanggal    : Rabu, 21 Mei 2025                                                */
/* Tugas      : Tugas Kecil 3 - Strategi Algoritma (IF2211-24)                   */
/* File Path  : Tucil3_13523021_13523095/src/utils/Board.java                    */
/* Deskripsi  : F07D - Data Structure Board Utility                              */
/* PIC F07D   : K02 - 13523095 - Rafif Farras                                    */

// Package & Import
package utils;

// Class Definition & Implementation
public class Board {
    // DESKRIPSI
    // Public Class Board
    
    // KAMUS
    // Board : Constructor Class Board
    // getGrid , getCell , getWidth , getHeight , setGrid , setCell , setWidth , setHeight : Procedure

    // PRIVATE ATTRIBUTES
    private char[][] grid;
    private int width;
    private int height;

    public Board(int width , int height) {
        // DESKRIPSI LOKAL
        // Instansiasi Constructor Class Board 1
        
        // KAMUS LOKAL
        // grid : Matrix of Character
        // width , height : Integer

        // ALGORITMA LOKAL
        this.width = width;
        this.height = height;
        this.grid = new char[height][width];
    }

    public Board(char[][] grid) {
        // DESKRIPSI LOKAL
        // Instansiasi Constructor Class Board 2
        
        // KAMUS LOKAL
        // grid : Matrix of Character
        // width , height : Integer

        // ALGORITMA LOKAL
        this.grid = grid;
        this.height = grid.length;
        this.width = grid[0].length;
    }

    public Board(Board board) {
        // DESKRIPSI LOKAL
        // Instansiasi Constructor Class Board 3
        
        // KAMUS LOKAL
        // grid : Matrix of Character
        // width , height : Integer

        // ALGORITMA LOKAL
        this.width = board.getWidth();
        this.height = board.getHeight();
        this.grid = new char[this.height][this.width];
        for (int i = 0 ; i < this.height ; i++) {
            System.arraycopy(board.getGrid()[i] , 0 , this.grid[i] , 0 , width);
        }
    }

    public char[][] getGrid() {
        // DESKRIPSI LOKAL
        // Getter Grid
        
        // KAMUS LOKAL
        // grid : Matrix of Character

        // ALGORITMA LOKAL
        return this.grid;
    }

    public char getCell(int x , int y) {
        // DESKRIPSI LOKAL
        // Getter Cell
        
        // KAMUS LOKAL
        // grid : Matrix of Character
        // x , y : Integer

        // ALGORITMA LOKAL
        return this.grid[y][x];
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

    public void setGrid(char[][] grid) {
        // DESKRIPSI LOKAL
        // Setter Grid
        
        // KAMUS LOKAL
        // grid : Matrix of Character

        // ALGORITMA LOKAL
        this.grid = grid;
    }

    public void setCell(int x , int y , char value) {
        // DESKRIPSI LOKAL
        // Setter Cell
        
        // KAMUS LOKAL
        // grid : Matrix of Character
        // x , y : Integer
        // value : Character

        // ALGORITMA LOKAL
        this.grid[y][x] = value;
    }

    public void setWidth(int width) {
        // DESKRIPSI LOKAL
        // Getter Width
        
        // KAMUS LOKAL
        // width : Integer

        // ALGORITMA LOKAL
        this.width = width;
    }

    public void setHeight(int height) {
        // DESKRIPSI LOKAL
        // Getter Height
        
        // KAMUS LOKAL
        // height : Integer

        // ALGORITMA LOKAL
        this.height = height;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int y = 0 ; y < this.height ; y++) {
            for (int x = 0 ; x < this.width ; x++) {
                sb.append(grid[y][x]).append(' ');
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}