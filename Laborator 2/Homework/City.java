package Homework;

public class City extends Location
{
    public City(String name, Integer posX, Integer posY, Integer population)
    {
        super(name, posX, posY);

        this.population = population;
    }
    private Integer population;

    public Integer getPopulation()
    {
        return population;
    }

    @Override
    public String toString()
    {
        return "City{" +
                "population=" + population +
                "} " + super.toString();
    }
}
