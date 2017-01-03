package shreevardhan.onlineexam;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText et1,et2;
    Button btn1,btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=(EditText)findViewById(R.id.username);
        et2=(EditText)findViewById(R.id.password);
        btn1=(Button)findViewById(R.id.login);
        btn2=(Button)findViewById(R.id.signup);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SignupActivity.class));
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=et1.getText().toString();
                String s2=et2.getText().toString();
                if(s1.equals("") || s2.equals(""))
                    Toast.makeText(MainActivity.this,"Please fill both fields to login",Toast.LENGTH_SHORT).show();
                else
                {
                    SQLiteDatabase db=openOrCreateDatabase("ExamDB",MODE_PRIVATE,null);
                    db.execSQL("Create table if not exists mytable (username varchar, password varchar,email varchar, city varchar, phone varchar, score varchar)");
                    String query="Select * from mytable where username='"+s1+"' and password='"+s2+"'";
                    Cursor cursor=db.rawQuery(query,null);
                    if(cursor.getCount()!=0)
                    {
                        Intent j=new Intent(MainActivity.this,Functions.class);
                        j.putExtra("username",s1);
                        startActivity(j);
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this,"Sorry !! We don't have your record.Please SignUp first.",Toast.LENGTH_LONG).show();
                    }


                }
            }
        });



    }
}
