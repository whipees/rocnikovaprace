import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private Messages m = new Messages();
    private ArrayList<Enemy> game = new ArrayList<>();
    private Player p = new Player(10, "Laura");
    private int skipChoice = 2;

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
        for (int i = 0; i < 15; i++) {
            int random = r.nextInt(8) + 1;
            game.add(new Enemy(random));
        }
        return game;

    }
    public void script() {
        try {
            File script = new File("script.txt");
            Scanner sc = new Scanner(script);
            while (sc.hasNextLine()) {
                String data = sc.nextLine();
                System.out.println(data);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
    public String mainLoop() {
        script();
        createHouse();
        int cycle = 0;
        for (int i = 0; i < game.size(); i++) {
            System.out.println(roomReturn(cycle));
            choice(cycle);
            System.out.println(healthcheck());
            cycle++;
        }
        return "bye";
    }

    public String roomReturn(int cycle) {
        return "You are in a room " + cycle + " " + "enemy there has: " + game.get(cycle).health + " " + "health";
    }
    public String fight(int a) {
        boolean checker = true;

        System.out.println(m.luckykM());
        while (checker) {
            game.get(a).health--;
            p.health--;
            System.out.println("your health is: " + p.getHealth());
            if (game.get(a).health < 1) {
                checker = false;
            }
            if (p.health < 1) {
                checker = false;
            }
        }
        if (p.getHealth() == 0) {
            return "oh no, you lost";
        } else {
            if (p.health < 4) {
                p.setHealth(p.health + 5);
                return "congratulations, you defeated the enemy and gained plus 5 health... you now have: " + p.health;
            }

            return "congratulations, you defeated the enemy... you now have: " + p.health;
        }
    }

    public void choice(int a) {
        Scanner sc = new Scanner(System.in);
        System.out.println(m.choiceQ());

        switch (sc.nextInt()) {
            case 1:
                System.out.println(fight(a));
                break;
            case 2:
        }

    }

    public String healthcheck() {
        if (p.health <= 0) {
            System.exit(69);
            return null;
        } else return "You are ready to win, be careful";
    }

    @Override
    public String toString() {
        return "Game{" +
                "game=" + game +
                ", p=" + p +
                '}';
    }
}
