package entites;

public class ArcherCard extends UnitCard {

    private int countArrows;

    public ArcherCard(String name, int healthPoint, int damagePoint, int countArrows) {
        super(name, healthPoint, damagePoint);

        this.countArrows = countArrows;
    }

    @Override
    public String getInfo() {
        return name + "- лучник - жизни: " + healthPoint + " урон: " + damagePoint + " осталось стрел: " + countArrows;
    }

    @Override
    protected int getCalculateDamagePoint() {
        if (countArrows > 0) {

            int calculateDamagePoint = damagePoint + countArrows / 4;

            countArrows--;

            return calculateDamagePoint;
        }
        return 0;
    }

    @Override
    protected int getCalculateDefendPoint() {
        return 0;
    }
}
