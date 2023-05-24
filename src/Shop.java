import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Shop {
    private Scanner sc = new Scanner(System.in);
    private Messages m = new Messages();
    private Random r = new Random();
    private int points;

    /**
     * counts corrext answers in gamble
     */
    private int correctCounter;

    public Shop() {
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getCorrectCounter() {
        return correctCounter;
    }

    public void setCorrectCounter(int correctCounter) {
        this.correctCounter = correctCounter;
    }

    /**
     * method that opens when player pick shop in game
     * plays enter message and opens switch for choices
     */
    public void openShop() {
        System.out.println(m.shopMenu());

        System.out.println(m.optionsText());

        boolean check = true;
        while (check) {
            try {
                switch (sc.nextInt()) {
                    default -> throw new RuntimeException();



                    case 1 -> check = false;
                    case 2 -> System.out.println(gamble());
                    case 3 -> System.out.println("Dasdsadasd");
                    case 4 -> buyHeals();
                }
            } catch(RuntimeException r){
                System.out.println("Try again");
                sc.nextLine();
            }
        }
    }


    /**
     * Method for gamble choice
     * makes math quiz for points
     * @return num of points playr gets
     */
    public String gamble() {
        m.gambleText();
        setCorrectCounter(0);

        for (int i = 0; i < 3; i++) {
            int a = r.nextInt(20) - 10;
            int b = r.nextInt(20);
            int ans = a + b;


            System.out.println("How much is " + a + "+ " + b + "?");

            boolean checker = true;

            while (checker) {
                try {
                    int pAns = sc.nextInt();
                    checker = false;
                    if (ans == pAns) {
                        correctCounter++;
                        System.out.println("Correct!");
                    } else {
                        System.out.println("wrong, omg.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("try again");
                    sc.nextLine();
                }
            }
            }

        if (correctCounter == 3) {
            setPoints(getPoints() + 5);
            return "Wow, I need to give you 5 points, here you go";
        } else if (correctCounter == 2) {
            setPoints(getPoints() + 3);
            return "Nice try, but I'll need to give you only 3 points";
        } else if (correctCounter == 1) {
            setPoints(getPoints() + 1);
            return "meh, I'm only giving you 1 point, because I'm a good man ";
        } else if (correctCounter < 1) {
            return "Are you for real, meh, nothing for you";
        }
        System.out.println("You now have" + getPoints() + " points");
        return null;


    }

    /**
     * method for buying heals for points
     */
    public void buyHeals(){
        Game g = new Game();
        System.out.println("You have: "+ points+ " Points");
        System.out.println("How many heals do you want to buy? \n " +
                "1) 1, PRICE: 2 Points \n" +
                "2) 2  PRICE: 4 Points\n" +
                "3) 3 PRICE: 6 Points");

        switch (sc.nextInt()){
            case 1:
                if (points>= 2){
                    g.getP().setHealth(g.getP().getHealth()+1);
                    System.out.println(g.getP().getHealth());
                    System.out.println("1 heal added to your inventory");
                }else {
                    System.out.println("You don't have enough points");
                }
                break;
            case 2:
                if (points>=4){
                    System.out.println(g.getHealercheck());
                    System.out.println("2 heals added to your inventory");
                     g.setHealercheck(g.getHealercheck()+1);
                    System.out.println(g.getHealercheck());
                }else {
                    System.out.println("You don't have enough points");
                }
                break;

        }

    }
}
