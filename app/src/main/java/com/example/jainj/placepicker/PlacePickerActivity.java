package com.example.jainj.placepicker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;

public class PlacePickerActivity extends AppCompatActivity {

    int PLACE_PICKER_REQUEST = 1;
    TextView tvplace;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_picker);
        tvplace = (TextView)findViewById(R.id.tvplace);
    }

    public void goPlacePicker(View view){

        PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
        try{
            startActivityForResult(builder.build(PlacePickerActivity.this),PLACE_PICKER_REQUEST);
        }
        catch(GooglePlayServicesRepairableException e)
        {
            e.printStackTrace();
        }
        catch(GooglePlayServicesNotAvailableException e)
        {
            e.printStackTrace();
        }
    }

    protected void onActivityResult(int requestcode, int resultcode, Intent data){

        if(requestcode == PLACE_PICKER_REQUEST){
            if(resultcode == RESULT_OK){
                Place place = PlacePicker.getPlace(PlacePickerActivity.this,data);
                tvplace.setText(place.getAddress());
            }
        }
    }
}
