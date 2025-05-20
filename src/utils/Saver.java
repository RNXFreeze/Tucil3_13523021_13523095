/* Kelompok   : Kelompok Tucil3_13523021_13523095                                */
/* Nama - 1   : Muhammad Raihan Nazhim Oktana                                    */
/* NIM - 1    : K01 - 13523021 - Teknik Informatika (IF-Ganesha) ITB             */
/* Nama - 2   : Rafif Farras                                                     */
/* NIM - 2    : K02 - 13523095 - Teknik Informatika (IF-Ganesha) ITB             */
/* Tanggal    : Rabu, 21 Mei 2025                                                */
/* Tugas      : Tugas Kecil 3 - Strategi Algoritma (IF2211-24)                   */
/* File Path  : Tucil3_13523021_13523095/src/utils/Saver.java                    */
/* Deskripsi  : F11 - File Saver Utility                                         */
/* PIC F11    : K01 - 13523021 - Muhammad Raihan Nazhim Oktana                   */

// Package & Import
package utils;
import algorithm.*;
import game.*;
import java.io.*;

// Class Definition & Implementation
public final class Saver {
    // DESKRIPSI
    // Public Class Saver

    // KAMUS
    // Saver : Constructor Class Saver
    // saveFile , writeBoard , writeLastBoard : Procedure

    // PRIVATE ATTRIBUTES
    // None

    private Saver() {
        // DESKRIPSI LOKAL
        // Instansiasi Constructor Class Saver
        
        // KAMUS LOKAL
        // None

        // ALGORITMA LOKAL
        // None
    }

