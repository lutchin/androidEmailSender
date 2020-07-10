package com.example.emailsender;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private EditText emailTo;
    private TextView subject;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        textView = findViewById(R.id.text_message);
        textView.setText(message);

        emailTo = findViewById(R.id.email);
        subject = findViewById(R.id.subject);

    }

    public void sendEmail(View view) {

        String to = emailTo.getText().toString();
        String subjectEmail = subject.getText().toString();
        String messageEmail = textView.getText().toString();

        Intent email = new Intent(Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
        email.putExtra(Intent.EXTRA_SUBJECT, subjectEmail);
        email.putExtra(Intent.EXTRA_TEXT, messageEmail);

        email.setType("message/rfc822");

        startActivity(Intent.createChooser(email, "Choose an Email client :"));
    }
}