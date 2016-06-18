package com.bakigoal.ocjp.thread;

import java.util.Random;

/**
 * Created by ilmir on 17.04.16.
 */
public class DiceGame {
	public static void main(String[] s) {
		Player player1 = new Player(Gamers.JANE);
		Player player2 = new Player(Gamers.JOE);
		// don'thread forget to set who starts the game
		Dice.setWhoStarts(Gamers.JOE);
		player1.start();
		player2.start();
	}
}

// the Gamers class just holds the name of players who roll the dice
class Gamers {
	// prevent instantiating this utility class by making constructor private
	private Gamers() {
	}

	public static final String JOE = "Joe";
	public static final String JANE = "Jane";
}

// the Dice class abstracts how the dice rolls and who plays it
class Dice {
	// to remember whose turn it is to roll the dice
	private static String turn = null;

	synchronized public static String getTurn() {
		return turn;
	}

	synchronized public static void setTurn(String player) {
		turn = player;
	}

	// which player starts the game
	public static void setWhoStarts(String name) {
		turn = name;
	}

	// prevent instantiating the class by making it private (we've only static members)
	private Dice() {
	}

	private static Random random = new Random();

	public static int roll() {
		return random.nextInt(6) + 1;
	}
}

// the class Player abstracts a player playing the Dice game
// each player runs as a separate thread, so Player extends Thread class
class Player extends Thread {
	private String currentPlayer = null;
	private String otherPlayer = null;

	public Player(String thisPlayer) {
		currentPlayer = thisPlayer;
// we've only two players; we remember them in currentPlayer and otherPlayer
		otherPlayer = thisPlayer.equals(Gamers.JOE) ? Gamers.JANE : Gamers.JOE;
	}

	public void run() {
// each player rolls the dice 6 times in the game
		for (int i = 0; i < 6; i++) {
// acquire the lock before proceeding
			synchronized (Dice.class) {
// if its not currentPlayer's turn, then
// wait for otherPlayers's notification
				while (!Dice.getTurn().equals(currentPlayer)) {
					try {
						Dice.class.wait(1000);
						System.out.println(currentPlayer +
								" was waiting for " + otherPlayer);
					} catch (InterruptedException ie) {
						ie.printStackTrace();
					}
				}
// its currentPlayer's turn now; throw the dice
				System.out.println(Dice.getTurn() + " throws " + Dice.roll());
// set the turn to otherPlayer, and notify the otherPlayer
				Dice.setTurn(otherPlayer);
				Dice.class.notifyAll();
			}
		}
	}
}