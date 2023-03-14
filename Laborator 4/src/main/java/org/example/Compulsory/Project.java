package org.example.Compulsory;

public class Project implements Comparable<Project>
{
    public String getName()
    {
        return name;
    }

    private String name;

    public Project(String name)
    {
        this.name = name;
    }

    @Override
    public int compareTo(Project o)
    {
        return name.compareTo(o.getName());
    }
}
