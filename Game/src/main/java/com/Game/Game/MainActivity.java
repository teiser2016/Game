package com.Game.Game;

		import android.Manifest;
		import android.app.Activity;
		import android.content.Intent;
		import android.content.IntentSender;
		import android.content.pm.PackageManager;
		import android.location.Location;
		import android.os.Bundle;
		import android.support.v4.app.ActivityCompat;
		import android.support.v7.app.AppCompatActivity;
		import android.util.Log;
		import android.view.View;
		import android.widget.TextView;
		import android.widget.Toast;

		import com.google.android.gms.common.ConnectionResult;
		import com.google.android.gms.common.GooglePlayServicesUtil;
		import com.google.android.gms.common.api.GoogleApiClient;
		import com.google.android.gms.location.LocationListener;
		import com.google.android.gms.location.LocationRequest;
		import com.google.android.gms.location.LocationServices;
		import com.google.android.gms.maps.CameraUpdate;
		import com.google.android.gms.maps.CameraUpdateFactory;
		import com.google.android.gms.maps.GoogleMap;
		import com.google.android.gms.maps.OnMapReadyCallback;
		import com.google.android.gms.maps.SupportMapFragment;
		import com.google.android.gms.maps.model.LatLng;
		import com.google.android.gms.maps.model.Marker;
		import com.google.android.gms.maps.model.MarkerOptions;

		//import db.MongoConnection;
		import permissions.dispatcher.NeedsPermission;
		import permissions.dispatcher.RuntimePermissions;

