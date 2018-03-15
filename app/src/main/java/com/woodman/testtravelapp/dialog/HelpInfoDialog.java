package com.woodman.testtravelapp.dialog;

import android.app.AlertDialog;
import android.content.Context;

import com.woodman.testtravelapp.R;

/**
 * Created by Zver on 14.03.2018.
 */

public class HelpInfoDialog {
    private Context context;
    private AlertDialog.Builder builder;

    public HelpInfoDialog(Context context) {
        this.context = context;
        builder = new AlertDialog.Builder(context);
    }

    public void createHelpInfoDialog() {
        builder.setTitle(context.getString(R.string.title_help_info_dialog));
        builder.setMessage(context.getString(R.string.message_help_info_dialog));
        builder.create();
    }

    public void showHelpInfoDialog() {
        builder.show();
    }
}
