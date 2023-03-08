package Homework;

import java.util.Objects;

public class Location
{
    public Location(String name, Integer posX, Integer posY)
    {
        this.name = name;
        this.positionX = posX;
        this.positionY = posY;
    }

    private String name;
    private Integer positionX;
    private Integer positionY;

    public String getName()
    {
        return name;
    }

    public Integer getPositionX()
    {
        return positionX;
    }

    public Integer getPositionY()
    {
        return positionY;
    }

    public static Float dist(Location loc1, Location loc2)
    {
        return (float) Math.sqrt((loc2.getPositionY() - loc1.getPositionY()) * (loc2.getPositionY() - loc1.getPositionY()) + (loc2.getPositionX() - loc1.getPositionX()) * (loc2.getPositionX() - loc1.getPositionX()));
    }

    public static Float dist(int x1, int y1, int x2, int y2)
    {
        return (float) Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(name, location.name) && Objects.equals(positionX, location.positionX) && Objects.equals(positionY, location.positionY);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name, positionX, positionY);
    }

    @Override
    public String toString()
    {
        return "Location{" +
                "name='" + name + '\'' +
                ", positionX=" + positionX +
                ", positionY=" + positionY +
                '}';
    }
}
