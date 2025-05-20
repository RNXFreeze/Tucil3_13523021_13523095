/* Kelompok   : Kelompok Tucil3_13523021_13523095                                */
/* Nama - 1   : Muhammad Raihan Nazhim Oktana                                    */
/* NIM - 1    : K01 - 13523021 - Teknik Informatika (IF-Ganesha) ITB             */
/* Nama - 2   : Rafif Farras                                                     */
/* NIM - 2    : K02 - 13523095 - Teknik Informatika (IF-Ganesha) ITB             */
/* Tanggal    : Selasa, 20 Mei 2025                                              */
/* Tugas      : Tugas Kecil 3 - Strategi Algoritma (IF2211-24)                   */
/* File Path  : Tucil3_13523021_13523095/src/game/GameLogic.java                 */
/* Deskripsi  : F10 - Game Logic Program                                         */
/* PIC F10    : K01 - 13523021 - Muhammad Raihan Nazhim Oktana                   */

// Package & Import
package game;
import java.util.*;
import utils.*;

// Class Definition & Implementation
public final class GameLogic {
    // DESKRIPSI
    // Public Class GameLogic
    
    // KAMUS
    // GameLogic : Constructor Class GameLogic
    // Move : Subclass Movement
    // generateMoves , applyMove , scanHorizontal , scanVertical : Procedure

    // PRIVATE ATTRIBUTES
    // None

    public enum Direction {
        // DESKRIPSI LOKAL
        // Instansiasi Enumeration Direction
        
        // KAMUS LOKAL
        // LEFT , RIGHT , UP , DOWN : Enumeration

        // ALGORITMA LOKAL
        LEFT , RIGHT , UP , DOWN
    }

    public static class Move {
        // DESKRIPSI SUBCLASS
        // Public Class Move
        
        // KAMUS SUBCLASS
        // Move : Constructor Sub Class Move
        // getIdType , getDirection , getStepCount , setIdType , setDirection , setStepCount , toString : Procedure

        // PRIVATE ATTRIBUTES SUBCLASS
        private char idType;
        private Direction direction;
        private int stepCount;

        public Move(char idType , Direction direction , int stepCount) {
            // DESKRIPSI SUBCLASS LOKAL
            // Instansiasi Constructor Class Move
            
            // KAMUS SUBCLASS LOKAL
            // idType : Character
            // direction : Enumeration Direction
            // stepCount : Integer

            // ALGORITMA SUBCLASS LOKAL
            this.idType = idType;
            this.direction = direction;
            this.stepCount = stepCount;
        }

        public char getIdType() {
            // DESKRIPSI SUBCLASS LOKAL
            // Getter ID Type
            
            // KAMUS SUBCLASS LOKAL
            // idType : Character

            // ALGORITMA SUBCLASS LOKAL
            return this.idType;
        }

        public Direction getDirection() {
            // DESKRIPSI SUBCLASS LOKAL
            // Getter Direction
            
            // KAMUS SUBCLASS LOKAL
            // direction : Enumeration Direction

            // ALGORITMA SUBCLASS LOKAL
            return this.direction;
        }

        public int getStepCount() {
            // DESKRIPSI SUBCLASS LOKAL
            // Getter Step Count
            
            // KAMUS SUBCLASS LOKAL
            // stepCount : Integer

            // ALGORITMA SUBCLASS LOKAL
            return this.stepCount;
        }

        public void setIdType(char idType) {
            // DESKRIPSI SUBCLASS LOKAL
            // Setter ID Type
            
            // KAMUS SUBCLASS LOKAL
            // idType : Character

            // ALGORITMA SUBCLASS LOKAL
            this.idType = idType;
        }

        public void setDirection(Direction direction) {
            // DESKRIPSI SUBCLASS LOKAL
            // Setter Direction
            
            // KAMUS SUBCLASS LOKAL
            // direction : Enumeration Direction

            // ALGORITMA SUBCLASS LOKAL
            this.direction = direction;
        }

        public void setStepCount(int stepCount) {
            // DESKRIPSI SUBCLASS LOKAL
            // Setter Step Count
            
            // KAMUS SUBCLASS LOKAL
            // stepCount : Integer

            // ALGORITMA SUBCLASS LOKAL
            this.stepCount = stepCount;
        }

        @Override
        public String toString() {
            // DESKRIPSI SUBCLASS LOKAL
            // Display Move To String
            
            // KAMUS SUBCLASS LOKAL
            // res : String
            // idType : Character
            // direction : Enumeration Direction
            // stepCount : Integer

            // ALGORITMA SUBCLASS LOKAL
            String res = this.idType + " - ";
            switch (this.direction) {
                case LEFT : res += "LEFT ";
                case RIGHT : res += "RIGHT ";
                case UP : res += "UP ";
                case DOWN : res += "DOWN ";
                default : res += "UNKNOWN ";
            }
            res = res + "(" + this.stepCount + " STEP)";
            return res;
        }
    }

    public static String boardKey(DataStructure dataStructure) {
        // DESKRIPSI LOKAL
        // Membangun string linear dari dataStructure untuk digunakan sebagai key pada HashSet & HashMap

        // KAMUS LOKAL
        // dataStructure : Class DataStructure
        // sb : StringBuilder
        // row : Array of Character
        // grid : Matrix of Character

        // ALGORITMA LOKAL
        StringBuilder sb = new StringBuilder();
        char[][] grid = dataStructure.getBoard().getGrid();
        for (char[] row : grid) {
            sb.append(row);
        }
        return sb.toString();
    }


