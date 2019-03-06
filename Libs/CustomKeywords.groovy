
/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */

import java.lang.String

import java.util.ArrayList

import com.kms.katalon.core.model.FailureHandling


def static "jsonData.jsonData.write2jsonfile"(
    	String str	) {
    (new jsonData.jsonData()).write2jsonfile(
        	str)
}

def static "jsonData.jsonData.writemap2jsonfile"(
    	ArrayList arr	
     , 	String jsonfilename	
     , 	FailureHandling flowControl	) {
    (new jsonData.jsonData()).writemap2jsonfile(
        	arr
         , 	jsonfilename
         , 	flowControl)
}

def static "jsonData.jsonData.loadjsonfile"(
    	String jsonfilename	
     , 	String fieldname	
     , 	FailureHandling flowControl	) {
    (new jsonData.jsonData()).loadjsonfile(
        	jsonfilename
         , 	fieldname
         , 	flowControl)
}

def static "jsonData.jsonData.getCurrentYear"() {
    (new jsonData.jsonData()).getCurrentYear()
}

def static "jsonData.jsonData.writemap2jsonfile"(
    	ArrayList arr	
     , 	String jsonfilename	) {
    (new jsonData.jsonData()).writemap2jsonfile(
        	arr
         , 	jsonfilename)
}

def static "jsonData.jsonData.loadjsonfile"(
    	String jsonfilename	
     , 	String fieldname	) {
    (new jsonData.jsonData()).loadjsonfile(
        	jsonfilename
         , 	fieldname)
}

def static "jsonData.mapHelper.randomFromList"(
    	ArrayList list	) {
    (new jsonData.mapHelper()).randomFromList(
        	list)
}
