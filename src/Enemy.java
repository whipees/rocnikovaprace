/**
 * Enemy for character, same methods as character (Extend)
 */
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
