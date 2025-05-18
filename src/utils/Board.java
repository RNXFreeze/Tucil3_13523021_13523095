package utils;

public class Board {
    private char[][] grid;
    private int width;
    private int height;

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        this.grid = new char[height][width];
    }

    public char getCell(int x, int y) {
        return grid[y][x];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public char[][] getGrid() {
        return grid;
    }

    public void setCell(int x, int y, char value) {
        grid[y][x] = value;
    }
}
