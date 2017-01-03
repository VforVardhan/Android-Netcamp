package shreevardhan.onlineexam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Calculator extends AppCompatActivity {

    Button back,btn1,btn2,btn3,btn4,btn5;
    EditText et1,et2;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);


            back=(Button)findViewById(R.id.button14);
            btn1=(Button)findViewById(R.id.button15);
            btn2=(Button)findViewById(R.id.button16);
            btn3=(Button)findViewById(R.id.button17);
            btn4=(Button)findViewById(R.id.button18);
            btn5=(Button)findViewById(R.id.button19);

            et1=(EditText)findViewById(R.id.editText7);
            et2=(EditText)findViewById(R.id.editText8);
            tv=(TextView)findViewById(R.id.textView2);


            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Double i1=Double.parseDouble(et1.getText().toString());
                    Double i2=Double.parseDouble(et2.getText().toString());

                    String s=Double.toString(i1+i2);
                    tv.setText(s);
                }
            });

            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Double i1=Double.parseDouble(et1.getText().toString());
                    Double i2=Double.parseDouble(et2.getText().toString());
                    String s=Double.toString(i1-i2);
                    tv.setText(s);
                }
            });

            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Double i1=Double.parseDouble(et1.getText().toString());
                    Double i2=Double.parseDouble(et2.getText().toString());
                    String s=Double.toString(i1*i2);
                    tv.setText(s);
                }
            });

            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Double i1=Double.parseDouble(et1.getText().toString());
                    Double i2=Double.parseDouble(et2.getText().toString());
                    String s=Double.toString(i1/i2);
                    tv.setText(s);
                }
            });

            btn5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    et1.setText("");
                    et2.setText("");
                    tv.setText("");
                }
            });

            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i=new Intent(Calculator.this,Functions.class);
                    i.putExtra("username",Functions.uname);
                    startActivity(i);
                }
            });
        }
    }

