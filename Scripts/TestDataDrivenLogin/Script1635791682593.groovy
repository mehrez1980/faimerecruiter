import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint

import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable

import static org.junit.Assert.assertEquals

import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testobject.ConditionType

TestObject ObjUsername=new TestObject("username")
TestObject ObjPassword=new TestObject("password")
TestObject ObjValider=new TestObject("valider")
TestObject ObjLogout=new TestObject("Logout")
TestObject ObjMsgErr=new TestObject("MsgErr")
ObjUsername.addProperty('xpath', ConditionType.EQUALS, '//input[@id=\'username\']')
ObjPassword.addProperty('xpath', ConditionType.EQUALS, '//input[@id=\'password\']')
ObjValider.addProperty('xpath', ConditionType.EQUALS, '//input[@value=\'Login\']')
ObjLogout.addProperty('xpath', ConditionType.EQUALS, '//a[contains(text(),\'Logout\')]')
ObjMsgErr.addProperty('xpath', ConditionType.EQUALS,'//p[@class="failure"]')
WebUI.waitForElementPresent(ObjUsername, 300)
WebUI.setText(ObjUsername, username)
WebUI.setText(ObjPassword, password)
WebUI.click(ObjValider)
if (WebUI.verifyElementPresent(ObjLogout, 30,FailureHandling.OPTIONAL))
{
String ActualResult = WebUI.getText(ObjLogout)
WebUI.click(ObjLogout)
assertEquals(ResultatAttendu, ActualResult)
}
if (WebUI.verifyElementPresent(ObjMsgErr, 30,FailureHandling.OPTIONAL))
{
String ActualResult = WebUI.getText(ObjMsgErr)
assertEquals("Le resultat Attendu devrais être: "+ResultatAttendu+" Alors que nous avons commme résultat: "+ActualResult,ResultatAttendu, ActualResult)
}