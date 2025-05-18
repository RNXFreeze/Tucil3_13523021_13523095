/* Kelompok   : Kelompok Tucil3_13523021_13523095                                */
/* Nama - 1   : Muhammad Raihan Nazhim Oktana                                    */
/* NIM - 1    : K01 - 13523021 - Teknik Informatika (IF-Ganesha) ITB             */
/* Nama - 2   : Rafif Farras                                                     */
/* NIM - 2    : K02 - 13523095 - Teknik Informatika (IF-Ganesha) ITB             */
/* Tanggal    : Senin, 19 Mei 2025                                               */
/* Tugas      : Tugas Kecil 3 - Strategi Algoritma (IF2211-24)                   */
/* File Path  : Tucil3_13523021_13523095/src/utils/DataStructure.java            */
/* Deskripsi  : F06 - Data Structure Utility                                     */
/* PIC F06    : K01 - 13523021 - Muhammad Raihan Nazhim Oktana                   */

package utils;

public class DataStructure {
    private int[][] grid;
    private int rows;
    private int cols;

    public DataStructure(int rows , int cols) {
        this.rows = rows;
        this.cols = cols;
        this.grid = new int[rows][cols];
    }

    public void setCell(int r, int c, int value) {
        grid[r][c] = value;
    }

    public int getCell(int r, int c) {
        return grid[r][c];
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public enum Direction {UP , DOWN , LEFT , RIGHT}
    public enum Orientation {HORIZONTAL , VERTICAL}
    public record Pos(int r , int c) {

    }
}
