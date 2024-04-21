package ui.pages;

import org.openqa.selenium.WebDriver;
import ui.base.SeleniumBase;

public class HotelSearchPage extends SeleniumBase {
    public HotelSearchPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isTextPresentInHotelSearch(String text) {
        return findElement(config.getLocator("searchHotelTextLocator")).getText().contains(text);
    }

    public void setLocation(String location) {
        selectDropdownByValue(config.getLocator("locationDropdownLocator"), location);
    }

    public void setHotelName(String hotelName) {
        selectDropdownByValue(config.getLocator("hotelDropdownLocator"), hotelName);
    }

    public void setRoomType(String roomType) {
        selectDropdownByValue(config.getLocator("roomTypeDropdownLocator"), roomType);
    }

    public void setNumberOfRooms(int numberOfRooms) {
        selectDropdownByIndex(config.getLocator("numberOfRoomsDropdownLocator"), numberOfRooms);
    }

    public void setCheckInDate(String checkInDate) {
        enterInputValue(config.getLocator("checkInDateLocator"), checkInDate);
    }

    public void setCheckOutDate(String checkOutDate) {
        enterInputValue(config.getLocator("checkOutDateLocator"), checkOutDate);
    }

    public void setAdultsPerRoom(int adultsPerRoom) {
        selectDropdownByIndex(config.getLocator("adultsPerRoomDropdownLocator"), adultsPerRoom);
    }

    public void setChildrenPerRoom(int childrenPerRoom) {
        selectDropdownByIndex(config.getLocator("childrenPerRoomDropdownLocator"), childrenPerRoom);
    }

    public void clickHotelSearchButton() {
        clickButton(config.getLocator("searchButtonLocator"));
    }

    public String getActualErrorMessage() {
        return findElement(config.getLocator("errorMessageLocator")).getText();
    }
}
