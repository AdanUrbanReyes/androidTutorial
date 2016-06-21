package ayan.ventanas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Segunda extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        Button regresar=(Button)findViewById(R.id.regresar);
        regresar.setOnClickListener(this);
        TextView saludo=(TextView)findViewById(R.id.saludar);
        Bundle datosARecuperar=this.getIntent().getExtras();//se obtiene el tunel de datos
        saludo.setText("Hola "+datosARecuperar.getString("nombre")+" recuerda no te debes rendir carino :*");//se recupera el dato

    }

    @Override
    public void onClick(View view) {
        Intent mainActivity=new Intent(Segunda.this,MainActivity.class);
        startActivity(mainActivity);
    }
}
