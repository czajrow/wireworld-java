package wireworld;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MyFileWriter {
    private FileWriter fileWriter;

    MyFileWriter() throws IOException {
        Path path;
        path = makeNextPath();
        File file = new File(String.valueOf(path));
        file.createNewFile();
        fileWriter = new FileWriter(String.valueOf(path));
    }

    public void writeFile(Matrix matrix) throws IOException {
        Integer numberOfRows = matrix.getNumberOfRows();
        Integer numberOfColumns = matrix.getNumberOfColumns();

        fileWriter.write(numberOfRows.toString());
        fileWriter.write(" ");
        fileWriter.write(numberOfColumns.toString());
        fileWriter.write("\n");

        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                int stateChar = matrix.getCell(i, j).getStateChar();
                fileWriter.write(stateChar);
                fileWriter.write(" ");
            }
            fileWriter.write("\n");
        }
        fileWriter.close();
    }

    private Path makeNextPath() {
        int n = 0;
        String name = "./data/results/result_" + n + ".txt";
        File file = new File(name);
        while (file.exists()) {
            n++;
            name = "./data/results/result_" + n + ".txt";
            file = new File(name);
        }
        return Paths.get(name);
    }
}
