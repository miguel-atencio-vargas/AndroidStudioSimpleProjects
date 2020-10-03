package com.example.banderasdebolivia;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    private String depto;
    public int aciertos = 0, errores = 0;
    ImageView imgAleat;
    TextView result, scoreAciertos, scoreErrores, message;
    LinearLayout linearLay;
    Button playBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        imgAleat = (ImageView) findViewById(R.id.wImgAleat);
        result = (TextView) findViewById(R.id.wResult);
        message = (TextView) findViewById(R.id.wMessage);
        scoreAciertos = (TextView) findViewById(R.id.wAciertos);
        scoreErrores = (TextView) findViewById(R.id.wErrores);
        linearLay = (LinearLayout) findViewById(R.id.wButtons);
        playBtn = (Button) findViewById(R.id.wPlay);
    }
    public void  play(View v){
        linearLay.setVisibility(v.VISIBLE);
        playBtn.setVisibility(v.GONE);
        int aleatory = (int) (Math.random()*9 + 1);
        result.setText("¿De qué departamento es la siguiente bandera?");
        switch (aleatory){
            case 1: imgAleat.setImageResource(R.drawable.pando); depto = "pando"; break;
            case 2: imgAleat.setImageResource(R.drawable.oruro); depto = "oruro"; break;
            case 3: imgAleat.setImageResource(R.drawable.beni);  depto = "beni"; break;
            case 4: imgAleat.setImageResource(R.drawable.cocha); depto = "cocha"; break;
            case 5: imgAleat.setImageResource(R.drawable.sucre); depto = "sucre"; break;
            case 6: imgAleat.setImageResource(R.drawable.santa); depto = "santa"; break;
            case 7: imgAleat.setImageResource(R.drawable.tarija);depto = "tarija"; break;
            case 8: imgAleat.setImageResource(R.drawable.potosi);depto = "potosi"; break;
            case 9: imgAleat.setImageResource(R.drawable.lapaz); depto = "lapaz"; break;
        }
    }
    public void onClick(View v){
        switch (v.getId()){
            case R.id.wBeni: eval("beni", "Beni"); break;
            case R.id.wCbba: eval("cocha", "Cochabamba"); break;
            case R.id.wLpz:  eval("lapaz", "La Paz"); break;
            case R.id.wOruro:eval("oruro", "Oruro"); break;
            case R.id.wSucre:eval("sucre", "Sucre (Capital de Bolivia)"); break;
            case R.id.wSzc:  eval("santa", "Santa Cruz de la Sierra"); break;
            case R.id.wTrj:  eval("tarija", "Tarija"); break;
            case R.id.wPotosi:eval("potosi", "Potosí");break;
            case R.id.wPando: eval("pando", "Pando");break;
        }
        play(findViewById(R.id.wPlay));
    }
    @SuppressLint("SetTextI18n")
    public void eval(String _depto, String _depto_name){
        if(depto.equals(_depto)){
            message.setText("Correcto la bandera corresponde a "+ _depto_name);
            aciertos++;
            scoreAciertos.setText(String.valueOf(aciertos));
        }else{
            message.setText("Incorrecto, intenta nuevamente!");
            errores++;
            scoreErrores.setText(String.valueOf(errores));
        }
    }
}