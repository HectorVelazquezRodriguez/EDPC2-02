package introduccion;
import utils.SequenceFile;
import java.util.FileNotFoundException;

public class Main {

    public static void main(String[] args) {
        Satelite sat = new Satelite();
        try{
            SequenceFile<Satelite> sf = new SequenceFile<Satelite>( "weather.csv",",");
            sf.skip();
            while(!sf.isEndOffFile()){
                sf.read(sat);
                if(sat.getMotion() >= 10){
                    System.out.print(sat);
                }
                sf.close();
            }

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}