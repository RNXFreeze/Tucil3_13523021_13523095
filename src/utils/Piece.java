package utils;
import java.util.List;

public class Piece {
    private char type;
    private List<Point> coordinates;
    private int orientation; // 0 = horizontal, 1 = vertical

    public Piece(char type, List<Point> coordinates, int orientation) {
        this.type = type;
        this.coordinates = coordinates;
        this.orientation = orientation;
    }

    public char getType() {
        return type;
    }
    
    public List<Point> getCoordinates() {
        return coordinates;
    }

    public int getOrientation() {
        return orientation;
    }

    public void setType(char type) {
        this.type = type;
    }

    public void setCoordinates(List<Point> coordinates) {
        this.coordinates = coordinates;
    }

    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }
}
