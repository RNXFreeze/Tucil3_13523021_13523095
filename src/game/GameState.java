/* Kelompok   : Kelompok Tucil3_13523021_13523095                                */
/* Nama - 1   : Muhammad Raihan Nazhim Oktana                                    */
/* NIM - 1    : K01 - 13523021 - Teknik Informatika (IF-Ganesha) ITB             */
/* Nama - 2   : Rafif Farras                                                     */
/* NIM - 2    : K02 - 13523095 - Teknik Informatika (IF-Ganesha) ITB             */
/* Tanggal    : Rabu, 21 Mei 2025                                                */
/* Tugas      : Tugas Kecil 3 - Strategi Algoritma (IF2211-24)                   */
/* File Path  : Tucil3_13523021_13523095/src/game/GameState.java                 */
/* Deskripsi  : F09 - Game State Program                                         */
/* PIC F09    : K01 - 13523021 - Muhammad Raihan Nazhim Oktana                   */

// Package & Import
package game;
import utils.*;

// Class Definition & Implementation
public class GameState {
    // DESKRIPSI
    // Public Class GameState
    
    // KAMUS
    // GameState : Constructor Class GameState
    // isSolved : Function

    // PRIVATE ATTRIBUTES
    // None

    private GameState() {
        // DESKRIPSI LOKAL
        // Instansiasi Constructor Class GameState
        
        // KAMUS LOKAL
        // None

        // ALGORITMA LOKAL
        // None
    }

    public static boolean isSolved(DataStructure dataStructure) {
        // DESKRIPSI LOKAL
        // Mengecek apakah puzzle telah solved atau belum.
        
        // KAMUS LOKAL
        // dataStructure : Class DataStructure
        // piece , pc : Class Piece
        // row , col , rig , lft , top , bot : Integer

        // ALGORITMA LOKAL
        Piece piece = dataStructure.getPieces().stream().filter(pc -> pc.getType() == 'P').findFirst().orElseThrow();
        Point exit = dataStructure.getExit();
        if (piece.getOrientation() == 0) {
            int row = piece.getCoordinates().get(0).getY();
            int rig = piece.getCoordinates().stream().mapToInt(Point::getX).max().orElseThrow();
            int lft = piece.getCoordinates().stream().mapToInt(Point::getX).min().orElseThrow();
            if (exit.getX() == -1) {
                return ((exit.getY() == dataStructure.getHeight() - 1 - row) && (lft <= exit.getX() + 1));
            } else {
                return ((exit.getY() == dataStructure.getHeight() - 1 - row) && (rig >= exit.getX() - 1));
            }
        } else {
            int col = piece.getCoordinates().get(0).getX();
            int bot = piece.getCoordinates().stream().mapToInt(Point::getY).max().orElseThrow();
            int top = piece.getCoordinates().stream().mapToInt(Point::getY).min().orElseThrow();
            if (exit.getY() == -1) {
                return ((exit.getX() == col) && (dataStructure.getHeight() - 1 - bot <= exit.getY() + 1));
            } else {
                return ((exit.getX() == col) && (dataStructure.getHeight() - 1 - top >= exit.getY() - 1));
            }
        }
    }
}