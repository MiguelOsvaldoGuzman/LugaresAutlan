package android.miguelogp.miprimeraapp.lugaresautlan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout hamburguesa, tacos, pizza, restaurant, hotdog, antojitos;
    Intent intent = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hamburguesa= (LinearLayout) findViewById(R.id.hamburguesa);
        tacos = (LinearLayout) findViewById(R.id.tacos);
        pizza = (LinearLayout) findViewById(R.id.pizza);
        hotdog = (LinearLayout) findViewById(R.id.hotdog);
        antojitos = (LinearLayout) findViewById(R.id.antojitos);
        restaurant = (LinearLayout) findViewById(R.id.restaurant);

        hamburguesa.setOnClickListener(this);
        tacos.setOnClickListener(this);
        pizza.setOnClickListener(this);
        hotdog.setOnClickListener(this);
        antojitos.setOnClickListener(this);
        restaurant.setOnClickListener(this);
    }

    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.pizza:
               intent = new Intent(MainActivity.this,MapsActivity.class);
                break;
            case R.id.hamburguesa:
                break;
            case R.id.tacos:
                break;
            case R.id.antojitos:
                break;
            case  R.id.hotdog:
                break;
            case R.id.restaurant:


        }
        startActivity(intent);
    }

}