    private GameLogic() {
        // DESKRIPSI LOKAL
        // Instansiasi Constructor Class GameLogic
        
        // KAMUS LOKAL
        // None

        // ALGORITMA LOKAL
        // None
    }

    public static List<Move> generateMoves(DataStructure dataStructure) {
        // DESKRIPSI LOKAL
        // Melakukan generate semua kemungkinan gerakan piece.
        
        // KAMUS LOKAL
        // dataStructure : Class DataStructure
        // listMoves : List of Sub Class Move
        // grid : Matrix of Character
        // piece : Class Piece

        // ALGORITMA LOKAL
        List<Move> listMoves = new ArrayList<>();
        char[][] grid = dataStructure.getBoard().getGrid();
        for (Piece piece : dataStructure.getPieces()) {
            if (piece.getOrientation() == 0) {
                listMoves.addAll(scanHorizontal(piece , grid , Direction.LEFT));
                listMoves.addAll(scanHorizontal(piece , grid , Direction.RIGHT));
            } else {
                listMoves.addAll(scanVertical(piece , grid , Direction.UP));
                listMoves.addAll(scanVertical(piece , grid , Direction.DOWN));
            }
        }
        return listMoves;
    }

    public static DataStructure applyMove(DataStructure dataStructure , Move move) {
        // DESKRIPSI LOKAL
        // Melakukan suatu gerakan dan mengupdate board permainan.
        
        // KAMUS LOKAL
        // dataStructure : Class DataStructure
        // newBoard : Class Board
        // newCoordinates : List of Class Point
        // move : Sub Class Move
        // movedPiece , piece : Class Piece
        // newPieces : List of Class Piece
        // nx , ny : Integer

        // ALGORITMA LOKAL
        Board newBoard = new Board(dataStructure.getBoard());
        List<Piece> newPieces = new ArrayList<>();
        Piece movedPiece = null;
        for (Piece piece : dataStructure.getPieces()) {
            if (piece.getType() == move.idType) {
                movedPiece = piece;
            } else {
                newPieces.add(piece);
            }
        }
        if (movedPiece == null) {
            return dataStructure;
        } else {
            for (Point point : movedPiece.getCoordinates()) {
                newBoard.setCell(point.getY() , point.getX() , '.');
            }
            List<Point> newCoordinates = new ArrayList<>();
            for (Point point : movedPiece.getCoordinates()) {
                int nx = point.getX();
                int ny = point.getY();
                switch (move.direction) {
                    case LEFT : nx -= move.stepCount;
                    case RIGHT : nx += move.stepCount;
                    case UP : ny -= move.stepCount;
                    case DOWN : ny += move.stepCount;
                    default : /*None*/;
                }
                newCoordinates.add(new Point(nx , ny));
                newBoard.setCell(ny , nx , move.idType);
            }
            newPieces.add(new Piece(move.idType , newCoordinates , movedPiece.getOrientation()));
            return new DataStructure(dataStructure.getWidth() , dataStructure.getHeight() , dataStructure.getPieceCount() , dataStructure.getExit() , newBoard , newPieces);
        }
    }

    private static List<Move> scanHorizontal(Piece piece , char[][] grid , Direction direction) {
        // DESKRIPSI LOKAL
        // Melakukan scanning kemungkinan move secara horizontal.
        
        // KAMUS LOKAL
        // row , mnx , mxx , cnt , x : Integer
        // res : List of Sub Class Move
        // grid : Matrix of Character
        // direction : Sub Class Move

        // ALGORITMA LOKAL
        List<Move> res = new ArrayList<>();
        int row = piece.getCoordinates().get(0).getY();
        int mnx = piece.getCoordinates().stream().mapToInt(Point::getX).min().orElseThrow();
        int mxx = piece.getCoordinates().stream().mapToInt(Point::getX).max().orElseThrow();
        int cnt = 1;
        if (direction == Direction.LEFT) {
            for (int x = mnx - 1 ; x >= 0 ; x--) {
                if (grid[row][x] == '.') {
                    res.add(new Move(piece.getType() , direction , cnt));
                    cnt++;
                } else {
                    break;
                }
            }
        } else {
            for (int x = mxx + 1 ; x < grid[0].length ; x++) {
                if (grid[row][x] == '.') {
                    res.add(new Move(piece.getType() , direction , cnt));
                    cnt++;
                } else {
                    break;
                }
            }
        }
        return res;
    }

    private static List<Move> scanVertical(Piece piece , char[][] grid , Direction direction) {
        // DESKRIPSI LOKAL
        // Melakukan scanning kemungkinan move secara vertical.
        
        // KAMUS LOKAL
        // col , mny , mxy , cnt , y : Integer
        // res : List of Sub Class Move
        // grid : Matrix of Character
        // direction : Sub Class Move

        // ALGORITMA LOKAL
        List<Move> res = new ArrayList<>();
        int col = piece.getCoordinates().get(0).getX();
        int mny = piece.getCoordinates().stream().mapToInt(Point::getY).min().orElseThrow();
        int mxy = piece.getCoordinates().stream().mapToInt(Point::getY).max().orElseThrow();
        int cnt = 1;
        if (direction == Direction.UP) {
            for (int y = mny - 1 ; y >= 0 ; y--) {
                if (grid[y][col] == '.') {
                    res.add(new Move(piece.getType() , direction , cnt));
                    cnt++;
                } else {
                    break;
                }
            }
        } else {
            for (int y = mxy + 1 ; y < grid.length ; y++) {
                if (grid[y][col] == '.') {
                    res.add(new Move(piece.getType() , direction , cnt));
                    cnt++;
                } else {
                    break;
                }
            }
        }
        return res;
    }
}