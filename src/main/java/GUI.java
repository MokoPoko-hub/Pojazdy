import lombok.Data;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.*;
import java.util.Collections;


public class GUI {

    static final Logger logger = LogManager.getLogger(Vehicles.class);
    Scanner s = new Scanner(System.in);
    String option;
    List<Vehicles> list = new ArrayList<Vehicles>();

    public GUI() {
        GUIinit();
    }

    public void GUIinit() {
        addToList();
        sortMyList();
        menuInit();
    }

    public void addToList() {
        list.add(new Vehicles(Vehicles.Type.CAR, "TOYOTA", 200));
        list.add(new Vehicles(Vehicles.Type.BICYCLE, "KROSS", 60));
        list.add(new Vehicles(Vehicles.Type.BICYCLE, "GIANT", 50));
        list.add(new Vehicles(Vehicles.Type.CAR, "SUBARU", 306));
        list.add(new Vehicles(Vehicles.Type.PLANE, "BOEING", 600));
        list.add(new Vehicles(Vehicles.Type.PLANE, "AIRBUS", 700));
        list.add(new Vehicles(Vehicles.Type.SHIP, "BIGSHIP", 40));
        list.add(new Vehicles(Vehicles.Type.SHIP, "CERBERUS", 70));
    }

    public void sortMyList() {
        Comparator<Vehicles> compareByType = (Vehicles o1, Vehicles o2) -> o1.getType().compareTo(o2.getType());
        Comparator<Vehicles> compareBySpeed = (Vehicles o1, Vehicles o2) -> Integer.compare(o1.getMax_speed(), o2.getMax_speed());
        Collections.sort(list, compareBySpeed.reversed());
        Collections.sort(list, compareByType);
    }

    public void menuInit(){
        while (true) {

            try {
                logger.info("Select an option number:\nCAR\nBICYCLE\nSHIP\nPLANE\nALL\nEXIT");
                option = s.nextLine();


                switch (Vehicles.Type.valueOf(option.toUpperCase())) {
                    case CAR:
                        Vehicles.showTheFastest(Vehicles.Type.CAR, list);
                        break;
                    case BICYCLE:
                        Vehicles.showTheFastest(Vehicles.Type.BICYCLE, list);
                        break;
                    case SHIP:
                        Vehicles.showTheFastest(Vehicles.Type.SHIP, list);
                        break;
                    case PLANE:
                        Vehicles.showTheFastest(Vehicles.Type.PLANE, list);
                        break;
                    case ALL:

                        for (Vehicles i : list) {

                            logger.info("Vehicle type " + i.getType() + " from the manufacturer " + i.getBrand() +
                                    " has maximum speed of " + i.getMax_speed());
                        }
                        break;
                    case EXIT:
                        logger.debug("Exiting");
                        System.exit(0);
                        break;
                    default:
                        logger.warn("Wrong!");
                }
            } catch (IllegalArgumentException e) {
                logger.error("Wrong input data type!");
            }
        }


    }
    }



