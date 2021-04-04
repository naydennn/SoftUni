package viceCity.models.guns;

public class Rifle extends BaseGun {

    private static final int BULLETS_PER_BARREL = 50;
    private static final int TOTAL_BULLETS = 500;

    private int bullets;

    public Rifle(String name) {
        super(name, BULLETS_PER_BARREL, TOTAL_BULLETS);
        this.bullets = BULLETS_PER_BARREL;
    }

    @Override
    public int fire() {
        if(canFire()) {
            if (this.bullets == 0) {
                reload();
            }
            this.bullets-=5;
        }
        return 5;
    }

    private void reload() {
        this.bullets = BULLETS_PER_BARREL;
        setTotalBullets(getTotalBullets() - BULLETS_PER_BARREL);
    }
}
