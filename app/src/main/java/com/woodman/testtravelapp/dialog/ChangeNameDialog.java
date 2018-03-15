package com.woodman.testtravelapp.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.woodman.testtravelapp.FirebaseDBHelper.DBImpl.UserDBImpl;
import com.woodman.testtravelapp.FirebaseDBHelper.UserDB;
import com.woodman.testtravelapp.R;

/**
 * Created by Zver on 12.03.2018.
 */

public class ChangeNameDialog {
    private EditText editTextUserFullName;

    private String newFullName;

    private FirebaseAuth mAuth;
    private FirebaseUser user;
    private UserDB userDB;
    private Activity activity;

    public ChangeNameDialog(Activity activity) {
        this.activity = activity;
        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();
        userDB = new UserDBImpl();
    }

    public void createChangeNameDialog() {
        final View view = activity.getLayoutInflater().inflate(R.layout.change_name_dialog, null);
        editTextUserFullName = view.findViewById(R.id.edit_text_change_name_dialog);
        AlertDialog alertDialog = new AlertDialog.Builder(activity)
                .setView(view)
                .setPositiveButton(R.string.btn_ok, null)
                .setNegativeButton(R.string.btn_cancel, null)
                .create();
        alertDialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(final DialogInterface dialogInterface) {
                Button btnOk = ((AlertDialog) dialogInterface).getButton(DialogInterface.BUTTON_POSITIVE);
                btnOk.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (isValidField()) {
                            userDB.setUserName(user, editTextUserFullName.getText().toString());
                            newFullName=editTextUserFullName.getText().toString();
                            dialogInterface.dismiss();
                        }
                    }
                });
                Button btnCancel = ((AlertDialog) dialogInterface).getButton(DialogInterface.BUTTON_NEGATIVE);
                btnCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialogInterface.cancel();
                    }
                });
            }
        });
        alertDialog.show();
    }

    protected boolean isValidField() {
        String tempName = editTextUserFullName.getText().toString();
        if (tempName.isEmpty()) {
            editTextUserFullName.setError(activity.getString(R.string.error_missing_full_name));
            editTextUserFullName.requestFocus();
            return false;
        }

        return true;
    }


    public String getNewFullName() {

        return newFullName;
    }
}
