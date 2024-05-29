package gamelogic;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class GameConstants {
    public static final int UNIT_CARDS_PER_PLAYER = 2;

    public static final ArrayList<String> UNIT_NAMES = new ArrayList<>(Arrays.asList("Один", "Тор", "Тюр", "Браги", "Ньёрд", "Хеймдалль", "Хёд", "Видар", "Али", "Улль", "Форсети", "Локи"));

    //region archer_card
    public static final int MIN_ARCHER_CARD_HEALTH_POINT = 5;
    public static final int MAX_ARCHER_CARD_HEALTH_POINT = 10;

    public static final int MIN_ARCHER_CARD_DAMAGE_POINT = 5;
    public static final int MAX_ARCHER_CARD_DAMAGE_POINT = 10;

    public static final int MIN_ARCHER_CARD_COUNT_ARROWS = 15;
    public static final int MAX_ARCHER_CARD_COUNT_ARROWS = 20;
    //endregion

    //region warrior_card
    public static final int MIN_WARRIOR_CARD_HEALTH_POINT = 5;
    public static final int MAX_WARRIOR_CARD_HEALTH_POINT = 10;

    public static final int MIN_WARRIOR_CARD_DAMAGE_POINT = 5;
    public static final int MAX_WARRIOR_CARD_DAMAGE_POINT = 10;

    public static final int MIN_WARRIOR_CARD_POWER_POINT = 15;
    public static final int MAX_WARRIOR_CARD_POWER_POINT = 20;

    public static final int MIN_WARRIOR_CARD_ARMOR_POINT = 3;
    public static final int MAX_WARRIOR_CARD_ARMOR_POINT = 5;
    //endregion


}
