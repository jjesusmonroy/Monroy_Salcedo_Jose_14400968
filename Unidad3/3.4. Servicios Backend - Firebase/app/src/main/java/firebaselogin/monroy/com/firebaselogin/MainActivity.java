package firebaselogin.monroy.com.firebaselogin;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText email,password;
    private TextView register;
    private Button login;
    private boolean flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        config();
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag=!flag;
                if(flag){config();}
                Toast.makeText(MainActivity.this, "Fill out your data to continue", Toast.LENGTH_SHORT).show();
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flag){
                    newUser(email.getText().toString(),password.getText().toString());
                    flag=!flag;
                    clean();
                }
                else {
                    login(email.getText().toString(),password.getText().toString());
                }
            }
        });
    }
    private void init(){
        mAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        register = findViewById(R.id.register);
        login = findViewById(R.id.login);
        flag = false;
    }
    private void config(){
        if(flag)login.setText("Create account");
        else login.setText("Login");
    }

    private void clean(){
        config();
        email.setText("");
        password.setText("");
    }

    @Override
    protected void onStart() {
        super.onStart();
        clean();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        clean();
    }


    private void newUser(String email, String password){
        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Log.i("SESION","Sesion creada correctamente");
                    Toast.makeText(MainActivity.this, "Account created", Toast.LENGTH_SHORT).show();
                }else{
                    Log.e("SESION",task.getException().getMessage()+"");
                    Toast.makeText(MainActivity.this, "Email or password not valid, or already in use", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void login(String email,String password){
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Intent i=new Intent(getApplicationContext(), AlumnoAdder.class);
                    startActivity(i);
                }else{
                    Log.e("SESION",task.getException().getMessage()+"");
                    Toast.makeText(MainActivity.this, "Failed to log in", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}


