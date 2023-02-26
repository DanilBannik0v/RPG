import Creatures.Player;
import Creatures.Trader;

import java.util.Scanner;

import static UserInterface.UserInterface.randomEncounter;

public class Main {
    public static Player player;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя персонажа: ");
        String name = scanner.nextLine();

        player = new Player(name,100,10,10,0,0);
        Trader trader = new Trader();

        System.out.println("""
                Правила игры:
                'to trader' - Вы направляетесь к торговцу, если хватает золота, то покупаете зелье.
                'to forest' - Вы направляетесь в лес, где Вас ожидают чудовища.
                'stats' - Отображение всех ваших характеристик
                'exit' - Вы заканчиваете игру.
                Ваши начальные характеристики: 100 hp, 10 strength, 10 agility, 0 gold, 0 xp
                Удачной игры!""");

        while (true) {
            String command = scanner.nextLine();
            switch (command) {
                case "exit" -> System.exit(1);
                case "to trader" -> System.out.println(player.buyPotion(trader));
                case "stats" -> System.out.println(player);
                case "to forest" -> {
                    randomEncounter(player);
                    if (!player.isAlive()) System.exit(1);
                }
            }
        }
    }
}