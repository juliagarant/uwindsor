package Assignment3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class FirstLetterMap {
    public static void main (String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("test2.txt"));
        in.useDelimiter("[^A-Za-z]+");

        //declarations
        TreeMap<Character, TreeSet<String>> letters = new TreeMap<>();
        TreeSet<String> fileWords = new TreeSet<>();

        //this section is isolating the characters for keys for the map
        while(in.hasNext()){    //loop to add words from file to a list
            fileWords.add(in.next().toLowerCase());
        }

        //adding things to the map
        for (String element : fileWords) {
            if(letters.containsKey(element.charAt(0))){    //element already in treeMap
                letters.get(element.charAt(0)).add(element);
            }
            else{
                letters.put(element.charAt(0), new TreeSet<String>());
                letters.get(element.charAt(0)).add(element);
            }
        }

        //final output, just made to format like the example
        Set<Character> keySet = letters.keySet();
        for (Character key : keySet) {
            TreeSet<String> value = letters.get(key);
            System.out.println(key + ":" + value);
        }
        in.close();
    }

}