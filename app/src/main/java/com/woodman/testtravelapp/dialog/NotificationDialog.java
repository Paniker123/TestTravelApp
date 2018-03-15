package com.woodman.testtravelapp.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import com.woodman.testtravelapp.R;
import com.woodman.testtravelapp.preference.PreferenceManager;

/**
 * Created by Zver on 14.03.2018.
 */

public class NotificationDialog {
    private final boolean[] choiceItemArray;
    AlertDialog.Builder builder;
    private Context context;
    private boolean sound;
    private boolean vibrate;
    private String[] choiceStrings = {"Sound", "Vibrate"};

    public NotificationDialog(Context context) {
        this.context = context;
        builder = new AlertDialog.Builder(context);

        builder.setTitle("Notification");
        sound = PreferenceManager.getInstance().getSoundNotification(context);
        vibrate = PreferenceManager.getInstance().getVibrationNotification(context);
        choiceItemArray = new boolean[]{sound, vibrate};
    }

    public void createNotificationDialog() {

        builder.setMultiChoiceItems(
                choiceStrings,
                choiceItemArray,
                new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        choiceItemArray[i] = b;
                    }
                }
        ).setPositiveButton(R.string.btn_ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                sound = choiceItemArray[0];
                vibrate = choiceItemArray[1];
                PreferenceManager.getInstance().setSoundNotification(context, choiceItemArray[0]);
                PreferenceManager.getInstance().setVibrationNotification(context, choiceItemArray[1]);
            }
        }).setNegativeButton(R.string.btn_cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.create();
    }

    public void showNotificationDialog() {
        builder.show();
    }
}
