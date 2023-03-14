package org.example.Homework;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;

public class InstanceBuilder
{

    private boolean projectNameIsUsed(List<Project> projects, String name)
    {
        for (Project project : projects) {
            if (project.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
    public List<Project> generateProjects(int numOfProjectsToCreate)
    {
        List<Project> projects = new ArrayList<>();
        Faker faker = new Faker();

        while (projects.size() < numOfProjectsToCreate)
        {
            String name = faker.app().name();

            if (!projectNameIsUsed(projects, name))
                projects.add(new Project(name));
        }

        return projects;
    }

    private boolean studentNameIsUsed(List<Student> students, String name)
    {
        for (Student student : students) {
            if (student.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
    public List<Student> generateStudents(int numOfStudentsToCreate)
    {
        List<Student> students = new ArrayList<>();
        Faker faker = new Faker();

        while (students.size() < numOfStudentsToCreate)
        {
            String name = faker.harryPotter().character();

            if (!studentNameIsUsed(students, name))
                students.add(new Student(name));
        }

        return students;
    }

    public void assignProjects(List<Project> projects, List<Student> students)
    {
        List<Project> projectsOfStudent0 = new ArrayList<>();
        projectsOfStudent0.add(projects.get(0));
        projectsOfStudent0.add(projects.get(1));
        projectsOfStudent0.add(projects.get(2));

        List<Project> projectsOfStudent1 = new ArrayList<>();
        projectsOfStudent1.add(projects.get(0));
        projectsOfStudent1.add(projects.get(1));

        List<Project> projectsOfStudent2 = new ArrayList<>();
        projectsOfStudent2.add(projects.get(0));

        students.get(0).setAdmissibleProjects(projectsOfStudent0);

        students.get(1).setAdmissibleProjects(projectsOfStudent1);

        students.get(2).setAdmissibleProjects(projectsOfStudent2);

    }
}
