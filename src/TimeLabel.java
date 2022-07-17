import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimeLabel extends JLabel {
    //constructor
    int seconds = 59;
    TimeLabel(){
        this.setSize(120, 40);
        this.setText(seconds + 1 + "");
        this.setFont(new Font(null, Font.BOLD, 35));
        this.setForeground(Color.WHITE);
        this.setHorizontalAlignment(JLabel.CENTER);
    }

    private TimeLabel timeLabel(){
        return this;
    }


    Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
             timeLabel().setText(seconds + "");
             seconds--;

             if(seconds < 0){
                 timer.stop();
             }
        }
    });
}
