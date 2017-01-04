package com.tinmegali.mylocation;

import android.Manifest;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationManager;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity
        implements
            GoogleApiClient.ConnectionCallbacks,
            GoogleApiClient.OnConnectionFailedListener,
            LocationListener,
            OnMapReadyCallback,
            GoogleMap.OnMapClickListener,
            GoogleMap.OnMarkerClickListener,
            ResultCallback<Status> {

    @Bind(R.id.edtComment) EditText edtComment;
    public static MyLatLng[] kbtgFencing = {
//            new MyLatLng(13.9099365,100.5506424),
//            new MyLatLng(13.9099016,100.5507627),
//            new MyLatLng(13.9098612,100.5508754),
//            new MyLatLng(13.9098243,100.5509783),
//            new MyLatLng(13.9097891,100.5510753),
//            new MyLatLng(13.9097552,100.5511691),
//            new MyLatLng(13.9097240,100.5512556),
//            new MyLatLng(13.9096946,100.5513382),
//            new MyLatLng(13.9096668,100.5514182),
//            new MyLatLng(13.9096301,100.5515292),
//            new MyLatLng(13.9095978,100.5516268),
//            new MyLatLng(13.9095695,100.5517016),
//            new MyLatLng(13.9095748,100.5518536),
//            new MyLatLng(13.9096787,100.5518913),
//            new MyLatLng(13.9097703,100.5519276),
//            new MyLatLng(13.9098637,100.5519647),
//            new MyLatLng(13.9099540,100.5520005),
//            new MyLatLng(13.9100838,100.5520524),
//            new MyLatLng(13.9102181,100.5521066),
//            new MyLatLng(13.9103996,100.5521812),
//            new MyLatLng(13.9105663,100.5522480),
//            new MyLatLng(13.9106475,100.5522798),
//
//            new MyLatLng(13.9112057,100.5509313),
//            new MyLatLng(13.9111193,100.5508937),
//            new MyLatLng(13.9110304,100.5508552),
//            new MyLatLng(13.9109379,100.5508177),
//            new MyLatLng(13.9108534,100.5507843),
//            new MyLatLng(13.9107658,100.5507502),
//            new MyLatLng(13.9106686,100.5507114),
//            new MyLatLng(13.9104818,100.5506373),
//            new MyLatLng(13.9104054,100.5506072),
//            new MyLatLng(13.9103244,100.5505756),
//            new MyLatLng(13.9101466,100.5504997),
//            new MyLatLng(13.9100471,100.5504477),
//            new MyLatLng(13.9099499,100.5505650)

            ////////
//            new MyLatLng(13.7470581,100.5340691),
//            new MyLatLng(13.7462254,100.5337996),
//            new MyLatLng(13.7457759,100.5337626),
//            new MyLatLng(13.7457615,100.5338940),
//            new MyLatLng(13.7457198,100.5340951),
//            new MyLatLng(13.7456528,100.5347751),
//            new MyLatLng(13.7455632,100.5353799),
//            new MyLatLng(13.7457065,100.5354899),
//            new MyLatLng(13.7459410,100.5355972),
//            new MyLatLng(13.7463891,100.5357259),
//            new MyLatLng(13.7466249,100.5358600),
//            new MyLatLng(13.7473661,100.5360196),
//            new MyLatLng(13.7477491,100.5360290),
//            new MyLatLng(13.7478598,100.5354000),
//            new MyLatLng(13.7478872,100.5349414),
//            new MyLatLng(13.7480497,100.5345256),
//            new MyLatLng(13.7476459,100.5343486),
//            new MyLatLng(13.7468317,100.5340026),


//            new MyLatLng(13.8159823,100.5597301),
//            new MyLatLng(13.8157466,100.5597362),
//            new MyLatLng(13.8156261,100.5603155),
//            new MyLatLng(13.8158801,100.5610384),
//            new MyLatLng(13.8160513,100.5614340),
//            new MyLatLng(13.8162994,100.5616714),
//            new MyLatLng(13.8169798,100.5619966),
//            new MyLatLng(13.8173627,100.5622259),
//            new MyLatLng(13.8176955,100.5617867),
//            new MyLatLng(13.8175000,100.5611389),
//            new MyLatLng(13.8164869,100.5606837),
//            new MyLatLng(13.8163170,100.5601345),
//            new MyLatLng(13.8162375,100.5598810)

            new MyLatLng(13.7447171,100.5441763),
            new MyLatLng(13.7444780,100.5439738),
            new MyLatLng(13.7441335,100.5439007),
            new MyLatLng(13.7440345,100.5444882),

            new MyLatLng(13.7440750, 100.544793),
            new MyLatLng(13.7444323,100.5448244),
            new MyLatLng(13.7448799,100.5448503),
//new MyLatLng(13.7444071,100.5447000),
//new MyLatLng(13.7448545,100.5447584),
            new MyLatLng(13.7449607,100.5446806),
            new MyLatLng(13.7448943,100.5445478),
    };
    protected LocationManager locationManager2;
    protected LocationListener locationListener2;

    private static final String TAG = MainActivity.class.getSimpleName();
    private Marker geoMarker;
    private GoogleMap map;
    private GoogleApiClient googleApiClient;
    private Location lastLocation;

    private TextView textLat, textLong;

    private MapFragment mapFragment;

    private static final String NOTIFICATION_MSG = "NOTIFICATION MSG";
    // Create a Intent send by the notification
    public static Intent makeNotificationIntent(Context context, String msg) {
        Intent intent = new Intent( context, MainActivity.class );
        intent.putExtra( NOTIFICATION_MSG, msg );
        return intent;
    }
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    //persmission method.
    public static void verifyStoragePermissions(Activity activity) {
        // Check if we have read or write permission
        int writePermission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int readPermission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.READ_EXTERNAL_STORAGE);

        if (writePermission != PackageManager.PERMISSION_GRANTED || readPermission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textLat = (TextView) findViewById(R.id.lat);
        textLong = (TextView) findViewById(R.id.lon);
        ButterKnife.bind(this);

//        locationManager2 = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
//        locationManager2.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);

        // initialize GoogleMaps
        initGMaps();
        verifyStoragePermissions(this);
        // create GoogleApiClient
        createGoogleApi();
    }

    // Create GoogleApiClient instance
    private void createGoogleApi() {
        Log.d(TAG, "createGoogleApi()");
        if ( googleApiClient == null ) {
            googleApiClient = new GoogleApiClient.Builder( this )
                    .addConnectionCallbacks( this )
                    .addOnConnectionFailedListener( this )
                    .addApi( LocationServices.API )
                    .build();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        // Call GoogleApiClient connection when starting the Activity
        googleApiClient.connect();
    }

    @Override
    protected void onStop() {
        super.onStop();

        // Disconnect GoogleApiClient when stopping Activity
        googleApiClient.disconnect();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate( R.menu.main_menu, menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch ( item.getItemId() ) {
            case R.id.geofence: {
                startGeofence();
                return true;
            }
            case R.id.clear: {
                clearGeofence();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    private final int REQ_PERMISSION = 999;

    // Check for permission to access Location
    private boolean checkPermission() {
        Log.d(TAG, "checkPermission()");
        // Ask for permission if it wasn't granted yet
        return (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED );
    }

    // Asks for permission
    private void askPermission() {
        Log.d(TAG, "askPermission()");
        ActivityCompat.requestPermissions(
                this,
                new String[] { Manifest.permission.ACCESS_FINE_LOCATION },
                REQ_PERMISSION
        );
    }

    // Verify user's response of the permission requested
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        Log.d(TAG, "onRequestPermissionsResult()");
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch ( requestCode ) {
            case REQ_PERMISSION: {
                if ( grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED ){
                    // Permission granted
                    getLastKnownLocation();

                } else {
                    // Permission denied
                    permissionsDenied();
                }
                break;
            }
        }
    }

    // App cannot work without the permissions
    private void permissionsDenied() {
        Log.w(TAG, "permissionsDenied()");
        // TODO close app and warn user
    }

    // Initialize GoogleMaps
    private void initGMaps(){
        mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    // Callback called when Map is ready
    @Override
    public void onMapReady(GoogleMap googleMap) {
        Log.d(TAG, "onMapReady()");
        map = googleMap;
        map.setOnMapClickListener(this);
        map.setOnMarkerClickListener(this);
    }

    @Override
    public void onMapClick(LatLng latLng) {
        Log.d(TAG, "onMapClick("+latLng +")");
        markerForGeofence(latLng);
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        Log.d(TAG, "onMarkerClickListener: " + marker.getPosition() );
        return false;
    }

    private LocationRequest locationRequest;
    // Defined in mili seconds.
    // This number in extremely low, and should be used only for debug
    private final int UPDATE_INTERVAL =  100;
    private final int FASTEST_INTERVAL = 90;

    // Start location Updates
    private void startLocationUpdates(){
        Log.i(TAG, "startLocationUpdates()");
        locationRequest = LocationRequest.create()
                .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
                .setInterval(UPDATE_INTERVAL)
                .setFastestInterval(FASTEST_INTERVAL);

        if ( checkPermission() ){
            LocationServices.FusedLocationApi.requestLocationUpdates(googleApiClient, locationRequest, this);
        }
    }

    @Override
    public void onLocationChanged(Location location) {
//        Log.d(TAG, "onLocationChanged ["+location+"]");

        lastLocation = location;
        writeActualLocation(location, BitmapDescriptorFactory.HUE_YELLOW);
    }

    // GoogleApiClient.ConnectionCallbacks connected
    @Override
    public void onConnected(@Nullable Bundle bundle) {
        Log.i(TAG, "onConnected()");
//        getLastKnownLocation();
//        recoverGeofenceMarker();
        drawStoreFencing();
    }

    // GoogleApiClient.ConnectionCallbacks suspended
    @Override
    public void onConnectionSuspended(int i) {
        Log.w(TAG, "onConnectionSuspended()");
    }

    // GoogleApiClient.OnConnectionFailedListener fail
    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Log.w(TAG, "onConnectionFailed()");
    }

    // Get last known location
    private void getLastKnownLocation() {
        Log.d(TAG, "getLastKnownLocation()");
        String comment = edtComment.getText().toString();
        if(comment == null) comment = "none";
        Log.e("YEAH","ON CLICK WORK");
        if ( checkPermission() ) {
            lastLocation = LocationServices.FusedLocationApi.getLastLocation(googleApiClient);
            int suitableMeter = 20;
            Log.e("Accuracy", ""+lastLocation.getAccuracy());
            if ( lastLocation != null) {

                Log.i(TAG, "LasKnown location. " +
                        "Long: " + lastLocation.getLongitude() +
                        " | Lat: " + lastLocation.getLatitude());
                writeActualLocation(lastLocation,BitmapDescriptorFactory.HUE_ROSE);
                startLocationUpdates();
                boolean isInsideKBTG = PolygonTest.PointIsInRegion(
                        lastLocation.getLatitude(),
                        lastLocation.getLongitude(),
                        kbtgFencing);
                String newLog = LogUtil.getInstance().addLog(comment, lastLocation, ""+isInsideKBTG);
                Toast.makeText(this, "Add New Log: "+newLog, Toast.LENGTH_SHORT).show();
            } else {
                Log.w(TAG, "No location retrieved yet");
                startLocationUpdates();
            }
        }
        else askPermission();
    }

    private void writeActualLocation(Location location, float color) {
        textLat.setText( "Lat: " + location.getLatitude() );
        textLong.setText( "Long: " + location.getLongitude() );
        String newLog = LogUtil.getInstance().addLog("PATH Central Ladprao", lastLocation, "null");
        markerLocation(new LatLng(location.getLatitude(), location.getLongitude()),color);
    }

    private void writeLastLocation() {
        writeActualLocation(lastLocation,BitmapDescriptorFactory.HUE_AZURE);
    }

    private Marker locationMarker;
    private void markerLocation(LatLng latLng, float color) {
        Log.i(TAG, "markerLocation("+latLng+")");
        String title = latLng.latitude + ", " + latLng.longitude;


        MarkerOptions markerOptions = new MarkerOptions()
                .position(latLng)
                .icon(BitmapDescriptorFactory.defaultMarker(color))
                .title(title);

        if ( map!=null ) {
//            if ( locationMarker != null )
//                locationMarker.remove();
            locationMarker = map.addMarker(markerOptions);
            float zoom = 17f;
            CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(latLng, zoom);
            map.animateCamera(cameraUpdate);
        }
    }


    private Marker geoFenceMarker;
    private void markerForGeofence(LatLng latLng) {
        Log.i(TAG, "markerForGeofence("+latLng+")");
        String title = latLng.latitude + ", " + latLng.longitude;
        // Define marker options
        MarkerOptions markerOptions = new MarkerOptions()
                .position(latLng)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE))
                .title(title);
        if ( map!=null ) {
            // Remove last geoFenceMarker
            if (geoFenceMarker != null)
                geoFenceMarker.remove();

            geoFenceMarker = map.addMarker(markerOptions);

        }
    }

    // Start Geofence creation process
    private void startGeofence() {
        Log.i(TAG, "startGeofence()");
        if( geoFenceMarker != null ) {
            Geofence geofence = createGeofence( geoFenceMarker.getPosition(), GEOFENCE_RADIUS );
            GeofencingRequest geofenceRequest = createGeofenceRequest( geofence );
//            addGeofence( geofenceRequest );
        } else {
            Log.e(TAG, "Geofence marker is null");
        }
    }

    private static final long GEO_DURATION = 60 * 60 * 1000;
    private static final String GEOFENCE_REQ_ID = "My Geofence";
    private static final float GEOFENCE_RADIUS = 500.0f; // in meters

    // Create a Geofence
    private Geofence createGeofence( LatLng latLng, float radius ) {
        Log.d(TAG, "createGeofence");
        return new Geofence.Builder()
                .setRequestId(GEOFENCE_REQ_ID)
                .setCircularRegion( latLng.latitude, latLng.longitude, radius)
                .setExpirationDuration( GEO_DURATION )
                .setTransitionTypes( Geofence.GEOFENCE_TRANSITION_ENTER
                        | Geofence.GEOFENCE_TRANSITION_EXIT )
                .build();
    }

    // Create a Geofence Request
    private GeofencingRequest createGeofenceRequest( Geofence geofence ) {
        Log.d(TAG, "createGeofenceRequest");
        return new GeofencingRequest.Builder()
                .setInitialTrigger( GeofencingRequest.INITIAL_TRIGGER_ENTER )
                .addGeofence( geofence )
                .build();
    }

    private PendingIntent geoFencePendingIntent;
    private final int GEOFENCE_REQ_CODE = 0;
//    private PendingIntent createGeofencePendingIntent() {
//        Log.d(TAG, "createGeofencePendingIntent");
//        if ( geoFencePendingIntent != null )
//            return geoFencePendingIntent;
//
//        Intent intent = new Intent( this, GeofenceTrasitionService.class);
//        return PendingIntent.getService(
//                this, GEOFENCE_REQ_CODE, intent, PendingIntent.FLAG_UPDATE_CURRENT );
//    }

    // Add the created GeofenceRequest to the device's monitoring list
//    private void addGeofence(GeofencingRequest request) {
//        Log.d(TAG, "addGeofence");
//        if (checkPermission())
//            LocationServices.GeofencingApi.addGeofences(
//                    googleApiClient,
//                    request,
////                    createGeofencePendingIntent()
//            ).setResultCallback(this);
//    }

    @Override
    public void onResult(@NonNull Status status) {
        Log.i(TAG, "onResult: " + status);
        if ( status.isSuccess() ) {
            saveGeofence();
            drawGeofence();
        } else {
            // inform about fail
        }
    }

    // Draw Geofence circle on GoogleMap
    private Circle geoFenceLimits;
    private void drawGeofence() {
        Log.d(TAG, "drawGeofence()");

//        if ( geoFenceLimits != null )
//            geoFenceLimits.remove();

        CircleOptions circleOptions = new CircleOptions()
                .center( geoFenceMarker.getPosition())
                .strokeColor(Color.argb(50, 70,70,70))
                .fillColor( Color.argb(100, 150,150,150) )
                .radius( GEOFENCE_RADIUS );
        geoFenceLimits = map.addCircle( circleOptions );
    }

    private final String KEY_GEOFENCE_LAT = "GEOFENCE LATITUDE";
    private final String KEY_GEOFENCE_LON = "GEOFENCE LONGITUDE";

    // Saving GeoFence marker with prefs mng
    private void saveGeofence() {
        Log.d(TAG, "saveGeofence()");
        SharedPreferences sharedPref = getPreferences( Context.MODE_PRIVATE );
        SharedPreferences.Editor editor = sharedPref.edit();

        editor.putLong( KEY_GEOFENCE_LAT, Double.doubleToRawLongBits( geoFenceMarker.getPosition().latitude ));
        editor.putLong( KEY_GEOFENCE_LON, Double.doubleToRawLongBits( geoFenceMarker.getPosition().longitude ));
        editor.apply();
    }

    // Recovering last Geofence marker
    private void recoverGeofenceMarker() {
        Log.d(TAG, "recoverGeofenceMarker");
        SharedPreferences sharedPref = getPreferences( Context.MODE_PRIVATE );

        if ( sharedPref.contains( KEY_GEOFENCE_LAT ) && sharedPref.contains( KEY_GEOFENCE_LON )) {
            double lat = Double.longBitsToDouble( sharedPref.getLong( KEY_GEOFENCE_LAT, -1 ));
            double lon = Double.longBitsToDouble( sharedPref.getLong( KEY_GEOFENCE_LON, -1 ));
            LatLng latLng = new LatLng( lat, lon );
            markerForGeofence(latLng);
            drawGeofence();
        }
    }

    // Clear Geofence
    private void clearGeofence() {
        Log.d(TAG, "clearGeofence()");
//        LocationServices.GeofencingApi.removeGeofences(
//                googleApiClient,
//                createGeofencePendingIntent()
//        ).setResultCallback(new ResultCallback<Status>() {
//            @Override
//            public void onResult(@NonNull Status status) {
//                if ( status.isSuccess() ) {
//                    // remove drawing
//                    removeGeofenceDraw();
//                }
//            }
//        });
    }

    private void removeGeofenceDraw() {
        Log.d(TAG, "removeGeofenceDraw()");
        if ( geoFenceMarker != null)
            geoFenceMarker.remove();
        if ( geoFenceLimits != null )
            geoFenceLimits.remove();
    }

    private void drawStoreFencing(){
        for(int i=0; i<kbtgFencing.length; i++) {
            MarkerOptions markerOptions = new MarkerOptions()
                    .position(new LatLng(kbtgFencing[i].Latitude, kbtgFencing[i].Longitude))
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
                    .title("fencing: " + i);

            if (map != null) {
                geoMarker = map.addMarker(markerOptions);
            }
        }
    }

    @OnClick(R.id.btnSubmit)
    public void onClickSubmit() {
        Handler handler1 = new Handler();
        for (int a = 1; a<=10 ;a++) {
            handler1.postDelayed(new Runnable() {

                @Override
                public void run() {
                    getLastKnownLocation();
                }
            }, 1000 * a);
        }
    }

}
