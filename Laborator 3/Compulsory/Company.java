package Compulsory;

public class Company implements Comparable<Company>, Node
{
    private String name;

    public Company(String name)
    {
        this.name = name;
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public int compareTo(Company o)
    {
        return name.compareTo(o.getName());
    }
}
