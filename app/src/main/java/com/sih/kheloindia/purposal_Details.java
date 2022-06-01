package com.sih.kheloindia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class purposal_Details extends AppCompatActivity {
    TextView pro_name,ap_name,area_detail,com_time,cost_detail,doa_detail,just_detail,loc_pro,owner_detail,phone_detail,postal_detail,
            sport_detail,status_detail,stage_detail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purposal_details);

        Intent i = getIntent();
        purposal_modal modal = (purposal_modal)i.getSerializableExtra("sampleObject");

        pro_name = findViewById(R.id.pro_name);
        ap_name = findViewById(R.id.ap_name);
        area_detail = findViewById(R.id.area_detail);
        com_time = findViewById(R.id.com_time);
        cost_detail = findViewById(R.id.cost_detail);
        doa_detail = findViewById(R.id.doa_detail);
        just_detail = findViewById(R.id.just_detail);
        loc_pro = findViewById(R.id.loc_pro);
        owner_detail = findViewById(R.id.owner_detail);
        phone_detail = findViewById(R.id.phone_detail);
        postal_detail = findViewById(R.id.postal_detail);
        sport_detail = findViewById(R.id.sport_detail);
        status_detail = findViewById(R.id.status_detail);
        stage_detail = findViewById(R.id.stage_detail);

        pro_name.setText(modal.getName_project());
        ap_name.setText(modal.getName_applicant());
        area_detail.setText(modal.getArea());
        com_time.setText(modal.getCompletiontime());
        cost_detail.setText(modal.getCost());
        doa_detail.setText(modal.getDoa());
        //just_detail.setText(modal.getJust());
        loc_pro.setText(modal.getLocation());
        owner_detail.setText(modal.getOwner());
        //phone_detail.setText(modal.getMob());
        postal_detail.setText(modal.getPostal());
        sport_detail.setText(modal.getSport());
        status_detail.setText(modal.getStatus());
        stage_detail.setText(modal.getStage());

    }
}