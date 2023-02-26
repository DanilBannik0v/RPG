package GameService;

import Creatures.Creature;
import Creatures.Player;

public class GameService {

    public static String fight(Player player, Creature enemy) {
        while (player.isAlive() && enemy.isAlive()) {
            player.attack(enemy);
            if (enemy.isAlive()) {
                enemy.attack(player);
            }
        }

        if (player.isAlive()) {
            giveReward(player);

            StringBuffer strB = new StringBuffer();
            strB.append(enemy.getName()).append(" was killed by ").append(player.getName()).append("\n")
                .append(player.getName()).append("'s gold: ").append(player.getGold()).append("\n")
                .append(player.getName()).append("'s level: ").append(player.getLevel()).append("\n")
                .append(player.getName()).append("'s health-points: ").append(player.getHealthPoints());
            return strB.toString();
        }

        return player.getName() + " was killed by " + enemy.getName() + " , what's a pity!";
    }

    public static void giveReward(Player player) {
        player.addGold(50 + getRandomNumber());
        player.addXp(50 + getRandomNumber());
    }

    public static int getRandomNumber() {
        return (int) (Math.random() * 100) + 1;
    }
}
