/* Kelompok   : Kelompok Tucil3_13523021_13523095                                */
/* Nama - 1   : Muhammad Raihan Nazhim Oktana                                    */
/* NIM - 1    : K01 - 13523021 - Teknik Informatika (IF-Ganesha) ITB             */
/* Nama - 2   : Rafif Farras                                                     */
/* NIM - 2    : K02 - 13523095 - Teknik Informatika (IF-Ganesha) ITB             */
/* Tanggal    : Senin, 19 Mei 2025                                               */
/* Tugas      : Tugas Kecil 3 - Strategi Algoritma (IF2211-24)                   */
/* File Path  : Tucil3_13523021_13523095/src/algorithm/GreedyBFS.java            */
/* Deskripsi  : F02 - Greedy BFS (Best First Search) Pathfinding Algorithm       */
/* PIC F02    : K01 - 13523021 - Muhammad Raihan Nazhim Oktana                   */

// Package & Import
package algorithm;
import utils.*;
import game.*;

// Class Definition & Implementation
public class GreedyBFS {
    // DESKRIPSI
    // Public Class GreedyBFS
    
    // KAMUS
    // GreedyBFS : Constructor Class GreedyBFS
    // solveGreedyBFS , solveGreedyBFS1 , solveGreedyBFS2 , solveGreedyBFS3 : Function

    private GreedyBFS() {
        // DESKRIPSI LOKAL
        // Instansiasi Constructor Class GreedyBFS
        
        // KAMUS LOKAL
        // None

        // ALGORITMA LOKAL
        // None
    }

    public static void solveGreedyBFS(DataStructure dataStructure , int num) {
        // DESKRIPSI LOKAL
        // Fungsi Utama GreedyBFS : Menyelesaikan pencarian jalur terpendek dari dataStructure dan tipe heuristiknya.
        
        // KAMUS LOKAL
        // dataStructure : Class DataStructure
        // solveGreedyBFS1 , solveGreedyBFS2 , solveGreedyBFS3 : Function
        // num : Integer

        // ALGORITMA LOKAL
        if (num == 1) {
            return solveGreedyBFS1(dataStructure);
        } else if (num == 2) {
            return solveGreedyBFS2(dataStructure);
        } else {
            return solveGreedyBFS3(dataStructure);
        }
    }

    private static void solveGreedyBFS1(DataStructure dataStructure) {
        // DESKRIPSI LOKAL
        // GreedyBFS 1 : Menyelesaikan pencarian jalur terpendek dari dataStructure dengan menggunakan GreedyBFS Heuristik 1.
        
        // KAMUS LOKAL
        // dataStructure : Class DataStructure
        // ...

        // ALGORITMA LOKAL
        // ...
    }

    private static void solveGreedyBFS2(DataStructure dataStructure) {
        // DESKRIPSI LOKAL
        // GreedyBFS 2 : Menyelesaikan pencarian jalur terpendek dari dataStructure dengan menggunakan GreedyBFS Heuristik 2.
        
        // KAMUS LOKAL
        // dataStructure : Class DataStructure
        // ...

        // ALGORITMA LOKAL
        // ...
    }

    private static void solveGreedyBFS3(DataStructure dataStructure) {
        // DESKRIPSI LOKAL
        // GreedyBFS 3 : Menyelesaikan pencarian jalur terpendek dari dataStructure dengan menggunakan GreedyBFS Heuristik 3.
        
        // KAMUS LOKAL
        // dataStructure : Class DataStructure
        // ...

        // ALGORITMA LOKAL
        // ...
    }
}