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
import algorithm.*;
import java.io.IOException;
import java.util.*;
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
        // args : Array of String
        // scanner : Java Util Scanner
        // displayDataStructure , displaySolution : Procedure
        // solveUCS , solveGBFS , solveAStar : Function
        // algorithmOption , heuristicOption : Integer
        // dataStructure : Class DataStructure
        // filePath , response : String
        // check : Boolean

        // ALGORITMA LOKAL
        System.out.println("==================================================");
        System.out.println("!!! SELAMAT DATANG DI PUZZLE RUSH HOUR SOLVER !!!");
        System.out.println("Dibuat Oleh :");
        System.out.println("Kelompok Tucil 3 | Tucil3_13523021_13523095");
        System.out.println("1. 13523021 - Muhammad Raihan Nazhim Oktana");
        System.out.println("2. 13523095 - Rafif Farras");
        boolean check = true;
        Scanner scanner = new Scanner(System.in);
        while (check) {
            System.out.println("==================================================");
            DataStructure dataStructure;
            String filePath;
            while (true) {
                if (args.length > 0) {
                    filePath = args[0];
                } else {
                    System.out.print("Masukkan Nama File Test Case (Example.txt) : ");
                    filePath = "test/input/" + scanner.nextLine().trim();
                }
                try {
                    dataStructure = Reader.readFile(filePath);
                    System.out.println("Success : File Berhasil Dibaca.");
                    break;
                } catch (IOException e) {
                    System.out.println("Error : File Gagal Dibaca : " + e.getMessage());
                    if (args.length >= 1) {
                        System.out.println("Error Args : Tolong Ulangi Running Program");
                        scanner.close();
                        return;
                    } else {
                        System.out.println("Silakan Ulangi Input Nama File Test Case.");
                    }
                }
            }
            System.out.println("==================================================");
            System.out.println("Display Board From File :");
            dataStructure.displayDataStructure();
            System.out.println("==================================================");
            System.out.println("Opsi Algoritma :");
            System.out.println("1. Uniform Cost Search (UCS)");
            System.out.println("2. Greedy Best First Search (GBFS)");
            System.out.println("3. A-Star Search (A*)");
            int algorithmOption = -1;
            while (true) {
                try {
                    System.out.print("Masukkan Pilihan Algoritma (1/2/3) : ");
                    algorithmOption = Integer.parseInt(scanner.nextLine().trim());
                    if (1 <= algorithmOption && algorithmOption <= 3) {
                        break;
                    } else {
                        System.out.println("Error : Input Pilihan Algoritma Tidak Valid : Harus Integer (1/2/3).");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error : Input Pilihan Algoritma Tidak Valid : Harus Integer (1/2/3).");
                }
            }
            System.out.println("==================================================");
            int heuristicOption = 0;
            if (algorithmOption == 1) {
                System.out.println("Algoritma Uniform Cost Search (UCS) melakukan blind search tanpa heuristik apapun.");
            } else {
                System.out.println("Opsi Heuristik :");
                System.out.println("1. Heuristik 1 : Menghitung Blocker");
                System.out.println("2. Heuristik 2 : Menghitung Blocker + Jarak Kosong");
                System.out.println("3. Heuristik 3 : Menghitung Blocker + Ukuran Blocker");
                while (true) {
                    try {
                        System.out.print("Masukkan Pilihan Heuristik (1/2/3) : ");
                        heuristicOption = Integer.parseInt(scanner.nextLine().trim());
                        if (1 <= heuristicOption && heuristicOption <= 3) {
                            break;
                        } else {
                            System.out.println("Error : Input Pilihan Heuristik Tidak Valid : Harus Integer (1/2/3).");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Error : Input Pilihan Heuristik Tidak Valid : Harus Integer (1/2/3).");
                    }
                }
            }
            Solution solution = switch (algorithmOption) {
                case 1 -> UCS.solveUCS(dataStructure , 0);
                case 2 -> GBFS.solveGBFS(dataStructure , heuristicOption);
                case 3 -> AStar.solveAStar(dataStructure , heuristicOption);
                default -> Solution.buildSolution("Unknown Algorithm" , 0 , 0 , 0 ,  new Solution.Node(dataStructure , null , 0 , 0 , null));
            };
            solution.displaySolution();
            System.out.println("==================================================");
            String response;
            while (true) {
                System.out.print("Apakah Anda Ingin Menyimpan Solusi Ke File? (Y/N) : ");
                response = scanner.nextLine().trim().toUpperCase();
                switch (response) {
                    case "Y" -> check = true;
                    case "N" -> check = false;
                    default -> {
                        System.out.println("Error : Input Respons Tidak Valid.");
                        continue;
                    }
                }
                break;
            }
            if (response.equals("Y")) {
                while (true) {
                    System.out.print("Masukkan Nama File Penyimpanan Solusi (Example.txt) : ");
                    response = "test/output/" + scanner.nextLine().trim();
                    try {
                        Saver.saveFile(response , solution);
                        System.out.println("Success : File Berhasil Disimpan.");
                        break;
                    } catch (IOException e) {
                        System.out.println("Error : File Gagal Disimpan : " + e.getMessage());
                        System.out.println("Silakan Ulangi Input Nama File Penyimpanan Solusi.");
                    }
                }
            }
            System.out.println("==================================================");
            while (true) {
                System.out.print("Apakah Anda Ingin Bermain Lagi? (Y/N) : ");
                response = scanner.nextLine().trim().toUpperCase();
                switch (response) {
                    case "Y" -> check = true;
                    case "N" -> check = false;
                    default -> {
                        System.out.println("Error : Input Respons Tidak Valid.");
                        continue;
                    }
                }
                break;
            }
        }
        System.out.println("==================================================");
        System.out.println("!!! TERIMA KASIH & SAMPAI JUMPA LAGI !!!");
        System.out.println("Dibuat Oleh :");
        System.out.println("Kelompok Tucil 3 | Tucil3_13523021_13523095");
        System.out.println("1. 13523021 - Muhammad Raihan Nazhim Oktana");
        System.out.println("2. 13523095 - Rafif Farras");
        System.out.println("==================================================");
        scanner.close();
    }
}