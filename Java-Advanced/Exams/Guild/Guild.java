package guild;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Guild {
    private List<Player> players;
    private String name;
    private int capacity;

    public Guild(String name, int capacity) {
        this.players = new ArrayList<>();
        this.name = name;
        this.capacity = capacity;
    }
    public void addPlayer(Player player) {
        if (count() < capacity) {
            this.players.add(player);
        }
    }
    public boolean removePlayer(String name) {
        for (Player p :players) {
            if (p.getName().equals(name)) {
                players.remove(p);
                return true;
            }
        }
        return false;
    }
    public void promotePlayer(String name) {
        boolean flag = true;
        for (Player p :players) {
            if (p.getName().equals(name) && flag) {
                if (!(p.getRank().equals("Member"))) {
                    p.setRank("Member");
                    flag = false;
                }
            }
        }
    }
    public void demotePlayer(String name){
        boolean flag = true;
        for (Player p :players) {
            if (p.getName().equals(name) && flag) {
                if (!(p.getRank().equals("Trial"))) {
                    p.setRank("Trial");
                    flag = false;
                }
            }
        }
    }
    public Player[] kickPlayersByClass(String clazz) {
        Player[] removed = players.stream()
                .filter(player -> clazz.equals(player.getClazz()))
                .toArray(Player[]::new);

        for (Player player : removed) {
            players.remove(player);
        }

        return removed;
    }
    public int count(){
        return players.size();
    }
    public String report() {
        return String.format(
                "Players in the guild: %s:%n%s", this.name,
                players.stream()
                        .map(Player::toString)
                        .collect(Collectors.joining(System.lineSeparator())));
    }
}
