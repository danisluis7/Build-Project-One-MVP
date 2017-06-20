<p align="center">WELCOME TO LEARN AND DEVELOP ANDROID PROJECT</p>

- [Configurate Theme Full Screen](#configurate-theme-full-screen)
- [Configurate Icon Launch In Android](#configurate-icon-launch-in-android)
- [Configurate These Attributes In Android](#configurate-these-attributes-in-android)
- [Using class Abstract in Android](#using-class-abstract-in-android)
- [Where is place to check permission](#where-is-place-to-check-permission)


- [Get Album contain images](#get-album-contain-images)

## Configurate Theme Full Screen
    + Understand attribute: windowContentOverlay in android
<p align="center">
    <image src="https://github.com/danisluis7/Build-Project-One-MVP/blob/master/1.png" alt="1.png"/>
</p>
    + Understand attribute: windowNoTitle in android
<p align="center">
    <image src="https://github.com/danisluis7/Build-Project-One-MVP/blob/master/2.png" alt="2.png"/>
</p>

        <!-- Splash Screen Theme -->

        <style name="Theme.AppCompat.Light.NoActionBar.FullScreen" parent="Theme.AppCompat.Light">
            <item name="windowNoTitle">true</item>
            <item name="windowActionBar">false</item>
            <item name="android:windowFullscreen">true</item>
            <item name="android:windowContentOverlay">@null</item>
        </style>

## Configurate Icon Launch In Android
<p align="center">
    <image src="https://github.com/danisluis7/Build-Project-One-MVP/blob/master/ic_launch.png" alt="ic_launch.png"/>
</p>
<p align="center">
    <image src="https://github.com/danisluis7/Build-Project-One-MVP/blob/master/ic_launch.svg" alt="ic_launch.svg"/>
</p>
    + Both two files will be designed in AI with two format is .png and .svg
    + Put them into mindmap and test

## Configurate These Attributes In Android
<p align="center">
    <image src="https://github.com/danisluis7/Build-Project-One-MVP/blob/master/3.jpeg" alt="3.jpeg"/>
</p>

## Using class Abstract in Android

   + I wanna use method setStatusBar();
<p align="center">
    <image src="https://github.com/danisluis7/Build-Project-One-MVP/blob/master/4.png" alt="4.png"/>
</p>
<p align="center">
    <image src="https://github.com/danisluis7/Build-Project-One-MVP/blob/master/5.png" alt="5.png"/>
</p>
<p align="center">
    <image src="https://github.com/danisluis7/Build-Project-One-MVP/blob/master/6.png" alt="6.png"/>
</p>
<p align="center">
    <image src="https://github.com/danisluis7/Build-Project-One-MVP/blob/master/7.png" alt="7.png"/>
</p>

    + Set NavigationBarColor() or hidden it.
<p align="center">
    <image src="https://github.com/danisluis7/Build-Project-One-MVP/blob/master/8.png" alt="8.png"/>
</p>

## Where is place to check permission

    + isDeviceInfoGranted specify what is it?
<p align="center">
    <image src="https://github.com/danisluis7/Build-Project-One-MVP/blob/master/9.png" alt="9.png"/>
</p>

    + Final Class with method(static) to check permission and request permission for Activity

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

## Get Album contain images

    + Congifure IntentFilter() in ManifestAndroid.xml and put content is OPEN_ALBUM. It looks like below

            <intent-filter>
                <action android:name="com.horaapps.leafpic.OPEN_ALBUM" />
            </intent-filter>

    + Explaining

    // LINE 2 => Get data from other object INTENT

        - I'm creating an intent to transfer data from one activity to another like this :
            Intent intent = new Intent(this, ActivityHighScore.class);
            intent.putExtra("USERNAME", username);
            intent.putExtra("PLAYERMOVES", playerMoves);

            this.startActivity(intent);
        - Then i want to check if all of this data exists as the activity starts, as it can be started from other sources without this data being set. Im using this statement:
            Bundle bundle = getIntent().getExtras();
            if (!bundle.getString("USERNAME").equals(null) && bundle.getInt("PLAYERMOVES") != 0){
                String username = bundle.getString("USERNAME");
                int playerMoves = bundle.getInt("PLAYERMOVES");
                addHighScore(username, playerMoves);

            }

