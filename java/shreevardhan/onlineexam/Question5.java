package shreevardhan.onlineexam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class Question5 extends AppCompatActivity {

    Button btn;
    RadioButton r1, r2, r3, r4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question5);
        btn = (Button) findViewById(R.id.button9);
        r1 = (RadioButton) findViewById(R.id.radioButton);
        r2 = (RadioButton) findViewById(R.id.radioButton2);
        r3 = (RadioButton) findViewById(R.id.radioButton3);
        r4 = (RadioButton) findViewById(R.id.radioButton4);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (r2.isChecked())
                    Question1.score = Question1.score + 4;
                if (r1.isChecked() || r2.isChecked() || r4.isChecked())
                    --Question1.score;

                String s = Integer.toString(Question1.score);
                Intent i=new Intent(Question5.this,ResultSend.class);
                i.putExtra("marks",s);
                startActivity(i);

            }
        });
    }
}