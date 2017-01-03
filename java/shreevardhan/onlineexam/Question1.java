package shreevardhan.onlineexam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class Question1 extends AppCompatActivity {

    Button btn;
    RadioButton r1,r2,r3,r4;
    static int score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);
        btn=(Button)findViewById(R.id.button9);
        r1=(RadioButton)findViewById(R.id.radioButton);
        r2=(RadioButton)findViewById(R.id.radioButton2);
        r3=(RadioButton)findViewById(R.id.radioButton3);
        r4=(RadioButton)findViewById(R.id.radioButton4);

        score=0;
        /*Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                String s = Integer.toString(Question1.score);
                Intent i=new Intent(Question1.this,ResultSend.class);
                i.putExtra("marks",s);
                startActivity(new Intent(Question1.this,ResultSend.class));

            }

        }, 30000);*/

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(r2.isChecked())
                    score=score+4;
                if(r1.isChecked() || r3.isChecked() || r4.isChecked())
                    --score;

                startActivity(new Intent(Question1.this,Question2.class));
            }
        });
    }
}
