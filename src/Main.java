import process.AdjacencyMatrixCalculator;
import process.MColoringProblem;
import utility.UI.MainFrame;
import utility.input_output.InputFileReader;
import utility.input_output.OutputFileWriter;

import java.io.IOException;

/**
 * Created by Parham on 10-Jun-18.
 * @author Parham Rahimi
 */
public class Main {
    public static void main(String args[])
    {
        // give the input file name(path) as the argument to the function
        InputFileReader inputFileReader = new InputFileReader("in3.csv");
        AdjacencyMatrixCalculator adjacencyMatrixCalculator =
                new AdjacencyMatrixCalculator(inputFileReader.getFirstVertices(), inputFileReader.getSecondVertices());
        int graph[][] = adjacencyMatrixCalculator.getAdjacencyMatrix();
        //test graphs
        /*
        int graph[][] = {
                {0, 1, 1, 1},
                {1, 0, 1, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 0},
        };
        */
        /*
        int graph[][] = {
                {0, 1, 1, 0, 0},
                {1, 0, 1, 0, 0},
                {1, 1, 0, 1, 0},
                {0, 0, 1, 0, 1},
                {0, 0, 0, 1, 0},
        };
        */

        int m = graph.length; // Number of colors
        long start = System.currentTimeMillis();
        MColoringProblem Coloring = new MColoringProblem(m, graph);
        System.out.println("Elapsed time: " + (System.currentTimeMillis() - start) + "ms");
        try {
            new OutputFileWriter("out3.txt", Coloring.getColor());
        } catch (IOException e) {
            e.printStackTrace();
        }
        new MainFrame(graph, Coloring.getColor());
    }
}
