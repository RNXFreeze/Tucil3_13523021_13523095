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
        // Menampilkan solusi dalam format CLI yang terstruktur

        // KAMUS LOKAL
        // algorithm : String
        // heuristicId , nodesVisited , i : Integer
        // time : Double
        // path : List of Class DataStructure
        // moves : List of Class GameLogic Sub Class Move

        // ALGORITMA LOKAL
        System.out.println("==================================================");
        System.out.println("INFORMATION SOLUTION RESULT :");
        System.out.printf("Algorithm    : %s\n" , this.algorithm);
        if (this.heuristicId == 0) {
            System.out.println("Heuristic    : None");
        } else {
            System.out.printf("Heuristic    : %d\n" , this.heuristicId);
        }
        System.out.printf("Step Count   : %d Step\n" , this.stepCount + 1);
        System.out.printf("Visited Node : %d Node\n" , this.nodesVisited);
        System.out.printf("Time Usage   : %d ms\n" , (int) this.time);
        if (this.moves.isEmpty()) {
            System.out.println("Success      : NO");
        } else {
            System.out.println("Success      : YES");
        }
        System.out.println("==================================================");
        if (this.moves.isEmpty()) {
            System.out.println("\nDisplay Board Awal & Akhir :");
            this.path.get(0).displayBoard();
        } else {
            System.out.println("Display Board Awal :");
            this.path.get(0).displayBoard();
            for (int i = 0 ; i < this.moves.size() ; i++) {
                System.out.printf("\nMOVE %d : %s\n" , (i + 1) , this.moves.get(i));
                this.path.get(i + 1).displayBoard();
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
        System.out.println("==================================================");
        System.out.println("RECALL INFORMATION SOLUTION RESULT :");
        System.out.printf("Algorithm    : %s\n" , this.algorithm);
        if (this.heuristicId == 0) {
            System.out.println("Heuristic    : None");
        } else {
            System.out.printf("Heuristic    : %d\n" , this.heuristicId);
        }
        System.out.printf("Step Count   : %d Step\n" , this.stepCount + 1);
        System.out.printf("Visited Node : %d Node\n" , this.nodesVisited);
        System.out.printf("Time Usage   : %d ms\n" , (int) this.time);
        if (this.moves.isEmpty()) {
            System.out.println("Success      : NO");
        } else {
            System.out.println("Success      : YES");
        }
    }
}