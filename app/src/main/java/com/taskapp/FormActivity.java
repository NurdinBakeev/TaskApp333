package com.taskapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class FormActivity extends AppCompatActivity {

    EditText editTitle, editDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        editTitle = findViewById(R.id.editTitle);
        editDesc = findViewById(R.id.editDesk);
    }

    public void onClick(View view) {

        String title = editTitle.getText().toString().trim();
        String desc = editDesc.getText().toString().trim();

        if (TextUtils.isEmpty(title)){
            editTitle.setError("Пустые поля не принимаем");
            return;
        }

        if (TextUtils.isEmpty(desc)){
            editDesc.setError("Пустые поля не принимаем");
            return;
        }

        Task task = new Task(title,desc);
        Intent intent = new Intent();
        intent.putExtra("task", task);
        setResult(RESULT_OK, intent);
        finish();
    }
}
