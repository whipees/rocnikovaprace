public class Character {
    protected int health;

    /**
     * Contructor of character
     * @param health
     */
    public Character(int health) {
        this.health = health;
    }

    /**
     * health getter
     * @return health
     */
    public int getHealth() {
        return health;
    }

    /**
     * setter for health
     * @param health
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     *
     * @return character with health
     */
    @Override
    public String toString() {
        return "Character{" +
                "health=" + health +
                '}';
    }
}
