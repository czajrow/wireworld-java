package wireworld;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Matrix implements Cloneable {
    private Cell[][] cells;
    private Path path;
    private Parser parser;
    private int numberOfColumns;
    private int numberOfRows;

    public void init() throws IOException {
        parser = new Parser(path);
        numberOfColumns = parser.getNumberOfColumns();
        numberOfRows = parser.getNumberOfRows();
        this.initializeCells();
        this.readMatrix();
    }

    public void setPathName(String name) {
        this.path = Paths.get(name);
    }

    public String getPathName() {
        return String.valueOf(path);
    }

    public int getNumberOfColumns() {
        return numberOfColumns;
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public Cell getCell(int x, int y) {
        return cells[x][y];
    }

    private void initializeCells() {
        cells = new Cell[numberOfRows][numberOfColumns];
        for (int i = 0; i < numberOfRows; i++)
            for (int j = 0; j < numberOfColumns; j++) {
                cells[i][j] = new Cell();
            }
    }

    private void readMatrix() {
        for (int i = 0; i < numberOfRows; i++)
            for (int j = 0; j < numberOfColumns; j++) {
                cells[i][j].setState(parser.readNextState());
            }
    }

    public Matrix nextGeneration() throws CloneNotSupportedException {
        Matrix newMatrix;
        newMatrix = this.copy();
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                countNeighboursElectronHeads(i, j);
                final CellState NEW_STATE = cells[i][j].getNextState();
                newMatrix.getCell(i, j).setState(NEW_STATE);
            }
        }
        return newMatrix;
    }

    private void countNeighboursElectronHeads(int row, int column) throws CloneNotSupportedException { //prosze wybaczyc i nawet tego nie czytac :(
        final CellState ELECTRON_HEAD = CellState.ELECTRON_HEAD;
        cells[row][column].setNumberOfNeighboursElectronHeads(0);
        final Cell CELL = cells[row][column].copy();

        if (row > 0 && column > 0)
            if (cells[row - 1][column - 1].getState() == ELECTRON_HEAD)
                CELL.incrementNumberOfNeighboursElectronHeads();
        if (row > 0)
            if (cells[row - 1][column].getState() == ELECTRON_HEAD)
                CELL.incrementNumberOfNeighboursElectronHeads();
        if (row > 0 && column < numberOfColumns - 1)
            if (cells[row - 1][column + 1].getState() == ELECTRON_HEAD)
                CELL.incrementNumberOfNeighboursElectronHeads();

        if (column > 0)
            if (cells[row][column - 1].getState() == ELECTRON_HEAD)
                CELL.incrementNumberOfNeighboursElectronHeads();
        if (column < numberOfColumns - 1)
            if (cells[row][column + 1].getState() == ELECTRON_HEAD)
                CELL.incrementNumberOfNeighboursElectronHeads();

        if (row < numberOfRows - 1 && column > 0)
            if (cells[row + 1][column - 1].getState() == ELECTRON_HEAD)
                CELL.incrementNumberOfNeighboursElectronHeads();
        if (row < numberOfRows - 1)
            if (cells[row + 1][column].getState() == ELECTRON_HEAD)
                CELL.incrementNumberOfNeighboursElectronHeads();
        if (row < numberOfRows - 1 && column < numberOfColumns - 1)
            if (cells[row + 1][column + 1].getState() == ELECTRON_HEAD)
                CELL.incrementNumberOfNeighboursElectronHeads();
        cells[row][column] = CELL;
    }

    private void setCells(Cell[][] cells) {
        this.cells = cells;
    }

    public Matrix copy() throws CloneNotSupportedException {
        Matrix matrix = (Matrix) super.clone();
        matrix.initializeCells();
        Cell[][] cells;
        cells = copyCells();
        matrix.setCells(cells);
        return matrix;
    }

    private Cell[][] copyCells() throws CloneNotSupportedException {
        Cell[][] cells = new Cell[numberOfRows][numberOfColumns];
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                cells[i][j] = this.cells[i][j].copy();
            }
        }
        return cells;
    }
}
