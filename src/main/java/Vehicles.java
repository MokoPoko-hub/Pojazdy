import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Vehicles {

    static final Logger logger = LogManager.getLogger(Main.class);

    public enum Type {
        CAR, SHIP, PLANE, BICYCLE
    }

    public Type type;
    private String brand;
    private int max_speed;

    public Vehicles(Type type, String brand, int max_speed ){
        this.type=type;
        this.brand=brand;
        this.max_speed=max_speed;
    }


    public int getMax_speed() {
        return max_speed;
    }

    public String getBrand() {
        return brand;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
