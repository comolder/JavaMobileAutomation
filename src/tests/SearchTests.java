package tests;

import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class SearchTests extends CoreTestCase
{
    @Test
    public void testSearch()
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResultBySubstring("Object-oriented programming language");
    }

    @Test
    public void testCancelSearch()
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();

        SearchPageObject.waitForCancelSearchButtonToAppear();
        SearchPageObject.clickCancelSearch();
        SearchPageObject.waitForCancelSearchButtonToDisappear();
    }

    @Test
    public void testAmountOfNotEmptySearch()
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        String search_line = "Linkin Park Diskography";

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(search_line);
        int amount_of_search_results = SearchPageObject.getAmountOfFoundArticles();

        assertTrue(
                "We found too few results!",
                amount_of_search_results > 0
        );
    }

    @Test
    public void testAmountOfEmptySearch()
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        String search_line = "zxcvasdfqwer";

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.waitForEmptyResultLabel();
        SearchPageObject.assertThereIsNoResultOfSearch();
    }
}