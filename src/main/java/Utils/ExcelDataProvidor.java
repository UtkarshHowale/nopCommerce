package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ExcelDataProvidor {

	@DataProvider(name = "TestData")
	public Object[][] getData(Method m) throws IOException {

		String excelSheetName = m.getName();
		File file = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\TestData.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workbook = WorkbookFactory.create(fileInputStream);
		Sheet sheetName = workbook.getSheet(excelSheetName);

		int totalRows = sheetName.getLastRowNum();
		Row rowCells = sheetName.getRow(0);
		int totalColumns = rowCells.getLastCellNum();

		DataFormatter dataFormatter = new DataFormatter();
		String testData[][] = new String[totalRows][totalColumns];

		for (int row = 1; row <= totalRows; row++) {

			for (int col = 0; col < totalColumns; col++) {

				testData[row - 1][col] = dataFormatter.formatCellValue(sheetName.getRow(row).getCell(col));
			}
		}

		return testData;
	}
}
