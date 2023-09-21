package com.example.matheus1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btncalcular=(Button)this.findViewById(R.id.btncalcular);
        Button btnLimpar = (Button)this.findViewById(R.id.btnLimpar);
        EditText editResposta=(EditText)(findViewById(R.id.editResposta));
        TextView txtCarac=(TextView)(findViewById(R.id.txtCarac));
        TextView txtCabacalho=(TextView)(findViewById(R.id.txtCabecalho));
        TextView txtresposta=(TextView)(findViewById(R.id.txtresposta));
        TextView txtletraA=(TextView)(findViewById(R.id.txtletraA));
        Button btncalca=(Button)this.findViewById(R.id.btncalca);


        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editResposta.setText("");
                txtresposta.setText("");
            }
        });

        btncalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String texto = editResposta.getText().toString();
                int tamanho = texto.length();
                txtresposta.setText(String.valueOf(tamanho).toString());
            }
        });

        btncalca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String texto = editResposta.getText().toString().toLowerCase();
                int count = 0;
                for (int i = 0; i<texto.length(); i++){
                    if (texto.charAt(i) == 'a') {
                        count++;
                    }
                }

            }
        });


    }
}
