package Lab9;
/*
Lab 9 for COMP2110
Julia Garant
104987469
Mar 22 2020
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Activity2 {
    public static void main(String[] args) throws FileNotFoundException {
        File input = new File(args[0]);

        try {
            Scanner in = new Scanner(input);
            String type = in.next();
            PrintWriter out = new PrintWriter(args[1]);

            if (type.equals("String")) {
                ArrayList<String> sList = new ArrayList<>();
                in.useDelimiter("[^A-Za-z!]+");  //only allows strings to be read in
                while(in.hasNextLine()) {
                    String value = in.next();
                    sList.add(value);
                }

                //SORTING
                if(args[2].equals("ascending")) {
                    Collections.sort(sList);
                }
                else if(args[2].equals("descending")){
                    Collections.sort(sList, Collections.reverseOrder());
                }

                out.println(type + ", Number of Lines: " +sList.size());
                for (String element: sList) {
                    out.println(element);
                }
                out.close();
                in.close();

            } else if (type.equals("Integer")) {
                ArrayList<Integer> iList = new ArrayList<>();
                while(in.hasNextLine()) {
                    if(in.hasNextInt()){    //if the values are integers
                        int value = in.nextInt();
                        iList.add(value);
                    }else{      //if not an integer
                        in.nextLine();
                    }
                }

                //SORTING
                if(args[2].equals("ascending")) {
                    Collections.sort(iList);
                }
                else if(args[2].equals("descending")){
                    Collections.sort(iList,Collections.reverseOrder());
                }

                out.println(type + ", Number of Lines: " +iList.size());
                for (int element: iList) {
                    out.println(element);
                }
                out.close();
                in.close();

            } else if (type.equals("Double")) {
                ArrayList<Double> dList = new ArrayList<>();
                while(in.hasNextLine()) {
                    if(in.hasNextDouble()){    //if the values are doubles
                        double value = in.nextDouble();
                        dList.add(value);
                    }else{      //if not a double
                        in.nextLine();
                    }
                }

                //SORTING
                if(args[2].equals("ascending")) {
                    Collections.sort(dList);
                }
                else if(args[2].equals("descending")){
                    Collections.sort(dList,Collections.reverseOrder());
                }

                out.println(type + ", Number of Lines: " +dList.size());
                for (double element: dList) {
                    out.println(element);
                }
                out.close();
                in.close();
            }
        }//IOException contains subclasses like FileNotFound and NoSuchElement
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
