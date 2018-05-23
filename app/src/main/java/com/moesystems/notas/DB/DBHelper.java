package com.moesystems.notas.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.moesystems.notas.Data.Student;


public class DBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME ="db_students";
    public static final String TABLA_ESTUDIANTE ="Estudiante";
    public static final String CAMPO_ID="carnet";
    public static final String CAMPO_NOMBRE="name";
    public static final String CAMPO_NOTA="nota";
    public static final String CREAR_TABLA_ESTUDIANTE="CREATE TABLE "+TABLA_ESTUDIANTE +"("+CAMPO_ID+" TEXT,"+CAMPO_NOMBRE+" TEXT,"+CAMPO_NOTA+" TEXT)";

    public static DBHelper myDB = null;
    private Context context;
    SQLiteDatabase db;

    public DBHelper(Context context) {
        super(context,DB_NAME,null,1);
        this.context=context;
        db=this.getWritableDatabase();
    }
    public static DBHelper getInstance(Context context){
        if(myDB == null){
            myDB = new DBHelper(context.getApplicationContext());
        }
        return myDB;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREAR_TABLA_ESTUDIANTE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+CAMPO_NOMBRE);
        onCreate(db);
    }
    public boolean addStudent(Student s){
        ContentValues values = new ContentValues();
        values.put(CAMPO_ID,s.getCarne());
        values.put(CAMPO_NOMBRE,s.getName());
        db.insert(TABLA_ESTUDIANTE,null,values);
        Toast.makeText(context,"Insertado con exito",Toast.LENGTH_SHORT).show();
        return true;
    }

    public Student findStudent(String carne){
        Student s;
        String[] parametros = {carne};
        String[] campos = {CAMPO_NOMBRE,CAMPO_NOTA};

        try {
            Cursor cursor = db.query(TABLA_ESTUDIANTE,campos,CAMPO_ID+"=?"+CAMPO_NOTA+"=?",parametros,null,null,null);
            cursor.moveToFirst();
            s=new Student(carne,cursor.getString(0),cursor.getString(1));
        }catch (Exception e){
            s=null;

        }
        return s;
    }
    public boolean editStudent(Student s){
        String [] parametros = {s.getCarne()};
        String[] campos = {CAMPO_NOMBRE,CAMPO_NOTA};
        ContentValues values = new ContentValues();
        values.put(CAMPO_NOMBRE,s.getName());
        values.put(CAMPO_NOTA,s.getNota());
        db.update(TABLA_ESTUDIANTE,values,CAMPO_ID+"=?",parametros);
        Toast.makeText(context,"Estudiante actualizado",Toast.LENGTH_SHORT).show();
        return true;
    }
    public boolean deleteStudent(String carne){
        String[] parametros = {carne};
        db.delete(TABLA_ESTUDIANTE,CAMPO_ID+"=?",parametros);
        Toast.makeText(context,"Estudiante eliminado",Toast.LENGTH_SHORT).show();
        return true;
    }

}
