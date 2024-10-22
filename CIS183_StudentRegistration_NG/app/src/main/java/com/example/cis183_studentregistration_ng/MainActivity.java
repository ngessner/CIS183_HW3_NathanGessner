package com.example.cis183_studentregistration_ng;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity
{
    Button ma_btn_j_addNewStudent;
    Intent intent_j_addNewStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ma_btn_j_addNewStudent = findViewById(R.id.ma_btn_v_addNewStudent);
        intent_j_addNewStudent = new Intent(MainActivity.this, activity_add_student.class);

        addNewStudentButtonListener();
    }

    private void addNewStudentButtonListener()
    {
        ma_btn_j_addNewStudent.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(intent_j_addNewStudent);
            }
        });
    }
}