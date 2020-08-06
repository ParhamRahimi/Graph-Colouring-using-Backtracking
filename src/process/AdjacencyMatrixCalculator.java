package process;

import java.util.ArrayList;

/**
 * Created by Parham on 10-Jun-18.
 */


/**
 * @author Parham Rahimi
 *
 * a class to generate adjacency matrix from input csv file
 */
public class AdjacencyMatrixCalculator {
    private int adjacencyMatrix[][];
    private int sizeOfList = 0;

    /**
     * generate adjacency matrix from input csv file
     *
     * @param firstVertices first vertices
     * @param secondVertices second vertices
     */
    public AdjacencyMatrixCalculator(ArrayList<Integer> firstVertices, ArrayList<Integer> secondVertices){
        for (int i = 0; i < firstVertices.size(); i++){
            if (firstVertices.get(i) > sizeOfList)
                sizeOfList = firstVertices.get(i);
        }
        adjacencyMatrix = new int[sizeOfList][sizeOfList];
        for (int i = 0; i < sizeOfList; i++) {
            for (int j = 0; j < sizeOfList; j++) {
                adjacencyMatrix[i][j] = 0;
            }
        }
        for (int i = 0; i < firstVertices.size(); i++) {
            adjacencyMatrix[firstVertices.get(i) - 1][secondVertices.get(i) - 1] = 1;
        }
    }

    /**
     * getter of result adjacency matrix
     * @return adjacency matrix
     */
    public int[][] getAdjacencyMatrix() {
        return adjacencyMatrix;
    }
}
