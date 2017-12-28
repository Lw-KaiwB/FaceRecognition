package com.cloud.facerecognition;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int RESULT_ONE_PHOTO = 0x001;
    private static final int RESULT_TWO_PHOTO = 0x002;

    private ImageView mOneImg, mTwoImg;
    private TextView mResultText;
    private Button mSubmitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mResultText = findViewById(R.id.result_text);
        mOneImg = findViewById(R.id.one_photo);
        mTwoImg = findViewById(R.id.two_photo);
        mSubmitBtn = findViewById(R.id.submit_btn);

        mOneImg.setOnClickListener(new MyOnClickListener());
        mTwoImg.setOnClickListener(new MyOnClickListener());
        mSubmitBtn.setOnClickListener(new MyOnClickListener());

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == RESULT_ONE_PHOTO) {

            } else if (requestCode == RESULT_TWO_PHOTO) {

            }
        }
    }

    private class MyOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.one_photo:
                    Intent intent = new Intent(MainActivity.this, HeadDialog.class);
                    startActivityForResult(intent, RESULT_ONE_PHOTO);
                    break;

                case R.id.two_photo:
                    Intent intent1 = new Intent(MainActivity.this, HeadDialog.class);
                    startActivityForResult(intent1, RESULT_TWO_PHOTO);
                    break;

                case R.id.submit_btn:

                    break;
            }
        }
    }
}
