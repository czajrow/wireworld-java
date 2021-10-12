package wireworld;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class Parser {
    private Scanner scanner;
    private final int numberOfColumns;
    private final int numberOfRows;

    Parser(Path path) throws IOException {
        FileReader fileReader = new FileReader(String.valueOf(path));
        scanner = new Scanner(fileReader);
        numberOfColumns = scanner.nextInt();
        numberOfRows = scanner.nextInt();
    }

    public CellState readNextState() {
        return intToCellState(scanner.nextInt());
    }

    private CellState intToCellState(int read) {
        switch (read) {
            case 0:
                return CellState.EMPTY;
            case 1:
                return CellState.ELECTRON_HEAD;
            case 2:
                return CellState.ELECTRON_TAIL;
            case 3:
                return CellState.CONDUCTOR;
            default:
                return null;
        }
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public int getNumberOfColumns() {
        return numberOfColumns;
    }
}
