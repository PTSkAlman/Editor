import javax.swing.*;

public class Editor {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Editor");
        Editor editor = new Editor();

        JMenuBar menuBar = new JMenuBar();
        JMenu menuFile = new JMenu("File");
        JMenuItem newFile = new JMenuItem("New");
        JMenuItem openFile = new JMenuItem("Open");
        JMenuItem saveFile = new JMenuItem("Save");
        menuFile.add(newFile);
        menuFile.add(openFile);
        menuFile.add(saveFile);
        menuBar.add(menuFile);
        frame.setJMenuBar(menuBar);

        frame.setSize(600, 800);
        frame.setContentPane(editor.panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private JPanel panel;
    private JTextArea textArea;
}
