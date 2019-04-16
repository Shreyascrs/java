package com.bridgelabz.json;

import java.util.Scanner;

public class DeckOfCards {

	
		String[] suite= {"Spades","Diamond","Club","Heart"};	//there are 4 types suites in the card
		String[] rank= {"2","3","4","5","6","7","8","9","10","Jack","King","Queen","Ace"}; //total no cards in each suite
		String[] deck=new String[52];	// which consists of shuffeled cards
		String[][] cards=new String[4][9];	// each person cards are stored hear
		
		
		public void getcards() {						// which gives 52 cards
		for (int i = 0; i < deck.length; i++) {
			deck[i]=rank[i%13]+" "+suite[i/13];
//			System.out.println(deck[i]);
		}
		}
		public void shuffel() {							// which shuffels the all cards
		for (int i = 0; i < deck.length; i++) {
			int index=(int)(Math.random()*deck.length);
			
			String temp=deck[i];
			deck[i]=deck[index];
			deck[index]=temp;
			
		}
		}
		
		public String[][] distribute(int no_of_player,int no_cards) {			// cards that are assegined to peopel
			int k=0;
			for (int i = 0; i < no_of_player; i++) {
				for (int j = 0; j < no_cards; j++) {
				cards[i][j]=deck[k];
				deck[k]=" ";
				k++;
				}
			}return cards;
		}
			
			
			public void print()			
			{
			for (int i = 0; i < 4; i++) {
				System.out.println();
				System.out.println("the "+(i+1)+" person cards are");
				System.out.println();
				for (int j = 0; j < 9; j++) {
					System.out.println(cards[i][j]);
				}
			}
			}
			public void remainingcard(int no_of_player,int no_cards) {
				int t=(no_cards*no_of_player);
				System.out.println(); 
			System.out.println(" the remaining cards are ");
			for (int i = t; i < deck.length; i++) {
				System.out.println(deck[i]);
			}
			}
			
			
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		DeckOfCards card=new DeckOfCards();
		int no_of_player;
		int no_cards;
		card.getcards();
		card.shuffel();
		System.out.println("enter no of players ");
		no_of_player=scan.nextInt();
		System.out.println("enter no of cards");
		no_cards=scan.nextInt();
		card.distribute(no_of_player,no_cards);
		card.print();
		card.remainingcard(no_of_player,no_cards);
	scan.close();
	}

}
