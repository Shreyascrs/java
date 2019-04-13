package com.bridgelabz.json;

import java.util.Scanner;

import com.bridgelabz.datastructures.Queue;

public class CardsQueue extends DeckOfCards {
public static void main(String[] args) {
	Scanner scan=new Scanner(System.in);
	Utilityjson util=new Utilityjson();
	
	int no_of_players;
	int no_cards;
	DeckOfCards deck=new CardsQueue();
	System.out.println("ENTER NO OF PLAYERS");
	no_of_players=scan.nextInt();
	System.out.println("ENTER NO OF CARDS");
	no_cards=scan.nextInt();
	deck.getcards();
	deck.shuffel();
	
	String cards[][]=deck.distribute(no_of_players, no_cards);
	for (int i = 0; i < no_of_players; i++) {
//		System.out.println("the "+(i+1)+" players cards");
		for (int j = 0; j < no_cards; j++) {
			try {
			util.queue.enqueue(cards[i][j]);
			}
			catch(Exception e)
			{
				e.getMessage();
			}
			
		}
		for (int j = 0; j < cards.length; j++) {
			
		}
		util.queue.deleteall();
	}
}
}
