/* Kelompok   : Kelompok Tucil3_13523021_13523095                                */
/* Nama - 1   : Muhammad Raihan Nazhim Oktana                                    */
/* NIM - 1    : K01 - 13523021 - Teknik Informatika (IF-Ganesha) ITB             */
/* Nama - 2   : Rafif Farras                                                     */
/* NIM - 2    : K02 - 13523095 - Teknik Informatika (IF-Ganesha) ITB             */
/* Tanggal    : Selasa, 20 Mei 2025                                              */
/* Tugas      : Tugas Kecil 3 - Strategi Algoritma (IF2211-24)                   */
/* File Path  : Tucil3_13523021_13523095/src/utils/Piece.java                    */
/* Deskripsi  : F07C - Data Structure Piece Utility                              */
/* PIC F07C   : K02 - 13523095 - Rafif Farras                                    */

// Package & Import
package utils;
import java.util.List;

// Class Definition & Implementation
public class Piece {
    // DESKRIPSI
    // Public Class Piece
    
    // KAMUS
    // Piece : Constructor Class Piece
    // getType , getCoordinates , getOrientation , setType , setCoordinates , setOrientation : Procedure

    // PRIVATE ATTRIBUTES
    private char type;
    private List<Point> coordinates;
    private int orientation;

    public Piece(char type , List<Point> coordinates , int orientation) {
        // DESKRIPSI LOKAL
        // Instansiasi Constructor Class Piece
        
        // KAMUS LOKAL
        // type : Character
        // coordinates : List Of Class Point
        // orientation : Integer

        // ALGORITMA LOKAL
        this.type = type;
        this.coordinates = coordinates;
        this.orientation = orientation;
    }

    public char getType() {
        // DESKRIPSI LOKAL
        // Getter Type
        
        // KAMUS LOKAL
        // type : Character

        // ALGORITMA LOKAL
        return this.type;
    }
    
    public List<Point> getCoordinates() {
        // DESKRIPSI LOKAL
        // Getter Coordinates
        
        // KAMUS LOKAL
        // coordinates : List Of Class Point

        // ALGORITMA LOKAL
        return this.coordinates;
    }

    public int getOrientation() {
        // DESKRIPSI LOKAL
        // Getter Orientation
        
        // KAMUS LOKAL
        // orientation : Integer

        // ALGORITMA LOKAL
        return this.orientation;
    }

    public void setType(char type) {
        // DESKRIPSI LOKAL
        // Setter Type
        
        // KAMUS LOKAL
        // type : Character

        // ALGORITMA LOKAL
        this.type = type;
    }

    public void setCoordinates(List<Point> coordinates) {
        // DESKRIPSI LOKAL
        // Setter Coordinates
        
        // KAMUS LOKAL
        // coordinates : List Of Class Point

        // ALGORITMA LOKAL
        this.coordinates = coordinates;
    }

    public void setOrientation(int orientation) {
        // DESKRIPSI LOKAL
        // Setter Orientation
        
        // KAMUS LOKAL
        // orientation : Integer

        // ALGORITMA LOKAL
        this.orientation = orientation;
    }
}
