public class Enemy extends Character {
    public Enemy(int health) {
        super(health);
    }

    @Override
    public String toString() {
        return "Enemy{" +
                "health=" + health +
                '}';
    }
}
