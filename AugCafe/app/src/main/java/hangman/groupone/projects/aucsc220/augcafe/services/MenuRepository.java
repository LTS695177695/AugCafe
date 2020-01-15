package hangman.groupone.projects.aucsc220.augcafe.services;

import java.io.IOException;
import java.util.Calendar;

import hangman.groupone.projects.aucsc220.augcafe.menuholders.MenuDay;

public interface MenuRepository {
    MenuDay[] getMenuDays(Calendar startDate) throws IOException;
}
