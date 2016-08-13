package com.stevesoltys.indeed.model;

import com.stevesoltys.indeed.Indeed;
import com.stevesoltys.indeed.exception.IndeedParameterException;
import com.stevesoltys.indeed.exception.IndeedParseException;
import com.stevesoltys.indeed.net.RestParameters;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Used to build Indeed API queries.
 *
 * @author Steve Soltys
 */
public class SearchBuilder {

    /**
     * The version key.
     */
    private static final String VERSION_KEY = "v";

    /**
     * The format key.
     */
    private static final String FORMAT_KEY = "format";

    /**
     * The callback key.
     */
    private static final String CALLBACK_KEY = "callback";

    /**
     * The query key.
     */
    private static final String QUERY_KEY = "q";

    /**
     * The location key.
     */
    private static final String LOCATION_KEY = "l";

    /**
     * The sort key.
     */
    private static final String SORT_KEY = "sort";

    /**
     * The radius key.
     */
    private static final String RADIUS_KEY = "radius";

    /**
     * The site type key.
     */
    private static final String SITE_TYPE_KEY = "st";

    /**
     * The job type key.
     */
    private static final String JOB_TYPE_KEY = "jt";

    /**
     * THe start key.
     */
    private static final String START_KEY = "start";

    /**
     * The limit key.
     */
    private static final String LIMIT_KEY = "limit";

    /**
     * The backlog limit key.
     */
    private static final String BACKLOG_LIMIT_KEY = "fromage";

    /**
     * The highlight key.
     */
    private static final String HIGHLIGHT_KEY = "highlight";

    /**
     * The filter key.
     */
    private static final String FILTER_KEY = "filter";

    /**
     * The coordinates key.
     */
    private static final String LATITUDE_LONGITUDE_KEY = "latlong";

    /**
     * The country key.
     */
    private static final String COUNTRY_KEY = "co";

    /**
     * The channel key.
     */
    private static final String CHANNEL_KEY = "chnl";

    /**
     * The user ip key.
     */
    private static final String USER_IP_KEY = "userip";

    /**
     * The user agent key.
     */
    private static final String USER_AGENT_KEY = "useragent";

    /**
     * The keys that are required for every search.
     */
    private static final String[] REQUIRED_KEYS = {LOCATION_KEY, QUERY_KEY, VERSION_KEY, USER_IP_KEY, USER_AGENT_KEY};

    /**
     * The map of parameters.
     */
    private final Map<String, String> parameters = new HashMap<>();

    /**
     * The Indeed instance.
     */
    private final Indeed indeed;

    public SearchBuilder(Indeed indeed) {
        this.indeed = indeed;

        setDefaults();
    }

    /**
     * Sets the default search values.
     */
    private void setDefaults() {

        parameters.put(VERSION_KEY, "2");
        parameters.put(USER_IP_KEY, "1.2.3.4");
        parameters.put(USER_AGENT_KEY, "Mozilla Firefox");

        parameters.put(FORMAT_KEY, "xml");
    }

    /**
     * Sets the start index.
     *
     * @param start The start index.
     * @return This search builder instance.
     */
    public SearchBuilder start(int start) {
        parameters.put(START_KEY, String.valueOf(start));

        return this;
    }

    /**
     * Sets the result limit.
     *
     * @param limit The start index.
     * @return This search builder instance.
     */
    public SearchBuilder limit(int limit) {
        parameters.put(LIMIT_KEY, String.valueOf(limit));

        return this;
    }

    /**
     * Sets the number of days to search in the backlog.
     *
     * @param days The number of days to search back.
     * @return This search builder instance.
     */
    public SearchBuilder backlog(int days) {
        parameters.put(BACKLOG_LIMIT_KEY, String.valueOf(days));

        return this;
    }

    /**
     * Sets the search radius.
     *
     * @param radius The search radius.
     * @return This search builder instance.
     */
    public SearchBuilder radius(int radius) {
        parameters.put(RADIUS_KEY, String.valueOf(radius));

        return this;
    }

    /**
     * Sets a flag indicating whether or not search terms should be bolded.
     *
     * @param flag The flag.
     * @return This search builder instance.
     */
    public SearchBuilder highlight(boolean flag) {
        parameters.put(HIGHLIGHT_KEY, flag ? "1" : "0");

        return this;
    }

