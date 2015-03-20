package appewtc.masterung.mycity;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    private int intTypeMap = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }   // onCreate

    public void clickSakon(View view) {
        intentToMaps(17.192068, 104.091615);
    }


    public void clickChiangmai(View view) {
        intentToMaps(18.788931, 98.985657);
    }

    public void clickBangkok(View view) {
        intentToMaps(13.741026, 100.524020);
    }

    private void intentToMaps(double douLat, double douLng) {

        Intent objIntent = new Intent(MainActivity.this, MapsActivity.class);
        objIntent.putExtra("Lat", douLat);
        objIntent.putExtra("Lng", douLng);
        objIntent.putExtra("Type", intTypeMap);
        startActivity(objIntent);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.itemSatelite:
                intTypeMap = 1;
                break;
            case R.id.itemTerrain:
                intTypeMap = 2;
                break;
            case R.id.itemHybrid:
                intTypeMap = 3;
                break;
            case R.id.itemNormal:
                intTypeMap = 0;
                break;
        }


        return super.onOptionsItemSelected(item);
    }
}   // Main Class
