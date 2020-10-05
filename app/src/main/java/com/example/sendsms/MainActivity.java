package com.example.sendsms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageButton btn_send,btn_res;
    EditText etxt_res,etxt_msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_send=findViewById(R.id.btn_Send);
        btn_res=findViewById(R.id.btn_res);
        etxt_res=findViewById(R.id.etxt_Recipient);
        etxt_msg=findViewById(R.id.etxt_msg);

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.SEND_SMS}, 0);
                    SmsManager sms = SmsManager.getDefault();
                    sms.sendTextMessage(etxt_res.getText().toString(), null, etxt_msg.getText().toString(), null, null);
                    Toast.makeText(MainActivity.this, "Message sent!", Toast.LENGTH_SHORT).show();
                    etxt_msg.setText("");
                }
                catch (Exception ex)
                {
                    ex.printStackTrace();
                }
            }
        });
        btn_res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(Intent.ACTION_VIEW);
                startActivity(i);
            }
        });

    }
}
