/**
 * DateChangeListener.java
 *
 * Handles all the date changing functions:
 * Changing the date displayed on the action
 */

package hangman.groupone.projects.aucsc220.augcafe.listeners;

import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.widget.TextView;

import java.util.Calendar;

import hangman.groupone.projects.aucsc220.augcafe.MainActivity;
import hangman.groupone.projects.aucsc220.augcafe.R;

/**
 * Responsible for performing functions to support the date
 * changing functionality.
 * This class has no responsibility in updating the fragment view.
 * Only performing functions to support the date changing.
 */
public class DateChangeListener implements ViewPager.OnPageChangeListener {
    private MainActivity mainActivity;

    public DateChangeListener(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        applyMenuDateChanges(position);
        updateDateView();
    }

    /**
     * Applies any required date tracking changes.
     * It is possible for this method to be called, but no swipe
     * to have happened.
     * In that case, no date tracking changes are made.
     * @param position Fragment page index.
     */
    private void applyMenuDateChanges(int position) {
        /*
        Java calendar days are '1' indexed.
        Page fragments are '0' indexed.
        Addition of 1 to offset this is difference is required.
         */
        position++;
        int fragmentsMoved;

        if (position != mainActivity.getMenuCalendar().getCurrentDateIndex()){
            //fragmentsChanged is the difference between the new position and the current position
            //With this, we can go directly to the selected date
            fragmentsMoved = position - mainActivity.getMenuCalendar().getCurrentDateIndex();

            mainActivity.getMenuCalendar().changeCurrentDateIndex(fragmentsMoved);
            mainActivity.getMenuCalendar().getCalendar().add(Calendar.DATE, fragmentsMoved);
        }//if
    }//applyMenuDateChanges

    /**
     * Updates the date displayed on the toolbar.
     */
    private void updateDateView() {
        String date = mainActivity.getMenuCalendar().getFullDateAsString();
        TextView dayView = (TextView) mainActivity.findViewById(R.id.date_view);
        dayView.setText(date);
        dayView.setGravity(Gravity.CENTER_HORIZONTAL);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
