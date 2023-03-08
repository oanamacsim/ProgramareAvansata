package Homework;

import java.util.*;

public class BestRouteProblem
{

    List<Location> locations;
    List<Road> roads;

    public BestRouteProblem(List<Location> locations, List<Road> roads)
    {
        this.locations = locations;
        this.roads = roads;
    }

    Boolean checkIfInputIsValid()
    {
        //check if roads lengths are correct
        for (Road road : roads)
        {
            Location loc1 = road.getLocation1();
            Location loc2 = road.getLocation2();
            Float length = Location.dist(loc1.getPositionX(), loc1.getPositionY(), loc2.getPositionX(), loc2.getPositionY());
            if (!road.getLength().equals(length))
                return false;
        }

        //check if roads are unique
        for (int i = 0; i < roads.size(); i++)
            for (int j = 0; j < roads.size(); j++)
            {
                if (i != j)
                {
                    if (roads.get(i).equals(roads.get(j)))
                        return false;
                }
            }

        //check if locations are unique
        for (int i = 0; i < locations.size(); i++)
            for (int j = 0; j < locations.size(); j++)
            {
                if (i != j)
                {
                    if (locations.get(i).equals(locations.get(j)))
                        return false;
                }
            }

        return true;
    }

    Boolean areTwoLocationsLinked(Location start, Location end)
    {
        Map<Location, List<Location>> adjacencyMap = new HashMap<>();

        for (Road road : roads)
        {
            if (!adjacencyMap.containsKey(road.getLocation1()))
                adjacencyMap.put(road.getLocation1(), new ArrayList<>());

            if (!adjacencyMap.containsKey(road.getLocation2()))
                adjacencyMap.put(road.getLocation2(), new ArrayList<>());

            adjacencyMap.get(road.getLocation1()).add(road.getLocation2());
            adjacencyMap.get(road.getLocation2()).add(road.getLocation1());
        }

        Queue<Location> queue = new LinkedList<>();
        Set<Location> visitedLocations = new HashSet<>();
        queue.offer(start);
        visitedLocations.add(start);

        while (!queue.isEmpty())
        {
            Location currentLocation = queue.poll();
            if (currentLocation.equals(end))
                return true;

            if (adjacencyMap.containsKey(currentLocation))
            {
                List<Location> adjLocations = adjacencyMap.get(currentLocation);
                for (Location adjLoc : adjLocations)
                    if (!visitedLocations.contains(adjLoc))
                    {
                        queue.offer(adjLoc);
                        visitedLocations.add(adjLoc);
                    }
            }
        }

        return false;
    }
}
