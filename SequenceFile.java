
package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SequenceFile <T extends SequentialFileReader> {
    private Scanner scan;
    private File file;
    private String separator;

    public SequenceFile(String fileName, String separator) throws FileNotFoundException{
        file = new File(fileName);
        this.separator = separator;
        scan= new Scanner(System.in);
    }

    

    public void skip(){
        scan.nextLine();
    }
 
    public boolean isEndOffFile(){
        return !scan.hasNextLine();
    }

    public void close(){
        scan.close();
    }

    public void read(T t) {
        String [] data = scan.nextLine().split(separator);
        t.readData(data);
    }
}
