/* Kelompok   : Kelompok Tucil3_13523021_13523095                                */
/* Nama - 1   : Muhammad Raihan Nazhim Oktana                                    */
/* NIM - 1    : K01 - 13523021 - Teknik Informatika (IF-Ganesha) ITB             */
/* Nama - 2   : Rafif Farras                                                     */
/* NIM - 2    : K02 - 13523095 - Teknik Informatika (IF-Ganesha) ITB             */
/* Tanggal    : Senin, 19 Mei 2025                                               */
/* Tugas      : Tugas Kecil 3 - Strategi Algoritma (IF2211-24)                   */
/* File Path  : Tucil3_13523021_13523095/src/utils/Piece.java                    */
/* Deskripsi  : F07C - Data Structure Piece Utility                              */
/* PIC F07C   : K02 - 13523095 - Rafif Farras                                    */

// Package & Import
package utils;
import java.util.List;

// Class Definition & Implementation
public class Piece {
    private char type;
    private List<Point> coordinates;
    private int orientation;

    public Piece(char type , List<Point> coordinates , int orientation) {
        this.type = type;
        this.coordinates = coordinates;
        this.orientation = orientation;
    }

    public char getType() {
        return this.type;
    }
    
    public List<Point> getCoordinates() {
        return this.coordinates;
    }

    public int getOrientation() {
        return this.orientation;
    }

    public void setType(char type) {
        this.type = type;
    }

    public void setCoordinates(List<Point> coordinates) {
        this.coordinates = coordinates;
    }

    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }
}
