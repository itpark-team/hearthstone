package gamelogic;

import entites.UnitCard;

import java.util.ArrayList;

public class Player {
    private String name;

    private ArrayList<UnitCard> unitCards;

    public Player(String name, ArrayList<UnitCard> unitCards) {
        this.name = name;
        this.unitCards = unitCards;
    }

    private String getAllCardsInfo() {
        String output = "";

        for (int i = 0; i < unitCards.size(); i++) {
            output += Integer.toString(i + 1) + ". " + unitCards.get(i).getInfo() + "\n";
        }

        return output;
    }

    public String getInfo() {
        return "Имя: " + name + "\n" +
                "Карты: \n" + getAllCardsInfo();
    }

    public boolean isAlive() {
        int countAlive = 0;

        for (int i = 0; i < unitCards.size(); i++) {
            if (unitCards.get(i).isAlive()) {
                countAlive++;
            }
        }

        return countAlive > 0;
    }

    public void resetRetaliatoryStrikeForAllUnits() {
        for (int i = 0; i < unitCards.size(); i++) {
            unitCards.get(i).resetRetaliatoryStrike();
        }
    }

    public ArrayList<UnitCard> getUnitCards() {
        return unitCards;
    }

    public void deleteDeadUnitCards() {
        for (int i = 0; i < unitCards.size(); i++) {
            if (!unitCards.get(i).isAlive()) {
                unitCards.remove(i);
                i = 0;
            }
        }
    }
}
