package com.aliens.humans.bazaar.Activity.Publico;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.aliens.humans.bazaar.Activity.Usuario.MainActivity;

public class LoginActivity extends Activity {

    private EditText editLogin;
    private EditText editSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editLogin = (EditText) findViewById(R.id.editLoginUsuario);
        editSenha = (EditText) findViewById(R.id.editSenhaUsuario);
    }

    public void logarUsuario(View v) {
        String email = editLogin.getText().toString();
        String senha = editSenha.getText().toString();

        UsuarioDAO usuarioDAO = new UsuarioDAO(this);
        long usuarioId = usuarioDAO.loginUsuario(email,Util.toMD5(senha));
        if(usuarioId > 0){
            Toast.makeText(this, "Usuário logado com Sucesso!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginActivity.this,MainActivity.class);
            intent.putExtra("USUARIO_ID", usuarioId);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "Usuário não Cadastrado.", Toast.LENGTH_SHORT).show();
        }
    }

    public void registrarUsuario(View v) {
        Intent intent = new Intent(LoginActivity.this, CadastrarUsuarioActivity.class);
        startActivity(intent);
    }
}
