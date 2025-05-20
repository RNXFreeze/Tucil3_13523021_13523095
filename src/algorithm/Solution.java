/* Kelompok   : Kelompok Tucil3_13523021_13523095                                */
/* Nama - 1   : Muhammad Raihan Nazhim Oktana                                    */
/* NIM - 1    : K01 - 13523021 - Teknik Informatika (IF-Ganesha) ITB             */
/* Nama - 2   : Rafif Farras                                                     */
/* NIM - 2    : K02 - 13523095 - Teknik Informatika (IF-Ganesha) ITB             */
/* Tanggal    : Rabu, 21 Mei 2025                                                */
/* Tugas      : Tugas Kecil 3 - Strategi Algoritma (IF2211-24)                   */
/* File Path  : Tucil3_13523021_13523095/src/algorithm/Solution.java             */
/* Deskripsi  : F06 - Solution Pathfinding Algorithm                             */
/* PIC F06    : K01 - 13523021 - Muhammad Raihan Nazhim Oktana                   */

// Package & Import
package algorithm;
import game.*;
import java.util.*;
import utils.*;

// Class Definition & Implementation
public final class Solution {
    // DESKRIPSI
    // Public Class Solution - Menyimpan hasil lengkap path-finding dan prosedur tampilan

    // KAMUS
    // Solution : Constructor Class Solution
    // displaySolution : Procedure cetak hasil solusi

    // PRIVATE ATTRIBUTES
    private final String algorithm;
    private final int heuristicId;
    private int nodesVisited;
    private int stepCount;
    private double time;
    private List<DataStructure> path;
    private List<GameLogic.Move> moves;

    // ANSI color codes
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_BOLD = "\u001B[1m";
    private static final String ANSI_BACKGROUND_RED = "\u001B[41m";
    private static final String ANSI_BACKGROUND_GREEN = "\u001B[42m";

    public Solution(String algorithm , int heuristicId , int nodesVisited , double time , List<DataStructure> path , List<GameLogic.Move> moves) {
        // DESKRIPSI LOKAL
        // Instansiasi Constructor Class Solution

        // KAMUS LOKAL
        // algorithm : String
        // heuristicId : Integer
        // nodesVisited : Integer
        // time : Double
        // path : List of Class DataStructure
        // moves : List of Class GameLogic Sub Class Move

        // ALGORITMA LOKAL
        this.algorithm = algorithm;
        this.heuristicId = heuristicId;
        this.nodesVisited = nodesVisited;
        this.time = time;
        this.path = path;
        this.moves = moves;
        this.stepCount = moves.size();
    }

    public String getAlgorithm() {
        // DESKRIPSI LOKAL
        // Getter Algorithm

        // KAMUS LOKAL
        // algorithm : String

        // ALGORITMA LOKAL
        return this.algorithm;
    }

    public int getHeuristicId() {
        // DESKRIPSI LOKAL
        // Getter Heuristic ID

        // KAMUS LOKAL
        // heuristicId : Integer

        // ALGORITMA LOKAL
        return this.heuristicId;
    }

    public int getNodesVisited() {
        // DESKRIPSI LOKAL
        // Getter Nodes Visited

        // KAMUS LOKAL
        // nodesVisited : Integer

        // ALGORITMA LOKAL
        return this.nodesVisited;
    }

    public int getStepCount() {
        // DESKRIPSI LOKAL
        // Getter Depth

        // KAMUS LOKAL
        // stepCount : Integer

        // ALGORITMA LOKAL
        return this.stepCount;
    }

    public double getTime() {
        // DESKRIPSI LOKAL
        // Getter Time Millis

        // KAMUS LOKAL
        // time : Double

        // ALGORITMA LOKAL
        return this.time;
    }

    public List<DataStructure> getPath() {
        // DESKRIPSI LOKAL
        // Getter Path

        // KAMUS LOKAL
        // path : List of Class DataStructure

        // ALGORITMA LOKAL
        return this.path;
    }

