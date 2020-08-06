package utility.UI;

import utility.UI.Graphics.GraphGraphic;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Parham on 01-Jul-18.
 */

/**
 * @author Parham Rahimi
 *
 * a jPanel class to initial graphGrphics based on matrix and colors
 */
public class Canvas extends JPanel {

    private int[][] matrix;
    private GraphGraphic graphGraphic;

    public Canvas(int[][] matrix, int[] colors) {
        this.matrix = matrix;
        graphGraphic = new GraphGraphic(matrix, colors);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        graphGraphic.draw(g, 400, 300);
    }
}
