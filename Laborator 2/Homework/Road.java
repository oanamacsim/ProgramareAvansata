package Homework;

import java.util.Objects;

public class Road
{
    private Float length;
    private Float speedLimit;
    private Location location1;
    private Location location2;

    public Road(Float length, Float speedLimit, Location location1, Location location2)
    {
        this.length = length;
        this.speedLimit = speedLimit;
        this.location1 = location1;
        this.location2 = location2;
    }

    public Float getLength()
    {
        return length;
    }

    public Float getSpeedLimit()
    {
        return speedLimit;
    }

    public Location getLocation1()
    {
        return location1;
    }

    public Location getLocation2()
    {
        return location2;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Road road = (Road) o;
        return Objects.equals(length, road.length) && Objects.equals(speedLimit, road.speedLimit) && Objects.equals(location1, road.location1) && Objects.equals(location2, road.location2);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(length, speedLimit, location1, location2);
    }

    @Override
    public String toString()
    {
        return "Road{" +
                "length=" + length +
                ", speedLimit=" + speedLimit +
                ", location1=" + location1 +
                ", location2=" + location2 +
                '}';
    }
}
