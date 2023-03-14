package org.example.Homework;

import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        InstanceBuilder instanceBuilder = new InstanceBuilder();

        int numOfInstances = 3;

        List<Project> projects = instanceBuilder.generateProjects(numOfInstances);

        List<Student> students = instanceBuilder.generateStudents(numOfInstances);
        instanceBuilder.assignProjects(projects, students);

        InstanceSolver instanceSolver = new InstanceSolver(students);
        instanceSolver.showStudentsWithLessPreferences();

        instanceSolver.printSolutionWithGreedy();
    }
}