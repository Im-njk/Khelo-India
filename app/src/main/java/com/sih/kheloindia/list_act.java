package com.sih.kheloindia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Application;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class list_act extends AppCompatActivity {
    RecyclerView recyclerView;
    List<purposal_modal> list = new ArrayList<>();
    recyclerviewClass claa;
    TextView title ;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Bundle bundle = getIntent().getExtras();
        String message = bundle.getString("message");
        int key = bundle.getInt("int");

        title = findViewById(R.id.list_title);
        title.setText(message);
        recyclerView=findViewById(R.id.recycker);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        ProgressDialog pd = new ProgressDialog(list_act.this);
        pd.setMessage("loading");
        pd.show();

        db.collection("Applications").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                if(key==1) {
                                    if (!document.get("Status").toString().toLowerCase(Locale.ROOT).equals("pending")) {
                                        purposal_modal modal = new purposal_modal();
                                        modal.setArea(document.get("Area of Land").toString());
                                        modal.setName_applicant(document.get("Applicant Name").toString());
                                        modal.setCompletiontime(document.get("Completion time").toString());
                                        modal.setCost(document.get("Cost of Estimation").toString());
                                        modal.setDoa(document.get("Date of Application").toString());
                                        //modal.setJust(document.get("Justification").toString());
                                        modal.setLocation(document.get("Location of Project").toString());
                                        modal.setName_project(document.get("Name of Project").toString());
                                        modal.setOwner(document.get("Ownership").toString());
                                        //modal.setMob(document.get("Phone No.").toString());
                                        modal.setPostal(document.get("Postal Address").toString());
                                        modal.setSport(document.get("Sports").toString());
                                        modal.setStage(document.get("Stage").toString());
                                        modal.setStatus(document.get("Status").toString());
                                        modal.setUserid(document.get("User Id").toString());
                                        list.add(modal);
                                    }
                                }
                                else{
                                    if (document.get("Status").toString().toLowerCase(Locale.ROOT).equals("pending")) {
                                        purposal_modal modal = new purposal_modal();
                                        modal.setArea(document.get("Area of Land").toString());
                                        modal.setName_applicant(document.get("Applicant Name").toString());
                                        modal.setCompletiontime(document.get("Completion time").toString());
                                        modal.setCost(document.get("Cost of Estimation").toString());
                                        modal.setDoa(document.get("Date of Application").toString());
                                        //modal.setJust(document.get("Justification").toString());
                                        modal.setLocation(document.get("Location of Project").toString());
                                        modal.setName_project(document.get("Name of Project").toString());
                                        modal.setOwner(document.get("Ownership").toString());
                                        //modal.setMob(document.get("Phone No.").toString());
                                        modal.setPostal(document.get("Postal Address").toString());
                                        modal.setSport(document.get("Sports").toString());
                                        modal.setStage(document.get("Stage").toString());
                                        modal.setStatus(document.get("Status").toString());
                                        modal.setUserid(document.get("User Id").toString());
                                        list.add(modal);
                                    }
                                }
                            }
                            claa=new recyclerviewClass(list_act.this,list);
                            recyclerView.setAdapter(claa);
                            pd.dismiss();
                        } else {
                            Toast.makeText(list_act.this, (CharSequence) task.getException(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

        claa=new recyclerviewClass(list_act.this,list);
        recyclerView.setAdapter(claa);

    }
}