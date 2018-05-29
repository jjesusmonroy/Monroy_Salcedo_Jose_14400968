package com.example.jjesusmonroy.laboratorio7feb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    int contador;
    Button unouno,unodos,unotres,dosuno,dosdos,dostres,tresuno,tresdos,trestres,reset;
    TextView resultado;
    Boolean banderauno,banderados,banderatres,banderacuatro,banderacinco,banderaseis,banderasiete,banderaocho,banderanueve;
    int [] validar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        validar = new int [9];
        contador=0;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultado=findViewById(R.id.mensaje);
        desactivarBanderas();
        unouno=findViewById(R.id.unouno);
        unodos=findViewById(R.id.unodos);
        unotres=findViewById(R.id.unotres);
        dosuno=findViewById(R.id.dosuno);
        dosdos=findViewById(R.id.dosdos);
        dostres=findViewById(R.id.dostres);
        tresuno=findViewById(R.id.tresuno);
        tresdos=findViewById(R.id.tresdos );
        trestres=findViewById(R.id.trestres);
        reset=findViewById(R.id.reset);

        unouno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!banderauno){
                    if(contador%2==0){
                        unouno.setText("X");
                        validar[contador]=11;
                    }
                    else {
                        unouno.setText("O");
                        validar[contador]=12;
                    }
                    contador++;
                    banderauno=true;
                    if(contador>8){validar();}
                }
            }
        });
        unodos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!banderados){
                    if(contador%2==0){
                        unodos.setText("X");
                        validar[contador]=21;
                    }
                    else {
                        unodos.setText("O");
                        validar[contador]=22;
                    }
                    contador++;
                    banderados=true;
                    if(contador>8){validar();}
                }
            }
        });
        unotres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!banderatres){
                    if(contador%2==0){
                        unotres.setText("X");
                        validar[contador]=31;
                    }
                    else {
                        unotres.setText("O");
                        validar[contador]=32;
                    }
                    contador++;
                    banderatres=true;
                    if(contador>8){validar();}
                }
            }
        });
        dosuno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!banderacuatro){
                    if(contador%2==0){
                        dosuno.setText("X");
                        validar[contador]=41;
                    }
                    else {
                        dosuno.setText("O");
                        validar[contador]=42;
                    }
                    contador++;
                    banderacuatro=true;
                    if(contador>8){validar();}
                }
            }
        });
        dosdos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!banderacinco){
                    if(contador%2==0){
                        dosdos.setText("X");
                        validar[contador]=51;
                    }
                    else {
                        dosdos.setText("O");
                        validar[contador]=52;
                    }
                    contador++;
                    banderacinco=true;
                    if(contador>8){validar();}
                }
            }
        });
        dostres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!banderaseis){
                    if(contador%2==0){
                        dostres.setText("X");
                        validar[contador]=61;
                    }
                    else {
                        dostres.setText("O");
                        validar[contador]=62;
                    }
                    contador++;
                    banderaseis=true;
                    if(contador>8){validar();}
                }
            }
        });
        tresuno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!banderasiete){
                    if(contador%2==0){
                        tresuno.setText("X");
                        validar[contador]=71;
                    }
                    else {
                        tresuno.setText("O");
                        validar[contador]=72;
                    }
                    contador++;
                    banderasiete=true;
                    if(contador>8){validar();}
                }
            }
        });
        tresdos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!banderaocho){
                    if(contador%2==0){
                        tresdos.setText("X");
                        validar[contador]=81;
                    }
                    else {
                        tresdos.setText("O");
                        validar[contador]=82;
                    }
                    contador++;
                    banderaocho=true;
                    if(contador>8){validar();}
                }
            }
        });
        trestres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!banderanueve){
                    if(contador%2==0){
                        trestres.setText("X");
                        validar[contador]=91;
                    }
                    else {
                        trestres.setText("O");
                        validar[contador]=92;
                    }
                    contador++;
                    banderanueve=true;
                    if(contador>8){validar();}
                }
            }
        });
    }

    private void validar(){
        Arrays.sort(validar);
        for(int i=0;i<validar.length;i++){
            if(validar[i]==11 && validar[i+1]==21 && validar[i+2]==31){
                resultado.setText("Gano x");
            }
            if(validar[i]==12 && validar[i+1]==22 && validar[i+2]==32){
                resultado.setText("Gano o");
            }

        }
    }
    private void desactivarBanderas(){
        banderauno=false;
        banderados=false;
        banderatres=false;
        banderacuatro=false;
        banderacinco=false;
        banderaseis=false;
        banderasiete=false;
        banderaocho=false;
        banderanueve=false;
    }
}
