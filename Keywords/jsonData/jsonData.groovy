package jsonData

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.sql.Array

import org.stringtemplate.v4.compiler.CodeGenerator.region_return

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import groovy.json.JsonBuilder

import internal.GlobalVariable


class Movie {
	Integer id
	String title
	String original_language
}
@Keyword
def write2jsonfile(String str){
	println str
}
/**
 * parse the response and build the JSON file the readable structure. see the topthree.json file in the data file dir
 * @param dest file path of destination, including extension
 * @param the array of movie parsing from the response text * 
 * @author KMS Turing team
 */
@Keyword
def writemap2jsonfile(ArrayList arr, String jsonfilename, FailureHandling flowControl=FailureHandling.STOP_ON_FAILURE){

	try {
		movies =[]
		for (i = 0; i <3; i++){

			Movie movie = new Movie(
					id: arr[i].id,
					title: arr[i].title,
					original_language: arr[i].original_language
					)
			movies.add(JsonOutput.toJson(movie))
		}
		'----------------------save json file--------------------'
		println "saved list movie" + movies
		File g = new File(GlobalVariable.tempDir+File.separator+jsonfilename)
		g.createNewFile()
		g.setText("{\"movie\":"+movies.toString()+"}")
	}
	catch(ex){
		handleError ex, flowControl
	}
}
/**
 * parse the response and build the JSON file the readable structure. see the topthree.json file in the data file dir
 * @param dest file path of source, including extension
 * @param key of the JSON object such as "movie","genres","sort by"
 * @param the array of movie return from the file *
 * @author Turing team
 */
@Keyword
def ArrayList loadjsonfile(String jsonfilename, String fieldname, FailureHandling flowControl=FailureHandling.STOP_ON_FAILURE){

	try {
		File f = new File(GlobalVariable.tempDir+File.separator+jsonfilename)
		def jsontext = f.getText()
		def jsonObject = new JsonSlurper()
		jsonMap = (jsonObject.parseText(jsontext ))."${fieldname}"
		return jsonMap
	}
	catch(ex){
		handleError ex, flowControl
	}
}
/**
 * parse the response and build the JSON file the readable structure. see the topthree.json file in the data file dir
 * @param dest file path of source, including extension
 * @param key of the JSON object such as "movie","genres","sort by"
 * @param the array of movie return from the file *
 * @author Turing team
 */

@Keyword
def String getCurrentYear() {
	try{
		Date today = new Date()
		String dateFormat = today.format('yyyy')
		GlobalVariable.currYear= dateFormat
		println "print in keywords"+ GlobalVariable.currYear
	}
	catch (Exception  ex){
		println("Can not get current Year")
	}
}

