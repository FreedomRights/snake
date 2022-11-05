
public class SnakeGame {
    public static void main(String[] args){
        sound mu = new sound();
        Thread thread =new Thread(mu);
        thread.start();
        System.out.println("Welcome!");
        new GameFrame();
    }
}
