package shreevardhan.onlineexam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Question4 extends AppCompatActivity {

    Button btn;
    RadioButton r1, r2, r3, r4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question4);
        btn = (Button) findViewById(R.id.button9);
        r1 = (RadioButton) findViewById(R.id.radioButton);
        r2 = (RadioButton) findViewById(R.id.radioButton2);
        r3 = (RadioButton) findViewById(R.id.radioButton3);
        r4 = (RadioButton) findViewById(R.id.radioButton4);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (r3.isChecked())
                    Question1.score = Question1.score + 4;
                if (r1.isChecked() || r2.isChecked() || r4.isChecked())
                    --Question1.score;


                startActivity(new Intent(Question4.this,Question5.class));

            }
        });
    }
}
