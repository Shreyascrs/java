package com.bridgelabz.json.Comertial_Data_Processing;

import java.util.List;
import java.util.Scanner;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

public class StockUtility {
	
	static ObjectMapper mapper=new ObjectMapper();
	
	public static void addAccount(String filename)
	{
		String filepath="/home/admin1/Desktop/projects/Bridgelabzprograms/"+filename;
		
		Scanner scan=new Scanner(System.in);
		try {
			List<Customer> customerlist=mapper.readValue(filepath,new TypeReference<List<Customer>>() {
			});
			Stockaccount stock=new Stockaccount();
			System.out.println("enter the customer name");
			String custName=scan.next().toUpperCase();
			if(searchCustomerIndex(custName,customerlist)==-1)
			{
				Customer newcustomer=new Customer();
				customerlist.add(newcustomer);
				System.out.println("    new customer added  :  "+custName+"\n");
				
				stock.save(filename,customerlist);
				System.out.printf("\n%-15s %-20s %-20s %-20s\n", "Cust. Name", "Yesbank(Shares)", "IDFC(Shares)", "eichermotor(Shares)");
				System.out.println("-----------------------------------------------------------------------------");
				System.out.println(customerlist.get(searchCustomerIndex(custName, customerlist)).toString());
				
			}
			else {
				System.out.println(" customer already exist ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	
	
	
	public static int searchCustomerIndex(String searchName, List<Customer> customerlist) {
		int count=0;
		int index=-1;
		for (int i = 0; i < customerlist.size(); i++) {
			count=0;
			String custname=customerlist.get(i).getName();
			if(searchName.compareTo(custname)==0)
			{
				index=i;
				break;
			}else
			{
				count++;
			}
		}
		if(count!=0)
		{
			System.out.println("customer not found");
		}
		return index;
	}
	
	
	public static int searchSharebySymbol(String symbol, List<Company_Shares> companyshare) {
		
		int count=0;
		int index=-1;
		for (int i = 0; i < companyshare.size(); i++) {
			count=0;
			String symbol1=companyshare.get(i).getCompany_Symbol();
			if(symbol1.compareTo(symbol)==0)
			{
				index=i;
				break;
			}else
			{
				count++;
			}
		}
		if(count!=0)
		{
			System.out.println("customer not found");
		}
		return index;
		
		
		
	}
	
}
