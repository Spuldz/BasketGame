import javax.swing.*;
import java.awt.*;

public class GameOverScreen extends JLabel {
    //constructor
    JButton restartButton;
    JLabel scoreLabel;
    Display display = new Display();
    GameOverScreen(){
        this.setSize(500, 400);
        this.setBackground(Color.RED);
        this.setOpaque(true);
        this.setLayout(null);


        JLabel text = new JLabel("Game Over!");
        text.setSize(200, 40);
        text.setBounds((this.getWidth() - text.getWidth())/2, 10, text.getWidth(), text.getHeight());
        text.setBackground(Color.YELLOW);
        text.setHorizontalAlignment(JLabel.CENTER);
        text.setOpaque(true);

        scoreLabel = new JLabel();
        scoreLabel.setSize(200, 150);
        scoreLabel.setBounds((this.getWidth() - scoreLabel.getWidth()) /2, (this.getHeight() - scoreLabel.getHeight()) / 2, scoreLabel.getWidth(), scoreLabel.getHeight());
        scoreLabel.setBackground(Color.GRAY);
        scoreLabel.setOpaque(true);
        scoreLabel.setHorizontalAlignment(JLabel.CENTER);
        scoreLabel.setFont(new Font(null, Font.BOLD, 100));
        scoreLabel.setForeground(Color.WHITE);

        restartButton = new JButton("Play Again");
        restartButton.setSize(100, 40);
        restartButton.setBounds((this.getWidth() - restartButton.getWidth()) /2, this.getHeight() - restartButton.getHeight() - 20, restartButton.getWidth(), restartButton.getHeight());
        restartButton.setBackground(Color.BLUE);




        this.add(text);
        this.add(scoreLabel);
        this.add(restartButton);




    }

    public JButton getRestartButton(){
        return restartButton;
    }



}
