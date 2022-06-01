package com.sih.kheloindia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class add_andUser_act extends AppCompatActivity {
    EditText name,email,pass,id;
    Button btn;
    FirebaseFirestore db ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_and_user);

        name = findViewById(R.id.name_android);
        email = findViewById(R.id.email_android);
        pass = findViewById(R.id.pass_android);
        id = findViewById(R.id.userid_android);
        btn = findViewById(R.id.btn_android);
        db = FirebaseFirestore.getInstance();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name_str  = name.getText().toString().trim();
                String email_str  = email.getText().toString().trim();
                String pass_str  = pass.getText().toString().trim();
                String id_str  = id.getText().toString().trim();

                Map<String,Object> user = new HashMap<>();
                user.put("Name",name_str);
                user.put("Email",email_str);
                user.put("Password",pass_str);
                user.put("User_id",id_str);


                db.collection("Android_users").document(email_str).set(user)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                Toast.makeText(add_andUser_act.this, "User added ", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(add_andUser_act.this, "Error :"+e, Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }
}