package utilities;

import java.util.Iterator;

import basetest.BaseTest;

public class SetExcel extends BaseTest {
	
	public static void Notexecuted() {
	int count = excel.getRowCount("Sheet1");
	System.out.println("Total Rows :" + count);
		  for (int i = 2; i <= count; i++) { 
		  excel.setCellData("Sheet1","Automation Result", i, "Not Executed"); 
		  }	 
	}

}