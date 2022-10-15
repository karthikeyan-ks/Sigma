package com.example.sigma;

import static com.example.sigma.MainActivity.TAG;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sigma.data.LoginUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class MainActivity2 extends AppCompatActivity {

    private CharSequence text;
    private DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        // Write a message to the database
        FirebaseDatabase database;
        database = FirebaseDatabase.getInstance();
        TextView textView = findViewById(R.id.TextView2);

        myRef = database.getReference("message");
        DatabaseReference userRef = database.getReference("users");
        this.setTitle(this.getIntent().getStringExtra("Username"));
        EditText editText = findViewById(R.id.editText2);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                text= s;
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        Button button = findViewById(R.id.Button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Connect(text);
            }
        });
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
        LoginUser loginUser=new LoginUser("karthikeyanks3673@gmail.com","karthi.2002","1234567890987654321");
        userRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                userRef.child("user").setValue(loginUser);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void Connect(CharSequence string) {
        SigmaObject sigmaObject = new SigmaObject();
        sigmaObject.set("hello guys","karthikeyan k s","karthi.2002");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                myRef.setValue(sigmaObject);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}