package com.stevesoltys.indeed.model;

import java.net.URL;
import java.util.Date;

/**
 * An Indeed API result builder.
 *
 * @author Steve Soltys
 */
public class IndeedResultBuilder {

    /**
     * The job title.
     */
    private String title;

    /**
     * The company.
     */
    private String company;

    /**
     * The city.
     */
    private String city;

    /**
     * The state.
     */
    private String state;

    /**
     * The country.
     */
    private String country;

    /**
     * The formatted location.
     */
    private String formattedLocation;

    /**
     * The source.
     */
    private String source;

    /**
     * The date.
     */
    private Date date;

    /**
     * The snippet.
     */
    private String snippet;

    /**
     * The URL.
     */
    private URL url;

    /**
     * The longitude. Will be null unless {@link SearchBuilder#coordinates(boolean)} is flagged as true.
     */
    private Double longitude;

    /**
     * The latitude. Will be null unless {@link SearchBuilder#coordinates(boolean)} is flagged as true.
     */
    private Double latitude;

    /**
     * The job key. Will be null if this is a job, rather than a search result.
     */
    private String jobKey;

    /**
     * A flag indicating whether or not this result is a sponsored advertisement.
     */
    private boolean sponsored;

    /**
     * A flag indicating whether or not this result has expired.
     */
    private boolean expired;

    /**
     * A flag indicating whether or not this job can be applied to using Indeed Apply.
     */
    private boolean indeedApply;

    /**
     * The entire formatted location of this result.
     */
    private String formattedLocationFull;

    /**
     * The formatted relative time.
     */
    private String formattedRelativeTime;

    /**
     * Builds an Indeed result.
     *
     * @return The result.
     */
    public IndeedResult build() {

        return new IndeedResult(title, company, city, state, country, formattedLocation, source, date, snippet, url,
                longitude, latitude, jobKey, sponsored, expired, indeedApply, formattedLocationFull,
                formattedRelativeTime);
    }

    /**
     * Sets the job title.
     *
     * @param title The job title.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Sets the company name for this result.
     *
     * @param company The company.
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * Sets the city that this result is located in.
     *
     * @param city The city.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Sets the state that this result is located in.
     *
     * @param state The state.
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Sets the country that this result is located in.
     *
     * @param country The country.
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Sets the formatted location for this result.
     *
     * @param formattedLocation The formatted location.
     */
    public void setFormattedLocation(String formattedLocation) {
        this.formattedLocation = formattedLocation;
    }

    /**
     * Sets the source of this result (i.e.: Indeed, Dice, Monster).
     *
     * @param source The source.
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * Gets the date this result was posted.
     *
     * @param date The date.
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Sets a snippet of this result's description.
     *
     * @param snippet The snippet description.
     */
    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    /**
     * Sets the URL for this result.
     *
     * @param url The url.
     */
    public void setUrl(URL url) {
        this.url = url;
    }

    /**
     * Sets the longitude for this result.
     *
     * @param longitude The longitude.
     */
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    /**
     * Sets the latitude for this result.
     *
     * @param latitude The latitude.
     */
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    /**
     * Sets the job key for this result.
     *
     * @param jobKey The job key.
     */
    public void setJobKey(String jobKey) {
        this.jobKey = jobKey;
    }

    /**
     * Sets a flag indicating whether or not this result is a sponsored advertisement.
     *
     * @param sponsored Whether or not this result is sponsored.
     */
    public void setSponsored(boolean sponsored) {
        this.sponsored = sponsored;
    }

    /**
     * Sets a flag indicating whether or not this result is expired.
     *
     * @param expired Whether or not this result is expired.
     */
    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    /**
     * Sets a flag indicating whether or not this job can be applied to using Indeed Apply.
     *
     * @param indeedApply Whether or not this job can be applied to using Indeed Apply.
     */
    public void setIndeedApply(boolean indeedApply) {
        this.indeedApply = indeedApply;
    }

    /**
     * Sets the full formatted location for this result.
     *
     * @param formattedLocationFull The full formatted location.
     */
    public void setFormattedLocationFull(String formattedLocationFull) {
        this.formattedLocationFull = formattedLocationFull;
    }

    /**
     * Sets the formatted relative time for this result.
     *
     * @param formattedRelativeTime The formatted relative time.
     */
    public void setFormattedRelativeTime(String formattedRelativeTime) {
        this.formattedRelativeTime = formattedRelativeTime;
    }
}
