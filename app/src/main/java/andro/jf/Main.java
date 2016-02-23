package andro.jf;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Toast;

public class Main extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // Fournisseurs de service
        LocationManager manager = 
         (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        List<String> fournisseurs = manager.getAllProviders();
        for (String f : fournisseurs)
        	Toast.makeText(getApplicationContext(), "" + f,
                Toast.LENGTH_SHORT).show();
        
        // Récupération de la localisation
        Location localisation = manager.getLastKnownLocation("gps");
        Toast.makeText(getApplicationContext(), "Lattitude" +
          localisation.getLatitude(), Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(), "Longitude" +
          localisation.getLongitude(), Toast.LENGTH_SHORT).show();
        
        // Ecouteur de changement de localisation
        manager.requestLocationUpdates("gps", 6000, 100,
               new LocationListener() {
			public void onStatusChanged(String provider,
                                int status, Bundle extras) {
			}
			public void onProviderEnabled(String provider) {
			}
			public void onProviderDisabled(String provider) {
			}
			public void onLocationChanged(Location location) {
				// TODO Auto-generated method stub
			}
		});
    }
}
