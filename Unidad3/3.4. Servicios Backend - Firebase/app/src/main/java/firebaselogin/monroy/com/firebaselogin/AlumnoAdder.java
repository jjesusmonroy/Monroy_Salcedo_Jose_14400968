package firebaselogin.monroy.com.firebaselogin;

import android.content.DialogInterface;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class AlumnoAdder extends AppCompatActivity {

    EditText name,nocontrol;
    FloatingActionButton add;
    Button logout;
    FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumno_adder);
        init();
        final DatabaseReference databaseReference= firebaseDatabase.getReference(References.tutoPreference);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Alumno alumno = new Alumno(name.getText().toString(),nocontrol.getText().toString());
                databaseReference.push().setValue(alumno);
                clean();
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Warning")
                .setMessage("You are about to log out, are you sure you want to continue?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        FirebaseAuth.getInstance().signOut();
                        finish();
                    }

                })
                .setNegativeButton("No", null)
                .show();
    }

    private void init(){
        name=findViewById(R.id.name);
        nocontrol=findViewById(R.id.nocontrol);
        add=findViewById(R.id.addAlumno);
        logout=findViewById(R.id.logout);
        firebaseDatabase=FirebaseDatabase.getInstance();
    }
    private void clean(){
        name.setText("");
        nocontrol.setText("");
    }
}
