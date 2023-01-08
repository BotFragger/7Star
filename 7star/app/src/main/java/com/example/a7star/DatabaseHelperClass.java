package com.example.a7star;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

    public class DatabaseHelperClass extends SQLiteOpenHelper {

        //Database version
        private static final int DATABASE_VERSION = 1;
        //Database Name
        private static final String DATABASE_NAME = "7star";
        //Database Table name
        private static final String TABLE_NAME = "passwordtb";
        //Table columns
        public static final String ID = "id";
        public static final String EMAIL = "email";
        public static final String PASSWORD = "password";
        private SQLiteDatabase sqLiteDatabase;


        //creating table query
        private static final String CREATE_TABLE = "create table " + TABLE_NAME +"("+ID+
                " INTEGER PRIMARY KEY AUTOINCREMENT," + EMAIL + " TEXT NOT NULL,"+PASSWORD+" TEXT NOT NULL);";
        //Constructor
        public DatabaseHelperClass (Context context){
            super(context,DATABASE_NAME,null,DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }


        public void addPassword(PasswordModelClass passwordModelClass){
            ContentValues contentValues = new ContentValues();
            contentValues.put(DatabaseHelperClass.EMAIL, passwordModelClass.getemail());
            contentValues.put(DatabaseHelperClass.PASSWORD, passwordModelClass.getpassword());
            sqLiteDatabase = this.getWritableDatabase();
            sqLiteDatabase.insert(DatabaseHelperClass.TABLE_NAME, null,contentValues);
        }
        public List<PasswordModelClass> getPasswordList(){
            String sql = "select * from " + TABLE_NAME;
            sqLiteDatabase = this.getReadableDatabase();
            List<PasswordModelClass> storePassword = new ArrayList<>();
            Cursor cursor = sqLiteDatabase.rawQuery(sql,null);
            if (cursor.moveToFirst()){
                do {
                    int id = Integer.parseInt(cursor.getString(0));
                    String email = cursor.getString(1);
                    String password = cursor.getString(2);
                    storePassword.add(new PasswordModelClass(id,email,password));
                }while (cursor.moveToNext());
            }
            cursor.close();
            return storePassword;
        }
        public void updatePassword(PasswordModelClass passwordModelClass){
            ContentValues contentValues = new ContentValues();
            contentValues.put(DatabaseHelperClass.EMAIL,passwordModelClass.getemail());
            contentValues.put(DatabaseHelperClass.PASSWORD,passwordModelClass.getpassword());
            sqLiteDatabase = this.getWritableDatabase();
            sqLiteDatabase.update(TABLE_NAME,contentValues,ID + " = ?" , new String[]
                    {String.valueOf(passwordModelClass.getId())});
        }
        public void deletePassword(int id){
            sqLiteDatabase = this.getWritableDatabase();
            sqLiteDatabase.delete(TABLE_NAME, ID + " = ? ", new String[]
                    {String.valueOf(id)});
        }
}
