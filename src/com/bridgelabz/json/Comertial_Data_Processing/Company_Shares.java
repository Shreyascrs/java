package com.bridgelabz.json.Comertial_Data_Processing;

public class Company_Shares {
	private String company_name;
	private String Company_Symbol;
	private int no_of_Shares;
	private int price;
	private String date;
	
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getCompany_Symbol() {
		return Company_Symbol;
	}
	public void setCompany_Symbol(String company_Symbol) {
		this.Company_Symbol = company_Symbol;
	}
	public int getNo_of_Shares() {
		return no_of_Shares;
	}
	public void setNo_of_Shares(int no_of_Shares) {
		this.no_of_Shares = no_of_Shares;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Company_Shares [company_name=" + company_name + ", Company_Symbol=" + Company_Symbol + ", no_of_Shares="
				+ no_of_Shares + ", price=" + price + ", date=" + date + "]";
	}
	
}
