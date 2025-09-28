package introduccion;

import java.time.LocalDate;
import java.time.LocalDateTime;
import utils.SequentialFileReader;

public class Satelite implements SequentialFileReader {

    private String objName;
    private String objId;
    private LocalDateTime epoch;
    private double meanMotion;
    private double iclinacion;
    private double raan;
    private double excentricity;
    private double argumentPercinter;

    public Satelite(){

    }

    @Override
    public void readData(String[] data) {
        this.objName = data[0];
        this.objId = data[1];
        this.epoch = LocalDateTime.parse(data[2]);
        this.argumentPercinter = Double.valueOf(data[3]);
        this.excentricity = Double.valueOf(data[4]);
        this.iclinacion = Double.valueOf(data[5]);
        this.raan = Double.valueOf(data[6]);
        this.meanMotion = Double.valueOf(data[7]);

    }
 public String toString(){
    return "Satelite [objName =" + objName + "objectID=" + objId + "epoch =" + epoch + "meanMotion=" + meanMotion
    + "excentricity= " + excentricity + " inclination= " + iclinacion + "raan =" + raan + "argumentPercinter" + argumentPercinter + "]";
 }

 public double getMotion() {
    return meanMotion;
 }

    
}