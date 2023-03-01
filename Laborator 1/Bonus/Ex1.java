package Bonus;

public class Ex1
{
    private int[][] CreateAdjacencyMatrixForCycledGraph(int n)
    {
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++)
        {
            int from = i;
            int to = (i + 1) % n;

            matrix[from][to] = 1;
            matrix[to][from] = 1;
        }

        return matrix;
    }

    private int[][] multiplyTwoMatrices(int[][] matrix1, int[][] matrix2, int n)
    {
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                for (int k = 0; k < n; k++)
                    matrix[i][j] += matrix1[i][k] * matrix2[k][j];

        return matrix;
    }

    private int[][] raiseMatrixToPower(int[][] matrix, int n, int k)
    {
        int[][] result = new int[n][n];

        //copy the matrix:
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                result[i][j] = matrix[i][j];

        //repeat the multiplication to reproduce the pow effect
        for (int i = 1; i <= k; i++)
            result = multiplyTwoMatrices(result, matrix, n);

        return result;
    }

    public void solve(int n)
    {
        int[][] cycleGraphMatrix = CreateAdjacencyMatrixForCycledGraph(n);

        for (int a = 2; a <= n; a++)
        {
            System.out.println("a=" + a + " => A^" + a + ":");
            int[][] matrixRaisedToThePowerOfA = raiseMatrixToPower(cycleGraphMatrix, n, a);
            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < n; j++)
                    System.out.print(matrixRaisedToThePowerOfA[i][j] + " ");

                System.out.println("");
            }
            System.out.println("");
        }
    }
}
