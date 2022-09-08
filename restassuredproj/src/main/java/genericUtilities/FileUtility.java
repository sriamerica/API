package genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 
 * @author Admin
 *
 */
public class FileUtility {
	/**
	 * to get the Common data from the property file
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String getPropertyKeyValue(String key) throws IOException {
		FileInputStream fileinputstream = new FileInputStream(IConstants.filePath);
		Properties properties = new Properties();
		properties.load(fileinputstream);
		String value = properties.getProperty(key);
		return value;
	}

}