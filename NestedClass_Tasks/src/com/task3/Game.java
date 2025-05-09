package com.task3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

	List<Player> players = new ArrayList<>();

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public Game() {
		super();
	
	}

	public Player findMaxScore() {
		int max=0;
		Player player = null;
		for(Player p:players) {
			if(p.score>max) {
				max=p.score;
				player=p;
			}
		}
		return player;
		

	}

	public class Player {
		private String Name;
		private int score;

		public Player(String name, int score) {
			super();
			Name = name;
			this.score = score;
			players.add(this);
			System.out.println("Player and their score added sucessfully");
		}

		public String getName() {
			return Name;
		}

		public void setName(String name) {
			Name = name;
		}

		public int getScore() {
			return score;
		}

		public void setScore(int score) {
			this.score = score;
		}

	}
	
	public static void main(String[] args) {
		char exit='y';
		Game game=new Game();
		Scanner sc=new Scanner(System.in);
		System.out.println("Welcome to game");
		
		do {
			
			System.out.println("Enter the Name of the player  and their score");
			System.out.println("Enter the Name:");
			String Name=sc.next();
			System.out.println("Enter the Score of "+Name+":");
			int Score=sc.nextInt();
			
			game.new Player(Name,Score);
			
			
			
			
			System.out.println("Do you want to continue'y' for yes and 'n' for no:");
			exit=sc.next().charAt(0);
		}while(exit=='y');
		
		Player p=game.findMaxScore();
		System.out.println("The Maximum scorer of the game is: \n"+p.Name +",scored " +p.score);
		
	}

}
