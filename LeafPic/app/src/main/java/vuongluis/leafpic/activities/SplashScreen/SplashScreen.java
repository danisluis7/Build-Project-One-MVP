package vuongluis.leafpic.activities.SplashScreen;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.widget.ImageView;

import butterknife.BindView;
import vuongluis.leafpic.R;
import vuongluis.leafpic.activities.SharedMediaActivity;
import vuongluis.leafpic.activities.ThemeActivity;
import vuongluis.leafpic.utils.ColorPalette;

public class SplashScreen extends SharedMediaActivity implements IScreenView {

    @BindView(R.id.activity_splash_screen_logo)
    ImageView imgLogo;

    @BindView(R.id.activity_splash_screen_title)
    ImageView txtTitle;

    @BindView(R.id.activity_splash_screen_loading)
    ImageView txtLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setNavigationBar();
        setStatusBarColor();
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
}
