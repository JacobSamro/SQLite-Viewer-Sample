package in.a6un.sqliteviewer.sample;


import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.json.JSONException;

import a6un.sqliteviewer.Databases;
import a6un.sqliteviewer.SQLiteDataHelper;
import a6un.sqliteviewer.SQLiteService;

public class StartActivity extends AppCompatActivity {

    Databases databases = new Databases();


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);


       //Creating a SQLite Helper

        SQLiteDataHelper dbHelper = new SQLiteDataHelper(this,"test",1);
        SQLiteDatabase db = dbHelper.getWritableDatabase();


        // Creating a Test Database

        SQLiteDataHelper.createTestDB(db);


        try {

            databases.add("test",1);


            SQLiteService sqLiteService = new SQLiteService(this,databases.getDatabases());

            sqLiteService.initiate("http://192.168.1.102:8000");

            //Log.d("TABLE DATA :", sqLiteService.getData("test","posts",0).toString());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
//        ActionSheetDialogNoTitle();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.runFinalization();
        Runtime.getRuntime().gc();
        System.gc();
    }





}