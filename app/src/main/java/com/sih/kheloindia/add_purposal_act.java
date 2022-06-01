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

public class add_purposal_act extends AppCompatActivity {
    EditText nameodfapplicant, postal,phone,nameofproject,location,area,ownership,sports,cost,justification,time,apply_date,stage,status,userid,application_id;
    Button btn;
    FirebaseFirestore db ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_purposal);
        nameodfapplicant = findViewById(R.id.name_of_applicant_proposal);
        postal  = findViewById(R.id.postal_add);
        phone = findViewById(R.id.phone_propoasl);
        nameofproject = findViewById(R.id.name_of_proposal);
        location = findViewById(R.id.location_of_project);
        area = findViewById(R.id.Size_proposal);
        ownership = findViewById(R.id.Ownership);
        sports = findViewById(R.id.sports_proposal);
        cost = findViewById(R.id.cost_proposal);
        justification = findViewById(R.id.justification);
        time = findViewById(R.id.date_propsal);
        btn = findViewById(R.id.btn_add_propsal);
        apply_date = findViewById(R.id.applicaationdate_propsal);
        stage = findViewById(R.id.stage_propsal);
        status = findViewById(R.id.status_propsal);
        userid = findViewById(R.id.userid_propsal);
        application_id = findViewById(R.id.appid_propsal);
        db = FirebaseFirestore.getInstance();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String sports_str= sports.getText().toString().trim();
                String cost_str  = cost.getText().toString().trim();
                String just_str  = justification.getText().toString().trim();
                String time_str  = time.getText().toString().trim();
                String applytime_str  = apply_date.getText().toString().trim();
                String stage_str  = stage.getText().toString().trim();
                String status_str  = status.getText().toString().trim();
                String user_id_str  = userid.getText().toString().trim();
                String application_id_str  = application_id.getText().toString().trim();
                String applicant_name_str = nameodfapplicant.getText().toString().trim();
                String postal_str = postal.getText().toString().trim();
                String phone_str = phone.getText().toString().trim();
                String name_project_str = nameofproject.getText().toString().trim();
                String location_str = location.getText().toString().trim();
                String area_str = area.getText().toString().trim();
                String owner_str = ownership.getText().toString().trim();


                Map<String,Object> propsal = new HashMap<>();
                propsal.put("Area of Land",area_str);
                propsal.put("Completion time",time_str);
                propsal.put("Date of Application",applytime_str);
                propsal.put("Cost of Estimation",cost_str);
                propsal.put("Justification ",just_str);
                propsal.put("Stage",stage_str);
                propsal.put("Status",status_str);
                propsal.put("User Id",user_id_str);
                propsal.put("Sports",sports_str);
                propsal.put("Applicant Name",applicant_name_str);
                propsal.put("Postal Address",postal_str);
                propsal.put("Phone No.",phone_str);
                propsal.put("Name of Project",name_project_str);
                propsal.put("Location of Project",location_str);
                propsal.put("Ownership",owner_str);

                db.collection("Applications").document(application_id_str).set(propsal)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                Toast.makeText(add_purposal_act.this, "Proposal added ", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(add_purposal_act.this, "Error :"+e, Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }
}