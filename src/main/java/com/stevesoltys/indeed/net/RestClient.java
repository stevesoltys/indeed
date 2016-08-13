package com.stevesoltys.indeed.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * A REST client.
 *
 * @author Steve Soltys
 */
public class RestClient {

    /**
     * The listing search resource URL.
     */
    protected static final String SEARCH_RESOURCE_URL = "http://api.indeed.com/ads/apisearch";

    /**
     * The job resource URL.
     */
    protected static final String JOB_RESOURCE_URL = "http://api.indeed.com/ads/apigetjobs";

    /**
     * Performs a GET request on the given URL string.
     *
     * @param url The URL.
     * @return The response.
     * @throws IOException If there is an error performing the request.
     */
    public String get(String url) throws IOException {

        URLConnection connection = new URL(url).openConnection();
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        StringBuilder responseBuilder = new StringBuilder();

        String line;
        while ((line = reader.readLine()) != null) {
            responseBuilder.append(line).append("\n");
        }

        reader.close();

        return responseBuilder.toString();
    }

    /**
     * Creates a job URL, given the parameters.
     *
     * @param parameters The parameters.
     * @return The result URL.
     */
    public String createJobUrl(RestParameters parameters) {
        return JOB_RESOURCE_URL + "?" + parameters.toString();
    }

    /**
     * Creates a search URL, given the parameters.
     *
     * @param parameters The parameters.
     * @return The result URL.
     */
    public String createSearchUrl(RestParameters parameters) {
        return SEARCH_RESOURCE_URL + "?" + parameters.toString();
    }

}
