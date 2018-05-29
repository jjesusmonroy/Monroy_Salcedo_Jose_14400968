package com.example.betsysanchez.juegopulsor;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity {
    TextView t, tizq, tcen, tder;
    Button inicio, detener,facil,normal,rude;
    Timer timer;
    TimerTask timerTask;
    double contador;
    Boolean bandera;
    int velocidad;

    final Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        velocidad=750;
        facil=findViewById(R.id.facil);
        normal=findViewById(R.id.normal);
        rude=findViewById(R.id.RUDE);
        normal.setTextColor(Color.parseColor("#ffffff"));
        facil.setTextColor(Color.parseColor("#ffffff"));
        rude.setTextColor(Color.parseColor("#ffffff"));
        bandera=false;
        t = findViewById(R.id.numAleat);
        detener = findViewById(R.id.button2);
        tizq = findViewById(R.id.tizq);
        tcen = findViewById(R.id.tcen);
        tder = findViewById(R.id.tder);
        contador = 0;
        t.setText(random()+"");

        facil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                velocidad=750;
                stoptimertask(view);
                startTimer();
                facil.setTextColor(Color.parseColor("#33b5e5"));
                normal.setTextColor(Color.parseColor("#ffffff"));
                rude.setTextColor(Color.parseColor("#ffffff"));
            }
        });

        normal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                velocidad=500;
                stoptimertask(view);
                startTimer();
                normal.setTextColor(Color.parseColor("#33b5e5"));
                facil.setTextColor(Color.parseColor("#ffffff"));
                rude.setTextColor(Color.parseColor("#ffffff"));
            }
        });

        rude.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                velocidad=150;
                stoptimertask(view);
                startTimer();
                rude.setTextColor(Color.parseColor("#33b5e5"));
                normal.setTextColor(Color.parseColor("#ffffff"));
                facil.setTextColor(Color.parseColor("#ffffff"));
            }
        });
        detener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stoptimertask(view);
                if(bandera==false){
                    bandera=true;
                    detener.setText("INICIAR");
                    Double a = Double.parseDouble(tcen.getText().toString());
                    Double b = Double.parseDouble(t.getText().toString());
                    if(a.compareTo(b)==0){
                        Context context = getApplicationContext();
                        CharSequence text = "Ganaste!";
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    }
                    else {
                        Context context = getApplicationContext();
                        CharSequence text = "Perdiste!";
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    }
                }
                else {
                    bandera=false;
                    detener.setText("DETENER");
                    t.setText(random()+"");
                    startTimer();
                }
            }
        });
    }
    private Double random(){
        Random r = new Random();
        return 0.0 + (3.0 - 0.0) * r.nextDouble();
    }

    @Override
    protected void onResume() {
        super.onResume();
        startTimer();
    }

    public void startTimer() {
        timer = new Timer();

        initializeTimerTask();

        timer.schedule(timerTask, 0, velocidad);
    }

    public void stoptimertask(View v) {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }

    public void initializeTimerTask() {
        timerTask = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        if (contador == 0.0) {
                            tizq.setText("3.0");
                            tcen.setText("0.0");
                            tder.setText("0.1");
                            contador+=1.0;
                            return;
                        }
                        if (contador == 30.0) {
                            tizq.setText("2.9");
                            tcen.setText("3.0");
                            tder.setText("0.0");
                            contador = 0.0;
                            return;
                        }
                        tizq.setText((contador/10)-.1+"");
                        tcen.setText(contador/10+"");
                        tder.setText((contador/10)+.1+"");
                        contador+=1.0;
                    }
                });
            }

        };
    }
}
