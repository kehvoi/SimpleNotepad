import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class Functionality {

    GUI gui;
    String fileName;
    String fileAddress;


    public Functionality(GUI gui){

        this.gui = gui;

    }

    public void newFile(){
        gui.textArea.setText("");
        gui.window.setTitle("New");
    }

    public void open(){
        FileDialog fileDia = new FileDialog(gui.window, "Open", FileDialog.LOAD);
        fileDia.setVisible(true);

        if(fileDia.getFile() !=null){
            fileName = fileDia.getFile();
            fileAddress = fileDia.getDirectory();
            gui.window.setTitle(fileName);

        }

        try {
            BufferedReader bRead = new BufferedReader(new FileReader(fileAddress + fileName));
            gui.textArea.setText("");
            String line = null;
            while((line = bRead.readLine())!=null){
                gui.textArea.append(line + "\n");
            }
            bRead.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "File not opened", "Open Error!", JOptionPane.ERROR_MESSAGE);
        }
    }
}
