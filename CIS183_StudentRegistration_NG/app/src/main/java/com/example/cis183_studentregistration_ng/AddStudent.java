package com.example.cis183_studentregistration_ng;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class AddStudent extends AppCompatActivity
{
    Button as_btn_j_back;
    Button as_btn_j_addStudent;
    Intent intent_j_mainmenu;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_student);

        as_btn_j_back = findViewById(R.id.as_btn_v_back);
        as_btn_j_addStudent = findViewById(R.id.as_btn_v_addStudent);
        intent_j_mainmenu = new Intent(AddStudent.this, MainActivity.class);

        backButtonListener();
        addBtnButtonListener();
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
    private void addBtnButtonListener()
    {
        as_btn_j_addStudent.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(intent_j_mainmenu);
            }
        });
    }
}