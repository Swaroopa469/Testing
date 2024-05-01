package utilities;

import java.lang.reflect.Method;
import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import basetest.BaseTest;

public class DataUtil extends BaseTest {
	@DataProvider(name = "dp1")
	public Object[][] getData2(Method m) {

		String sheetName = m.getName();

		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);

		Object[][] data = new Object[rows - 1][cols];

		for (int rowNum = 2; rowNum <= rows; rowNum++) {
			for (int colNum = 0; colNum < cols; colNum++) {
				data[rowNum - 2][colNum] = excel.getCellData(sheetName, colNum, rowNum);
			}
		}
		return data;
	}

		
	@DataProvider(name = "dp")
	public Object[][] getData(Method m) {

		String sheetName = m.getName();
		int rows = excel.getRowCount(sheetName);
		System.out.println("Rows :" +rows);
		int cols = excel.getColumnCount(sheetName);
		System.out.println("cols :" +cols);
		Object[][] data = new Object[rows - 1][1];
		Hashtable<String, String> table = null;

		for (int rowNum = 2; rowNum <= rows; rowNum++) { // 2
			table = new Hashtable<String, String>();

			for (int colNum = 0; colNum < cols; colNum++) {

				// data[0][0]
				table.put(excel.getCellData(sheetName, colNum, 1), excel.getCellData(sheetName, colNum, rowNum));
				data[rowNum - 2][0] = table;
			}
		}
		return data;
	}
}



//DataFormatter dataFormatter = new DataFormatter(java.util.Locale.US);
//FormulaEvaluator formulaEvaluator = workbook.getCreationHelper().createFormulaEvaluator();
//String value=dataFormatter.formatCellValue(cell,formulaEvaluator);

