package Homework;

public class Airport extends Location
{
    public Airport(String name, Integer posX, Integer posY, Integer flightsNum)
    {
        super(name, posX, posY);
        this.flightsNum = flightsNum;
    }
    private Integer flightsNum;

    public Integer getFlightsNum()
    {
        return flightsNum;
    }

    @Override
    public String toString()
    {
        return "Airport{" +
                "flightsNum=" + flightsNum +
                "} " + super.toString();
    }
}
