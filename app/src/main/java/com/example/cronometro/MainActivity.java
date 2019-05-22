package com.example.cronometro;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText horas;
    EditText minutos;
    EditText segundos;
    public long seg;

    Button empezar;
    Button detener;

    CountDownTimer cronometro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        horas= findViewById(R.id.txthoras);
        minutos = findViewById(R.id.txtminutos);
        segundos = findViewById(R.id.txtsegundos);
        empezar = findViewById(R.id.button);
        detener = findViewById(R.id.button2);
        empezar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int n = Integer.valueOf(minutos.getText().toString());
                seg = n*60*1000;
                cronometro = new CountDownTimer(seg,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        seg = millisUntilFinished;

                        int minutes =(int)millisUntilFinished/6000;
                        int seconds = (int)(millisUntilFinished%6000)/1000;

                        horas.setText(minutes);
                        segundos.setText(seconds);



                    }

                    @Override
                    public void onFinish() {
                        Toast.makeText(getApplicationContext(),"Finalozado",Toast.LENGTH_SHORT).show();

                    }
                }.start();
            }
        });


    }
}
