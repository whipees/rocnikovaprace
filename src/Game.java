import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private Messages m = new Messages();
    private ArrayList<Enemy> game = new ArrayList<>();
    private Player p = new Player(10, "Laura");
    private int skipChoice;

    private int healercheck;
    private int arraylist;

    public Game() {

    }

    public Messages getM() {
        return m;
    }

    public void setM(Messages m) {
        this.m = m;
    }

    public int getArraylist() {
        return arraylist;
    }

    public void setArraylist(int arraylist) {
        this.arraylist = arraylist;
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

    public int getSkipChoice() {
        return skipChoice;
    }

    public void setSkipChoice(int skipChoice) {
        this.skipChoice = skipChoice;
    }

    public int getHealercheck() {
        return healercheck;
    }

    public void setHealercheck(int healercheck) {
        this.healercheck = healercheck;
    }

    public void createHouse() {

        Random r = new Random();
        for (int i = 0; i < 15; i++) {
            int random = r.nextInt(8) + 1;
            game.add(new Enemy(random));
        }


    }

    public void script() {
        try {
            File script = new File("untitled/script.txt");
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
        game = new ArrayList<>();
        p.setHealth(10);
        setHealercheck(3);
        setSkipChoice(2);
        createHouse();

        for (int i = 0; i < 15; i++) {
            System.out.println(roomReturn(i));
            choice(i);

        }
        return "You won, congratulations";
    }

    public String roomReturn(int cycle) {
        return "You are in a room " + cycle + " " + "enemy there has: " + game.get(cycle).health + " " + "health";
    }

    public String fight(int a) {
        boolean checker = true;
        System.out.println(m.luckykM());
        while (checker) {
            game.get(a).health--;
            if (game.get(a).health < 1) {
                checker = false;
            } else {
                p.health--;
                System.out.println("your health is: " + p.getHealth());

                if (p.health < 1) {
                    checker = false;
                }
            }
        }
        if (p.getHealth() == 0) {
            mainLoop();
            return null;
        } else {
            if (p.health < 4) {
                p.setHealth(p.health + 5);
                return "congratulations, you defeated the enemy and gained plus 5 health... you now have: " + p.health;
            }

            return "congratulations, you defeated the enemy... you now have: " + p.health;
        }
    }

    public String skip() {
        skipChoice--;
        if (skipChoice >= 0) {
            return "Successfully skipped one room! ";
        } else {
            return "You are out of skips!";
        }
    }

    public String heal() {
        if (healercheck > 0) {
            healercheck--;
            p.setHealth(p.health + 4);
            return "Successfully healed";
        } else {
            return "You cannot heal anymore";
        }
    }

    public void choice(int a) {
        Scanner sc = new Scanner(System.in);
        Shop s = new Shop();
        boolean check = true;
        while (check) {
            System.out.println(m.choiceQ());
            System.out.println("Num of healers: "+ healercheck + " Num of Skippers: "+ skipChoice);
            try {
                switch (sc.nextInt()) {
                    default -> throw new RuntimeException();
                    case 1 -> {
                        System.out.println(fight(a));
                        check = false;
                    }
                    case 2 -> {
                        System.out.println(skip());
                        if (skipChoice >= 0) {
                            check = false;
                        }
                    }
                    case 3 -> System.out.println(heal());
                    case 4 -> s.openShop();

                }
            } catch (RuntimeException r) {
                System.out.println("try again");
                sc.nextLine();
            }
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
