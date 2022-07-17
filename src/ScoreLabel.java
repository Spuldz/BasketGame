import javax.swing.*;
import java.awt.*;

public class ScoreLabel extends JLabel {
    //constructor
    String text;
    ScoreLabel(String text){
        this.text = text;

        this.setSize(150, 40);
        this.setFont(new Font(null, Font.BOLD, 30));
        this.setForeground(Color.WHITE);
        this.setText(this.text);
        this.setHorizontalAlignment(JLabel.CENTER);
    }

    void update(int score){
        this.setText(score + "");

    }



}
