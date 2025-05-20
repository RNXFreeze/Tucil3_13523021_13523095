/* Kelompok   : Kelompok Tucil3_13523021_13523095                                */
/* Nama - 1   : Muhammad Raihan Nazhim Oktana                                    */
/* NIM - 1    : K01 - 13523021 - Teknik Informatika (IF-Ganesha) ITB             */
/* Nama - 2   : Rafif Farras                                                     */
/* NIM - 2    : K02 - 13523095 - Teknik Informatika (IF-Ganesha) ITB             */
/* Tanggal    : Selasa, 20 Mei 2025                                              */
/* Tugas      : Tugas Kecil 3 - Strategi Algoritma (IF2211-24)                   */
/* File Path  : Tucil3_13523021_13523095/src/Main.java                           */
/* Deskripsi  : F01 - Main Program (Connection)                                  */
/* PIC F01    : K01 - 13523021 - Muhammad Raihan Nazhim Oktana                   */

// Package & Import
import java.io.IOException;
import java.util.*;
import algorithm.*;
import utils.*;

// Class Definition & Implementation
public class Main {
    // DESKRIPSI
    // Public Class Main
    
    // KAMUS
    // main : Main Function

    // PRIVATE ATTRIBUTES
    // None
    
    public static void main(String[] args) {
        // DESKRIPSI LOKAL
        // Main Program Function Connection
        
        // KAMUS LOKAL
        // ...

        // ALGORITMA LOKAL
        /* ---------------- Scanner in try-with-resources ----------------- */
        try (Scanner in = new Scanner(System.in)) {

            /* ---------- Path file ---------- */
            String filePath = (args.length >= 1)
                    ? args[0]
                    : prompt(in, "Masukkan path file test-case : ");

            /* ---------- Baca file ---------- */
            DataStructure start;
            try {
                start = Reader.readFile(filePath);
                System.out.println("\nFile berhasil dibaca.\n");
            } catch (IOException e) {
                System.err.println("Gagal membaca file : " + e.getMessage());
                return;
            }

            /* ---------- Pilih algoritma ---------- */
            System.out.println("Pilih algoritma:");
            System.out.println("  1. Uniform-Cost Search (UCS)");
            System.out.println("  2. Greedy Best-First Search");
            System.out.println("  3. A* Search");
            int algoOpt = Integer.parseInt(prompt(in, "Pilihan [1/2/3] : "));

            /* ---------- Pilih heuristik bila perlu ---------- */
            int heurOpt = 0;
            if (algoOpt == 2 || algoOpt == 3) {
                System.out.println("\nPilih heuristik:");
                System.out.println("  1. H1 – blocker + 1");
                System.out.println("  2. H2 – blocker + jarak kosong");
                System.out.println("  3. H3 – blocker + size blocker");
                heurOpt = Integer.parseInt(prompt(in, "Pilihan [1..3] : "));
            }

            /* ---------- Jalankan solver ---------- */
            Solution sol = switch (algoOpt) {
                case 1 -> UCS.solveUCS(start , 0);
                case 2 -> GBFS.solveGBFS(start , heurOpt);
                case 3 -> AStar.solveAStar(start , heurOpt);
                default -> null;
            };

            /* ---------- Tampilkan ---------- */
            if (sol == null) {
                System.out.println("❌  Puzzle tidak memiliki solusi / pilihan salah.");
            } else {
                sol.displaySolution();
            }
        }
    }

    /* --------------------- Helper prompt --------------------- */
    private static String prompt(Scanner in, String msg) {
        System.out.print(msg);
        return in.nextLine().trim();
    }
}