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
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl('https://dev.yorba.app/login')

WebUI.click(findTestObject('Object Repository/Signup/Page_Yorba Login/a_Sign Up'))

WebUI.click(findTestObject('Object Repository/Signup/Page_Yorba Register/input_First name_firstName'))

WebUI.setText(findTestObject('Object Repository/Signup/Page_Yorba Register/input_First name_firstName'), 'TestFirstName')

WebUI.setText(findTestObject('Object Repository/Signup/Page_Yorba Register/input_Last name_lastName'), 'TestLastName')

WebUI.setText(findTestObject('Object Repository/Signup/Page_Yorba Register/input_Email address_email'), 'uttam+3@outside.tech')

not_run: WebUI.setEncryptedText(findTestObject('Object Repository/Signup/Page_Yorba Register/input_Password_password'), 
    'xqowoNZu/lL0j1avc9w3bQ==')

WebUI.setText(findTestObject('Signup/Page_Yorba Register/input_Password_password'), 'Uttam2@@')

WebUI.click(findTestObject('Object Repository/Signup/Page_Yorba Register/svg_Password_sc-cxpSdN kxJXuv'))

WebUI.click(findTestObject('Object Repository/Signup/Page_Yorba Register/span_Sign me up'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Signup/Page_Yorba Confirmation Email/h2_Confirmation sent'))

WebUI.verifyElementText(findTestObject('Object Repository/Signup/Page_Yorba Confirmation Email/h2_Confirmation sent'), 'Confirmation sent!')

