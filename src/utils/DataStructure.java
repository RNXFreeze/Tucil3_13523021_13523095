/* Kelompok   : Kelompok Tucil3_13523021_13523095                                */
/* Nama - 1   : Muhammad Raihan Nazhim Oktana                                    */
/* NIM - 1    : K01 - 13523021 - Teknik Informatika (IF-Ganesha) ITB             */
/* Nama - 2   : Rafif Farras                                                     */
/* NIM - 2    : K02 - 13523095 - Teknik Informatika (IF-Ganesha) ITB             */
/* Tanggal    : Senin, 19 Mei 2025                                               */
/* Tugas      : Tugas Kecil 3 - Strategi Algoritma (IF2211-24)                   */
/* File Path  : Tucil3_13523021_13523095/src/utils/DataStructure.java            */
/* Deskripsi  : F06 - Data Structure Utility                                     */
/* PIC F06    : K02 - 13523095 - Rafif Farras                                    */

package utils;

import java.util.List;

public class DataStructure {
    public int width;
    public int height;
    public int pieceCount;
    public List<Piece> pieces;
    
    public DataStructure(int width, int height, int pieceCount, List<Piece> pieces) {
        this.width = width;
        this.height = height;
        this.pieceCount = pieceCount;
        this.pieces = pieces;
    }
}