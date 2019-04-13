package com.bridgelabz.json.Comertial_Data_Processing;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

public class Stockaccount implements Stockinterface  {

		private Customer customer;
		private Company_Shares company_shares;
		
		public static ObjectMapper mapper=new ObjectMapper();
		
		File customerfile=new File("/home/admin1/Desktop/projects/Bridgelabzprograms/input/Customer.json");
		File sharesfile=new File("/home/admin1/Desktop/projects/Bridgelabzprograms/input/Company_Shares.json");
	
		public Stockaccount()
		{
			
		}
		
		
		public Stockaccount(String filename)
		{
			StockUtility.addAccount(filename);
		}
		
		
		
		public void save(String fileName, List<Customer> customerList) {
			try {
				mapper.writerWithDefaultPrettyPrinter().writeValue(new File(fileName), customerList);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public void list()
		{
			
				try {
					List<Company_Shares> companySharesList = mapper.readValue(sharesfile,
							new TypeReference<List<Company_Shares>>() {
							});
					List<Customer> customerList = mapper.readValue(customerfile, new TypeReference<List<Customer>>() {
					});
					
					String str="";
					//List<>abcd=objM.readValue(new File(path),new TypeReference<List<setter>>() {});
					for(int i=0;i<companySharesList.size();i++)
					{
						str=companySharesList.get(i).toString();
						//System.out.println(""+set);
//						ls.add(str);
						
					}
					
					
				
				} catch (IOException e) {
					System.out.println(""+e.getMessage());
					e.printStackTrace();
				}
				}


		@Override
		public double valueoff() {
			Scanner scan=new Scanner(System.in);
			try {
				
				List<Customer> customerlist= mapper.readValue(customerfile, new TypeReference<List<Customer>>() {
				});
				
				List<Company_Shares> companysharelist=mapper.readValue(sharesfile, new TypeReference<List<Company_Shares>>() {
				});
				
				System.out.println("enter the person name ");
				String searchname=scan.next().toUpperCase();
				
				int index=StockUtility.searchCustomerIndex(searchname, customerlist);
				if(index!=-1)
				{
					Customer customer=new Customer();
					customer=customerlist.get(index);
					
					int yesbankshares=companysharelist.get(0).getPrice()*customer.getYesbank();
					int idfcbankshare=companysharelist.get(0).getPrice()*customer.getIdfc();
					int eichermtrshare=companysharelist.get(0).getPrice()*customer.getEichermotor();
					
					int totalvalue=yesbankshares+idfcbankshare+eichermtrshare;
					
					System.out.println("\n total value of stock : ");
					return(double)totalvalue;
				}else
				{
					return -1;
				}
				
			}
			catch(Exception e)
			{
			e.printStackTrace();
			
			}
			return 0;
			
		}

		@Override
		public void buy(int amount, String symbol) {
			Scanner sc=new Scanner(System.in);
			try {
			List<Company_Shares> companySharesList = mapper.readValue(sharesfile,
					new TypeReference<List<Company_Shares>>() {
					});
			List<Customer> customerList = mapper.readValue(customerfile, new TypeReference<List<Customer>>() {
			});
			System.out.println("Enter the person name");

			String searchName = sc.next().toUpperCase();
			int custIndex = StockUtility.searchCustomerIndex(searchName, customerList);
			int stockIndex = StockUtility.searchSharebySymbol(symbol, companySharesList);
			String stackSymbol = null;
			Company_Shares companyShares = null;
			
			if (custIndex != -1) {
				companyShares = companySharesList.get(stockIndex);
				int noOfShares = companyShares.getNo_of_Shares();
				companyShares.setNo_of_Shares(noOfShares - amount);
				stackSymbol = companyShares.getCompany_Symbol();
				

				
				Customer customer = customerList.get(custIndex);
				if (stockIndex == 0) {
					int value = customer.getYesbank();
					customer.setYesbank(value + amount);
				}
				if (stockIndex == 1) {
					int value = customer.getIdfc();
					customer.setIdfc(value + amount);
				}
				if (stockIndex == 2) {
					int value = customer.getEichermotor();
					customer.setEichermotor(value + amount);
				}
			} else {
				System.out.println("stock not found!");
			}
			
			
			
			mapper.writerWithDefaultPrettyPrinter().writeValue(sharesfile, companySharesList);
			mapper.writerWithDefaultPrettyPrinter().writeValue(customerfile, customerList);

			System.out.println("\n----------Stock Details----------");
			System.out.printf("%-15s %-20s %-20s\n", "Company Name", "NO. of Stocks", "Price");
			System.out.println("------------------------------------------------------------------");
			System.out.println(companySharesList.get(stockIndex).toString());

			System.out.printf("\n%-15s %-20s %-20s %-20s\n", "Cust. Name", "Reliance(Shares)", "HDFC(Shares)",
					"ICICI(Shares)");
			System.out.println("-------------------------------------------------------------------");
			System.out.println(customerList.get(custIndex).toString());

			
			}
			catch(Exception e)
			{
				e.printStackTrace();
				
			}
		}

		@Override
		public void sell(int amount, String symbol) {
			
			Scanner sc = new Scanner(System.in);
			try {

				List<Company_Shares> companySharesList = mapper.readValue(sharesfile,
						new TypeReference<List<Company_Shares>>() {
						});
				List<Customer> customerList = mapper.readValue(customerfile, new TypeReference<List<Customer>>() {
				});

				int stockIndex = StockUtility.searchSharebySymbol(symbol, companySharesList);
				System.out.println("Enter the person name");
				String searchName = sc.next().toUpperCase();
				int custIndex = StockUtility.searchCustomerIndex(searchName, customerList);
				String stackSymbol = "";
				Company_Shares companyShares = null;
				if (custIndex != -1) {
					companyShares = companySharesList.get(stockIndex);
					int noOfShares = companyShares.getNo_of_Shares();
					companyShares.setNo_of_Shares(noOfShares + amount);

					System.out.println("");
					stackSymbol = companyShares.getCompany_Symbol();
					// ls.add(companyShares);

					// System.out.println(stockIndex);
					Customer customer = customerList.get(custIndex);
					if (stockIndex == 0) {
						int value = customer.getYesbank();
						customer.setYesbank(value - amount);
					}
					if (stockIndex == 1) {
						int value = customer.getIdfc();
						customer.setIdfc(value - amount);
					}
					if (stockIndex == 2) {
						int value = customer.getEichermotor();
						customer.setEichermotor(value - amount);
					}
				} else {
					System.out.println("stock not found!");
				}

				mapper.writerWithDefaultPrettyPrinter().writeValue(sharesfile, companySharesList);
				mapper.writerWithDefaultPrettyPrinter().writeValue(customerfile, customerList);

				System.out.println("\n----------Stock Details----------");
				System.out.printf("%-15s %-20s %-20s\n", "Company Name", "NO. of Stocks", "Price");
				System.out.println("---------------------------------------------------------------------");
				System.out.println(companySharesList.get(stockIndex).toString());

				System.out.println("\n----------Customer Details----------");
				System.out.printf("\n%-15s %-20s %-20s %-20s\n", "Cust. Name", "Reliance(Shares)", "HDFC(Shares)",
						"ICICI(Shares)");
				System.out.println("----------------------------------------------------------------------");
				System.out.println(customerList.get(custIndex).toString());
			}catch(Exception e)
			{
				e.printStackTrace();
				
			}
		}

		@Override
		public void printreport() {
			
			
			try {

				
				List<Company_Shares> companySharesList=mapper.readValue(sharesfile, new TypeReference<List<Company_Shares>>() {
				} );
				
				List<Customer> customerList = mapper.readValue(customerfile, new TypeReference<List<Customer>>() {
				});

				System.out.println("\n----------Stock Details----------");
				System.out.printf("%-15s %-20s %-20s\n", "Company Name", "NO. of Stocks", "Price");
				System.out.println("-----------------------------------------------------------------");
				for (int i = 0; i < companySharesList.size(); i++) {

					System.out.println(companySharesList.get(i).toString());
				}

				System.out.println("\n----------Customer Details----------");
				System.out.printf("\n%-15s %-20s %-20s %-20s\n", "Cust. Name", "Yesbank(Shares)", "IDFC(Shares)",
						"Eichermotor(Shares)");
				System.out.println("----------------------------------------------------------------------");
				for (int i = 0; i < customerList.size(); i++) {
					System.out.println(customerList.get(i).toString());
				}
				
			} catch (IOException e) {
				System.out.println(""+e.getMessage());
				
			}
			
		}
}
