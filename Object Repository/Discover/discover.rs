<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>discover</name>
   <tag></tag>
   <elementGuidId>a3b75f9b-8e60-4403-aa0f-f2a104b8cc78</elementGuidId>
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
   <restUrl>https://${host}${path}?api_key=${token}&amp;language=en-US&amp;sort_by=popularity.desc&amp;include_adult=false&amp;include_video=false&amp;primary_release_date.lte=&amp;with_genres=&amp;year=&amp;with_keywords=&amp;page=${page}</restUrl>
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
      <defaultValue>GlobalVariable.PATH_DISCOVER</defaultValue>
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
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>a2ed80dd-6d30-4ed7-bbae-2d2dea63d96e</id>
      <masked>false</masked>
      <name>date</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>8c2deb60-7f39-4239-83d9-5539af3afc2c</id>
      <masked>false</masked>
      <name>genre</name>
   </variables>
   <variables>
      <defaultValue>0</defaultValue>
      <description></description>
      <id>f306954d-9108-45b9-a1b7-c7b920362d00</id>
      <masked>false</masked>
      <name>page</name>
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
