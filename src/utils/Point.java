/* Kelompok   : Kelompok Tucil3_13523021_13523095                                */
/* Nama - 1   : Muhammad Raihan Nazhim Oktana                                    */
/* NIM - 1    : K01 - 13523021 - Teknik Informatika (IF-Ganesha) ITB             */
/* Nama - 2   : Rafif Farras                                                     */
/* NIM - 2    : K02 - 13523095 - Teknik Informatika (IF-Ganesha) ITB             */
/* Tanggal    : Senin, 19 Mei 2025                                               */
/* Tugas      : Tugas Kecil 3 - Strategi Algoritma (IF2211-24)                   */
/* File Path  : Tucil3_13523021_13523095/src/utils/Point.java                    */
/* Deskripsi  : F07B - Data Structure Point Utility                              */
/* PIC F07B   : K02 - 13523095 - Rafif Farras                                    */

// Package & Import
package utils;

// Class Definition & Implementation
public class Point {
    
    // Private Attributes
    private int x;
    private int y;
    
    public Point(int x , int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Point add(Point other) {
        return new Point(this.x + other.x , this.y + other.y);
    }

    public Point subtract(Point other) {
        return new Point(this.x - other.x , this.y - other.y);
    }

    @Override
    public String toString() {
        return "(" + x + " , " + y + ")";
    }
}
