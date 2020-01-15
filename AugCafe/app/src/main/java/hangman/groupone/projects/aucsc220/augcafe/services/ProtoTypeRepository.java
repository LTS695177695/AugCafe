package hangman.groupone.projects.aucsc220.augcafe.services;

import java.util.Calendar;

import hangman.groupone.projects.aucsc220.augcafe.MainActivity;
import hangman.groupone.projects.aucsc220.augcafe.Meal;
import hangman.groupone.projects.aucsc220.augcafe.menuholders.MenuDay;

public class ProtoTypeRepository implements MenuRepository {
    @Override
    public MenuDay[] getMenuDays(Calendar startDate) {
        MenuDay[] menuDays = new MenuDay[MainActivity.menuTimeSpan];

        MenuDay dummyDayOne = new MenuDay();
        dummyDayOne.addBreakfastMeal("Bacon");
        dummyDayOne.addBreakfastMeal("Eggs");
        dummyDayOne.addLunchMeal("Pizza");
        dummyDayOne.addLunchMeal("Bread");
        dummyDayOne.addSupperMeal("Rice");
        dummyDayOne.addSupperMeal("Fruit");

        MenuDay dummyDayTwo = new MenuDay();
        dummyDayTwo.addBreakfastMeal("Cereal");
        dummyDayTwo.addBreakfastMeal("Milk");
        dummyDayTwo.addLunchMeal("Hot Dogs");
        dummyDayTwo.addLunchMeal("Flat Bread");
        dummyDayTwo.addSupperMeal("Chicken");
        dummyDayTwo.addSupperMeal("Rice");

        MenuDay dummyDayThree = new MenuDay();
        dummyDayThree.addBreakfastMeal("Scrambled Eggs");
        dummyDayThree.addBreakfastMeal("Cereal");
        dummyDayThree.addLunchMeal("Wraps");
        dummyDayThree.addLunchMeal("Various Veggies");
        dummyDayThree.addSupperMeal("Lasagna");
        dummyDayThree.addSupperMeal("Salad");

        menuDays[0] = dummyDayOne;
        menuDays[1] = dummyDayTwo;
        menuDays[2] = dummyDayThree;
        menuDays[3] = dummyDayOne;
        menuDays[4] = dummyDayTwo;
        menuDays[5] = dummyDayThree;
        menuDays[6] = dummyDayOne;
        menuDays[7] = dummyDayTwo;
        menuDays[8] = dummyDayThree;
        menuDays[9] = dummyDayOne;
        menuDays[10] = dummyDayTwo;
        menuDays[11] = dummyDayThree;
        menuDays[12] = dummyDayOne;
        menuDays[13] = dummyDayTwo;

        return menuDays;
    }
}
