package com.example.test2;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.test2.R;



public class MainActivity extends AppCompatActivity {

    Button playshort, playlong, play3, play4, play5, play6, d1, d2, d3, d4, d5, d6;

    SoundPool sp;
    MediaPlayer mp;
    int sonido_de_Reproduccion;
    int sonido_de_Reproduccion2;
    int sonido_de_Reproduccion3;
    int sonido_de_Reproduccion4;
    int sonido_de_Reproduccion5;

    String url_1, url_2, url_3, url_4, url_5, url_6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //PlayShort
        playshort = (Button)findViewById(R.id.button_playshort);

        //PlayLong
        playlong = (Button)findViewById(R.id.button_playlong);

        //Play3
        play3 = (Button)findViewById(R.id.button_play3);

        //Play4
        play4 = (Button)findViewById(R.id.button_play4);

        //Play5
        play5 = (Button)findViewById(R.id.button_play5);

        //Play6
        play6 = (Button)findViewById(R.id.button_play6);

        //Download
        d1 = (Button)findViewById(R.id.button_desc1);
        d2 = (Button)findViewById(R.id.button_desc2);
        d3 = (Button)findViewById(R.id.button_desc3);
        d4 = (Button)findViewById(R.id.button_desc4);
        d5 = (Button)findViewById(R.id.button_desc5);
        d6 = (Button)findViewById(R.id.button_desc6);

        //URL
        url_1 = "https://www.sonidosmp3gratis.com/sounds/tono-mensaje-3-.mp3";
        url_2 = "https://www.sonidosmp3gratis.com/sounds/iphone-notificacion.mp3";
        url_3 = "https://www.sonidosmp3gratis.com/sounds/mario-bros%20tuberia.mp3";
        url_4 = "https://www.sonidosmp3gratis.com/sounds/mario-bros%20vida.mp3";
        url_5 = "https://www.sonidosmp3gratis.com/sounds/mario-bros-die.mp3";
        url_6 = "https://www.sonidosmp3gratis.com/sounds/mario-coin.mp3";

        //SoundPool tendrá playshort
        sp = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);

        //Cargando los sonidos adicionales en el SoundPool
        sonido_de_Reproduccion = sp.load(this, R.raw.sound_short, 1);
        sonido_de_Reproduccion2 = sp.load(this, R.raw.mario_tuberia, 1);
        sonido_de_Reproduccion3 = sp.load(this, R.raw.mario_vida, 1);
        sonido_de_Reproduccion4 = sp.load(this, R.raw.mario_die, 1);
        sonido_de_Reproduccion5 = sp.load(this, R.raw.mario_coin, 1);

        d1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(url_1);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        d2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(url_2);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        d3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(url_3);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        d4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(url_4);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        d5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(url_5);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        d6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(url_6);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }



    //Métodos para los botones
    public void onButtonClick(View view) {
        String tag = view.getTag().toString();
        switch (tag) {
            case "playshort":
                sp.play(sonido_de_Reproduccion, 1, 1, 1, 0, 1);
                break;
            case "playlong":
                if (mp != null) {
                    mp.release();
                }
                mp = MediaPlayer.create(this, R.raw.sound_long);
                mp.start();
                break;
            case "play3":
                sp.play(sonido_de_Reproduccion2, 1, 1, 1, 0, 1);
                break;
            case "play4":
                sp.play(sonido_de_Reproduccion3, 1, 1, 1, 0, 1);
                break;
            case "play5":
                sp.play(sonido_de_Reproduccion4, 1, 1, 1, 0, 1);
                break;
            case "play6":
                sp.play(sonido_de_Reproduccion5, 1, 1, 1, 0, 1);
                break;
        }
    }





    @Override
    protected void onStop(){
        super.onStop();
        if(mp!=null)
        {
            mp.release();
            mp=null;
        }
    }
}