    public List<GameLogic.Move> getMoves() {
        // DESKRIPSI LOKAL
        // Getter Moves

        // KAMUS LOKAL
        // moves : List of Class GameLogic Sub Class Move

        // ALGORITMA LOKAL
        return this.moves;
    }

    public String setAlgorithm() {
        // DESKRIPSI LOKAL
        // Setter Algorithm

        // KAMUS LOKAL
        // algorithm : String

        // ALGORITMA LOKAL
        return this.algorithm;
    }

    public int setHeuristicId() {
        // DESKRIPSI LOKAL
        // Setter Heuristic ID

        // KAMUS LOKAL
        // heuristicId : Integer

        // ALGORITMA LOKAL
        return this.heuristicId;
    }

    public void setNodesVisited(int nodesVisited) {
        // DESKRIPSI LOKAL
        // Setter Nodes Visited

        // KAMUS LOKAL
        // nodesVisited : Integer

        // ALGORITMA LOKAL
        this.nodesVisited = nodesVisited;
    }

    public void setStepCount(int stepCount) {
        // DESKRIPSI LOKAL
        // Setter Step Count

        // KAMUS LOKAL
        // stepCount : Integer

        // ALGORITMA LOKAL
        this.stepCount = stepCount;
    }

    public void setTime(double time) {
        // DESKRIPSI LOKAL
        // Setter Time Millis

        // KAMUS LOKAL
        // time : Double

        // ALGORITMA LOKAL
        this.time = time;
    }

    public void setPath(List<DataStructure> path) {
        // DESKRIPSI LOKAL
        // Setter Path

        // KAMUS LOKAL
        // path : List of Class DataStructure

        // ALGORITMA LOKAL
        this.path = path;
    }

    public void setMoves(List<GameLogic.Move> moves) {
        // DESKRIPSI LOKAL
        // Setter Moves

        // KAMUS LOKAL
        // moves : List of Class GameLogic Sub Class Move

        // ALGORITMA LOKAL
        this.moves = moves;
    }

    public static class Node {
        // DESKRIPSI SUBCLASS
        // Public Class Node
        
        // KAMUS SUBCLASS
        // Node : Constructor Sub Class Node
        // solveF : Function
        // getState , getMove , getGValue , getHValue , getParent : Procedure
        // setState , setMove , setGValue , setHValue , setParent : Procedure

        // PRIVATE ATTRIBUTES SUBCLASS
        public DataStructure state;
        public GameLogic.Move move;
        public int gValue;
        public int hValue;
        public Node parent;

        public Node(DataStructure state , GameLogic.Move move , int gValue , int hValue , Node parent) {
            // DESKRIPSI SUBCLASS LOKAL
            // Instansiasi Constructor Class Node
            
            // KAMUS SUBCLASS LOKAL
            // state : Class DataStructure
            // move : Class GameLogic Sub Class Move
            // parent : Class Solution Sub Class Node
            // gValue , hValue : Integer

            // ALGORITMA SUBCLASS LOKAL
            this.state = state;
            this.move = move;
            this.gValue = gValue;
            this.hValue = hValue;
            this.parent = parent;
        }

        public DataStructure getState() {
            // DESKRIPSI LOKAL
            // Getter State

            // KAMUS LOKAL
            // state : Class DataStructure

            // ALGORITMA LOKAL
            return this.state;
        }

        public GameLogic.Move getMove() {
            // DESKRIPSI LOKAL
            // Getter Move

            // KAMUS LOKAL
            // move : Class GameLogic Sub Class Move

            // ALGORITMA LOKAL
            return this.move;
        }

        public int getGValue() {
            // DESKRIPSI LOKAL
            // Getter G Value

            // KAMUS LOKAL
            // gValue : Integer

            // ALGORITMA LOKAL
            return this.gValue;
        }

        public int getHValue() {
            // DESKRIPSI LOKAL
            // Getter H Value

            // KAMUS LOKAL
            // hValue : Integer
            
            // ALGORITMA LOKAL
            return this.hValue;
        }

        public Node getParent() {
            // DESKRIPSI LOKAL
            // Getter Parent

            // KAMUS LOKAL
            // parent : Class Solution Sub Class Node

            // ALGORITMA LOKAL
            return this.parent;
        }

