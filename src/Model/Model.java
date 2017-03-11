package Model;

import javafx.scene.paint.Color;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Lock;

/**
 * Created by mark on 9-3-2017.
 */
public class Model {
    private int as;

    private int arraysize = 3;
    private Cell[][] array;
    private HashSet<String> wordlist=  new HashSet<>();
    //private StringBuilder sb= new StringBuilder();
    private boolean[][] visited;



    public Model() {
        ReadtxtFile();
        CreateArray();

    }

    public void CreateArray() {
        array = new Cell[arraysize][arraysize];
        visited= new boolean[arraysize][arraysize];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] = new Cell(i, j, CreateChar());
                visited[i][j]= false;
            }
        }
        findallneighb();
    }

    public char CreateChar() {
        Random r = new Random();
        char c = (char) (r.nextInt(26) + 'a');
        return c;
    }

    public void ReadtxtFile() {
        String line;
        try {
            BufferedReader input = new BufferedReader(new FileReader("C:\\Users\\mark\\Dropbox\\jaar 2\\OOP3\\opdr\\week 2\\quicksort\\untitled1\\src\\TextFile\\dict.txt"));
            while ((line = input.readLine()) != null) {
                wordlist.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void findallneighb() {
        String str = "";


        for (int x = 0; x < array.length; x++) {
            for (int y = 0; y < array.length; y++) {
                findneighb(array[x][y], visited, str);
            }
        }
    }

    public void findneighb(Cell cell, boolean[][] visited, String str) {
        visited[cell.getX()][cell.getY()] = true;
        str += cell.getContent();
        if (wordfound(str)) {
            System.out.println(str);
        }
        // made here because of lots of recalls which dropped the program speed about 0;
        int x= cell.getX();
        int y= cell.getY();
        int xmax = cell.getX()+1;
        int ymax = cell.getY()+1;

        // searching for neighbours and thier content..
        for (;x <= xmax && x<arraysize; x++) {
            for (; y <= ymax && y<arraysize; y++) {
                if (x >= 0 && y >= 0 && !visited[x][y]) {
                    findneighb(array[x][y], visited,str); // recursive calling the method
                }
            }
        }
        str.substring(0,str.length()-1);
        visited[cell.getX()][cell.getY()]=false;
    }

    public boolean wordfound(String str){
            if (wordlist.contains(str)){
                return true;
            }

        return false;
    }

    // Setters and getters..
    public void setarraysize(int n){
        this.arraysize = n;
        CreateArray();
    }
    public int getArraysize(){
        return arraysize;
    }
    public Cell[][] getArray(){
        return array;
    }


}
