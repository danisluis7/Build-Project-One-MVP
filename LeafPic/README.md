<p align="center">WELCOME TO LEARN AND DEVELOP ANDROID PROJECT</p>

- [Configurate Theme Full Screen](#configurate-theme-full-screen)

## Configurate Theme Full Screen
    + Understand attribute: windowContentOverlay in android
<p align="center">
    <image src="" alt="1.png"/>
</p>
    + Understand attribute: windowNoTitle in android
<p align="center">
    <image src="" alt="2.png"/>
</p>
    + The result show below
<p align="center">
    <image src="" alt="3.png"/>
</p>

        <!-- Splash Screen Theme -->

        <style name="Theme.AppCompat.Light.NoActionBar.FullScreen" parent="Theme.AppCompat.Light">
            <item name="windowNoTitle">true</item>
            <item name="windowActionBar">false</item>
            <item name="android:windowFullscreen">true</item>
            <item name="android:windowContentOverlay">@null</item>
        </style>