package wireworld;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Window extends JFrame implements ActionListener {
    private final Game game;
    private Matrix matrix;
    private MyCanvas myCanvas;

    private JMenuItem mStartStop;
    private JMenuItem m1000ms;
    private JMenuItem m500ms;
    private JMenuItem m250ms;
    private JMenuItem m100ms;
    private JMenuItem mData;
    private JMenuItem mDiodes;
    private JMenuItem mHighFrequencyGenerator;
    private JMenuItem mLowFrequencyGenerator;
    private JMenuItem mNANDgate;
    private JMenuItem mNOTgate;
    private JMenuItem mORgate;
    private JMenuItem mXORgate;
    private JMenuItem mEasterEgg;
    private JMenuItem mSave;


    Window(Matrix matrix, Game game) {
        this.matrix = matrix;
        this.game = game;
    }

    public void redrawMatrix(Matrix matrix) {
        myCanvas.setMatrix(matrix);
        myCanvas.repaint();
    }

    public void createWindow() {
        setupWindow();
        setupMenu();
        drawContent();
    }

    public void setMatrix(Matrix matrix) {
        this.matrix = matrix;
    }

    private void setupWindow() {
        setSize(1024, 512);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Wireworld");
    }

    private void setupMenu() {
        JMenuBar menuBar = new JMenuBar();

        JMenu menuPeriod = new JMenu("Frequency");
        mStartStop = new JMenuItem("Start/Stop", ' ');
        m1000ms = new JMenuItem("1Hz", '1');
        m500ms = new JMenuItem("2Hz", '2');
        m250ms = new JMenuItem("4Hz", '3');
        m100ms = new JMenuItem("10Hz", '4');
        JMenu mLibrary = new JMenu("Library");
        mData = new JMenuItem("User's data.txt");
        mDiodes = new JMenuItem("Diodes");
        mHighFrequencyGenerator = new JMenuItem("High Frequency Generator");
        mLowFrequencyGenerator = new JMenuItem("Low Frequency Generator");
        mNANDgate = new JMenuItem("NAND gate");
        mNOTgate = new JMenuItem("NOT gate");
        mORgate = new JMenuItem("OR gate");
        mXORgate = new JMenuItem("XOR gate");
        mEasterEgg = new JMenuItem("");
        mSave = new JMenuItem("Save to TXT");

        setJMenuBar(menuBar);

        menuBar.add(menuPeriod);
        menuPeriod.add(m1000ms);
        m1000ms.addActionListener(this);
        menuPeriod.add(m500ms);
        m500ms.addActionListener(this);
        menuPeriod.add(m250ms);
        m250ms.addActionListener(this);
        menuPeriod.add(m100ms);
        m100ms.addActionListener(this);

        menuBar.add(mLibrary);
        mLibrary.add(mDiodes);
        mDiodes.addActionListener(this);
        mLibrary.add(mHighFrequencyGenerator);
        mHighFrequencyGenerator.addActionListener(this);
        mLibrary.add(mLowFrequencyGenerator);
        mLowFrequencyGenerator.addActionListener(this);
        mLibrary.add(mNANDgate);
        mNANDgate.addActionListener(this);
        mLibrary.add(mNOTgate);
        mNOTgate.addActionListener(this);
        mLibrary.add(mORgate);
        mORgate.addActionListener(this);
        mLibrary.add(mXORgate);
        mXORgate.addActionListener(this);

        menuBar.add(mData);
        mData.addActionListener(this);

        menuBar.add(mStartStop);
        mStartStop.addActionListener(this);

        menuBar.add(mSave);
        mSave.addActionListener(this);

        menuBar.add(mEasterEgg);
        mEasterEgg.addActionListener(this);
    }

    private void drawContent() {
        myCanvas = new MyCanvas(matrix);
        getContentPane().add(myCanvas);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object object = e.getSource();
        if (object == mStartStop) {
            startStop();
        } else if (object == m1000ms) {
            setMenuPeriod(1000);
        } else if (object == m500ms) {
            setMenuPeriod(500);
        } else if (object == m250ms) {
            setMenuPeriod(250);
        } else if (object == m100ms) {
            setMenuPeriod(100);
        } else if (object == mData) {
            game.setInputFileName("./data/data.txt");
            try {
                remakeMatrix();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else if (object == mDiodes) {
            game.setInputFileName("./data/library/diodes.txt");
            try {
                remakeMatrix();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else if (object == mHighFrequencyGenerator) {
            game.setInputFileName("./data/library/highFrequencyGenerator.txt");
            try {
                remakeMatrix();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else if (object == mLowFrequencyGenerator) {
            game.setInputFileName("./data/library/lowFrequencyGenerator.txt");
            try {
                remakeMatrix();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else if (object == mNANDgate) {
            game.setInputFileName("./data/library/NANDgate.txt");
            try {
                remakeMatrix();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else if (object == mORgate) {
            game.setInputFileName("./data/library/ORgate.txt");
            try {
                remakeMatrix();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else if (object == mXORgate) {
            game.setInputFileName("./data/library/XORgate.txt");
            try {
                remakeMatrix();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else if (object == mNOTgate) {
            game.setInputFileName("./data/library/NOTgate.txt");
            try {
                remakeMatrix();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else if (object == mEasterEgg) {
            game.setInputFileName("./data/easterEgg.txt");
            try {
                remakeMatrix();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else if (object == mSave) {
            try {
                save();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    private void startStop() {
        game.setRun(!game.isRun());
    }

    private void setMenuPeriod(int period) {
        game.setPeriod(period);
    }

    private void remakeMatrix() throws IOException {
        matrix = game.makeMatrixFromFile();
    }

    private void save() throws IOException {
        game.save();
    }
}
