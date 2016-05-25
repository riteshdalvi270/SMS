package course.coursera.sms;

import android.Manifest;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SMS extends AppCompatActivity {

    private void requestPermission() {
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},1);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        requestPermission();

        final EditText toNumber = (EditText)findViewById(R.id.editText);
        final EditText message = (EditText) findViewById(R.id.editText2);

        final Button send = (Button) findViewById(R.id.button);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final SmsManager smsManager = SmsManager.getDefault();
                try {
                    smsManager.sendTextMessage(toNumber.getText().toString(), null, message.getText().toString(), null, null);
                    Toast.makeText(getApplicationContext(),"Message sent",Toast.LENGTH_SHORT).show();
                }catch (Exception e) {

                    Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        });
    }
}
