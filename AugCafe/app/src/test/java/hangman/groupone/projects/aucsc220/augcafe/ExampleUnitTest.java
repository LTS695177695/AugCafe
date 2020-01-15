package hangman.groupone.projects.aucsc220.augcafe;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import hangman.groupone.projects.aucsc220.augcafe.menuholders.MenuDay;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void testMeal()
    {       ingredientDialog a = new ingredientDialog();
            System.out.print(a.text_data);

        MenuDay test4 = new MenuDay();
        test4.addBreakfastMeal("egg");
        test4.addBreakfastMeal("beef");
        test4.addBreakfastMeal("milk");
        System.out.println(test4.getBreakfastTitle());

        Date dt = new Date();
        int hours = dt.getHours();
        int minutes = dt.getMinutes();

        if(hours > 8 && hours < 15){
            System.out.print("lunch");
        }//else if
        else if(hours > 15 && hours < 19){
            System.out.print("supper");
        }//else if
        else if(hours == 18 && minutes < 31){
            System.out.print("supper");
        }//else if
        else if (hours > 18 || hours < 9){
            System.out.print("breakfast");
        }
        else if(hours == 18 && minutes > 30 ){
            System.out.print("breakfast");
        }

        Calendar c = Calendar.getInstance();
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        dayOfWeek += 1;

        if (Calendar.MONDAY == dayOfWeek){
            System.out.print("Mon");
            System.out.print(Calendar.MONDAY);
        }
        else if (Calendar.TUESDAY == dayOfWeek){
            System.out.print("Tue");
        }
        else if (Calendar.WEDNESDAY == dayOfWeek){
            System.out.print("Wed");
        }
        else if (Calendar.THURSDAY == dayOfWeek){
            System.out.print("Thur");
        }
        else if (Calendar.FRIDAY == dayOfWeek){
            System.out.print("Fri");
        }
        else if (Calendar.SATURDAY == dayOfWeek){
            System.out.print("Sat");
        }
        else if (Calendar.SUNDAY == dayOfWeek){
            System.out.print("Sun");
            System.out.print(Calendar.SUNDAY);
        }

    }

    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }
}