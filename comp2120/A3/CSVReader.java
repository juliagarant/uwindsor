package Assignment3;
/*
Assignment 3
Problem 2
Julia Garant
104987469
Apr 2 2020
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CSVReader {
    private String CSV ;
    private Scanner in;
    private ArrayList<String> lines;
    private ArrayList<ArrayList<String>> fields;


    public CSVReader(String CSV) throws FileNotFoundException {
        this.CSV = CSV;

        fields = new ArrayList<>();
        lines = new ArrayList<>();

        in = new Scanner(new File(CSV));
        in.useDelimiter(",");
        while(in.hasNextLine()) {
            lines.add(in.nextLine());
        }

        String str = null;
        int i = 0;
        for (String row: lines) {
            fields.add(new ArrayList<>());

            in = new Scanner(row);
            in.useDelimiter(",");
            while (in.hasNext()){
                str = in.next().trim();     //trim the excess characters
                if(str.startsWith("\"")){
                    while(!str.endsWith("\"")){
                        str += "," + in.next();
                    }
                    //Case: one set of double quotes
                    str = str.substring(1,str.length()-1);  //remove single quotes but keep comma
                    //Case: two sets of double quotes
                    str = str.replaceAll("\\\"\\\"","\"");  //replace instance of ""words"" with "words"
                }
                fields.get(i).add(str);
            }
            i++;
        }
    }
//---------------------------------------------------------------------------------------------------------------------
    /*
    Returns the number of lines in the CSV file
     */
    public int numberOfRows() {
        return lines.size();
    }
    /*
    Returns the number of fields in a particular row
     */
    public int numberOfFields(int row) {
        return fields.get(row).size();
    }
    /*
    Returns the field in a particular row and column
     */
    public String field(int row, int column) {
        return fields.get(row).get(column);
    }

}
