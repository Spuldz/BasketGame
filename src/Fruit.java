import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Fruit extends JLabel {
    String imgPath;
    Random rand = new Random();
    int random = 0;
    ArrayList<Fruit> fruits;
    ArrayList<Fruit> fallenFruit;
    Iterator<Fruit> iter;
    int fruitsSpawned = 0;
    //constructor
    Fruit(String imgPath){
        this.imgPath = imgPath;
        fruits = new ArrayList<Fruit>();
        fallenFruit = new ArrayList<Fruit>();
       // fruitTimer.start();


        random = rand.nextInt(0, 1000 - this.getWidth());
        this.setBounds(random, 0, 55, 55);


        ImageIcon icon = new ImageIcon(this.imgPath);
        this.setIcon(icon);

    }

    void Fall(){

          this.setLocation(this.getX(), this.getY() + 15);

    }

    void CheckForFallenFruit(Display display){

       for(Fruit f : fruits){
           if(f.getY() > 600){
               display.remove(f);
               fallenFruit.add(f);

           }

       }

        display.repaint();

        for(int i = 0; i< fallenFruit.size(); i++){
            if(fruits.get(i) == fallenFruit.get(i)){
                fallenFruit.remove(i);
                fruits.remove(i);
            }
        }

    }

    private Fruit getApple(){
        return this;
    }


    Timer fruitTimer = new Timer(10, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
              for(Fruit f : fruits){
                 // f.Fall();
              }
        }
    });


}
