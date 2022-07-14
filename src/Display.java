import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Display extends JLabel{
    //constructor
    Basket basket;
    Apple apple;
    Orange orange;
    TaskLabel taskLabel;
    ScoreLabel scoreLabel;
    LaunchTimerLabel launchLabel;
    TimeLabel timeLabel;


    Display(){
        this.setSize(1000, 700);
        this.setBackground(new Color(52, 162, 235));
        this.setOpaque(true);

        taskLabel = new TaskLabel(null);
        basket = new Basket();
        scoreLabel = new ScoreLabel(this.basket.score + "");
        scoreLabel.setBounds((this.getWidth() - scoreLabel.getWidth()) / 2, 0, scoreLabel.getWidth(), scoreLabel.getHeight());
        this.basket.setTaskLabelIcon(this);

        launchLabel = new LaunchTimerLabel();
        launchLabel.setBounds((this.getWidth() - launchLabel.getWidth()) / 2, (this.getHeight() - launchLabel.getHeight())/2, launchLabel.getWidth(), launchLabel.getHeight());

        timeLabel = new TimeLabel();
        timeLabel.setBounds(this.getWidth() - timeLabel.getWidth(), 0, timeLabel.getWidth(), timeLabel.getHeight());



        apple = new Apple("Assets\\apple.png", "apple");
        orange = new Orange("Assets\\pineapple.png", "orange");
        //LaunchWaitTimer.start();

        this.add(basket);
        this.add(scoreLabel);
        this.add(taskLabel);
        this.add(launchLabel);
        this.add(timeLabel);
    }





    public void checkForCollision(){
        //System.out.println();
        if(basket.getX() > this.getWidth() - basket.getWidth()){
            basket.setLocation(this.getWidth() - basket.getWidth(), basket.getY());
            basket.direction = "left";

        }else if(basket.getX() < 0){
            basket.setLocation(0, basket.getY());
            basket.direction = "right";
        }
    }

    private Display getDisplay(){
        return this;
    }


    Timer ApplespawnTimer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            apple.spawn(getDisplay());
        }
    });

    Timer orangeSpawnTimer = new Timer(1500, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            orange.spawn(getDisplay());
        }
    });




}
