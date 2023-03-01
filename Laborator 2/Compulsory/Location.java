package Compulsory;

public class Location
{
    public Location(String name, LocationType type, int pozX, int pozY)
    {
        this.name = name;
        this.type = type;
        this.pozX = pozX;
        this.pozY = pozY;
    }

    @Override
    public String toString()
    {
        return "Location{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", pozX=" + pozX +
                ", pozY=" + pozY +
                '}';
    }

    public enum LocationType
    {
        cities,
        airports,
        gasStations
    }

    private String name;

    private LocationType type;

    int pozX;
    int pozY;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public LocationType getType()
    {
        return type;
    }

    public void setType(LocationType type)
    {
        this.type = type;
    }

    public int getPozX()
    {
        return pozX;
    }

    public void setPozX(int pozX)
    {
        this.pozX = pozX;
    }

    public int getPozY()
    {
        return pozY;
    }

    public void setPozY(int pozY)
    {
        this.pozY = pozY;
    }
}
