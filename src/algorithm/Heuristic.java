/* Kelompok   : Kelompok Tucil3_13523021_13523095                                */
/* Nama - 1   : Muhammad Raihan Nazhim Oktana                                    */
/* NIM - 1    : K01 - 13523021 - Teknik Informatika (IF-Ganesha) ITB             */
/* Nama - 2   : Rafif Farras                                                     */
/* NIM - 2    : K02 - 13523095 - Teknik Informatika (IF-Ganesha) ITB             */
/* Tanggal    : Selasa, 20 Mei 2025                                              */
/* Tugas      : Tugas Kecil 3 - Strategi Algoritma (IF2211-24)                   */
/* File Path  : Tucil3_13523021_13523095/src/algorithm/Heuristic.java            */
/* Deskripsi  : F05 - Heuristic Pathfinding Algorithm                            */
/* PIC F05    : K01 - 13523021 - Muhammad Raihan Nazhim Oktana                   */

// Package & Import
package algorithm;
import utils.*;

// Class Definition & Implementation
public class Heuristic {
    // DESKRIPSI
    // Public Class Heuristic
    
    // KAMUS
    // Heuristic : Constructor Class Heuristic
    // solveHeuristic , heuristic1 , heuristic2 , heuristic3 , blockingCount , findPrimary , isBlocking : Function

    // PRIVATE ATTRIBUTES
    // None
    
    private Heuristic() {
        // DESKRIPSI LOKAL
        // Instansiasi Constructor Class Heuristic
        
        // KAMUS LOKAL
        // None

        // ALGORITMA LOKAL
        // None
    }

    public static int solveHeuristic(DataStructure dataStructure , int num) {
        // DESKRIPSI LOKAL
        // Fungsi Utama Heuristik : Menghitung nilai heuristik dari dataStructure dan tipe heuristiknya.
        
        // KAMUS LOKAL
        // dataStructure : Class DataStructure
        // heuristic1 , heuristic2 , heuristic3 : Function
        // num : Integer

        // ALGORITMA LOKAL
        return switch (num) {
            case 1 -> heuristic1(dataStructure);
            case 2 -> heuristic2(dataStructure);
            case 3 -> heuristic3(dataStructure);
            default -> 0;
        };
    }

    private static int heuristic1(DataStructure dataStructure) {
        // DESKRIPSI LOKAL
        // Heuristik 1 : Menghitung jumlah piece yang menghalangi primary piece.
        
        // KAMUS LOKAL
        // dataStructure : Class DataStructure
        // blockingCount : Function

        // ALGORITMA LOKAL
        return blockingCount(dataStructure) + 1;
    }

    private static int heuristic2(DataStructure dataStructure) {
        // DESKRIPSI LOKAL
        // Heuristik 2 : Menghitung jumlah piece yang menghalangi primary piece dan jarak kosong yang tersedia.
        
        // KAMUS LOKAL
        // dataStructure : Class DataStructure
        // blockingCount , findPrimary : Function
        // piece : Class Piece
        // board : Class Board
        // blocker , rig , bot : Integer

        // ALGORITMA LOKAL
        int blocker = blockingCount(dataStructure);
        Piece piece = findPrimary(dataStructure);
        if (piece.getOrientation() == 0) {
            int rig = piece.getCoordinates().stream().mapToInt(Point::getX).max().orElseThrow();
            return blocker + dataStructure.getExit().getX() - rig - 1;
        } else {
            int bot = piece.getCoordinates().stream().mapToInt(Point::getY).max().orElseThrow();
            return blocker + dataStructure.getExit().getY() - bot - 1;
        }
    }

    private static int heuristic3(DataStructure dataStructure) {
        // DESKRIPSI LOKAL
        // Heuristik 3 : Menghitung jumlah piece yang menghalangi primary piece dan ukuran setiap piece yang menghalangi tersebut.
        
        // KAMUS LOKAL
        // dataStructure : Class DataStructure
        // blockingCount , findPrimary , isBlocking : Function
        // piece , pc : Class Piece
        // blocker , extra : Integer

        // ALGORITMA LOKAL
        int blocker = blockingCount(dataStructure);
        Piece piece = findPrimary(dataStructure);
        int extra = dataStructure.getPieces().stream().filter(pc -> pc != piece && isBlocking(pc , piece)).mapToInt(pc -> pc.getCoordinates().size()).sum();
        return blocker + extra;
    }

    private static int blockingCount(DataStructure dataStructure) {
        // DESKRIPSI LOKAL
        // Fungsi Bantuan : Menghitung jumlah piece yang menghalangi primary piece.
        
        // KAMUS LOKAL
        // dataStructure : Class DataStructure
        // findPrimary : Function
        // piece : Class Piece
        // board : Class Board
        // cnt , row , col , rig , bot , x , y : Integer

        // ALGORITMA LOKAL
        Piece piece  = findPrimary(dataStructure);
        Board board = dataStructure.getBoard();
        int cnt = 0;
        if (piece.getOrientation() == 0) {
            int row = piece.getCoordinates().get(0).getY();
            int rig = piece.getCoordinates().stream().mapToInt(Point::getX).max().orElseThrow();
            for (int x = rig + 1 ; x < board.getHeight() ; x++) {
                if (board.getCell(row , x) != '.') {
                    cnt++;
                }
            }
        } else {
            int col = piece.getCoordinates().get(0).getX();
            int bot = piece.getCoordinates().stream().mapToInt(Point::getY).max().orElseThrow();
            for (int y = bot + 1 ; y < board.getHeight() ; y++) {
                if (board.getCell(y , col) != '.') {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private static Piece findPrimary(DataStructure dataStructure) {
        // DESKRIPSI LOKAL
        // Fungsi Bantuan : Mencari primary piece dari dataStructure.
        
        // KAMUS LOKAL
        // dataStructure : Class DataStructure
        // piece : Piece

        // ALGORITMA LOKAL
        return dataStructure.getPieces().stream().filter(piece -> piece.getType() == 'P').findFirst().orElseThrow();
    }

    private static boolean isBlocking(Piece otherPiece , Piece primaryPiece) {
        // DESKRIPSI LOKAL
        // Fungsi Bantuan : Mengecek apakah piece lain menghalangi primary piece.
        
        // KAMUS LOKAL
        // dataStructure : Class DataStructure
        // primaryPiece , otherPiece , piece : Piece
        // exit : Class Point
        // prow , orow , pcol , ocol : Integer

        // ALGORITMA LOKAL
        if (primaryPiece.getOrientation() == 0) {
            int prow = primaryPiece.getCoordinates().get(0).getY();
            int orow = otherPiece.getCoordinates().get(0).getY();
            return ((prow == orow) && (otherPiece.getCoordinates().stream().anyMatch(piece -> piece.getX() > primaryPiece.getCoordinates().stream().mapToInt(Point::getX).max().orElseThrow())));
        } else {
            int pcol = primaryPiece.getCoordinates().get(0).getX();
            int ocol = otherPiece.getCoordinates().get(0).getX();
            return pcol == ocol && otherPiece.getCoordinates().stream().anyMatch(piece -> piece.getY() > primaryPiece.getCoordinates().stream().mapToInt(Point::getY).max().orElseThrow());
        }
    }
}