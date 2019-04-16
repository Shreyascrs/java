package com.bridgelabz.json.Addressbook;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * 
 * @author shreyas
 * @date 13/4/2019
 *
 */
public class FileSystem {
	public static List<Person> personList = null;	//creating person list
	public static ObjectMapper objM = new ObjectMapper();	
	
	public static void setList(List<Person> personList) 
	{
		FileSystem.personList = personList;
	}
	
	public static List<Person> getList()
	{
		return personList;
	}
	/**
	 * to create a new file
	 * @param fileName
	 * @param fileExtension
	 * @return
	 */
	
	public static File createNewFile(String fileName, String fileExtension)
	{
		File file = AddressInterface.getPathOfFile(fileName, fileExtension);
		try {
			@SuppressWarnings({ "unused", "resource" })
			FileWriter newFileWritten = new FileWriter(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return file;
}
}
