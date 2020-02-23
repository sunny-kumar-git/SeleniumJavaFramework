package com.actitime.generics;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * 
 * @author sandeep
 *
 */
public class FileLib 
{
/**
 * 	
 * @param path
 * @param key
 * @return
 * @throws Exception
 */
public String getPropertyData(String path,String key)  throws Exception{//get value from properties files
	FileInputStream fis=new FileInputStream(path);
	Properties p=new Properties();
	p.load(fis);
	String data = p.getProperty(key);
	return data;
	
}
public String getPropertyData(String key)  throws Exception{
	FileInputStream fis=new FileInputStream("./data/commondata.properties");
	Properties p=new Properties();
	p.load(fis);
	String data = p.getProperty(key);
	return data;
	
}
public String getExcelValue(String path,String sheetname,int rownum,int cellnum) throws EncryptedDocumentException, InvalidFormatException, IOException {
	FileInputStream fis=new FileInputStream(path);
	Workbook wb = WorkbookFactory.create(fis);
	String value = wb.getSheet(sheetname).getRow(rownum).getCell(cellnum).toString();
	return value;
}
public String getExcelValue(String sheetname,int rownum,int cellnum) throws EncryptedDocumentException, InvalidFormatException, IOException {
	FileInputStream fis=new FileInputStream("./data/TestScriptData.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	String value = wb.getSheet(sheetname).getRow(rownum).getCell(cellnum).toString();
	return value;
}
}
