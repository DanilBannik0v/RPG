package Creatures;

import static GameService.GameService.getRandomNumber;

public class Trader {
    private String name;
    private int healPotion;

    public Trader() {
        if (getRandomNumber() > 50) {
            this.name = "Greedy Devy";
            this.healPotion = 5;
        } else {
            this.name = "Honest Joe";
            this.healPotion = 1;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealPotion() {
        return healPotion;
    }

    public void setHealPotion(int healPotion) {
        this.healPotion = healPotion;
    }
}
