public class Pineapple extends Fruit{
    Pineapple pineapple;
    Pineapple(String imgPath, String type) {
        super(imgPath, type);

    }

    void spawn(Display display){
        int randomTime = rand.nextInt(600, 1600);
        display.ApplespawnTimer.setDelay(randomTime);
        pineapple = new Pineapple("Assets\\pineapple.png", "pineapple");
        fruits.add(pineapple);
        random = pineapple.rand.nextInt(0, 1000 - pineapple.getWidth());
        pineapple.setBounds(random, 0 - this.getHeight(), 55, 100);
        display.add(pineapple);
    }
}
