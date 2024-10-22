package com.example.cis183_studentregistration_ng;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class activity_add_student extends AppCompatActivity
{
    Button as_btn_j_back;
    Intent intent_j_mainmenu;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_student);

        as_btn_j_back = findViewById(R.id.as_btn_v_back);
        intent_j_mainmenu = new Intent(activity_add_student.this, MainActivity.class);

        backButtonListener();
    }

    private void backButtonListener()
    {
        as_btn_j_back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(intent_j_mainmenu);
            }
        });
    }
}