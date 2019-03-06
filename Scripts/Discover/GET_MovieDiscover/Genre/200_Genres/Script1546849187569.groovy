import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static org.assertj.core.api.Assertions.*
import org.testng.Assert
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import groovy.json.JsonSlurper as JsonSlurper
import internal.GlobalVariable as GlobalVariable

KeywordLogger log = new KeywordLogger()
'define and send the resquest api'
def response = WS.sendRequest(findTestObject('Genre/genre', [('host') : GlobalVariable.HOST_API, ('path') : GlobalVariable.PATH_GENRE_LIST
			, ('token') : GlobalVariable.themoviedbToken]), FailureHandling.STOP_ON_FAILURE)
log.logInfo('Response message'+response)

'define and get the map of json respone'
def jsonSlurper = new JsonSlurper()
def jsonResponse = jsonSlurper.parseText(response.getResponseText())

'Get the list of genres from response'
jsonMapActualdata = jsonResponse.genres

"Verify the request sent successfully"
WS.verifyResponseStatusCode(response, GlobalVariable.ok_200, FailureHandling.CONTINUE_ON_FAILURE)

'Verify the request sent and corresponding response'
jsonMapExpecteddata = CustomKeywords.'jsonData.jsonData.loadjsonfile'('listGenre.json','genres')

log.logInfo("Assert Actual data "+jsonMapActualdata+" again" + " Expected data "+ jsonMapExpecteddata)
Assert.assertEquals(jsonMapExpecteddata, jsonMapActualdata);
