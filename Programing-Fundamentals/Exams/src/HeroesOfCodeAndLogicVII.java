import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class HeroesOfCodeAndLogicVII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> heroAndHeal = new TreeMap<>();
        Map<String, Integer> heroAndMana = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String[] infoForHero = scanner.nextLine().split("\\s+");
            String name = infoForHero[0];
            int heal = Integer.parseInt(infoForHero[1]);
            int mana = Integer.parseInt(infoForHero[2]);
            if (heal <= 100 && mana <= 200) {
                heroAndHeal.put(name, heal);
                heroAndMana.put(name, mana);
            }
        }
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] commands = input.split(" - ");
            String name = commands[1];
            switch (commands[0]) {
                case "CastSpell":
                    int mana = Integer.parseInt(commands[2]);
                    String spellName = commands[3];
                    if (heroAndMana.get(name) - mana >= 0) {
                        heroAndMana.put(name, heroAndMana.get(name) - mana);
                        System.out.printf("%s has successfully cast %s and now has %d MP!%n", name, spellName, heroAndMana.get(name));
                    } else {
                        System.out.printf("%s does not have enough MP to cast %s!%n", name, spellName);
                    }
                    break;
                case "TakeDamage":
                    int damage = Integer.parseInt(commands[2]);
                    String attacker = commands[3];
                    if (heroAndHeal.get(name) - damage > 0) {
                        heroAndHeal.put(name, heroAndHeal.get(name) - damage);
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n", name, damage, attacker, heroAndHeal.get(name));
                    } else {
                        heroAndHeal.remove(name);
                        heroAndMana.remove(name);
                        System.out.printf("%s has been killed by %s!%n", name, attacker);
                    }
                    break;
                case "Recharge":
                    int amount = Integer.parseInt(commands[2]);
                    if (heroAndMana.get(name) + amount > 200) {
                        System.out.printf("%s recharged for %d MP!%n", name, 200 - heroAndMana.get(name));
                        heroAndMana.put(name, 200);
                    } else {
                        heroAndMana.put(name, heroAndMana.get(name) + amount);
                        System.out.printf("%s recharged for %d MP!%n", name, amount);
                    }
                    break;
                case "Heal":
                    amount = Integer.parseInt(commands[2]);
                    if (heroAndHeal.get(name) + amount > 100) {
                        System.out.printf("%s healed for %d HP!%n", name, 100 - heroAndHeal.get(name));
                        heroAndHeal.put(name, 100);
                    } else {
                        heroAndHeal.put(name, heroAndHeal.get(name) + amount);
                        System.out.printf("%s healed for %d HP!%n", name, amount);
                    }
                    break;
            }

            input = scanner.nextLine();
        }
        heroAndHeal.entrySet().stream().sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .forEach(a -> {
                    System.out.println(a.getKey());
                    System.out.println("  HP: " + a.getValue());
                    System.out.println("  MP: " + heroAndMana.get(a.getKey()));
                });
    }
}
