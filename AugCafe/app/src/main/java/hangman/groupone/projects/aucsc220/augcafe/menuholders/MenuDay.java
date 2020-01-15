/**
 * MenuDay.java
 *
 * Receives Meal object from Meal.java and
 * formats then passes it into PlaceholderFragment.java
 */

package hangman.groupone.projects.aucsc220.augcafe.menuholders;

import hangman.groupone.projects.aucsc220.augcafe.Meal;
import java.util.ArrayList;
import java.util.List;

public class MenuDay {
    //data
    List<Meal> breakfastList = new ArrayList<Meal>();

    List<Meal> lunchList = new ArrayList<Meal>();

    List<Meal> supperList = new ArrayList<Meal>();
    //add a Meal object into Breakfast array list
    public void addBreakfastMeal(String foodtitle,String[] foodIngredients, boolean Vegitarian, boolean GlutenFree, boolean LactoseFree, boolean Halal, boolean Fish) {
        breakfastList.add(new Meal(foodtitle,foodIngredients,Vegitarian,GlutenFree,LactoseFree,Halal,Fish));
    }

    //adda a Meal object into Lunch array list
    public void addLunchMeal(String foodtitle,String[] foodIngredients, boolean Vegitarian, boolean GlutenFree, boolean LactoseFree, boolean Halal, boolean Fish) {
        lunchList.add(new Meal(foodtitle,foodIngredients,Vegitarian,GlutenFree,LactoseFree,Halal,Fish));
    }

    //add a Meal object into Supper array list
    public void addSupperMeal(String foodtitle,String[] foodIngredients, boolean Vegitarian, boolean GlutenFree, boolean LactoseFree, boolean Halal, boolean Fish) {
        supperList.add(new Meal(foodtitle,foodIngredients,Vegitarian,GlutenFree,LactoseFree,Halal,Fish));
    }

    //without speical diets
    public void addBreakfastMeal (String foodtitle, String[] foodIngredients)
    {
        breakfastList.add(new Meal(foodtitle,foodIngredients,false,false,false,false,false));
    }//food title and ingredients

    //without special diets
    public void addLunchMeal (String foodtitle, String[] foodIngredients)
    {
        lunchList.add(new Meal(foodtitle,foodIngredients,false,false,false,false,false));
    }//food title and ingredients

    //without special diets
    public void addSupperMeal (String foodtitle, String[] foodIngredients)
    {
        supperList.add(new Meal(foodtitle,foodIngredients,false,false,false,false,false));
    }//food title and ingredients

    //only food title
    public void addBreakfastMeal (String foodtitle)
    {
        breakfastList.add(new Meal(foodtitle,new String[]{"unknown"},false,false,false,false,false));
    }//only food title

    //only food title
    public void addLunchMeal (String foodtitle)
    {
        lunchList.add(new Meal(foodtitle,new String[]{"unknown"},false,false,false,false,false));
    }//only food title

    //only food title
    public void addSupperMeal (String foodtitle)
    {
        supperList.add(new Meal(foodtitle,new String[]{"unknown"},false,false,false,false,false));
    }//only food title

    /**
     * Passes in and formats the title of the meal to MenuCalendar
     * Spaces are for indent within the background
     */
    public String getTitle(List<Meal> Meallist)
    {
        String sumTitle = "\n";
        for (int i = 0; i < Meallist.size();i++)
        {
        sumTitle = sumTitle + "     - " + Meallist.get(i).getTitle() + "\n";
        }
        return sumTitle;
    }

    public String getBreakfastTitle() {return getTitle(breakfastList);}

    public String getLunchTitle()
    {
        return getTitle(lunchList);
    }

    public String getSupperTitle()
    {
        return getTitle(supperList);
    }

    //test function
    public int PrintTest()
    {
        return breakfastList.size();
    }
}
