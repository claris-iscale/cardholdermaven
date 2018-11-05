package CardholderMavenProject;

import org.openqa.selenium.chrome.ChromeDriver;

public class settings {

	public static final int registrationTest = 1;
	public static final int loginTest = 2;
	public static final int orderCardTest1 = 3;
	public static final int accountTest = 3;
/*	public static final int loadByCardTest = 6;*/
	public static final int loadByBankTransfertest = 4;
	public static final int profileTest = 5;
	public static final int statementTest = 6;
	public static final int suspendedTest = 7;
	public static final int unloadTest = 8;
	public static final int orderCardNonEUTest = 9;
	public static final int loadByCardEUTest = 10;
	public static final int loadByCardNonEUTest = 11;
	public static final int orderCardEUTest = 12;
	public static final int orderCardTest = 15;
	
	public static final int pinTest = 13;
	public static final int viewImageTest = 14;
	
	   public boolean skipTest(String testCase) {
		   boolean runTestCase;
		   switch (testCase) {
           case "registrationTest": runTestCase = false; //done - fixed
        	   	break;
           case "loginTest": runTestCase = false;//done
   	   			break;
           case "accountTest": runTestCase = false;//done
   	   			break;  
           case "profileTest": runTestCase = false;//done
	   			break;
           case "loadByBankTransfertest": runTestCase = false;//done
   	   			break; 
           case "suspendedTest": runTestCase = false;//done  -- to fix find not suspended card
	   			break;
           case "pinTest": runTestCase = false;//to fix - done document - need to update data for pin change
	   			break;
           case "statementTest": runTestCase = false;//done
	   			break;
           case "unloadTest": runTestCase = false;//done -- to fix find first card that has available amount
	   			break;
           case "viewImageTest": runTestCase = false;// fixed - 10//11/2018
	   			break;
           case "orderCardEUTest": runTestCase = false; // done- document
  				break;
           case "orderCardNonEUTest": runTestCase = false;// done document -fixed 10/15/2018
  				break;
           case "loadByCardEUTest": runTestCase = false;// to fix - done documented -fixed 10/15/2018
  				break;
           case "loadByCardNonEUTest": runTestCase = true;// to ask lea  // false
  			break;
           case "orderCardTest": runTestCase = false;// done - document - working
 			break;
           case "orderCardTest1": runTestCase = false;//done - document - working
	   			break;
           default:  runTestCase = true;
                    break;
		   }
		   return runTestCase;
		   
	   }
}