        public void setState(DataStructure state) {
            // DESKRIPSI LOKAL
            // Setter State

            // KAMUS LOKAL
            // state : Class DataStructure

            // ALGORITMA LOKAL
            this.state = state;
        }

        public void setMove(GameLogic.Move move) {
            // DESKRIPSI LOKAL
            // Setter Move

            // KAMUS LOKAL
            // move : Class GameLogic Sub Class Move

            // ALGORITMA LOKAL
            this.move = move;
        }

        public void setGValue(int gValue) {
            // DESKRIPSI LOKAL
            // Setter G Value

            // KAMUS LOKAL
            // gValue : Integer

            // ALGORITMA LOKAL
            this.gValue = gValue;
        }

        public void setHValue(int hValue) {
            // DESKRIPSI LOKAL
            // Setter H Value

            // KAMUS LOKAL
            // hValue : Integer
            
            // ALGORITMA LOKAL
            this.hValue = hValue;
        }

        public void setParent(Node parent) {
            // DESKRIPSI LOKAL
            // Setter Parent

            // KAMUS LOKAL
            // parent : Class Solution Sub Class Node

            // ALGORITMA LOKAL
            this.parent = parent;
        }

        public int solveF() {
            // DESKRIPSI SUBCLASS LOKAL
            // Menghitung nilai F pada algoritma pencarian A-Star
            
            // KAMUS SUBCLASS LOKAL
            // gValue , hValue : Integer

            // ALGORITMA SUBCLASS LOKAL
            return this.gValue + this.hValue;
        }
    }

    public static Solution buildSolution(String algorithm , int heuristicId , int visitedCount , double time , Node goal) {
        // DESKRIPSI LOKAL
        // Membangun tipe data Solution dari hasil algoritma pencarian

        // KAMUS LOKAL
        // moves : List of Class GameLogic Sub Class Move
        // boards : List of Class DataStructure
        // node , goal : Sub Class Node
        // heuristicId , visitedCount : Integer
        // algorithm : String
        // time : Double

        // ALGORITMA LOKAL
        LinkedList<DataStructure> boards = new LinkedList<>();
        LinkedList<GameLogic.Move> moves = new LinkedList<>();
        for (Node node = goal ; node != null ; node = node.parent) {
            boards.addFirst(node.state);
            if (node.move != null) {
                moves.addFirst(node.move);
            }
        }
        return new Solution(algorithm , heuristicId , visitedCount , time , boards , moves);
    }

    public void displaySolution() {
        // DESKRIPSI LOKAL
        // Menampilkan solusi dalam format CLI yang terstruktur dengan highlighting perubahan

        // KAMUS LOKAL
        // algorithm : String
        // heuristicId, nodesVisited, i : Integer
        // time : Double
        // path : List of Class DataStructure
        // moves : List of Class GameLogic Sub Class Move

        // ALGORITMA LOKAL
        if (this.moves.isEmpty()) {
            System.out.println("\nDisplay Board Awal & Akhir :");
            this.path.get(0).displayBoard();
        } else {
            System.out.println("\nDisplay Board Awal :");
            this.path.get(0).displayBoard();
            
            for (int i = 0; i < this.moves.size(); i++) {
                System.out.printf("\n%sMOVE %d : %s%s\n", ANSI_BOLD + ANSI_PURPLE, (i + 1), this.moves.get(i), ANSI_RESET);
                displayBoardWithHighlight(this.path.get(i), this.path.get(i + 1), this.moves.get(i));
            }
            System.out.printf("\nMOVE %d : P - OUT %s (%d STEP)\n" , this.moves.size() + 1 , switch (this.moves.get(this.moves.size() - 1).getDirection()) {
                case UP -> "UP";
                case DOWN -> "DOWN";
                case RIGHT -> "RIGHT";
                case LEFT -> "LEFT";
                default -> "UNKNOWN";
            } , this.path.get(0).getPieces().stream().filter(pc -> pc.getType() == 'P').findFirst().orElseThrow().solveSize());
            this.path.get(this.moves.size() - 1).displayLastBoard();
        }
        
        System.out.println(ANSI_BOLD + "==================================================" + ANSI_RESET);
        System.out.println(ANSI_BOLD + "RECALL INFORMATION SOLUTION RESULT :" + ANSI_RESET);
        System.out.printf("Algorithm    : %s%s%s\n", ANSI_CYAN, this.algorithm, ANSI_RESET);
        if (this.heuristicId == 0) {
            System.out.println("Heuristic    : None");
        } else {
            System.out.printf("Heuristic    : %s%d%s\n", ANSI_CYAN, this.heuristicId, ANSI_RESET);
        }
        System.out.printf("Step Count   : %s%d Step%s\n", ANSI_YELLOW, this.stepCount + 1, ANSI_RESET);
        System.out.printf("Visited Node : %s%d Node%s\n", ANSI_YELLOW, this.nodesVisited, ANSI_RESET);
        System.out.printf("Time Usage   : %s%d ms%s\n", ANSI_YELLOW, (int) this.time, ANSI_RESET);
        if (this.moves.isEmpty()) {
            System.out.println("Success      : " + ANSI_RED + "NO" + ANSI_RESET);
        } else {
            System.out.println("Success      : " + ANSI_GREEN + "YES" + ANSI_RESET);
        }
    }

