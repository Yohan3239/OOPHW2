import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Q9 {
    public static class guessingGame {
        int number;
        int attemptsLeft;
        Player player;
        boolean gameOver;
        Random r = new Random();
        public guessingGame(Player p, String gameDifficulty) {
            this.player = p;
            this.number = r.nextInt(1000) + 1;
            //defaults to 10 if invalid input
            this.attemptsLeft = gameDifficulty.equals("Hard") ? 5 : gameDifficulty.equals("Medium") ? 10 : gameDifficulty.equals("Easy") ? 15 : 10;
            this.gameOver = false;
        }

        public void guess(int guess) {
            attemptsLeft--;
            if (attemptsLeft == 0 && guess != number) {
                System.out.println("Game over");
                player.gamesPlayed++;
                gameOver = true;
                System.out.println("Game finished, the number was: " + number);
            }
            else if (guess == number) {
                System.out.println("Correct");
                player.gamesPlayed++;
                player.gamesWon++;
                gameOver = true;
                System.out.println("Game finished");
            } 
            else if (guess > number) {
                System.out.println("Go lower, attempts left: " + (attemptsLeft));
            } else {
                System.out.println("Go higher, attempts left: " + (attemptsLeft));
            }
        }

        public boolean getGameOver() {
            return gameOver;
        }
    }
    public static class Player {
        String name;
        int gamesWon;
        int gamesPlayed;
        public Player(String name) {
            this.name = name;
            gamesWon = 0;
            gamesPlayed = 0;
        }
    }
    public static class Scoreboard {
        ArrayList<Player> players;
        public Scoreboard() {
            players = new ArrayList<Player>();
        }
        public Player getPlayer(String input) {
            for (Player p : players) {
                if (p.name.equals(input)) {
                    return p;
                }
            }
            return null;
        }
        public void addPlayer(String name) {
            players.add(new Player(name));
        }
        public void printScoreboard() {
            System.out.println("Scoreboard:");
            for (Player p : players) {
                System.out.println(p.name + ": Wins: " + p.gamesWon + ", Played: " + p.gamesPlayed);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Scoreboard scoreboard = new Scoreboard();
        System.out.println("1 to add player, 2 to start game, 3 to view scoreboard, 4 to exit:");
        int input = scanner.nextInt();
        while (input != 4) {
            switch (input) {
                case 1:
                    System.out.println("Name:");
                    String playerName = scanner.next();
                    scoreboard.addPlayer(playerName);
                    System.out.println("Player added.");
                    break;
                case 2:
                    System.out.println("Enter player name to start game:");
                    String name = scanner.next();
                    Player player = scoreboard.getPlayer(name);
                    if (player == null) {
                        System.out.println("Player not found.");
                        break;
                    }
                    System.out.println("Select difficulty (Easy, Medium, Hard):");
                    String difficulty = scanner.next();
                    guessingGame game = new guessingGame(player, difficulty);
                    while (!game.getGameOver()) {
                        System.out.println("guess:");
                        game.guess(scanner.nextInt());
                    }
                    break;
                case 3:
                    scoreboard.printScoreboard();
                    break;
                case 4:
                    System.out.println("Exiting.");
                    break;
                default:
                    System.out.println("Invalid");
            }
            System.out.println("1 to add player, 2 to start game, 3 to view scoreboard, 4 to exit:");
            input = scanner.nextInt();
        }
        scanner.close();
    }

}