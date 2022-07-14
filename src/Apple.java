import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Apple extends Fruit {
        static Apple apple;
    Apple(String imgPath, String type) {
        super(imgPath, type);
    }




    void spawn(Display display){
       int randomTime = rand.nextInt(600, 1600);
        display.ApplespawnTimer.setDelay(randomTime);
        apple = new Apple("Assets\\apple.png", "apple");
        fruits.add(apple);
        random = apple.rand.nextInt(0, 1000 - apple.getWidth());
        apple.setBounds(random, 0 - this.getHeight(), 55, 55);
        display.add(apple);

    }

    public static Apple getApple(){
        return apple;
    }





}
