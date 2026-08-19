package ru.alfabank.homework16.runners;

import io.cucumber.junit.platform.engine.Constants;
import org.junit.platform.suite.api.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource(value = "features")
@ConfigurationParameter(key = Constants.GLUE_PROPERTY_NAME, value = "ru.alfabank.homework16")
@ConfigurationParameter(key = Constants.FILTER_TAGS_PROPERTY_NAME, value = "not @negative")
@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME, value = "pretty")
public class BookingTestRunner {
}
