package Model;

import java.util.*;
import java.util.concurrent.ExecutorService;


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
    private ArrayList<ArrayList<Cell>> allfound;
    private int foundsize= 0;




    public Model() {
        dictonary dictonary = new dictonary();
        dict=dictonary.builddic("C:\\Users\\mark\\Dropbox\\jaar 2\\OOP3\\opdr\\week 2\\quicksort\\untitled1\\src\\TextFile\\dict.txt");
        CreateArray();
    }

    public void Constructneighbours(){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {

                array[i][j].setNeighbors(possibleNeigbors(i,j));
            }
        }
    findallneighb();
    }


    public LinkedList<Cell> possibleNeigbors(int i,int j){
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
        return neighbors;
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
       allfound= new ArrayList<>();
       foundsize= 0;
        for (Cell[] c : array){
           for (Cell cell: c){
               ArrayList<Cell> found = new ArrayList<Cell>();
               cell.setVisited(true);
               found.add(cell);
               findneighb(cell, Character.toString(cell.getContent()), found);
               cell.setVisited(false);
           }
       }

    }

    public void findneighb(Cell cell,  String str,ArrayList<Cell> found) {
        if (!dict.containsKey(str)) {
        return;
        }
        else if (dict.get(str).equals("word")){
            System.out.println(str);
            allfound.add(new ArrayList<Cell>());
            for (Cell c: found){
                allfound.get(allfound.size()-1).add(c);
            }

        }
        for (Cell neighbor: cell.getNeighbors()){
            if (!neighbor.Visited()) {
                neighbor.setVisited(true);
                found.add(neighbor);
                findneighb(neighbor, str.concat(String.valueOf(neighbor.getContent())),found);
                found.remove(found.size()-1);
                neighbor.setVisited(false);
            }
        }
        }

    public ArrayList<ArrayList<Cell>> getallfound(){
        return allfound;
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
