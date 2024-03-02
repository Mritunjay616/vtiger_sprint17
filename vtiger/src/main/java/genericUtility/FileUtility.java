package genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class has generic method to fetch data from property file
 * @author Mritunjay
 * 
 */

public class FileUtility {
	
	public String fetchDataFromPropertyFile(String key) throws IOException {
		/**
		 * This method fetches data from property file
		 * @param key
		 * @return
		 * @throws IOException
		 */
		FileInputStream fis=new FileInputStream(IPathConstant.PROPERTY_FILE_PATH);
		Properties prop = new Properties();
		prop.load(fis);
		return prop.getProperty(key);
	}
}
