package PokemonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private int badges;
    private String name;
    private List<Pokemon> pokemons;

    public Trainer(String name) {
        this.name = name;
        this.pokemons = new ArrayList<>();
        this.badges = 0;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public int getBadges() {
        return badges;
    }

    public void setBadges() {
        this.badges++;
    }

    public String getName() {
        return name;
    }
}
