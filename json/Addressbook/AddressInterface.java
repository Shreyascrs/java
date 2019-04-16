package com.bridgelabz.json.Addressbook;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author Shreyas CR
 * @date 13/4/2019
 *
 */

public interface AddressInterface {

public static ObjectMapper objM = new ObjectMapper();
	
	public static File getPathOfFile(String fileName, String fileExtension)	// java 8 functionality to give a method body if it is static
	{
		fileName = "/home/admin1/eclipse-workspace/jsonfiles/"
				+ fileName + fileExtension;
		
		File file = new File(fileName);
		
		return file;
	}
	
	
	public static void saveFile(File file)
	{
		List<Person> updatedList =FileSystem.getList();
		try {
			objM.writerWithDefaultPrettyPrinter().writeValue(file, updatedList);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void readFile(File file)			// 
	{
		try 
		{
			FileSystem.setList(objM.readValue(file, new TypeReference<List<Person>>() {}));
		} 
		catch (IOException e) 
		{
			System.out.println("\nFile Not Found!\n");
		}
	}
}
