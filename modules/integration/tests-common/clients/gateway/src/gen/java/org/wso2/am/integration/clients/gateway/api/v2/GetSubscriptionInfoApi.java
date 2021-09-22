/*
 * WSO2 API Manager - Gateway
 * This document specifies a **RESTful API** for WSO2 **API Manager** - Gateway. Please see [full swagger definition](https://raw.githubusercontent.com/wso2/carbon-apimgt/master/components/apimgt/org.wso2.carbon.apimgt.rest.api.gateway/src/main/resources/gateway-api.yaml) of the API which is written using [swagger 2.0](http://swagger.io/) specification. 
 *
 * OpenAPI spec version: v2
 * Contact: architecture@wso2.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package org.wso2.am.integration.clients.gateway.api.v2;

import org.wso2.am.integration.clients.gateway.api.ApiCallback;
import org.wso2.am.integration.clients.gateway.api.ApiClient;
import org.wso2.am.integration.clients.gateway.api.ApiException;
import org.wso2.am.integration.clients.gateway.api.ApiResponse;
import org.wso2.am.integration.clients.gateway.api.Configuration;
import org.wso2.am.integration.clients.gateway.api.Pair;
import org.wso2.am.integration.clients.gateway.api.ProgressRequestBody;
import org.wso2.am.integration.clients.gateway.api.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import org.wso2.am.integration.clients.gateway.api.v2.dto.ErrorDTO;
import org.wso2.am.integration.clients.gateway.api.v2.dto.SubscriptionDTO;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetSubscriptionInfoApi {
    private ApiClient apiClient;

    public GetSubscriptionInfoApi() {
        this(Configuration.getDefaultApiClient());
    }

    public GetSubscriptionInfoApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for subscriptionsGet
     * @param apiUUID UUID of the API  (optional)
     * @param appUUID UUID of the Application  (optional)
     * @param tenantDomain Tenant Domain of the Application  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call subscriptionsGetCall(String apiUUID, String appUUID, String tenantDomain, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/subscriptions";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (apiUUID != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("apiUUID", apiUUID));
        if (appUUID != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("appUUID", appUUID));
        if (tenantDomain != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("tenantDomain", tenantDomain));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call subscriptionsGetValidateBeforeCall(String apiUUID, String appUUID, String tenantDomain, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        

        com.squareup.okhttp.Call call = subscriptionsGetCall(apiUUID, appUUID, tenantDomain, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Get the subscriptions meta information of an api by providing the api uuid and application uuid.
     * This operation is used to get the subscription information of an API from storage. If the Tenant domain is not provided carbon.super will be picked as the Tenant domain. 
     * @param apiUUID UUID of the API  (optional)
     * @param appUUID UUID of the Application  (optional)
     * @param tenantDomain Tenant Domain of the Application  (optional)
     * @return SubscriptionDTO
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public SubscriptionDTO subscriptionsGet(String apiUUID, String appUUID, String tenantDomain) throws ApiException {
        ApiResponse<SubscriptionDTO> resp = subscriptionsGetWithHttpInfo(apiUUID, appUUID, tenantDomain);
        return resp.getData();
    }

    /**
     * Get the subscriptions meta information of an api by providing the api uuid and application uuid.
     * This operation is used to get the subscription information of an API from storage. If the Tenant domain is not provided carbon.super will be picked as the Tenant domain. 
     * @param apiUUID UUID of the API  (optional)
     * @param appUUID UUID of the Application  (optional)
     * @param tenantDomain Tenant Domain of the Application  (optional)
     * @return ApiResponse&lt;SubscriptionDTO&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<SubscriptionDTO> subscriptionsGetWithHttpInfo(String apiUUID, String appUUID, String tenantDomain) throws ApiException {
        com.squareup.okhttp.Call call = subscriptionsGetValidateBeforeCall(apiUUID, appUUID, tenantDomain, null, null);
        Type localVarReturnType = new TypeToken<SubscriptionDTO>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get the subscriptions meta information of an api by providing the api uuid and application uuid. (asynchronously)
     * This operation is used to get the subscription information of an API from storage. If the Tenant domain is not provided carbon.super will be picked as the Tenant domain. 
     * @param apiUUID UUID of the API  (optional)
     * @param appUUID UUID of the Application  (optional)
     * @param tenantDomain Tenant Domain of the Application  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call subscriptionsGetAsync(String apiUUID, String appUUID, String tenantDomain, final ApiCallback<SubscriptionDTO> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = subscriptionsGetValidateBeforeCall(apiUUID, appUUID, tenantDomain, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<SubscriptionDTO>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
