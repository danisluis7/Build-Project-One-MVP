package vuongluis.leafpic.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import vuongluis.leafpic.activities.SplashScreen.IScreenView;

/**
 * Created by vuongluis on 6/18/2017.
 */

public abstract class ThemeActivity extends AppCompatActivity implements IScreenView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getlayoutResID());
    }

    protected abstract void setStatusBarColor();

    protected abstract void setNavigationBar();
}
