package com.example.mrbug.locationlisten;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public LocationManager locationManager;
    public MyLocationListener listener;
    public Location myLoc = null;
    TextView labelLocation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        labelLocation = (TextView)findViewById(R.id.labelloc);
    }





    //region LocationOperations
    public  void CheckLocation(View v){


        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        listener = new MyLocationListener();
        if (Build.VERSION.SDK_INT < 23) {
            //konumçek
            try {

                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){


                    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 4000, 0, listener);

                    if(locationManager==null)

                    locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 4000, 0, listener);

                labelLocation.setText("konumunuz Longitude="+myLoc.getLongitude()+" Latitude="+myLoc.getLatitude());
                }
                else Toast.makeText(getApplicationContext(),"error", Toast.LENGTH_SHORT).show();
            }
            catch (Exception e){
                labelLocation.setText("bir kaç saniye sonra deneyin");
            }

        } else {
            //yukardaki if olmadan konum istenemez derleyici hata veriyor
            //konum servisleri kullanılsınmı diye sor
            if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                //izin sorduk
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            }
            // else artık izinimiz var
            else {
                //konumçek
                try {



                    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 4000, 0, listener);

                    if(locationManager==null)

                        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 4000, 0, listener);


                    labelLocation.setText("Longitude="+myLoc.getLongitude()+"\nLatitude="+myLoc.getLatitude());
                }
                catch (Exception e){
                    labelLocation.setText("bir kaç saniye sonra deneyin");
                }
            }
        }

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(grantResults.length>0&& grantResults[0]== PackageManager.PERMISSION_GRANTED){
            if(ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION ) != PackageManager.PERMISSION_GRANTED) {
                //konum çek
                try {

                    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 4000, 0, listener);

                    if(locationManager==null)

                        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 4000, 0, listener);

                    labelLocation.setText("konumunuz Longitude="+myLoc.getLongitude()+" Latitude="+myLoc.getLatitude());
                }
                catch (Exception e){
                    labelLocation.setText("bir kaç saniye\n sonra deneyin");
                }
            }
        }
    }
    public class MyLocationListener implements LocationListener
    {
        public void onLocationChanged(final Location loc)
        {
            myLoc = loc;
        }
        public void onProviderDisabled(String provider)
        {
            Toast.makeText( getApplicationContext(), "Gps Kapatıldı", Toast.LENGTH_SHORT ).show();
        }
        public void onProviderEnabled(String provider)
        {
            Toast.makeText( getApplicationContext(), "Gps Açıldı", Toast.LENGTH_SHORT).show();
        }
        public void onStatusChanged(String provider, int status, Bundle extras)
        {}



    }


    //endregion

}
