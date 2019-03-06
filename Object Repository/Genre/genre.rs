<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>genre</name>
   <tag></tag>
   <elementGuidId>c0d2de66-a938-4a6b-ba64-a90436e12670</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  \&quot;username\&quot;: \&quot;${username}\&quot;,\n  \&quot;password\&quot;: \&quot;${password}\&quot;\n}&quot;,
  &quot;contentType&quot;: &quot;application/json&quot;,
  &quot;charset&quot;: &quot;UTF-8&quot;
}</httpBodyContent>
   <httpBodyType>text</httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>application/json</value>
   </httpHeaderProperties>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>GET</restRequestMethod>
   <restUrl>https://${host}${path}?api_key=${token}&amp;language=pt-US</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceFunction></soapServiceFunction>
   <variables>
      <defaultValue>GlobalVariable.HOST_API</defaultValue>
      <description></description>
      <id>72b86028-8aa7-4148-9b50-773aad845c87</id>
      <masked>false</masked>
      <name>host</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.PATH_GENRE_LIST</defaultValue>
      <description></description>
      <id>afaefeb2-fa11-434a-9920-b3cb5bd98257</id>
      <masked>false</masked>
      <name>path</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.themoviedbToken</defaultValue>
      <description></description>
      <id>98c12fb4-17d2-40d8-b93b-529835201881</id>
      <masked>false</masked>
      <name>token</name>
   </variables>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()

//def jsonSlurper = new JsonSlurper()

//def jsonResponse = jsonSlurper.parseText(response.getResponseText())

//WS.verifyResponseStatusCode(response, 200)

//assertThat(response.getStatusCode()).isEqualTo(200)

//def jsonSlurper = new JsonSlurper()

//def jsonResponse = jsonSlurper.parseText(response.getResponseText())
</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
