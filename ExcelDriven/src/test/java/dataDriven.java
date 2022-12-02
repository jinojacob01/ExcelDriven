import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDriven {

	// TODO Auto-generated method stub
	public ArrayList<String> getData1(String TestcaseName) throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\jino.jacob\\Desktop\\Selenium Test.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int sheetCount = workbook.getNumberOfSheets();
		ArrayList<String> a = new ArrayList<String>();
		for (int i = 0; i < sheetCount; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("testdata")) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				Iterator<Row> rows = sheet.rowIterator(); // sheet is collection of rows
				Row firstRow = rows.next();
				Iterator<Cell> cells = firstRow.cellIterator(); // row is collection of cells
				int k = 0;
				int column = 0;
				while (cells.hasNext()) {
					Cell value = cells.next();
					if (value.getStringCellValue().equalsIgnoreCase("Testcases")) {
						column = k;
					}
					k++;
				}
				System.out.println(column);

				while (rows.hasNext()) {

					Row r = rows.next();
					if (r.getCell(column).getStringCellValue().equalsIgnoreCase(TestcaseName)) {
						Iterator<Cell> c = r.cellIterator();

						while (c.hasNext()) {

							Cell cl = c.next();
							if (cl.getCellType() == CellType.STRING) {
								a.add(cl.getStringCellValue());
							} else {
								a.add(NumberToTextConverter.toText(cl.getNumericCellValue()));
							}
						}
					}
				}
			}

		}
		return a;
	}

	public void getData2() throws IOException {
		System.out.println("--------------------------Printing Values From Second Sheet--------------------------");
		FileInputStream fis = new FileInputStream("C:\\Users\\jino.jacob\\Desktop\\Selenium Test.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int sheetCount = workbook.getNumberOfSheets();
		for (int i = 0; i < sheetCount; i++) {
			XSSFSheet sheet = workbook.getSheetAt(i);
			if (sheet.getSheetName().equalsIgnoreCase("sample")) {
				Iterator<Row> rows = sheet.rowIterator();
				Row firstrow = rows.next();
				Iterator<Cell> cells = firstrow.cellIterator();
				int k = 0;
				int column = 0;
				while (cells.hasNext()) {
					if (cells.next().getStringCellValue().equalsIgnoreCase("Testcases")) {
						column = k;
					}
					k++;
				}
				System.out.println(column);
				while (rows.hasNext()) {
					Row r = rows.next();
					if (r.getCell(column).getStringCellValue().equalsIgnoreCase("Delete Profile")) {
						Iterator<Cell> ci = r.cellIterator();
						while (ci.hasNext()) {
							System.out.println(ci.next().getStringCellValue());
						}

					}

				}
			}

		}

	}

	public static void main(String[] args) throws IOException {

	}
}
