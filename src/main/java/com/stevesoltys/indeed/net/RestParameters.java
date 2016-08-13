package com.stevesoltys.indeed.net;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Parameters for use with a {@link RestClient}.
 *
 * @author Steve Soltys
 */
public class RestParameters {

    /**
     * The 'job keys' key.
     */
    private static final String JOB_KEYS_KEY = "jobkeys";

    /**
     * The version key.
     */
    private static final String VERSION_KEY = "v";

    /**
     * The publisher ID key.
     */
    private static final String PUBLISHER_ID_KEY = "publisher";

    /**
     * The character encoding used for URL parameters.
     */
    private static final String PARAMETER_ENCODING = "UTF-8";

    /**
     * The parameters map.
     */
    private final Map<String, String> parameters;

    /**
     * Creates a search parameter set, given the parameter map.
     *
     * @param parameters The parameter map.
     */
    public RestParameters(Map<String, String> parameters) {
        this.parameters = parameters;
    }

    /**
     * Creates a job query parameter set, given the publisher id and job key.
     *
     * @param publisherId The publisher id.
     * @param jobKey      The job key.
     */
    public RestParameters(String publisherId, String jobKey) {
        Map<String, String> parameters = new HashMap<>();

        parameters.put(VERSION_KEY, "2");
        parameters.put(PUBLISHER_ID_KEY, publisherId);
        parameters.put(JOB_KEYS_KEY, jobKey);

        this.parameters = parameters;
    }

    /**
     * Sets the publisher id.
     *
     * @param publisherId The publisher id.
     */
    public void setPublisherId(String publisherId) {
        parameters.put(PUBLISHER_ID_KEY, publisherId);
    }

    /**
     * URL encodes the parameter map and returns the result as a string.
     *
     * @return The URL encoded string.
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        parameters.forEach((key, value) -> {
            try {

                stringBuilder.append(URLEncoder.encode(key, PARAMETER_ENCODING));
                stringBuilder.append("=");

                stringBuilder.append(URLEncoder.encode(value, PARAMETER_ENCODING));
                stringBuilder.append("&");

            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

        });

        return stringBuilder.toString();
    }
}
