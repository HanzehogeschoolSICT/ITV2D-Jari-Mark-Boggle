package Model;

import javafx.scene.paint.Color;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;

/**
 * Created by mark on 9-3-2017.
 */
public class Model {
    private int arraysize = 2;
    private Cell[][] array;
    private HashSet<String> wordlist=  new HashSet<>();
    //private StringBuilder sb= new StringBuilder();
    private boolean[][] visited;
    private ExecutorService exe;
    private HashMap<String,String> dict;




    public Model() {
        dictonary dictonary = new dictonary();
        dict=dictonary.builddic("C:\\Users\\mark\\Dropbox\\jaar 2\\OOP3\\opdr\\week 2\\quicksort\\untitled1\\src\\TextFile\\dict.txt");
        CreateArray();
    }

    public void Constructneighbours(){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                LinkedList<Cell> neighbors= new LinkedList<>();
                if (i-1> -1&&j-1> -1){
                    neighbors.add(array[i-1][j-1]);
                }

                if (i-1>-1){
                    neighbors.add(array[i-1][j]);
                }

                if (i-1> -1&&   j+1<array.length){
                    neighbors.add(array[i-1][j+1]);
                }

                if (j+1<array.length){
                    neighbors.add(array[i][j+1]);
                }

                if (j-1>-1){
                    neighbors.add(array[i][j-1]);
                }

                if (i+1<array.length && j-1>-1){
                    neighbors.add(array[i+1][j-1]);
                }

                if (i+1<array.length){
                    neighbors.add(array[i+1][j]);
                }
                if (i+1<array.length&& j+1<array.length){
                    neighbors.add(array[i+1][j+1]);
                }
                array[i][j].setNeighbors(neighbors);
            }
        }
    findallneighb();
    }
    public void CreateArray() {
        array = new Cell[arraysize][arraysize];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                    array[i][j] = new Cell(i, j, CreateChar(),false);
            }
        }
                Constructneighbours();


    }

    public char CreateChar() {
        Random r = new Random();
        char c = (char) (r.nextInt(26) + 'a');
        return c;
    }

    public void findallneighb() {
        System.out.println("-------");
        for (Cell[] c : array){
           for (Cell cell: c){
               cell.setVisited(true);
               findneighb(cell, Character.toString(cell.getContent()));
               cell.setVisited(false);
           }
       }
    }

    public void findneighb(Cell cell,  String str) {
        if (!dict.containsKey(str)) {
        return;
        }
        else if (dict.get(str).equals("word")){
            System.out.println(str);
        }
        for (Cell neighbor: cell.getNeighbors()){
            if (!neighbor.Visited()) {
                neighbor.setVisited(true);
                findneighb(neighbor, str.concat(String.valueOf(neighbor.getContent())));
                neighbor.setVisited(false);
            }
        }
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
