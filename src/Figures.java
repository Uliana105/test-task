import java.awt.*;

public abstract class Figures {

    public abstract void draw(Graphics g, int positionX, int positionY);
    public abstract int getSquare();
    public abstract Color getColor();

    public static class Square extends Figures{

        private final int side;
        private final Color color;
        Square(int side, Color color) {
            this.side = side;
            this.color = color;
        }
        @Override
        public void draw(Graphics g, int positionX, int positionY) {
            g.setColor(color);
            g.fillRect(positionX, positionY, side, side);
            g.setColor(Color.BLACK);
            g.drawRect(positionX, positionY, side, side);
        }

        @Override
        public int getSquare() {
            return side*side;
        }

        @Override
        public Color getColor() {
            return color;
        }
        public int getSide() {
            return side;
        }
    }

    public static class Circle extends Figures{

        private final int radius;
        private final Color color;
        Circle(int radius, Color color) {
            this.radius = radius;
            this.color = color;
        }

        @Override
        public void draw(Graphics g, int positionX, int positionY) {
            g.setColor(color);
            g.fillOval(positionX, positionY, 2*radius, 2*radius);
            g.setColor(Color.BLACK);
            g.drawOval(positionX, positionY, 2*radius, 2*radius);
        }

        @Override
        public int getSquare() {
            return (int)(Math.PI*Math.pow(radius, 2));
        }

        @Override
        public Color getColor() {
            return color;
        }

        public int getRadius() {
            return radius;
        }
    }

    public static class Triangle extends Figures{

        private final int hypotenuse;
        private final Color color;
        int[] pointsX = new int[3];
        int[] pointsY = new int[3];
        Triangle(int hypotenuse, Color color) {
            this.hypotenuse = hypotenuse;
            this.color = color;
        }
        @Override
        public void draw(Graphics g, int positionX, int positionY) {
            pointsX[0] = positionX;
            pointsX[1] = pointsX[0]+hypotenuse;
            pointsX[2] = pointsX[0]+hypotenuse/2;
            pointsY[0] = positionY;
            pointsY[1] = pointsY[0];
            pointsY[2] = pointsY[0]+hypotenuse/2;
            g.setColor(color);
            g.fillPolygon(pointsX, pointsY, 3);
            g.setColor(Color.BLACK);
            g.drawPolygon(pointsX, pointsY, 3);
        }

        @Override
        public Color getColor() {
            return color;
        }

        public int getHypotenuse() {
            return hypotenuse;
        }

        @Override
        public int getSquare() {
            return (int)((1/2.0)*hypotenuse*hypotenuse/2);
        }
    }

    public static class Trapeze extends Figures {

        private final int heightOfTrapeze;
        private final Color color;
        private final int[] pointsX = new int[4];
        private final int[] pointsY = new int[4];

        Trapeze(int height, Color color) {
            this.heightOfTrapeze = height;
            this.color = color;
        }

        @Override
        public void draw(Graphics g, int positionX, int positionY) {
            pointsX[0] = positionX;
            pointsX[1] = pointsX[0]+heightOfTrapeze;
            pointsX[2] = pointsX[1]+heightOfTrapeze/2;
            pointsX[3] = pointsX[0];
            pointsY[0] = positionY;
            pointsY[1] = pointsY[0];
            pointsY[2] = pointsY[0] + heightOfTrapeze;
            pointsY[3] = pointsY[0] + heightOfTrapeze;
            g.setColor(color);
            g.fillPolygon(pointsX, pointsY, 4);
            g.setColor(Color.BLACK);
            g.drawPolygon(pointsX, pointsY, 4);
        }

        @Override
        public Color getColor() {
            return color;
        }

        @Override
        public int getSquare() {
            return (int)((5/2*heightOfTrapeze) / 2.0 * heightOfTrapeze);
        }

        public int getHeightOfTrapeze() {
            return heightOfTrapeze;
        }
    }
}
