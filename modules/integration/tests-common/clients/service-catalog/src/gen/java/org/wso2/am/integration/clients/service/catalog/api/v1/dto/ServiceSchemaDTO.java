/*
 * Service Catalog APIs
 * This specifies a **RESTful API** for Service Catalog.  # Authentication Our REST APIs are protected using OAuth2 and access control is achieved through scopes. Before you start invoking the the API you need to obtain an access token with the required scopes. This guide will walk you through the steps that you will need to follow to obtain an access token. First you need to obtain the consumer key/secret key pair by calling the dynamic client registration (DCR) endpoint. You can add your preferred grant types in the payload. A Sample payload is shown below. ```   {   \"callbackUrl\":\"www.google.lk\",   \"clientName\":\"rest_api_service_catalog\",   \"owner\":\"admin\",   \"grantType\":\"client_credentials password refresh_token\",   \"saasApp\":true   } ``` Create a file (payload.json) with the above sample payload, and use the cURL shown bellow to invoke the DCR endpoint. Authorization header of this should contain the base64 encoded admin username and password. **Format of the request** ```   curl -X POST -H \"Authorization: Basic Base64(admin_username:admin_password)\" -H \"Content-Type: application/json\"   \\ -d @payload.json https://<host>:<servlet_port>/client-registration/v0.17/register ``` **Sample request** ```   curl -X POST -H \"Authorization: Basic YWRtaW46YWRtaW4=\" -H \"Content-Type: application/json\"   \\ -d @payload.json https://localhost:9443/client-registration/v0.17/register ``` Following is a sample response after invoking the above curl. ``` { \"clientId\": \"fOCi4vNJ59PpHucC2CAYfYuADdMa\", \"clientName\": \"rest_api_service_catalog\", \"callBackURL\": \"www.google.lk\", \"clientSecret\": \"a4FwHlq0iCIKVs2MPIIDnepZnYMa\", \"isSaasApplication\": true, \"appOwner\": \"admin\", \"jsonString\": \"{\\\"grant_types\\\":\\\"client_credentials password refresh_token\\\",\\\"redirect_uris\\\":\\\"www.google.lk\\\",\\\"client_name\\\":\\\"rest_api123\\\"}\", \"jsonAppAttribute\": \"{}\", \"tokenType\": null } ``` Next you must use the above client id and secret to obtain the access token. We will be using the password grant type for this, you can use any grant type you desire. You also need to add the proper **scope** when getting the access token. All possible scopes for Service Catalog REST API can be viewed in **OAuth2 Security** section of this document and scope for each resource is given in **authorization** section of resource documentation. Following is the format of the request if you are using the password grant type. ``` curl -k -d \"grant_type=password&username=<admin_username>&password=<admin_passowrd>&scope=<scopes seperated by space>\" \\ -H \"Authorization: Basic base64(cliet_id:client_secret)\" \\ https://<host>:<servlet_port>/oauth2/token ``` **Sample request** ``` curl https://localhost:9443/oauth2/token -k \\ -H \"Authorization: Basic Zk9DaTR2Tko1OVBwSHVjQzJDQVlmWXVBRGRNYTphNEZ3SGxxMGlDSUtWczJNUElJRG5lcFpuWU1h\" \\ -d \"grant_type=password&username=admin&password=admin&scope=service_catalog:service_view service_catalog:service_write\" ``` Shown below is a sample response to the above request. ``` { \"access_token\": \"e79bda48-3406-3178-acce-f6e4dbdcbb12\", \"refresh_token\": \"a757795d-e69f-38b8-bd85-9aded677a97c\", \"scope\": \"service_catalog:service_view service_catalog:service_write\", \"token_type\": \"Bearer\", \"expires_in\": 3600 } ``` Now you have a valid access token, which you can use to invoke an API. Navigate through the API descriptions to find the required API, obtain an access token as described above and invoke the API with the authentication header. If you use a different authentication mechanism, this process may change. 
 *
 * The version of the OpenAPI document: 1.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.wso2.am.integration.clients.service.catalog.api.v1.dto;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.File;
import java.io.IOException;
import org.wso2.am.integration.clients.service.catalog.api.v1.dto.ServiceDTO;
import com.fasterxml.jackson.annotation.JsonCreator;
/**
* ServiceSchemaDTO
*/

public class ServiceSchemaDTO {
        public static final String SERIALIZED_NAME_SERVICE_METADATA = "serviceMetadata";
        @SerializedName(SERIALIZED_NAME_SERVICE_METADATA)
            private ServiceDTO serviceMetadata;

        public static final String SERIALIZED_NAME_DEFINITION_FILE = "definitionFile";
        @SerializedName(SERIALIZED_NAME_DEFINITION_FILE)
            private File definitionFile;

        public static final String SERIALIZED_NAME_INLINE_CONTENT = "inlineContent";
        @SerializedName(SERIALIZED_NAME_INLINE_CONTENT)
            private String inlineContent;


        public ServiceSchemaDTO serviceMetadata(ServiceDTO serviceMetadata) {
        
        this.serviceMetadata = serviceMetadata;
        return this;
        }

    /**
        * Get serviceMetadata
    * @return serviceMetadata
    **/
      @ApiModelProperty(required = true, value = "")
    
    public ServiceDTO getServiceMetadata() {
        return serviceMetadata;
    }


    public void setServiceMetadata(ServiceDTO serviceMetadata) {
        this.serviceMetadata = serviceMetadata;
    }


        public ServiceSchemaDTO definitionFile(File definitionFile) {
        
        this.definitionFile = definitionFile;
        return this;
        }

    /**
        * Get definitionFile
    * @return definitionFile
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(value = "")
    
    public File getDefinitionFile() {
        return definitionFile;
    }


    public void setDefinitionFile(File definitionFile) {
        this.definitionFile = definitionFile;
    }


        public ServiceSchemaDTO inlineContent(String inlineContent) {
        
        this.inlineContent = inlineContent;
        return this;
        }

    /**
        * Inline content of the document
    * @return inlineContent
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(value = "Inline content of the document")
    
    public String getInlineContent() {
        return inlineContent;
    }


    public void setInlineContent(String inlineContent) {
        this.inlineContent = inlineContent;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
        return true;
        }
        if (o == null || getClass() != o.getClass()) {
        return false;
        }
            ServiceSchemaDTO serviceSchema = (ServiceSchemaDTO) o;
            return Objects.equals(this.serviceMetadata, serviceSchema.serviceMetadata) &&
            Objects.equals(this.definitionFile, serviceSchema.definitionFile) &&
            Objects.equals(this.inlineContent, serviceSchema.inlineContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviceMetadata, definitionFile, inlineContent);
    }


@Override
public String toString() {
StringBuilder sb = new StringBuilder();
sb.append("class ServiceSchemaDTO {\n");
    sb.append("    serviceMetadata: ").append(toIndentedString(serviceMetadata)).append("\n");
    sb.append("    definitionFile: ").append(toIndentedString(definitionFile)).append("\n");
    sb.append("    inlineContent: ").append(toIndentedString(inlineContent)).append("\n");
sb.append("}");
return sb.toString();
}

/**
* Convert the given object to string with each line indented by 4 spaces
* (except the first line).
*/
private String toIndentedString(Object o) {
if (o == null) {
return "null";
}
return o.toString().replace("\n", "\n    ");
}

}

