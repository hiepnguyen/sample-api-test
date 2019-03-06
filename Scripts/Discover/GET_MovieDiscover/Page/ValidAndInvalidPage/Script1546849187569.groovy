import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import internal.GlobalVariable as GlobalVariable


KeywordLogger log = new KeywordLogger()

TestData data = findTestData('Data Files/PageData1')

int rows = data.getRowNumbers()


for (def i : (1..rows)) 
{	
		
	if(data.getObjectValue("page", i)==null)
	{
		'Define and send the resquest api'
		def response = WS.sendRequest(findTestObject('Discover/discover', [('host') : GlobalVariable.HOST_API, ('path') : GlobalVariable.PATH_DISCOVER
			, ('token') :GlobalVariable.themoviedbToken,('page'):""]), FailureHandling.STOP_ON_FAILURE)
		'Verify the response'		
		WS.verifyResponseStatusCode(response, GlobalVariable.ok_200, FailureHandling.CONTINUE_ON_FAILURE)
		
		WS.containsString(response, 'OK', false)
		log.logInfo('Response message' + response.getResponseText())
	}
	else
	{		
		def intValue = data.getObjectValue("page", i) as int		
		def response = WS.sendRequest(findTestObject('Discover/discover', [('host') : GlobalVariable.HOST_API, ('path') : GlobalVariable.PATH_DISCOVER
			, ('token') :GlobalVariable.themoviedbToken,('page'):intValue]), FailureHandling.STOP_ON_FAILURE)
	
		if(intValue>0 && intValue<=1000)
		{			
			'Verify the valid page in the request gets correct response'
			WS.verifyResponseStatusCode(response, GlobalVariable.ok_200, FailureHandling.CONTINUE_ON_FAILURE)			
			//WS.containsString(response, 'OK', false)
		}
		else
		{
			'Verify the invalid page in the request gets error'
			WS.verifyResponseStatusCode(response, GlobalVariable.error_422, FailureHandling.CONTINUE_ON_FAILURE)			
			log.logInfo('Response message' + response.getResponseText())			
			if(intValue<=0)
			{
				
				WS.containsString(response, 'page must be greater than 0', false)
			}
			else
			{
				WS.containsString(response, 'page must be less than or equal to 1000', false)
			}
		}
		log.logInfo('Response message' + response.getResponseText())
		
	}	
	
}

