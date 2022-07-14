import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Fruit extends JLabel {
    String imgPath;
    String type;
    Random rand = new Random();
    int random = 0;
    ArrayList<Fruit> fruits;
    ArrayList<Fruit> fallenFruit;
    Iterator<Fruit> iter;
    int fruitsSpawned = 0;
    //constructor
    Fruit(String imgPath, String type){
        this.imgPath = imgPath;
        this.type = type;
        fruits = new ArrayList<Fruit>();
        fallenFruit = new ArrayList<Fruit>();

        random = rand.nextInt(0, 1000 - this.getWidth());
        this.setBounds(random, 0, 55, 55);


        ImageIcon icon = new ImageIcon(this.imgPath);
        this.setIcon(icon);

    }

    void Fall(){

          this.setLocation(this.getX(), this.getY() + 10);

    }

    void CheckForFallenFruit(Display display){

       for(Fruit f : fruits){
           if(f.getY() > 700){
               display.remove(f);
               fallenFruit.add(f);
           }

       }

        display.repaint();

        for(int i = 0; i< fallenFruit.size(); i++){
            if(fruits.get(i) == fallenFruit.get(i) && fruits.size() >= 1 && fallenFruit.size() >= 1){
                fallenFruit.remove(i);
                fruits.remove(i);
            }
        }

    }



}
