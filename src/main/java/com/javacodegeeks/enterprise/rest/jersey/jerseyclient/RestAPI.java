package com.javacodegeeks.enterprise.rest.jersey.jerseyclient;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import org.codehaus.jackson.map.ObjectMapper;

import java.util.ArrayList;
import java.util.HashMap;

public class RestAPI {

    public static HashMap<String, Object> callPost(String url, String parameter) {
        try {
            ClientConfig clientConfig = new DefaultClientConfig();
            clientConfig.getFeatures().put(
                    JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
            Client client = Client.create(clientConfig);
            WebResource webResource = client
                    .resource(url);
            ClientResponse response = webResource.accept("application/json")
                    .type("application/json").post(ClientResponse.class, parameter);
            return (HashMap<String, Object>) new ObjectMapper().readValue(response.getEntity(String.class), HashMap.class);
        } catch (Exception e) {
            e.printStackTrace();
            return new HashMap<>();
        }
    }

    public static ArrayList<HashMap<String, Object>> callPostWithList(String url, String parameter) {
        try {
            ClientConfig clientConfig = new DefaultClientConfig();
            clientConfig.getFeatures().put(
                    JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
            Client client = Client.create(clientConfig);
            WebResource webResource = client
                    .resource(url);
            ClientResponse response = webResource.accept("application/json")
                    .type("application/json").post(ClientResponse.class, parameter);
            return (ArrayList<HashMap<String, Object>>) new ObjectMapper().readValue(response.getEntity(String.class), ArrayList.class);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static HashMap<String, Object> callPatch(String url, String parameter) {
        try {
            ClientConfig clientConfig = new DefaultClientConfig();
            clientConfig.getFeatures().put(
                    JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
            Client client = Client.create(clientConfig);

            WebResource webResource = client
                    .resource(url);
            ClientResponse response = webResource.accept("application/json")
                    .type("application/json").method("PATCH", ClientResponse.class, parameter);
            return (HashMap<String, Object>) new ObjectMapper().readValue(response.getEntity(String.class), HashMap.class);
        } catch (Exception e) {
            e.printStackTrace();
            return new HashMap<>();
        }
    }

    public static ArrayList<HashMap<String, Object>> callPatchWithList(String url, String parameter) {
        try {
            ClientConfig clientConfig = new DefaultClientConfig();
            clientConfig.getFeatures().put(
                    JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
            Client client = Client.create(clientConfig);
            WebResource webResource = client
                    .resource(url);
            ClientResponse response = webResource.accept("application/json")
                    .type("application/json").method("PATCH", ClientResponse.class, parameter);
            return (ArrayList<HashMap<String, Object>>) new ObjectMapper().readValue(response.getEntity(String.class), ArrayList.class);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static HashMap<String, Object> callGet(String url) {
        try {
            ClientConfig clientConfig = new DefaultClientConfig();
            clientConfig.getFeatures().put(
                    JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
            Client client = Client.create(clientConfig);
            WebResource webResource = client
                    .resource(url);
            ClientResponse response = webResource.accept("application/json")
                    .type("application/json").get(ClientResponse.class);
            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatus());
            }
            return (HashMap<String, Object>) new ObjectMapper().readValue(response.getEntity(String.class), HashMap.class);
        } catch (Exception e) {
            e.printStackTrace();
            return new HashMap<>();
        }
    }

    public static ArrayList<HashMap<String, Object>> callGetWithList(String url) {
        try {
            ClientConfig clientConfig = new DefaultClientConfig();
            clientConfig.getFeatures().put(
                    JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
            Client client = Client.create(clientConfig);
            WebResource webResource = client
                    .resource(url);
            ClientResponse response = webResource.accept("application/json")
                    .type("application/json").get(ClientResponse.class);
            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatus());
            }
            return (ArrayList<HashMap<String, Object>>) new ObjectMapper().readValue(response.getEntity(String.class), ArrayList.class);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

}
