package game;

import java.util.TreeSet;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ExcelParser implements Parsing{


	
final static String filePath = "src\\main\\resources\\city.xls";
	
	

	public TreeSet<String> parse(Object obj) {
		TreeSet<String> table = new TreeSet<String>();
		try {
			FileInputStream file = new FileInputStream(new File(filePath));
			HSSFWorkbook workbook = new HSSFWorkbook(file);
			HSSFSheet sheet = workbook.getSheetAt(0);
			
			HSSFRow currentRow = null;
			HSSFCell currentCell = null;
			int currentRowNumber = 0; 
			int currentCellNumber = 0;
			int rowNumber = 1; 
								
			while ((currentRow = sheet.getRow(currentRowNumber)) != null) {
				
								
				table.add(currentRow.getCell(currentCellNumber).toString());
				currentRowNumber++;
				currentCellNumber = 0;
				rowNumber++;
			}
			
			
		
			file.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return table;
	}
	


}
