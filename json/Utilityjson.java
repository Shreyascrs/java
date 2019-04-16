package com.bridgelabz.json;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.bridgelabz.datastructures.Utilityds.*;

public class Utilityjson {
	static ObjectMapper mapper;
	static {
		mapper=new ObjectMapper();
	}
	public static String javatojson(Object object)
	{
		String jsonResult="";
		try {
			jsonResult=mapper.writeValueAsString(object);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonResult;
	}
	public static <T> T jsontojava(String json,Class<T> cls) {
		T result=null;
		try {
			result=mapper.readValue(json, cls);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			System.out.println("error while converting json to java");
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			System.out.println("error while converting json to java");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("error while converting json to java");
		}
		return result;
	}
	public static boolean validate(String phone) {
		 
		
			Pattern p=Pattern.compile("[5-9][0-9]{9}");
			Matcher m=p.matcher(phone);
			return(m.find()&&m.group().equals(phone));
		
	}
	public static class Queue <T>{ 
		int size;
		@SuppressWarnings("hiding")
		class Node<T>{   // creation of node
			T data;
			@SuppressWarnings("rawtypes")
			Node next;
		}
		
		@SuppressWarnings("rawtypes")
		Node front;		//front pointer
		@SuppressWarnings("rawtypes")
		Node rear;		//rear pointer
		
		@SuppressWarnings({ "unchecked", "rawtypes" })
		public  void enqueue(T data)
		{
			
			Node node=new Node(); // new node to add element
			
			node.data=data;  	 //  assigning data to node
			node.next=null;		
			if( rear == null)	//comparing first node wether null or not
			{
				
				front=node;		// assigning first node as front 
				rear=node;		//assigning first node as rear
				size++;
			}
			else		
			{														
				Node n;
				n=front;
				while(n.next!=null)  // iteration to reach last node
				{
					n=n.next;
				}
				n.next=node;
				rear=node;
				
				size++;
			}
			
		}
		
		@SuppressWarnings("rawtypes")
		public void print()						//to print the elements
		{
			Node n=front;
			
			while(n!=null)						// loop to reach the end
			{
				System.out.println(n.data);
				n=n.next;
			}

		}
		
		
		
		@SuppressWarnings({ "rawtypes" })
		public void dequeue()					// method to remove from list
		{
			Node n=front;						//reference of front node
			if(size==0)
			{
				System.out.println("stack empty");
				return;
			}
			{
				System.out.println(n.data);
				n=n.next;
				front=n;
				size--;
			}
			
		}
		
		public boolean isEmpty()				//returns true if it is empty
		{
			if(size==0)							//comparing the size
			{
				return true;
			}else
				return false;
		}
		
		public int size()						//to return the size value
		{
			return size;
		}
		public void deleteall()
		{
			Node n=front;
			Node y=n.next;
			if(n.next==null)
			{
				System.out.println(n.data);
			}
			while(y.next!=null)
			{
				System.out.println(n.data);
				n.next=null;
				n=y;
				y=y.next;
			}
		}
		
	}
	
	
	Queue<String> queue=new Queue<String>();
	
}
