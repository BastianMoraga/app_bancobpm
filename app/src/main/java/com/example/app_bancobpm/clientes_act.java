package com.example.app_bancobpm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import Clases.AdminSQLiteOpenHelper;

public class clientes_act extends AppCompatActivity {

    private EditText edCodigo, edNombre, edSalario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes_act);

        edCodigo = (EditText)findViewById(R.id.edCodigo);
        edNombre = (EditText)findViewById(R.id.edNombre);
        edSalario = (EditText)findViewById(R.id.edSalario);

    }

    public void guardarCliente(View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Banco", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = edCodigo.getText().toString();
        String nombre = edNombre.getText().toString();
        String salario = edSalario.getText().toString();

        /*if ((!codigo.isEmpty()) || (!nombre.isEmpty()) || (!salario.isEmpty()))*/
        if(!codigo.isEmpty())
        {
            ContentValues registro = new ContentValues();
            registro.put("codigo", Integer.parseInt(codigo));
            registro.put("nombre", nombre);
            registro.put("salario", Integer.parseInt(salario));

            db.insert("cliente", null, registro);
            db.close();

            Toast.makeText(this, "Se ha agregado un Cliente", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "Completar todos los campos", Toast.LENGTH_LONG).show();
        }
    }

    public void mostrarCliente(View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Banco", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = edCodigo.getText().toString();


        if (!codigo.isEmpty())
        {
            Cursor fila = db.rawQuery("SELECT nombre, salario FROM cliente WHERE codigo=" + codigo, null);

            if (fila.moveToFirst())
            {
                edNombre.setText(fila.getString(0));
                edSalario.setText(fila.getString(1));
            }
            else
            {
                Toast.makeText(this, "Cliente no existe", Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            Toast.makeText(this, "No ha ingresado el codigo", Toast.LENGTH_LONG).show();
        }
    }

    public void eliminarCliente(View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Banco", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = edCodigo.getText().toString();

        if (!codigo.isEmpty())
        {
            db.delete("cliente", "codigo=" + codigo, null);
            db.close();

            Toast.makeText(this, "Cliente Eliminado", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "No ha ingresado el codigo", Toast.LENGTH_LONG).show();
        }
    }

    public void actualizarCliente(View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Banco", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = edCodigo.getText().toString();
        String nombre = edNombre.getText().toString();
        String salario = edSalario.getText().toString();

        ContentValues cont = new ContentValues();
        cont.put("codigo", Integer.parseInt(codigo));
        cont.put("nombre", nombre);
        cont.put("salario", Integer.parseInt(salario));

        /*if ((!codigo.isEmpty()) || (!nombre.isEmpty()) || (!salario.isEmpty()))*/
        if(!codigo.isEmpty())
        {
            db.update("cliente", cont, "codigo=" + codigo, null);
            db.close();

            Toast.makeText(this, "Cliente actualizado", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "Completar todos los campos", Toast.LENGTH_LONG).show();
        }
    }
}