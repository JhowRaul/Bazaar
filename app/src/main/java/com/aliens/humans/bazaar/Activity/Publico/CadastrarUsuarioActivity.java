package com.aliens.humans.bazaar.Activity.Publico;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.aliens.humans.bazaar.R;

public class CadastrarUsuarioActivity extends AppCompatActivity implements View.OnClickListener {

    UsuarioViewModel usuarioViewModel;
    UsuarioViewHolder usuarioViewHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_usuario);

        usuarioViewHolder = new UsuarioViewHolder(findViewById(R.id.activity_cadastrar_usuario));
        usuarioViewHolder.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnSalvarUsuario) {
            Usuario usuario = new Usuario();
            usuario.setNome(usuarioViewHolder.getTextFromEditNome());
            // set atributos da classe UsuarioViewHolder


            long resul = usuarioViewModel.insert(usuario);
            if(result > 0) {
                Toast.makeText(this, "Usuário Cadastrado!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(CadastrarUsuarioActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(this, "Usuário não Cadastrado.", Toast.LENGTH_SHORT).show();
            }
        }
    }

}
