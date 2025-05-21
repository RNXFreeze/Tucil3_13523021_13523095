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
    // readFile , readPieces , determineOrientation , isContiguous : Procedure

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
        // isHorizontal : Boolean

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

    private static boolean isContiguous(Piece piece) {
        // DESKRIPSI LOKAL
        // Mengecek apakah sebuah piece ukuran dan bentuknya valid.
        
        // KAMUS LOKAL
        // coords : List of Class Point
        // sameRow , sameCol : Boolean
        // piece : Class Piece

        // ALGORITMA LOKAL
        List<Point> coords = piece.getCoordinates();
        if (coords.size() <= 1) {
            return false;
        } else {
            boolean sameRow = (coords.stream().mapToInt(Point::getY).distinct().count() == 1);
            boolean sameCol = (coords.stream().mapToInt(Point::getX).distinct().count() == 1);
            if (!(sameRow ^ sameCol)) {
                return false;
            } else {
                coords = new ArrayList<>(coords);
                if (sameRow) {
                    coords.sort(Comparator.comparingInt(Point::getX));
                    for (int i = 1 ; i < coords.size() ; i++) {
                        if (coords.get(i).getX() != coords.get(i - 1).getX() + 1) {
                            return false;
                        }
                    }
                } else {
                    coords.sort(Comparator.comparingInt(Point::getY));
                    for (int i = 1 ; i < coords.size() ; i++) {
                        if (coords.get(i).getY() != coords.get(i - 1).getY() + 1) {
                            return false;
                        }
                    }
                }
                return true;
            }
        }
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
        // piece : Class Piece
        // exit : Class Point
        // c : Character
        // onEdge , inside , inCorner , checkp : Boolean
        // width , height , pieceCount , newY , x , cntk , cntp , i , j : Integer

        // ALGORITMA LOKAL
        Path path = Paths.get(filePath);
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String[] dimensions = reader.readLine().trim().split("\\s+");
            if (dimensions.length != 2) {
                throw new IOException("Baris Ke-1 Harus Berisi 2 Bilangan Bulat : Width & Height (A & B)");
            } else {
                int width , height;
                try {
                    width  = Integer.parseInt(dimensions[0]);
                    height = Integer.parseInt(dimensions[1]);
                } catch (NumberFormatException e) {
                    throw new IOException("Width & Height Harus Bilangan Bulat Positif");
                }
                if (width <= 0 || height <= 0) {
                    throw new IOException("Width & Height Harus Bilangan Bulat Positif");
                } else {
                    int pieceCount;
                    try {
                        pieceCount = Integer.parseInt(reader.readLine().trim());
                    } catch (NumberFormatException e) {
                        throw new IOException("Baris Ke-2 Harus Berisi 1 Bilangan Bulat Non-Negatif : Piece Count (N)");
                    }
                    int area = width * height;
                    int maxn = (area - 2) / 2;
                    if (pieceCount > maxn || pieceCount >= 25 || pieceCount < 0) {
                        throw new IOException("Nilai N Harus Bilangan Bulat Non-Negatif Kurang Dari 1/2 * (Area - 2) & Kurang dari 25");
                    }
                    List<String> rawLines = new ArrayList<>();
                    String line;
                    int cntk = 0;
                    while ((line = reader.readLine()) != null) {
                        rawLines.add(line);
                        for (int i = 0 ; i < line.length() ; i++) {
                            if (line.charAt(i) == 'K') {
                                cntk++;
                            }
                            if (cntk > 1) {
                                throw new IOException("Exit Position (K) Terdefinisi Lebih Dari Sekali");
                            }
                        }
                    }
                    Point exit = null;
                    if (!rawLines.isEmpty() && rawLines.get(0).trim().equals("K")) {
                        exit = new Point(rawLines.get(0).indexOf('K') , height);
                        rawLines.remove(0);
                    }
                    if (!rawLines.isEmpty() && rawLines.get(rawLines.size()-1).trim().equals("K")) {
                        exit = new Point(rawLines.get(rawLines.size()-1).indexOf('K') , -1);
                        rawLines.remove(rawLines.size() - 1);
                    }
                    boolean hasLeftExit = rawLines.stream().anyMatch(s -> s != null && s.length() > 0 && s.charAt(0) == 'K');
                    List<String> trimmedLines = new ArrayList<>();
                    for (String lines : rawLines) {
                        if (lines != null) {
                            if (lines.trim().isEmpty()) {
                                throw new IOException("Konfigurasi Papan Mengandung Baris Kosong Invalid");
                            } else if (hasLeftExit) {
                                if (lines.charAt(0) == 'K') {
                                    String row = lines.substring(1);
                                    if (row.contains(" ")) {
                                        throw new IOException("Konfigurasi Papan Mengandung Spasi Invalid");
                                    } else if (!row.matches("[A-Z\\.]*")) {
                                        throw new IOException("Konfigurasi Papan Mengandung Karakter Invalid");
                                    } else {
                                        int yExit = trimmedLines.size();
                                        exit = new Point(-1 , height - 1 - yExit);
                                        trimmedLines.add(row);
                                    }
                                } else {
                                    if (!(lines.length() >= 2 && lines.charAt(0) == ' ' && lines.charAt(1) != ' ')) {
                                        throw new IOException("Konfigurasi Papan Mengandung Spasi Invalid");
                                    } else {
                                        String row = lines.substring(1);
                                        if (row.contains(" ")) {
                                            throw new IOException("Konfigurasi Papan Mengandung Spasi Invalid");
                                        } else if (!row.matches("[A-Z\\.]*")) {
                                            throw new IOException("Konfigurasi Papan Mengandung Karakter Invalid");
                                        } else {
                                            trimmedLines.add(row);
                                        }
                                    }
                                }
                            } else {
                                if (lines.contains(" ")) {
                                    throw new IOException("Konfigurasi Papan Mengandung Spasi Invalid");
                                } else if (!lines.matches("[A-ZK\\.]*")) {
                                    throw new IOException("Konfigurasi Papan Mengandung Karakter Invalid");
                                } else {
                                    trimmedLines.add(lines);
                                }
                            }
                        }
                    }
                    if (trimmedLines.size() != height) {
                        throw new IOException("Jumlah Baris Konfigurasi Papan Tidak Sama Dengan Height");
                    }
                    for (int i = 0 ; i < height ; i++) {
                        String row = trimmedLines.get(i);
                        if (row.startsWith("K")) {
                            int y = (i + height - 1);
                            if (y >= height) {
                                y -= ((y - (height - 1)) * 2);
                            }
                            exit = new Point(-1 , y);
                            row  = row.substring(1);
                        } else if (row.endsWith("K")) {
                            int y = (i + height - 1);
                            if (y >= height) {
                                y -= ((y - (height - 1)) * 2);
                            }
                            exit = new Point(width , y);
                            row  = row.substring(0 , row.length() - 1);
                        }
                        if (row.length() != width) {
                            throw new IOException("Panjang Baris Ke-" + (i + 3) + " Tidak Sama Dengan Width");
                        } else {
                            trimmedLines.set(i , row);
                        }
                    }
                    if (exit == null) {
                        throw new IOException("Karakter K (Exit) Tidak Ditemukan Di Pinggir Konfigurasi Papan");
                    } else {
                        boolean onEdge = (exit.getX() == 0 || exit.getX() == width - 1 || exit.getX() == -1 || exit.getX() == width || exit.getY() == 0 || exit.getY() == height - 1 || exit.getY() == -1 || exit.getY() == height);
                        boolean inside = (exit.getX() >= 0 && exit.getX() < width && exit.getY() >= 0 && exit.getY() < height);
                        boolean isCorner = inside && ((exit.getX() == 0 || exit.getX() == width - 1) && (exit.getY() == 0 || exit.getY() == height - 1));
                        if (!onEdge || isCorner) {
                            throw new IOException("Karakter K (Exit) Tidak Berada Dalam Posisi Yang Valid Di Konfigurasi Papan");
                        }
                    }
                    char[][] grid = new char[height][width];
                    Board board = new Board(width , height);
                    for (int i = 0 ; i < height ; i++) {
                        String row = trimmedLines.get(i);
                        for (int j = 0 ; j < width ; j++) {
                            char c = '.';
                            if (j < row.length()) {
                                c = row.charAt(j);
                            }
                            if (c == 'K') {
                                throw new IOException("Karakter K (Exit) Harus Berada Dalam Posisi Yang Valid Di Konfigurasi Papan");
                            } else {
                                grid[i][j] = c;
                                board.setCell(j , i , c);
                            }
                        }
                    }
                    int cntp = 0;
                    boolean checkp = false;
                    List<Piece> pieces = readPieces(grid);
                    for (Piece piece : pieces) {
                        if (piece.getType() != '.' && piece.getType() != 'K' && !isContiguous(piece)) {
                            throw new IOException("Piece '" + piece.getType() + "' Tidak Kontigu / Ukurannya Tidak Valid");
                        } else if (piece.getType() == 'P') {
                            checkp = true;
                        } else if (piece.getType() != '.' && piece.getType() != 'K') {
                            cntp++;
                        }
                    }
                    if (!checkp) {
                        throw new IOException("Tidak Ada Primary Piece (P) Di Konfigurasi Papan");
                    } else if (cntp != pieceCount) {
                        throw new IOException("Jumlah Piece Di Konfigurasi Papan Tidak Sama Dengan Piece Count (N)");
                    } else {
                        return new DataStructure(width , height , pieceCount , exit , board , pieces);
                    }
                }
            }
        }
    }
}