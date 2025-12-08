import java.awt.*;

public class Functionality {

    GUI gui;
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

        }
    }
}
