package com.newproject.permission;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;

import com.gyf.barlibrary.ImmersionBar;
import com.newproject.R;
import com.newproject.base.BaseActivity;
import com.newproject.entity.RefreshToken;

public class PermissionsActivity extends BaseActivity {

    public static final int PERMISSIONS_GRANTED = 0;

    public static final int PERMISSIONS_DENIED = 1;

    private static final int PERMISSION_REQUEST_CODE = 0;

    private static final String EXTRA_PERMISSIONS = "com.ucloud.ulive.example.extra_permission";

    private static final String PACKAGE_URL_SCHEME = "package:";

    private PermissionsChecker mChecker;

    private boolean isRequireCheck;
//    private View topView;

    public static void startActivityForResult(Activity activity, int requestCode, String... permissions) {
        Intent intent = new Intent(activity, PermissionsActivity.class);
        intent.putExtra(EXTRA_PERMISSIONS, permissions);
        ActivityCompat.startActivityForResult(activity, intent, requestCode, null);
    }

    protected ImmersionBar mImmersionBar;



    protected void initImmersionBar() {
        //在BaseActivity里初始化
//        mImmersionBar.with(PermissionsActivity.this)
//                .statusBarView(topView)
//                .statusBarDarkFont(true, 0.2f)
//                .init();
    }





    @Override
    public int getLayout() {
        if (getIntent() == null || !getIntent().hasExtra(EXTRA_PERMISSIONS)) {
            throw new RuntimeException("PermissionsActivity需要使用静态startActivityForResult方法启动!");
        }
        return R.layout.activity_permissions;
    }

    @Override
    public void initView() {
//        topView = findViewById(R.id.top_view);
        mChecker = new PermissionsChecker(this);
        isRequireCheck = true;
    }

    @Override
    public void initData() {

    }



    @Override
    public void accept(String msg) {

    }

    @Override
    public void refresh(RefreshToken event) {

    }


    @Override
    protected void onResume() {
        super.onResume();
        if (isRequireCheck) {
            String[] permissions = getPermissions();
            if (mChecker.lacksPermissions(permissions)) {
                requestPermissions(permissions);
            } else {
                allPermissionsGranted();
            }
        } else {
            isRequireCheck = true;
        }
    }

    private String[] getPermissions() {
        return getIntent().getStringArrayExtra(EXTRA_PERMISSIONS);
    }

    private void requestPermissions(String... permissions) {
        ActivityCompat.requestPermissions(this, permissions, PERMISSION_REQUEST_CODE);
    }

    private void allPermissionsGranted() {
        setResult(PERMISSIONS_GRANTED);
        finish();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == PERMISSION_REQUEST_CODE && hasAllPermissionsGranted(grantResults)) {
            isRequireCheck = true;
            allPermissionsGranted();
        } else {
            isRequireCheck = false;
            showMissingPermissionDialog();
        }
    }

    private boolean hasAllPermissionsGranted(@NonNull int[] grantResults) {
        for (int grantResult : grantResults) {
            if (grantResult == PackageManager.PERMISSION_DENIED) {
                return false;
            }
        }
        return true;
    }

    private void showMissingPermissionDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(PermissionsActivity.this);
        builder.setTitle(R.string.help);
        builder.setMessage(R.string.string_help_text);

        builder.setNegativeButton(R.string.quit, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                setResult(PERMISSIONS_DENIED);
                finish();
            }
        });

        builder.setPositiveButton(R.string.settings, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                startAppSettings();
            }
        });

        builder.setCancelable(false);

        builder.show();
    }

    private void startAppSettings() {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        intent.setData(Uri.parse(PACKAGE_URL_SCHEME + getPackageName()));
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        if (mImmersionBar != null) {
            mImmersionBar.destroy();
        }
        super.onDestroy();
    }
}
