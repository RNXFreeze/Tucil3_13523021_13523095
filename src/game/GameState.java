/* Kelompok   : Kelompok Tucil3_13523021_13523095                                */
/* Nama - 1   : Muhammad Raihan Nazhim Oktana                                    */
/* NIM - 1    : K01 - 13523021 - Teknik Informatika (IF-Ganesha) ITB             */
/* Nama - 2   : Rafif Farras                                                     */
/* NIM - 2    : K02 - 13523095 - Teknik Informatika (IF-Ganesha) ITB             */
/* Tanggal    : Senin, 19 Mei 2025                                               */
/* Tugas      : Tugas Kecil 3 - Strategi Algoritma (IF2211-24)                   */
/* File Path  : Tucil3_13523021_13523095/src/game/GameState.java                 */
/* Deskripsi  : F09 - Game State Program                                         */
/* PIC F09    : K01 - 13523021 - Muhammad Raihan Nazhim Oktana                   */

// Package & Import
package game;
import utils.*;
import algorithm.*;
import java.util.List;

// Class Definition & Implementation
public class GameState {
    // DESKRIPSI
    // Public Class GameState
    
    // KAMUS
    // GameState : Constructor Class GameState
    // isSolved : Function

    private GameState() {
        // DESKRIPSI LOKAL
        // Instansiasi Constructor Class GameState
        
        // KAMUS LOKAL
        // None

        // ALGORITMA LOKAL
        // None
    }

    public boolean isSolved(DataStructure dataStructure) {
        // DESKRIPSI LOKAL
        // Mengecek apakah puzzle telah solved atau belum.
        
        // KAMUS LOKAL
        // dataStructure : Class DataStructure
        // piece , pc : Class Piece
        // row , col , rig , bot : Integer

        // ALGORITMA LOKAL
        Piece piece = dataStructure.getPieces().stream().filter(pc -> pc.getType() == 'P').findFirst().orElseThrow();
        if (piece.getOrientation() == 0) {
            int row = piece.getCoordinates().get(0).getX();
            int rig = piece.getCoordinates().stream().mapToInt(Point::getY).max().orElseThrow();
            return ((dataStructure.getExit().getX() == row) && (rig < dataStructure.getExit().getY()));
        } else {
            int col = piece.getCoordinates().get(0).getY();
            int bot = piece.getCoordinates().stream().mapToInt(Point::getX).max().orElseThrow();
            return ((dataStructure.getExit().getY() == col) && (bot < dataStructure.getExit().getX()));
        }
    }
}