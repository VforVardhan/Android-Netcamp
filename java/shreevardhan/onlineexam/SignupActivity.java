package shreevardhan.onlineexam;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {
EditText username,password,confirmpassword,email,city,phone;
    Button signup,back;
    static String s4,s6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        username=(EditText)findViewById(R.id.editText);
        password=(EditText)findViewById(R.id.editText2);
        confirmpassword=(EditText)findViewById(R.id.editText3);
        email=(EditText)findViewById(R.id.editText4);
        city=(EditText)findViewById(R.id.editText5);
        phone=(EditText)findViewById(R.id.editText6);
        signup=(Button)findViewById(R.id.button);
        back=(Button)findViewById(R.id.button2);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignupActivity.this,MainActivity.class));
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=username.getText().toString();
                String s2=password.getText().toString();
                String s3=confirmpassword.getText().toString();
                s4=email.getText().toString();
                String s5=city.getText().toString();
                s6=phone.getText().toString();

                if(s1.equals("")==true || s2.equals("")==true || s3.equals("")==true || s4.equals("")==true)
                    Toast.makeText(SignupActivity.this,"The first four fields are mandatory to fill",Toast.LENGTH_SHORT).show();

                else if(s2.equals(s3)==false)
                    Toast.makeText(SignupActivity.this,"Please Recheck your Password",Toast.LENGTH_LONG).show();

                else
                {
                    SQLiteDatabase db=openOrCreateDatabase("ExamDB",MODE_PRIVATE,null);
                    db.execSQL("Create table if not exists mytable (username varchar, password varchar, email varchar, city varchar, phone varchar)");
                    db.execSQL("Insert into mytable values ('"+s1+"' , '"+s2+"' , '"+s4+"' , '"+s5+"' , '"+s6+"') ");
                    Toast.makeText(SignupActivity.this,"You have been added !!", Toast.LENGTH_SHORT).show();
                    Intent j=new Intent(SignupActivity.this,Functions.class);
                    j.putExtra("username",s1);
                    startActivity(j);
                }
            }
        });


    }
}
