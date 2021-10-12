package wireworld;

import java.awt.*;

public class Cell implements Cloneable {
    private CellState state = CellState.EMPTY;
    private int numberOfNeighboursElectronHeads = 0;

    public void setState(CellState state) {
        this.state = state;
    }

    public CellState getState() {
        return state;
    }

    public char getStateChar() {
        switch (state) {
            case EMPTY:
                return '0';
            case ELECTRON_HEAD:
                return '1';
            case ELECTRON_TAIL:
                return '2';
            case CONDUCTOR:
                return '3';
            default:
                return '9';
        }
    }

    public Color getStateColor() {
        switch (state) {
            case EMPTY:
                return Color.black;
            case ELECTRON_HEAD:
                return Color.blue;
            case ELECTRON_TAIL:
                return Color.red;
            case CONDUCTOR:
                return Color.yellow;
            default:
                return null;
        }
    }

    public void setNumberOfNeighboursElectronHeads(int numberOfNeighboursElectronHeads) {
        this.numberOfNeighboursElectronHeads = numberOfNeighboursElectronHeads;
    }

    public void incrementNumberOfNeighboursElectronHeads() {
        numberOfNeighboursElectronHeads++;
    }

    public CellState getNextState() {
        switch (state) {
            case EMPTY:
                return CellState.EMPTY;
            case ELECTRON_HEAD:
                return CellState.ELECTRON_TAIL;
            case ELECTRON_TAIL:
                return CellState.CONDUCTOR;
            case CONDUCTOR:
                if (numberOfNeighboursElectronHeads == 1 || numberOfNeighboursElectronHeads == 2)
                    return CellState.ELECTRON_HEAD;
                else
                    return CellState.CONDUCTOR;
            default:
                return CellState.EMPTY;
        }
    }

    public Cell copy() throws CloneNotSupportedException {
        return (Cell) this.clone();
    }
}
