package com.bridgelabz.json.Comertial_Data_Processing;

import java.util.Scanner;

public class Runnable {
public static void main(String[] args) {
	Scanner scint=new Scanner(System.in);
	Scanner scstr=new Scanner(System.in);
	boolean value = true;

	
	while(value)
	{
		Stockaccount stockA = new Stockaccount();
	
		System.out.println("Enter the choice");
		System.out.println("1. Add Stock Account");
		System.out.println("2. Get Total Value of Stock");
		System.out.println("3. Buy Shares");
		System.out.println("4. Sell Shares");
		System.out.println("5. Print Report");
		System.out.println("6. Exit");
		int n=scint.nextInt();
		switch(n)
		{
			case 1:Stockaccount newStock = new Stockaccount("commcustinput.json");
					break;
		
			case 2:	double totalValue = stockA.valueoff();
					if(totalValue >= 0)
					{
						System.out.println(totalValue);
					}
					break;
					
					
			case 3: System.out.println("Enter the shares");
					int shares = scint.nextInt();
					System.out.println("Enter the Symbol");
					String symbol = scstr.next().toUpperCase();
					stockA.buy(shares, symbol);
					break;
					
			case 4: System.out.println("Enter the shares");
					shares = scint.nextInt();
					System.out.println("Enter the Symbol");
					symbol = scstr.next().toUpperCase();
					stockA.sell(shares, symbol);
					break;
					
			case 5: stockA.printreport();
					break;
					
			case 6: value = false;
					break;
					
			default: System.out.println("invalid choice");
		}			
	
	
}
}
}
