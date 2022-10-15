package com.example.sigma.data;

import static com.example.sigma.MainActivity.TAG;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.sigma.data.model.LoggedInUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {
    private DatabaseReference myRef;
    public Result<LoggedInUser> login(String username, String password) {

        try {
            // TODO: handle loggedInUser authentication
            FirebaseDatabase database;
            database = FirebaseDatabase.getInstance();
            myRef = database.getReference("users");
            myRef.child("user").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    LoginUser loginUser=snapshot.getValue(LoginUser.class);
                    Log.d(TAG, "onDataChange: "+loginUser.userid);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
            LoggedInUser fakeUser =
                    new LoggedInUser(
                            java.util.UUID.randomUUID().toString(),
                            "Jane Doe");
            return new Result.Success<>(fakeUser);
        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }

    public void logout() {
        // TODO: revoke authentication
    }
}