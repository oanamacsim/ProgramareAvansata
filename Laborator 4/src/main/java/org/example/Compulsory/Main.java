package org.example.Compulsory;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main
{
    private static Project getNthElement(TreeSet<Project> treeSet, int n) {
        Project nthProject = null;
        Iterator<Project> iterator = treeSet.iterator();
        for (int i = 0; i < n && iterator.hasNext(); i++) {
            nthProject = iterator.next();
        }
        return nthProject;
    }

    public static void main(String[] args)
    {
        TreeSet<Project> projects = Stream.of(
                new Project("P0"),
                new Project("P1"),
                new Project("P2")).collect(Collectors.toCollection(TreeSet::new));

        System.out.println("Projects:");
        for (Project project : projects)
        {
            System.out.println(project.getName());
        }

        List<Project> projectsList = projects.stream().toList();

        LinkedList<Student> students = (LinkedList<Student>)Stream.of(
                new Student("S3", Stream.of(getNthElement(projects, 1)).toList()),
                new Student("S2", Stream.of(getNthElement(projects, 1), getNthElement(projects, 2)).toList()),
                new Student("S1", Stream.of(getNthElement(projects, 1), getNthElement(projects, 2), getNthElement(projects, 3)).toList())).collect(Collectors.toCollection(LinkedList::new));

        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student p1, Student p2) {
                return p1.compareTo(p2);
            }
        });

        System.out.println("Students:");
        for(Student student : students)
            System.out.println(student.getName());
    }
}