
package com.bridgelabz.json;

import java.io.File;
import java.io.IOException;

import java.util.Scanner;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
/*
 * @auther	:Shreyas CR
 * @version	:jackson 1x
 * @date	:09/04/2019
 */

public class Inventrymanagement {
public static void main(String[] args)  {
	Scanner scan=new Scanner(System.in);		
							
	String path="/home/admin1/Desktop/input/jsoninput.json";	// source file path contain json data
	ObjectMapper mapper=new ObjectMapper();						// creation of object mapper reference
	File file=new File(path);									// for file reference 
												// for choice in selection of inventry
	int totalValue=0;
	
	try {
		JsonNode jsondata=mapper.readTree(file);				// reading data of json in tree structure

		
		

			 JsonNode inventry = jsondata.findPath("Rice");		// searching for specific data
			 System.out.println(" --------------------------------- Rice -------------------------------");
			 System.out.println();
	for (JsonNode node : inventry) {
			String name=node.findPath("name").asText();				// accessing name value 
	int weight=node.findPath("weight").asInt();				// accessing weight value
	int price=node.findPath("price").asInt();				// accessing price value
	
		System.out.println("name\t:"+name+"\nprice\t:"+price+"\nweight\t:"+weight);//printing the accessed value
		totalValue+=(price*weight);
		
			
		
	}	
	System.out.println("the total value of RICE :"+totalValue);
	totalValue=0;
	 System.out.println(" --------------------------------- pulses --------------------------------");
			 inventry = jsondata.findPath("Pulses");
		for (JsonNode node1 : inventry) {
		String name1=node1.findPath("name").asText();				// accessing name value 
		int weight1=node1.findPath("weight").asInt();				// accessing weight value
		int price1=node1.findPath("price").asInt();				// accessing price value
		
			System.out.println("name\t:"+name1+"\nprice\t:"+price1+"\nweight\t:"+weight1);//printing the accessed value
			totalValue+=(price1*weight1);
			
				
		}
		System.out.println("the total value of pulses :"+totalValue);
		totalValue=0;
		 System.out.println(" --------------------------------- Wheat -------------------------------");
			 inventry = jsondata.findPath("Wheat");
				for (JsonNode node2 : inventry) {
				String name2=node2.findPath("name").asText();				// accessing name value 
				int weight2=node2.findPath("weight").asInt();				// accessing weight value
				int price2=node2.findPath("price").asInt();				// accessing price value
				
					System.out.println("name\t:"+name2+"\nprice\t:"+price2+"\nweight\t:"+weight2);//printing the accessed value
					totalValue+=(price2*weight2);
					
			
				}
				System.out.println("the total value of Wheat "+totalValue);
		
	 
	
	}catch (IOException e) {
		// TODO Auto-generated catch block
		System.out.println("error occured while parsing a file");
	}
	scan.close();
	}
}