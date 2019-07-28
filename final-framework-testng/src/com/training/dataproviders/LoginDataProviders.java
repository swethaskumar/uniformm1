package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.LoginBean;
import com.training.dao.ELearningDAO;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.readexcel.ReadExcel;

public class LoginDataProviders {

	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<LoginBean> list = new ELearningDAO().getLogins(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(LoginBean temp : list){
			Object[]  obj = new Object[5]; 
			obj[0] = temp.getProductnametest(); 
			obj[1] = temp.getPricetest(); 
			obj[2] = temp.getStatustest(); 
			obj[3] = temp.getModeltest(); 
			obj[4] = temp.getQuantitytest(); 
		
			
			result[count ++] = obj; 
		}
		
		
		return result;
	}
	
	@DataProvider(name = "excel-inputs")
	public Object[][] getExcelData(){
		String fileName ="C:\\Users\\IBM_ADMIN\\Desktop\\Backup - Swe\\Data\\TestData.xlsx"; 
		int sheetno = 0;
		return new ApachePOIExcelRead().getExcelContent(fileName,sheetno); 
	}
	
	@DataProvider(name = "excel-inputs1")
	public Object[][] getExcelData1(){
		String fileName ="C:\\Users\\IBM_ADMIN\\Desktop\\Backup - Swe\\Data\\TestData.xlsx"; 
		int sheetno = 1;
		return new ApachePOIExcelRead().getExcelContent(fileName,sheetno); 
	}
	
	@DataProvider(name = "excel-inputs2")
	public Object[][] getExcelData2(){
		String fileName ="C:\\Users\\IBM_ADMIN\\Desktop\\Backup - Swe\\Data\\TestData.xlsx"; 
		int sheetno = 2;
		return new ApachePOIExcelRead().getExcelContent(fileName,sheetno); 
	}
	
	@DataProvider(name = "xls-inputs")
	public Object[][] getXLSData(){
		// ensure you will have the title as first line in the file 
		return new ReadExcel().getExcelData("C:/Users/Naveen/Desktop/Testing.xls", "Sheet1"); 
	}
}
