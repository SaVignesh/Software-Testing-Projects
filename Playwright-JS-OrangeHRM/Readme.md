# Playwright Automation

## OrangeHRM

###	Prerequisite

1. Nodejs
2. Playwright: - Playwright libraries 

### What framework offers 
* Command line execution (No IDE required)
*	Custom configurations
*	Cross browser support
*	Parallel test execution
*	HTML reports
*	Single test case or group of test cases can be run
*	Run test cases using a batch file

### Folder structure
* Package: - Consist JavaScript file
* Folder: - Images, log files, etc.

config file - playwright.config.js
**Project Name** <br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;| <br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;PageObjects (Package) <br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;| <br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;testCases (Package) <br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;| <br /> 
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;testData (Folder) <br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;| <br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Reports (Folder) <br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;| <br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Run.bat (File) <br />
<br />


### Folder Description 

* PageObjects: - Page object scripts. Script use to perform action on target site<br />

*	testCases: - Test cases<br />

*	testData: - JSON files having test data<br />

*	Reports: - HTML reports of run<br />


### Commands to run

*	Execute run.bat file to execute the test cases. There are pre existing commands within the batch file <br />

*	To Run a single test case <br />
 &nbsp;&nbsp;&nbsp;`npx playwright test OrangeHRM/testCases/test_001_login.spec.js --headed --project chromium`<br />

 *	To Run the group of test cases marked as 'smoke' test cases <br />
 &nbsp;&nbsp;&nbsp;`npx playwright test --grep smoke --headed --project chromium`<br />
