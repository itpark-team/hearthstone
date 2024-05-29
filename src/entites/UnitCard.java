package entites;

public abstract class UnitCard {
    protected String name;
    protected int healthPoint;
    protected int damagePoint;
    protected boolean hasRetaliatoryStrike;

    public UnitCard(String name, int healthPoint, int damagePoint) {
        this.name = name;
        this.healthPoint = healthPoint;
        this.damagePoint = damagePoint;

        hasRetaliatoryStrike = true;
    }

    public String getName() {
        return name;
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    public int getDamagePoint() {
        return damagePoint;
    }


    public abstract String getInfo();

    protected abstract int getCalculateDamagePoint();

    protected abstract int getCalculateDefendPoint();

    public void attackOtherUnitCard(UnitCard enemyUnitCard) {
        int ourCalculateDamagePoint = getCalculateDamagePoint();
        int enemyCalculateDefendPoint = enemyUnitCard.getCalculateDefendPoint();

        int ourDamage = ourCalculateDamagePoint - enemyCalculateDefendPoint;

        enemyUnitCard.healthPoint -= ourDamage;

        if (enemyUnitCard.hasRetaliatoryStrike) {
            enemyUnitCard.hasRetaliatoryStrike = false;

            int enemyCalculateDamagePoint = enemyUnitCard.getCalculateDamagePoint();
            int ourCalculateDefendPoint = getCalculateDefendPoint();

            int enemyDamage = enemyCalculateDamagePoint - ourCalculateDefendPoint;

            healthPoint -= enemyDamage;
        }
    }

    public void resetRetaliatoryStrike() {
        hasRetaliatoryStrike = true;
    }

    public boolean isAlive() {
        return healthPoint > 0;
    }
}
