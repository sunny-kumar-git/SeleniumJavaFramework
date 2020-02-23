package com.actitime.test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.actitime.generics.BaseClass;
import com.actitime.pom.EnterTimeTrack;
import com.actitime.pom.TaskListPage;
/**
 * 
 * @author sunny-kumar
 *
 */
public class CustomerModule extends BaseClass{
	
@Test
public void testCreateCustome() throws InterruptedException, Exception, InvalidFormatException, IOException {
	Reporter.log("testCreateCustome",true);
	EnterTimeTrack e=new EnterTimeTrack(driver);
	TaskListPage t=new TaskListPage(driver);
	String CustomerName = f.getExcelValue("CreateCustomer", 1, 0);
	String CustomerDesc = f.getExcelValue("CreateCustomer", 1, 1);
	Thread.sleep(3000);
	e.taskTabClick();
	Thread.sleep(2000);
	t.getAddNewBTN().click();
	t.getNewCustBTN().click();
	Thread.sleep(3000);
	t.getEnterCustTBX().sendKeys(CustomerName);///setter concept
	t.getDescriptionTBX().sendKeys(CustomerDesc);
	Thread.sleep(3000);
	t.getSelectCustListBX().click();
	Thread.sleep(2000);
	t.getProjectName().click();
	t.getCreateCustBTN().click();
	Thread.sleep(2000);
	String Atext = t.getActualText().getText();
	Assert.assertEquals(Atext, CustomerName);
	Reporter.log("Created customer matching");
	Thread.sleep(2000);
	}
}
