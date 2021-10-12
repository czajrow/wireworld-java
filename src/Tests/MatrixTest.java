package Tests;

import org.junit.Before;
import org.junit.Test;
import wireworld.Cell;
import wireworld.Matrix;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

public class MatrixTest {
    private Matrix matrix;

    @Before
    public void setUp() throws IOException {
        matrix = new Matrix();
        matrix.setPathName("./data/library/diodes.txt");
        matrix.init();
    }

    @Test
    public void getCell() {
        // given
        final Cell CELL;

        // when
        CELL = matrix.getCell(3, 4);

        // then
        assertThat(CELL, instanceOf(Cell.class));
    }

    @Test
    public void init() throws IOException {
        // given
        Matrix matrix1 = new Matrix();
        matrix1.setPathName("./data/library/diodes.txt");
        // when
        matrix1.init();
        // then
        final Cell CELL = matrix1.getCell(0, 0);
        assertThat(CELL, instanceOf(Cell.class));
    }

    @Test
    public void setPathName() {
        // given
        // when
        matrix.setPathName("./data/library/diodes.txt");
        // then
        assertEquals(matrix.getPathName(), "./data/library/diodes.txt");
    }

    @Test
    public void nextGeneration() throws CloneNotSupportedException {
        // given
        Matrix matrix1 = matrix.copy();
        // when
        matrix.nextGeneration();
        // then
        assertNotEquals(matrix.hashCode(), matrix1.hashCode());
    }
}