    public static void saveFile(String filePath , Solution solution) throws IOException {
        // DESKRIPSI LOKAL
        // Melakukan write solution pada file yang telah ditentukan pathnya.
        
        // KAMUS LOKAL
        // filePath : String
        // solution : Class Solution
        // writer : Java IO BufferedWriter
        // piece : Class Piece
        // primaryPieceSize , i , j : Integer

        // ALGORITMA LOKAL
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("==================================================\n");
            writer.write("INFORMATION SOLUTION RESULT :\n");
            writer.write(String.format("Algorithm    : %s\n" , solution.getAlgorithm()));
            writer.write(String.format("Heuristic    : %d\n" , solution.getHeuristicId()));
            writer.write(String.format("Step Count   : %d Step\n" , solution.getStepCount()));
            writer.write(String.format("Visited Node : %d Node\n" , solution.getNodesVisited()));
            writer.write(String.format("Time Usage   : %d ms\n" , (int) solution.getTime()));
            if (solution.getMoves().isEmpty()) {
                writer.write("Success      : NO\n");
            } else {
                writer.write("Success      : YES\n");
            }
            writer.write("==================================================\n");
            if (solution.getMoves().isEmpty()) {
                writer.write("\nDisplay Board Awal & Akhir :\n");
                writeBoard(writer , solution.getPath().get(0));
            } else {
                writer.write("Display Board Awal :\n");
                writeBoard(writer , solution.getPath().get(0));
                for (int i = 0 ; i < solution.getMoves().size() ; i++) {
                    writer.write(String.format("\nMOVE %d : %s\n" , (i + 1) , solution.getMoves().get(i)));
                    writeBoard(writer , solution.getPath().get(i + 1));
                }
                if (!solution.getMoves().isEmpty()) {
                    GameLogic.Move last = solution.getMoves().get(solution.getMoves().size() - 1);
                    String direction = switch (last.getDirection()) {
                        case UP    -> "UP";
                        case DOWN  -> "DOWN";
                        case LEFT  -> "LEFT";
                        case RIGHT -> "RIGHT";
                        default    -> "UNKNOWN";
                    };
                    int primaryPieceSize = solution.getPath().get(0).getPieces().stream().filter(piece -> piece.getType() == 'P').findFirst().orElseThrow().solveSize();
                    writer.write(String.format("\nMOVE %d : P - OUT %s (%d STEP)\n" , solution.getMoves().size() + 1 , direction , primaryPieceSize));
                    writeLastBoard(writer , solution.getPath().get(solution.getMoves().size() - 1));
                }
            }
            writer.write("==================================================\n");
            writer.write("RECALL INFORMATION SOLUTION RESULT :\n");
            writer.write(String.format("Algorithm    : %s\n" , solution.getAlgorithm()));
            writer.write(String.format("Heuristic    : %d\n" , solution.getHeuristicId()));
            writer.write(String.format("Step Count   : %d Step\n" , solution.getStepCount()));
            writer.write(String.format("Visited Node : %d Node\n" , solution.getNodesVisited()));
            writer.write(String.format("Time Usage   : %d ms\n" , (int) solution.getTime()));
            if (solution.getMoves().isEmpty()) {
                writer.write("Success      : NO\n");
            } else {
                writer.write("Success      : YES\n");
            }
            writer.write("==================================================\n");
        }
    }

    private static void writeBoard(BufferedWriter writer , DataStructure dataStructure) throws IOException {
        // DESKRIPSI LOKAL
        // Menulis Board Puzzle Ke Writer
        
        // KAMUS LOKAL
        // writer : Java IO BufferedWriter
        // dataStructure : Class DataStructure
        // board : Class Board
        // exit : Class Point
        // width , height , i , j : Integer

        // ALGORITMA LOKAL
        Board board = dataStructure.getBoard();
        Point exit = dataStructure.getExit();
        int width = dataStructure.getWidth();
        int height = dataStructure.getHeight();
        if (exit.getX() == -1) {
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
        } else if (exit.getY() == -1) {
            for (int i = 0 ; i < height ; i++) {
                for (int j = 0 ; j < width ; j++) {
                    writer.write(board.getCell(j , i) + " ");
                }
                writer.newLine();
            }
            for (int j = 0 ; j < exit.getX() ; j++) {
                writer.write("  ");
            }
            writer.write("K\n");
        } else if (exit.getY() == height) {
            for (int j = 0 ; j < exit.getX() ; j++) {
                writer.write("  ");
            }
            writer.write("K\n");
            for (int i = 0 ; i < height ; i++) {
                for (int j = 0 ; j < width ; j++) {
                    writer.write(board.getCell(j , i) + " ");
                }
                writer.newLine();
            }
        } else {
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

    private static void writeLastBoard(BufferedWriter writer , DataStructure dataStructure) throws IOException {
        // DESKRIPSI LOKAL
        // Menulis Last Board Puzzle Ke Writer
        
        // KAMUS LOKAL
        // writer : Java IO BufferedWriter
        // dataStructure : Class DataStructure
        // piece : Class Piece
        // board : Class Board
        // exit : Class Point
        // primaryPieceSize , width , height , i , j : Integer

        // ALGORITMA LOKAL
        Board board = dataStructure.getBoard();
        Point exit = dataStructure.getExit();
        int width = dataStructure.getWidth();
        int height = dataStructure.getHeight();
        int primaryPieceSize = dataStructure.getPieces().stream().filter(piece -> piece.getType() == 'P').findFirst().orElseThrow().solveSize();
        if (exit.getX() == -1) {
            for (int i = 0 ; i < height ; i++) {
                for (int j = 0 ; j < primaryPieceSize ; j++) {
                    if (height - 1 - exit.getY() == i) {
                        writer.write("P ");
                    } else {
                        writer.write("  ");
                    }
                }
                for (int j = 0 ; j < width ; j++) {
                    if (board.getCell(j , i) == 'P') {
                        writer.write(". ");
                    } else {
                        writer.write(board.getCell(j , i) + " ");
                    }
                }
                writer.newLine();
            }
        } else if (exit.getY() == -1) {
            for (int i = 0 ; i < height ; i++) {
                for (int j = 0 ; j < width ; j++) {
                    if (board.getCell(j , i) == 'P') {
                        writer.write(". ");
                    } else {
                        writer.write(board.getCell(j , i) + " ");
                    }
                }
                writer.newLine();
            }
            for (int i = 0 ; i < primaryPieceSize ; i++) {
                for (int j = 0 ; j < exit.getX() ; j++) {
                    writer.write("  ");
                }
                writer.write("P\n");
            }
        } else if (exit.getY() == height) {
            for (int i = 0 ; i < primaryPieceSize ; i++) {
                for (int j = 0 ; j < exit.getX() ; j++) {
                    writer.write("  ");
                }
                writer.write("P\n");
            }
            for (int i = 0 ; i < height ; i++) {
                for (int j = 0 ; j < width ; j++) {
                    if (board.getCell(j , i) == 'P') {
                        writer.write(". ");
                    } else {
                        writer.write(board.getCell(j , i) + " ");
                    }
                }
                writer.newLine();
            }
        } else {
            for (int i = 0 ; i < height ; i++) {
                for (int j = 0 ; j < width ; j++) {
                    if (board.getCell(j , i) == 'P') {
                        writer.write(". ");
                    } else {
                        writer.write(board.getCell(j , i) + " ");
                    }
                }
                if (height - 1 - exit.getY() == i) {
                    for (int j = 0 ; j < primaryPieceSize ; j++) {
                        writer.write("P ");
                    }
                }
                writer.newLine();
            }
        }
    }
}