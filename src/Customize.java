import java.awt.*;

public class Customize {

    GUI gui;
    Font arial, comicSansMS, timesNewRoman;
    String selectedFont;

    public Customize(GUI gui){
        this.gui = gui;

    }

    public void wordWrap(){
        if(gui.wordWrapOn == false){
            gui.wordWrapOn = true;
            gui.textArea.setLineWrap(true);
            gui.textArea.setWrapStyleWord(true);
            gui.cusWrap.setText("Word Wrap: On");
        }else if(gui.wordWrapOn == true){
            gui.wordWrapOn = false;
            gui.textArea.setLineWrap(false);
            gui.textArea.setWrapStyleWord(false);
            gui.cusWrap.setText("Word Wrap: OFF");

        }
    }

    public void createFont(int fontSize){
        arial = new Font("Arial", Font.PLAIN, fontSize);
        comicSansMS = new Font("Comic Sans MS", Font.PLAIN, fontSize );
        timesNewRoman = new Font("Times New Roman", Font.PLAIN, fontSize);
        setFont(selectedFont);
    }

    public void setFont(String font){
        selectedFont = font;

        switch(selectedFont){
            case "Arial":
                gui.textArea.setFont(arial);
                break;

            case "Comic Sans MS":
                gui.textArea.setFont(comicSansMS);
                break;

            case "Times New Roman":
                gui.textArea.setFont(timesNewRoman);
                break;

        }
    }

    public void setColor(String color){
        switch(color){
            case "Black":
                gui.window.getContentPane().setBackground(Color.BLACK);
                gui.textArea.setBackground(Color.WHITE);
                gui.textArea.setForeground(Color.BLACK);
                break;

            case "White":
                gui.window.getContentPane().setBackground(Color.white);
                gui.textArea.setBackground(Color.black);
                gui.textArea.setForeground(Color.white);
                break;

            case "Blue":
                gui.window.getContentPane().setBackground(Color.BLUE);
                gui.textArea.setBackground(Color.WHITE);
                gui.textArea.setForeground(Color.BLUE);
                break;

            case "Hacker Green":
                gui.window.getContentPane().setBackground(Color.GREEN);
                gui.textArea.setBackground(Color.BLACK);
                gui.textArea.setForeground(Color.GREEN);

                break;
        }
    }

}
