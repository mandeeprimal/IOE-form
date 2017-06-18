package com.ofir12.form;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends Activity {
    Button btn1;

    Button button;
    ImageView imageview;
    static final int CAMERA_REQUEST = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button2);
        imageview = (ImageView) findViewById(R.id.imageview2);
        OnClickButtonListner();
//        imageview.setBackground(getDrawable(R.drawable.logo));
        imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent TakePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                if (TakePictureIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(TakePictureIntent, CAMERA_REQUEST);

                }

            }
        });

    }
    public void OnClickButtonListner()
    {
        btn1=(Button)findViewById(R.id.buttn);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Intent intents= new Intent("com.ofir12.form.SignatureActivity");
                    startActivity(intents);
            }
        });

    }



    public void dispatchTakePictureIntent(View v) {
        Intent TakePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if (TakePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(TakePictureIntent, CAMERA_REQUEST);

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {

        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imagebitmap = (Bitmap) extras.get("data");
            imageview.setImageBitmap(imagebitmap);







    }}}



