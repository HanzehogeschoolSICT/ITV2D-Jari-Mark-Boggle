package Model;

import javafx.scene.paint.Color;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

/**
 * Created by mark on 9-3-2017.
 */
public class Model {

    private int arraysize=8;
    private char[][] array=new char[arraysize][arraysize];

    public Model(){
        ReadtxtFile();
        CreateArray();
    }

    public void CreateArray(){
        for (int i = 0; i<array.length;i++){
            for (int j= 0; j<array.length;j++) {
                array[i][j] = CreateChar();
            }
        }
    }
    public char CreateChar(){
        Random r = new Random();
        char c = (char)(r.nextInt(26) + 'a');
        return c;
    }

    public void ReadtxtFile() {
        String line;
        try {
            BufferedReader input = new BufferedReader(new FileReader("C:\\Users\\mark\\Dropbox\\jaar 2\\OOP3\\opdr\\week 2\\quicksort\\untitled1\\src\\TextFile\\dict.txt"));
            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // Setters and getters..
    public void setarraysize(int n){
        this.arraysize = n;
    }
    public int getArraysize(){
        return arraysize;
    }
    public char[][] getArray(){
        return array;
    }
}
