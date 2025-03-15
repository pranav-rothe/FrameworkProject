package utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {

	public static Object[][] getTestDataFromExcel(String sheetName) {
		File path = new File("C:\\Users\\Pranav\\eclipse-workspace\\Pranav_Framework\\TestData\\TestData.xlsx");
		XSSFWorkbook workbook = null;
		try {
			FileInputStream file = new FileInputStream(path);
			workbook = new XSSFWorkbook(file);
		} catch (Exception e) {
			e.printStackTrace();
		}

		XSSFSheet sheet = workbook.getSheet(sheetName);

		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(0).getLastCellNum();

		Object[][] data = new Object[rows][cols];

		// Create DataFormatter instance
		//DataFormatter dataFormatter = new DataFormatter();

		for (int i = 0; i < rows; i++) {

			XSSFRow row = sheet.getRow(i + 1);

			for (int j = 0; j <= cols - 1; j++) {

				XSSFCell cell = row.getCell(j);

//				if (cell != null) {
//					data[i][j] = dataFormatter.formatCellValue(cell);
//				} else {
//					data[i][j] = ""; // Handling null cells explicitly
//				}

				CellType cellType = cell.getCellType();

				switch (cellType) {

				case STRING:
					data[i][j] = cell.getStringCellValue();
					break;
				case NUMERIC:
					data[i][j] = Integer.toString((int) cell.getNumericCellValue());
					break;
				case BOOLEAN:
					data[i][j] = cell.getBooleanCellValue();
					break;

				}

			}

		}

		return data;

	}

}
