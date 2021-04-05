package viceCity.core;

import viceCity.core.interfaces.Controller;
import viceCity.models.guns.*;
import viceCity.models.neighbourhood.GangNeighbourhood;
import viceCity.models.neighbourhood.Neighbourhood;
import viceCity.models.players.*;

import java.util.*;
import java.util.stream.Collectors;

import static viceCity.common.ConstantMessages.*;

public class ControllerImpl implements Controller {

    private Player mainPLayer;
    private Map<String, Player> civilPlayers;
    private Deque<Gun> guns;
    private Neighbourhood neighbourhood;

    public ControllerImpl() {
        this.mainPLayer = new MainPlayer();
        this.civilPlayers = new LinkedHashMap<>();
        this.guns = new ArrayDeque<>();
        this.neighbourhood = new GangNeighbourhood();
    }

    @Override
    public String addPlayer(String name) {
        this.civilPlayers.put(name, new CivilPlayer(name));
        return String.format(PLAYER_ADDED, name) ;
    }

    @Override
    public String addGun(String type, String name) {
        Gun gun;
        switch (type) {
            case "Rifle":
                gun = new Rifle(name);
                break;
            case "Pistol":
                gun = new Pistol(name);
                break;
            default:
                return GUN_TYPE_INVALID;
        }
        guns.offer(gun);
        return String.format(GUN_ADDED, name, type);
    }

    @Override
    public String addGunToPlayer(String name) {
        if (this.guns.isEmpty()) {
            return GUN_QUEUE_IS_EMPTY;
        } else if (name.equals("Vercetti")) {
            Gun gun = guns.poll();
            this.mainPLayer.getGunRepository().add(gun);
            return String.format(GUN_ADDED_TO_MAIN_PLAYER, gun.getName(), this.mainPLayer.getName());
        } else if (civilPlayers.containsKey(name)) {
            Gun gun = guns.poll();
            this.civilPlayers.get(name).getGunRepository()
                    .add(gun);
            return String.format(GUN_ADDED_TO_CIVIL_PLAYER, gun.getName(), name);
        } else {
            return CIVIL_PLAYER_DOES_NOT_EXIST;
        }
    }

    @Override
    public String fight() {
        neighbourhood.action(this.mainPLayer, civilPlayers.values());

        if (mainPLayer.getLifePoints() == 100 && civilPlayers
                .values().stream().allMatch(p -> p.getLifePoints() == 50)) {
            return FIGHT_HOT_HAPPENED;
        }

        List<Player> deadPlayers = civilPlayers.values()
                .stream()
                .filter(p -> !p.isAlive())
                .collect(Collectors.toList());

        StringBuilder out = new StringBuilder(FIGHT_HAPPENED);

        out.append(System.lineSeparator())
                .append(String.format(MAIN_PLAYER_LIVE_POINTS_MESSAGE, mainPLayer.getLifePoints()))
                .append(System.lineSeparator())
                .append(String.format(MAIN_PLAYER_KILLED_CIVIL_PLAYERS_MESSAGE, deadPlayers.size()))
                .append(System.lineSeparator())
                .append(String.format(CIVIL_PLAYERS_LEFT_MESSAGE, civilPlayers.size() - deadPlayers.size()));

        for (Player player : deadPlayers) {
            civilPlayers.remove(player.getName());
        }

        return out.toString().trim();
    }
}
