package Homework;

public class GasStation extends Location
{
    public GasStation(String name, Integer posX, Integer posY, float gasPrice)
    {
        super(name, posX, posY);
        this.gasPrice = gasPrice;
    }

    private float gasPrice;

    @Override
    public String toString()
    {
        return "GasStation{" +
                "gasPrice=" + gasPrice +
                "} " + super.toString();
    }
}
