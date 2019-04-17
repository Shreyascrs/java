package com.bridgelabz.json;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.DateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
// the another class is Userinput.java
public class Regex {
	
	public static void main(String[] args) throws Exception {
		Scanner scan=new Scanner(System.in);
		Userinput input=new Userinput();
		String path="/home/admin1/Desktop/input/regexinput.txt";	// path to read the file
		File file=new File(path);
		String data="";
		String name1="";
		String name2="";
		String phone="";
		
		BufferedReader reader=new BufferedReader(new FileReader(file));
		String temp="";
		while((temp=reader.readLine())!=null) {
		data+=temp;
		}
		
		System.out.println("enter the first name");
		
			do {
			name1=scan.next();
			}while(!name1.matches("[a-zA-Z],")); 	// to verify the name
		
		
		input.setFirstname(name1);
		System.out.println("enter the last name");
	
		do {
			name2=scan.next();
			}while(!name1.matches("[a-zA-Z],"));
			
			
	
		input.setLastname(name2);
		System.out.println("enter the mobile number");
		phone=scan.next();
		if(Utilityjson.validate(phone)==true)  // to verify mobile number
		{
		input.setMobileno(scan.next());
		}else
		{
			System.out.println("invalid phone number"); 
		}
		Date date=new Date();
		String dat=DateFormat.getInstance().format(date); 
		input.setDate(dat);
		
		String message = convertstring(input,data);
		System.out.println(message);
		
	}
	/**
	 *  to modify the message and to add name and details
	 * @param input
	 * @param data
	 * @return
	 */
	public static String convertstring(Userinput input,String data) {
		
		Pattern p=Pattern.compile("<<name>>");
		Matcher m=p.matcher(data);
		data=m.replaceAll(input.getFirstname());
		
		p=Pattern.compile("<<full name>>");
		m=p.matcher(data);
		data=m.replaceAll(input.getFirstname()+" "+input.getLastname());
		
		p=Pattern.compile("xxxxxxxxxx");
		m=p.matcher(data);
		data=m.replaceAll(input.getMobileno());
		
		p=Pattern.compile("01/01/2016");
		m=p.matcher(data);
		data=m.replaceAll(input.getDate());
		
		return data;
	}

}
