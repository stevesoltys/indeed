package com.stevesoltys.indeed.model;

import java.net.URL;
import java.util.Date;

/**
 * An Indeed API result.
 *
 * @author Steve Soltys
 */
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

    public IndeedResult(String title, String company, String city, String state, String country,
                        String formattedLocation, String source, Date date, String snippet, URL url,
                        Double longitude, Double latitude, String jobKey, boolean sponsored, boolean expired,
                        boolean indeedApply, String formattedLocationFull, String formattedRelativeTime) {

        this.title = title;
        this.company = company;

        this.city = city;
        this.state = state;
        this.country = country;

        this.formattedLocation = formattedLocation;
        this.source = source;
        this.date = date;

        this.snippet = snippet;
        this.url = url;

        this.longitude = longitude;
        this.latitude = latitude;

        this.jobKey = jobKey;

        this.sponsored = sponsored;
        this.expired = expired;
        this.indeedApply = indeedApply;

        this.formattedLocationFull = formattedLocationFull;
        this.formattedRelativeTime = formattedRelativeTime;
    }

    /**
     * The job title for this result.
     *
     * @return The job title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets the company name for this result.
     *
     * @return The company name.
     */
    public String getCompany() {
        return company;
    }

    /**
     * Gets the city that this result is located in.
     *
     * @return The city.
     */
    public String getCity() {
        return city;
    }

    /**
     * Gets the state that this result is located in.
     *
     * @return The state.
     */
    public String getState() {
        return state;
    }

    /**
     * Gets the country that this result is located in.
     *
     * @return The country.
     */
    public String getCountry() {
        return country;
    }

    /**
     * Gets the formatted location of this result.
     *
     * @return The formatted location.
     */
    public String getFormattedLocation() {
        return formattedLocation;
    }

    /**
     * Gets the source of this result (i.e.: Indeed, Dice, Monster).
     *
     * @return The source.
     */
    public String getSource() {
        return source;
    }

    /**
     * Gets the date this result was posted.
     *
     * @return The date.
     */
    public Date getDate() {
        return date;
    }

    /**
     * Gets a snippet of this result's description.
     *
     * @return The snippet description.
     */
    public String getSnippet() {
        return snippet;
    }

    /**
     * Gets the URL for this result.
     *
     * @return The URL.
     */
    public URL getUrl() {
        return url;
    }

    /**
     * Gets the longitude. Will be null unless {@link SearchBuilder#coordinates(boolean)} is flagged as true.
     *
     * @return The longitude.
     */
    public Double getLongitude() {
        return longitude;
    }

    /**
     * Gets the latitude. Will be null unless {@link SearchBuilder#coordinates(boolean)} is flagged as true.
     *
     * @return The latitude.
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     * Gets the job key. Will be null if this is a job, rather than a search result.
     *
     * @return The job key.
     */
    public String getJobKey() {
        return jobKey;
    }

    /**
     * Gets a flag indicating whether or not this result is a sponsored advertisement.
     *
     * @return A flag indicating whether or not this result is a sponsored advertisement.
     */
    public boolean isSponsored() {
        return sponsored;
    }


    /**
     * A flag indicating whether or not this result has expired.
     *
     * @return A flag indicating whether or not this result has expired.
     */
    public boolean isExpired() {
        return expired;
    }

    /**
     * Gets a flag indicating whether or not this job can be applied to using Indeed Apply.
     *
     * @return A flag indicating whether Indeed Apply is enabled.
     */
    public boolean isIndeedApply() {
        return indeedApply;
    }

    /**
     * Gets the entire formatted location of this result.
     *
     * @return The entire formatted location of this result.
     */
    public String getFormattedLocationFull() {
        return formattedLocationFull;
    }


    /**
     * Gets the formatted relative time.
     *
     * @return The formatted relative time.
     */
    public String getFormattedRelativeTime() {
        return formattedRelativeTime;
    }

}
