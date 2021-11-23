package projlib;

import java.util.Properties;

import gtlib.Genlib;

public class Globals 
{
	
	static Properties prop = Genlib.readConfig("config.properties");
	
	public static final String LOGIN_URL = prop.getProperty("loginUrl");
	public static final String TESTS_ROOT = prop.getProperty("testsRoot");
	public static final String CONFIG_FILE_DIR = prop.getProperty("configFileDir");
	public static final String RESULT_FILE_DIR = prop.getProperty("resultFileDir");
	public static final String DEP_FILE_DIR = prop.getProperty("depFileDir");
	public static final String DATA_FILE_DIR = prop.getProperty("dataFileDir");
	public static final String CHROME_DRIVER_PATH = prop.getProperty("chromeDriver");
	public static final String CHROME_DATA_DIR = prop.getProperty("chromeDataDir");
	public static final String IE_DRIVER_PATH = prop.getProperty("ieDriver");
	public static final String FIREFOX_DRIVER_PATH = prop.getProperty("firefoxDriver");
	public static final String SUITE_NAME = prop.getProperty("suiteName");
	public static final String TESTNG_FILE_NAME = prop.getProperty("testNGFileName");
	public static final String BROWSER = prop.getProperty("browser");
	public static final String SCREENSHOT_DIR = prop.getProperty("screenshot");
	public static final String LOG4J_FILE = prop.getProperty("log4j");
	public static final String FAIL = "F";
	public static final String PASS = "P";
	public static final String EXCEPTION = "E";
	//public static final String PROG_FILEUPLOAD = "C:\\Software Setup\\AutoIT\\File Upload.exe"; 
	public static final String PROG_FILEUPLOAD = prop.getProperty("fileUpload");
	public static final String EXTENT_REPORT = prop.getProperty("extentReport");
	
