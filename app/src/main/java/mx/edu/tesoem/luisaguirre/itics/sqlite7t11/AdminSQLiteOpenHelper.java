package mx.edu.tesoem.luisaguirre.itics.sqlite7t11;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

    public AdminSQLiteOpenHelper(Context context, String nombre, SQLiteDatabase.CursorFactory factory, int version) {

        super(context, nombre, factory, version);

    }

    @Override

    public void onCreate(SQLiteDatabase db) {


        db.execSQL("create table usuario(dni integer primary key, nombre text, ciudad text, numero integer)");

    }

    @Override

    public void onUpgrade(SQLiteDatabase db, int version1, int version2) {

        db.execSQL("drop table if exists usuario");

        db.execSQL("create table usuario(dni integer primary key, nombre text, ciudad text, numero integer)");

    }

    public ArrayList llenar_v(){
        ArrayList<String> lista = new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();
        String q = "SELECT * FROM usuario";
        Cursor registros = database.rawQuery(q,null);
        if(registros.moveToFirst()){
            do{
                lista.add(registros.getString(0));
                lista.add(registros.getString(1));
                lista.add(registros.getString(2));
                lista.add(registros.getString(3));

            }while(registros.moveToNext());
        }
        return lista;

    }



}