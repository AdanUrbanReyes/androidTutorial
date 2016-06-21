package ayan.ventanas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText nombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button boton=(Button)findViewById(R.id.entrar);
        nombre=(EditText)findViewById(R.id.nombre);
        boton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        //una clase que intenta acer algo en este caso intenta lanazar una activiti
        Intent activitySegunda=new Intent(MainActivity.this,Segunda.class);
        //se crea el tunel de datos
        Bundle datosACompartir=new Bundle();
        datosACompartir.putString("nombre",nombre.getText().toString());//se pone el dato nombre
        activitySegunda.putExtras(datosACompartir);
        startActivity(activitySegunda);
    }
}
