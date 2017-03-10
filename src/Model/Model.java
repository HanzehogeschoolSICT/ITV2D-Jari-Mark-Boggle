package Model;

import javafx.scene.paint.Color;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Lock;

/**
 * Created by mark on 9-3-2017.
 */
public class Model {

    private int arraysize=3;
    private Cell[][] array;
    private ArrayList<String> wordlist= new ArrayList<>();
    //private StringBuilder sb= new StringBuilder();


    public Model(){
        ReadtxtFile();
        CreateArray();

        for (int x = 0; x<array.length;x++){
            for (int y= 0; y<array.length;y++) {
                findneighb(array[y][x], "");
            }
        }
    }

    public void CreateArray(){
        array=new Cell[arraysize][arraysize];
        for (int i = 0; i<array.length;i++){
            for (int j= 0; j<array.length;j++) {
                array[i][j] = new Cell(i,j,CreateChar());
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
                wordlist.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void findneighb(Cell cell,String word){
        String newword = word +cell.getContent();
        boolean valid = false;
        for (int y =cell.getY()-1;y<= cell.getY()+1; y++){
            for (int x = cell.getX()-1; x<=cell.getX()+1; x++){
                if (!(cell.getX()==x && cell.getY()==y)&& x>= 0&& y>=0 && x<arraysize && y<arraysize){
                    for (String a: wordlist) {
                        if (a.contains(newword)) {
                            System.out.println(sb.toString());
                            findneighb(array[x][y], sb.toString());
                            valid = true;
                        }
                        else{
                            continue;
                        }
                    }
                    if (valid)
                        sb.delete(0,sb.length());
                        continue;


                }
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

    public void Updatemodel(){
        CreateArray();
        //FindNeightbours
    }
}
