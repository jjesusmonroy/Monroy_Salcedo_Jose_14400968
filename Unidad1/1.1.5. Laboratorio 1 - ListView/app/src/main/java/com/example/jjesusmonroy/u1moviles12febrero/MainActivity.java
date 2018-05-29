package com.example.jjesusmonroy.u1moviles12febrero;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    SeekBar seekBar;
    TextView progress;
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.seekBar=findViewById(R.id.seekbar);
        this.progress=findViewById(R.id.progress);
        this.listview=findViewById(R.id.listview);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int val = (i * (seekBar.getWidth() - 2 * seekBar.getThumbOffset())) / seekBar.getMax();
                progress.setText("" + i);
                progress.setX(seekBar.getX() + val + seekBar.getThumbOffset() / 2);
                population(i,null);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
    private void population(int a,View v){
        ArrayList<String> arreglo = new ArrayList<String>();
        for(int i=1;i<31;i++){
            arreglo.add(a+"x"+i+" = "+a*i);
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arreglo);
        listview.setAdapter(arrayAdapter);
    }
}
