package com.stevesoltys.indeed.util;

import com.stevesoltys.indeed.exception.IndeedParseException;
import com.stevesoltys.indeed.model.IndeedResult;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Parses {@link IndeedResult}s from {@link Node}s.
 *
 * @author Steve Soltys
 */
public class ResultParser {

    /**
     * The job title tag.
     */
    private static final String JOB_TITLE_TAG = "jobtitle";

    /**
     * The company tag.
     */
    private static final String COMPANY_TAG = "company";

    /**
     * The city tag.
     */
    private static final String CITY_TAG = "city";

    /**
     * The state tag.
     */
    private static final String STATE_TAG = "state";

    /**
     * The country tag.
     */
    private static final String COUNTRY_TAG = "country";

    /**
     * The formatted location tag.
     */
    private static final String FORMATTED_LOCATION_TAG = "formattedLocation";

    /**
     * The source tag.
     */
    private static final String SOURCE_TAG = "source";

    /**
     * The date tag.
     */
    private static final String DATE_TAG = "date";

    /**
     * The date format.
     */
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz");

    /**
     * The snippet tag.
     */
    private static final String SNIPPET_TAG = "snippet";

    /**
     * The URL tag.
     */
    private static final String URL_TAG = "url";

    /**
     * The latitude tag.
     */
    private static final String LATITUDE_TAG = "latitude";

    /**
     * The longitude tag.
     */
    private static final String LONGITUDE_TAG = "longitude";

    /**
     * The job key tag.
     */
    private static final String JOB_KEY_TAG = "jobkey";

    /**
     * The sponsored tag.
     */
    private static final String SPONSORED_TAG = "sponsored";

    /**
     * The expired tag.
     */
    private static final String EXPIRED_TAG = "expired";

    /**
     * The Indeed Apply tag.
     */
    private static final String INDEED_APPLY_TAG = "indeedApply";

    /**
     * The formatted location full tag.
     */
    private static final String FORMATTED_LOCATION_FULL_TAG = "formattedLocationFull";

    /**
     * The formatted relative time tag.
     */
    private static final String FORMATTED_RELATIVE_TIME_TAG = "formattedRelativeTime";

    /**
     * Parses an Indeed result, given the node.
     *
     * @param node The node.
     * @return The parsed Indeed result.
     * @throws IndeedParseException If there is an error while parsing the node.
     */
    IndeedResult parseResult(Node node) throws IndeedParseException {
        IndeedResult.IndeedResultBuilder resultBuilder = IndeedResult.builder();

        NodeList children = node.getChildNodes();

        for (int i = 0; i < children.getLength(); i++) {
            Node attribute = children.item(i);

            parseAttribute(resultBuilder, attribute.getNodeName(), attribute.getTextContent());
        }

        return resultBuilder.build();
    }

    /**
     * Parses an attribute key and sets the value for that attribute in the given result builder.
     *
     * @param builder The result builder.
     * @param key     They key.
     * @param value   The value.
     * @throws IndeedParseException If there is an error while parsing the attribute value.
     */
    private void parseAttribute(IndeedResult.IndeedResultBuilder builder, String key, String value)
            throws IndeedParseException {

        switch (key) {

            case JOB_TITLE_TAG:
                builder.title(value);
                break;

            case COMPANY_TAG:
                builder.company(value);
                break;

            case CITY_TAG:
                builder.city(value);
                break;

            case STATE_TAG:
                builder.state(value);
                break;

            case COUNTRY_TAG:
                builder.country(value);
                break;

            case FORMATTED_LOCATION_TAG:
                builder.formattedLocation(value);
                break;

            case SOURCE_TAG:
                builder.source(value);
                break;

            case DATE_TAG:
                try {
                    builder.date(DATE_FORMAT.parse(value));

                } catch (ParseException e) {
                    e.printStackTrace();
                    throw new IndeedParseException("Could not parse date");
                }
                break;

            case SNIPPET_TAG:
                builder.snippet(value);
                break;

            case URL_TAG:
                try {
                    builder.url(new URL(value));

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                    throw new IndeedParseException("Could not parse URL");
                }
                break;

            case LATITUDE_TAG:
                double latitude = Double.parseDouble(value);

                builder.latitude(latitude);
                break;

            case LONGITUDE_TAG:
                double longitude = Double.parseDouble(value);

                builder.longitude(longitude);
                break;

            case JOB_KEY_TAG:
                builder.jobKey(value);
                break;

            case SPONSORED_TAG:
                boolean sponsered = Boolean.parseBoolean(value);

                builder.sponsored(sponsered);
                break;

            case EXPIRED_TAG:
                boolean expired = Boolean.parseBoolean(value);

                builder.expired(expired);
                break;

            case INDEED_APPLY_TAG:
                boolean indeedApply = Boolean.parseBoolean(value);

                builder.indeedApply(indeedApply);
                break;

            case FORMATTED_LOCATION_FULL_TAG:
                builder.formattedLocationFull(value);
                break;

            case FORMATTED_RELATIVE_TIME_TAG:
                builder.formattedRelativeTime(value);
                break;

        }

    }

}
