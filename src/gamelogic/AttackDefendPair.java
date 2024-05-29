package gamelogic;

public class AttackDefendPair
{
    private int indexAttack;
    private int indexDefend;

    public AttackDefendPair(int indexAttack, int indexDefend)
    {
        this.indexAttack = indexAttack;
        this.indexDefend = indexDefend;
    }

    public int getIndexAttack() {
        return indexAttack;
    }

    public int getIndexDefend() {
        return indexDefend;
    }
}
