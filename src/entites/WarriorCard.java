package entites;

public class WarriorCard extends UnitCard {
    private int powerPoint;
    private int armorPoint;

    public WarriorCard(String name, int healthPoint, int damagePoint, int powerPoint, int armorPoint) {
        super(name, healthPoint, damagePoint);

        this.powerPoint = powerPoint;
        this.armorPoint = armorPoint;
    }

    @Override
    public String getInfo() {
        return name + "- воин - жизни: " + healthPoint + " урон: " + damagePoint + " выносливость: " + powerPoint + " броня: " + armorPoint;
    }

    @Override
    protected int getCalculateDamagePoint() {
        if (powerPoint > 0) {
            int calculateDamagePoint = damagePoint * powerPoint;

            powerPoint = powerPoint / 2;

            return calculateDamagePoint;
        }
        return 0;
    }

    @Override
    protected int getCalculateDefendPoint() {
        return armorPoint;
    }
}
