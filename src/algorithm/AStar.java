/* Kelompok   : Kelompok Tucil3_13523021_13523095                                */
/* Nama - 1   : Muhammad Raihan Nazhim Oktana                                    */
/* NIM - 1    : K01 - 13523021 - Teknik Informatika (IF-Ganesha) ITB             */
/* Nama - 2   : Rafif Farras                                                     */
/* NIM - 2    : K02 - 13523095 - Teknik Informatika (IF-Ganesha) ITB             */
/* Tanggal    : Selasa, 20 Mei 2025                                              */
/* Tugas      : Tugas Kecil 3 - Strategi Algoritma (IF2211-24)                   */
/* File Path  : Tucil3_13523021_13523095/src/algorithm/AStar.java                */
/* Deskripsi  : F04 - AStar Pathfinding Algorithm                                */
/* PIC F04    : K02 - 13523095 - Rafif Farras                                    */

// Package & Import
package algorithm;
import utils.*;

// Class Definition & Implementation
public class AStar {
    // DESKRIPSI
    // Public Class AStar
    
    // KAMUS
    // AStar : Constructor Class AStar
    // solveAStar : Function

    // PRIVATE ATTRIBUTES
    // None
    
    private AStar() {
        // DESKRIPSI LOKAL
        // Instansiasi Constructor Class AStar
        
        // KAMUS LOKAL
        // None

        // ALGORITMA LOKAL
        // None
    }

    public static Solution solveAStar(DataStructure dataStructure , int num) {
        // DESKRIPSI LOKAL
        // Fungsi Utama AStar : Menyelesaikan pencarian jalur terpendek dari dataStructure dan tipe heuristiknya.
        // AStar : Menyelesaikan pencarian jalur terpendek dengan algoritma AStar dan modifikasi heuristik.
        
        // KAMUS LOKAL
        // dataStructure : Class DataStructure
        // cur : Class Solution Sub Class Node
        // startTime , endTime : Long
        // num , cnt : Integer

        // ALGORITMA LOKAL
        long startTime = System.nanoTime();
        int cnt = 0;
        Solution.Node cur = null;
        long endTime = System.nanoTime();
        double time = (endTime - startTime) / 1000000;
        return Solution.buildSolution("A-Star" , num , cnt , time , cur);
    }
}