@RuntimePermissions
public class MainActivity extends AppCompatActivity implements
		GoogleApiClient.ConnectionCallbacks,
		GoogleApiClient.OnConnectionFailedListener,
		LocationListener,
		GoogleMap.OnMarkerClickListener{

	private SupportMapFragment mapFragment;
	private GoogleMap map;
	private GoogleApiClient mGoogleApiClient;
	private LocationRequest mLocationRequest;
	private long UPDATE_INTERVAL = 100;  /* 60 secs */
	private long FASTEST_INTERVAL = 5000; /* 5 secs */

	private final static int CONNECTION_FAILURE_RESOLUTION_REQUEST = 9000;

	private String dbURL = "";
	public static LatLng userLocation = null;
	TextView tv;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);

		mapFragment = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map));
		if (mapFragment != null) {
			mapFragment.getMapAsync(new OnMapReadyCallback() {
				@Override
				public void onMapReady(GoogleMap map) {
					loadMap(map);
				}
			});
		} else {
			Toast.makeText(this, "Error - Map Fragment was null!!", Toast.LENGTH_SHORT).show();
		}

		//tv = (TextView) findViewById(R.id.tv);
	}

	protected void loadMap(GoogleMap googleMap) {
		map = googleMap;
		if (map != null) {
			// Map is ready
			Toast.makeText(this, "Map Fragment was loaded properly!", Toast.LENGTH_SHORT).show();
			MainActivityPermissionsDispatcher.getMyLocationWithCheck(this);
		} else {
			Toast.makeText(this, "Error - Map was null!!", Toast.LENGTH_SHORT).show();
		}
	}

	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		MainActivityPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
	}

	@SuppressWarnings("all")
	@NeedsPermission({Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION})
	void getMyLocation() {
		if (map != null) {
			// Now that map has loaded, let's get our location!
			map.setMyLocationEnabled(true);
			mGoogleApiClient = new GoogleApiClient.Builder(this)
					.addApi(LocationServices.API)
					.addConnectionCallbacks(this)
					.addOnConnectionFailedListener(this).build();
			connectClient();
		}
	}

	protected void connectClient() {
		// Connect the client.
		if (isGooglePlayServicesAvailable() && mGoogleApiClient != null) {
			mGoogleApiClient.connect();
		}
	}

	//Called when the Activity becomes visible.
	@Override
	protected void onStart() {
		super.onStart();
		connectClient();
	}

	//Called when the Activity is no longer visible.
	@Override
	protected void onStop() {
		// Disconnecting the client invalidates it.
		if (mGoogleApiClient != null) {
			mGoogleApiClient.disconnect();
		}
		super.onStop();
	}

	//Handle results returned to the FragmentActivity by Google Play services
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// Decide what to do based on the original request code
		switch (requestCode) {
			case CONNECTION_FAILURE_RESOLUTION_REQUEST:
				//If the result code is Activity.RESULT_OK, try to connect again
				switch (resultCode) {
					case Activity.RESULT_OK:
						mGoogleApiClient.connect();
						break;
				}
		}
	}

	private boolean isGooglePlayServicesAvailable() {
		// Check that Google Play services is available
		int resultCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
		// If Google Play services is available
		if (ConnectionResult.SUCCESS == resultCode) {
			// In debug mode, log the status
			Log.d("Location Updates", "Google Play services is available.");
			return true;
		} else {
			return false;
		}
	}

	//Called by Location Services when the request to connect the client finishes successfully.
	//At this point, you can request the current location or start periodic updates
	@Override
	public void onConnected(Bundle dataBundle) {
		// Display the connection status
		if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
			return;
		}
		Location location = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
		if (location != null) {
			Toast.makeText(this, "GPS location was found!", Toast.LENGTH_SHORT).show();
			LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());

			userLocation = latLng;

			new MarkersHandler().setMarkersOnMap(map);

			new CameraHandler().setCamera(map, virtualUser);

			map.setOnMarkerClickListener(this);

		} else {
			Toast.makeText(this, "Current location was null, enable GPS on emulator!", Toast.LENGTH_SHORT).show();
		}
		startLocationUpdates();
	}

	@Override
	public boolean onMarkerClick(final Marker marker) {

		Integer tag = (Integer) marker.getTag();

		new MarkersHandler().highlightMarker(marker, tag);

		LatLng latLng = new LatLng(marker.getPosition().latitude, marker.getPosition().longitude);
		//the marker clicked is the user's virtual location
		virtualUser = latLng;

		// Return false to indicate that we have not consumed the event and that we wish for the default behavior to occur
		return false;
	}

	protected void startLocationUpdates() {
		mLocationRequest = new LocationRequest();
		mLocationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
		mLocationRequest.setInterval(UPDATE_INTERVAL);
		mLocationRequest.setFastestInterval(FASTEST_INTERVAL);
		if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
			return;
		}
		LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
	}

	public void onLocationChanged(Location location) {
		//parameter:location = updated location

		LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
		//update userLocation
		userLocation = latLng;

		//every time there is an update in the user's location, search for nearby object or npc within radius
		//there can only be one nearby
		LatLng nearbyEntity = new NearbySearch(userLocation).findEntity();

		if (nearbyEntity != null){
			//display marker of nearby entity
			setMarker(nearbyEntity.latitude, nearbyEntity.longitude, "name of obj/npc");
		}
	}

	public void setMarker(double lat1, double lng1, String title1){
		LatLng latLng = new LatLng(lat1, lng1);
		MarkerOptions markerOptions = new MarkerOptions();
		markerOptions.position(latLng);
		markerOptions.title(title1);
		Marker marker = map.addMarker(markerOptions);
	}

	//Called by Location Services if the connection to the location client drops because of an error.
	@Override
	public void onConnectionSuspended(int i) {
		if (i == CAUSE_SERVICE_DISCONNECTED) {
			Toast.makeText(this, "Disconnected. Please re-connect.", Toast.LENGTH_SHORT).show();
		} else if (i == CAUSE_NETWORK_LOST) {
			Toast.makeText(this, "Network lost. Please re-connect.", Toast.LENGTH_SHORT).show();
		}
	}

	//Called by Location Services if the attempt to Location Services fails.
	@Override
	public void onConnectionFailed(ConnectionResult connectionResult) {
		//Google Play services can resolve some errors it detects.
		if (connectionResult.hasResolution()) {
			try {
				// Start an Activity that tries to resolve the error
				connectionResult.startResolutionForResult(this, CONNECTION_FAILURE_RESOLUTION_REQUEST);
			} catch (IntentSender.SendIntentException e) {
				// Log the error
				e.printStackTrace();
			}
		} else {
			Toast.makeText(getApplicationContext(),
					"Sorry. Location services not available to you", Toast.LENGTH_LONG).show();
		}
	}
<<<<<<< Updated upstream




=======
/*
	public void selectaCharacter(View v)
	{
		Charchoice my_dialog = new Charchoice();
		my_dialog.show(getSupportFragmentManager(),"my_dialog");
	}

	public void selectgender(View v)
	{
		Properties my_dialog_a = new Properties();
		my_dialog_a.show(getSupportFragmentManager(),"my_dialog_a");
	}
*/
>>>>>>> Stashed changes
}
