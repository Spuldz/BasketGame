public class Orange extends Fruit{
    Orange orange;
    Orange(String imgPath, String type) {
        super(imgPath, type);

    }

    void spawn(Display display){
        int randomTime = rand.nextInt(600, 1600);
        display.orangeSpawnTimer.setDelay(randomTime);
        orange = new Orange("Assets\\orange.png", "orange");
        fruits.add(orange);
        random = orange.rand.nextInt(0, 1000 - orange.getWidth());
        orange.setBounds(random, 0 - this.getHeight(), 55, 55);
        display.add(orange);
    }
}
