package org.example.duckduckgo.pages;

import org.example.core.ui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResult extends AbstractPage {

    @FindBy(css = "a[data-testid='region-filter-label']")
    private WebElement allRegionsDropdown;

    public List<WebElement> getAllResultTitle() {
        return driver.findElements(By.cssSelector("a[data-testid='result-title-a']"));
    }

    public SearchResult clickAllRegionsDropdown() {
        action.click(allRegionsDropdown);
        return this;
    }

    public List<WebElement> getAllCountriesResult() {
        return driver.findElements(By.cssSelector(".fdosLIuRgrWo7SyeqSUb"));
    }

}
