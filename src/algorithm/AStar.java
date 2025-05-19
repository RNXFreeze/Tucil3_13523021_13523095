/* Kelompok   : Kelompok Tucil3_13523021_13523095                                */
/* Nama - 1   : Muhammad Raihan Nazhim Oktana                                    */
/* NIM - 1    : K01 - 13523021 - Teknik Informatika (IF-Ganesha) ITB             */
/* Nama - 2   : Rafif Farras                                                     */
/* NIM - 2    : K02 - 13523095 - Teknik Informatika (IF-Ganesha) ITB             */
/* Tanggal    : Senin, 19 Mei 2025                                               */
/* Tugas      : Tugas Kecil 3 - Strategi Algoritma (IF2211-24)                   */
/* File Path  : Tucil3_13523021_13523095/src/algorithm/AStar.java                */
/* Deskripsi  : F04 - AStar Pathfinding Algorithm                                */
/* PIC F04    : K02 - 13523095 - Rafif Farras                                    */

// Package & Import
package algorithm;
import utils.*;
import game.*;

// Class Definition & Implementation
public class AStar {
    // DESKRIPSI
    // Public Class AStar
    
    // KAMUS
    // AStar : Constructor Class AStar
    // solveAStar , solveAStar1 , solveAStar2 , solveAStar3 : Function

    private AStar() {
        // DESKRIPSI LOKAL
        // Instansiasi Constructor Class AStar
        
        // KAMUS LOKAL
        // None

        // ALGORITMA LOKAL
        // None
    }

    public static void solveAStar(DataStructure dataStructure , int num) {
        // DESKRIPSI LOKAL
        // Fungsi Utama AStar : Menyelesaikan pencarian jalur terpendek dari dataStructure dan tipe heuristiknya.
        
        // KAMUS LOKAL
        // dataStructure : Class DataStructure
        // solveAStar1 , solveAStar2 , solveAStar3 : Function
        // num : Integer

        // ALGORITMA LOKAL
        if (num == 1) {
            return solveAStar1(dataStructure);
        } else if (num == 2) {
            return solveAStar2(dataStructure);
        } else {
            return solveAStar3(dataStructure);
        }
    }

    private static void solveAStar1(DataStructure dataStructure) {
        // DESKRIPSI LOKAL
        // AStar 1 : Menyelesaikan pencarian jalur terpendek dari dataStructure dengan menggunakan AStar Heuristik 1.
        
        // KAMUS LOKAL
        // dataStructure : Class DataStructure
        // ...

        // ALGORITMA LOKAL
        // ...
    }

    private static void solveAStar2(DataStructure dataStructure) {
        // DESKRIPSI LOKAL
        // AStar 2 : Menyelesaikan pencarian jalur terpendek dari dataStructure dengan menggunakan AStar Heuristik 2.
        
        // KAMUS LOKAL
        // dataStructure : Class DataStructure
        // ...

        // ALGORITMA LOKAL
        // ...
    }

    private static void solveAStar3(DataStructure dataStructure) {
        // DESKRIPSI LOKAL
        // AStar 3 : Menyelesaikan pencarian jalur terpendek dari dataStructure dengan menggunakan AStar Heuristik 3.
        
        // KAMUS LOKAL
        // dataStructure : Class DataStructure
        // ...

        // ALGORITMA LOKAL
        // ...
    }
}