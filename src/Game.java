import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;

public class Game {
    private ArrayList<Enemy> game = new ArrayList<>();
    private Player p = new Player(10, "Laura");

    public Game() {

    }

    public ArrayList<Enemy> getGame() {
        return game;
    }

    public void setGame(ArrayList<Enemy> game) {
        this.game = game;
    }

    public Player getP() {
        return p;
    }

    public void setP(Player p) {
        this.p = p;
    }

    public ArrayList<Enemy> createHouse() {

        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            int random = r.nextInt(10) + 1;
            game.add(new Enemy(random));
        }
        return game;

    }

    public String mainLoop()  {
        createHouse();
        int cycle = 0;
        for (int i = 0; i < game.size(); i++) {
            System.out.println(roomReturn(cycle));
            System.out.println(fight(cycle));
            cycle++;
        }
        return "bye";
    }

    public String roomReturn(int cycle) {
        return "You are in a room " + cycle + " " + "enemy there has: " + game.get(cycle).health + " " + "health";
    }

    public String luckykM() {
        return "Lucky you, you always strike first";
    }

    public String fight(int a) {

        luckykM();
        while (game.get(a).health > 0 || p.health > 0) {
            game.get(a).health--;
            p.health--;
            System.out.println("your health is: " + p.getHealth());

        }
        if (p.getHealth() == 0) {
            return "oh no, you lost";
        } else {
            p.setHealth(p.health + 5);
            return "congratulations, you defeated the enemy and gained plus 5 health";
        }
    }


    @Override
    public String toString() {
        return "Game{" +
                "game=" + game +
                ", p=" + p +
                '}';
    }
}
