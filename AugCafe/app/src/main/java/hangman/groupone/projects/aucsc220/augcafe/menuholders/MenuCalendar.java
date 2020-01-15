/**
 * MenuCalendar.java
 *
 * Keeps track of the date and what date is being looked at
 * Also changes the date into a readable format for the fragment header
 */
package hangman.groupone.projects.aucsc220.augcafe.menuholders;

import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.Calendar;
import java.util.TimeZone;

/**
 * Keeps a reference to the 14 day time span the app must cover.
 * Keeps a record of what menu is currently active (being looked at).
 */
public class MenuCalendar {
    private MenuDay[] menuDates;
    private int currentDateIndex;
    private Calendar calendar;

    private MenuCalendar(final int dayOfWeek, Calendar calendar) {
        menuDates = new MenuDay[14];
        currentDateIndex = dayOfWeek;
        this.calendar = calendar;
        for (int i = 0; i < 14; i++)
            menuDates[i] = new MenuDay();
    }

    public MenuCalendar(final Calendar calendar) {
        this(calendar.get(Calendar.DAY_OF_WEEK), calendar);
    }

    public MenuCalendar() {
        this(Calendar.getInstance(TimeZone.getDefault()));
    }

    /**
     * Gets the menu at the current date index.
     * @return MenuDay at current date index.
     */
    public MenuDay getActiveMenu() {
        return menuDates[currentDateIndex -1];
    }

    public int getCurrentDateIndex() {
        return currentDateIndex;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void changeCurrentDateIndex(int frangmentsMoved) {
        currentDateIndex += frangmentsMoved;
    }

    /**
     * Gets the current date in a human readable format.
     * The current date is the whichever date the user is
     * currently looking at.
     * @return String representation of the current date.
     */
    public String getFullDateAsString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getDayOfWeekFromDateIndex(currentDateIndex));
        sb.append(", ");
        sb.append(new DateFormatSymbols().getShortMonths()[calendar.get(Calendar.MONTH)]);
        sb.append(" ");
        sb.append(calendar.get(Calendar.DAY_OF_MONTH));
        return sb.toString();
    }

    /**
     * Converts the date index into a valid day of the week.
     * @param currentDateIndex Current date index.
     * @return String representation for the current day of the week.
     */
    private static String getDayOfWeekFromDateIndex(int currentDateIndex) {
        if (currentDateIndex > 7)
            currentDateIndex -= 7;
        switch (currentDateIndex) {
            case 1:
                return "Sunday";
            case 2:
                return "Monday";
            case 3:
                return "Tuesday";
            case 4:
                return "Wednesday";
            case 5:
                return "Thursday";
            case 6:
                return "Friday";
            case 7:
                return "Saturday";
            default:
                return "Invalid Day";
        }
    }

    public void setMenuDates(MenuDay[] menuDates) {
        this.menuDates = menuDates;
    }


    public MenuDay getCafeDateAtlndex (int dateIndex)
    {
        return menuDates[dateIndex];
    }
}
