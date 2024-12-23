package genericutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Ashutosh
 */
public class fileUtility {
	
	/** 
	 * *this method will return value from property file
	 * this method takes key as an argument
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String getDataFromproperty(String key) throws IOException
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData/commondata.properties");
		Properties prop = new Properties();
		prop.load(fis);
		return prop.getProperty(key);
		
	}

}
