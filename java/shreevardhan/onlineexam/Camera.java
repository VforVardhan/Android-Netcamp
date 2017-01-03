package shreevardhan.onlineexam;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Camera extends AppCompatActivity {

    Button btn,back;
    ImageView iv;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {  //displaying the captured image in the imageView
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap b=(Bitmap)data.getExtras().get("data");
        iv.setImageBitmap(b);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        btn=(Button)findViewById(R.id.button10);
        back=(Button)findViewById(R.id.button3);
        iv=(ImageView)findViewById(R.id.imageView2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i,0); //camera opens up
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Camera.this,Functions.class);
                i.putExtra("username",Functions.uname);
                startActivity(i);

            }
        });

    }
}
