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

    JMenuItem cusWrap, cusFontArial, cusFontCSMS, cusFontTNR, cusFontSize8, cusFontSize12, cusFontSize16, cusFontSize20, cusFontSize24, cusFontSize28, cusColor1, cusColor2, cusColor3, cusColor4;
    JMenu menuFont, menuFontSize, menuColor;



    boolean wordWrapOn = false;


    Functionality file = new Functionality(this);
    Customize custom = new Customize(this);

    public GUI(){
        createWindow();
        createTextArea();
        createMenuBar();
        createFileMenu();
        createFileOpen();
        createFileSave();
        createFileSaveAs();
        createFileExit();
        createCustomizeMenu();
        custom.selectedFont = "Arial";
        custom.createFont(16);
        custom.wordWrap();
        custom.setColor("Black");

        window.setVisible(true);
    }

    public void createWindow(){
        window = new JFrame("Funpad");
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

    public void createCustomizeMenu(){
        cusWrap = new JMenuItem("Word Wrap: OFF");
        cusWrap.addActionListener(this);
        cusWrap.setActionCommand("Word Wrap");
        menuCustomize.add(cusWrap);

        menuColor = new JMenu("Color");
        menuCustomize.add(menuColor);

        menuFont = new JMenu("Font");
        menuCustomize.add(menuFont);

        menuFontSize = new JMenu("Font Size");
        menuCustomize.add(menuFontSize);

        cusFontArial = new JMenuItem("Arial");
        cusFontArial.addActionListener(this);
        cusFontArial.setActionCommand("Arial");
        menuFont.add(cusFontArial);

        cusFontCSMS = new JMenuItem("Comic Sans MS");
        cusFontCSMS.addActionListener(this);
        cusFontCSMS.setActionCommand("Comic Sans MS");
        menuFont.add(cusFontCSMS);

        cusFontTNR = new JMenuItem("Times New Roman");
        cusFontTNR.addActionListener(this);
        cusFontTNR.setActionCommand("Times New Roman");
        menuFont.add(cusFontTNR);

        cusFontSize8 = new JMenuItem("8");
        cusFontSize8.addActionListener(this);
        cusFontSize8.setActionCommand("size 8");
        menuFontSize.add(cusFontSize8);

        cusFontSize12 = new JMenuItem("12");
        cusFontSize12.addActionListener(this);
        cusFontSize12.setActionCommand("size 12");
        menuFontSize.add(cusFontSize12);

        cusFontSize16 = new JMenuItem("16");
        cusFontSize16.addActionListener(this);
        cusFontSize16.setActionCommand("size 16");
        menuFontSize.add(cusFontSize16);

        cusFontSize20 = new JMenuItem("20");
        cusFontSize20.addActionListener(this);
        cusFontSize20.setActionCommand("size 20");
        menuFontSize.add(cusFontSize20);

        cusFontSize24 = new JMenuItem("24");
        cusFontSize24.addActionListener(this);
        cusFontSize24.setActionCommand("size 24");
        menuFontSize.add(cusFontSize24);

        cusFontSize28 = new JMenuItem("28");
        cusFontSize28.addActionListener(this);
        cusFontSize28.setActionCommand("size 28");
        menuFontSize.add(cusFontSize28);

        cusColor1 = new JMenuItem("Black");
        cusColor1.addActionListener(this);
        cusColor1.setActionCommand("Black");
        menuColor.add(cusColor1);

        cusColor2 = new JMenuItem("White");
        cusColor2.addActionListener(this);
        cusColor2.setActionCommand("White");
        menuColor.add(cusColor2);

        cusColor3 = new JMenuItem("Blue");
        cusColor3.addActionListener(this);
        cusColor3.setActionCommand("Blue");
        menuColor.add(cusColor3);

        cusColor4 = new JMenuItem("Hacker Green");
        cusColor4.addActionListener(this);
        cusColor4.setActionCommand("Hacker Green");
        menuColor.add(cusColor4);


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

            case "Exit":file.exit();
            break;

            case "Word Wrap": custom.wordWrap();
            break;

            case "size 8": custom.createFont(8);
            break;

            case "size 12": custom.createFont(12);
            break;

            case "size 16": custom.createFont(16);
                break;

            case "size 20": custom.createFont(20);
                break;

            case "size 24": custom.createFont(24);
                break;

            case "size 28": custom.createFont(28);
                break;

            case "Arial":custom.setFont(command);
            break;

            case "Comic Sans MS":custom.setFont(command);
            break;

            case "Times New Roman":custom.setFont(command);
            break;

            case "Black":custom.setColor(command);
            break;

            case "White":custom.setColor(command);
            break;

            case "Blue":custom.setColor(command);
            break;

            case "Hacker Green":custom.setColor(command);
            break;
        }

    }
}
