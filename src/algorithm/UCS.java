/* Kelompok   : Kelompok Tucil3_13523021_13523095                                */
/* Nama - 1   : Muhammad Raihan Nazhim Oktana                                    */
/* NIM - 1    : K01 - 13523021 - Teknik Informatika (IF-Ganesha) ITB             */
/* Nama - 2   : Rafif Farras                                                     */
/* NIM - 2    : K02 - 13523095 - Teknik Informatika (IF-Ganesha) ITB             */
/* Tanggal    : Selasa, 20 Mei 2025                                              */
/* Tugas      : Tugas Kecil 3 - Strategi Algoritma (IF2211-24)                   */
/* File Path  : Tucil3_13523021_13523095/src/algorithm/UCS.java                  */
/* Deskripsi  : F02 - UCS (Uniform Cost Search) Pathfinding Algorithm            */
/* PIC F02    : K01 - 13523021 - Muhammad Raihan Nazhim Oktana                   */

// Package & Import
package algorithm;
import game.*;
import java.util.*;
import utils.*;

// Class Definition & Implementation
public class UCS {
    // DESKRIPSI
    // Public Class UCS
    
    // KAMUS
    // UCS : Constructor Class UCS
    // solveUCS : Function

    // PRIVATE ATTRIBUTES
    // None

    private UCS() {
        // DESKRIPSI LOKAL
        // Instansiasi Constructor Class UCS
        
        // KAMUS LOKAL
        // None

        // ALGORITMA LOKAL
        // None
    }

    public static Solution solveUCS(DataStructure dataStructure , int num) {
        // DESKRIPSI LOKAL
        // Fungsi Utama UCS : Menyelesaikan pencarian jalur terpendek dari dataStructure dan tipe heuristiknya.
        // UCS Blind Search : Tidak Menggunakan Heuristik Apapun (BFS Uniform).
        
        // KAMUS LOKAL
        // dataStructure , nxt : Class DataStructure
        // pq : Priority Queue of Class Solution Sub Class Node
        // node , cur : Class Solution Sub Class Node
        // visited : HashSet of String
        // startTime , endTime : Long
        // num , cnt : Integer
        // time : Double
        // key : String

        // ALGORITMA LOKAL
        long startTime = System.nanoTime();
        PriorityQueue<Solution.Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.gValue));
        Set<String> visited = new HashSet<>();
        pq.add(new Solution.Node(dataStructure , null , 0 , 0 , null));
        visited.add(GameLogic.boardKey(dataStructure));
        int cnt = 0;
        while (!pq.isEmpty()) {
            cnt++;
            System.out.println("Count Step : " + cnt + " || Queue Size : " + pq.size());
            Solution.Node cur = pq.poll();
            Solution.buildSolution("UCS Trial" , num , cnt , 1 , cur).displaySolution();
            if (GameState.isSolved(cur.state) || cnt == 100) {
                long endTime = System.nanoTime();
                double time = (endTime - startTime) / 1000000;
                return Solution.buildSolution("UCS" , num , cnt , time , cur);
            } else {
                for (GameLogic.Move move : GameLogic.generateMoves(cur.state)) {
                    DataStructure nxt = GameLogic.applyMove(cur.state , move);
                    String key = GameLogic.boardKey(nxt);
                    if (visited.add(key)) {
                        pq.add(new Solution.Node(nxt , move , cur.gValue + 1 , 0 , cur));
                    }
                }
            }
        }
        return null;
    }
}