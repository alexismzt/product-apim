/*
 * WSO2 API Manager - Publisher API
 * This specifies a **RESTful API** for WSO2 **API Manager** - Publisher.  Please see [full swagger definition](https://raw.githubusercontent.com/wso2/carbon-apimgt/v6.0.4/components/apimgt/org.wso2.carbon.apimgt.rest.api.publisher/src/main/resources/publisher-api.yaml) of the API which is written using [swagger 2.0](http://swagger.io/) specification. 
 *
 * OpenAPI spec version: 0.10.0
 * Contact: architecture@wso2.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package org.wso2.carbon.apimgt.rest.integration.tests.api.publisher;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.wso2.carbon.apimgt.rest.integration.tests.publisher.ApiResponse;
import org.wso2.carbon.apimgt.rest.integration.tests.publisher.api.APICollectionApi;
import org.wso2.carbon.apimgt.rest.integration.tests.publisher.ApiException;
import org.wso2.carbon.apimgt.rest.integration.tests.publisher.model.APIList;
import org.wso2.carbon.apimgt.rest.integration.tests.publisher.api.APIIndividualApi;
import org.wso2.carbon.apimgt.rest.integration.tests.publisher.model.API;
import org.wso2.carbon.apimgt.rest.integration.tests.publisher.model.APIBusinessInformation;
import org.wso2.carbon.apimgt.rest.integration.tests.publisher.model.APICorsConfiguration;
import org.wso2.carbon.apimgt.rest.integration.tests.publisher.model.Sequence;
import org.testng.annotations.Test;

import java.util.ArrayList;

/**
 * API tests for APICollectionApi
 */
public class APICollectionApiIT {

    private final APICollectionApi api = new APICollectionApi();
    private static String apiID;
    /**
     * Retrieve/Search APIs
     * <p>
     * This operation provides you a list of available APIs qualifying under a given search condition.  Each retrieved API is represented with a minimal amount of attributes. If you want to get complete details of an API, you need to use **Get details of an API** operation.
     *
     * @throws ApiException if the Api call fails
     */
    @Test(priority = 1)
    public void apisGetTest() throws ApiException {
        Integer limit = 10;
        Integer offset = 0;
        String query = null;
        String accept = null;
        String ifNoneMatch = null;
        APIList response = api.apisGet(limit, offset, query, ifNoneMatch);
        System.out.println(response);
        Assert.assertEquals(response.getList().get(0).getName(), "API-117", "API name mismatch");
        Assert.assertEquals(response.getList().get(0).getId(), apiID, "API Id mismatch");
        Assert.assertEquals(response.getList().get(0).getDescription(), "This is the api description", "API description mismatch");
        Assert.assertEquals(response.getList().get(0).getContext(), "API-117", "API description mismatch");
        Assert.assertEquals(response.getList().get(0).getVersion(), "1.0.0", "API version mismatch");
        Assert.assertEquals(response.getList().get(0).getLifeCycleStatus(), "Created", "API Lifecycle status mismatch");
    }

    /**
     * Check given API attibute name is already exist
     * <p>
     * Using this operation, you can check a given API context is already used. You need to provide the context name you want to check.
     *
     * @throws ApiException if the Api call fails
     */
    @Test(priority = 2)
    public void apisHeadTest() throws ApiException {
        String query = "name:API-117";
        String accept = null;
        String ifNoneMatch = null;
        ApiResponse response = api.apisHeadWithHttpInfo(query, ifNoneMatch);
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200, "status code mismatch");
    }

    /**
     * Check for error if given API attribute does not exist
     * @throws ApiException
     */
    @Test(priority = 3)
    public void apisHeadFailureTest() throws ApiException {
        String query = "name:DoesNotExist";
        String accept = null;
        String ifNoneMatch = null;
        ApiResponse response = api.apisHeadWithHttpInfo(query, ifNoneMatch);
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 404, "status code mismatch");
    }

    /**
     * Create a new API
     * <p>
     * This operation can be used to create a new API specifying the details of the API in the payload. The new API will be in &#x60;CREATED&#x60; state.  There is a special capability for a user who has &#x60;APIM Admin&#x60; permission such that he can create APIs on behalf of other users. For that he can to specify &#x60;\&quot;provider\&quot; : \&quot;some_other_user\&quot;&#x60; in the payload so that the API&#39;s creator will be shown as &#x60;some_other_user&#x60; in the UI.
     *
     * @throws ApiException if the Api call fails
     */
    @Test(priority = 0)
    public void apisPostTest() throws ApiException {
        API body = new API();
        String contentType = "application/json";

        body.setName("API-117");
        body.setDescription("This is the api description");
        body.setContext("API-117");
        body.setVersion("1.0.0");
        body.setProvider("admin");
        body.setLifeCycleStatus("CREATED");
        body.setTransport(new ArrayList<String>() {{
            add("http");
        }});
        body.setCacheTimeout(100);
        body.setPolicies(new ArrayList<String>() {{
            add("Unlimited");
        }});
        body.setVisibility(API.VisibilityEnum.PUBLIC);
        body.setTags(new ArrayList<String>());
        body.setVisibleRoles(new ArrayList<String>());
        body.setVisibleTenants(new ArrayList<String>());
        body.setSequences(new ArrayList<Sequence>());
        body.setBusinessInformation(new APIBusinessInformation());
        body.setCorsConfiguration(new APICorsConfiguration());
        API response = api.apisPost(body);
        this.apiID = response.getId();

        Assert.assertEquals(response.getName(), "API-117", "api name mismatch");
        Assert.assertEquals(response.getDescription(), "This is the api description", "API description mismatch");
        Assert.assertEquals(response.getContext(), "API-117", "API context mismatch");
        Assert.assertEquals(response.getVersion(), "1.0.0", "API version mismatch");
        Assert.assertEquals(response.getLifeCycleStatus(), "Created", "API Lifecycle status mismatch");

    }

    @Test(priority = 4)
    public void apisPostTest_NF() throws ApiException {
            API body = new API();
            String contentType = "application/json";

            try {
                //body.setName("API-117");
                body.setDescription("This is the api description");
                body.setContext("API-117");
                body.setVersion("1.0.0");
                body.setProvider("admin");
                body.setLifeCycleStatus("CREATED");
                body.setTransport(new ArrayList<String>() {{
                    add("http");
                }});
                body.setCacheTimeout(100);
                body.setPolicies(new ArrayList<String>() {{
                    add("Unlimited");
                }});
                body.setVisibility(API.VisibilityEnum.PUBLIC);
                body.setTags(new ArrayList<String>());
                body.setVisibleRoles(new ArrayList<String>());
                body.setVisibleTenants(new ArrayList<String>());
                body.setSequences(new ArrayList<Sequence>());
                body.setBusinessInformation(new APIBusinessInformation());
                body.setCorsConfiguration(new APICorsConfiguration());
                API response = api.apisPost(body);
                this.apiID = response.getId();
            }catch (Exception e)
            {
                System.out.println("response is "+e.getMessage());
                Assert.assertEquals(e.getMessage(), "name: may not be null", "Exception message mismatch");
            }
    }

    @AfterClass
    public void afterClass() throws ApiException {
        APIIndividualApi apiClient = new APIIndividualApi();

        APIList response = api.apisGet(1, 0, null, null);

        String apiId = response.getList().get(0).getId();
        String ifMatch = null;
        String ifUnmodifiedSince = null;
        apiClient.apisApiIdDelete(apiId, ifMatch, ifUnmodifiedSince);
    }

}
