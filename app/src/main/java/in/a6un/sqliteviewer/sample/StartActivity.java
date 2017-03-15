package in.a6un.sqliteviewer.sample;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

import a6un.sqliteviewer.CreateTestDatabase;
import a6un.sqliteviewer.SQLiteService;

public class StartActivity extends AppCompatActivity {

    ArrayList<String> databases = new ArrayList<String>();


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        CreateTestDatabase createTestDatabase = new CreateTestDatabase(getApplicationContext());

        databases.add("test");

        SQLiteService sqLiteService = new SQLiteService(getApplicationContext(),databases);



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