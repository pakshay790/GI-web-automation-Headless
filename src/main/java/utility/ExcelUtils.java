package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import projlib.Globals;

public class ExcelUtils {
	public static List readExcelData(String file, String sheetName, int colCount) throws Exception {
		String rowData = "";
		FileInputStream fis = null;
		XSSFWorkbook wkbk = null;
		XSSFSheet sheet = null;
		int rowNum = 0;
		Integer intRowNum = 0;
		String strRowNum = "";
		int cellIndex = 0;
		XSSFRow row = null;
		XSSFCell cell = null;
		String strCellVal = "";
		Boolean blnCellVal = false;
		boolean rowFound = false;
		List<String> s = new ArrayList<>();
		//String[] s = new String[] {};
		int rowCount = 0;

		try {
			fis = new FileInputStream(file);
			wkbk = new XSSFWorkbook(fis);
			sheet = wkbk.getSheet(sheetName);
			Iterator<Row> rowIterator = sheet.iterator();

			while (rowIterator.hasNext()) {

				row = (XSSFRow) rowIterator.next();
				rowNum = row.getRowNum();

				if (rowNum == 0) {
					continue;
				}
				
				intRowNum = (Integer) rowNum;
				strRowNum = intRowNum.toString();
				rowData = "";

				cellIndex = 0;
				Iterator<Cell> cellIterator = row.cellIterator();
				int i = 0;
				for (i = 0; i < colCount; i++) {
					cell = row.getCell(i);
					if (cell != null) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							// dblCellVal = cell.getNumericCellValue();
							// strCellVal = dblCellVal.toString();
							cell.setCellType(Cell.CELL_TYPE_STRING);
							strCellVal = cell.getStringCellValue();
							break;
						case Cell.CELL_TYPE_STRING:
							strCellVal = cell.getStringCellValue();
							break;
						case Cell.CELL_TYPE_BOOLEAN:
							blnCellVal = cell.getBooleanCellValue();
							strCellVal = blnCellVal.toString();
							break;
						case Cell.CELL_TYPE_BLANK:
							cell.setCellType(Cell.CELL_TYPE_STRING);
							strCellVal = cell.getStringCellValue();
							break;
						}
					} else {
						strCellVal = "";
					}

					if ((i == 0)) {
						if (strCellVal.equals("1")) {
							rowFound = true;
							rowData = rowData + strCellVal;
						} else {
							rowFound = false;
							break;
						}

					} else {
						rowData = rowData + "|" + strCellVal;
					}
					// cellIndex++;
				}
				if (rowFound) {
					//s[rowCount] = rowData;
					rowData += "|" + strRowNum;
					s.add(rowData);
					//rowCount++;
				}
			}

		} finally {
			if (wkbk != null) {
				wkbk.close();
			}

			if (fis != null) {
				fis.close();
			}
		}

		return s;
	}

	public static HashMap readToHashMap(String file, String sheetName, String key, int colCount) {
		String rowData = "";
		String hdrRowData = "";
		//FileInputStream fis = null;
		XSSFWorkbook wkbk = null;
		XSSFSheet sheet = null;
		int rowNum = 0;
		Integer intRowNum = 0;
		String strRowNum = "";
		int cellIndex = 0;
		XSSFRow row = null;
		XSSFCell cell = null;
		String strCellVal = "";
		Boolean blnCellVal = false;
		double numCellVal = 0;
		boolean rowFound = false;
		HashMap<String, String> hMap = new HashMap<String, String>();

		try {
			//fis = new FileInputStream(file);
			wkbk = new XSSFWorkbook(file);
			sheet = wkbk.getSheet(sheetName);
			Iterator<Row> rowIterator = sheet.iterator();

			while (rowIterator.hasNext()) {

				row = (XSSFRow) rowIterator.next();
				rowNum = row.getRowNum();

				/*if (rowNum == 0) {
					continue;
				}*/
				intRowNum = (Integer) rowNum;
				strRowNum = intRowNum.toString();
				rowData = "";

				cellIndex = 0;
				Iterator<Cell> cellIterator = row.cellIterator();
				int i = 0;
				for (i = 0; i < colCount; i++) {
					cell = row.getCell(i);
					if (cell != null) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							// dblCellVal = cell.getNumericCellValue();
							// strCellVal = dblCellVal.toString();
							cell.setCellType(Cell.CELL_TYPE_STRING);
							strCellVal = cell.getStringCellValue();
							break;
						case Cell.CELL_TYPE_STRING:
							strCellVal = cell.getStringCellValue();
							break;
						case Cell.CELL_TYPE_BOOLEAN:
							blnCellVal = cell.getBooleanCellValue();
							strCellVal = blnCellVal.toString();
							break;
						case Cell.CELL_TYPE_BLANK:
							cell.setCellType(Cell.CELL_TYPE_STRING);
							strCellVal = cell.getStringCellValue();
							break;
						}
					} else {
						strCellVal = "";
					}
					if (rowNum == 0) { // Checking for hdr row
						if (i == 0) {
							hdrRowData = hdrRowData + strCellVal;	
						} else {
							hdrRowData = hdrRowData + "|" + strCellVal;
						}
						
					} else {
						if ((i == 0)) {
							if (strCellVal.equals(key)) {
								rowFound = true;
								rowData = rowData + strCellVal;
							} else {
								rowFound = false;
								break;
							}

						} else {
							rowData = rowData + "|" + strCellVal;
						}
					}
					// cellIndex++;
				}
				if (rowFound) {
					break;
				}
			}
			String[] hdrArr = hdrRowData.split("\\|");
			String[] rowArr = rowData.split("\\|");
			
			for (int i = 0; i < hdrArr.length; i++) {
				hMap.put(hdrArr[i], rowArr[i]);
			}

		} 
		catch (Exception e) {
			e.printStackTrace();
		} 
		//return rowData + "|" + strRowNum;
		return hMap;
	}

	public static String readExcelRowWithKeyVal(String file, String sheetName, String key, int colCount) {
		String rowData = "";
		//FileInputStream fis = null;
		XSSFWorkbook wkbk = null;
		XSSFSheet sheet = null;
		int rowNum = 0;
		Integer intRowNum = 0;
		String strRowNum = "";
		int cellIndex = 0;
		XSSFRow row = null;
		XSSFCell cell = null;
		String strCellVal = "";
		Boolean blnCellVal = false;
		double numCellVal = 0;
		boolean rowFound = false;

		try {
			//fis = new FileInputStream(file);
			wkbk = new XSSFWorkbook(file);
			sheet = wkbk.getSheet(sheetName);
			Iterator<Row> rowIterator = sheet.iterator();

			while (rowIterator.hasNext()) {

				row = (XSSFRow) rowIterator.next();
				rowNum = row.getRowNum();

				if (rowNum == 0) {
					continue;
				}
				intRowNum = (Integer) rowNum;
				strRowNum = intRowNum.toString();
				rowData = "";

				cellIndex = 0;
				Iterator<Cell> cellIterator = row.cellIterator();
				int i = 0;
				for (i = 0; i < colCount; i++) {
					cell = row.getCell(i);
					if (cell != null) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							// dblCellVal = cell.getNumericCellValue();
							// strCellVal = dblCellVal.toString();
							cell.setCellType(Cell.CELL_TYPE_STRING);
							strCellVal = cell.getStringCellValue();
							break;
						case Cell.CELL_TYPE_STRING:
							strCellVal = cell.getStringCellValue();
							break;
						case Cell.CELL_TYPE_BOOLEAN:
							blnCellVal = cell.getBooleanCellValue();
							strCellVal = blnCellVal.toString();
							break;
						case Cell.CELL_TYPE_BLANK:
							cell.setCellType(Cell.CELL_TYPE_STRING);
							strCellVal = cell.getStringCellValue();
							break;
						}
					} else {
						strCellVal = "";
					}

					if ((i == 0)) {
						if (strCellVal.equals(key)) {
							rowFound = true;
							rowData = rowData + strCellVal;
						} else {
							rowFound = false;
							break;
						}

					} else {
						rowData = rowData + "|" + strCellVal;
					}
					// cellIndex++;
				}
				if (rowFound) {
					break;
				}
			}

		} 
		catch (Exception e) {
			e.printStackTrace();
		} 
		return rowData + "|" + strRowNum;
	}

	public static String getCellData(String file, String sheetName, int rowNum, int colNum) throws Exception {
		FileInputStream fis = null;
		XSSFWorkbook wkbk = null;
		XSSFSheet sheet = null;
		XSSFCell cell = null;
		String cellData = "";
		String strCellVal = "";
		Boolean blnCellVal = false;

		try {
			fis = new FileInputStream(file);
			wkbk = new XSSFWorkbook(fis);
			sheet = wkbk.getSheet(sheetName);
			cell = sheet.getRow(rowNum).getCell(colNum);

			switch (cell.getCellType()) {
			case Cell.CELL_TYPE_NUMERIC:
				// dblCellVal = cell.getNumericCellValue();
				// strCellVal = dblCellVal.toString();
				cell.setCellType(Cell.CELL_TYPE_STRING);
				strCellVal = cell.getStringCellValue();
				break;
			case Cell.CELL_TYPE_STRING:
				strCellVal = cell.getStringCellValue();
				break;
			case Cell.CELL_TYPE_BOOLEAN:
				blnCellVal = cell.getBooleanCellValue();
				strCellVal = blnCellVal.toString();
				break;
			}

			cellData = cell.getStringCellValue();

		} finally {
			if (wkbk != null) {
				wkbk.close();
			}

			if (fis != null) {
				fis.close();
			}
		}

		return cellData;
	}

	public static void setCellData(String setData, String file, int rowNum, int colNum, String sheetName) throws Exception {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		XSSFWorkbook wkbk = null;
		XSSFSheet sheet = null;
		XSSFRow row = null;
		XSSFCell cell = null;
		String cellData = "";
		String strCellVal = "";
		Boolean blnCellVal = false;

		try {
			fis = new FileInputStream(file);
			wkbk = new XSSFWorkbook(fis);
			sheet = wkbk.getSheet(sheetName);
			row = sheet.getRow(rowNum);
			cell = row.getCell(colNum, MissingCellPolicy.RETURN_BLANK_AS_NULL);

			if (cell == null) {
				cell = row.createCell(colNum);
			}

			cell.setCellValue(setData);
			cell.getColumnIndex();
			cell.getStringCellValue();
			fis.close();

			// Constant variables Test Data path and Test Data file name
			fos = new FileOutputStream(file);
			wkbk.write(fos);

			fos.flush();
			wkbk.close();
			fos.close();

		} finally {
			if (wkbk != null) {
				wkbk.close();
			}

			if (fis != null) {
				fis.close();
			}

			if (fos != null) {
				fos.close();
			}

		}
	}	

	public static String setCellDataWithKeyVal(String file, String sheetName, String key, int colCount, 
			int keyValCol, int setCol, String setVal) throws Exception {
		FileInputStream fis = null;
		FileOutputStream fos = null;

		String rowData = "";
		XSSFWorkbook wkbk = null;
		XSSFSheet sheet = null;
		int rowNum = 0;
		Integer intRowNum = 0;
		String strRowNum = "";
		int cellIndex = 0;
		XSSFRow row = null;
		XSSFCell cell = null;
		String strCellVal = "";
		Boolean blnCellVal = false;
		double numCellVal = 0;
		boolean rowFound = false;

		try {
			fis = new FileInputStream(file);
			wkbk = new XSSFWorkbook(fis);
			sheet = wkbk.getSheet(sheetName);
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {
				row = (XSSFRow) rowIterator.next();
				rowNum = row.getRowNum();
				if (rowNum == 0) {
					continue;
				}
				intRowNum = (Integer) rowNum;
				strRowNum = intRowNum.toString();
				rowData = "";

				cellIndex = 0;
				Iterator<Cell> cellIterator = row.cellIterator();
				int i = 0;
				for (i = 0; i < colCount; i++) {
					cell = row.getCell(i);
					if (cell != null) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							// dblCellVal = cell.getNumericCellValue();
							// strCellVal = dblCellVal.toString();
							cell.setCellType(Cell.CELL_TYPE_STRING);
							strCellVal = cell.getStringCellValue();
							break;
						case Cell.CELL_TYPE_STRING:
							strCellVal = cell.getStringCellValue();
							break;
						case Cell.CELL_TYPE_BOOLEAN:
							blnCellVal = cell.getBooleanCellValue();
							strCellVal = blnCellVal.toString();
							break;
						case Cell.CELL_TYPE_BLANK:
							cell.setCellType(Cell.CELL_TYPE_STRING);
							strCellVal = cell.getStringCellValue();
							break;
						}
					} else {
						strCellVal = "";
					}
					if ((i == keyValCol)) {
						if (strCellVal.equals(key)) {
							rowFound = true;
							rowData = rowData + strCellVal;
							cell = row.getCell(setCol, MissingCellPolicy.RETURN_BLANK_AS_NULL);
							if (cell == null) {
								cell = row.createCell(setCol);
							}
							cell.setCellValue(setVal);
							cell.getColumnIndex();
							cell.getStringCellValue();
						} else {
							rowFound = false;
							//break;
						}
						break;

					} else {
						rowData = rowData + "|" + strCellVal;
					}
				}
				if (rowFound) {
					fis.close();
					fos = new FileOutputStream(file);
					wkbk.write(fos);
					fos.flush();
					wkbk.close();
					fos.close();
					break;
				}
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
			if (wkbk != null) {
				wkbk.close();
			}

			if (fos != null) {
				fos.close();
			}
			
		}
		return rowData + "|" + strRowNum;
	}

}
