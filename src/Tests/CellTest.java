package Tests;

import org.junit.Before;
import org.junit.Test;
import wireworld.Cell;
import wireworld.CellState;

import java.awt.*;

import static org.junit.Assert.*;
import static wireworld.CellState.*;

public class CellTest {
    private Cell cellElectronHead;
    private Cell cellElectronTail;
    private Cell cellConductor;
    private Cell cellEmpty;

    @Before
    public void setUp() {
        cellElectronHead = new Cell();
        cellElectronTail = new Cell();
        cellConductor = new Cell();
        cellEmpty = new Cell();
    }

    @Test
    public void setState() {
        // given
        final CellState EXPECTED_CELL_STATE_ELECTRON_HEAD = ELECTRON_HEAD;
        final CellState EXPECTED_CELL_STATE_ELECTRON_TAIL = ELECTRON_TAIL;
        final CellState EXPECTED_CELL_STATE_CONDUCTOR = CONDUCTOR;
        final CellState EXPECTED_CELL_STATE_EMPTY = EMPTY;

        CellState ACTUAL_CELL_STATE_ELECTRON_HEAD;
        CellState ACTUAL_CELL_STATE_ELECTRON_TAIL;
        CellState ACTUAL_CELL_STATE_CONDUCTOR;
        CellState ACTUAL_CELL_STATE_EMPTY;

        // when
        cellElectronHead.setState(EXPECTED_CELL_STATE_ELECTRON_HEAD);
        cellElectronTail.setState(EXPECTED_CELL_STATE_ELECTRON_TAIL);
        cellConductor.setState(EXPECTED_CELL_STATE_CONDUCTOR);
        cellEmpty.setState(EXPECTED_CELL_STATE_EMPTY);

        // then
        ACTUAL_CELL_STATE_ELECTRON_HEAD = cellElectronHead.getState();
        ACTUAL_CELL_STATE_ELECTRON_TAIL = cellElectronTail.getState();
        ACTUAL_CELL_STATE_CONDUCTOR = cellConductor.getState();
        ACTUAL_CELL_STATE_EMPTY = cellEmpty.getState();

        assertEquals(EXPECTED_CELL_STATE_ELECTRON_HEAD, ACTUAL_CELL_STATE_ELECTRON_HEAD);
        assertEquals(EXPECTED_CELL_STATE_ELECTRON_TAIL, ACTUAL_CELL_STATE_ELECTRON_TAIL);
        assertEquals(EXPECTED_CELL_STATE_CONDUCTOR, ACTUAL_CELL_STATE_CONDUCTOR);
        assertEquals(EXPECTED_CELL_STATE_EMPTY, ACTUAL_CELL_STATE_EMPTY);
    }

    @Test
    public void getState() {
        // given
        final CellState EXPECTED_CELL_STATE_ELECTRON_HEAD = ELECTRON_HEAD;
        final CellState EXPECTED_CELL_STATE_ELECTRON_TAIL = ELECTRON_TAIL;
        final CellState EXPECTED_CELL_STATE_CONDUCTOR = CONDUCTOR;
        final CellState EXPECTED_CELL_STATE_EMPTY = EMPTY;

        CellState ACTUAL_CELL_STATE_ELECTRON_HEAD;
        CellState ACTUAL_CELL_STATE_ELECTRON_TAIL;
        CellState ACTUAL_CELL_STATE_CONDUCTOR;
        CellState ACTUAL_CELL_STATE_EMPTY;

        cellElectronHead.setState(EXPECTED_CELL_STATE_ELECTRON_HEAD);
        cellElectronTail.setState(EXPECTED_CELL_STATE_ELECTRON_TAIL);
        cellConductor.setState(EXPECTED_CELL_STATE_CONDUCTOR);
        cellEmpty.setState(EXPECTED_CELL_STATE_EMPTY);

        // when
        ACTUAL_CELL_STATE_ELECTRON_HEAD = cellElectronHead.getState();
        ACTUAL_CELL_STATE_ELECTRON_TAIL = cellElectronTail.getState();
        ACTUAL_CELL_STATE_CONDUCTOR = cellConductor.getState();
        ACTUAL_CELL_STATE_EMPTY = cellEmpty.getState();

        // then
        assertEquals(EXPECTED_CELL_STATE_ELECTRON_HEAD, ACTUAL_CELL_STATE_ELECTRON_HEAD);
        assertEquals(EXPECTED_CELL_STATE_ELECTRON_TAIL, ACTUAL_CELL_STATE_ELECTRON_TAIL);
        assertEquals(EXPECTED_CELL_STATE_CONDUCTOR, ACTUAL_CELL_STATE_CONDUCTOR);
        assertEquals(EXPECTED_CELL_STATE_EMPTY, ACTUAL_CELL_STATE_EMPTY);
    }

    @Test
    public void getStateColor() {
        // given
        final Color EXPECTED_CELL_COLOR_ELECTRON_HEAD = Color.blue;
        final Color EXPECTED_CELL_COLOR_ELECTRON_TAIL = Color.red;
        final Color EXPECTED_CELL_COLOR_CONDUCTOR = Color.yellow;
        final Color EXPECTED_CELL_COLOR_EMPTY = Color.black;

        Color ACTUAL_CELL_COLOR_ELECTRON_HEAD;
        Color ACTUAL_CELL_COLOR_ELECTRON_TAIL;
        Color ACTUAL_CELL_COLOR_CONDUCTOR;
        Color ACTUAL_CELL_COLOR_EMPTY;

        cellElectronHead.setState(ELECTRON_HEAD);
        cellElectronTail.setState(ELECTRON_TAIL);
        cellConductor.setState(CONDUCTOR);
        cellEmpty.setState(EMPTY);

        // when
        ACTUAL_CELL_COLOR_ELECTRON_HEAD = cellElectronHead.getStateColor();
        ACTUAL_CELL_COLOR_ELECTRON_TAIL = cellElectronTail.getStateColor();
        ACTUAL_CELL_COLOR_CONDUCTOR = cellConductor.getStateColor();
        ACTUAL_CELL_COLOR_EMPTY = cellEmpty.getStateColor();

        // then
        assertEquals(EXPECTED_CELL_COLOR_ELECTRON_HEAD, ACTUAL_CELL_COLOR_ELECTRON_HEAD);
        assertEquals(EXPECTED_CELL_COLOR_ELECTRON_TAIL, ACTUAL_CELL_COLOR_ELECTRON_TAIL);
        assertEquals(EXPECTED_CELL_COLOR_CONDUCTOR, ACTUAL_CELL_COLOR_CONDUCTOR);
        assertEquals(EXPECTED_CELL_COLOR_EMPTY, ACTUAL_CELL_COLOR_EMPTY);
    }
}
