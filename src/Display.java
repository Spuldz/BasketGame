import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Display extends JLabel {
    //constructor
    Basket basket;
    Apple apple;
    Orange orange;
    Random rand;
    TaskLabel taskLabel;
    int randomTime;
    ScoreLabel scoreLabel;
    String img = "";

    Display(){
        this.setSize(1000, 700);
        this.setBackground(new Color(52, 162, 235));
        this.setOpaque(true);

        taskLabel = new TaskLabel(img);
        basket = new Basket();
        rand = new Random();
        randomTime = rand.nextInt(1000, 2300);
        scoreLabel = new ScoreLabel(this.basket.score + "");
        scoreLabel.setBounds((this.getWidth() - scoreLabel.getWidth()) / 2, 0, scoreLabel.getWidth(), scoreLabel.getHeight());
        this.basket.setTaskLabelIcon(this);


        apple = new Apple("Assets\\apple.png");
        orange = new Orange("Assets\\pineapple.png");
        ApplespawnTimer.start();
        pineappleSpawnTimer.start();


        this.add(basket);
        this.add(scoreLabel);
        this.add(taskLabel);
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


    Timer ApplespawnTimer = new Timer(2000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            apple.spawn(getDisplay());
        }
    });

    Timer pineappleSpawnTimer = new Timer(1500, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            orange.spawn(getDisplay());
        }
    });





}
