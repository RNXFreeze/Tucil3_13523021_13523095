/* Kelompok   : Kelompok Tucil3_13523021_13523095                                */
/* Nama - 1   : Muhammad Raihan Nazhim Oktana                                    */
/* NIM - 1    : K01 - 13523021 - Teknik Informatika (IF-Ganesha) ITB             */
/* Nama - 2   : Rafif Farras                                                     */
/* NIM - 2    : K02 - 13523095 - Teknik Informatika (IF-Ganesha) ITB             */
/* Tanggal    : Rabu, 21 Mei 2025                                                */
/* Tugas      : Tugas Kecil 3 - Strategi Algoritma (IF2211-24)                   */
/* File Path  : Tucil3_13523021_13523095/src/utils/Reader.java                   */
/* Deskripsi  : F08 - File Reader Utility                                        */
/* PIC F08    : K02 - 13523095 - Rafif Farras                                    */

// Package & Import
package utils;
import java.io.*;
import java.nio.file.*;
import java.util.*;

// Class Definition & Implementation
public class Reader {
    public static DataStructure readFile(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String[] dimensions = reader.readLine().trim().split("\\s+");
            int width = Integer.parseInt(dimensions[0]);
            int height = Integer.parseInt(dimensions[1]);
            
            int pieceCount = Integer.parseInt(reader.readLine().trim());
    
            // Baca semua baris setelah jumlah piece ke list (BELUM di-trim)
            List<String> rawLines = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                rawLines.add(line);
            }

            Point keluar = null;

            if (!rawLines.isEmpty() && rawLines.get(0).trim().equals("K")) {
                String firstLine = rawLines.get(0); 
                int x = firstLine.indexOf('K');
                keluar = new Point(x, height);
                rawLines.remove(0);
            }

            if (!rawLines.isEmpty() && rawLines.get(rawLines.size() - 1).trim().equals("K")) {
                String lastLine = rawLines.get(rawLines.size() - 1);
                int x = lastLine.indexOf('K');
                keluar = new Point(x, -1);
                rawLines.remove(rawLines.size() - 1);
            }

            List<String> trimmedLines = new ArrayList<>();
            for (String l : rawLines) {
                if (l != null) {
                    String trimmed = l.trim();
                    if (!trimmed.isEmpty()) {
                        trimmedLines.add(trimmed);
                    }
                }
            }
            
            if (trimmedLines.size() != height) {
                throw new IOException("Jumlah baris grid (" + trimmedLines.size() + ") tidak sesuai dimensi height (" + height + ")");
            }
    
            for (int i = 0; i < height; i++) {
                String row = trimmedLines.get(i);
                if (row.startsWith("K")) {
                    int newY = (i + height - 1);
                    if (newY >= height) {
                        newY -= ((newY - (height - 1))*2);
                    }
                    keluar = new Point(-1, newY); 
                    trimmedLines.set(i, row.substring(1));
                } else if (row.endsWith("K")) {
                    int newY = (i + height - 1);
                    if (newY >= height) {
                        newY -= ((newY - (height - 1))*2);
                    }
                    keluar = new Point(width, newY); 
                    trimmedLines.set(i, row.substring(0, row.length() - 1)); 
                }
            }
    
            char[][] grid = new char[height][width];
            Board board = new Board(width, height);
    
            for (int i = 0; i < height; i++) {
                String row = trimmedLines.get(i);
                for (int j = 0; j < width; j++) {
                    char c = (j < row.length()) ? row.charAt(j) : '.';
                    grid[i][j] = c;
                    board.setCell(j , i , c);
                }
            }
    
            List<Piece> pieces = readPieces(grid);
    
            return new DataStructure(width, height, pieceCount, keluar, board, pieces);
        }
    }

    public static List<Piece> readPieces(char[][] grid) {
        int height = grid.length;
        int width = grid[0].length;
        
        Map<Character, List<Point>> pieceCoordinates = new HashMap<>();
        
        // Scan grid
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                char cell = grid[i][j];
                if (!pieceCoordinates.containsKey(cell)) {
                    pieceCoordinates.put(cell, new ArrayList<>());
                }
                pieceCoordinates.get(cell).add(new Point(j, i));  // X=j, Y=i (kolom, baris)
            }
        }
        
        List<Piece> pieces = new ArrayList<>();
        for (Map.Entry<Character, List<Point>> entry : pieceCoordinates.entrySet()) {
            char type = entry.getKey();
            List<Point> coords = entry.getValue();

            // for (Point point : coords) {
            //     int newY = (point.getY() + height - 1);
            //     if (newY >= height) {
            //         newY -= ((newY - (height - 1))*2);
            //     }
            //     point.setY(newY);
            // }
        
            int orientation = determineOrientation(coords);
        
            pieces.add(new Piece(type, coords, orientation));
        }
        
        return pieces;
    }

    public static int determineOrientation(List<Point> coordinates) {
        boolean isHorizontal = true;
        int firstX = coordinates.get(0).getX();
        int firstY = coordinates.get(0).getY();
        for (Point point : coordinates) {
            if (point.getY() != firstY) {
                isHorizontal = false;
                break;
            }
            if (point.getX() != firstX) {
                break;
            }
        }
        if (isHorizontal) {
            return 0; 
        } else {
            return 1;
        }
    }
}