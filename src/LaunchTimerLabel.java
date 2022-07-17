import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LaunchTimerLabel extends JLabel {
    //constructor
    int seconds = 4;
    LaunchTimerLabel(){
        this.setSize(100, 100);
        this.setText(seconds + 1 + "");
        this.setFont(new Font(null, Font.BOLD, 100));
        this.setForeground(Color.WHITE);
        this.setHorizontalAlignment(JLabel.CENTER);

        timer.start();
    }

    private LaunchTimerLabel getLabel(){
        return this;
    }


    Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            getLabel().setText(seconds + "");
            seconds--;

            if(seconds == 0){
                timer.stop();
            }
        }
    });
}
