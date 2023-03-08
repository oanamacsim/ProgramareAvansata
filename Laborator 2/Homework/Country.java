package Homework;

public class Country extends Road
{
    public Country(Float length, Float speedLimit, Location location1, Location location2, Integer numarGropi)
    {
        super(length, speedLimit, location1, location2);
        this.numarGropi = numarGropi;
    }

    private Integer numarGropi;

    public Integer getNumarGropi()
    {
        return numarGropi;
    }

    @Override
    public String toString()
    {
        return "Country{" +
                "numarGropi=" + numarGropi +
                "} " + super.toString();
    }
}
