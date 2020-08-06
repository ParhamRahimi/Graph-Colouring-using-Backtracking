package utility.UI.Graphics;

import javafx.util.Pair;

import java.awt.*;
import java.util.Random;

/**
 * Created by Parham on 01-Jul-18.
 */

/**
 * @author Parham Rahimi
 *
 * a class to get graph adjacency matrix and colors and draw the graph with appropriate colors
 */
public class GraphGraphic {
    private int[][] adjacency;
    private int[] intColor;
    private Color[] colors;
    private Pair<Double, Double>[] positions;
    private final int nodeNumbers;
    private static final double scale = 150.0d;
    private static final double radius = 10.0d;

    /**
     * initialing
     *
     * @param adjacencyMatrix adjacency matrix of input graph
     * @param colorMatrix colors generated for each vertex
     */
    public GraphGraphic(int[][] adjacencyMatrix, int[] colorMatrix) {
        this.adjacency = adjacencyMatrix;
        this.intColor = colorMatrix;
        nodeNumbers = adjacencyMatrix.length;
        initialize();
    }

    /**
     * initialing
     */
    private void initialize() {

        initializePositions();

        initializeColors();
    }

    /**
     * initializing positions based on number of vertices
     */
    private void initializePositions() {
        positions = new Pair[nodeNumbers];

        for(int i = 0; i < nodeNumbers; i++) {
            double rad = (Math.PI * 2 * i) / nodeNumbers;

            double sin = Math.sin(rad);
            double cos = Math.cos(rad);

            this.positions[i] = new Pair<Double, Double>(sin * scale, cos * scale);
        }
    }

    /**
     * initializing colors
     */
    private void initializeColors() {
        this.colors = generateColors(this.intColor);
    }

    /**
     * generating real rgb colors for each vertex based on color integer generated in MColoringProblem
     * @param intColor color integer generated in MColoringProblem
     * @return real rgb colors for each vertex
     */
    private static Color[] generateColors(int[] intColor){
        Random random = new Random();
        Color[] colors = new Color[intColor.length];

        boolean repetitive = false;
        boolean valid = false;
        float r = 0, g = 0, b = 0;
        Color randomColor = new Color(0, 0, 0);
        for (int i = 0; i < intColor.length; i++) {
            for (int j = 0; j < i; j++) {
                if (intColor[i] == intColor[j]){
                    colors[i] = colors[j];
                    repetitive = true;
                    break;
                }
            }
            if (!repetitive) {
                while (!valid) {
                    valid = true;
                    r = random.nextFloat();
                    g = random.nextFloat();
                    b = random.nextFloat();
                    randomColor = new Color(r, g, b);
                    for (int j = 0; j < i; j++) {
                        if (colors[j] == randomColor) {
                            valid = false;
                        }
                    }
                }
                colors[i] = randomColor;
                valid = false;
            }
            repetitive = false;
        }

        return colors;
    }

    /**
     *
     * @param g
     * @param xOffset
     * @param yOffset
     */
    public void draw(Graphics g, int xOffset, int yOffset) {

//        g.setColor(Color.getColor());


        for(int i = 0; i < nodeNumbers; i++) {
            for(int j = i; j < nodeNumbers; j++) {
                if(adjacency[i][j] == 1) {
                    g.drawLine(xOffset + (int)positions[i].getKey().doubleValue(), yOffset + (int)positions[i].getValue().doubleValue(),
                            xOffset + (int)positions[j].getKey().doubleValue(), yOffset + (int)positions[j].getValue().doubleValue());
                }
            }
        }


        for(int i = 0; i < this.nodeNumbers; i++) {
            Color current = this.colors[i];

            Color text = new Color(255 - current.getRed(), 255 - current.getGreen(), 255 - current.getBlue());

            g.setColor(this.colors[i]);
            g.fillOval(xOffset + (int) (positions[i].getKey().doubleValue() - radius / 2), yOffset + (int) (positions[i].getValue() - radius / 2), (int)(radius) * 2, (int)(radius) * 2);
            g.setColor(text);
            g.drawString(i + "", xOffset + (int)positions[i].getKey().doubleValue(), yOffset + (int)(positions[i].getValue().doubleValue() + radius));
        }

        g.setColor(Color.black);
    }
}
