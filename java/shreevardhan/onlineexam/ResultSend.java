package shreevardhan.onlineexam;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ResultSend extends AppCompatActivity {

    TextView tv,tv1;
    Button sms,email,out;
    String s1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_send);
        tv=(TextView) findViewById(R.id.textView14);
        tv.setText("Hey "+Functions.uname);
        tv1=(TextView)findViewById(R.id.textView13);
        sms=(Button)findViewById(R.id.button20);
        email=(Button)findViewById(R.id.button21);
        out=(Button)findViewById(R.id.button22);
        Intent i=getIntent();
        s1=i.getStringExtra("marks");
        sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SmsManager sandesh= SmsManager.getDefault();
                sandesh.sendTextMessage(SignupActivity.s6,null,"Your Quiz score is : "+s1,null,null);
                Toast.makeText(ResultSend.this,"your score has been texted to this no. "+SignupActivity.s6,Toast.LENGTH_SHORT).show();
            }
        });
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent obj=new Intent(Intent.ACTION_SEND);
                obj.setData(Uri.parse("mailto:"));
                String[] to={SignupActivity.s4};
                obj.putExtra(Intent.EXTRA_EMAIL,to);
                obj.putExtra(Intent.EXTRA_SUBJECT,"The result of your online exam");
                obj.putExtra(Intent.EXTRA_TEXT,"Your score is : "+s1);
                obj.setType("message/rfc822");
                startActivity(Intent.createChooser(obj,"Select an app"));
                Toast.makeText(ResultSend.this,"your score will be mailed to "+SignupActivity.s4,Toast.LENGTH_SHORT).show();


            }
        });

        out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ResultSend.this,"Thank you "+Functions.uname+" for using this app !!",Toast.LENGTH_LONG).show();
                startActivity(new Intent(ResultSend.this,MainActivity.class));

            }
        });
    }
}
