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
    // DESKRIPSI
    // Public Class Reader

    // KAMUS
    // Reader : Constructor Class Reader
    // readFile , readPieces , determineOrientation : Procedure

    // PRIVATE ATTRIBUTES
    // None

    private Reader() {
        // DESKRIPSI LOKAL
        // Instansiasi Constructor Class Reader
        
        // KAMUS LOKAL
        // None

        // ALGORITMA LOKAL
        // None
    }

    public static DataStructure readFile(String filePath) throws IOException {
        // DESKRIPSI LOKAL
        // Melakukan read pada file yang telah ditentukan pathnya.
        
        // KAMUS LOKAL
        // filePath , line , firstLine , lines , trimmed , row : String
        // path : Path
        // reader : Java IO BufferedReader
        // dimensions : Array of String
        // rawLines , trimmedLines : List of String
        // pieces : List of Class Piece
        // grid : Matrix of Character
        // board : Class Board
        // exit : Class Point
        // c : Character
        // width , height , pieceCount , newY , x , i , j : Integer

        // ALGORITMA LOKAL
        Path path = Paths.get(filePath);
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String[] dimensions = reader.readLine().trim().split("\\s+");
            int width = Integer.parseInt(dimensions[0]);
            int height = Integer.parseInt(dimensions[1]);
            int pieceCount = Integer.parseInt(reader.readLine().trim());
            List<String> rawLines = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                rawLines.add(line);
            }
            Point exit = null;
            if (!rawLines.isEmpty() && rawLines.get(0).trim().equals("K")) {
                String firstLine = rawLines.get(0); 
                int x = firstLine.indexOf('K');
                exit = new Point(x, height);
                rawLines.remove(0);
            }
            if (!rawLines.isEmpty() && rawLines.get(rawLines.size() - 1).trim().equals("K")) {
                String lastLine = rawLines.get(rawLines.size() - 1);
                int x = lastLine.indexOf('K');
                exit = new Point(x, -1);
                rawLines.remove(rawLines.size() - 1);
            }
            List<String> trimmedLines = new ArrayList<>();
            for (String lines : rawLines) {
                if (lines != null) {
                    String trimmed = lines.trim();
                    if (!trimmed.isEmpty()) {
                        trimmedLines.add(trimmed);
                    }
                }
            }
            if (trimmedLines.size() != height) {
                throw new IOException("Jumlah baris grid (" + trimmedLines.size() + ") tidak sesuai dimensi height (" + height + ")");
            } else {
                for (int i = 0 ; i < height ; i++) {
                    String row = trimmedLines.get(i);
                    if (row.startsWith("K")) {
                        int newY = (i + height - 1);
                        if (newY >= height) {
                            newY -= ((newY - (height - 1)) * 2);
                        }
                        exit = new Point(-1 , newY); 
                        trimmedLines.set(i , row.substring(1)); 
                    } else if (row.endsWith("K")) {
                        int newY = (i + height - 1);
                        if (newY >= height) {
                            newY -= ((newY - (height - 1)) * 2);
                        }
                        exit = new Point(width , newY); 
                        trimmedLines.set(i , row.substring(0 , row.length() - 1)); 
                    }
                }
                char[][] grid = new char[height][width];
                Board board = new Board(width , height);
                for (int i = 0 ; i < height ; i++) {
                    String row = trimmedLines.get(i);
                    for (int j = 0 ; j < width ; j++) {
                        char c = '.';
                        if ((j < row.length())) {
                            c = row.charAt(j);
                        }
                        grid[i][j] = c;
                        board.setCell(j , i , c);
                    }
                }
                List<Piece> pieces = readPieces(grid);
                return new DataStructure(width , height , pieceCount , exit , board , pieces);
            }
        }
    }

    public static List<Piece> readPieces(char[][] grid) {
        // DESKRIPSI LOKAL
        // Melakukan pembacaan pieces pada grid yang telah diread sebelumnya.
        
        // KAMUS LOKAL
        // pieceCoordinates : Map From Key Character To Value List of Class Point
        // pieces : List of Class Piece
        // coords : List of Class Point
        // grid : Matrix of Character
        // cell , type : Character
        // entry : Map Entry
        // width , height , orientation , i , j : Integer

        // ALGORITMA LOKAL
        int height = grid.length;
        int width = grid[0].length;
        Map<Character , List<Point>> pieceCoordinates = new HashMap<>();
        for (int i = 0 ; i < height ; i++) {
            for (int j = 0 ; j < width ; j++) {
                char cell = grid[i][j];
                if (!pieceCoordinates.containsKey(cell)) {
                    pieceCoordinates.put(cell , new ArrayList<>());
                }
                pieceCoordinates.get(cell).add(new Point(j , i));
            }
        }
        List<Piece> pieces = new ArrayList<>();
        for (Map.Entry<Character , List<Point>> entry : pieceCoordinates.entrySet()) {
            char type = entry.getKey();
            List<Point> coords = entry.getValue();
            int orientation = determineOrientation(coords);
            pieces.add(new Piece(type , coords , orientation));
        }
        return pieces;
    }

    public static int determineOrientation(List<Point> coordinates) {
        // DESKRIPSI LOKAL
        // Melakukan penentuan orientasi sebuah piece berdasarkan titik-titik koordinatnya.
        
        // KAMUS LOKAL
        // coordinates : List of Class Point
        // grid : Matrix of Character
        // point : Class Point
        // cell , type : Character
        // firstX , firstY : Integer
        // isHorizontal : boolean

        // ALGORITMA LOKAL
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