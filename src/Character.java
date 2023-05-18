public class Character {
    protected int health;

    public Character(int health) {
        this.health = health;
    }
    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    @Override
    public String toString() {
        return "Character{" +
                "health=" + health +
                '}';
    }
}
