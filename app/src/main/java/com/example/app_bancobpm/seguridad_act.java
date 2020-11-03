package com.example.app_bancobpm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.security.MessageDigest;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class seguridad_act extends AppCompatActivity {

    private EditText pass;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seguridad_act);

        pass = (EditText)findViewById(R.id.edPass);
        resultado = (TextView)findViewById(R.id.txtResultado);
    }

    private SecretKeySpec generateKey(String password)throws Exception
    {
        MessageDigest sh = MessageDigest.getInstance("SHA-256");
        byte[] key = password.getBytes("UTF-8");
        key = sh.digest(key);

        SecretKeySpec secretKey = new SecretKeySpec(key, "AES");

        return secretKey;
    }

    public String encriptar(String datos, String password)throws Exception
    {
        if (!pass.getText().toString().isEmpty())
        {
            SecretKeySpec secretKey = generateKey(password);
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            byte[] datosEncriptadosbyte = cipher.doFinal(datos.getBytes());
            String datosEncriptadosString = Base64.encodeToString(datosEncriptadosbyte, Base64.DEFAULT);

            return datosEncriptadosString;
        }
        else
        {
            Toast.makeText(this, "Ingrese Contraseña", Toast.LENGTH_SHORT).show();
            return null;
        }
    }

    public void boton_encriptar(View view)
    {
        try {
            String mensaje = encriptar(pass.getText().toString(), resultado.getText().toString());
            resultado.setText(mensaje);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}