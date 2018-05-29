package com.example.jjesusmonroy.moviles8febrero;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button generar;
    EditText caja;
    TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generar=findViewById(R.id.generar);
        caja=findViewById(R.id.edittext);
        resultado=findViewById(R.id.resultado);

        generar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultado.setText("");
                int numero= Integer.parseInt(caja.getText().toString());
                String  cad="";
                for(int i=1;i<11;i++){
                    cad+=numero+"x"+i+" = "+numero*i+"\n";
                }
                resultado.setText(cad);
            }
        });
    }
}
