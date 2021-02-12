import javax.swing.*;

public class Editor {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Editor");
        Editor editor = new Editor();

        JMenuBar menubar = new JMenuBar();
        JMenu menu1 = new JMenu("File");
        JMenuItem newFile = new JMenuItem("New");
        menu1.add(newFile);
        menubar.add(menu1);
        frame.add(menubar);

        frame.setSize(600, 800);
        frame.setContentPane(editor.panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private JPanel panel;
    private JTextArea textArea;
}
