/* Kelompok   : Kelompok Tucil3_13523021_13523095                                */
/* Nama - 1   : Muhammad Raihan Nazhim Oktana                                    */
/* NIM - 1    : K01 - 13523021 - Teknik Informatika (IF-Ganesha) ITB             */
/* Nama - 2   : Rafif Farras                                                     */
/* NIM - 2    : K02 - 13523095 - Teknik Informatika (IF-Ganesha) ITB             */
/* Tanggal    : Selasa, 20 Mei 2025                                              */
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
            // Validasi baris pertama (dimensi)
            String dimensionLine = reader.readLine();
            if (dimensionLine == null) {
                throw new IOException("File kosong.");
            }
            
            String[] dimensions = dimensionLine.trim().split("\\s+");
            
            // Jika Baris pertama punya lebih dari 2 angka
            if (dimensions.length != 2) {
                throw new IOException("Format dimensi tidak valid. Harap masukkan width dan height saja.");
            }
            
            // Jika Baris pertama bukan angka
            int width, height;
            try {
                width = Integer.parseInt(dimensions[0]);
                height = Integer.parseInt(dimensions[1]);
                
                // Validasi dimensi positif
                if (width <= 0 || height <= 0) {
                    throw new IOException("Dimensi harus berupa angka positif.");
                }
            } catch (NumberFormatException e) {
                throw new IOException("Dimensi harus berupa angka.");
            }
            
            // Validasi baris kedua (jumlah piece)
            String pieceLine = reader.readLine();
            if (pieceLine == null) {
                throw new IOException("File tidak sesuai formatt. Jumlah piece tidak ditemukan.");
            }
            
            int pieceCount;
            try {
                pieceCount = Integer.parseInt(pieceLine.trim());
                if (pieceCount <= 0) {
                    throw new IOException("Jumlah piece harus positif.");
                }

                if (pieceCount > 24) {
                    throw new IOException("Jumlah piece maksimal adalah 24 (26 alfabet - P dan K).");
                }
            } catch (NumberFormatException e) {
                throw new IOException("Jumlah piece harus berupa angka.");
            }
    
            // Baca semua baris setelah jumlah piece ke list
            List<String> rawLines = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                // Case 5: Skip line kosong
                if (!line.trim().isEmpty()) {
                    rawLines.add(line);
                } else {
                    throw new IOException("Board tidak boleh memiliki baris kosong.");
                }
            }

            // Inisialisasi keluar
            Point keluar = null;

            List<String> trimmedLines = new ArrayList<>();
            for (String l : rawLines) {
                if (l != null) {
                    int kIndex = l.indexOf('K');
                    if (kIndex != -1) {
                        if (rawLines.indexOf(l) == 0) {
                            if (keluar != null) {
                                throw new IOException("Hanya boleh ada satu posisi keluar.");
                            }
                            keluar = new Point(kIndex, height);
                        } 
                        // Jika K berada di baris terakhir
                        else if (rawLines.indexOf(l) == rawLines.size() - 1) {
                            if (keluar != null) {
                                throw new IOException("Hanya boleh ada satu posisi keluar.");
                            }
                            keluar = new Point(kIndex, -1);
                        }
                        // Jika K berada di sisi kiri atau kanan
                        else {
                            int boardIndex = rawLines.indexOf(l);
                            String rowContent = l.trim();
                            if (rowContent.startsWith("K")) {
                                if (keluar != null) {
                                    throw new IOException("Hanya boleh ada satu posisi keluar.");
                                }
                                keluar = new Point(-1, boardIndex);
                                rowContent = rowContent.substring(1);
                            } 
                            else if (rowContent.endsWith("K")) {
                                if (keluar != null) {
                                    throw new IOException("Hanya boleh ada satu posisi keluar.");
                                }
                                keluar = new Point(width, boardIndex);
                                rowContent = rowContent.substring(0, rowContent.length() - 1); 
                            }
                            else if (kIndex != -1) {
                                String contentWithoutSpaces = l.replaceAll("\\s+", "");
                                int realKIndex = contentWithoutSpaces.indexOf('K');
                                
                                if (realKIndex == 0) {
                                    if (keluar != null) {
                                        throw new IOException("Hanya boleh ada satu posisi keluar.");
                                    }
                                    keluar = new Point(-1, boardIndex);
                                    contentWithoutSpaces = contentWithoutSpaces.substring(1);
                                }
                                else if (realKIndex == contentWithoutSpaces.length() - 1) {
                                    if (keluar != null) {
                                        throw new IOException("Hanya boleh ada satu posisi keluar.");
                                    }
                                    keluar = new Point(width, boardIndex);
                                    contentWithoutSpaces = contentWithoutSpaces.substring(0, contentWithoutSpaces.length() - 1);
                                }
                                // Jika K di tengah-tengah, ini tidak valid
                                else {
                                    throw new IOException("Posisi K harus berada di pinggir board.");
                                }
                                rowContent = contentWithoutSpaces;
                            }
                            l = rowContent;
                        }
                    }
                    String trimmed = l.trim().replace("K", ""); 
                    if (!trimmed.isEmpty()) {
                        trimmedLines.add(trimmed);
                    }
                }
            }

            // Validasi jumlah baris
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

            // Validasi posisi keluar sesuai aturan
            if (keluar.getX() < -1 || keluar.getX() > width || keluar.getY() < -1 || keluar.getY() > height || 
                (keluar.getX() >= 0 && keluar.getX() < width && keluar.getY() >= 0 && keluar.getY() < height)) {
                throw new IOException("Posisi keluar tidak valid.");
            }

            // Validasi posisi sudut
            if ((keluar.getX() == -1 && keluar.getY() == -1) ||
                (keluar.getX() == -1 && keluar.getY() == height) ||
                (keluar.getX() == width && keluar.getY() == -1) ||
                (keluar.getX() == width && keluar.getY() == height)) {
                throw new IOException("Posisi keluar tidak valid (tidak boleh di sudut).");
            }

            char[][] grid = new char[height][width];
            Board board = new Board(width, height);

            Set<Character> piecesFound = new HashSet<>();
    
            for (int i = 0; i < height; i++) {
                String row = trimmedLines.get(i);
                for (int j = 0; j < width; j++) {
                    char c = (j < row.length()) ? row.charAt(j) : '.';
                    grid[i][j] = c;
                    board.setCell(j , i , c);
                    if (c != '.' && c != 'P' && c != 'K') {
                        piecesFound.add(c);
                    }
                }
            }

            if (piecesFound.size() != pieceCount) {
                throw new IOException("Jumlah piece di board (" + piecesFound.size() + ") tidak sesuai dengan jumlah yang dideklarasikan (" + pieceCount + ").");
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