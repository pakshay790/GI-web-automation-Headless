package testDrivers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import projlib.Globals;

import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;




public class TestNGCreator 
{

	public void runTestNGTest() throws IOException 
	{
	
			//Create an instance on TestNG
			TestNG myTestNG = new TestNG();

			//Create an instance of XML Suite and assign a name for it.
			XmlSuite mySuite = new XmlSuite();
			mySuite.setName(Globals.SUITE_NAME);

			//Create a list of XmlTests and add the Xmltest you created earlier to it.
			List<XmlTest> myTests = new ArrayList<XmlTest>();

			XSSFSheet excelWSheet = null;
			XSSFWorkbook excelWBook = null;
			XSSFCell cell = null;
			XSSFRow row = null;

			Double dblCellVal;
			String strCellVal = null;
			Boolean blnCellVal;

			FileInputStream excelFile = new FileInputStream(Globals.CONFIG_FILE_DIR);
			excelWBook = new XSSFWorkbook(excelFile);
			//excelWSheet = excelWBook.getSheet(Globals.CONFIG_SHEET_NAME);


			Iterator <Row> rowIterator = excelWSheet.iterator(); 
			//Iterator <Cell> cellIterator = row.cellIterator();
			String testName = null;
			int colCount;

			if (rowIterator.hasNext())
			{
				row = (XSSFRow) rowIterator.next();
				colCount = row.getPhysicalNumberOfCells();
			}
			while (rowIterator.hasNext())
			{
				row = (XSSFRow) rowIterator.next();
				Iterator <Cell> cellIterator = row.cellIterator();
				int curCell = 0;
				while (cellIterator.hasNext())
				{
					cell = (XSSFCell) cellIterator.next();
					curCell++;
					switch (cell.getCellType())
					{
					case Cell.CELL_TYPE_NUMERIC:
						dblCellVal = cell.getNumericCellValue();
						strCellVal = dblCellVal.toString();
						break;
					case Cell.CELL_TYPE_STRING:
						strCellVal = cell.getStringCellValue();
						break;
					case Cell.CELL_TYPE_BOOLEAN:
						blnCellVal = cell.getBooleanCellValue();
						strCellVal = blnCellVal.toString();
						break;
					}

					//If it is first cell then store the Test Name
					if (cell.getColumnIndex()== 0)
					{
						testName = strCellVal;
					}
					
					if (curCell == 5) {
						if (strCellVal.equals("1.0")) {
							//Adding to suite
							//Create an instance of XmlTest and assign a name for it.
							XmlTest myTest = new XmlTest(mySuite);
							myTest.setName(testName);

							//Add any parameters that you want to set to the Test.
							Map<String, String> testngParams = new HashMap<String,String> ();
							testngParams.put("testId", testName);
							myTest.setParameters(testngParams);

							//Create a list which can contain the classes that you want to run.
							List<XmlClass> myClasses = new ArrayList<XmlClass> ();
							myClasses.add(new XmlClass("testDrivers.TestDriver"));

							//Assign that to the XmlTest Object created earlier.
							myTest.setXmlClasses(myClasses);

							//Adding the test to test list created earlier
							myTests.add(myTest);
							break;
							
						}
					}
				}

			}

			excelWBook.close();

			//add the list of tests to your Suite.
			mySuite.setTests(myTests);

			//Add the suite to the list of suites.
			List<XmlSuite> mySuites = new ArrayList<XmlSuite>();
			mySuites.add(mySuite);

			//Set the list of Suites to the testNG object you created earlier.
			myTestNG.setXmlSuites(mySuites);

			File file = new File(Globals.TESTNG_FILE_NAME);
			System.out.println("File is: " + file);

			FileWriter writer = new FileWriter(file);
			writer.write(mySuite.toXml());
			writer.close();

			//invoke run() - this will run your class.
			//myTestNG.run();

			


	}
	public static void main(String args[]) throws IOException
	{
		TestNGCreator testDriver = new TestNGCreator();
		testDriver.runTestNGTest();
	}
}
