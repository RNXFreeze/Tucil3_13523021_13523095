/* Kelompok   : Kelompok Tucil3_13523021_13523095                                */
/* Nama - 1   : Muhammad Raihan Nazhim Oktana                                    */
/* NIM - 1    : K01 - 13523021 - Teknik Informatika (IF-Ganesha) ITB             */
/* Nama - 2   : Rafif Farras                                                     */
/* NIM - 2    : K02 - 13523095 - Teknik Informatika (IF-Ganesha) ITB             */
/* Tanggal    : Rabu, 21 Mei 2025                                                */
/* Tugas      : Tugas Kecil 3 - Strategi Algoritma (IF2211-24)                   */
/* File Path  : Tucil3_13523021_13523095/src/algorithm/AStar.java                */
/* Deskripsi  : F04 - AStar Pathfinding Algorithm                                */
/* PIC F04    : K02 - 13523095 - Rafif Farras                                    */

// Package & Import
package algorithm;
import game.*;
import java.util.*;
import utils.*;

// Class Definition & Implementation
public class AStar {
    // DESKRIPSI
    // Public Class AStar
    
    // KAMUS
    // AStar : Constructor Class AStar
    // solveAStar : Function

    // PRIVATE ATTRIBUTES
    // None
    
    private AStar() {
        // DESKRIPSI LOKAL
        // Instansiasi Constructor Class AStar
        
        // KAMUS LOKAL
        // None

        // ALGORITMA LOKAL
        // None
    }

    public static Solution solveAStar(String filePath , DataStructure dataStructure , int num) {
        // DESKRIPSI LOKAL
        // Fungsi Utama AStar : Menyelesaikan pencarian jalur terpendek dari dataStructure dan tipe heuristiknya.
        // AStar : A* Algorithm Search berdasarkan heuristik yang dihitung.
        
        // KAMUS LOKAL
        // dataStructure , nxt : Class DataStructure
        // pq : Priority Queue of Class Solution Sub Class Node
        // node1 , node2 , cur , childNode : Class Solution Sub Class Node
        // solveHeuristic : Function Class Heuristic
        // visited : HashSet of String
        // bestCost : HashMap of String To Integer
        // startTime , endTime : Long
        // num , cnt , f1 , f2 , gValue , hValue : Integer
        // time : Double
        // filePath , key : String

        // ALGORITMA LOKAL
        long startTime = System.nanoTime();
        Set<String> visited = new HashSet<>();
        Map<String , Integer> bestCost = new HashMap<>();
        PriorityQueue<Solution.Node> pq = new PriorityQueue<>((node1 , node2) -> {
            int f1 = node1.solveF();
            int f2 = node2.solveF();
            if (f1 != f2) {
                return Integer.compare(f1 , f2);
            } else {
                return Integer.compare(node1.hValue , node2.hValue);
            } 
        });
        String key = GameLogic.boardKey(dataStructure);
        pq.add(new Solution.Node(dataStructure , null , 0 , Heuristic.solveHeuristic(dataStructure , num) , null));
        bestCost.put(key , 0);
        int cnt = 0;
        Solution.Node res = null;
        while (!pq.isEmpty()) {
            Solution.Node cur = pq.poll();
            key = GameLogic.boardKey(cur.state);
            if (!visited.contains(key) || bestCost.get(key) > cur.gValue) {
                cnt++;
                visited.add(key);
                if (GameState.isSolved(cur.state)) {
                    if (res == null || cur.gValue < res.gValue) {
                        res = cur;
                    }
                } else {
                    for (GameLogic.Move move : GameLogic.generateMoves(cur.state)) {
                        DataStructure nxt = GameLogic.applyMove(cur.state , move);
                        String nxtKey = GameLogic.boardKey(nxt);
                        int gValue = cur.gValue + 1;
                        if (!visited.contains(nxtKey) || gValue < bestCost.getOrDefault(nxtKey , Integer.MAX_VALUE)) {
                            int hValue = Heuristic.solveHeuristic(nxt , num);
                            bestCost.put(nxtKey , gValue);
                            Solution.Node childNode = new Solution.Node(nxt , move , gValue , hValue , cur);
                            pq.add(childNode);
                        }
                    }
                }
            }
        }
        long endTime = System.nanoTime();
        double time = (endTime - startTime) / 1000000;
        if (res != null) {
            return Solution.buildSolution(filePath , "A-Star Search (A*)" , num , cnt , time , res);
        } else {
            return Solution.buildSolution(filePath , "A-Star Search (A*)" , num , cnt , time , new Solution.Node(dataStructure , null , 0 , 0 , null));
        }
    }
}