package com.assignment.base;

import java.io.FileInputStream;
import java.util.Properties;

public class testBase {
	public Properties CON;
	public Properties OR;
	FileInputStream Fis = null;

	public void initFile() {
		if (CON == null) {
			try {

				CON = new Properties();
				Fis = new FileInputStream(System.getProperty("user.dir")
						+ "\\src\\test\\java\\com\\assignment\\resources\\project.properties");
				CON.load(Fis);

				OR = new Properties();
				Fis = new FileInputStream(System.getProperty("user.dir")
						+ "\\src\\test\\java\\com\\assignment\\resources\\or.properties");
				OR.load(Fis);

			} catch (Throwable t) {
				System.out.println("Error occurred while loading property files " + t.fillInStackTrace());
			}
		}
	}

}
