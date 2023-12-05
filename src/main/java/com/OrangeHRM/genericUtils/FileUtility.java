package com.OrangeHRM.genericUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	public String getPropertyKayAndValue(String key) throws IOException {
		FileInputStream fis = new FileInputStream("");
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value; 
		}
}
