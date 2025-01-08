package com.kauadt.appjokenpo;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void selecionarPedra(View view){
        verificarGanhador("pedra");
    }

    public void selecionarPapel(View view){
        verificarGanhador("papel");
    }

    public void selecionarTesoura(View view){
        verificarGanhador("tesoura");
    }

    private String gerarEscolhaAleatoriaApp() {
        String[] opcoes =  {"pedra", "papel", "tesoura"};
        int numeroAleatorio = new Random().nextInt(3);

        String escolhaApp = opcoes[numeroAleatorio];

        ImageView imageApp = findViewById(R.id.img_app);

        switch (escolhaApp){
            case "pedra":
                imageApp.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imageApp.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imageApp.setImageResource(R.drawable.papel);
                break;
            default:
                System.out.println("Ops! Selecione uma opção válida");
                break;
        }

        return escolhaApp;
    }

    private void verificarGanhador(String escolhaUsuario){
        String escolhaApp = gerarEscolhaAleatoriaApp();
        TextView textoResultado = findViewById(R.id.text_resultado);

        if(
                escolhaApp == "pedra" && escolhaUsuario == "tesoura" ||
                escolhaApp == "papel" && escolhaUsuario == "pedra" ||
                escolhaApp == "tesoura" && escolhaUsuario == "papel"
        ){

            textoResultado.setText("Você perdeu :(");
            textoResultado.setVisibility(View.VISIBLE);


        } else if(
                escolhaUsuario == "pedra" && escolhaApp == "tesoura" ||
                escolhaUsuario == "papel" && escolhaApp == "pedra" ||
                escolhaUsuario == "tesoura" && escolhaApp == "papel"

        ){
            textoResultado.setText("Você venceu :)");
            textoResultado.setVisibility(View.VISIBLE);

        } else {
            textoResultado.setText("Empate");
            textoResultado.setVisibility(View.VISIBLE);
        }

    }

}