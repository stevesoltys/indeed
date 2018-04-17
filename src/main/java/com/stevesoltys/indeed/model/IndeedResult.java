package com.stevesoltys.indeed.model;

import lombok.Builder;
import lombok.Data;

import java.net.URL;
import java.util.Date;

/**
 * An Indeed API result.
 *
 * @author Steve Soltys
 */
@Data
@Builder
public class IndeedResult {

    /**
     * The job title.
     */
    private final String title;

    /**
     * The company.
     */
    private final String company;

    /**
     * The city.
     */
    private final String city;

    /**
     * The state.
     */
    private final String state;

    /**
     * The country.
     */
    private final String country;

    /**
     * The formatted location.
     */
    private final String formattedLocation;

    /**
     * The source.
     */
    private final String source;

    /**
     * The date.
     */
    private final Date date;

    /**
     * The snippet.
     */
    private final String snippet;

    /**
     * The URL.
     */
    private final URL url;

    /**
     * The longitude. Will be null unless {@link SearchBuilder#coordinates(boolean)} is flagged as true.
     */
    private final Double longitude;

    /**
     * The latitude. Will be null unless {@link SearchBuilder#coordinates(boolean)} is flagged as true.
     */
    private final Double latitude;

    /**
     * The job key. Will be null if this is a job, rather than a search result.
     */
    private final String jobKey;

    /**
     * A flag indicating whether or not this result is a sponsored advertisement.
     */
    private final boolean sponsored;

    /**
     * A flag indicating whether or not this result has expired.
     */
    private final boolean expired;

    /**
     * A flag indicating whether or not this job can be applied to using Indeed Apply.
     */
    private final boolean indeedApply;

    /**
     * The entire formatted location of this result.
     */
    private final String formattedLocationFull;

    /**
     * The formatted relative time.
     */
    private final String formattedRelativeTime;
}
