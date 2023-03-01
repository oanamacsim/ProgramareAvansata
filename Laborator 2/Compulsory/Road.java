package Compulsory;

public class Road
{
    public Road(RoadType type, float length, float speedLimit)
    {
        this.type = type;
        this.length = length;
        this.speedLimit = speedLimit;
    }

    @Override
    public String toString()
    {
        return "Road{" +
                "type=" + type +
                ", length=" + length +
                ", speedLimit=" + speedLimit +
                '}';
    }

    enum RoadType
    {
        highways,
        express,
        country
    }

    RoadType type;

    float length;

    float speedLimit;

    public RoadType getType()
    {
        return type;
    }

    public void setType(RoadType type)
    {
        this.type = type;
    }

    public float getLength()
    {
        return length;
    }

    public void setLength(float length)
    {
        this.length = length;
    }

    public float getSpeedLimit()
    {
        return speedLimit;
    }

    public void setSpeedLimit(float speedLimit)
    {
        this.speedLimit = speedLimit;
    }
}
