package android.miguelogp.miprimeraapp.lugaresautlan;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

/**
 * Created by Chabelo on 11/08/2017.
 */

public class LocationInforWindowAdapter implements GoogleMap.InfoWindowAdapter {
    LayoutInflater inflater=null;

    LocationInforWindowAdapter (LayoutInflater inflater){
        this.inflater=inflater;
    }

    @Override
    public View getInfoWindow(Marker arg0) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {
        View infoWindow=inflater.inflate(R.layout.info_window,null);
        TextView title=(TextView)infoWindow.findViewById(R.id.title);
        TextView description=(TextView)infoWindow.findViewById(R.id.snippet);
        title.setText(marker.getTitle());
        description.setText(marker.getSnippet());
        return (infoWindow);
    }
}
