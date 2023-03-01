package Bonus;

public class Ex2
{
    public void solve(int numOfVertices, int vertexDegree)
    {
        if(numOfVertices >= vertexDegree + 1 && (numOfVertices * vertexDegree) % 2 == 0)
        {
            int[][] adjMatrixOfARegularGraph = new int[numOfVertices][numOfVertices];
            int[] vertexDegreeFreq = new int[numOfVertices];

            for (int i = 0; i < numOfVertices; i++)
            {
                while (vertexDegreeFreq[i] < vertexDegree)
                {
                    for (int j = numOfVertices - 1; j >= 0; j--)
                    {
                        int from = i;
                        int to = j;
                        if (from != to && vertexDegreeFreq[from] < vertexDegree && vertexDegreeFreq[to] < vertexDegree)
                        {
                            adjMatrixOfARegularGraph[from][to] = 1;
                            vertexDegreeFreq[from] += 1;

                            adjMatrixOfARegularGraph[to][from] = 1;
                            vertexDegreeFreq[to] += 1;
                        }
                    }
                }
            }

            for (int i = 0; i < numOfVertices; i++)
            {
                for (int j = 0; j < numOfVertices; j++)
                {
                    System.out.print(adjMatrixOfARegularGraph[i][j]);
                    System.out.print(" ");
                }
                System.out.println("");
            }
        }
        else
        {
            System.out.println("Invalid input");
        }
    }
}