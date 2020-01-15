package hangman.groupone.projects.aucsc220.augcafe.listeners;

import android.app.Dialog;
import android.view.View;
import android.view.Window;

import hangman.groupone.projects.aucsc220.augcafe.MainActivity;
import hangman.groupone.projects.aucsc220.augcafe.R;

public class ContactInfoButtonListener implements View.OnClickListener {
    private final MainActivity mainActivity;

    public ContactInfoButtonListener(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public void onClick(View v) {
        Dialog contactInfoDialog = new Dialog(mainActivity);
        contactInfoDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        contactInfoDialog.setContentView(R.layout.contact_info_dialog);
        contactInfoDialog.show();
    }
}
