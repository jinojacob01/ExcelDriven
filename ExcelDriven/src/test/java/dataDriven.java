import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDriven {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fis = new FileInputStream("C:\\Users\\jino.jacob\\Desktop\\Selenium Test.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int sheetCount = workbook.getNumberOfSheets();
		for(int i =0;i<sheetCount;i++) {
			if(workbook.getSheetName(i).equalsIgnoreCase("testdata")) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				Iterator<Row> rows = sheet.rowIterator(); // sheet is collection of rows
				Row firstRow = rows.next();
				Iterator<Cell> cells = firstRow.cellIterator(); // row is collection of cells
				int k = 0;
				int column = 0;
				while(cells.hasNext()) {
					Cell value = cells.next();
					if(value.getStringCellValue().equalsIgnoreCase("Data3")) {
						column = k;
					}
					k++;
				}
				System.out.println(column);
			}

		}

	}

}
