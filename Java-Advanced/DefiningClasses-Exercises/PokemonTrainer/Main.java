package PokemonTrainer;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        LinkedHashMap<String, Trainer> trainers = new LinkedHashMap<>();

        while (!input.equals("Tournament")) {
            String[] tokens = input.split("\\s+");
            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String element = tokens[2];
            int health = Integer.parseInt(tokens[3]);

            Pokemon pokemon = new Pokemon(pokemonName, element, health);

            trainers.putIfAbsent(trainerName ,new Trainer(trainerName));
            trainers.get(trainerName).getPokemons().add(pokemon);

            input = scanner.nextLine();
        }
        input = scanner.nextLine();

        while (!input.equals("End")) {
            for (Trainer trainer: trainers.values()) {
                if (trainer.getPokemons().size() > 0) {
                    boolean havePokemon = false;
                    for (Pokemon pokemon : trainer.getPokemons()) {
                        if (pokemon.getElement().equals(input)) {
                            havePokemon = true;
                        }
                        if (havePokemon) {
                            trainer.setBadges();
                            break;
                        }
                    }
                    if (!havePokemon) {
                        for (Pokemon pokemon:trainer.getPokemons()) {
                            int health = pokemon.getHealth();
                            if (health - 10 > 0) {
                                pokemon.setHealth(health-10);
                            } else {
                                trainer.getPokemons().remove(pokemon);
                                break;
                            }
                        }
                    }
                }
            }
            input = scanner.nextLine();
        }
        trainers.values().stream().sorted((t1, t2) -> t2.getBadges() - t1.getBadges())
                .forEach(a-> System.out.println(a.getName() + " " + a.getBadges() + " " + a.getPokemons().size()));
    }
}
