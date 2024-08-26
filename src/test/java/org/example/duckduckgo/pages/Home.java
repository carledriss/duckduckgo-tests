package org.example.duckduckgo.pages;

import org.example.core.ui.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home extends AbstractPage {

    @FindBy(css = "#searchbox_input")
    private WebElement searchInput;

    @FindBy(css = "button[aria-label='Search']")
    private WebElement searchButton;

    public Home() {
        driver.get("https://start.duckduckgo.com/");
    }

    public SearchResult search(String input) {
        action.setValue(searchInput, input);
        action.click(searchButton);
        return new SearchResult();
    }

}
