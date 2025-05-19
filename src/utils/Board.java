/* Kelompok   : Kelompok Tucil3_13523021_13523095                                */
/* Nama - 1   : Muhammad Raihan Nazhim Oktana                                    */
/* NIM - 1    : K01 - 13523021 - Teknik Informatika (IF-Ganesha) ITB             */
/* Nama - 2   : Rafif Farras                                                     */
/* NIM - 2    : K02 - 13523095 - Teknik Informatika (IF-Ganesha) ITB             */
/* Tanggal    : Senin, 19 Mei 2025                                               */
/* Tugas      : Tugas Kecil 3 - Strategi Algoritma (IF2211-24)                   */
/* File Path  : Tucil3_13523021_13523095/src/utils/Board.java                    */
/* Deskripsi  : F06B - Data Structure Board Utility                              */
/* PIC F06B   : K02 - 13523095 - Rafif Farras                                    */

package utils;

public class Board {
    private char[][] grid;
    private int width;
    private int height;

    public Board(int width , int height) {
        this.width = width;
        this.height = height;
        this.grid = new char[height][width];
    }

    public Board(char[][] grid) {
        this.grid = grid;
        this.height = grid.length;
        this.width = grid[0].length;
    }

    public Board(Board board) {
        this.width = board.getWidth();
        this.height = board.getHeight();
        this.grid = new char[height][width];
        for (int i = 0; i < height; i++) {
            System.arraycopy(board.getGrid()[i] , 0 , this.grid[i] , 0 , width);
        }
    }

    public char[][] getGrid() {
        return this.grid;
    }

    public char getCell(int x , int y) {
        return this.grid[y][x];
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public void setGrid(char[][] grid) {
        this.grid = grid;
    }

    public void setCell(int x , int y , char value) {
        this.grid[y][x] = value;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
