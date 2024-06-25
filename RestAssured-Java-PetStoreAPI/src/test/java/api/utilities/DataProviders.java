package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
@DataProvider(name = "Data")
	public String[][] getAllData() throws IOException
	{
		String path = System.getProperty("user.dir")+"//testData//Userdata.xlsx";
		XLUtility xl = new XLUtility(path);
		int rownum = xl.getRowCount("Sheet1");
		int colnum = xl.getCellCount("Sheet1", 1);
		String data[][] = new String[rownum][colnum];
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colnum;j++)
			{
				data[i-1][j]=xl.getCellData("Sheet1", i, j);
			}
		}
		return data;
	}

	@DataProvider(name="Username")
	public String[] getUsername() throws IOException
	{
		String path = System.getProperty("user.dir")+"//testData//Userdata.xlsx";
		XLUtility xl = new XLUtility(path);
		int rownum = xl.getRowCount("Sheet1");
		String username[] = new String[rownum];
		for(int i=1;i<=rownum;i++)
		{
			username[i-1]= xl.getCellData("Sheet1", i, 1);
		}
		return username;
	}
	
	@DataProvider(name = "Orders")
	public String[][] getAllOrdersData() throws IOException
	{
		String path = System.getProperty("user.dir")+"//testData//Orderdata.xlsx";
		XLUtility xl = new XLUtility(path);
		int rownum = xl.getRowCount("Sheet1");
		int colnum = xl.getCellCount("Sheet1", 1);
		String data[][] = new String[rownum][colnum];
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colnum;j++)
			{
				data[i-1][j]=xl.getCellData("Sheet1", i, j);
			}
		}
		return data;
	}
	
	@DataProvider(name="OrderID")
	public String[] getOrderID() throws IOException
	{
		String path = System.getProperty("user.dir")+"//testData//Orderdata.xlsx";
		XLUtility xl = new XLUtility(path);
		int rownum = xl.getRowCount("Sheet1");
		String OrderID[] = new String[rownum];
		for(int i=1;i<=rownum;i++)
		{
			OrderID[i-1]= xl.getCellData("Sheet1", i, 0);
		}
		return OrderID;
	}
}
