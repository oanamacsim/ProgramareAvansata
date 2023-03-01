package Bonus;

public class Main
{
    public static void main(String[] args)
    {
        //start ex1
        int n = 8;
        Ex1 ex1 = new Ex1();
        ex1.solve(n);

        //start ex2
        if (args.length != 2)
        {
            System.out.println("Invalid number of arguments. Expected 2");
            return;
        }
        else
        {
            int numOfVertices = Integer.parseInt(args[0]);
            int vertexDegree = Integer.parseInt(args[1]);

            Ex2 ex2 = new Ex2();
            ex2.solve(numOfVertices, vertexDegree);
        }
    }
}
