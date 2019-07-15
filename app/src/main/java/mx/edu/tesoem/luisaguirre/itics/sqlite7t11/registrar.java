package mx.edu.tesoem.luisaguirre.itics.sqlite7t11;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class registrar extends AppCompatActivity {

    private EditText et1, et2, et3, et4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);


        et1 = (EditText) findViewById(R.id.editText1); et2 = (EditText) findViewById(R.id.editText2);
        et3 = (EditText) findViewById(R.id.editText3); et4 = (EditText) findViewById(R.id.editText4);
    }

    public void alta(View v) {

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,

                "administracion", null, 1);

        SQLiteDatabase bd = admin.getWritableDatabase();

        String dni = et1.getText().toString();
        String nombre = et2.getText().toString();
        String ciudad = et3.getText().toString();
        String numero = et4.getText().toString();

        ContentValues registro = new ContentValues();

        registro.put("dni", dni);
        registro.put("nombre", nombre);
        registro.put("ciudad", ciudad);
        registro.put("numero", numero);


        bd.insert("usuario", null, registro);

        bd.close();


        et1.setText(""); et2.setText(""); et3.setText(""); et4.setText("");

        Toast.makeText(this, "Datos del usuario registrados con exito", Toast.LENGTH_SHORT).show();

    }



    public void btncancelar(View v){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        this.finish();
    }

}
