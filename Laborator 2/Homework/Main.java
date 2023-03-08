package Homework;

import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        List<Location> locations = new ArrayList<>();

        locations.add(new City("Cluj Napoca", 10, 20, 1000));
        locations.add(new City("Iasi", 30, 40, 500));
        locations.add(new City("Falticeni", 50, 60, 100));

        locations.add(new GasStation("OMV Cluj Napoca", 15, 25, 10));
        locations.add(new GasStation("OMV Iasi", 35, 45, 100));
        locations.add(new GasStation("OMV Falticeni", 55, 65, 100));
//        locations.add(new GasStation("OMV Falticeni", 55, 65, 100));

        List<Road> roads = new ArrayList<>();
        roads.add(new Highway(Location.dist(locations.get(0), locations.get(1)), 130.f, locations.get(0), locations.get(1), 10));
        roads.add(new Highway(Location.dist(locations.get(1), locations.get(2)), 130.f, locations.get(1), locations.get(2), 5));
//        roads.add(new Highway(-1.f, 130.f, locations.get(3), locations.get(4), 5));


        BestRouteProblem routeProblem = new BestRouteProblem(locations, roads);

        if(routeProblem.checkIfInputIsValid())
            System.out.println("The input is valid");
        else
            System.out.println("The input isn't valid");

        Location from = locations.get(0);
        Location to = locations.get(2);

//        Location from = locations.get(0);
//        Location to = locations.get(4);

        if(routeProblem.areTwoLocationsLinked(from, to))
            System.out.println("We can go from location:" + from.getName() + " to location " + to.getName());
        else
            System.out.println("We cannot go from location:" + from.getName() + " to location " + to.getName());
    }
}