package vuongluis.leafpic.utils;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by vuongluis on 6/18/2017.
 */

public final class PermissionUtils {

    // Indirectly to check permission from Activity
    public static boolean isDeviceInfoGranted (Context context) {
        return checkPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE);
    }

    private static boolean checkPermission (Context context, String permission) {
        return ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED;
    }

    /**
     * Directly to check permission from Activity
     * ... => difference with another method, represent an array methods
     */
    public static boolean checkPermission (Context context, String... permissions){
        for (String permission : permissions) {
            if (!checkPermission(context, permission)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Request permission
     */
    public static void requestPermission (Object o, int permissionId, String... permissions) {
        if (o instanceof Activity) {
            ActivityCompat.requestPermissions((AppCompatActivity) o, permissions, permissionId);
        }
    }
}
