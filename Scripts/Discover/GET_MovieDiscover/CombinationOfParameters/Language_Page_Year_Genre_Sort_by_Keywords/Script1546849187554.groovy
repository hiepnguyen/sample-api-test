import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import groovy.json.JsonSlurper as JsonSlurper
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
def currentY = (GlobalVariable.currYear) as int
years = 1900..currentY

KeywordLogger log = new KeywordLogger()

def data = findTestData('searchData')
println "number of rows" + data.getRowNumbers()-1
for (i = 0; i < data.getRowNumbers()-1; i++) {
    syear = data.internallyGetValue('year', i)

    if (syear != '') {
        switch (syear) {
            case 'mid':
                syear = (years[(years.size() / 2).intValue()])

                break
            case 'last':
                syear = years.last()

                break
            case 'random':
                Random y = new Random()

                syear = (years[y.nextInt(years.size())])

                break
            case 'nearness':
                syear = (years[years.size() - 1.intValue()])

                break
            default:
                println('Something else')}
    }
    
    sortby = data.internallyGetValue('sort', i)

    genre = data.internallyGetValue('genre', i)

    println((((((('Test case: index=' + i) + ';year=') + syear) + ';sort by=') + sortby) + ';Genres=') + genre)

    'define and send the resquest api'
    def response = WS.sendRequest(findTestObject('Discover/discover', [('host') : GlobalVariable.HOST_API, ('path') : GlobalVariable.PATH_DISCOVER
                , ('token') : GlobalVariable.themoviedbToken, ('sort_by') : sortby, ('page') : '', ('date') : '', ('genre') : genre
                , ('year') : syear, ('with_keywords') : '']), FailureHandling.STOP_ON_FAILURE)

    WS.verifyResponseStatusCode(response, GlobalVariable.ok_200, FailureHandling.CONTINUE_ON_FAILURE)

    'define and get the map of json respone'
    def jsonSlurper = new JsonSlurper()

    def jsonResponse = jsonSlurper.parseText(response.getResponseText())

    log.logInfo('Response message' + jsonResponse)
}

