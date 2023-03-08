package Homework;

public class Express extends Road
{
    public Express(Float length, Float speedLimit, Location location1, Location location2, Integer numarPoduri)
    {
        super(length, speedLimit, location1, location2);
        this.numarPoduri = numarPoduri;
    }

    private Integer numarPoduri;

    public Integer getNumarPoduri()
    {
        return numarPoduri;
    }

    @Override
    public String toString()
    {
        return "Express{" +
                "numarPoduri=" + numarPoduri +
                "} " + super.toString();
    }
}
