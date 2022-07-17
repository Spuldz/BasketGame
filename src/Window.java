import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Window extends JFrame implements KeyListener{
    //constructor
    Basket basket;
    Display display;
    GameOverScreen gameOverScreen;
    JButton restartButton;

    Window(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1016, 739);
        this.setResizable(false);
        this.setLayout(null);
        this.addKeyListener(this);

        display = new Display();
        gameOverScreen = new GameOverScreen();

        this.add(display);


        this.setVisible(true);
        LaunchWaitTimer.start();
        restartButton = gameOverScreen.getRestartButton();

        restartButton.addActionListener(e1 -> {
            restart();
        });


    }

    private Window window(){
        return this;
    }
     Timer gameloop = new Timer(10, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            display.checkForCollision();
            display.apple.CheckForFallenFruit(display);
            display.orange.CheckForFallenFruit(display);
            display.pineapple.CheckForFallenFruit(display);
            display.basket.setDirection(display.basket.direction);
            display.basket.checkForBasketFruitCollision(display.apple, display);
            display.basket.checkForBasketFruitCollision(display.orange, display);
            display.basket.checkForBasketFruitCollision(display.pineapple, display);


            for(Fruit o : display.orange.fruits){
                o.Fall();
            }

            for(Fruit a : display.apple.fruits){
                a.Fall();
            }

            for(Fruit p : display.pineapple.fruits){
                p.Fall();
            }

            if(display.timeLabel.seconds <  0){
                gameloop.stop();
                gameOverScreen.setBounds((display.getWidth() - gameOverScreen.getWidth())/2,(display.getHeight() - gameOverScreen.getHeight())/2, gameOverScreen.getWidth(), gameOverScreen.getHeight());
                display.add(gameOverScreen);
                gameOverScreen.scoreLabel.setText(display.basket.score + "");
                display.setComponentZOrder(gameOverScreen, 0);
            }
        }
    });



     Timer LaunchWaitTimer = new Timer(5000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            LaunchWaitTimer.stop();
            display.ApplespawnTimer.start();
            display.orangeSpawnTimer.start();
            display.pineappleSpawnTimer.start();
            gameloop.start();
            display.remove(display.launchLabel);
            display.timeLabel.timer.start();
        }
    });



    public void restart() {
        display.remove(gameOverScreen);



        for(Fruit f : display.apple.fruits){
            display.remove(f);
        }

        for(Fruit f : display.orange.fruits){
            display.remove(f);
        }

        for(Fruit p : display.pineapple.fruits){
            display.remove(p);
        }



        display.ApplespawnTimer.stop();
        display.orangeSpawnTimer.stop();
        display.pineappleSpawnTimer.stop();
        display.launchLabel.timer.start();
        LaunchWaitTimer.start();
        display.timeLabel.seconds = 59;
        display.basket.score = 0;
        display.scoreLabel.setText("0");
        display.timeLabel.setText("60");
        display.taskLabel.setTask(display);
        display.launchLabel.seconds = 4;
        display.launchLabel.setText("5");
        display.add(display.launchLabel);
        display.apple.fruits.clear();
        display.orange.fruits.clear();
        display.pineapple.fruits.clear();
        display.getTopLevelAncestor().requestFocus();

        display.repaint();

    }















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
