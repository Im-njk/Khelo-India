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
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class addUser_act extends AppCompatActivity {
    EditText name,email,pass,position,userid;
    Button btn;

    FirebaseFirestore db ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        name = findViewById(R.id.name_adduser);
        email = findViewById(R.id.email_adduser);
        pass = findViewById(R.id.pass_adduser);
        position = findViewById(R.id.position_adduser);
        userid = findViewById(R.id.userid_adduser);
        btn = findViewById(R.id.btn_adduser);

        db = FirebaseFirestore.getInstance();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name_str = name.getText().toString().trim();
                String email_str = email.getText().toString().trim();
                String pass_str = pass.getText().toString().trim();
                String position_str = position.getText().toString().trim();
                String userid_str = userid.getText().toString().trim();
                Map<String,String> user = new HashMap<>();
                user.put("id",userid_str);
                user.put("Name",name_str);
                user.put("Email",email_str);
                user.put("Password",pass_str);
                user.put("Position",position_str);

//                db.collection("User").add(user)
//                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
//                            @Override
//                            public void onSuccess(DocumentReference documentReference) {
//                                Toast.makeText(addUser_act.this, "User added : "+ documentReference.getId(), Toast.LENGTH_SHORT).show();
//                            }
//                        })
//                        .addOnFailureListener(new OnFailureListener() {
//                            @Override
//                            public void onFailure(@NonNull Exception e) {
//                                Toast.makeText(addUser_act.this, "Error :"+e, Toast.LENGTH_SHORT).show();
//                            }
//                        });



                db.collection("User").document(email_str).set(user)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                Toast.makeText(addUser_act.this, "User added ", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(addUser_act.this, "Error :"+e, Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }
}