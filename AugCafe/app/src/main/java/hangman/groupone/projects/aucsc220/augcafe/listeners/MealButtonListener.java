/**
 * MealButtonListener.java
 *
 * Handles the clicks of the breakfast, lunch, and supper meal buttons
 * When clicked, a textview for that meal sets its text to the respective meal
 * and the button becomes white while the others become gray.
 */

package hangman.groupone.projects.aucsc220.augcafe.listeners;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import hangman.groupone.projects.aucsc220.augcafe.PlaceholderFragment;
import hangman.groupone.projects.aucsc220.augcafe.R;

public class MealButtonListener implements View.OnClickListener {
    private static final int WHITE_COLOR = Color.parseColor("#fafafa");
    private static final int GRAY_COLOR = Color.parseColor("#d6d7d7");
    private static final int BUTTON_DIVIDER = Color.parseColor("#b1b1b1");
    private static final int TRANSPARENT = Color.parseColor("#00000000");

    private final TextView mealTextView;
    private final View rootView;
    private Bundle args;

    public MealButtonListener(View rootView, Bundle args) {
        mealTextView = rootView.findViewById(R.id.meal_text_view);
        this.rootView = rootView;
        this.args = args;
    }

    @Override
    public void onClick(View v) {
        TextView timeView = rootView.findViewById(R.id.time_text_view);
        switch (v.getId()) {
            case R.id.meal_button_breakfast:
                mealTextView.setText(args.getString(PlaceholderFragment.ARG_BREAKFAST));
                rootView.findViewById(R.id.meal_button_breakfast).setBackgroundColor(WHITE_COLOR);
                rootView.findViewById(R.id.meal_button_lunch).setBackgroundColor(GRAY_COLOR);
                rootView.findViewById(R.id.meal_button_dinner).setBackgroundColor(GRAY_COLOR);
                rootView.findViewById(R.id.firstDivider).setBackgroundColor(TRANSPARENT);
                rootView.findViewById(R.id.secondDivider).setBackgroundColor(BUTTON_DIVIDER);
                if (args.getBoolean(PlaceholderFragment.ARG_WEEKEND)) {
                    timeView.setText(PlaceholderFragment.END_BREAKFAST_TIME);
                } else {
                    timeView.setText(PlaceholderFragment.WEEK_BREAKFAST_TIME);
                }
                break;
            case R.id.meal_button_lunch:
                mealTextView.setText(args.getString(PlaceholderFragment.ARG_LUNCH));
                rootView.findViewById(R.id.meal_button_breakfast).setBackgroundColor(GRAY_COLOR);
                rootView.findViewById(R.id.meal_button_lunch).setBackgroundColor(WHITE_COLOR);
                rootView.findViewById(R.id.meal_button_dinner).setBackgroundColor(GRAY_COLOR);
                rootView.findViewById(R.id.firstDivider).setBackgroundColor(TRANSPARENT);
                rootView.findViewById(R.id.secondDivider).setBackgroundColor(TRANSPARENT);
                if (args.getBoolean(PlaceholderFragment.ARG_WEEKEND)) {
                    timeView.setText(PlaceholderFragment.END_LUNCH_TIME);
                } else {
                    timeView.setText(PlaceholderFragment.WEEK_LUNCH_TIME);
                }
                break;
            case R.id.meal_button_dinner:
                mealTextView.setText(args.getString(PlaceholderFragment.ARG_DINNER));
                rootView.findViewById(R.id.meal_button_breakfast).setBackgroundColor(GRAY_COLOR);
                rootView.findViewById(R.id.meal_button_lunch).setBackgroundColor(GRAY_COLOR);
                rootView.findViewById(R.id.meal_button_dinner).setBackgroundColor(WHITE_COLOR);
                rootView.findViewById(R.id.firstDivider).setBackgroundColor(BUTTON_DIVIDER);
                rootView.findViewById(R.id.secondDivider).setBackgroundColor(TRANSPARENT);
                if (args.getBoolean(PlaceholderFragment.ARG_WEEKEND)) {
                    timeView.setText(PlaceholderFragment.END_SUPPER_TIME);
                } else {
                    timeView.setText(PlaceholderFragment.WEEK_SUPPER_TIME);
                }
                break;
            default:
                break;
        }
    }
}