	static Properties sysMsgProp = Genlib.readConfig("SystemMessages.properties");
	public static final String LAND_DELETE_SUCCESS = sysMsgProp.getProperty("landDeletedSuccess");
	public static final String LAND_ADD_SUCCESS = sysMsgProp.getProperty("landAddSuccess");
	public static final String DUP_LAND_ADDED = sysMsgProp.getProperty("dupLandAdd");
	public static final String FREG_ENDDATE_SUCCESS = sysMsgProp.getProperty("fRegEndDateSuccess");
	public static final String FSEASON_NOTACTIVE_SUCCESS = sysMsgProp.getProperty("fSeasonNotActiveSuccess");
	public static final String FARMER_NAME = sysMsgProp.getProperty("farmerName");
	public static final String FARMER_GENDER = sysMsgProp.getProperty("farmerGender");
	public static final String FARMER_MOBILE = sysMsgProp.getProperty("farmerMobile");
	public static final String FARMER_PINCODE = sysMsgProp.getProperty("farmerPincode");
	public static final String FARMER_VILLAGE = sysMsgProp.getProperty("farmerVillage");
	public static final String FARMER_IDPROOFTYPE = sysMsgProp.getProperty("farmerIdProofType");
	public static final String FARMER_ACNAME = sysMsgProp.getProperty("farmerAcName");
	public static final String FARMER_BANKAC = sysMsgProp.getProperty("farmerBankAc");
	public static final String FARMER_BANKNAME = sysMsgProp.getProperty("farmerBankName");
	public static final String FARMER_VOTERID = sysMsgProp.getProperty("farmerVoterId");
	public static final String FARMER_REGSUCCESS = sysMsgProp.getProperty("farmerRegSuccess");
	public static final String FARMER_MODSUCCESS = sysMsgProp.getProperty("farmerModSuccess");
	public static final String LOT_ENTRY_SUCCESS = sysMsgProp.getProperty("lotEntrySuccess");
	public static final String DUP_LOT_ENTRY_SUCCESS = sysMsgProp.getProperty("duplicateLotEntrySucess");
	public static final String FARMER_QUAN_EXCESS = sysMsgProp.getProperty("farmerQuanExcess");
	public static final String CENTER_CODE_REQUIRE = sysMsgProp.getProperty("centerCodeRequire");
	public static final String COMM_UPDATE_SUCESS = sysMsgProp.getProperty("commUpdateSucess");
	public static final String SEL_COMM_CODE = sysMsgProp.getProperty("selCommodityCode");
	public static final String BAG_TYPE_REQUIRED = sysMsgProp.getProperty("bagTypeRequired");
	public static final String BAG_VAL_NOT_ZERO = sysMsgProp.getProperty("bagValCannotZero");
	public static final String QUAN_REQUIRED = sysMsgProp.getProperty("quantityRequired");
	public static final String SESS_ID_REQUIRED = sysMsgProp.getProperty("seasonIdRequired");
	public static final String MOISTURE_REQUIRED = sysMsgProp.getProperty("moistureRequired");
	public static final String BROKEN_REQUIRED = sysMsgProp.getProperty("brokenRequired");
	public static final String BILL_NO_REQUIRED = sysMsgProp.getProperty("billNoRequired");
	public static final String PRE_REJECTION_SUCCESS = sysMsgProp.getProperty("preRejectionSuccess");
	public static final String SCHEDULE_GEN_SUCCESS = sysMsgProp.getProperty("scheduleSuccess");
	public static final String LAND_SUCCESS_APPRVL = sysMsgProp.getProperty("landSuccessApprvl");
	public static final String LAND_DELETE_SUCCESS_APPRVL = sysMsgProp.getProperty("landDeleteSuccessApprvl");
	public static final String LAND_MOD_SUCCESS = sysMsgProp.getProperty("landUpdateSuccess");
	public static final String FBASIC_MOD_SEASON_NOT_ACIVE = sysMsgProp.getProperty("fBasicModSeasonNotActive");
	public static final String CROP_DEL_SEASON_NOT_ACTIVE = sysMsgProp.getProperty("cropDelSeasonNotActive");
	public static final String STATE_COMM_SUCCESS = sysMsgProp.getProperty("stateCommSuccess");
	public static final String SCH_DATE_WITHIN_SEA_START_END_DATE = sysMsgProp.getProperty("scheduleSeasonNotActive");
	public static final String CENTER_COMM_DATE_SUCCESS = sysMsgProp.getProperty("centerCommDateSuccess");
	public static final String LAND_MOD_APPROVAL = sysMsgProp.getProperty("landModifyApproval");
	public static final String CROP_MOD_SEASON_NOT_ACTIVE = sysMsgProp.getProperty("cropModSeasonNotActive");
	public static final String CROP_MOD_SEASON_END = sysMsgProp.getProperty("cropModSeasonEnd");

	
/*	static Properties sysMsgProp = Genlib.readConfig("SystemMessages.properties");
	public static final String LAND_ADD_SUCCESS = sysMsgProp.getProperty("landAddSuccess");
	public static final String DUP_LAND_ADDED = sysMsgProp.getProperty("dupLandAdd");
	public static final String FREG_ENDDATE_SUCCESS = sysMsgProp.getProperty("fRegEndDateSuccess");
	public static final String FSEASON_NOTACTIVE_SUCCESS = sysMsgProp.getProperty("fSeasonNotActiveSuccess");
	public static final String FARMER_NAME = sysMsgProp.getProperty("farmerName");
	public static final String FARMER_GENDER = sysMsgProp.getProperty("farmerGender");
	public static final String FARMER_MOBILE = sysMsgProp.getProperty("farmerMobile");
	public static final String FARMER_PINCODE = sysMsgProp.getProperty("farmerPincode");
	public static final String FARMER_VILLAGE = sysMsgProp.getProperty("farmerVillage");
	public static final String FARMER_IDPROOFTYPE = sysMsgProp.getProperty("farmerIdProofType");
	public static final String FARMER_ACNAME = sysMsgProp.getProperty("farmerAcName");
	public static final String FARMER_BANKAC = sysMsgProp.getProperty("farmerBankAc");
	public static final String FARMER_BANKNAME = sysMsgProp.getProperty("farmerBankName");
	public static final String FARMER_VOTERID = sysMsgProp.getProperty("farmerVoterId");
	public static final String FARMER_REGSUCCESS = sysMsgProp.getProperty("farmerRegSuccess");
	public static final String FARMER_MODSUCCESS = sysMsgProp.getProperty("farmerModSuccess");
	
	public static final String LOT_ENTRY_SUCCESS = sysMsgProp.getProperty("lotEntrySuccess");
	public static final String DUP_LOT_ENTRY_SUCCESS = sysMsgProp.getProperty("duplicateLotEntrySucess");
	public static final String FARMER_QUAN_EXCESS = sysMsgProp.getProperty("farmerQuanExcess");
	public static final String CENTER_CODE_REQUIRE = sysMsgProp.getProperty("centerCodeRequire");
	public static final String COMM_UPDATE_SUCESS = sysMsgProp.getProperty("commUpdateSucess");
	public static final String SEL_COMM_CODE = sysMsgProp.getProperty("selCommodityCode");
	public static final String BAG_TYPE_REQUIRED = sysMsgProp.getProperty("bagTypeRequired");
	public static final String BAG_VAL_NOT_ZERO = sysMsgProp.getProperty("bagValCannotZero");
	public static final String QUAN_REQUIRED = sysMsgProp.getProperty("quantityRequired");
	public static final String SESS_ID_REQUIRED = sysMsgProp.getProperty("seasonIdRequired");
	public static final String MOISTURE_REQUIRED = sysMsgProp.getProperty("moistureRequired");
	public static final String BROKEN_REQUIRED = sysMsgProp.getProperty("brokenRequired");
	public static final String BILL_NO_REQUIRED = sysMsgProp.getProperty("billNoRequired");
	public static final String PRE_REJECTION_SUCCESS = sysMsgProp.getProperty("preRejectionSuccess");*/

	
	
	static Properties logMsgProp = Genlib.readConfig("LogMessages.properties");
	
}
