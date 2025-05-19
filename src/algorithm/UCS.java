/* Kelompok   : Kelompok Tucil3_13523021_13523095                                */
/* Nama - 1   : Muhammad Raihan Nazhim Oktana                                    */
/* NIM - 1    : K01 - 13523021 - Teknik Informatika (IF-Ganesha) ITB             */
/* Nama - 2   : Rafif Farras                                                     */
/* NIM - 2    : K02 - 13523095 - Teknik Informatika (IF-Ganesha) ITB             */
/* Tanggal    : Senin, 19 Mei 2025                                               */
/* Tugas      : Tugas Kecil 3 - Strategi Algoritma (IF2211-24)                   */
/* File Path  : Tucil3_13523021_13523095/src/algorithm/UCS.java                  */
/* Deskripsi  : F03 - UCS (Uniform Cost Search) Pathfinding Algorithm            */
/* PIC F03    : K01 - 13523021 - Muhammad Raihan Nazhim Oktana                   */

// Package & Import
package algorithm;
import utils.*;
import game.*;

// Class Definition & Implementation
public class UCS {
    // DESKRIPSI
    // Public Class UCS
    
    // KAMUS
    // UCS : Constructor Class UCS
    // solveUCS , solveUCS1 , solveUCS2 , solveUCS3 : Function

    private UCS() {
        // DESKRIPSI LOKAL
        // Instansiasi Constructor Class UCS
        
        // KAMUS LOKAL
        // None

        // ALGORITMA LOKAL
        // None
    }

    public static void solveUCS(DataStructure dataStructure , int num) {
        // DESKRIPSI LOKAL
        // Fungsi Utama UCS : Menyelesaikan pencarian jalur terpendek dari dataStructure dan tipe heuristiknya.
        
        // KAMUS LOKAL
        // dataStructure : Class DataStructure
        // solveUCS1 , solveUCS2 , solveUCS3 : Function
        // num : Integer

        // ALGORITMA LOKAL
        if (num == 1) {
            return solveUCS1(dataStructure);
        } else if (num == 2) {
            return solveUCS2(dataStructure);
        } else {
            return solveUCS3(dataStructure);
        }
    }

    private static void solveUCS1(DataStructure dataStructure) {
        // DESKRIPSI LOKAL
        // UCS 1 : Menyelesaikan pencarian jalur terpendek dari dataStructure dengan menggunakan UCS Heuristik 1.
        
        // KAMUS LOKAL
        // dataStructure : Class DataStructure
        // ...

        // ALGORITMA LOKAL
        // ...
    }

    private static void solveUCS2(DataStructure dataStructure) {
        // DESKRIPSI LOKAL
        // UCS 2 : Menyelesaikan pencarian jalur terpendek dari dataStructure dengan menggunakan UCS Heuristik 2.
        
        // KAMUS LOKAL
        // dataStructure : Class DataStructure
        // ...

        // ALGORITMA LOKAL
        // ...
    }

    private static void solveUCS3(DataStructure dataStructure) {
        // DESKRIPSI LOKAL
        // UCS 3 : Menyelesaikan pencarian jalur terpendek dari dataStructure dengan menggunakan UCS Heuristik 3.
        
        // KAMUS LOKAL
        // dataStructure : Class DataStructure
        // ...

        // ALGORITMA LOKAL
        // ...
    }
}