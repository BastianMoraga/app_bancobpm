package com.example.app_bancobpm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import java.util.ArrayList;

public class home_act extends AppCompatActivity {

    private ViewFlipper vf;
    private int[] image = {R.drawable.a, R.drawable.b, R.drawable.c};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_act);

        vf = (ViewFlipper)findViewById(R.id.vf);

        for(int i = 0; i < image.length; i++)
        {
            flipImage(image[i]);
        }

    }

    public void flipImage(int i)
    {
        ImageView view = new ImageView(this);
        view.setBackgroundResource(i);

        vf.addView(view);
        vf.setFlipInterval(2000);
        vf.setAutoStart(true);

        vf.setInAnimation(this, android.R.anim.slide_in_left);
        vf.setOutAnimation(this, android.R.anim.slide_out_right);
    }

    public  void info(View view)
    {
        Intent i = new Intent(this, info_act.class);
        startActivity(i);
    }

    public  void seguridad(View view)
    {
        Intent i = new Intent(this, seguridad_act.class);
        startActivity(i);
    }

    public void prestamos(View view)
    {
        ArrayList<String> clientes = new ArrayList<String>();
        ArrayList<String> creditos = new ArrayList<String>();

        clientes.add("Axel");
        clientes.add("Roxana");

        creditos.add("Credito Hipotecado");
        creditos.add("Credito Automotriz");

        Intent i = new Intent(this, prestamos_act.class);

        i.putExtra("listaClientes", clientes);
        i.putExtra("listaCreditos", creditos);

        startActivity(i);
    }

    public  void clientes(View view)
    {
        Intent i = new Intent(this, clientes_act.class);
        startActivity(i);
    }
}