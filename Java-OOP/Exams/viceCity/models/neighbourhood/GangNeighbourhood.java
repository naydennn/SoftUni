package viceCity.models.neighbourhood;

import viceCity.models.guns.Gun;
import viceCity.models.players.Player;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;

public class GangNeighbourhood implements Neighbourhood {

    @Override
    public void action(Player mainPlayer, Collection<Player> civilPlayers) {

        Collection<Gun> models = mainPlayer.getGunRepository().getModels();
        Deque<Player> players = new ArrayDeque<>();
        Deque<Gun> guns = new ArrayDeque<>();
        civilPlayers.forEach(players::offer);
        models.forEach(guns::offer);

        Player player = players.poll();
        Gun gun = guns.poll();
        while (gun != null || player != null) {
            while (gun.canFire() && player.isAlive()) {
                player.takeLifePoints(gun.fire());
            }
            if (!gun.canFire()) {
                gun = guns.poll();
            }
            if (!player.isAlive()) {
                player = players.poll();
            }
        }

        if (guns.isEmpty() && !players.isEmpty()) {
            for (Player civilPlayer : players) {
                Collection<Gun> gunsCivilPlayer = civilPlayer.getGunRepository().getModels();
                guns.clear();
                gunsCivilPlayer.forEach(guns::offer);
                while (mainPlayer.isAlive()) {
                    mainPlayer.takeLifePoints();
                }
            }
        }
    }
}
