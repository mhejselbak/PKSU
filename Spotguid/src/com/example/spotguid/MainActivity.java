package com.example.spotguid;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends Activity {
	private final LatLng LOCATION_BMXbutikken = new LatLng(55.700934, 12.569840);
	private final LatLng LOCATION_fælled = new LatLng(55.698343, 12.543104);
	
	private GoogleMap map;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Criteria cri= new Criteria();
        String bbb = locationmanager.getBestProvider(cri, true);
        Location myLocation = locationmanager.getLastKnownLocation(bbb);

        double lat= myLocation.getLatitude();
        double long = myLocation.getLongitude();
        LatLng ll = new LatLng(lat, long);

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ll, 20));
        map  = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
        map.addMarker(new MarkerOptions().position(LOCATION_BMXbutikken).title("Find us here!"));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
	public void onClick_City(View v) {
//		CameraUpdate update = CameraUpdateFactory.newLatLng(LOCATION_BURNABY);
		map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
		CameraUpdate update = CameraUpdateFactory.newLatLngZoom(LOCATION_BMXbutikken, 9);
		map.animateCamera(update);
	}
	public void onClick_Burnaby(View v) {
		map.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
		CameraUpdate update = CameraUpdateFactory.newLatLngZoom(LOCATION_BMXbutikken, 14);
		map.animateCamera(update);
		
	}
	public void onClick_Surrey(View v) {
		map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
		CameraUpdate update = CameraUpdateFactory.newLatLngZoom(LOCATION_fælled, 16);
		map.animateCamera(update);
		
	}
}
