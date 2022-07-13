import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Basket extends JLabel {
    String basket = "Assets\\basket.png";
    ImageIcon basketIcon;
    String direction;
    //constructor
    Basket(){
        basketIcon = new ImageIcon(basket);
        direction = "left";

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





}
