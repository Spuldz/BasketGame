import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Window extends JFrame implements KeyListener {
    //constructor
    Basket basket;
    Display display;

    Window(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1016, 739);
        this.setResizable(false);
        this.setLayout(null);

        display = new Display();

        this.add(display);
        gameloop.start();
        this.addKeyListener(this);

        this.setVisible(true);




    }
    Timer gameloop = new Timer(10, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            display.checkForCollision();
            display.apple.CheckForFallenFruit(display);
            display.orange.CheckForFallenFruit(display);
            display.basket.setDirection(display.basket.direction);
            display.basket.checkForBasketFruitCollision(display.apple, display);
            display.basket.checkForBasketFruitCollision(display.orange, display);

            for(Fruit o : display.orange.fruits){
                o.Fall();
            }

            for(Fruit a : display.apple.fruits){
                a.Fall();
            }
        }
    });





    @Override
    public void keyTyped(KeyEvent e) {

    }
    @Override
    public void keyPressed(KeyEvent e) {

        switch(e.getKeyCode()){
            case 65:
                display.basket.direction = "left";
                break;
            case 68:
                display.basket.direction = "right";
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }




}
