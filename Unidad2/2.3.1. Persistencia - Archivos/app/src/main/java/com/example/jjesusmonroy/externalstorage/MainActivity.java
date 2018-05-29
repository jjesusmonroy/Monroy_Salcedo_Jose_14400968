package com.example.jjesusmonroy.externalstorage;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    Button save,load;
    EditText text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save();
            }
        });
        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                load();
            }
        });

    }
    private void save(){
        String text = this.text.getText().toString();
        try {
            File path = Environment.getExternalStorageDirectory();
            File f = new File(path.getAbsolutePath(), "save.txt");
            Log.d("ruta",""+path.getAbsolutePath());
            OutputStreamWriter sfile = new OutputStreamWriter(
                            new FileOutputStream(f));
            sfile.write(text);
            sfile.close();
            Toast.makeText(getBaseContext(), "saved succesfully", Toast.LENGTH_SHORT).show();
        }
        catch (Exception ex) {
            Toast.makeText(getBaseContext(), "not saved succesfully"+ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
    private void load(){
        try {
            File path = Environment.getExternalStorageDirectory();

            File file = new File(path.getAbsolutePath(), "save.txt");

            BufferedReader rfile = new BufferedReader(new InputStreamReader(
                    new FileInputStream(file)));
            String texto = rfile.readLine();
            text.setText(texto);
            rfile.close();
        }
        catch (Exception ex) {
            Toast.makeText(getBaseContext(), "File couldnt get loaded", Toast.LENGTH_SHORT).show();
        }
    }

    private void init(){
        text = findViewById(R.id.text);
        save=findViewById(R.id.save);
        load=findViewById(R.id.load);
    }

}
