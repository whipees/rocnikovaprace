import java.util.Random;
import java.util.Scanner;

public class Shop {
    private Scanner sc = new Scanner(System.in);
    private Messages m = new Messages();
    private Random r = new Random();
    private int points;

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

    public void openShop() {
        System.out.println(m.shopMenu());
        // TODO: 23.05.2023 muzu si nakoupit healy a skipy, bude davat otazky a veci za free

        options();

    }

    public void options() {
        System.out.println(m.optionsText());
        int choice = sc.nextInt();
        boolean check = true;

            while (check) {
                try {
                    switch (choice) {
                        case 1:
                            System.out.println(gamble());
                            break;
                        case 2:
                            System.out.println("Fd");
                            break;
                        case 3:
                            System.out.println("Dasdsadasd");
                            break;
                        case 4:
                            check = false;
                            System.out.println(m.choiceQ());
                            break;
                        default:
                            throw new RuntimeException();
                    }


                } catch(RuntimeException r){
                    System.out.println("Try again");
                    sc.nextLine();
                }
            }

    }

    public String gamble() {
        Game g = new Game();
        m.gambleText();
        setCorrectCounter(0);

        for (int i = 0; i < 3; i++) {
            int a = r.nextInt(20) - 10;
            int b = r.nextInt(20);
            int ans = a + b;


            System.out.println("How much is " + a + "+ " + b + "?");


            int pAns = sc.nextInt();

            if (ans == pAns) {
                correctCounter++;
                System.out.println("Correct!");
            } else {
                System.out.println("wrong, omg.");
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
        return "You now have" + correctCounter + " points";


    }
}
