package com.example.trabalho_dreco;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextPalavra;
    private EditText editTextCaractere;
    private Button buttonCalcular;
    private Button buttonLimpar;
    private Button buttonEncerrar;
    private TextView textViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextPalavra = findViewById(R.id.editTextPalavra);
        editTextCaractere = findViewById(R.id.editTextCaractere);
        buttonCalcular = findViewById(R.id.buttonCalcular);
        buttonLimpar = findViewById(R.id.buttonLimpar);
        buttonEncerrar = findViewById(R.id.buttonEncerrar);
        textViewResultado = findViewById(R.id.textViewResultado);

        setTitle("Trabalho Matheus");

        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fecharTeclado();

                String palavra = editTextPalavra.getText().toString().trim();
                String caractere = editTextCaractere.getText().toString().trim();

                if (palavra.isEmpty() || caractere.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Digite uma palavra e um caractere", Toast.LENGTH_SHORT).show();
                } else {
                    int contador = contarCaractere(palavra, caractere);
                    textViewResultado.setText("A palavra '" + palavra + "' tem " + contador + " ocorrências do caractere '" + caractere + "'");
                }
            }
        });

        buttonLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextPalavra.setText("");
                editTextCaractere.setText("");
                textViewResultado.setText("");
            }
        });

        buttonEncerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private int contarCaractere(String palavra, String caractere) {
        int contador = 0;
        for (int i = 0; i < palavra.length(); i++) {
            if (palavra.charAt(i) == caractere.charAt(0)) {
                contador++;
            }
        }
        return contador;
    }

    private void fecharTeclado() {
        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        View view = getCurrentFocus();
        if (view != null) {
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}