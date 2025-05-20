/* Kelompok   : Kelompok Tucil3_13523021_13523095                                */
/* Nama - 1   : Muhammad Raihan Nazhim Oktana                                    */
/* NIM - 1    : K01 - 13523021 - Teknik Informatika (IF-Ganesha) ITB             */
/* Nama - 2   : Rafif Farras                                                     */
/* NIM - 2    : K02 - 13523095 - Teknik Informatika (IF-Ganesha) ITB             */
/* Tanggal    : Rabu, 21 Mei 2025                                                */
/* Tugas      : Tugas Kecil 3 - Strategi Algoritma (IF2211-24)                   */
/* File Path  : Tucil3_13523021_13523095/src/utils/Point.java                    */
/* Deskripsi  : F07B - Data Structure Point Utility                              */
/* PIC F07B   : K02 - 13523095 - Rafif Farras                                    */

// Package & Import
package utils;
import java.util.*;

// Class Definition & Implementation
public class Point {
    // DESKRIPSI
    // Public Class Point
    
    // KAMUS
    // Point : Constructor Class Point
    // getX , getY , setX , setY , add , subtract , toString : Procedure

    // PRIVATE ATTRIBUTES
    private int x;
    private int y;
    
    public Point(int x , int y) {
        // DESKRIPSI LOKAL
        // Instansiasi Constructor Class Point
        
        // KAMUS LOKAL
        // x , y : Integer

        // ALGORITMA LOKAL
        this.x = x;
        this.y = y;
    }

    public int getX() {
        // DESKRIPSI LOKAL
        // Getter X
        
        // KAMUS LOKAL
        // x : Integer

        // ALGORITMA LOKAL
        return this.x;
    }

    public int getY() {
        // DESKRIPSI LOKAL
        // Getter Y
        
        // KAMUS LOKAL
        // y : Integer

        // ALGORITMA LOKAL
        return this.y;
    }

    public void setX(int x) {
        // DESKRIPSI LOKAL
        // Setter X
        
        // KAMUS LOKAL
        // x : Integer

        // ALGORITMA LOKAL
        this.x = x;
    }

    public void setY(int y) {
        // DESKRIPSI LOKAL
        // Getter Y
        
        // KAMUS LOKAL
        // y : Integer

        // ALGORITMA LOKAL
        this.y = y;
    }

    public Point add(Point other) {
        // DESKRIPSI LOKAL
        // Menjumlahkan 2 Point
        
        // KAMUS LOKAL
        // x , y : Integer

        // ALGORITMA LOKAL
        return new Point(this.x + other.x , this.y + other.y);
    }

    public Point subtract(Point other) {
        // DESKRIPSI LOKAL
        // Mengurangi 2 Point
        
        // KAMUS LOKAL
        // x , y : Integer

        // ALGORITMA LOKAL
        return new Point(this.x - other.x , this.y - other.y);
    }

    @Override
    public String toString() {
        // DESKRIPSI LOKAL
        // Mengubah Point menjadi String
        
        // KAMUS LOKAL
        // x , y : Integer

        // ALGORITMA LOKAL
        return "(" + this.x + " , " + this.y + ")";
    }

    @Override
    public boolean equals(Object obj) {
        // DESKRIPSI LOKAL
        // Melakukan override fungsi equals untuk mengecek kesamaan 2 Object Class Point.
        
        // KAMUS LOKAL
        // obj : Object Class Point
        // other : Class Point
        // x , y : Integer

        // ALGORITMA LOKAL
        if (this == obj) {
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            return false;
        } else {
            Point other = (Point) obj;
            return ((x == other.x) && (y == other.y));
        }
    }

    @Override
    public int hashCode() {
        // DESKRIPSI LOKAL
        // Melakukan override fungsi hashCode untuk menghitung nilai hashnya.
        
        // KAMUS LOKAL
        // x , y : Integer

        // ALGORITMA LOKAL
        return Objects.hash(this.x , this.y);
    }
}