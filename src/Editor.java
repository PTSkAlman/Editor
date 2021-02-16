import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Editor {
    public Editor() {
        createMenu();
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                textArea.setText("");
            }
        });
        copyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                StringSelection stringSelection = new StringSelection(textArea.getText());
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(stringSelection, null);
            }
        });
        donateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("Scammad!");
            }
        });
        openFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser fc = new JFileChooser();
                int result = fc.showOpenDialog(null);
                String filename;
                if (result == JFileChooser.APPROVE_OPTION) {
                    filename = fc.getSelectedFile().getAbsolutePath();
                } else {
                    filename = "exempel.txt";
                }

                FileReader fr = null;
                try {
                    fr = new FileReader(filename);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                BufferedReader inFile = new BufferedReader(fr);
            }
        });
    }
    JMenuBar menuBar;
    JMenu menuFile;
    JMenuItem newFile;
    JMenuItem openFile;
    JMenuItem saveFile;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Editor");
        Editor editor = new Editor();

        frame.setSize(600, 800);
        frame.setJMenuBar(editor.menuBar);
        frame.setContentPane(editor.panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createMenu() {
        menuBar = new JMenuBar();
        menuFile = new JMenu("File");
        newFile = new JMenuItem("New");
        openFile = new JMenuItem("Open");
        saveFile = new JMenuItem("Save");
        menuFile.add(newFile);
        menuFile.add(openFile);
        menuFile.add(saveFile);
        menuBar.add(menuFile);

    }

    private JPanel panel;
    private JTextArea textArea;
    private JButton copyButton;
    private JButton donateButton;
    private JButton clearButton;



}
