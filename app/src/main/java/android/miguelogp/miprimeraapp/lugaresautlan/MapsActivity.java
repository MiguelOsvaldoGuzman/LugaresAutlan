package android.miguelogp.miprimeraapp.lugaresautlan;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {


    private GoogleMap mMap;
    public static final LatLng sanjose = new LatLng(19.764967, -104.369094);
    public static final LatLng landia = new LatLng(19.7611, -104.3787186);
    public static final LatLng angelos = new LatLng(19.765119, -104.374800);
    public static final LatLng sancar = new LatLng(19.766155, -104.371344);
    public static final LatLng pizzeria2 = new LatLng(19.77200382, -104.37313057);
    public static final LatLng crocante = new LatLng(19.7699535, -104.3748309);
    public static final LatLng silver = new LatLng(19.776220, -104.365019);
    public static final LatLng laredos = new LatLng(19.782432, -104.364346);
    public static final LatLng george = new LatLng(19.770065, -104.364753);

    private Marker mgeorge;
    private Marker msanjose;
    private Marker mlandia;
    private Marker mangelos;
    private Marker msancar;
    private Marker mpizzeria2;
    private Marker mcrocante;
    private Marker msilver;
    private Marker mlaredos;
    String city = "";

    Intent intent;
    private GoogleApiClient mGoogleApiClient;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.title_activity_maps);
        mapFragment.getMapAsync(this);



        Geocoder geocoder;
        List<Address>addresses;
        geocoder=new Geocoder(this, Locale.getDefault());
        try{
            addresses=geocoder.getFromLocation(sanjose.latitude,sanjose.longitude,1);
            city=addresses.get(0).getAddressLine(0);
        }catch (IOException e){
            e.printStackTrace();
        }


    }



    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng autlan = new LatLng(19.770774,-104.3667 );
        mMap.moveCamera(CameraUpdateFactory.newLatLng(autlan));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(autlan, 13));

        mangelos=mMap.addMarker(new MarkerOptions().position(angelos).title("Pizzeria Angelos").snippet("Dirrecion:"+city+"\n\n"+"Numero de telefono: ").icon(BitmapDescriptorFactory.fromResource(R.drawable.pizza_icon)));

        mangelos.setTag(0);
        mlandia=mMap.addMarker(new MarkerOptions().position(landia).title("Pizzeria PizzaLandia").snippet("Dirrecion:"+city+"\n\n"+"Numero de telefono: ").icon(BitmapDescriptorFactory.fromResource(R.drawable.pizza_icon)));
        mlandia.setTag(0);
        msanjose=mMap.addMarker(new MarkerOptions().position(sanjose).title("Pizzeria Sanjose").snippet("Dirrecion:"+city+"\n\n"+"Numero de telefono: ").icon(BitmapDescriptorFactory.fromResource(R.drawable.pizza_icon)).draggable(true));
        msanjose.setTag(0);
        msancar=mMap.addMarker(new MarkerOptions().position(sancar).title("Pizzeria San Carlos").snippet("Dirrecion:"+city+"\n\n"+"Numero de telefono: ").icon(BitmapDescriptorFactory.fromResource(R.drawable.pizza_icon)));
        msancar.setTag(0);
        mpizzeria2=mMap.addMarker(new MarkerOptions().position(pizzeria2).title("Pizzeria").snippet("Dirrecion:"+city+"\n\n"+"Numero de telefono: ").icon(BitmapDescriptorFactory.fromResource(R.drawable.pizza_icon)));
        mpizzeria2.setTag(0);
        mcrocante=mMap.addMarker(new MarkerOptions().position(crocante).title("Pizzeria Crocante").snippet("Dirrecion:"+city+"\n\n"+"Numero de telefono: ").icon(BitmapDescriptorFactory.fromResource(R.drawable.pizza_icon)));
        mcrocante.setTag(0);
        msilver=mMap.addMarker(new MarkerOptions().position(silver).title("Pizzeria Silver").snippet("Dirrecion:"+city+"\n\n"+"Numero de telefono: ").icon(BitmapDescriptorFactory.fromResource(R.drawable.pizza_icon)));
        msilver.setTag(0);
        mlaredos=mMap.addMarker(new MarkerOptions().position(laredos).title("Pizzeria Laredos").snippet("Dirrecion:"+city+"\n\n"+"Numero de telefono: ").icon(BitmapDescriptorFactory.fromResource(R.drawable.pizza_icon)));
        mlaredos.setTag(0);
        mgeorge=mMap.addMarker(new MarkerOptions().position(george).title("Pizzeria George").snippet("Dirrecion:"+city+"\n\n"+"Numero de telefono: ").icon(BitmapDescriptorFactory.fromResource(R.drawable.pizza_icon)));
        mgeorge.setTag(0);
        mMap.setOnMarkerClickListener(this);
        mMap.setInfoWindowAdapter(new LocationInforWindowAdapter(getLayoutInflater()));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);


    }
    public boolean onMarkerClick(final Marker marker) {
        Integer clickCount = (Integer) marker.getTag();
        if (clickCount != null) {
            clickCount = clickCount + 1;
            marker.setTag(clickCount);
            Toast.makeText(this,
                    marker.getTitle() ,
                    Toast.LENGTH_SHORT).show();
        }
        return (false);
    }

}
