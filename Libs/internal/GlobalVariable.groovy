package internal

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase

/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */
public class GlobalVariable {
     
    /**
     * <p></p>
     */
    public static Object error_400
     
    /**
     * <p>Profile movieAPI : Unauthorized access code and message on responses</p>
     */
    public static Object error_401
     
    /**
     * <p>Profile movieAPI : successfully request</p>
     */
    public static Object ok_200
     
    /**
     * <p></p>
     */
    public static Object error_500
     
    /**
     * <p>Profile movieAPI : host of movie db</p>
     */
    public static Object HOST_API
     
    /**
     * <p>Profile movieAPI : path to genres</p>
     */
    public static Object PATH_GENRE_LIST
     
    /**
     * <p>Profile movieAPI : path to movie</p>
     */
    public static Object PATH_MOVIE
     
    /**
     * <p>Profile movieAPI : api credentials</p>
     */
    public static Object themoviedbToken
     
    /**
     * <p>Profile movieAPI : json test data</p>
     */
    public static Object tempDir
     
    /**
     * <p>Profile movieAPI : discover movie</p>
     */
    public static Object PATH_DISCOVER
     
    /**
     * <p>Profile movieAPI : 422 Unprocessable Entity</p>
     */
    public static Object error_422
     
    /**
     * <p></p>
     */
    public static Object PATH_INVALID
     
    /**
     * <p></p>
     */
    public static Object error_404
     
    /**
     * <p></p>
     */
    public static Object currYear
     
    /**
     * <p></p>
     */
    public static Object PATH_SEARCH_MOVIE
     

    static {
        def allVariables = [:]        
        allVariables.put('movieAPI', ['error_400' : 400, 'error_401' : 401, 'ok_200' : 200, 'error_500' : 500, 'HOST_API' : 'api.themoviedb.org', 'PATH_GENRE_LIST' : '/3/genre/movie/list', 'PATH_MOVIE' : '/3/movie/551', 'themoviedbToken' : 'b59556b3a71343ce8fffafe1337cb080', 'tempDir' : 'Data Files\\\\jsons', 'PATH_DISCOVER' : '/3/discover/movie', 'error_422' : 422, 'PATH_INVALID' : '/3/2/1', 'error_404' : '404', 'currYear' : 2018, 'PATH_SEARCH_MOVIE' : '/3/movie/movie_id'])
        
        String profileName = RunConfiguration.getExecutionProfile()
        def selectedVariables = allVariables[profileName]
		
		for(object in selectedVariables){
			String overridingGlobalVariable = RunConfiguration.getOverridingGlobalVariable(object.key)
			if(overridingGlobalVariable != null){
				selectedVariables.put(object.key, overridingGlobalVariable)
			}
		}

        error_400 = selectedVariables["error_400"]
        error_401 = selectedVariables["error_401"]
        ok_200 = selectedVariables["ok_200"]
        error_500 = selectedVariables["error_500"]
        HOST_API = selectedVariables["HOST_API"]
        PATH_GENRE_LIST = selectedVariables["PATH_GENRE_LIST"]
        PATH_MOVIE = selectedVariables["PATH_MOVIE"]
        themoviedbToken = selectedVariables["themoviedbToken"]
        tempDir = selectedVariables["tempDir"]
        PATH_DISCOVER = selectedVariables["PATH_DISCOVER"]
        error_422 = selectedVariables["error_422"]
        PATH_INVALID = selectedVariables["PATH_INVALID"]
        error_404 = selectedVariables["error_404"]
        currYear = selectedVariables["currYear"]
        PATH_SEARCH_MOVIE = selectedVariables["PATH_SEARCH_MOVIE"]
        
    }
}