    /**
     * Sets a flag indicating whether or not search coordinates should be returned in results.
     *
     * @param flag The flag.
     * @return This search builder instance.
     */
    public SearchBuilder coordinates(boolean flag) {
        parameters.put(LATITUDE_LONGITUDE_KEY, Boolean.toString(flag));

        return this;
    }

    /**
     * Sets a flag indicating whether or not the search should be filtered of duplicates.
     *
     * @param flag The flag.
     * @return This search builder instance.
     */
    public SearchBuilder filter(boolean flag) {
        parameters.put(FILTER_KEY, Boolean.toString(flag));

        return this;
    }

    /**
     * Sets the search location.
     *
     * @param location The search location.
     * @return This search builder instance.
     */
    public SearchBuilder location(String location) {
        parameters.put(LOCATION_KEY, location);

        return this;
    }

    /**
     * Sets the search query.
     *
     * @param query The query.
     * @return This search builder instance.
     */
    public SearchBuilder query(String query) {
        parameters.put(QUERY_KEY, query);

        return this;
    }

    /**
     * Sets the preferred API channel.
     *
     * @param channel The channel.
     * @return This search builder instance.
     */
    public SearchBuilder channel(String channel) {
        parameters.put(CHANNEL_KEY, channel);

        return this;
    }

    /**
     * Sets the site type. Possible values include: 'jobsite' for job boards, and 'employer' for direct employer
     * websites.
     *
     * @param siteType The site type.
     * @return This search builder instance.
     */
    public SearchBuilder siteType(String siteType) {
        parameters.put(SITE_TYPE_KEY, siteType);

        return this;
    }

    /**
     * Sort by 'relevance' or 'date'. Default is 'relevance'.
     *
     * @param sort The sort type.
     * @return This search builder instance.
     */
    public SearchBuilder sort(String sort) {
        parameters.put(SORT_KEY, sort);

        return this;
    }

    /**
     * Sets the job type. Possible values include: 'fulltime', 'parttime', 'contract', 'internship', 'temporary'.
     *
     * @param jobType The job type.
     * @return This search builder instance.
     */
    public SearchBuilder jobType(String jobType) {
        parameters.put(JOB_TYPE_KEY, jobType);

        return this;
    }

    /**
     * Sets the country code.
     *
     * @param country The country code.
     * @return This search builder instance.
     */
    public SearchBuilder country(String country) {
        parameters.put(COUNTRY_KEY, country);

        return this;
    }

    /**
     * Sets the IP of the user performing this search.
     *
     * @param ip The user ip.
     * @return This search builder instance.
     */
    public SearchBuilder userIp(String ip) {
        parameters.put(USER_IP_KEY, ip);

        return this;
    }

    /**
     * Sets the user agent of the user performing this search.
     *
     * @param agent The user agent.
     * @return This search builder instance.
     */
    public SearchBuilder userAgent(String agent) {
        parameters.put(USER_AGENT_KEY, agent);

        return this;
    }

    /**
     * Builds REST parameters from the parameter map.
     *
     * @return The REST parameters.
     * @throws IndeedParameterException If a required parameter was not set.
     */
    public RestParameters build() throws IndeedParameterException {
        checkParameters();

        return new RestParameters(parameters);
    }

    /**
     * Builds REST parameters from the parameter map and runs the query.
     *
     * @return The Indeed search results.
     * @throws IOException If there was an error querying the API.
     * @throws IndeedParseException If there was an error parsing the API result.
     * @throws IndeedParameterException If a required parameter was not set.
     */
    public IndeedSearchResults run() throws IOException, IndeedParseException, IndeedParameterException {
        checkParameters();

        return indeed.getListings(new RestParameters(parameters));
    }

    /**
     * Checks the parameters in the parameter map for validity.
     *
     * @throws IndeedParameterException If a required parameter was not set.
     */
    private void checkParameters() throws IndeedParameterException {
        for(String key : REQUIRED_KEYS) {

            if (!parameters.containsKey(key) || parameters.get(key) == null) {
                throw new IndeedParameterException(key);
            }
        }
    }

}
