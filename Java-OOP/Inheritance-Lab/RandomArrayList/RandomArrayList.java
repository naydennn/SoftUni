package RandomArrayList;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class RandomArrayList extends ArrayList {
    public Object getRandomElement() {
        int index = ThreadLocalRandom.current().nextInt(this.size());
        return remove(index);
    }
}
