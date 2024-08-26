package org.example.duckduckgo.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.commons.lang3.StringUtils;
import org.example.core.api.RequestManager;
import org.example.core.api.RequestSpec;
import org.example.core.ui.DriverManager;
import org.example.duckduckgo.pages.Home;
import org.example.duckduckgo.pages.SearchResult;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class DuckDuckGoTests {

    @Test
    public void testCase1() {
        String searchText = "Android";
        SearchResult searchResult = new Home()
                .search(searchText);
        List<WebElement> allResultTitle = searchResult.getAllResultTitle();
        for (WebElement resultTitle : allResultTitle) {
            Assert.assertTrue(resultTitle.getText().contains(searchText));
        }
    }

    @Test
    public void testCase2() {
        String searchText = "Android";
        SearchResult searchResult = new Home()
                .search(searchText)
                .clickAllRegionsDropdown();
        List<WebElement> allCountriesResult = searchResult.getAllCountriesResult();
        Assert.assertTrue(allCountriesResult.size() > 10);
    }

    @Test
    public void testCase3() {
        final Response response = RestAssured.given(RequestSpec.getRequestSpec())
                .when()
                .header("accept-language", "es-US,es-419;q=0.9,es;q=0.8")
                .queryParam("q", "simpsons")
                .queryParam("format", "json")
                .get("/");
        RequestManager.getResponseWithLogger(response);
        List<Map<String, Object>> relatedTopics = response.jsonPath().getList("RelatedTopics");

        // list and print Icon.URL if it's not null
        for (Map<String, Object> topic : relatedTopics) {
            Map<String, String> icon = (Map<String, String>) topic.get("Icon");
            if (icon != null) {
                String iconUrl = icon.get("URL");
                if (StringUtils.isNotEmpty(iconUrl)) {
                    System.out.printf("Icon URL: %s%n", iconUrl);
                }
            }
        }
    }

    @AfterTest
    public void teardown() {
        WebDriver driver = DriverManager.getInstance().getDriver();
        if (driver !=  null) {
            driver.quit();
        }
    }

}
