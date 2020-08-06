package utility.UI;

import sun.applet.Main;

import javax.swing.*;

/**
 * Created by Parham on 01-Jul-18.
 */

/**
 * @author Parham Rahimi
 *
 * a class to define graphic window and draw the visual form of matrix and its colors in it
 */
public class MainFrame extends JFrame {

    private int graph[][];
    private int colors[];

    public MainFrame(int graph[][], int colors[]) {
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.graph = graph;
        this.colors = colors;

        this.setSize(800, 600);
        this.setLocation(200, 200);


        this.getContentPane().add(new Canvas(graph, colors));


        this.setVisible(true);
    }

}
