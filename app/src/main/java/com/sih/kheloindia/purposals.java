package com.sih.kheloindia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class purposals extends AppCompatActivity {
    TextView old, intrans,username_pur;
    LinearLayout oldL, intransL;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purposals);

        old = findViewById(R.id.old_purposal);
        intrans = findViewById(R.id.transition_purposal);
        oldL = findViewById(R.id.old_layout_purposal);
        intransL = findViewById(R.id.trans_layout_purposal);
        username_pur = findViewById(R.id.username_pur);

        Bundle bundle = getIntent().getExtras();
        String message = bundle.getString("name");
        username_pur.setText("Hi, "+message);


        oldL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(purposals.this, list_act.class);
                intent.putExtra("message", "Old Purposals");
                intent.putExtra("int", 1);
                startActivity(intent);
            }
        });

        oldL.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP){
                    oldL.setBackground(ContextCompat.getDrawable(purposals.this, R.drawable.editbox_sh));
                    old.setTextColor(ContextCompat.getColor(purposals.this, R.color.orange));
                }
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    oldL.setBackground(ContextCompat.getDrawable(purposals.this, R.drawable.orng));
                    old.setTextColor(ContextCompat.getColor(purposals.this, R.color.white));
                }
                return false;
            }
        });
        intransL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(purposals.this, list_act.class);
                intent.putExtra("message", "In-Transition Purposals");
                intent.putExtra("int", 2);
                startActivity(intent);
            }
        });




        intransL.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP){
                    intransL.setBackground(ContextCompat.getDrawable(purposals.this, R.drawable.editbox_sh));
                    intrans.setTextColor(ContextCompat.getColor(purposals.this, R.color.orange));

                }
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    intransL.setBackground(ContextCompat.getDrawable(purposals.this, R.drawable.orng));
                    intrans.setTextColor(ContextCompat.getColor(purposals.this, R.color.white));

                }
                return false;
            }
        });
    }
}