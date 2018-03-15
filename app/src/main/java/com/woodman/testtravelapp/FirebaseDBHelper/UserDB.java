package com.woodman.testtravelapp.FirebaseDBHelper;

import com.google.firebase.auth.FirebaseUser;

/**
 * Created by Zver on 07.03.2018.
 */

public interface UserDB {
    void setUserName(FirebaseUser user,String name);
    void updateUserEmail(FirebaseUser user,String email);
    void updateUserPassword(FirebaseUser user,String password);
}