    private void displayColoredBoard(DataStructure data, DataStructure prevData, GameLogic.Move move) {
        // DESKRIPSI LOKAL
        // Display Board From Data Structure To CLI Terminal dengan warna

        // KAMUS LOKAL
        // board : Class Board
        // exit : Class Point
        // width, height, i, j : Integer
        // changedPositions : Set<Point> - posisi yang berubah jika ada move
        
        int width = data.getWidth();
        int height = data.getHeight();
        Point exit = data.getExit();
        Board board = data.getBoard();
        
        // Informasi untuk highlighting perubahan (jika ada)
        Set<Point> oldPositions = new HashSet<>();
        Set<Point> newPositions = new HashSet<>();
        
        if (prevData != null && move != null) {
            char movingPiece = move.getIdType();
            
            // Dapatkan posisi lama
            for (Piece piece : prevData.getPieces()) {
                if (piece.getType() == movingPiece) {
                    oldPositions.addAll(piece.getCoordinates());
                    break;
                }
            }
            
            // Dapatkan posisi baru
            for (Piece piece : data.getPieces()) {
                if (piece.getType() == movingPiece) {
                    newPositions.addAll(piece.getCoordinates());
                    break;
                }
            }
        }

        // ALGORITMA LOKAL - Mengikuti format asli tapi dengan warna
        if (exit.getX() == -1) {
            for (int i = 0; i < height; i++) {
                if (height - 1 - exit.getY() == i) {
                    System.out.print(ANSI_BOLD + ANSI_PURPLE + "K " + ANSI_RESET);
                } else {
                    System.out.print("  ");
                }
                for (int j = 0; j < width; j++) {
                    Point currentPoint = new Point(j, i);
                    char cell = board.getCell(j, i);
                    
                    // Warna untuk piece P
                    if (cell == 'P') {
                        System.out.print(ANSI_BOLD + ANSI_GREEN + cell + " " + ANSI_RESET);
                    } 
                    // Posisi lama dari piece yang bergerak
                    else if (prevData != null && oldPositions.contains(currentPoint) && !newPositions.contains(currentPoint)) {
                        System.out.print(ANSI_BACKGROUND_RED + "  " + ANSI_RESET + " ");
                    } 
                    // Posisi baru dari piece yang bergerak
                    else if (prevData != null && newPositions.contains(currentPoint) && !oldPositions.contains(currentPoint)) {
                        System.out.print(ANSI_BACKGROUND_GREEN + cell + " " + ANSI_RESET);
                    }
                    // Warna default
                    else {
                        System.out.print(cell + " ");
                    }
                }
                System.out.println();
            }
        } else if (exit.getY() == -1) {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    Point currentPoint = new Point(j, i);
                    char cell = board.getCell(j, i);
                    
                    if (cell == 'P') {
                        System.out.print(ANSI_BOLD + ANSI_GREEN + cell + " " + ANSI_RESET);
                    } 
                    else if (prevData != null && oldPositions.contains(currentPoint) && !newPositions.contains(currentPoint)) {
                        System.out.print(ANSI_BACKGROUND_RED + "  " + ANSI_RESET + " ");
                    } 
                    else if (prevData != null && newPositions.contains(currentPoint) && !oldPositions.contains(currentPoint)) {
                        System.out.print(ANSI_BACKGROUND_GREEN + cell + " " + ANSI_RESET);
                    }
                    else {
                        System.out.print(cell + " ");
                    }
                }
                System.out.println();
            }
            for (int i = 0; i < exit.getX(); i++) {
                System.out.print("  ");
            }
            System.out.println(ANSI_BOLD + ANSI_PURPLE + "K" + ANSI_RESET);
        } else if (exit.getY() == height) {
            for (int i = 0; i < exit.getX(); i++) {
                System.out.print("  ");
            }
            System.out.println(ANSI_BOLD + ANSI_PURPLE + "K" + ANSI_RESET);
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    Point currentPoint = new Point(j, i);
                    char cell = board.getCell(j, i);
                    
                    if (cell == 'P') {
                        System.out.print(ANSI_BOLD + ANSI_GREEN + cell + " " + ANSI_RESET);
                    } 
                    else if (prevData != null && oldPositions.contains(currentPoint) && !newPositions.contains(currentPoint)) {
                        System.out.print(ANSI_BACKGROUND_RED + "  " + ANSI_RESET + " ");
                    } 
                    else if (prevData != null && newPositions.contains(currentPoint) && !oldPositions.contains(currentPoint)) {
                        System.out.print(ANSI_BACKGROUND_GREEN + cell + " " + ANSI_RESET);
                    }
                    else {
                        System.out.print(cell + " ");
                    }
                }
                System.out.println();
            }
        } else {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    Point currentPoint = new Point(j, i);
                    char cell = board.getCell(j, i);
                    
                    if (cell == 'P') {
                        System.out.print(ANSI_BOLD + ANSI_GREEN + cell + " " + ANSI_RESET);
                    } 
                    else if (prevData != null && oldPositions.contains(currentPoint) && !newPositions.contains(currentPoint)) {
                        System.out.print(ANSI_BACKGROUND_RED + "  " + ANSI_RESET + " ");
                    } 
                    else if (prevData != null && newPositions.contains(currentPoint) && !oldPositions.contains(currentPoint)) {
                        System.out.print(ANSI_BACKGROUND_GREEN + cell + " " + ANSI_RESET);
                    }
                    else {
                        System.out.print(cell + " ");
                    }
                }
                if (height - 1 - exit.getY() == i) {
                    System.out.print(ANSI_BOLD + ANSI_PURPLE + "K" + ANSI_RESET);
                }
                System.out.println();
            }
        }
    }
    
    /**
     * Menampilkan board terakhir dengan warna
     */
    private void displayLastBoardColored(DataStructure data) {
        displayColoredBoard(data, null, null);
    }

    private void displayBoardWithHighlight(DataStructure prevBoard, DataStructure currentBoard, GameLogic.Move move) {
        displayColoredBoard(currentBoard, prevBoard, move);
        System.out.println("\nKeterangan:");
        System.out.println(ANSI_BACKGROUND_RED + "  " + ANSI_RESET + " : Posisi lama dari piece " + move.getIdType());
        System.out.println(ANSI_BACKGROUND_GREEN + move.getIdType() + " " + ANSI_RESET + " : Posisi baru dari piece " + move.getIdType());
        System.out.println(ANSI_BOLD + ANSI_GREEN + "P" + ANSI_RESET + " : Piece yang harus keluar");
        System.out.println(ANSI_BOLD + ANSI_PURPLE + "K" + ANSI_RESET + " : Posisi pintu keluar");
    }
}