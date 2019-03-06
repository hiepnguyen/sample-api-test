import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import groovy.sql.DataSet

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

KeywordLogger log = new KeywordLogger()

'//Call Data File'
TestData data = findTestData('Data Files/InvalidApi_keyData')

'//Get row numbers'
int rows = data.getRowNumbers()

for (def i : (1..rows)) {

'Define and send the resquest api'
def response = WS.sendRequest(findTestObject('Discover/discover', [('host') : GlobalVariable.HOST_API, ('path') : GlobalVariable.PATH_DISCOVER
				, ('token') :data.getObjectValue("invalid api_key", i)]), FailureHandling.STOP_ON_FAILURE)

'Verify the response'
WS.verifyResponseStatusCode(response, GlobalVariable.error_401, FailureHandling.CONTINUE_ON_FAILURE)

WS.containsString(response, 'Invalid API key: You must be granted a valid key.', false)

log.logInfo('Response message' + response.getResponseText())


}
