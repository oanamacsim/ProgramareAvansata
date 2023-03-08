package Compulsory;

import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        List<Node> nodes = new ArrayList<>();

        nodes.add(new Person("Maria"));
        nodes.add(new Person("Radu"));
        nodes.add(new Person("Matei"));
        nodes.add(new Person("Marina"));
        nodes.add(new Person("Julia"));

        nodes.add(new Company("Adobe"));
        nodes.add(new Company("Microsoft"));
        nodes.add(new Company("Google"));


        for (int i = 0; i < nodes.size(); i++)
            System.out.println(nodes.get(i).getName());
    }
}