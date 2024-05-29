import gamelogic.GameManager;

public class Main {
    public static void main(String[] args) {
        GameManager gameManager = new GameManager();

        gameManager.initPlayers();
        gameManager.gameLoop();
        gameManager.showWinner();
    }
}