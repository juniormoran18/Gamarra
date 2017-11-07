package com.example.junior.gamarra_app.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.junior.gamarra_app.R;
import com.example.junior.gamarra_app.model.User;
import com.example.junior.gamarra_app.repository.Usuario;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText user;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = (EditText) findViewById(R.id.userTxt);
        password = (EditText) findViewById(R.id.passTxt);

    }

    public void login(View view){

        String usua = user.getText().toString();
        String contraseña = password.getText().toString();

        if(usua.isEmpty() || contraseña.isEmpty()){
            Toast.makeText(this,"Faltan completar campos", Toast.LENGTH_SHORT).show();
        }else{
            Usuario usuario = Usuario.getInstance();
            List<User> usuarios = usuario.getUsers();
            boolean check = true;

            for (final User usuarioCreado : usuarios){
                if (usua.equals(usuarioCreado.getCorreo()) && contraseña.equals(usuarioCreado.getPassword())){
                    check = true;
                    Intent i = new Intent(MainActivity.this, MenuActivity.class);
                    String tipo = usuarioCreado.getTipo();
                    i.putExtra("Ingresado",tipo);
                    startActivity(i);
                    break;
                }else {
                    check = false;
                }
            }
            if(!check){
                Toast.makeText(this, "error:datos incorrectos ", Toast.LENGTH_SHORT).show();
            }
        }

    }

}
