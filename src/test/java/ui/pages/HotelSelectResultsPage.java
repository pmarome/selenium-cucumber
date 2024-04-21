package ui.pages;

import org.openqa.selenium.WebDriver;
import ui.base.SeleniumBase;

public class HotelSelectResultsPage extends SeleniumBase {
    public HotelSelectResultsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getHotelName() {
        return findElement(config.getLocator("hotelNameLocator")).getAttribute("value");
    }

    public String getLocation() {
        return findElement(config.getLocator("locationLocator")).getAttribute("value");
    }

    public String getNumberOfRooms() {
        return findElement(config.getLocator("numberOfRoomsLocator")).getAttribute("value");
    }

    public String getArrivalDate() {
        return findElement(config.getLocator("arrivalDateLocator")).getAttribute("value");
    }

    public String getDepartureDate() {
        return findElement(config.getLocator("departureDateLocator")).getAttribute("value");
    }

    public String getNumberOfDays() {
        return findElement(config.getLocator("numberOfDaysLocator")).getAttribute("value");
    }

    public String getRoomType() {
        return findElement(config.getLocator("roomTypeLocator")).getAttribute("value");
    }
}
