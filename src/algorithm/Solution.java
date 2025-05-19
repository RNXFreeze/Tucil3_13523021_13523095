/* Kelompok   : Kelompok Tucil3_13523021_13523095                                */
/* Nama - 1   : Muhammad Raihan Nazhim Oktana                                    */
/* NIM - 1    : K01 - 13523021 - Teknik Informatika (IF-Ganesha) ITB             */
/* Nama - 2   : Rafif Farras                                                     */
/* NIM - 2    : K02 - 13523095 - Teknik Informatika (IF-Ganesha) ITB             */
/* Tanggal    : Selasa, 20 Mei 2025                                              */
/* Tugas      : Tugas Kecil 3 - Strategi Algoritma (IF2211-24)                   */
/* File Path  : Tucil3_13523021_13523095/src/algorithm/Solution.java             */
/* Deskripsi  : F06 - Solution Pathfinding Algorithm                             */
/* PIC F06    : K01 - 13523021 - Muhammad Raihan Nazhim Oktana                   */

// Package & Import
package algorithm;
import game.*;
import java.util.List;
import utils.*;

// Class Definition & Implementation
public final class Solution {
    // DESKRIPSI
    // Public Class Solution - Menyimpan hasil lengkap path-finding dan prosedur tampilan

    // KAMUS
    // Solution : Constructor Class Solution
    // displaySolution : Procedure cetak hasil solusi

    // PRIVATE ATTRIBUTES
    private String algorithm;
    private int heuristicId;
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

    public void displaySolution() {
        // DESKRIPSI LOKAL
        // Menampilkan solusi dalam format CLI yang terstruktur

        // KAMUS LOKAL
        // algorithm : String
        // heuristicId : Integer
        // nodesVisited : Integer
        // time : Double
        // path : List of Class DataStructure
        // moves : List of Class GameLogic Sub Class Move
        // i : Integer

        // ALGORITMA LOKAL
        System.out.println("\u250C\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500 SOLUTION \u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2510");
        System.out.printf("\u2502  Algorithm : %-10s   Heuristic : %d%n" , this.algorithm , this.heuristicId);
        System.out.printf("\u2502  Depth     : %-10d   Visited   : %d%n" , this.stepCount , this.nodesVisited);
        System.out.printf("\u2502  Time      : %.3f ms%n" , this.time);
        System.out.println("\u2514\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2518\n");
        System.out.println("Papan Awal :");
        System.out.print(this.path.get(0).getBoard().toString());
        for (int i = 0 ; i < this.moves.size() ; i++) {
            System.out.printf("%nGerakan %d : %s%n" , (i + 1) , this.moves.get(i));
            System.out.print(this.path.get(i + 1).getBoard().toString());
        }
    }
}