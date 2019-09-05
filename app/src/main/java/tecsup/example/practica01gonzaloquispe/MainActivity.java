package tecsup.example.practica01gonzaloquispe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Vector;

public class MainActivity extends AppCompatActivity {

    /* CREANDO OBJETOS PARA LOS BOTONES
     */
    Button bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9,bt0;
    Button bt_suma,bt_resta,bt_multiplicacion,bt_division;

    Button bt_ac,bt_c,bt_cambiarSigno;

    Button bt_punto,bt_igual;

    EditText et_num;

    /*
    CREANDO OTRAS VARIABLES PARA QUE LA CALCULADORA FUNCIONE
     */

    String numPantalla;


    double num1=0;
    double num2=0;
    String operacion_anterior;
    boolean operacion_concatenada=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numPantalla="";

        /*
        ENLAZANDO OBJETOS JAVA DE A LOS OBJETOS DEL XML.
         */

        bt0 = findViewById(R.id.bt0);
        bt1 = findViewById(R.id.bt1);
        bt2 = findViewById(R.id.bt2);
        bt3 = findViewById(R.id.bt3);
        bt4 = findViewById(R.id.bt4);
        bt5 = findViewById(R.id.bt5);
        bt6 = findViewById(R.id.bt6);
        bt7 = findViewById(R.id.bt7);
        bt8 = findViewById(R.id.bt8);
        bt9 = findViewById(R.id.bt9);


        bt_suma=findViewById(R.id.bt_suma);
        bt_resta=findViewById(R.id.bt_resta);
        bt_multiplicacion=findViewById(R.id.bt_multiplicacion);
        bt_division=findViewById(R.id.bt_division);


        et_num=findViewById(R.id.et_num);



        bt_ac=findViewById(R.id.bt_ac);
        bt_c=findViewById(R.id.bt_c);
        bt_cambiarSigno=findViewById(R.id.bt_cambiarSigno);


        bt_punto=findViewById(R.id.bt_punto);
        bt_igual=findViewById(R.id.bt_igual);

        /*
        LISTENERS:
         */

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                anadirNumero(1);
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                anadirNumero(2);
            }
        });


        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                anadirNumero(3);
            }
        });


        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                anadirNumero(4);
            }
        });




        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                anadirNumero(5);
            }
        });


        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                anadirNumero(6);
            }
        });


        bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                anadirNumero(7);
            }
        });


        bt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                anadirNumero(8);
            }
        });

        bt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                anadirNumero(9);
            }
        });


        bt0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                anadirNumero(0);
            }
        });


        bt_punto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        bt_ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AC("completo");
            }
        });

        bt_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                C();
            }
        });


        bt_suma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                suma();
            }
        });


        bt_resta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resta();
            }
        });


        bt_igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                igual();
            }
        });

        bt_multiplicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                multiplicacion();
            }
        });

        bt_division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                division();
            }
        });

    }


    /*
    FUNCIONES PARA LA CALCULADORA
     */


    private void anadirNumero(int num){
        et_num.setText("");
        if(numPantalla.length()>=1 && numPantalla.substring(0,1).equals("0")  ){
            numPantalla=numPantalla.substring(1);

        }

        /*
        IF EN CASO DE QUE NUMTOTAL SEA 0.
         */
        if(numPantalla.equals("0")) et_num.setText("");
        numPantalla+=num;
        et_num.setText(numPantalla);
    }


    private void AC(String tipo){
        if(tipo=="completo") {
            if (numPantalla == "0") et_num.setText("");
            numPantalla = "0";
            et_num.setText("0");
            num1 = 0;
            num2 = 0;
        }else if(tipo=="sinNums"){
            numPantalla="0";
            et_num.setText("0");
        }




    }

    private void borrarPantalla(){


        et_num.setText("");
    }

    private void C(){
        //if(numTotal=="0") et_num.setText("");
        if(numPantalla!="0") {
            if (numPantalla.length() >= 1) {
                numPantalla = numPantalla.substring(0, numPantalla.length() - 1);
                et_num.setText(numPantalla);
            } else if (numPantalla.length() == 0 || numPantalla.length() == 1) et_num.setText("0");
        }
    }





    private void suma(){

        if(operacion_concatenada) igual();
        num1 = Double.parseDouble(numPantalla);
        AC("sinNums");
        if(!operacion_concatenada) et_num.setText(""+ num1);
        operacion_anterior = "suma";
        operacion_concatenada = true;



    }

    private void resta(){
        if(operacion_concatenada==true) igual();
        num1 = Double.parseDouble(numPantalla);
        AC("sinNums");
        if(!operacion_concatenada) et_num.setText(""+ num1);
        operacion_anterior="resta";
        operacion_concatenada=true;
    }

    private void multiplicacion(){
        if(operacion_concatenada==true) igual();
        num1 = Double.parseDouble(numPantalla);
        AC("sinNums");
        if(!operacion_concatenada) et_num.setText(""+ num1);
        operacion_anterior="multiplicacion";
        operacion_concatenada=true;
    }


    private void division(){
        if(operacion_concatenada==true) igual();
        num1 = Double.parseDouble(numPantalla);
        AC("sinNums");
        if(!operacion_concatenada) et_num.setText(""+ num1);
        operacion_anterior="division";
        operacion_concatenada=true;
    }


    private void modulo(){
        if(operacion_concatenada==true) igual();
        num1 = Double.parseDouble(numPantalla);
        AC("sinNums");
        if(!operacion_concatenada) et_num.setText(""+ num1);
        operacion_anterior="modulo";
        operacion_concatenada=true;
    }

    private void igual(){
        if(operacion_anterior=="suma") {
            num2 = Double.parseDouble(numPantalla);
            numPantalla = "" + (num1 + num2);

        }else if(operacion_anterior=="resta"){
            num2 = Double.parseDouble(numPantalla);
            numPantalla = "" + (num1 - num2);

        }else if(operacion_anterior=="multiplicacion"){
            num2 = Double.parseDouble(numPantalla);
            numPantalla = "" + (num1 * num2);
        }else if(operacion_anterior=="division"){
            num2 = Double.parseDouble(numPantalla);
            numPantalla = "" + (num1 / num2);
        }else if(operacion_anterior=="modulo"){
            num2 = Double.parseDouble(numPantalla);
            numPantalla = "" + (num1 % num2);
        }

        /*
        switch (operacion_anterior) {
            case "suma":


        }
        */

        num1 = 0;
        num2 = 0;
        operacion_concatenada=false;
        et_num.setText(numPantalla);
    }

}
