package com.cloud.facerecognition;

import android.Manifest;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnNeverAskAgain;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.OnShowRationale;
import permissions.dispatcher.PermissionRequest;
import permissions.dispatcher.RuntimePermissions;

/**
 * Created by Administrator on 2017/12/27.
 */
@RuntimePermissions
public class HeadDialog extends Activity {
    private TextView mCameraTextBtn, mGalleryTextBtn, mCancelTextBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.head_dialog_view);

        Window m = getWindow();
        m.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        //m.setBackgroundDrawableResource(android.R.color.transparent);
        m.setBackgroundDrawableResource(R.drawable.dialog_bg);
        //m.getDecorView().setPadding(Utils.dp2px(mContext, 20), 0, Utils.dp2px(mContext, 20), 0);
        m.setDimAmount(0.3f);
        m.setGravity(Gravity.BOTTOM);
        m.setWindowAnimations(R.style.dialog_activity_animation);

        mCameraTextBtn = findViewById(R.id.take_photo);
        mGalleryTextBtn = findViewById(R.id.take_gallery);
        mCancelTextBtn = findViewById(R.id.take_cancel);

        mCameraTextBtn.setOnClickListener(new MyOnClickListener());
        mGalleryTextBtn.setOnClickListener(new MyOnClickListener());
        mCancelTextBtn.setOnClickListener(new MyOnClickListener());
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        HeadDialogPermissionsDispatcher.onRequestPermissionsResult(this,requestCode,grantResults);
    }

    //获得操作储存卡的权限之后，会来到这里
    @NeedsPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
    void writeExternalStorage(){

    }

    //用户拒绝给予应用操作储存卡的权限
    @OnPermissionDenied(Manifest.permission.WRITE_EXTERNAL_STORAGE)
    void writeExternalStorageDenied(){

    }

    //当用户没有勾选“不再询问”而选择拒绝时，弹出对话框说明为什么我们需要这个权限
    @OnShowRationale(Manifest.permission.WRITE_EXTERNAL_STORAGE)
    void showWriteExternalStorageDialog(final PermissionRequest request){

    }

    //用户选择不再弹出请求操作储存卡的权限的对话框
    @OnNeverAskAgain(Manifest.permission.WRITE_EXTERNAL_STORAGE)
    void writeExternalStorageNeverAsked(){

    }

    //获得操作想家的权限之后，会走到这里
    @NeedsPermission(Manifest.permission.CAMERA)
    void takeCamera() {

    }

    //当用户第一次选择拒绝时，会走到这一步，我们会再次申请一次摄像头权限
    @OnPermissionDenied(Manifest.permission.CAMERA)
    void takeCameraDenied(){

    }

    //当用户选择拒绝，并且选择了“不再询问”时，我们会弹出提示框提示用户，为什么我们需要这个权限
    @OnShowRationale(Manifest.permission.CAMERA)
    void showTakeCameraDialog(final PermissionRequest request){

    }

    //当用户选择“不再询问”，并且拒绝时，以后应用在申请权限，都会直接走到这里，不会再有弹出申请权限的提示，我们就直接弹出个提示就可以了
    @OnNeverAskAgain(Manifest.permission.CAMERA)
    void takeCameraNeverAsked(){

    }

    private class MyOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.take_photo:
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){

                    }else {

                    }
                    break;

                case R.id.take_gallery:

                    break;

                case R.id.take_cancel:
                    finish();
                    break;
            }
        }
    }
}
