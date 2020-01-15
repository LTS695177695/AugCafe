package hangman.groupone.projects.aucsc220.augcafe.services;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import hangman.groupone.projects.aucsc220.augcafe.MainActivity;
import hangman.groupone.projects.aucsc220.augcafe.menuholders.MenuDay;

public class DefaultDataRepository implements MenuRepository {
    private InputStream inputStream;

    public DefaultDataRepository(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public MenuDay[] getMenuDays(final Calendar startDate) throws IOException {
        long epochTimestamp = getStartEpochTime(startDate);
        return generateMenuDays(epochTimestamp);
    }

    private MenuDay[] generateMenuDays(final long startEpoch) throws IOException {
        List<MenuDay> menuDays = buildMenuDayList(startEpoch);
        return menuDays.toArray(new MenuDay[MainActivity.menuTimeSpan]);
    }

    /**
     * Calculates the epoch time at the given date normalized to
     * midnight (12am) of the given day.
     * @param startDate Calendar to reference day, month, and year from.
     * @return Start time normalized to midnight in epoch time.
     */
    private long getStartEpochTime(final Calendar startDate) {
        Calendar epochCalendar = Calendar.getInstance();
        epochCalendar.set(Calendar.DAY_OF_MONTH, startDate.get(Calendar.DAY_OF_MONTH));
        epochCalendar.set(Calendar.MONTH, startDate.get(Calendar.MONTH));
        epochCalendar.set(Calendar.YEAR, startDate.get(Calendar.YEAR));
        epochCalendar.set(Calendar.HOUR_OF_DAY, 0);
        epochCalendar.set(Calendar.MINUTE, 0);
        epochCalendar.set(Calendar.SECOND, 0);
        epochCalendar.set(Calendar.MILLISECOND, 0);
        return epochCalendar.getTimeInMillis() / 1000;
    }

    /**
     * Sets up the CSV file parser to read in the data dump.
     * @return CSVParser
     * @throws IOException
     */
    private CSVParser setupParser() throws IOException {
        Reader reader = new InputStreamReader(inputStream);
        return new CSVParser(reader, CSVFormat.DEFAULT.withEscape('\\'));
    }

    private List<MenuDay> buildMenuDayList(final long startEpoch) throws IOException {
        CSVParser parser = setupParser();
        ListIterator<CSVRecord> iterator = parser.getRecords().listIterator();
        boolean foundStartDate = determineAndLocateCSVStart(iterator, startEpoch);
        List<MenuDay> menuDays;
        if (!foundStartDate)
            menuDays = buildEmptyMenuDays();
        else
            menuDays = buildMenuDaysFromIterator(iterator);
        return menuDays;
    }

    private List<MenuDay> buildMenuDaysFromIterator(ListIterator<CSVRecord> iterator) {
        List<MenuDay> menuDays = new LinkedList<>();
        for (int i = 0; i < MainActivity.menuTimeSpan; i++) {
            MenuDay menuDay = new MenuDay();
            if (!iterator.hasNext()) {
                fillRemainingMenuDaysWithBlanks(menuDays, MainActivity.menuTimeSpan - i);
                break;
            } else {
                for (String breakfast : iterator.next().get(1).split("\n")) {
                    if (containsLetter(breakfast))
                        menuDay.addBreakfastMeal(breakfast);
                }
                for (String lunch : iterator.next().get(1).split("\n")) {
                    if (containsLetter(lunch))
                        menuDay.addLunchMeal(lunch);
                }
                for (String supper : iterator.next().get(1).split("\n")) {
                    if (containsLetter(supper))
                        menuDay.addSupperMeal(supper);
                }
                menuDays.add(menuDay);
            }
        }
        return menuDays;
    }

    private boolean containsLetter(String stringToCheck) {
        for (char character : stringToCheck.toCharArray())
            if (Character.isLetter(character))
                return true;
        return false;
    }

    private void fillRemainingMenuDaysWithBlanks(List<MenuDay> menuDays, final int days) {
        for (int i = 0; i < days; i++) {
            menuDays.add(buildEmptyMenuDay());
        }
    }

    /**
     * Attempts to find the first data entry with a matching epoch time.
     * The iterator will be left at the previous CSV entry meaning calling
     * next on the list iterator will return the first entry with the matching
     * epoch time.
     * @param iterator CSV file list iterator.
     * @param startEpoch Start epoch time to look for.
     * @return true if found, false if not.
     */
    private boolean determineAndLocateCSVStart(ListIterator<CSVRecord> iterator,
                                                 final long startEpoch) {
        while (iterator.hasNext()) {
            CSVRecord record = iterator.next();
            if (record.get(0).equals(Long.toString(startEpoch))) {
                iterator.previous();
                return true;
            }
        }
        return false;
    }

    /**
     * Builds a whole menu time span of menu days
     * with no food data.
     * @return Time span of no meal data menu days.
     */
    private List<MenuDay> buildEmptyMenuDays() {
        List<MenuDay> emptyMenuList = new ArrayList<>();
        for (int i = 0; i < MainActivity.menuTimeSpan; i++)
            emptyMenuList.add(buildEmptyMenuDay());
        return emptyMenuList;
    }

    /**
     * Builds a single menu day with no meal data.
     * @return Menu day with no data.
     */
    private MenuDay buildEmptyMenuDay() {
        MenuDay menuDay = new MenuDay();
        menuDay.addBreakfastMeal("No meal data");
        menuDay.addLunchMeal("No meal data");
        menuDay.addSupperMeal("No meal data");
        return menuDay;
    }
}
