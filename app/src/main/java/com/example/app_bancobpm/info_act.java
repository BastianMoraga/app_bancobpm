package com.example.app_bancobpm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class info_act extends AppCompatActivity {

    private VideoView video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_act);

        video = (VideoView)findViewById(R.id.vvInfo);

        String ruta = "android:resource://" + getPackageName() + "/" + R.raw.video;
        Uri uri = Uri.parse(ruta);
        video.setVideoURI(uri);

        MediaController media =new MediaController(this);
        video.setMediaController(media);
    }

    public void maps(View view)
    {
        Intent i = new Intent(this, maps_act.class);
        startActivity(i);
    }
}