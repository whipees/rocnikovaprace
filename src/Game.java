import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {
    /**
     * Creates Object of messages
     */
    private Messages m = new Messages();
    /**
     * whole game is based on this arraylist
     */
    private ArrayList<Enemy> game = new ArrayList<>();
    /**
     * Player
     */
    private Player p = new Player(10, "Laura");
    /**
     * This int checks if player can still skip a room
     */
    private int skipChoice;
    /**
     * This int checks if player can still heal
     */
    private int healercheck;

    public Game() {
        this.healercheck = 3;
        this.skipChoice = 2;
    }

    public Messages getM() {
        return m;
    }

    public void setM(Messages m) {
        this.m = m;
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

    /**
     * This method creates the whole game
     * puts enemies into their room
     * adds enemy health with random from 1 to 8
     */
    public void createHouse() {

        Random r = new Random();
        for (int i = 0; i < 15; i++) {
            int random = r.nextInt(8) + 1;
            game.add(new Enemy(random));
        }


    }

    /**
     * This writes the starting text for the game script.txt
     */

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

    /**
     * This is the main loop, whole game is here
     * for cycle for printing rooms and method choice for them
     * @return Congrats if you complete every room
     */
    public String mainLoop() {
        script();
        game = new ArrayList<>();
        p.setHealth(10);
        createHouse();

        for (int i = 0; i < 15; i++) {
            System.out.println(roomReturn(i));
            choice(i);

        }
        return "You won, congratulations";
    }

    /**
     * Switch for players choice (fight, skip, heal, shop)
     * @param a used for player to fight the right enemy
     */
    public void choice(int a) {
        Scanner sc = new Scanner(System.in);
        Shop s = new Shop();
        boolean check = true;
        while (check) {
            System.out.println(m.choiceQ());
            System.out.println("Num of healers: "+ getHealercheck() + " Num of Skippers: "+ skipChoice);
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
                    case 4 -> s.openShop(this);

                }
            } catch (RuntimeException r) {
                System.out.println("try again");
                sc.nextLine();
            }
        }
    }

    /**
     *
     * @param cycle returns the room you are in
     * @return what room you are in
     */
    public String roomReturn(int cycle) {
        return "You are in a room " + cycle + " " + "enemy there has: " + game.get(cycle).health + " " + "health";
    }

    /**
     * This method fights the enemy in the current room
     * @param a for method to know who to fight
     * @return if you have less than 4hp and win, you get 5 hp as a bonus
     * if you win with more, nothing for you
     * if you lose, game restarts
     */

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

    /**
     * Method for skipping room
     * @return success skip or out of skips
     */

    public String skip() {
        skipChoice--;
        if (skipChoice >= 0) {
            return "Successfully skipped one room! ";
        } else {
            return "You are out of skips!";
        }
    }

    /**
     * Method for healing player with 4hp
     * @return success heal or out of heals
     */

    public String heal() {
        if (healercheck > 0) {
            healercheck--;
            p.setHealth(p.health + 4);
            return "Successfully healed";
        } else {
            return "You cannot heal anymore";
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
