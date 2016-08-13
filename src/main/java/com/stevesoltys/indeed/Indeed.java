package com.stevesoltys.indeed;

import com.stevesoltys.indeed.exception.IndeedParseException;
import com.stevesoltys.indeed.model.IndeedResult;
import com.stevesoltys.indeed.model.IndeedSearchResults;
import com.stevesoltys.indeed.model.SearchBuilder;
import com.stevesoltys.indeed.net.RestClient;
import com.stevesoltys.indeed.net.RestParameters;
import com.stevesoltys.indeed.util.ResponseParser;
import com.stevesoltys.indeed.util.ResultParser;

import java.io.IOException;

/**
 * The Indeed search API wrapper.
 *
 * @author Steve Soltys
 */
public class Indeed {

    /**
     * The publisher id.
     */
    private final String publisherId;

    /**
     * The REST client.
     */
    private final RestClient restClient;

    /**
     * The Indeed API response parser.
     */
    private final ResponseParser responseParser;

    public Indeed(String publisherId) {
        this(publisherId, new RestClient());
    }

    public Indeed(String publisherId, RestClient restClient) {
        this(publisherId, restClient, new ResponseParser(new ResultParser()));
    }

    public Indeed(String publisherId, RestClient restClient, ResponseParser responseParser) {
        this.publisherId = publisherId;
        this.restClient = restClient;
        this.responseParser = responseParser;
    }

    /**
     * Performs a search, given the REST parameters.
     *
     * @param parameters The parameters.
     * @return The Indeed search results.
     * @throws IOException If there was an error querying the API.
     * @throws IndeedParseException If there was an error parsing the API result.
     */
    public IndeedSearchResults getListings(RestParameters parameters) throws IOException, IndeedParseException {
        parameters.setPublisherId(publisherId);

        String searchUrl = restClient.createSearchUrl(parameters);
        return responseParser.parseSearch(restClient.get(searchUrl));
    }

    /**
     * Gets a job, given the job key.
     *
     * @param jobKey The job key.
     * @return The Indeed search results.
     * @throws IOException If there was an error querying the API.
     * @throws IndeedParseException If there was an error parsing the API result.
     */
    public IndeedResult getJob(String jobKey) throws IOException, IndeedParseException {
        RestParameters query = new RestParameters(publisherId, jobKey);

        String searchUrl = restClient.createJobUrl(query);
        return responseParser.parseJob(restClient.get(searchUrl));
    }

    /**
     * Creates and returns a search builder, for chaining.
     *
     * @return The search builder.
     */
    public SearchBuilder search() {
        return new SearchBuilder(this);
    }

}
