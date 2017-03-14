package Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;


public class dictonary {

    public HashMap<String,String> builddic(String filepath) {
        HashMap<String,String> dic = new HashMap<>();
        String line;
        try {
            BufferedReader input = new BufferedReader(new FileReader(filepath));
            while ((line = input.readLine()) != null) {
                for (int i = 0; i <= line.length(); i++) {
                    if (i==line.length()){
                        dic.put(line,"word");
                }
                else if (dic.containsKey(line.substring(0,i))!=true){
                        dic.put(line.substring(0,i),"prefix");
                    }
                }
            }
            } catch(IOException e){
                e.printStackTrace();
            }

            return dic;
        }
    }


