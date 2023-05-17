import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {
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

    public void script(){
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

    public String mainLoop()  {
        script();
        createHouse();
        int cycle = 0;
        for (int i = 0; i < game.size(); i++) {
            System.out.println(roomReturn(cycle));
            choice(cycle);
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

    public void choice(int a){
        Scanner sc = new Scanner(System.in);
        System.out.println(choiceQ());

        switch (sc.nextInt()){
            case 1:
                System.out.println(fight(a));
            break;
            case 2:
        }

    }

    public String choiceQ(){
        return "Choose your option: \n " +
                "1) Fight  \n" +
                "2) Skip \n" +
                "3) Heal";
    }


    @Override
    public String toString() {
        return "Game{" +
                "game=" + game +
                ", p=" + p +
                '}';
    }
}
