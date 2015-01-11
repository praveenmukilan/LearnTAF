package test.resources;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.testng.ISuiteResult;


import org.testng.IReporter;
import org.testng.ITestContext;
import org.testng.xml.XmlSuite;
import org.testng.ISuite;


public class HtmlReporter implements IReporter
{
	
	
	private static FileWriter htmlFile; 
  public static String now(String dateFormat)
  {
    Calendar cal = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
    return sdf.format(cal.getTime());
  }
  
  public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory){
	  
	  try{
		  
		  String html_report_file_name = Constants.resultsFolder+"HTML_Report.html";
		  htmlFile = new FileWriter(html_report_file_name);
		  htmlFile.write("<html><head>Automation Report</head>");
	  //Iterating over each suite included in the test
      for (ISuite suite : suites) {
          //Following code gets the suite name
          String suiteName = suite.getName();
	    //Getting the results for the said suite
	    Map<String,ISuiteResult> suiteResults = suite.getResults();
	    for (ISuiteResult sr : suiteResults.values()) {
	        ITestContext tc = sr.getTestContext();
	      
	        int passCount = tc.getPassedTests().getAllResults().size();
	        int failCount = tc.getFailedTests().getAllResults().size();
	        int skipCount =  tc.getSkippedTests().getAllResults().size();
	      Html_Test_Summary(now("yyyymmdd"), Constants.resultsFolder, suiteName, passCount, failCount, skipCount);  		
	
	      
	         
	      }
	    
	  
	    
	    htmlFile.write("</body> </html>");
	    htmlFile.flush();
	    htmlFile.close();
	    
	    
	    
      }
	  }catch(Exception e){
    	  
    	 System.out.println(e.toString());
      }
	  
	  
      }
 
	  /*
		try {
			htmlFile = new FileWriter(html_report_file_name);
			htmlFile.write("<html><head>Automation Report</head>");
			
			Html_Test_Summary(now("yyymmdd"), Constants.resultsFolder, xmlSuite.getName(), xmlSuite.get PassCount, FailCount, SkipCount);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	
  
  public static void Html_Test_Summary(String TimeStamp, String ResultsPath, String TestSuiteName, int PassCount, int FailCount, int SkipCount)
    throws IOException
  {
   

    int FailPercentage = 0;
    int PassPercentage = 0;
    int SkipPercentage = 0;
    
    
    
 
    htmlFile.write("<body>");
    htmlFile.write("<table border='0 cellspacing=0' cellpadding='0' width='100%' align='center'");
    htmlFile.write("<tr valign='top'>");
    htmlFile.write("<style>");
    htmlFile.write(".subheading {style='background-color:#ABCDEF;border:1px solid blue;'}");
    htmlFile.write(".subheading1{BORDER-RIGHT: #8eb3d8 1px solid;PADDING-RIGHT: 4px;BORDER-TOP: #8eb3d8 1px solid;PADDING-LEFT: 4px;FONT-WEIGHT: bold;FONT-SIZE: 9pt;PADDING-BOTTOM: 0px;BORDER-LEFT: #8eb3d8 1px solid;COLOR: #000000;PADDING-TOP: 0px;BORDER-BOTTOM: #8eb3d8 1px solid;FONT-FAMILY: Arial, helvetica, sans-serif;HEIGHT: 10px;}");
    htmlFile.write(".subheading2{BORDER-RIGHT: #8eb3d8 1px solid;PADDING-RIGHT: 2px;BORDER-TOP: #8eb3d8 1px solid;PADDING-LEFT: 2px;FONT-WEIGHT: bold;FONT-SIZE: 9pt;PADDING-BOTTOM: 0px;BORDER-LEFT: #8eb3d8 1px solid;COLOR: #000000;PADDING-TOP: 0px;BORDER-BOTTOM: #8eb3d8 1px solid;FONT-FAMILY: Arial, helvetica, sans-serif;HEIGHT: 10px;}");
    htmlFile.write(".tdborder_1{style='background-color:#ABCDEF;border:1px solid blue;'}");
    htmlFile.write("<td>");
    htmlFile.write("<tr>");
    htmlFile.write("<td style='color:#000000;background-color:#C0E0FF;border:2px groove white;font-family:Arial, Helvetica;font-size:12px;text-align:center;'>");
    htmlFile.write("</style>");
    htmlFile.write("<tr>");
    htmlFile.write("<td class='subheading1' colspan=6 align=center>");
    htmlFile.write("<p style='font-size:1.8em'>");
    htmlFile.write("<body link='#00ff00'>MIGME Automation FRAMEWORK</body></p>");
    htmlFile.write("<FONT SIZE='4' FACE='courier' COLOR=blue><MARQUEE WIDTH=100% BEHAVIOR=SCROLL DIRECTION=RIGHT BGColor=white>WEB AUTOMATION REPORT");
    htmlFile.write(TimeStamp);
    htmlFile.write("</MARQUEE></FONT>");
    htmlFile.write("</td>");
    
    htmlFile.write("</tr>");
    htmlFile.write("<tr>");
    htmlFile.write("<td colspan=3 align=center style='color:#000000;background-color:#C0E0FF;border:2px groove white;font-family:Arial, Helvetica;font-size:12px;text-align:center;'><b>Test_Suite</b></td>");
    htmlFile.write("<td colspan=3 align=center style='color:#000000;background-color:#C0E0FF;border:2px groove white;font-family:Arial, Helvetica;font-size:12px;text-align:center;'><b>Total_TC_Executed</b></td>");
    htmlFile.write("</tr>");
    htmlFile.write("<tr>");
    
    htmlFile.write("<td colspan=3 style='color:#000000;background-color:White;border:2px groove white;font-family:Arial, Helvetica;font-size:12px;text-align:center;'>");
    htmlFile.write("<a href=" + "Test_Suite_Summary_Filename" + " style='color: #0000FF' target='blank'>" + TestSuiteName + "</a>");
    htmlFile.write("</td>");
    int TotalTestsCount = PassCount + FailCount + SkipCount;
    htmlFile.write("<td colspan=3 style='color:#000000;background-color:White;border:2px groove white;font-family:Arial, Helvetica;font-size:12px;text-align:center;'><b>" + TotalTestsCount + "</b></td>");
    htmlFile.write("</tr>");
    
    htmlFile.write("<tr>");
    htmlFile.write("<td colspan=2 style='color:#000000;background-color:#90EE90;border:2px groove white;font-family:Arial, Helvetica;font-size:12px;text-align:center;'><b>&nbsp;Pass&nbsp;</b></td>");
    htmlFile.write("<td colspan=2 style='color:#000000;background-color:#FF0000;border:2px groove white;font-family:Arial, Helvetica;font-size:12px;text-align:center;'><b>&nbsp;Fail&nbsp;</b></td>");
    htmlFile.write("<td colspan=2 style='color:#000000;background-color:#FFFF00;border:2px groove white;font-family:Arial, Helvetica;font-size:12px;text-align:center;'><b>&nbsp;Skip&nbsp;</b></td>");
    htmlFile.write("</tr>");
    
    htmlFile.write("<tr>");
    htmlFile.write("<td colspan=1 style='color:#000000;background-color:#FFFFFF;border:2px groove white;font-family:Arial, Helvetica;font-size:12px;' align=center nowrap><b>Test Case Count</b></td>");
    
    htmlFile.write("<td colspan=1 style='color:#000000;background-color:#FFFFFF;border:2px groove white;font-family:Arial, Helvetica;font-size:12px;' align=center nowrap><b>Percentage</b></td>");
    
    htmlFile.write("<td colspan=1 style='color:#000000;background-color:#FFFFFF;border:2px groove white;font-family:Arial, Helvetica;font-size:12px;' align=center nowrap><b>Test Case Count</b></td>");
    
    htmlFile.write("<td colspan=1 style='color:#000000;background-color:#FFFFFF;border:2px groove white;font-family:Arial, Helvetica;font-size:12px;' align=center nowrap><b>Percentage</b></td>");
    
    htmlFile.write("<td colspan=1 style='color:#000000;background-color:#FFFFFF;border:2px groove white;font-family:Arial, Helvetica;font-size:12px;' align=center nowrap><b>Test Case Count</b></td>");
    
    htmlFile.write("<td colspan=1 style='color:#000000;background-color:#FFFFFF;border:2px groove white;font-family:Arial, Helvetica;font-size:12px;' align=center nowrap><b>Percentage</b></td>");
    htmlFile.write("</tr>");
    htmlFile.write("<tr>");
    if (Math.rint(PassCount * 100.0D / TotalTestsCount) >= 1.0D) {
      PassPercentage = (int)Math.rint(PassCount * 100.0D / TotalTestsCount);
    }
    htmlFile.write("<td colspan=1 style='color:#000000;background-color:#FFFFFF;border:2px groove white;font-family:Arial, Helvetica;font-size:12px;' align=center nowrap><b>" + PassCount + "</b></td>");
    htmlFile.write("<td colspan=1 style='color:black;background-color:#FFFFFF;border:2px groove white;font-family:Arial, Helvetica;font-size:12px;' width=73 align=center nowrap><b>" + String.valueOf(PassPercentage) + "%</b></td>");
    
    htmlFile.write("<td colspan=1 style='color:#000000;background-color:#FFFFFF;border:2px groove white;font-family:Arial, Helvetica;font-size:12px;' align=center nowrap><b>" + FailCount + "</b></td>");
    if (Math.rint(FailCount * 100.0D / TotalTestsCount) >= 1.0D) {
      FailPercentage = (int)Math.rint(FailCount * 100.0D / TotalTestsCount);
    }
    htmlFile.write("<td colspan=1 style='color:black;background-color:#FFFFFF;border:2px groove white;font-family:Arial, Helvetica;font-size:12px;' width=73 align=center nowrap><b>" + String.valueOf(FailPercentage) + "%</b></td>");
    htmlFile.write("<td colspan=1 style='color:#000000;background-color:#FFFFFF;border:2px groove white;font-family:Arial, Helvetica;font-size:12px;' align=center nowrap><b>" + SkipCount + "</b></td>");
    if (Math.rint(SkipCount * 100.0D / TotalTestsCount) >= 1.0D) {
      SkipPercentage = (int)Math.rint(SkipCount * 100.0D / TotalTestsCount);
    }
    htmlFile.write("<td colspan=1 style='color:black;background-color:#FFFFFF;border:2px groove white;font-family:Arial, Helvetica;font-size:12px;' width=73 align=center nowrap><b>" + String.valueOf(SkipPercentage) + "%</b></td>");
    htmlFile.write("</tr>");
    htmlFile.write("<td colspan=6 style='color:#000000;background-color:#C0E0FF;border:2px groove white;font-family:Arial, Helvetica;font-size:12px;text-align:center;'>");
    
    htmlFile.write("<table bgcolor='White' border='1' align='center' style='width: 8%; height:150px'>");
    htmlFile.write("<tr>");
    htmlFile.write("<td>");
    htmlFile.write("<div align='justify'>");
    htmlFile.write("<table bgcolor='WhiteSmoke' align='center' style='width: 101%; height:150px'>");
    htmlFile.write("<caption><b>Trend Analysis</b></caption>");
    htmlFile.write("<tr >");
    


    htmlFile.write("<td valign='bottom'>");
    int passpercent = Integer.parseInt(String.valueOf(PassPercentage));
    if (passpercent != 0) {
      htmlFile.write("<div style='background-color:lightgreen; width:50; height:" + String.valueOf(PassPercentage) + ";'>");
    }
    htmlFile.write("<td valign='bottom'>");
    int failpercent = Integer.parseInt(String.valueOf(FailPercentage));
    if (failpercent != 0) {
      htmlFile.write("<div style='background-color:red; width:50; height:" + String.valueOf(FailPercentage) + ";'>");
    }
    htmlFile.write("<td valign='bottom'>");
    int skippercent = Integer.parseInt(String.valueOf(SkipPercentage));
    if (skippercent != 0) {
      htmlFile.write("<div style='background-color:yellow; width:50; height:" + String.valueOf(SkipPercentage) + ";'>");
    }
    htmlFile.write("</td>");
    htmlFile.write("</tr>");
    htmlFile.write("<tr>");
    htmlFile.write("<td style='width: 23px'> <p> <b>Pass</b></p>");
    htmlFile.write("</td>");
    htmlFile.write("<td style='width: 14px'> <p><b>Fail</b></p>");
    htmlFile.write("</td>");
    htmlFile.write("<td style='width: 30px'> <p><b>Skip</b></p>");
    htmlFile.write("</td>");
    htmlFile.write("</tr>");
    htmlFile.write("</table>");
    htmlFile.write("</div>");
    htmlFile.write("</td>");
    htmlFile.write("</tr>");
    htmlFile.write("</table>");
    htmlFile.write("</td>");
    htmlFile.write("</table>");
    htmlFile.write("</td>");
    htmlFile.write("</tr>");
    htmlFile.write("</table>");
    htmlFile.write("</td>");
    htmlFile.write("</body>");
    htmlFile.write("</html>");
    htmlFile.flush();
    htmlFile.close();
  }
  
  public void Html_TestSuite_Summary_head(String TimeStamp, String ResultsPath, String TestSuiteName)
    throws IOException
  {
    String Test_Step_Execution_FilePath = ResultsPath;
    Test_Step_Execution_FilePath = Test_Step_Execution_FilePath.concat("\\Html_TestSuite_Summary_" + TimeStamp + ".html");
    FileWriter HtmlFile = new FileWriter(Test_Step_Execution_FilePath);
    HtmlFile.write("<html>");
    HtmlFile.write("<style>");
    HtmlFile.write(".subheading { BORDER-RIGHT: #8eb3d8 1px solid;PADDING-RIGHT: 4px;BORDER-TOP: #8eb3d8 1px solid;PADDING-LEFT: 4px;FONT-WEIGHT: bold;FONT-SIZE: 9pt;PADDING-BOTTOM: 0px;BORDER-LEFT: #8eb3d8 1px solid;COLOR: #000000;PADDING-TOP: 0px;BORDER-BOTTOM: #8eb3d8 1px solid;FONT-FAMILY: Arial, helvetica, sans-serif;HEIGHT: 20px;BACKGROUND-COLOR: #b0d9ea}");
    HtmlFile.write(".subheading1{BORDER-RIGHT: #8eb3d8 1px solid;PADDING-RIGHT: 4px;BORDER-TOP: #8eb3d8 1px solid;PADDING-LEFT: 4px;FONT-WEIGHT: bold;FONT-SIZE: 9pt;PADDING-BOTTOM: 0px;BORDER-LEFT: #8eb3d8 1px solid;COLOR: #000000;PADDING-TOP: 0px;BORDER-BOTTOM: #8eb3d8 1px solid;FONT-FAMILY: Arial, helvetica, sans-serif;HEIGHT: 10px;}");
    HtmlFile.write(".subheading2{BORDER-RIGHT: #8eb3d8 1px solid;PADDING-RIGHT: 2px;BORDER-TOP: #8eb3d8 1px solid;PADDING-LEFT: 2px;FONT-WEIGHT: bold;FONT-SIZE: 9pt;PADDING-BOTTOM: 0px;BORDER-LEFT: #8eb3d8 1px solid;COLOR: #000000;PADDING-TOP: 0px;BORDER-BOTTOM: #8eb3d8 1px solid;FONT-FAMILY: Arial, helvetica, sans-serif;HEIGHT: 10px;}");
    HtmlFile.write(".tdborder_1{BORDER-RIGHT: #bdd0e4 1px solid;PADDING-RIGHT: 4px;BORDER-TOP: #bdd0e4 1px solid;PADDING-LEFT: 4px;FONT-SIZE: 9pt;PADDING-BOTTOM: 0px;BORDER-LEFT: #bdd0e4 1px solid;COLOR: #000000;PADDING-TOP: 0px;BORDER-BOTTOM: #bdd0e4 1px solid;FONT-FAMILY: Arial, helvetica, sans-serif;HEIGHT: 20px}");
    HtmlFile.write(".tdborder_1_PASS{BORDER-RIGHT: #bdd0e4 1px solid;PADDING-RIGHT: 4px;BORDER-TOP: #bdd0e4 1px solid;PADDING-LEFT: 4px;FONT-SIZE: 9pt;PADDING-BOTTOM: 0px;BORDER-LEFT: #bdd0e4 1px solid;COLOR: #00ff00;PADDING-TOP: 0px;BORDER-BOTTOM: #bdd0e4 1px solid;FONT-FAMILY: Arial, helvetica, sans-serif;HEIGHT: 20px}");
    HtmlFile.write(".tdborder_1_FAIL{BORDER-RIGHT: #bdd0e4 1px solid;PADDING-RIGHT: 4px;BORDER-TOP: #bdd0e4 1px solid;PADDING-LEFT: 4px;FONT-SIZE: 9pt;PADDING-BOTTOM: 0px;BORDER-LEFT: #bdd0e4 1px solid;COLOR: #ff0000;PADDING-TOP: 0px;BORDER-BOTTOM: #bdd0e4 1px solid;FONT-FAMILY: Arial, helvetica, sans-serif;HEIGHT: 20px}");
    HtmlFile.write(".tdborder_1_ERROR{BORDER-RIGHT: #bdd0e4 1px solid;PADDING-RIGHT: 4px;BORDER-TOP: #bdd0e4 1px solid;PADDING-LEFT: 4px;FONT-SIZE: 9pt;PADDING-BOTTOM: 0px;BORDER-LEFT: #bdd0e4 1px solid;COLOR: #ff0000;PADDING-TOP: 0px;BORDER-BOTTOM: #bdd0e4 1px solid;FONT-FAMILY: Arial, helvetica, sans-serif;HEIGHT: 20px}");
    HtmlFile.write(".tdborder_1_DONE{BORDER-RIGHT: #bdd0e4 1px solid;PADDING-RIGHT: 4px;BORDER-TOP: #bdd0e4 1px solid;PADDING-LEFT: 4px;FONT-SIZE: 9pt;PADDING-BOTTOM: 0px;BORDER-LEFT: #bdd0e4 1px solid;COLOR: #ffcc00;PADDING-TOP: 0px;BORDER-BOTTOM: #bdd0e4 1px solid;FONT-FAMILY: Arial, helvetica, sans-serif;HEIGHT: 20px}");
    HtmlFile.write(".tdborder_1_SKIPPED{BORDER-RIGHT: #bdd0e4 1px solid;PADDING-RIGHT: 4px;BORDER-TOP: #bdd0e4 1px solid;PADDING-LEFT: 4px;FONT-SIZE: 9pt;PADDING-BOTTOM: 0px;BORDER-LEFT: #bdd0e4 1px solid;COLOR: #00ccff;PADDING-TOP: 0px;BORDER-BOTTOM: #bdd0e4 1px solid;FONT-FAMILY: Arial, helvetica, sans-serif;HEIGHT: 20px}");
    HtmlFile.write(".heading {FONT-WEIGHT: bold; FONT-SIZE: 17px; COLOR: #005484;FONT-FAMILY: Arial, Verdana, Tahoma, Arial;}");
    HtmlFile.write(".style1 { border: 1px solid #8eb3d8;padding: 0px 4px;FONT-WEIGHT: bold;FONT-SIZE: 9pt;COLOR: #000000;FONT-FAMILY: Arial, helvetica, sans-serif;HEIGHT: 20px;width: 180px;}");
    HtmlFile.write(".style3 { border: 1px solid #8eb3d8;padding: 0px 4px;FONT-WEIGHT: bold;FONT-SIZE: 9pt;COLOR: #000000;FONT-FAMILY: Arial, helvetica, sans-serif;HEIGHT: 20px;width: 2px;}");
    HtmlFile.write("</style>");
    HtmlFile.write("<head>");
    HtmlFile.write("<title></title>");
    HtmlFile.write("</head>");
    HtmlFile.write("<body>");
    HtmlFile.write("<table cellSpacing='0' cellPadding='0' width='96%' border='0'  align='center' style='height: 40px'>");
    HtmlFile.write("<tr>");
    HtmlFile.write("<td   align=center><span class='heading'><A NAME=returntotop>" + TestSuiteName + " Test_Suite RAFT Execution Summary</A> </span>");
    HtmlFile.write("<br />");
    HtmlFile.write("</td></tr>");
    HtmlFile.write("</table>");
    
    HtmlFile.write("<br />");
    HtmlFile.write("<table cellSpacing='0' cellPadding='0' border='0' align='center' style='width:96%; margin-left:20px;'>");
    
    HtmlFile.write("<TR>");
    HtmlFile.write("<tr>");
    HtmlFile.write("<td class='subheading' >TestScenario</td>");
    HtmlFile.write("<td class='subheading'>TestCase Iteration</td>");
    HtmlFile.write("<td class='subheading'>Execution Status</td>");
    HtmlFile.write("<td class='subheading'>Start Time</td>");
    HtmlFile.write("<td class='subheading'>End Time</td>");
    HtmlFile.write("<td class='subheading'>Result</td>");
    HtmlFile.write("</tr>");
    HtmlFile.flush();
    HtmlFile.close();
  }
  
  public void Html_TestSuite_Summary_Iteration(String TimeStamp, String ResultsPath, String TestCaseSheetName, String TestCaseName, String Iteration, String ExecutionStatus, String TestResult, String TEST_START_TIME)
    throws IOException
  {
    String ResultStyle = null;
    

    String Test_Step_Execution_FilePath = ResultsPath;
    Test_Step_Execution_FilePath = Test_Step_Execution_FilePath.concat("\\Html_TestSuite_Summary_" + TimeStamp + ".html");
    

    FileWriter HtmlFile = new FileWriter(Test_Step_Execution_FilePath, true);
    
    HtmlFile.write("<TR>");
    HtmlFile.write("<tr>");
    HtmlFile.write("<td class =style1>" + TestCaseSheetName + "</td>");
    if (TestResult.equalsIgnoreCase("SKIPPED")) {
      HtmlFile.write("<td class =style1>" + Iteration + "</td>");
    } else {
      HtmlFile.write("<td class =style1><a href=Html_Test_Step_Results_" + TimeStamp + ".html#" + Iteration + ">" + Iteration + "</a></td>");
    }
    HtmlFile.write("<td class =style1>" + ExecutionStatus + "</td>");
    
    HtmlFile.write("<td class=style1>" + TEST_START_TIME + "</td>");
    
    Calendar TestEndTime = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    String TEST_END_TIME = sdf.format(TestEndTime.getTime());
    HtmlFile.write("<td class=style1>" + TEST_END_TIME + "</td>");
    ResultStyle = "tdborder_1_".concat(TestResult);
    HtmlFile.write("<td class=" + ResultStyle + ">" + TestResult + "</td>");
    HtmlFile.write("</tr>");
    HtmlFile.flush();
    HtmlFile.close();
  }
  
  public void Html_Test_Step_Iteration(String TimeStamp, String ResultsPath, int IterationCount, String TestCaseName, String TestCaseSheetName, String Type)
    throws IOException
  {
    String ResultFileName = "Html_Test_Step_Results";
    String ParentTestName = "";
    if (Type.startsWith("Function_"))
    {
      ParentTestName = Type.substring(Type.lastIndexOf("_") + 1, Type.length() - 1);
      ResultFileName = "Html_Test_Scenario_Results";
    }
    String Test_Step_Execution_FilePath = ResultsPath;
    Test_Step_Execution_FilePath = Test_Step_Execution_FilePath.concat("\\" + ResultFileName + "_" + TimeStamp + ".html");
    

    FileWriter HtmlFile = new FileWriter(Test_Step_Execution_FilePath, true);
    HtmlFile.write("<table name=" + TestCaseSheetName + "_" + TestCaseName + "_" + String.valueOf(IterationCount) + " cellSpacing='0' cellPadding='0' border='0' align='center' style='width:96%; margin-left:20px;'>");
    HtmlFile.write("<tr>");
    HtmlFile.write("<td class = subheading2 colspan=6 align ='center'>" + TestCaseSheetName + "_" + TestCaseName + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Iteration Count - " + String.valueOf(IterationCount) + "</td></tr>");
    HtmlFile.write("</table>");
    HtmlFile.write("<table cellSpacing='0' cellPadding='0' border='0' align='center' style='width:96%; margin-left:20px;'>");
    HtmlFile.write("</table>");
    HtmlFile.write("<br />");
    HtmlFile.write("<table cellSpacing='0' cellPadding='0' border='0' align='center' style='width:96%; margin-left:20px;'>");
    if (Type.startsWith("Function_")) {
      HtmlFile.write("<tr><td class = subheading2 colspan=4 align ='center'><A NAME=" + ParentTestName + "_" + TestCaseName + "_Iteration_" + IterationCount + ">" + ParentTestName + "_" + TestCaseName + "_Iteration_" + IterationCount + "</A></td><td class = subheading2 colspan=2 align ='center'><A href=\"#returntotop\">Return to Top</A></td></tr>");
    } else {
      HtmlFile.write("<tr><td class = subheading2 colspan=4 align ='center'><A NAME=" + TestCaseName + ">" + TestCaseName + "_Iteration_" + IterationCount + "</A></td><td class = subheading2 colspan=2 align ='center'><A href=\"#returntotop\">Return to Top</A></td></tr>");
    }
    HtmlFile.write("<TR>");
    HtmlFile.write("<tr>");
    HtmlFile.write("<td class='subheading' >Step No.</td>");
    HtmlFile.write("<td class='subheading' >TestStep Description</td>");
    HtmlFile.write("<td class='subheading'>Data</td>");
    HtmlFile.write("<td class='subheading'>Expected Result</td>");
    HtmlFile.write("<td class='subheading'>Actual Result</td>");
    HtmlFile.write("<td class='subheading'>Iteration_Result_Status</td>");
    HtmlFile.write("</tr>");
    HtmlFile.flush();
    HtmlFile.close();
  }
  
  public void Html_Test_Step_head(String TimeStamp, String ResultsPath, String Type)
    throws IOException
  {
    String Test_Step_Execution_FilePath = ResultsPath;
    String ResultFileName = "Html_Test_Step_Results";
    if (Type.equalsIgnoreCase("Function")) {
      ResultFileName = "Html_Test_Scenario_Results";
    }
    Test_Step_Execution_FilePath = Test_Step_Execution_FilePath.concat("\\" + ResultFileName + "_" + TimeStamp + ".html");
    FileWriter HtmlFile = new FileWriter(Test_Step_Execution_FilePath);
    
    HtmlFile.write("<html>");
    HtmlFile.write("<style>");
    HtmlFile.write(".subheading { BORDER-RIGHT: #8eb3d8 1px solid;PADDING-RIGHT: 4px;BORDER-TOP: #8eb3d8 1px solid;PADDING-LEFT: 4px;FONT-WEIGHT: bold;FONT-SIZE: 9pt;PADDING-BOTTOM: 0px;BORDER-LEFT: #8eb3d8 1px solid;COLOR: #000000;PADDING-TOP: 0px;BORDER-BOTTOM: #8eb3d8 1px solid;FONT-FAMILY: Arial, helvetica, sans-serif;HEIGHT: 20px;BACKGROUND-COLOR: #b0d9ea}");
    HtmlFile.write(".subheading1{BORDER-RIGHT: #8eb3d8 1px solid;PADDING-RIGHT: 4px;BORDER-TOP: #8eb3d8 1px solid;PADDING-LEFT: 4px;FONT-WEIGHT: bold;FONT-SIZE: 9pt;PADDING-BOTTOM: 0px;BORDER-LEFT: #8eb3d8 1px solid;COLOR: #000000;PADDING-TOP: 0px;BORDER-BOTTOM: #8eb3d8 1px solid;FONT-FAMILY: Arial, helvetica, sans-serif;HEIGHT: 10px;}");
    HtmlFile.write(".subheading2{BORDER-RIGHT: #8eb3d8 1px solid;PADDING-RIGHT: 2px;BORDER-TOP: #8eb3d8 1px solid;PADDING-LEFT: 2px;FONT-WEIGHT: bold;FONT-SIZE: 9pt;PADDING-BOTTOM: 0px;BORDER-LEFT: #8eb3d8 1px solid;COLOR: #000000;PADDING-TOP: 0px;BORDER-BOTTOM: #8eb3d8 1px solid;FONT-FAMILY: Arial, helvetica, sans-serif;HEIGHT: 10px;}");
    HtmlFile.write(".tdborder_1{BORDER-RIGHT: #bdd0e4 1px solid;PADDING-RIGHT: 4px;BORDER-TOP: #bdd0e4 1px solid;PADDING-LEFT: 4px;FONT-SIZE: 9pt;PADDING-BOTTOM: 0px;BORDER-LEFT: #bdd0e4 1px solid;COLOR: #000000;PADDING-TOP: 0px;BORDER-BOTTOM: #bdd0e4 1px solid;FONT-FAMILY: Arial, helvetica, sans-serif;HEIGHT: 20px}");
    HtmlFile.write(".tdborder_1_PASS{BORDER-RIGHT: #bdd0e4 1px solid;PADDING-RIGHT: 4px;BORDER-TOP: #bdd0e4 1px solid;PADDING-LEFT: 4px;FONT-SIZE: 9pt;PADDING-BOTTOM: 0px;BORDER-LEFT: #bdd0e4 1px solid;COLOR: #00ff00;PADDING-TOP: 0px;BORDER-BOTTOM: #bdd0e4 1px solid;FONT-FAMILY: Arial, helvetica, sans-serif;HEIGHT: 20px}");
    HtmlFile.write(".tdborder_1_FAIL{BORDER-RIGHT: #bdd0e4 1px solid;PADDING-RIGHT: 4px;BORDER-TOP: #bdd0e4 1px solid;PADDING-LEFT: 4px;FONT-SIZE: 9pt;PADDING-BOTTOM: 0px;BORDER-LEFT: #bdd0e4 1px solid;COLOR: #ff0000;PADDING-TOP: 0px;BORDER-BOTTOM: #bdd0e4 1px solid;FONT-FAMILY: Arial, helvetica, sans-serif;HEIGHT: 20px}");
    HtmlFile.write(".tdborder_1_ERROR{BORDER-RIGHT: #bdd0e4 1px solid;PADDING-RIGHT: 4px;BORDER-TOP: #bdd0e4 1px solid;PADDING-LEFT: 4px;FONT-SIZE: 9pt;PADDING-BOTTOM: 0px;BORDER-LEFT: #bdd0e4 1px solid;COLOR: #ff0000;PADDING-TOP: 0px;BORDER-BOTTOM: #bdd0e4 1px solid;FONT-FAMILY: Arial, helvetica, sans-serif;HEIGHT: 20px}");
    HtmlFile.write(".tdborder_1_DONE{BORDER-RIGHT: #bdd0e4 1px solid;PADDING-RIGHT: 4px;BORDER-TOP: #bdd0e4 1px solid;PADDING-LEFT: 4px;FONT-SIZE: 9pt;PADDING-BOTTOM: 0px;BORDER-LEFT: #bdd0e4 1px solid;COLOR: #00ff00;PADDING-TOP: 0px;BORDER-BOTTOM: #bdd0e4 1px solid;FONT-FAMILY: Arial, helvetica, sans-serif;HEIGHT: 20px}");
    HtmlFile.write(".tdborder_1_SKIPPED{BORDER-RIGHT: #bdd0e4 1px solid;PADDING-RIGHT: 4px;BORDER-TOP: #bdd0e4 1px solid;PADDING-LEFT: 4px;FONT-SIZE: 9pt;PADDING-BOTTOM: 0px;BORDER-LEFT: #bdd0e4 1px solid;COLOR: #00ccff;PADDING-TOP: 0px;BORDER-BOTTOM: #bdd0e4 1px solid;FONT-FAMILY: Arial, helvetica, sans-serif;HEIGHT: 20px}");
    HtmlFile.write(".heading {FONT-WEIGHT: bold; FONT-SIZE: 17px; COLOR: #005484;FONT-FAMILY: Arial, Verdana, Tahoma, Arial;}");
    HtmlFile.write(".style1 { border: 1px solid #8eb3d8;padding: 0px 4px;FONT-WEIGHT: bold;FONT-SIZE: 9pt;COLOR: #000000;FONT-FAMILY: Arial, helvetica, sans-serif;HEIGHT: 20px;width: 180px;}");
    HtmlFile.write(".style3 { border: 1px solid #8eb3d8;padding: 0px 4px;FONT-WEIGHT: bold;FONT-SIZE: 9pt;COLOR: #000000;FONT-FAMILY: Arial, helvetica, sans-serif;HEIGHT: 20px;width: 2px;}");
    HtmlFile.write("</style>");
    HtmlFile.write("<head>");
    HtmlFile.write("<title></title>");
    HtmlFile.write("</head>");
    HtmlFile.write("<body>");
    HtmlFile.write("<table cellSpacing='0' cellPadding='0' width='96%' border='0'  align='center' style='height: 40px'>");
    HtmlFile.write("<tr>");
    HtmlFile.write("<td   align=center><span class='heading'><a name=\"returntotop\">RAFT_Execution_Results</A> </span>");
    HtmlFile.write("<br />");
    
    HtmlFile.write("</td></tr>");
    HtmlFile.write("</table>");
    HtmlFile.flush();
    HtmlFile.close();
  }
  
  public void HTML_Test_Step_Details(String TimeStamp, String ResultsPath, int StepNo, String Description, String Data, String ExpectedResult, String ActualResult, String Result, String Type, String ScreenShotPath)
    throws IOException
  {
    String ResultStyle = null;
    String ResultFileName = "Html_Test_Step_Results";
    if (Type.equalsIgnoreCase("Function")) {
      ResultFileName = "Html_Test_Scenario_Results";
    }
    String Test_Step_Execution_FilePath = ResultsPath;
    Test_Step_Execution_FilePath = Test_Step_Execution_FilePath.concat("\\" + ResultFileName + "_" + TimeStamp + ".html");
    

    FileWriter HtmlFile = new FileWriter(Test_Step_Execution_FilePath, true);
    
    HtmlFile.write("<TR>");
    HtmlFile.write("<tr>");
    
    HtmlFile.write("<td class =style1>" + StepNo + "</td>");
    if (!Description.isEmpty())
    {
      if (Data.toUpperCase().startsWith("FN_"))
      {
        HtmlFile.write("<td class =style1><A href=Html_Test_Scenario_Results_" + TimeStamp + ".html>" + Description + "</A></td>");
        HtmlFile.write("<td class =style1> - </td>");
      }
      else
      {
        HtmlFile.write("<td class =style1>" + Description + "</td>");
        if (!Data.isEmpty()) {
          HtmlFile.write("<td class =style1>" + Data + "</td>");
        } else {
          HtmlFile.write("<td class =style1> - </td>");
        }
      }
    }
    else
    {
      HtmlFile.write("<td class =style1> </td>");
      if (!Data.isEmpty()) {
        HtmlFile.write("<td class =style1>" + Data + "</td>");
      } else {
        HtmlFile.write("<td class =style1> - </td>");
      }
    }
    if (!ExpectedResult.isEmpty()) {
      HtmlFile.write("<td class =style1>" + ExpectedResult + "</td>");
    } else {
      HtmlFile.write("<td class =style1> - </td>");
    }
    if (!ActualResult.isEmpty()) {
      HtmlFile.write("<td class =style1>" + ActualResult + "</td>");
    } else {
      HtmlFile.write("<td class =style1> - </td>");
    }
    ResultStyle = "tdborder_1_".concat(Result);
    if ((Result.equalsIgnoreCase("FAIL")) || (Result.equalsIgnoreCase("ERROR")))
    {
      File ImageFile = new File(ScreenShotPath);
      if (ImageFile.exists())
      {
        String FileName = "\\";
        int LastIndex = ScreenShotPath.lastIndexOf(FileName);
        FileName = ScreenShotPath.substring(LastIndex, ScreenShotPath.length());
        FileName = "Bitmaps\\".concat(FileName);
        HtmlFile.write("<td class=" + ResultStyle + "><A HREF=" + FileName + ">" + Result.toUpperCase() + "</A></td>");
      }
      else
      {
        HtmlFile.write("<td class=" + ResultStyle + ">" + Result.toUpperCase() + "</td>");
      }
    }
    else
    {
      HtmlFile.write("<td class=" + ResultStyle + ">" + Result.toUpperCase() + "</td>");
    }
    HtmlFile.write("</tr>");
    HtmlFile.flush();
    HtmlFile.close();
  }
  
  public void Html_Test_Step_iteration_result(String TimeStamp, String ResultsPath, int[] ResultsCounter, String Type)
    throws IOException
  {
    String ResultFileName = "Html_Test_Step_Results";
    if (Type.equalsIgnoreCase("Function")) {
      ResultFileName = "Html_Test_Scenario_Results";
    }
    String Test_Step_Execution_FilePath = ResultsPath;
    Test_Step_Execution_FilePath = Test_Step_Execution_FilePath.concat("\\" + ResultFileName + "_" + TimeStamp + ".html");
    

    FileWriter HtmlFile = new FileWriter(Test_Step_Execution_FilePath, true);
    
    HtmlFile.write("</table>");
    HtmlFile.write("<table cellSpacing='0' cellPadding='0' border='0' align='center' style='width:96%; margin-left:20px;'>");
    HtmlFile.write("<TR>");
    HtmlFile.write("<td class='subheading1' colspan=6 align=center>");
    HtmlFile.write("<TR>");
    HtmlFile.write("<TD class=subheading vAlign=center align=middle >Test Step-Pass</TD>");
    HtmlFile.write("<TD class=subheading vAlign=center align=middle >Test Step-Fail</TD>");
    HtmlFile.write("<TD class=subheading vAlign=center align=middle >Test Step-Done</TD>");
    HtmlFile.write("<TD class=subheading vAlign=center align=middle >Test Step-Error</TD>");
    HtmlFile.write("<TD class=subheading vAlign=center align=middle >Test Step-Skip</TD></TR>");
    
    HtmlFile.write("<TR>");
    HtmlFile.write("<TD class=bg_darkblue height=1></TD>");
    HtmlFile.write("<TD class=bg_darkblue  height=1></TD></TR>");
    HtmlFile.write("<TR>");
    HtmlFile.write("<TD class=bg_gray_eee  height=1></TD>");
    HtmlFile.write("<TD class=bg_gray_eee height=1></TD></TR>");
    HtmlFile.write("<TR>");
    
    HtmlFile.write("<TD class='tdborder_1'  vAlign=center align=middle><b>" + ResultsCounter[1] + "</b></TD>");
    HtmlFile.write("<TD class='tdborder_1'  vAlign=center align=middle ><b>" + ResultsCounter[2] + "</b></TD>");
    HtmlFile.write("<TD class='tdborder_1'  vAlign=center align=middle ><b>" + ResultsCounter[0] + "</b></TD>");
    HtmlFile.write("<TD class='tdborder_1'  vAlign=center align=middle ><b>" + ResultsCounter[3] + "</b></TD>");
    HtmlFile.write("<TD class='tdborder_1'  vAlign=center align=middle ><b>" + ResultsCounter[4] + "</b></TD></TR>");
    HtmlFile.write("<TR>");
    HtmlFile.write("<TD class=subheading vAlign=center align=middle >  </TD>");
    HtmlFile.write("<TD class=subheading vAlign=center align=middle >  </TD>");
    HtmlFile.write("<TD class=subheading vAlign=center align=middle >  </TD>");
    HtmlFile.write("<TD class=subheading vAlign=center align=middle >  </TD>");
    HtmlFile.write("<TD class=subheading vAlign=center align=middle >  </TD></TR>");
    
    HtmlFile.write("</table>");
    HtmlFile.write("<BR />");
    HtmlFile.flush();
    HtmlFile.close();
  }
  
  public void Html_Test_Step_tail(String TimeStamp, String ResultsPath, String Type)
    throws IOException
  {
    String ResultFileName = "Html_Test_Step_Results";
    if (Type.equalsIgnoreCase("Function")) {
      ResultFileName = "Html_Test_Scenario_Results";
    }
    String Test_Step_Execution_FilePath = ResultsPath;
    Test_Step_Execution_FilePath = Test_Step_Execution_FilePath.concat("\\" + ResultFileName + "_" + TimeStamp + ".html");
    

    FileWriter HtmlFile = new FileWriter(Test_Step_Execution_FilePath, true);
    

    HtmlFile.write("</body>");
    HtmlFile.write("</html>");
    HtmlFile.flush();
    HtmlFile.close();
  }
  
  
  public static void main(String args[]){
	  
	  
	  HtmlReporter rpt = new HtmlReporter();
	  try {
		rpt.Html_Test_Summary("20141006134700", ".", "AutoPraveen", 90,7,3);
		  rpt.Html_TestSuite_Summary_head("20141006134759", ".", "Auto Praveen");
		  rpt.Html_Test_Step_head("20141006134700", ".", "Function");
		  rpt.Html_Test_Step_Iteration("20141006134700", ".", 2, "Login_01", "TestCases", "Type");
		  rpt.Html_TestSuite_Summary_Iteration("20141006134758", ".", "Test Cases", "Login_01", "1", "PASS", "Pass", "20141006134758");
		  
		  
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

  }
  
}

