import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.*;
import java.util.Collections;


public class Main {
    static final Logger logger = LogManager.getLogger(Main.class);

    public enum c {
        CAR, SHIP, PLANE, BICYCLE
    }

public static void main(String args[]){
    Scanner s = new Scanner(System.in);
    int option;


    List<Vehicles> list = new ArrayList<Vehicles>();
    list.add(new Vehicles(Vehicles.Type.CAR, "TOYOTA", 200));
    list.add(new Vehicles(Vehicles.Type.BICYCLE, "KROSS", 60));
    list.add(new Vehicles(Vehicles.Type.BICYCLE, "GIANT", 50));
    list.add(new Vehicles(Vehicles.Type.CAR, "SUBARU", 306));
    list.add(new Vehicles(Vehicles.Type.PLANE, "BOEING", 600));
    list.add(new Vehicles(Vehicles.Type.PLANE, "AIRBUS", 700));
    list.add(new Vehicles(Vehicles.Type.SHIP, "BIGSHIP", 40));
    list.add(new Vehicles(Vehicles.Type.SHIP, "CERBERUS", 70));

    Comparator<Vehicles> compareByType = (Vehicles o1, Vehicles o2)->o1.getType().compareTo(o2.getType());
    Comparator<Vehicles> compareBySpeed = (Vehicles o1, Vehicles o2) -> Integer.compare(o1.getMax_speed(), o2.getMax_speed());
    Collections.sort(list, compareBySpeed.reversed());
    Collections.sort(list, compareByType);

    while(true){

        try {
            logger.info("Select an option number:\n1. CAR\n2. BIKE\n3. SHIP\n4. PLANE\n5. ALL\n9. EXIT");
            option = s.nextInt();

            switch (option) {
                case 1:
                    showTheFastest(Vehicles.Type.CAR, list);
                    break;
                case 2:
                    showTheFastest(Vehicles.Type.BICYCLE, list);
                    break;
                case 3:
                    showTheFastest(Vehicles.Type.SHIP, list);
                    break;
                case 4:
                    showTheFastest(Vehicles.Type.PLANE, list);
                    break;
                case 5:

                    for (Vehicles i : list)
                    {

                        logger.info("Vehicle type "+ i.getType()+ " from the manufacturer "+ i.getBrand()+
                                " has maximum speed of " + i.getMax_speed());
                    }
                    break;
                case 9:
                    logger.debug("koniec programu");
                    System.exit(0);
                    break;
                default:
                    logger.warn("Wrong!");
            }
        } catch (InputMismatchException e) {
            logger.error("Wrong input data type!");
            s.next();
        }
    }





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
