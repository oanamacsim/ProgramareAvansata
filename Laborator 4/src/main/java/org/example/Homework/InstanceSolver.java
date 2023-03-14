package org.example.Homework;

import java.util.Comparator;
import java.util.List;

public class InstanceSolver
{
    private final List<Student> students;

    public InstanceSolver(List<Student> students)
    {
        this.students = students;
    }

    private Float getAverageNumberOfPreferencesOfStudents()
    {
        Float totalNumOfPreferences = 0.f;

        for (Student student : students)
        {
            totalNumOfPreferences += student.getNumberOfPreferences();
        }

        return totalNumOfPreferences / students.size();
    }

    public void showStudentsWithLessPreferences()
    {
        System.out.println("Students With Less Preferences:");
        Float average = getAverageNumberOfPreferencesOfStudents();

        students.stream()
                .filter(student -> student.getNumberOfPreferences() < average)
                .forEach(System.out::println);
    }

    private Integer getProjectImportance(Project project)
    {
        int projectImportance = 0;
        for (Student student : students)
            if (student.getAdmissibleProjects().contains(project))
                projectImportance += 1;

        return projectImportance;
    }

    private Project getBestProjectForStudent(Student student)
    {
        Integer minimumProjectImportance = Integer.MAX_VALUE;
        Project projectWithMinimumImportance = null;
        List<Project> admissibleProjects = student.getAdmissibleProjects();

        for (Project project : admissibleProjects)
        {
            Integer projectImportance = getProjectImportance(project);
            if(projectImportance < minimumProjectImportance)
            {
                minimumProjectImportance = projectImportance;
                projectWithMinimumImportance = project;
            }
        }

        return projectWithMinimumImportance;
    }

    private void removeProjectFromStudents(Project project)
    {
        for(Student student : students)
        {
            student.getAdmissibleProjects().remove(project);
        }
    }

    public void printSolutionWithGreedy()
    {
        List<Student> sortedStudents = students.stream()
                .sorted(Comparator.comparingInt(Student::getNumberOfPreferences))
                .toList();


        for (Student student : sortedStudents)
        {
            Project bestProject = getBestProjectForStudent(student);

            if(bestProject == null) {
                System.out.println("Instance Has No Solution!");
                return;
            }

            removeProjectFromStudents(bestProject);

            student.setFinalProject(bestProject);
        }

        System.out.println("Instance Solution:");
        System.out.println("Students:");
        for(Student student : students)
            System.out.println(student);
    }
}
