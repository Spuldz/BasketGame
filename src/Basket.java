import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Basket extends JLabel {
    String basket = "Assets\\basket.png";
    ImageIcon basketIcon;
    Random rand;
    String direction;
    Apple apple;
    ScoreLabel scoreLabel;
    int score;
    int random;
    //constructor
    Basket(){
        basketIcon = new ImageIcon(basket);
        direction = "left";

        score = 0;
        rand = new Random();
        random = rand.nextInt(1,3);


        this.setBounds(450, 500, 140, 110);
        this.setIcon(basketIcon);
    }



    void setDirection(String direction){
        if(direction == "left"){

            this.setLocation(this.getX() - 10, this.getY());
        }else if(direction == "right"){
            this.setLocation(this.getX() + 10, this.getY());
        }
    }

    void checkForBasketFruitCollision(Fruit fruit, Display display){


        for(Fruit f : fruit.fruits){
            if(f.getBounds().intersects(this.getBounds())){
                display.remove(f);
                fruit.fallenFruit.add(f);


                if(random == 1 && f.type == "orange"){
                        score++;
                        display.scoreLabel.update(score);
                        return;
                }else if(random == 1 && f.type != "orange"){
                    score--;
                    display.scoreLabel.update(score);
                    return;
                }

            if(random == 2 && f.type == "apple"){
                    score++;
                    display.scoreLabel.update(score);
                    return;

            }else if(random == 2 && f.type != "apple"){
                score--;
                display.scoreLabel.update(score);
                return;
            }
        }


    }
        if(score <= 0){
            score = 0;
            display.scoreLabel.update(score);
        }
}

    void setTaskLabelIcon(Display display){
        random = rand.nextInt(1, 3);
        if(random == 2){
            display.taskLabel.setIcon(new ImageIcon("Assets\\appleIcon.png"));
        }else if(random == 1){
            display.taskLabel.setIcon(new ImageIcon("Assets\\orangeIcon.png"));
        }
    }

}
