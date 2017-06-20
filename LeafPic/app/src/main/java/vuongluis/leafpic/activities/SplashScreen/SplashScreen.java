package vuongluis.leafpic.activities.SplashScreen;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;

import java.io.File;

import butterknife.BindView;
import vuongluis.leafpic.R;
import vuongluis.leafpic.activities.HomeScreen.HomeScreen;
import vuongluis.leafpic.activities.SharedMediaActivity;
import vuongluis.leafpic.contants.ConstantIntentFilter;
import vuongluis.leafpic.contants.ConstantPermissionID;
import vuongluis.leafpic.model.album.Album;
import vuongluis.leafpic.utils.ColorPalette;
import vuongluis.leafpic.utils.PermissionUtils;

public class SplashScreen extends SharedMediaActivity implements IScreenView, IUIScreenView, ICallView {

    private boolean PICK_INTENT = false;

    @BindView(R.id.activity_splash_screen_logo)
    ImageView imgLogo;

    @BindView(R.id.activity_splash_screen_title)
    ImageView txtTitle;

    @BindView(R.id.activity_splash_screen_loading)
    ImageView txtLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSystemUiVisibility();
        setNavigationBar();
        setStatusBarColor();
        // Check permission by class before go to Home Screen
        if (PermissionUtils.isDeviceInfoGranted(this)) {
            if (true) {
                // Accept permission Manifest.permission.READ_EXTERNAL_STORAGE
                callAnotherActivity();
                finishActivity();
                return;
            } else {
                if (getIntent().getAction().equals(ConstantIntentFilter._ACTION_OPEN_ALBUM_)) {
                    // Declaring object Bundle
                    Bundle data = getIntent().getExtras(); // LINE 2
                    if (data != null) {
                        if (data.getString("albumPath") != null) {
                            // Get all data that is transfered from Intent (Only string)
                            File directory = new File(data.getString("albumPath"));
                            // Call object and set value for this object
                            Album album = new Album();
                        }
                    } else {

                    }
                }else{
                    // Using AsynTask to get photo from phone

                }
                /*
                 * Check two Implicit Intents will be show
                 * - Intent.ACTION_GET_CONTENT
                 * - Intent.ACTION_PICK
                 */
                PICK_INTENT = getIntent().getAction().equals(Intent.ACTION_GET_CONTENT) || getIntent().getAction().equals(Intent.ACTION_PICK);
            }
        } else {
            // Request permission directly
            PermissionUtils.requestPermission(this, ConstantPermissionID.READ_EXTERNAL_STORAGE_ID, Manifest.permission.READ_EXTERNAL_STORAGE);
        }
    }

    @Override
    protected void setNavigationBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(ColorPalette.getTransparentColor(
                    ContextCompat.getColor(getApplicationContext(), vuongluis.leafpic.R.color.md_black_1000), 0));
        }
    }

    @Override
    protected void setStatusBarColor(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(ColorPalette.getTransparentColor(
                    ContextCompat.getColor(getApplicationContext(), vuongluis.leafpic.R.color.md_black_1000), 70));
        }
    }

    @Override
    public int getlayoutResID() {
        return R.layout.activity_splash_screen;
    }

    @Override
    public void setSystemUiVisibility(){
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }

    @Override
    public void callAnotherActivity(){
        startActivity(new Intent(SplashScreen.this, HomeScreen.class));
    }

    @Override
    public void finishActivity(){
        this.finish();
    }
}
