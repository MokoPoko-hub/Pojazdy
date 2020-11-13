import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import lombok.Data;

import java.util.List;

public @Data class Vehicles {


    public enum Type {
        CAR, SHIP, PLANE, BICYCLE,ALL,EXIT
    }

    static final Logger logger = LogManager.getLogger(Vehicles.class);
    public Type type;
    private String brand;
    private int max_speed;

    public Vehicles(Type type, String brand, int max_speed ){
        this.type=type;
        this.brand=brand;
        this.max_speed=max_speed;
    }


    public static void showTheFastest(Vehicles.Type type, List<Vehicles> list ){

        for (Vehicles i : list){
            if(i.getType().equals(type))
            {
                logger.info("Vehicle type "+ i.getType()+ " from the manufacturer "+ i.getBrand()+
                        " is the fastest with maximum speed " + i.getMax_speed());
                break;
            }
        }
    }
}
