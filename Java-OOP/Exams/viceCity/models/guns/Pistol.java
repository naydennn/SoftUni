package viceCity.models.guns;

public class Pistol extends BaseGun{

    private static final int BULLETS_PER_BARREL = 10;
    private static final int TOTAL_BULLETS = 100;

    private int bullets;

    public Pistol(String name) {
        super(name, BULLETS_PER_BARREL, TOTAL_BULLETS);
        this.bullets = BULLETS_PER_BARREL;
    }

    @Override
    public int fire() {
        if(canFire()) {
            if (this.bullets == 0) {
                reload();
            }
            this.bullets--;
        }
        return 1;
    }

    private void reload() {
        this.bullets = BULLETS_PER_BARREL;
        setTotalBullets(getTotalBullets() - BULLETS_PER_BARREL);
    }
}
