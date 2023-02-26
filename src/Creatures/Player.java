package Creatures;

public class Player extends Creature {
    private int gold;
    private int xp;
    private int level = 1;
    private int xpBorder = 100;

    public Player(String name, int healthPoints, int strength, int agility, int gold, int xp) {
        super(name, healthPoints, strength, agility);
        this.gold = gold;
        this.xp = xp;
        checkLevel();
    }

    public void addXp(int xp) {
        this.xp += xp;
        checkLevel();
    }

    private void checkLevel() {
        while (xp > xpBorder) {
            xp -= xpBorder;
            xpBorder += 100;
            newLevel();
        }
    }

    private void newLevel() {
        level += 1;
        setStrength(getStrength() + 1);
        setAgility(getAgility() + 1);
    }

    public void addGold(int gold) {
        this.gold = +gold;
    }

    public String buyPotion(Trader trader) {
        if (this.getGold() > 30 && trader.getHealPotion() > 0) {
            trader.setHealPotion(trader.getHealPotion() - 1);
            setHealthPoints(getHealthPoints() + 100);
            setGold(getGold() - 30);
        } else return "Failed to buy, try later";

        return "Your health-points: " + getHealthPoints() + "\n" +
                "Your gold: " + getGold();
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getXp() {
        return xp;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return "Player: " +
                "name='" + getName() + '\'' +
                ", healthPoints=" + getHealthPoints() +
                ", strength=" + getStrength() +
                ", agility=" + getAgility() +
                ", gold=" + getGold() +
                ", xp=" + getXp() +
                ", level=" + getLevel();
    }
}
