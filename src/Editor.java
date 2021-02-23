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
        clearButton.addActionListener(new clear() {});
        copyButton.addActionListener(new copy() {});
        donateButton.addActionListener(new donate() {});
        newFile.addActionListener(new nFile() {});
        openFile.addActionListener(new oFile() {});
        saveFile.addActionListener(new sFile() {});
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


    private class copy implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            StringSelection stringSelection = new StringSelection(textArea.getText());
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, null);
        }
    }

    private class donate implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            System.out.println("Scammad!");
        }
    }

    private class clear implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            textArea.setText("");
        }
    }

    private class nFile implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if (textArea.getText().length() > 0) {
                int confirm = JOptionPane.showConfirmDialog(null, "Do you want to save?", "New File", JOptionPane.YES_NO_OPTION);
                if (confirm == 0) {
                    //Save file code
                } else {
                    textArea.setText("");
                }
            } else {
                textArea.setText("");
            }
        }
    }

    private class oFile implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            JFileChooser fc = new JFileChooser();
            int confirm = fc.showOpenDialog(null);
            String filename;
            if (confirm == JFileChooser.APPROVE_OPTION) {
                filename = fc.getSelectedFile().getAbsolutePath();
            } else {
                filename = "Textfile.txt";
            }
            BufferedReader br = null;
            try {
                br = new BufferedReader(new FileReader(filename));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            String line;
            try {
                while ((line = br.readLine()) != null) {
                    textArea.append(line + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private class sFile implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {

        }
    }
}
