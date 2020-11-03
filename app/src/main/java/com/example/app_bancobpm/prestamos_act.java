package com.example.app_bancobpm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

import Clases.Clientes;
import Clases.Prestamos;

public class prestamos_act extends AppCompatActivity {

    private Spinner spinClientes, spinCreditos;
    private TextView resultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prestamos_act);

        spinClientes = (Spinner)findViewById(R.id.spClientes);
        spinCreditos = (Spinner)findViewById(R.id.spPrestamos);
        resultado = (TextView) findViewById(R.id.txtResultado);

        ArrayList<String> listaClientes = (ArrayList<String>) getIntent().getSerializableExtra("listaClientes");
        ArrayList<String> listaCreditos = (ArrayList<String>) getIntent().getSerializableExtra("listaCreditos");

        ArrayAdapter<String> adaptClientes = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaClientes);
        ArrayAdapter<String> adaptCreditos = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaCreditos);

        spinClientes.setAdapter(adaptClientes);
        spinCreditos.setAdapter(adaptCreditos);
    }

    public void prestamo(View view)
    {
        String cliente = spinClientes.getSelectedItem().toString();
        String credito = spinCreditos.getSelectedItem().toString();

        Clientes cli = new Clientes();
        Prestamos pre = new Prestamos();
        int sueldo, prestamo, total;

        if (cliente.equals("Axel"))
        {
            sueldo = Integer.parseInt(cli.getAxel());

            if (credito.equals("Credito Hipotecado"))
            {
                prestamo = Integer.parseInt(pre.getHipotecario());
                total = sueldo + prestamo;

                resultado.setText("Total: " + total);
            }
            if (credito.equals("Credito Automotriz"))
            {
                prestamo = Integer.parseInt(pre.getAutomotriz());
                total = sueldo + prestamo;

                resultado.setText("Total: " + total);
            }
        }
        if (cliente.equals("Roxana"))
        {
            sueldo = Integer.parseInt(cli.getRoxana());

            if (credito.equals("Credito Hipotecado"))
            {
                prestamo = Integer.parseInt(pre.getHipotecario());
                total = sueldo + prestamo;

                resultado.setText("Total: " + total);
            }
            if (credito.equals("Credito Automotriz"))
            {
                prestamo = Integer.parseInt(pre.getAutomotriz());
                total = sueldo + prestamo;

                resultado.setText("Total: " + total);
            }
        }
        if(cliente.equals("Betzabe"))
        {
            sueldo = Integer.parseInt(cli.getBetzabe());

            if (credito.equals("Credito Hipotecado"))
            {
                prestamo = Integer.parseInt(pre.getHipotecario());
                total = sueldo + prestamo;

                resultado.setText("Total: " + total);
            }
            if (credito.equals("Credito Automotriz"))
            {
                prestamo = Integer.parseInt(pre.getAutomotriz());
                total = sueldo + prestamo;

                resultado.setText("Total: " + total);
            }
        }
        if (cliente.equals("Matias"))
        {
            sueldo = Integer.parseInt(cli.getMatias());

            if (credito.equals("Credito Hipotecado"))
            {
                prestamo = Integer.parseInt(pre.getHipotecario());
                total = sueldo + prestamo;

                resultado.setText("Total: " + total);
            }
            if (credito.equals("Credito Automotriz"))
            {
                prestamo = Integer.parseInt(pre.getAutomotriz());
                total = sueldo + prestamo;

                resultado.setText("Total: " + total);
            }
        }
    }

    public  void deuda(View view)
    {
        String cliente = spinClientes.getSelectedItem().toString();
        String credito = spinCreditos.getSelectedItem().toString();

        Clientes cli = new Clientes();
        Prestamos pre = new Prestamos();
        int sueldo, prestamo, total;

        if (cliente.equals("Axel"))
        {
            sueldo = Integer.parseInt(cli.getAxel());

            if (credito.equals("Credito Hipotecado"))
            {
                prestamo = Integer.parseInt(pre.getHipotecario());
                total = (sueldo + prestamo)/12;

                resultado.setText("Cuotas: " + total);
            }
            if (credito.equals("Credito Automotriz"))
            {
                prestamo = Integer.parseInt(pre.getAutomotriz());
                total = (sueldo + prestamo)/8;

                resultado.setText("Cuotas: " + total);
            }
        }
        if (cliente.equals("Roxana"))
        {
            sueldo = Integer.parseInt(cli.getRoxana());

            if (credito.equals("Credito Hipotecado"))
            {
                prestamo = Integer.parseInt(pre.getHipotecario());
                total = (sueldo + prestamo)/12;

                resultado.setText("Cuotas: " + total);
            }
            if (credito.equals("Credito Automotriz"))
            {
                prestamo = Integer.parseInt(pre.getAutomotriz());
                total = (sueldo + prestamo)/8;

                resultado.setText("Cuotas: " + total);
            }
        }
        if (cliente.equals("Betzabe"))
        {

            sueldo = Integer.parseInt(cli.getBetzabe());

            if (credito.equals("Credito Hipotecado"))
            {
                prestamo = Integer.parseInt(pre.getHipotecario());
                total = (sueldo + prestamo)/12;

                resultado.setText("Cuotas: " + total);
            }
            if (credito.equals("Credito Automotriz"))
            {
                prestamo = Integer.parseInt(pre.getAutomotriz());
                total = (sueldo + prestamo)/8;

                resultado.setText("Cuotas: " + total);
            }
        }
        if (cliente.equals("Matias"))
        {

            sueldo = Integer.parseInt(cli.getMatias());

            if (credito.equals("Credito Hipotecado"))
            {
                prestamo = Integer.parseInt(pre.getHipotecario());
                total = (sueldo + prestamo)/12;

                resultado.setText("Cuotas: " + total);
            }
            if (credito.equals("Credito Automotriz"))
            {
                prestamo = Integer.parseInt(pre.getAutomotriz());
                total = (sueldo + prestamo)/8;

                resultado.setText("Cuotas: " + total);
            }
        }
    }
}