package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by mark on 11-3-2017.
 */
public class dictonary {

    public HashMap<String,String> buildprefix(String filepath) {
        HashMap<String,String> dict = new HashMap<String, String>();
        String line;
        try {
            BufferedReader input = new BufferedReader(new FileReader(filepath));
            while ((line = input.readLine()) != null) {
                for (int i = 0; i <= line.length(); i++) {
                    String str = line.substring(0,i);

                    if (i==line.length()){
                        dict.put(str,"word");
                }
                else if (dict.containsKey(str)!=true){
                        dict.put(str,"prefix");
                    }
                }
            }
            } catch(IOException e){
                e.printStackTrace();
            }
            return dict;
        }
    }


