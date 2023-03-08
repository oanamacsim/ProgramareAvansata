package Homework;

public class Highway extends Road
{
    public Highway(Float length, Float speedLimit, Location location1, Location location2, Integer numarRadare)
    {
        super(length, speedLimit, location1, location2);
        this.numarRadare = numarRadare;
    }

    private Integer numarRadare;

    public Integer getNumarRadare()
    {
        return numarRadare;
    }

    @Override
    public String toString()
    {
        return "Highway{" +
                "numarRadare=" + numarRadare +
                "} " + super.toString();
    }
}
