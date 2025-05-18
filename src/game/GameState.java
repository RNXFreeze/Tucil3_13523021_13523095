/* Kelompok   : Kelompok Tucil3_13523021_13523095                                */
/* Nama - 1   : Muhammad Raihan Nazhim Oktana                                    */
/* NIM - 1    : K01 - 13523021 - Teknik Informatika (IF-Ganesha) ITB             */
/* Nama - 2   : Rafif Farras                                                     */
/* NIM - 2    : K02 - 13523095 - Teknik Informatika (IF-Ganesha) ITB             */
/* Tanggal    : Senin, 19 Mei 2025                                               */
/* Tugas      : Tugas Kecil 3 - Strategi Algoritma (IF2211-24)                   */
/* File Path  : Tucil3_13523021_13523095/src/game/GameState.java                 */
/* Deskripsi  : F08 - Game State Program                                         */
/* PIC F08    : K01 - 13523021 - Muhammad Raihan Nazhim Oktana                   */

package game;
import utils.*;
import algorithm.*;
import java.util.List;

public class GameState {
    public boolean isSolved(DataStructure dataStructure) {
        Piece P = dataStructure.pieces.stream().filter(piece -> piece.getType() == 'P').findFirst().orElseThrow();
        List<Point> cells = P.getCoordinates();
        int orient = P.getOrientation();
        if (orient == 0) {
            int row = cells.get(0).getX();
            int rightMost = cells.stream().mapToInt(Point::getY).max().orElseThrow();
            return (dataStructure.exit.getX() == row && rightMost < dataStructure.exit.getY());
        } else {
            int col = cells.get(0).getY();
            int bottomMost = cells.stream().mapToInt(Point::getX).max().orElseThrow();
            return (dataStructure.exit.getY() == col && bottomMost < dataStructure.exit.getX());
        }
    }
}