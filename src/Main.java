/* Kelompok   : Kelompok Tucil3_13523021_13523095                                */
/* Nama - 1   : Muhammad Raihan Nazhim Oktana                                    */
/* NIM - 1    : K01 - 13523021 - Teknik Informatika (IF-Ganesha) ITB             */
/* Nama - 2   : Rafif Farras                                                     */
/* NIM - 2    : K02 - 13523095 - Teknik Informatika (IF-Ganesha) ITB             */
/* Tanggal    : Senin, 19 Mei 2025                                               */
/* Tugas      : Tugas Kecil 3 - Strategi Algoritma (IF2211-24)                   */
/* File Path  : Tucil3_13523021_13523095/src/Main.java                           */
/* Deskripsi  : F01 - Main Program (Connection)                                  */
/* PIC F01    : K01 - 13523021 - Muhammad Raihan Nazhim Oktana                   */

import java.io.*;
import utils.DataStructure;
import utils.Reader;

public class Main {
    public static void main(String[] args) {
        String filePath = "test/input/test.txt";
        try {
            DataStructure data = Reader.readFile(filePath); 
            System.out.println("File berhasil dibaca.");
            data.printDataStructure();
        } catch (IOException e) {
            System.err.println("Gagal membaca file: " + e.getMessage());
        }
    }
}
