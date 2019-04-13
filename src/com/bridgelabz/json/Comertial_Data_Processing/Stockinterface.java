package com.bridgelabz.json.Comertial_Data_Processing;

import java.util.List;

public interface Stockinterface {
	
	public double valueoff();
	void buy(int amounr ,String symbol);
	void sell(int amounr ,String symbol);
	void printreport();
	void save(String fileName, List<Customer> customerList);
	
}
