package wireworld;

import java.io.IOException;

public class Game {
    private String inputFileName = "./data/data.txt";
    private int period = 250;
    private boolean run = true;
    private Matrix matrix;
    private Window window;

    public void setRun(boolean run) {
        this.run = run;
    }

    public boolean isRun() {
        return run;
    }

    public void setPeriod(int period) {
        this.period = period;
    }


    public void setInputFileName(String inputFileName) {
        this.inputFileName = inputFileName;
    }

    public Matrix makeMatrixFromFile() throws IOException {
        Matrix newMatrix = new Matrix();
        newMatrix.setPathName(inputFileName);
        newMatrix.init();
        window.setMatrix(newMatrix);
        matrix = newMatrix;
        return newMatrix;
    }

    public void save() throws IOException {
        MyFileWriter myFileWriter = new MyFileWriter();
        myFileWriter.writeFile(matrix);
    }

    public void run() throws IOException, CloneNotSupportedException, InterruptedException {
        matrix = new Matrix();
        matrix.setPathName(inputFileName);
        matrix.init();
        window = new Window(matrix, this);
        window.createWindow();

        while (true) {
            if (run) {
                window.redrawMatrix(matrix);
                Thread.sleep(period);
                matrix = matrix.nextGeneration();
            } else {
                Thread.sleep(100);
            }
        }
    }
}
