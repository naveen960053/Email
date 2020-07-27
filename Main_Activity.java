package com.example.email;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText to,sub,msg;
    Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        to=(EditText)findViewById(R.id.to);
        sub=(EditText)findViewById(R.id.sub);
        msg=(EditText)findViewById(R.id.msg);
        send=(Button)findViewById(R.id.send);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String recipientList=to.getText().toString();
                String[] recipient=recipientList.split(",");
                String message=msg.getText().toString();
                String subject=sub.getText().toString();

                Intent i=new Intent(Intent.ACTION_SEND);
                i.putExtra(Intent.EXTRA_EMAIL,recipient);
                i.putExtra(Intent.EXTRA_SUBJECT,subject);
                i.putExtra(Intent.EXTRA_TEXT,message);

                i.setType("message/rfc882");
                startActivity(Intent.createChooser(i,"Choose an email client"));
            }
        });
    }
}
