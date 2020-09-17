package com.example.spesuez.Evaluation.helpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class MySQLite {
    private Context context;
    private Operations_SQlLiteLoader operations_sQlLiteLoader;
    private SQLiteDatabase db;

    public MySQLite(Context context){
        this.context=context;
        operations_sQlLiteLoader=new Operations_SQlLiteLoader(context);
        db=operations_sQlLiteLoader.getWritableDatabase();

    }
    public void dropAll(){
        operations_sQlLiteLoader.onUpgrade(db,0,1);
        db.close();
        operations_sQlLiteLoader.close();
    }
    private void insertOperation( Operation operation){
        ContentValues content = new ContentValues();
        content.put("_id", operation.getId());
        content.put("member_id", operation.getMember_id());
        content.put("name", operation.getName());
        content.put("value", operation.getValue());
        content.put("committee", operation.getCommittee().toString());
        content.put("type", operation.getType().toString());
        content.put("month", operation.getMonth().toString());
       db.insert("operations", null, content);
     
    }



    public void insertArray(ArrayList<Operation> my_operations){
        for(Operation operation:my_operations){
            insertOperation(operation);
        }
        db.close();
        operations_sQlLiteLoader.close();
    }

    public ArrayList<Operation> readData(){
        ArrayList<Operation> my_operations=new ArrayList<Operation>();

        String columns[] ={"_id","member_id","name","value","committee","type","month"};
        Cursor cursor=db.query("operations",columns,null,null,null,null,null);
        while (cursor.moveToNext()){
        Operation operation=new Operation(cursor.getString(0),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                Operation.Committee.valueOf(cursor.getString(4)),
                Operation.Type.valueOf(cursor.getString(5)),
                Operation.Month.valueOf(cursor.getString(6)));
                my_operations.add(operation);
        }
        db.close();
        operations_sQlLiteLoader.close();
        return my_operations;

    }


    //second class

    private class Operations_SQlLiteLoader extends SQLiteOpenHelper{



    private static final String DB_NAME = "operationsDB"; // the name of our database
    private static final int DB_VERSION = 1; // the version of the database

    public Operations_SQlLiteLoader(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE operations ("
                + "_id Text PRIMARY KEY, "
                + "member_id VARCHAR(255), "
                + "name TEXT, "
                + "value TEXT, "
                + "committee TEXT, "
                + "type TEXT, "
                + "month TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS operations");
        onCreate(db);
    }

}
    }