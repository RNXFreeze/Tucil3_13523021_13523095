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
import game.GameLogic;
import game.GameState;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
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
    
        int cnt = 0;// Menambahkan batas maksimum iterasi untuk mencegah loop tak berujung
        
        while (!pq.isEmpty()) {
            Solution.Node cur = pq.poll();
            String curKey = GameLogic.boardKey(cur.state);
            
            // Skip jika state sudah dikunjungi dan cost-nya tidak lebih baik
            if (visited.contains(curKey) && bestCost.get(curKey) <= cur.gValue) {
                continue;
            }
            
            visited.add(curKey);
            cnt++;
            
            int f = cur.gValue + cur.hValue;
            
            // Periksa apakah puzzle telah diselesaikan
            if (GameState.isSolved(cur.state)) {
                long endTime = System.nanoTime();
                double timeInMs = (endTime - startTime) / 1_000_000.0;
                return Solution.buildSolution("A-Star", num, cnt, timeInMs, cur);
            }
            
            // Coba semua gerakan yang mungkin
            for (GameLogic.Move move : GameLogic.generateMoves(cur.state)) {
                DataStructure nxt = GameLogic.applyMove(cur.state, move);
                String nxtKey = GameLogic.boardKey(nxt);
                int g = cur.gValue + 1;
                
                // Evaluasi state baru jika belum pernah dikunjungi atau memiliki cost yang lebih baik
                if (!visited.contains(nxtKey) || g < bestCost.getOrDefault(nxtKey , Integer.MAX_VALUE)) {
                    int h = Heuristic.solveHeuristic(nxt , num);
                    bestCost.put(nxtKey , g);
                    Solution.Node childNode = new Solution.Node(nxt , move , g , h , cur);
                    pq.add(childNode);
                }
            }
        }
        
        return null;
    }
}