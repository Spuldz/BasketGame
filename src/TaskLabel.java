import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class TaskLabel extends JLabel {
    //constructor
    String imgPath;
    Icon icon;
    int random;
    Random rand;
    TaskLabel(String imgPath){
        this.imgPath = imgPath;
        icon = new ImageIcon(this.imgPath);
        this.setSize(200, 38);
        this.setBounds(0, 0, 200, 38);
        this.setText("Needed fruit: ");
        this.setFont(new Font(null, Font.BOLD, 15));
        this.setForeground(Color.WHITE);
        this.setIcon(icon);
        this.setHorizontalTextPosition(JLabel.LEFT);

        rand = new Random();
    }

    void setTask(Display display){
        random = rand.nextInt(1, 4);
        if(random == 2){
            display.taskLabel.setIcon(new ImageIcon("Assets\\appleIcon.png"));
        }else if(random == 1){
            display.taskLabel.setIcon(new ImageIcon("Assets\\orangeIcon.png"));
        }else if(random == 3){
            display.taskLabel.setIcon(new ImageIcon("Assets\\pineappleIcon.png"));
        }
    }
}
