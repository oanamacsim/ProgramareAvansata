package org.example.Compulsory;

import java.util.List;

public class Student implements Comparable<Student>
{
    public String getName()
    {
        return name;
    }

    private String name;
    private List<Project> admissibleProjects;

    public Student(String name, List<Project> admissibleProjects)
    {
        this.name = name;
        this.admissibleProjects = admissibleProjects;
    }

    @Override
    public int compareTo(Student o)
    {
        return name.compareTo(o.getName());
    }

    public List<Project> getAdmissibleProjects()
    {
        return admissibleProjects;
    }
}
