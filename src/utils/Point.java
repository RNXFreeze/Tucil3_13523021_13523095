package utils;

public class Point {
    private int x, y;
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public Point add(Point other) {
        return new Point(this.x + other.x, this.y + other.y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

}
