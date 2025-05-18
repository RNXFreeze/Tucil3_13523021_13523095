import java.io.*;
import algorithm.*;
import utils.Reader;
import utils.DataStructure;

public class Main {
    public static void main(String[] args) {
        String filePath = "test/input/test.txt";

        try {
            DataStructure data = Reader.readFile(filePath); 
            System.out.println("File berhasil dibaca.");

            data.printDataStructure();
        } catch (IOException e) {
            System.err.println("Gagal membaca file: " + e.getMessage());
        }
    }
}
