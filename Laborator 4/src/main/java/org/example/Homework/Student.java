package org.example.Homework;

import java.util.ArrayList;
import java.util.List;

public class Student implements Comparable<Student>
{
    public String getName()
    {
        return name;
    }

    private final String name;
    private List<Project> admissibleProjects;

    public Student(String name)
    {
        this.name = name;
        this.admissibleProjects = new ArrayList<>();
    }

    public void setFinalProject(Project admissibleProject)
    {
        this.admissibleProjects.clear();
        this.admissibleProjects.add(admissibleProject);
    }

    public void setAdmissibleProjects(List<Project> admissibleProjects)
    {
        this.admissibleProjects = admissibleProjects;
    }

    public List<Project> getAdmissibleProjects()
    {
        return admissibleProjects;
    }

    public Integer getNumberOfPreferences()
    {
        return admissibleProjects.size();
    }

    @Override
    public int compareTo(Student o)
    {
        return name.compareTo(o.getName());
    }

    @Override
    public String toString()
    {
        return "Student{" +
                "name='" + name + '\'' +
                ", admissibleProjects=" + admissibleProjects +
                '}';
    }
}
