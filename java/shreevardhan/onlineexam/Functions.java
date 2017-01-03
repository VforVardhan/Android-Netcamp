package shreevardhan.onlineexam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Functions extends AppCompatActivity {
    TextView tv;
    Button back,mp,cal,cam,quiz;
    static String uname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_functions);
        tv=(TextView)findViewById(R.id.textView4);
        back=(Button)findViewById(R.id.button3);
        mp=(Button)findViewById(R.id.button4);
        cal=(Button)findViewById(R.id.button5);
        cam=(Button)findViewById(R.id.button6);
        quiz=(Button)findViewById(R.id.button7);
        Intent i=getIntent();
        uname=i.getStringExtra("username");
        tv.setText("WELCOME "+uname);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Functions.this,SignupActivity.class));
            }
        });

        mp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Functions.this,MusicPlayer.class));
            }
        });

        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Functions.this,Calculator.class));
            }
        });

        cam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Functions.this,Camera.class));
            }
        });

        quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Functions.this,Quiz.class));
            }
        });
    }
}
