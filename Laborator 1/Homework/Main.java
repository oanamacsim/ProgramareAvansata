package Homework;

public class Main
{
    private static boolean validateInput(String[] input)
    {
        if (input.length == 0)
            return false;

        int positiveInteger = Integer.parseInt(input[0]);

        if(positiveInteger <= 0)
            return false;

        return true;
    }

    private static int[][] getLatinSquaredMatrix(int n)
    {
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++)
        {
            if(i == 0)
            {
                for (int j = 0; j < n; j++)
                    matrix[i][j] = j + 1;
            }
            else
            {
                int previousElementCopy = matrix[i - 1][0];

                for (int j = 0; j < n - 1; j++)
                    matrix[i][j] = matrix[i - 1][j + 1];

                matrix[i][n - 1] = previousElementCopy;
            }
        }

        return matrix;
    }

    private static void displayMatrixLinesAndColumnsAsString(int[][] matrix, int n)
    {
        System.out.println("Display each matrix line as string:");
        for (int i = 0; i < n; i++)
        {
            String line = "";
            for (int j = 0; j < n; j++) {
                line += Integer.toString(matrix[i][j]);
            }
            System.out.println(line);
        }

        System.out.println("Display each matrix column as string:");
        for (int i = 0; i < n; i++)
        {
            String column = "";
            for (int j = 0; j < n; j++) {
                column += Integer.toString(matrix[j][i]);
            }
            System.out.println(column);
        }
    }

    public static void main(String[] args)
    {

        if (!validateInput(args))
        {
            System.out.println("Invalid input");
            return;
        }

        int n = Integer.parseInt(args[0]);

        long startTime = System.nanoTime();
        int[][] matrix = getLatinSquaredMatrix(n);

        if(n < 30000)
        {
            displayMatrixLinesAndColumnsAsString(matrix, n);
        }
        else
        {
            long executionTimeInNanoSeconds =  System.nanoTime() - startTime;
            System.out.println("Execution time of the application in nanoseconds: " + executionTimeInNanoSeconds);
        }
    }
}
