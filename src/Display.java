import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Display extends JLabel {
    //constructor
    Basket basket;
    Apple apple;
    Display(){
        this.setSize(1000, 700);
        this.setBackground(new Color(52, 162, 235));
        this.setOpaque(true);

        basket = new Basket();


        apple = new Apple("Assets\\apple.png");
        spawnTimer.start();


        this.add(basket);
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


    Timer spawnTimer = new Timer(2000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            apple.spawn(getDisplay());
        }
    });



}
