package shreevardhan.onlineexam;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MusicPlayer extends AppCompatActivity {

    Button btn,play,pause;

    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);
        btn=(Button)findViewById(R.id.button11);
        play=(Button)findViewById(R.id.button12);
        pause=(Button)findViewById(R.id.button13);

        mp=MediaPlayer.create(this,R.raw.crankitup);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MusicPlayer.this,Functions.class);
                i.putExtra("username",Functions.uname);
                startActivity(i);
            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.pause();
            }
        });

        //iv.setImageResource(R.drawable.davidguetta);
    }
}
