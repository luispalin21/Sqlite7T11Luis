package mx.edu.tesoem.luisaguirre.itics.sqlite7t11;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.ref.SoftReference;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText et1, et2, et3, et4;
    GridView lv ;
    ArrayList<String> lista;
    ArrayAdapter adaptador;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (GridView) findViewById(R.id.lista);
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getApplicationContext(),"administracion",null,1);
        lista = admin.llenar_v();
        adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1,lista);
        lv.setAdapter(adaptador);



        et1 = (EditText) findViewById(R.id.editText1); et2 = (EditText) findViewById(R.id.editText2);
        et3 = (EditText) findViewById(R.id.editText3); et4 = (EditText) findViewById(R.id.editText4);


        lv = (GridView) findViewById(R.id.lista);
        final TextView editText1 = (EditText) findViewById(R.id.editText1);










        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String selectedItem = parent.getItemAtPosition(position).toString();


                editText1.setText(selectedItem);
            }
        });















    }


    public void consulta(View v) {

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,

                "administracion", null, 1);

        SQLiteDatabase bd = admin.getWritableDatabase();

        String dni = et1.getText().toString();

        Cursor fila = bd.rawQuery(

                "select nombre, ciudad, numero from usuario where dni=" + dni, null);

        if (fila.moveToFirst()) {

            et2.setText(fila.getString(0));
            et3.setText(fila.getString(1));
            et4.setText(fila.getString(2));



        } else


            Toast.makeText(this, "No existe ningún usuario con ese ID",

                    Toast.LENGTH_SHORT).show();

        bd.close();

    }
















    public void btneliminar(View v){
        Intent intent = new Intent(this,eliminar.class);
        startActivity(intent);
        this.finish();
    }
    public void btnregistra(View v){
        Intent intent = new Intent(this,registrar.class);
        startActivity(intent);
        this.finish();
    }
    public void btnactualiza(View v){
        Intent intent = new Intent(this,actualizar.class);
        startActivity(intent);
        this.finish();
    }






}

