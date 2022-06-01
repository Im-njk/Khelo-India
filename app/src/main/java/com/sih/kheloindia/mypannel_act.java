package com.sih.kheloindia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class mypannel_act extends AppCompatActivity {
    Button user,anduser,propsal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypannel);
        user = findViewById(R.id.adduser);
        anduser = findViewById(R.id.add_anduser);
        propsal = findViewById(R.id.addpurposal);

        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(mypannel_act.this,addUser_act.class);
                startActivity(i);
            }
        });

        anduser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(mypannel_act.this,add_andUser_act.class);
                startActivity(i);
            }
        });

        propsal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(mypannel_act.this,add_purposal_act.class);
                i.putExtra("int", 1);
                startActivity(i);
            }
        });
    }
}