# RestAssured Hybrid Framework

## PetStore API

###	Prerequisite



1. Java
2. RestAssured: - RestAssured libraries 
3. TestNG : - TestNG Framework
4. Maven: - Java Build Management



### What framework offers 
* Command line execution (No IDE required)
*	Custom logger
*	HTML reports 
*	All test cases can be run using pom.xml

### Folder structure
* Package: - Contains Java classes
* Folder: - Images, log files, etc.

**Project Name** <br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;| <br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;sec/test/java/api.endpoints (Package) <br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;| <br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;test/java/api.payload (Package) <br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;| <br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;test/java/api.test (Package) <br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;| <br /> 
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;test/java/api.utilities (Package) <br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;| <br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;TestData (Folder) <br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;| <br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Logs (Folder) <br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;| <br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Reports (Folder) <br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;| <br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;testng.xml (File) <br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;| <br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;pom.xml (File) <br />
<br />

### Folder Description 

* api.endpoints: - Contains API URLs, Endpoints and Scripts to send requests<br />

* api.payload: - Contains POJO (Plain Old Java Object) classes that contain the payload that needs to be sent in the request<br />

*	api.test: - Contains tests that need to be performed<br />

*	api.utilities: - Scripts for utilities like reading Excel file, generating reports <br />

*	TestData: - Excel files having test data<br />


*	Logs: - Log file of run<br />

*	Reports: - HTML reports of run<br />

* pom.xml - Contains all dependencies that needs to be dowloaded and plugins. All tests can be run using this file <br />

* testng.xml - TestNG configuration files that has list of test classes that need to be executed <br />

#### You can also directly run the code from Github Folder in Jenkins using the Run.bat file:
![jenkins nopCommerce pass](https://github.com/SaVignesh/nopCommerceAdmin/assets/47379614/83c3a795-ecec-4c18-ba5f-3dbe90b4f170)
