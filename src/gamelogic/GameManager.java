package gamelogic;

import entites.ArcherCard;
import entites.UnitCard;
import entites.WarriorCard;
import tools.ConsoleUtil;
import tools.Random;

import java.util.ArrayList;


public class GameManager {
    private Player player1;
    private Player player2;

    private Player initPlayer() {
        String name = ConsoleUtil.inputString("Введите имя: ");
        ConsoleUtil.println("Раздача случайных карт.....");

        ArrayList<UnitCard> unitCards = new ArrayList<>();
        for (int i = 0; i < GameConstants.UNIT_CARDS_PER_PLAYER; i++) {

            int choose = Random.getValueWithoutRightBound(0, 1000);
            if (choose > 500) {
                unitCards.add(new ArcherCard(
                        GameConstants.UNIT_NAMES.get(Random.getValueWithoutRightBound(0, GameConstants.UNIT_NAMES.size())),
                        Random.getValueWithRightBound(GameConstants.MIN_ARCHER_CARD_HEALTH_POINT, GameConstants.MAX_ARCHER_CARD_HEALTH_POINT),
                        Random.getValueWithRightBound(GameConstants.MIN_ARCHER_CARD_DAMAGE_POINT, GameConstants.MAX_ARCHER_CARD_DAMAGE_POINT),
                        Random.getValueWithRightBound(GameConstants.MIN_ARCHER_CARD_COUNT_ARROWS, GameConstants.MAX_ARCHER_CARD_COUNT_ARROWS)
                ));
            } else {
                unitCards.add(new WarriorCard(
                        GameConstants.UNIT_NAMES.get(Random.getValueWithoutRightBound(0, GameConstants.UNIT_NAMES.size())),
                        Random.getValueWithRightBound(GameConstants.MIN_WARRIOR_CARD_HEALTH_POINT, GameConstants.MAX_WARRIOR_CARD_HEALTH_POINT),
                        Random.getValueWithRightBound(GameConstants.MIN_WARRIOR_CARD_DAMAGE_POINT, GameConstants.MAX_WARRIOR_CARD_DAMAGE_POINT),
                        Random.getValueWithRightBound(GameConstants.MIN_WARRIOR_CARD_POWER_POINT, GameConstants.MAX_WARRIOR_CARD_POWER_POINT),
                        Random.getValueWithRightBound(GameConstants.MIN_WARRIOR_CARD_ARMOR_POINT, GameConstants.MAX_WARRIOR_CARD_ARMOR_POINT)
                ));
            }
        }

        return new Player(name, unitCards);
    }

    public void initPlayers() {
        ConsoleUtil.println("ИГРОК 1");
        player1 = initPlayer();

        ConsoleUtil.addVerticalWhiteSpaces();

        ConsoleUtil.println("ИГРОК 2");
        player2 = initPlayer();

        ConsoleUtil.addVerticalWhiteSpaces();
    }

    private void printPlayers() {
        ConsoleUtil.println(player1.getInfo());

        ConsoleUtil.addVerticalWhiteSpaces();

        ConsoleUtil.println(player2.getInfo());

        ConsoleUtil.addVerticalWhiteSpaces();
    }

    private ArrayList<AttackDefendPair> createAttackDefendPairs() {
        ArrayList<AttackDefendPair> attackDefendPairs = new ArrayList<>();

        int hasMorePair;

        do {

            int indexAttack = ConsoleUtil.inputInt("Введите номер своего атакующего существа: ") - 1;
            int indexDefend = ConsoleUtil.inputInt("Введите номер у противника защищающегося существа: ") - 1;

            attackDefendPairs.add(new AttackDefendPair(indexAttack, indexDefend));

            hasMorePair = ConsoleUtil.inputInt("Нужно ли выбрать ещё одну пару для атаки и защиты (0 - нет, 1 - да): ");
        } while (hasMorePair == 1);

        return attackDefendPairs;
    }

    public void gameLoop() {

        boolean isRun = true;

        while (isRun) {
            ConsoleUtil.addVerticalWhiteSpaces();

            printPlayers();

            player2.resetRetaliatoryStrikeForAllUnits();

            ConsoleUtil.println("Ходит ИГРОК 1");

            ArrayList<AttackDefendPair> attackDefendPairsPlayer1 = createAttackDefendPairs();

            for (int i = 0; i < attackDefendPairsPlayer1.size(); i++) {
                AttackDefendPair currentPair = attackDefendPairsPlayer1.get(i);

                int indexAttack = currentPair.getIndexAttack();
                int indexDefend = currentPair.getIndexDefend();

                UnitCard attackUnitCard = player1.getUnitCards().get(indexAttack);
                UnitCard defendUnitCard =  player2.getUnitCards().get(indexDefend);

                attackUnitCard.attackOtherUnitCard(defendUnitCard);
            }

            ConsoleUtil.addVerticalWhiteSpaces();
            ConsoleUtil.println("Битва состоялась. С поля уносят поверженных существ. Нажмите <Enter> для продолжения");
            ConsoleUtil.waitEnter();

            player1.deleteDeadUnitCards();
            player2.deleteDeadUnitCards();

            isRun = player1.isAlive() && player2.isAlive();

            player1.resetRetaliatoryStrikeForAllUnits();

            ConsoleUtil.addVerticalWhiteSpaces();

            printPlayers();

            ConsoleUtil.println("Ходит ИГРОК 2");

            ArrayList<AttackDefendPair> attackDefendPairsPlayer2 = createAttackDefendPairs();

            for (int i = 0; i < attackDefendPairsPlayer2.size(); i++) {
                AttackDefendPair currentPair = attackDefendPairsPlayer2.get(i);

                int indexAttack = currentPair.getIndexAttack();
                int indexDefend = currentPair.getIndexDefend();

                UnitCard attackUnitCard = player2.getUnitCards().get(indexAttack);
                UnitCard defendUnitCard =  player1.getUnitCards().get(indexDefend);

                attackUnitCard.attackOtherUnitCard(defendUnitCard);
            }

            ConsoleUtil.addVerticalWhiteSpaces();
            ConsoleUtil.println("Битва состоялась. С поля уносят поверженных существ. Нажмите <Enter> для продолжения");
            ConsoleUtil.waitEnter();

            player1.deleteDeadUnitCards();
            player2.deleteDeadUnitCards();

            isRun = player1.isAlive() && player2.isAlive();
        }
    }

    public void showWinner() {
        printPlayers();

        if (player1.isAlive() && !player2.isAlive()) {
            ConsoleUtil.println("Победил ИГРОК 1");
        } else if (!player1.isAlive() && player2.isAlive()) {
            ConsoleUtil.println("Победил ИГРОК 2");
        } else if (!player1.isAlive() && !player2.isAlive()) {
            ConsoleUtil.println("Ничья");
        }
    }
}
