/* Kelompok   : Kelompok Tucil3_13523021_13523095                                */
/* Nama - 1   : Muhammad Raihan Nazhim Oktana                                    */
/* NIM - 1    : K01 - 13523021 - Teknik Informatika (IF-Ganesha) ITB             */
/* Nama - 2   : Rafif Farras                                                     */
/* NIM - 2    : K02 - 13523095 - Teknik Informatika (IF-Ganesha) ITB             */
/* Tanggal    : Selasa, 20 Mei 2025                                              */
/* Tugas      : Tugas Kecil 3 - Strategi Algoritma (IF2211-24)                   */
/* File Path  : Tucil3_13523021_13523095/src/utils/Saver.java                    */
/* Deskripsi  : F11 - File Saver Utility                                         */
/* PIC F11    : K01 - 13523021 - Muhammad Raihan Nazhim Oktana                   */

// Package & Import
package utils;
import algorithm.*;
import java.io.*;

// Class Definition & Implementation
public final class Saver {
    // DESKRIPSI
    // Public Class Saver - Menyimpan hasil Solution ke berkas teks

    // KAMUS
    // saveFile : Procedure

    // PRIVATE ATTRIBUTES
    // None

    private Saver() {
        // DESKRIPSI LOKAL
        // Instansiasi Constructor Class Saver (Private)
        
        // KAMUS LOKAL
        // None

        // ALGORITMA LOKAL
        // None
    }

    public static void saveFile(String filePath , Solution solution) throws IOException {
        // DESKRIPSI LOKAL
        // Menulis solusi (detail langkah & papan) ke berkas teks
        
        // KAMUS LOKAL
        // filePath : String
        // solution : Class Solution
        // writer : Java IO BufferedWriter
        // i , j : Integer
        // board : Class Board
        // ds : Class DataStructure
        // grid : Matrix of Character

        // ALGORITMA LOKAL
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            /* Bagian header informasi */
            writer.write("==================================================\n");
            writer.write("INFORMATION SOLUTION RESULT :\n");
            writer.write(String.format("Algorithm    : %s%n" , solution.getAlgorithm()));
            writer.write(String.format("Heuristic    : %d%n" , solution.getHeuristicId()));
            writer.write(String.format("Step Count   : %d Step%n" , solution.getStepCount()));
            writer.write(String.format("Visited Node : %d Node%n" , solution.getNodesVisited()));
            writer.write(String.format("Time Usage   : %d ms%n" , (int) solution.getTime()));
            if (solution.getMoves().isEmpty()) {
                writer.write("Success      : NO\n");
            } else {
                writer.write("Success      : YES\n");
            }
            writer.write("==================================================\n");

            /* Bagian papan & langkah */
            if (solution.getMoves().isEmpty()) {
                writer.write("\nDisplay Board Awal & Akhir :\n");
                writeBoard(writer , solution.getPath().get(0));
            } else {
                writer.write("Display Board Awal :\n");
                writeBoard(writer , solution.getPath().get(0));
                for (int i = 0 ; i < solution.getMoves().size() ; i++) {
                    writer.write(String.format("%nMOVE %d : %s%n" ,
                                               (i + 1) ,
                                               solution.getMoves().get(i)));
                    writeBoard(writer , solution.getPath().get(i + 1));
                }
            }
            writer.write("==================================================\n");
            writer.write("RECALL INFORMATION SOLUTION RESULT :\n");
            writer.write(String.format("Algorithm    : %s%n" , solution.getAlgorithm()));
            writer.write(String.format("Heuristic    : %d%n" , solution.getHeuristicId()));
            writer.write(String.format("Step Count   : %d Step%n" , solution.getStepCount()));
            writer.write(String.format("Visited Node : %d Node%n" , solution.getNodesVisited()));
            writer.write(String.format("Time Usage   : %d ms%n" , (int) solution.getTime()));
            if (solution.getMoves().isEmpty()) {
                writer.write("Success      : NO\n");
            } else {
                writer.write("Success      : YES\n");
            }
            writer.write("==================================================\n");
        }
    }

    /* ================================================================ */
    /* =================== PRIVATE HELPER PROCEDURE =================== */
    /* ================================================================ */
    private static void writeBoard(BufferedWriter writer , DataStructure ds) throws IOException {
        // DESKRIPSI LOKAL
        // Menulis satu papan permainan (lengkap dengan huruf K) ke writer
        
        // KAMUS LOKAL
        // board : Class Board
        // exit  : Class Point
        // width , height , i , j : Integer

        // ALGORITMA LOKAL
        Board board  = ds.getBoard();
        Point exit   = ds.getExit();
        int width    = ds.getWidth();
        int height   = ds.getHeight();

        if (exit.getX() == -1) {                       // Pintu di kiri
            for (int i = 0 ; i < height ; i++) {
                if (height - 1 - exit.getY() == i) {
                    writer.write("K ");
                } else {
                    writer.write("  ");
                }
                for (int j = 0 ; j < width ; j++) {
                    writer.write(board.getCell(j , i) + " ");
                }
                writer.newLine();
            }
        } else if (exit.getY() == -1) {                // Pintu di atas
            for (int i = 0 ; i < height ; i++) {
                for (int j = 0 ; j < width ; j++) {
                    writer.write(board.getCell(j , i) + " ");
                }
                writer.newLine();
            }
            for (int j = 0 ; j < exit.getX() ; j++) {
                writer.write("  ");
            }
            writer.write("K");
            writer.newLine();
        } else if (exit.getY() == height) {            // Pintu di bawah
            for (int j = 0 ; j < exit.getX() ; j++) {
                writer.write("  ");
            }
            writer.write("K");
            writer.newLine();
            for (int i = 0 ; i < height ; i++) {
                for (int j = 0 ; j < width ; j++) {
                    writer.write(board.getCell(j , i) + " ");
                }
                writer.newLine();
            }
        } else {                                       // Pintu di kanan
            for (int i = 0 ; i < height ; i++) {
                for (int j = 0 ; j < width ; j++) {
                    writer.write(board.getCell(j , i) + " ");
                }
                if (height - 1 - exit.getY() == i) {
                    writer.write("K");
                }
                writer.newLine();
            }
        }
    }
}
