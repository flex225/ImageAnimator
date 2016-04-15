package com.yantur.imageanimator;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView curr, imageLeft, imageCenter, imageRight;
    private String path1 = Environment.getExternalStorageDirectory().toString() + "/IMG_20160411_1.png";
    private String path2 = Environment.getExternalStorageDirectory().toString() + "/IMG_20160411_1.png";
    private String path3 = Environment.getExternalStorageDirectory().toString() + "/IMG_20160411_1.png";
    private float x, y;
    private RelativeLayout relativeLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageLeft = (ImageView) findViewById(R.id.image1);
        imageCenter = (ImageView) findViewById(R.id.image2);
        imageRight = (ImageView) findViewById(R.id.image3);
        relativeLayout = (RelativeLayout) findViewById(R.id.layout);
        ImageLoader imageLoader1 = new ImageLoader(imageLeft);
        ImageLoader imageLoader2 = new ImageLoader(imageCenter);
        ImageLoader imageLoader3 = new ImageLoader(imageRight);
        imageLoader1.execute(path1);
        imageLoader2.execute(path2);
        imageLoader3.execute(path3);
        imageLeft.setOnClickListener(this);
        imageCenter.setOnClickListener(this);
        imageRight.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        if (curr != null) {
            curr.animate().x(x).y(y).setDuration(2000)
                    .setListener(new MyAnimation(curr, 1, 1)).start();
            curr.setClickable(true);
        }

        switch (v.getId()) {
            case R.id.image1:
                moveImage(imageLeft);
                break;
            case R.id.image2:
                moveImage(imageCenter);
                break;
            case R.id.image3:
                moveImage(imageRight);
                break;
        }


    }

    private void moveImage(ImageView imageView) {
        float layoutHeight = relativeLayout.getHeight() / 2;
        float layoutWidth = relativeLayout.getWidth() / 2;
        curr = imageView;
        x = imageView.getLeft();
        y = imageView.getTop();
        curr.setClickable(false);
        curr.animate().x(layoutWidth - curr.getWidth() / 2).y(layoutHeight - curr.getHeight())
                .setDuration(2000).
                setListener(new MyAnimation(curr, 4, 4)).start();
    }
}


