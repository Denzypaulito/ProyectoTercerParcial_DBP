package mx.uach.fing.proyectotercerparcial_dbp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnDenzel = (Button)findViewById(R.id.CurriculumDenzel);
        btnDenzel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),CurriculumDenzel.class);
                startActivity(i);
            }
        });
        Button btnJuan = (Button)findViewById(R.id.CurriculumJuan);
        btnJuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),CurriculumJuan.class);
                startActivity(i);
            }
        });
        Button btnJessica = (Button)findViewById(R.id.CurriculumJessica);
        btnJessica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),CurriculumJessica.class);
                startActivity(i);
            }
        });
    }
    @Override
    public void onBackPressed() {
        if (!(this instanceof MainActivity)) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            super.onBackPressed();
        }
    }
}