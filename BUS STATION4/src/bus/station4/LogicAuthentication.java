package bus.station4;

import java.util.ArrayList;

public class LogicAuthentication {

    SaveLists lists;
    ArrayList<Trips> newlist;
    String y = "NULL";
    String coment;

    public String checkPrice(String stop, Trips list) {
        System.out.println(stop);
        System.out.println(list.price);
        String noStop = "No Stop";
        String oneStop = "One Stop";

        Double x = Double.valueOf(list.price);

        if (stop.equals(noStop)) {

            y = String.valueOf(x);

        } else if (stop.equals(oneStop)) {
            x = x - (x * 0.2);
            y = String.valueOf(x);
        } else {
            x = x - (x * 0.4);
            y = String.valueOf(x);
        }

        return y;

    }

    public String checkPriceForWay(String way, String list) {
        System.out.println(way);
        System.out.println(list);
        String roundTrip = "Round Trip";
        Double x = Double.valueOf(list);
        if (way.equals(roundTrip)) {
            x = x + (x * 0.9);
            y = String.valueOf(x);
        }
        return y;

    }

    public void setLists(SaveLists lists) {
        this.lists = lists;
    }

}
