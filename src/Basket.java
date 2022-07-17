import javax.swing.*;
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


               setScore(display, 1, "apple", f);
               setScore(display, 2, "orange", f);
               setScore(display, 3, "pineapple", f);

            }


    }
        if(score <= 0){
            score = 0;
            display.scoreLabel.update(score);
        }
}

void setScore(Display display,int random ,String fruit, Fruit f){
    if(display.taskLabel.random == random && f.type == fruit){
        score++;
        display.scoreLabel.update(score);
        return;
    }else if(display.taskLabel.random == random && f.type != fruit){
        score--;
        display.scoreLabel.update(score);
        return;
    }
}



}
