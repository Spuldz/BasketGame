import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Apple extends Fruit {
        Apple apple;
    Apple(String imgPath) {
        super(imgPath);
    }




    void spawn(Display display){
        apple = new Apple("Assets\\apple.png");
        fruits.add(apple);
        random = apple.rand.nextInt(0, 1000 - apple.getWidth());
        apple.setBounds(random, 0, 55, 55);
        display.add(apple);

    }





}
