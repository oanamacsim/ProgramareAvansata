package Compulsory;

public class Person implements Comparable<Person>, Node
{
    public Person(String name)
    {
        this.name = name;
    }

    private String name;

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public int compareTo(Person o)
    {
        return name.compareTo(o.getName());
    }
}
