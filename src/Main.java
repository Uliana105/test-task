import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Random;

public class Main extends Canvas{
    private static final int FRAME_WIDTH = 500;
    private static final int FRAME_HEIGHT = 500;
    private static final String[] possibleFigures = {"square", "circle", "triangle", "trapeze"};
    private static final Color[] possibleColors = {Color.BLUE, Color.RED, Color.YELLOW, Color.GRAY, Color.GREEN, Color.MAGENTA};
    private static final HashMap<Color, String> colorName = new HashMap<>() {{
        put(Color.BLUE, "blue");
        put(Color.RED, "red");
        put(Color.YELLOW, "yellow");
        put(Color.GRAY, "gray");
        put(Color.GREEN, "green");
        put(Color.MAGENTA, "magenta");
    }};
    private static Figures[] figures;
    private static final int MAX_SIZE_OF_FIGURE = 150;
    private static final int MIN_SIZE_OF_FIGURE = 60;
    private static final int MAX_NUM_OF_FIGURES = (FRAME_WIDTH/MAX_SIZE_OF_FIGURE)*(FRAME_HEIGHT/MAX_SIZE_OF_FIGURE);

    public static void main(String[] args) {
        figures = new Figures[rand(1, MAX_NUM_OF_FIGURES)];
        generateFigures();
        drawGeneratedFigures();
    }

    private static void drawGeneratedFigures() {
        Canvas canvas = new MyCanvas();
        JFrame frame = new JFrame("Figures");
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        canvas.setBackground(Color.WHITE);
        frame.add(canvas);
        frame.setVisible(true);
    }

    private static void generateFigures() {
        for (int i = 0; i < figures.length; i++) {
            String currentFigure = possibleFigures[rand(0, possibleFigures.length)];
            Color currentColor = possibleColors[rand(0, possibleColors.length)];
            System.out.print("Figure: " + currentFigure);
            switch (currentFigure) {
                case "square" -> {
                    Figures.Square figure = new Figures.Square(rand(MIN_SIZE_OF_FIGURE, MAX_SIZE_OF_FIGURE), currentColor);
                    figures[i] = figure;
                    System.out.println(", square: " + figures[i].getSquare() + ", side length: " + figure.getSide() +
                            ", color: " + colorName.get(figure.getColor()));
                }
                case "circle" -> {
                    Figures.Circle figure = new Figures.Circle(rand(MIN_SIZE_OF_FIGURE, MAX_SIZE_OF_FIGURE) / 2, currentColor);
                    figures[i] = figure;
                    System.out.println(", square: " + figures[i].getSquare() + ", radius: " + figure.getRadius() +
                            ", color: " + colorName.get(figure.getColor()));
                }
                case "triangle" -> {
                    Figures.Triangle figure = new Figures.Triangle(rand(MIN_SIZE_OF_FIGURE, MAX_SIZE_OF_FIGURE), currentColor);
                    figures[i] = figure;
                    System.out.println(", square: " + figures[i].getSquare() + ", hypotenuse: " + figure.getHypotenuse() +
                            ", color: " + colorName.get(figure.getColor()));
                }
                case "trapeze" -> {
                    Figures.Trapeze figure = new Figures.Trapeze(rand(MIN_SIZE_OF_FIGURE, MAX_SIZE_OF_FIGURE) / 2, currentColor);
                    figures[i] = figure;
                    System.out.println(", square: " + figures[i].getSquare() + ", height: " + figure.getHeightOfTrapeze() +
                            ", color: " + colorName.get(figure.getColor()));
                }
            }
        }
    }

    public static int rand(int min, int max) {
        Random random = new Random();
        int i = random.nextInt(max-min);
        return i+min;
    }

    private static class MyCanvas extends Canvas {
        @Override
        public void paint(Graphics g) {
            int numOfFiguresPerRow = FRAME_WIDTH/MAX_SIZE_OF_FIGURE;
            int currentRowNum = 0, currentNumCol = 0;
            for (Figures figure : figures) {
                figure.draw(g, currentNumCol * MAX_SIZE_OF_FIGURE, currentRowNum * MAX_SIZE_OF_FIGURE);
                currentNumCol++;
                if (currentNumCol == numOfFiguresPerRow) {
                    currentNumCol = 0;
                    currentRowNum++;
                }
            }
        }
    }
}
