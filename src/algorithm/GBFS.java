/* Kelompok   : Kelompok Tucil3_13523021_13523095                                */
/* Nama - 1   : Muhammad Raihan Nazhim Oktana                                    */
/* NIM - 1    : K01 - 13523021 - Teknik Informatika (IF-Ganesha) ITB             */
/* Nama - 2   : Rafif Farras                                                     */
/* NIM - 2    : K02 - 13523095 - Teknik Informatika (IF-Ganesha) ITB             */
/* Tanggal    : Rabu, 21 Mei 2025                                                */
/* Tugas      : Tugas Kecil 3 - Strategi Algoritma (IF2211-24)                   */
/* File Path  : Tucil3_13523021_13523095/src/algorithm/GBFS.java                 */
/* Deskripsi  : F03 - GBFS (Greedy Best First Search) Pathfinding Algorithm      */
/* PIC F03    : K01 - 13523021 - Muhammad Raihan Nazhim Oktana                   */

// Package & Import
package algorithm;
import game.*;
import java.util.*;
import utils.*;

// Class Definition & Implementation
public class GBFS {
    // DESKRIPSI
    // Public Class GBFS
    
    // KAMUS
    // GBFS : Constructor Class GBFS
    // solveGBFS : Function

    // PRIVATE ATTRIBUTES
    // None
    
    private GBFS() {
        // DESKRIPSI LOKAL
        // Instansiasi Constructor Class GBFS
        
        // KAMUS LOKAL
        // None

        // ALGORITMA LOKAL
        // None
    }

    public static Solution solveGBFS(String filePath , DataStructure dataStructure , int num) {
        // DESKRIPSI LOKAL
        // Fungsi Utama GBFS : Menyelesaikan pencarian jalur terpendek dari dataStructure dan tipe heuristiknya.
        // GBFS : Greedy Best First Search berdasarkan heuristik yang dihitung.
        
        // KAMUS LOKAL
        // dataStructure , nxt : Class DataStructure
        // pq : Priority Queue of Class Solution Sub Class Node
        // node , cur : Class Solution Sub Class Node
        // solveHeuristic : Function Class Heuristic
        // visited : HashSet of String
        // startTime , endTime : Long
        // num , cnt : Integer
        // time : Double
        // filePath , key : String

        // ALGORITMA LOKAL
        long startTime = System.nanoTime();
        int cnt = 0;
        Set<String> visited = new HashSet<>();
        PriorityQueue<Solution.Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.hValue));
        pq.add(new Solution.Node(dataStructure , null , 0 , Heuristic.solveHeuristic(dataStructure , num) , null));
        while (!pq.isEmpty()) {
            Solution.Node cur = pq.poll();
            if (visited.add(GameLogic.boardKey(cur.state))) {
                cnt++;
                if (GameState.isSolved(cur.state)) {
                    long endTime = System.nanoTime();
                    double time = (endTime - startTime) / 1000000;
                    return Solution.buildSolution(filePath , "Greedy Best First Search (GBFS)" , num , cnt , time , cur);
                } else {
                    for (GameLogic.Move move : GameLogic.generateMoves(cur.state)) {
                        DataStructure nxt = GameLogic.applyMove(cur.state , move);
                        pq.add(new Solution.Node(nxt , move , 0 , Heuristic.solveHeuristic(nxt , num) , cur));
                    }
                }
            }
        }
        long endTime = System.nanoTime();
        double time = (endTime - startTime) / 1000000;
        return Solution.buildSolution(filePath , "Greedy Best First Search (GBFS)" , num , cnt , time , new Solution.Node(dataStructure , null , 0 , 0 , null));
    }
}