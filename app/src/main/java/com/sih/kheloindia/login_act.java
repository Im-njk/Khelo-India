package com.sih.kheloindia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

public class login_act extends AppCompatActivity {
    TextView pannel, err;
    EditText username, pass;
    Button btn;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ProgressDialog pd = new ProgressDialog(login_act.this);
        db = FirebaseFirestore.getInstance();
        username = findViewById(R.id.username_login);
        pass = findViewById(R.id.pass_login);
        btn = findViewById(R.id.btn_login);
        err = findViewById(R.id.error);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pd.setMessage("Signing in..");
                pd.show();
                String usernamestr = username.getText().toString().trim();
                String passstr = pass.getText().toString().trim();
                db.collection("Android_users").document(usernamestr).get()
                        .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                            @Override
                            public void onSuccess(DocumentSnapshot d) {
                                try {
                                    if (passstr.equals(d.get("Password").toString())) {
                                        Intent i = new Intent(login_act.this, purposals.class);
                                        i.putExtra("name", d.get("Name").toString());
                                        startActivity(i);
                                    } else {
                                        err.setVisibility(View.VISIBLE);
                                    }
                                    pd.dismiss();
                                } catch (Exception e) {
                                    err.setVisibility(View.VISIBLE);
                                    pd.dismiss();
                                }
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                err.setVisibility(View.VISIBLE);
                                pd.dismiss();
                            }
                        });
            }
        });


    }
}