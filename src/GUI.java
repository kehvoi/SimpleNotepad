import javax.swing.*;
import javax.swing.JTextArea;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {
    JFrame window;
    JTextArea textArea;
    JScrollPane scrollPane;
    JMenuBar menuBar;
    JMenu menuFile, menuEdit, menuCustomize;
    JMenuItem fileNew, fileOpen, fileSave, fileSaveAs, fileExit;

    Functionality file = new Functionality(this);

    public GUI(){
        createWindow();
        createTextArea();
        createMenuBar();
        createFileMenu();
        createFileOpen();
        createFileSave();
        createFileSaveAs();
        createFileExit();

        window.setVisible(true);
    }

    public void createWindow(){
        window = new JFrame("Notepad");
        window.setSize(800,600);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);

    }

    public void createTextArea(){
        textArea = new JTextArea();
        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        window.add(scrollPane);
    }

    public void createMenuBar(){
        menuBar = new JMenuBar();
        window.setJMenuBar(menuBar);

        menuFile = new JMenu("File");
        menuBar.add(menuFile);

        menuEdit = new JMenu("Edit");
        menuBar.add(menuEdit);

        menuCustomize = new JMenu("Customize");
        menuBar.add(menuCustomize);
    }

    public void createFileMenu(){
        fileNew = new JMenuItem("New");
        fileNew.addActionListener(this);
        fileNew.setActionCommand("New");
        menuFile.add(fileNew);
    }

    public void createFileOpen(){
        fileOpen = new JMenuItem("Open");
        fileOpen.addActionListener(this);
        fileOpen.setActionCommand("Open");
        menuFile.add(fileOpen);
    }

    public void createFileSave(){
        fileSave = new JMenuItem("Save");
        fileSave.addActionListener(this);
        fileSave.setActionCommand("Save");
        menuFile.add(fileSave);
    }

    public void createFileSaveAs(){
        fileSaveAs = new JMenuItem("Save As");
        fileSaveAs.addActionListener(this);
        fileSaveAs.setActionCommand("Save As");
        menuFile.add(fileSaveAs);
    }

    public void createFileExit(){
        fileExit = new JMenuItem("Exit");
        fileExit.addActionListener(this);
        fileExit.setActionCommand("Exit");
        menuFile.add(fileExit);
    }







    public static void main(String[] args){
        new GUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch(command){
            case "New":file.newFile();
            break;

            case "Open":file.open();
            break;

            case "Save":file.save();
            break;

            case "Save As":file.saveAs();
            break;
        }

    }
}
