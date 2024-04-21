package ui.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import ui.driver.DriverFactory;
import ui.pages.HotelSearchPage;
import ui.pages.HotelSelectResultsPage;
import ui.pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HotelSearchStepDefinitions {
    private WebDriver webDriver;
    private HotelSearchPage hotelSearchPage;

    @Before
    public void setup() {
        webDriver = DriverFactory.getWebDriver();
    }

    @Given("I log in to the Adactin application with username {string} and password {string}")
    public void loginWithUsernameAndPassword(String username, String password) {
        new LoginPage(webDriver).login(username, password);
    }

    @And("I am on the Adactin {string} booking page")
    public void currentsPageHasSearchHotel(String expectedPage) {
        hotelSearchPage = new HotelSearchPage(webDriver);
        assertTrue(hotelSearchPage.isTextPresentInHotelSearch(expectedPage));
    }

    @When("I select {string} as the location")
    public void selectLocation(String location) {
        hotelSearchPage.setLocation(location);
    }

    @And("I select {string} as the hotel")
    public void selectHotel(String hotelName) {
        hotelSearchPage.setHotelName(hotelName);
    }

    @And("I select {string} as the room type")
    public void selectRoomType(String roomType) {
        hotelSearchPage.setRoomType(roomType);
    }

    @And("I select {int} as the number of rooms")
    public void selectNumberOfRooms(int numberOfRooms) {
        hotelSearchPage.setNumberOfRooms(numberOfRooms);
    }

    @And("I enter {string} as the check-in date")
    public void enterCheckInDate(String checkInDate) {
        hotelSearchPage.setCheckInDate(checkInDate);
    }

    @And("I enter {string} as the check-out date")
    public void enterCheckOutDate(String checkOutDate) {
        hotelSearchPage.setCheckOutDate(checkOutDate);
    }

    @And("I select {int} for adults per room")
    public void selectAdultsPerRoom(int adultsPerRoom) {
        hotelSearchPage.setAdultsPerRoom(adultsPerRoom);
    }

    @And("I select {int} for children per room")
    public void selectChildrenPerRoom(int childrenPerRoom) {
        hotelSearchPage.setChildrenPerRoom(childrenPerRoom);
    }

    @When("I click on the search button to find hotels")
    public void clickOnSearchButton() {
        hotelSearchPage.clickHotelSearchButton();
    }

    @Then("I should see a list of available hotels that match the entered search criteria {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void resultsMatchSearchCriteria(String hotelName, String location, String roomType, String numberOfRooms,
                                           String checkInDate, String checkOutDate, String numberOfDays) {
        HotelSelectResultsPage resultsPage = new HotelSelectResultsPage(webDriver);

        assertEquals(hotelName, resultsPage.getHotelName());
        assertEquals(location, resultsPage.getLocation());

        assertEquals(roomType, resultsPage.getRoomType());
        assertTrue(numberOfRooms.contains(resultsPage.getNumberOfRooms()));

        assertEquals(checkInDate, resultsPage.getArrivalDate());
        assertEquals(checkOutDate, resultsPage.getDepartureDate());

        assertTrue(numberOfDays.contains(resultsPage.getNumberOfDays()));
    }

    @When("I set the check-in date to {string} and the check-out date to {string}")
    public void setCheckInDateAndCheckOutDate(String checkInDate, String checkOutDate) {
        hotelSearchPage.setCheckInDate(checkInDate);
        hotelSearchPage.setCheckOutDate(checkOutDate);
    }

    @When("I click on the search button to validate dates")
    public void clickOnSearchButtonToValidateDates() {
        hotelSearchPage.clickHotelSearchButton();
    }

    @Then("I should see the error message {string}")
    public void showCheckInDateErrorMessage(String expectedErrorMessage) {
        String actualErrorMessage = hotelSearchPage.getActualErrorMessage();
        assertEquals(expectedErrorMessage, actualErrorMessage);
    }

    @After
    public void closeWebDriverResources() {
        DriverFactory.closeWebDriver();
    }
}