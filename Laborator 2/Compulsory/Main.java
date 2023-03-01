package Compulsory;

public class Main
{
    public static void main(String[] args)
    {
        Location copou = new Location("Copou", Location.LocationType.cities, 1234, 2456);
        Location omvIasi = new Location("Omv Petrom iasi", Location.LocationType.gasStations, 1200, 2356);
        Location aeroportSuceava = new Location("Aeroportul International Stefan Cel Mare Suceava", Location.LocationType.airports, 2000, 2900);

        Road autostradaSuceava = new Road(Road.RoadType.highways, 0.01f, 130);
        Road drumExpress = new Road(Road.RoadType.express, 50, 120);
        Road drumDeTara = new Road(Road.RoadType.country, 40, 90);

        System.out.println(copou.toString());
        System.out.println(omvIasi.toString());
        System.out.println(aeroportSuceava.toString());

        System.out.println(autostradaSuceava.toString());
        System.out.println(drumExpress.toString());
        System.out.println(drumDeTara.toString());

    }
}
