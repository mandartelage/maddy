package neoStoxBase1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class howToReadProperty {

	public static void main(String[] args) throws IOException {
		
		
//create object of properties class
	
		Properties prop=new Properties();
		
		 //Created object of fileInputStream pass property file location (path)
		FileInputStream myfile =new FileInputStream("C:\\Users\\manda\\eclipse-workspace\\new\\src\\property.properties");
		// for the loading the file  in the  eclipse memory we use  load method and load method belong to property class
		prop.load(myfile);
		
		String value = prop.getProperty("url");
		System.out.println(value);
		
		
		
	}

	

	

}
