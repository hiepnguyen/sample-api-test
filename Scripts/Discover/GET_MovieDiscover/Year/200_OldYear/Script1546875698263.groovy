import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.logging.KeywordLogger
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import groovy.json.JsonBuilder
import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

def currentY = (GlobalVariable.currYear) as int
years = 1900..currentY
KeywordLogger log = new KeywordLogger()

'define and send the resquest api'
def response = WS.sendRequest(findTestObject('Discover/discover', [('host') : GlobalVariable.HOST_API, ('path') : GlobalVariable.PATH_DISCOVER
	, ('token') : GlobalVariable.themoviedbToken,('sort_by'):'popularity.desc', ('page') : '',('date'):'',('genre'):'',('year'):years.last()]), FailureHandling.STOP_ON_FAILURE)

WS.verifyResponseStatusCode(response, GlobalVariable.ok_200, FailureHandling.CONTINUE_ON_FAILURE)

'define and get the map of json respone'
def jsonSlurper = new JsonSlurper()
def jsonResponse = jsonSlurper.parseText(response.getResponseText())
log.logInfo('Response message'+jsonResponse)