package UserInterface;

import Creatures.Creature;
import Creatures.Goblin;
import Creatures.Player;
import Creatures.Skeleton;

import static GameService.GameService.*;

public class UserInterface {
    public static void randomEncounter(Player player) {
        Creature enemy;
        if (getRandomNumber() > 50) {
            enemy = new Skeleton("Bone Lee",50,15,10);
        } else {
            enemy = new Goblin("One Hand",40,10,20);
        }

        System.out.println("Characters are fighting and...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(fight(player,enemy));
    }
}
