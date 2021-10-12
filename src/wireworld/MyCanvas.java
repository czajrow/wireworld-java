package wireworld;

import java.awt.*;

public class MyCanvas extends Canvas {
    private Matrix matrix;

    MyCanvas(Matrix matrix) {
        this.matrix = matrix;
    }

    public void setMatrix(Matrix matrix) {
        this.matrix = matrix;
    }

    @Override
    public void paint(Graphics graphics) {
        graphics.setColor(new Color(40, 40, 40)); // same red, green and blue value, so gray shades
        graphics.fillRect(0, 0, getBounds().width, getBounds().height);
        int numberOfRows = matrix.getNumberOfRows();
        int numberOfColumns = matrix.getNumberOfColumns();
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                int width = getBounds().width / numberOfColumns;
                int height = getBounds().height / numberOfRows;
                int y = i * height;
                int x = j * width;
                graphics.setColor(matrix.getCell(i, j).getStateColor());
                graphics.fillRect(x, y, width - 1, height - 1);
            }
        }
    }
}
