/* Kelompok   : Kelompok Tucil3_13523021_13523095                                */
/* Nama - 1   : Muhammad Raihan Nazhim Oktana                                    */
/* NIM - 1    : K01 - 13523021 - Teknik Informatika (IF-Ganesha) ITB             */
/* Nama - 2   : Rafif Farras                                                     */
/* NIM - 2    : K02 - 13523095 - Teknik Informatika (IF-Ganesha) ITB             */
/* Tanggal    : Selasa, 20 Mei 2025                                              */
/* Tugas      : Tugas Kecil 3 - Strategi Algoritma (IF2211-24)                   */
/* File Path  : Tucil3_13523021_13523095/src/algorithm/AStar.java                */
/* Deskripsi  : F04 - AStar Pathfinding Algorithm                                */
/* PIC F04    : K02 - 13523095 - Rafif Farras                                    */

// Package & Import
package algorithm;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

import game.GameLogic;
import game.GameState;
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

    public static Solution solveAStar(DataStructure dataStructure, int num) {
        long startTime = System.nanoTime();
        Set<String> visited = new HashSet<>();
        Map<String, Integer> bestCost = new HashMap<>();
        PriorityQueue<Solution.Node> pq = new PriorityQueue<>((node1, node2) -> {
            int f1 = node1.gValue + node1.hValue;
            int f2 = node2.gValue + node2.hValue;
            return f1 != f2 ? Integer.compare(f1, f2) : Integer.compare(node1.hValue, node2.hValue);
        });
    
        String startKey = GameLogic.boardKey(dataStructure);
        int startH = Heuristic.solveHeuristic(dataStructure, num);
        Solution.Node startNode = new Solution.Node(dataStructure, null, 0, startH, null);
        pq.add(startNode);
        bestCost.put(startKey, 0);
        
        System.out.println("DEBUG: Starting A* Search");
        System.out.println("Initial State:");
        dataStructure.displayDataStructure();
        System.out.println("Initial h = " + startH);
    
        int cnt = 0;
        int maxIterations = 100000; // Menambahkan batas maksimum iterasi untuk mencegah loop tak berujung
        
        while (!pq.isEmpty() && cnt < maxIterations) {
            Solution.Node cur = pq.poll();
            String curKey = GameLogic.boardKey(cur.state);
            
            // Skip jika state sudah dikunjungi dan cost-nya tidak lebih baik
            if (visited.contains(curKey) && bestCost.get(curKey) <= cur.gValue) {
                continue;
            }
            
            visited.add(curKey);
            cnt++;
            
            int f = cur.gValue + cur.hValue;
            System.out.println("\nDEBUG: Step " + cnt);
            System.out.println("Current state:");
            System.out.println("g = " + cur.gValue + ", h = " + cur.hValue + ", f = " + f);
            
            // Periksa apakah puzzle telah diselesaikan
            if (GameState.isSolved(cur.state)) {
                long endTime = System.nanoTime();
                double timeInMs = (endTime - startTime) / 1_000_000.0;
                System.out.println("DEBUG: Solution found!");
                System.out.println("Total steps explored: " + cnt);
                System.out.println("Execution time: " + timeInMs + " ms");
                return Solution.buildSolution("A-Star", num, cnt, timeInMs, cur);
            }
            
            // Coba semua gerakan yang mungkin
            for (GameLogic.Move move : GameLogic.generateMoves(cur.state)) {
                DataStructure nxt = GameLogic.applyMove(cur.state, move);
                String nxtKey = GameLogic.boardKey(nxt);
                int g = cur.gValue + 1;
                
                // Evaluasi state baru jika belum pernah dikunjungi atau memiliki cost yang lebih baik
                if (!visited.contains(nxtKey) || g < bestCost.getOrDefault(nxtKey, Integer.MAX_VALUE)) {
                    int h = Heuristic.solveHeuristic(nxt, num);
                    bestCost.put(nxtKey, g);
                    Solution.Node childNode = new Solution.Node(nxt, move, g, h, cur);
                    pq.add(childNode);
                    
                    System.out.println("DEBUG: Added child state with move: " + move);
                    System.out.println("    g = " + g + ", h = " + h + ", f = " + (g + h));
                    // Uncomment untuk mencetak state
                    // nxt.displayBoard();
                }
            }
        }
        
        if (cnt >= maxIterations) {
            System.out.println("DEBUG: Stopped after " + maxIterations + " iterations to prevent infinite loop.");
        } else {
            System.out.println("DEBUG: No solution found after exploring " + cnt + " states.");
        }
        
        return null;
    }
}