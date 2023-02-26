package Creatures;

import static GameService.GameService.getRandomNumber;

public abstract class Creature {
    private final String name;
    private int healthPoints;
    private int strength;
    private int agility;
    private int attackCounter;

    public Creature(String name, int healthPoints, int strength, int agility) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.strength = strength;
        this.agility = agility;
        this.attackCounter = 0;
    }

    public void attack(Creature enemy) {
        if (this.agility * 3 > getRandomNumber()) {

            if (this.attackCounter == 5) {
                enemy.healthPoints -= this.strength * 2;
                this.attackCounter = 0;
            } else {
                enemy.healthPoints -= this.strength;
                this.attackCounter += 1;
            }
        }
    }

    public boolean isAlive() {
        return this.healthPoints > 0;
    }

    public String getName() {
        return name;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getAttackCounter() {
        return attackCounter;
    }

    public void setAttackCounter(int attackCounter) {
        this.attackCounter = attackCounter;
    }

    @Override
    public String toString() {
        return "Creature{" +
                "name='" + name + '\'' +
                ", healthPoints=" + healthPoints +
                ", strength=" + strength +
                ", agility=" + agility +
                ", attackCounter=" + attackCounter +
                '}';
    }
}
