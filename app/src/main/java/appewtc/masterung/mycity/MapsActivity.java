package appewtc.masterung.mycity;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    private double douCenterLat, douCenterLng;
    private LatLng latlngCenterMap,
            sakonMaker1, sakonMaker2, sakonMaker3, sakonMaker4,
            chianMai1, chianMai2, chianMai3, chianMai4,
            bkk1, bkk2, bkk3, bkk4;
    private PolylineOptions bkkPolylineOptions;
    private PolygonOptions bkkPolygonOptions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        //Receive From MainActivity
        receiveFromMain();

        //Create Lat,Lng
        createLatLng();

        setUpMapIfNeeded();

        //Create Map
        createMap();

        //Create Maker
        createMaker();

        //Create Polyline
        createPolyline();

        //Create Polygon
        createPolygon();


    }   // onCreate

    private void createPolygon() {

        bkk1 = new LatLng(13.742303, 100.522781);
        bkk2 = new LatLng(13.741980, 100.525109);
        bkk3 = new LatLng(13.740333, 100.524798);
        bkk4 = new LatLng(13.740687, 100.522513);

        bkkPolygonOptions = new PolygonOptions();
        bkkPolygonOptions.add(bkk1)
                .add(bkk2)
                .add(bkk3)
                .add(bkk4)
                .add(bkk1)
                .strokeWidth(10)
                .strokeColor(Color.BLUE)
                .fillColor(Color.argb(50, 219, 249, 21)).zIndex(5);
        mMap.addPolygon(bkkPolygonOptions);

    }

    private void createPolyline() {

        bkk1 = new LatLng(13.742303, 100.522781);
        bkk2 = new LatLng(13.741980, 100.525109);
        bkk3 = new LatLng(13.740333, 100.524798);
        bkk4 = new LatLng(13.740687, 100.522513);

        bkkPolylineOptions = new PolylineOptions();
        bkkPolylineOptions.add(bkk1)
                .add(bkk2)
                .add(bkk3)
                .add(bkk4)
                .add(bkk1)
                .width(5)
                .color(Color.RED).zIndex(20);
        mMap.addPolyline(bkkPolylineOptions);


    }

    private void createMaker() {

        //For Sakon
        sakonMaker1 = new LatLng(17.192647, 104.093637);
        sakonMaker2 = new LatLng(17.194892, 104.089378);
        sakonMaker3 = new LatLng(17.190812, 104.086739);
        sakonMaker4 = new LatLng(17.188281, 104.091062);

        mMap.addMarker(new MarkerOptions().position(sakonMaker1).title("My Home").snippet("Home of Master UNG"));
        mMap.addMarker(new MarkerOptions().position(sakonMaker2).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)).title("โรงเรียน").snippet("สถานศึกษาโรงเรียน"));
        mMap.addMarker(new MarkerOptions().position(sakonMaker3).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
        mMap.addMarker(new MarkerOptions().position(sakonMaker4));

        //Chianmai
        chianMai1 = new LatLng(18.797280, 98.976838);
        chianMai2 = new LatLng(18.782938, 98.976580);
        chianMai3 = new LatLng(18.780541, 98.992759);
        chianMai4 = new LatLng(18.796224, 98.994004);

        mMap.addMarker(new MarkerOptions().position(chianMai1).icon(BitmapDescriptorFactory.fromResource(R.drawable.build1)));
        mMap.addMarker(new MarkerOptions().position(chianMai2).icon(BitmapDescriptorFactory.fromResource(R.drawable.build2)));
        mMap.addMarker(new MarkerOptions().position(chianMai3).icon(BitmapDescriptorFactory.fromResource(R.drawable.build3)));
        mMap.addMarker(new MarkerOptions().position(chianMai4).icon(BitmapDescriptorFactory.fromResource(R.drawable.build4)));
    }

    private void createMap() {

        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latlngCenterMap, 17));

    }

    private void createLatLng() {
        latlngCenterMap = new LatLng(douCenterLat, douCenterLng);
    }

    private void receiveFromMain() {
        douCenterLat = getIntent().getExtras().getDouble("Lat");
        douCenterLng = getIntent().getExtras().getDouble("Lng");
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p/>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p/>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p/>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */
    private void setUpMap() {
        mMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));
    }
}   // Main Class
