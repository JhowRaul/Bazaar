package com.aliens.humans.bazaar.Activity.Usuario;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.aliens.humans.bazaar.Activity.Publico.LoginActivity;
import com.aliens.humans.bazaar.R;
import com.facebook.stetho.Stetho;

public class MainActivity extends Activity {

    private static Usuario usuarioLogado;
    private TextView textWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Stetho.initializeWithDefaults(this);

        // Elementos da view
        textWelcome = (TextView) findViewById(R.id.textWelcome);


        Intent resultado = getIntent();
        long id = resultado.getLongExtra("USUARIO_ID", 0);
        if(usuarioLogado == null)
            usuarioLogado = new UsuarioDAO(this).buscarUsuarioPorID(id);

        textWelcome.setText("Olá! " + usuarioLogado.getNome());
    }

    public void carregaItemMenu(View v) {
        switch (v.getId()){
            case R.id.btnEditarPerfil:
                carregarIntent(EditarPerfilActivity.class);
                break;
            case R.id.btnUpgradePerfil:
                carregarIntent(UpgradePerfilActivity.class);
                break;
            case R.id.btnBuscarPaginas:
                carregarIntent(BuscarPaginasPorCategoria.class);
                break;
        }
    }

    public void deslogar(View v) {
        usuarioLogado = null;
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    public void carregarIntent(Class classe) {
        Intent intent = new Intent(MainActivity.this, classe);
        startActivity(intent);
    }
}
