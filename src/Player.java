public class Player extends Character {
    private String name;

    public Player(int health, String name) {
        super(health);
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", health=" + health +
                '}';
    }
}
