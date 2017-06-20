package vuongluis.leafpic.model.album;

import android.database.Cursor;
import android.provider.MediaStore;
import android.provider.MediaStore.Audio.Media;

import java.util.ArrayList;

import vuongluis.leafpic.utils.StringUtils;

/**
 * Created by vuongluis on 6/19/2017.
 */

@SuppressWarnings("deprecation")
public class Album {

    // Attribute of class
    private String name, path;
    private long id = -1, dateModified;
    private int count = -1, currentMediaIndex = 0;

    private boolean selected = false;
    // public AlbumSettings settings;

    private ArrayList<Media> medias;

    private ArrayList<Media> selectedMedia;

    public Album(){}

    public Album(String path, String name) {

        // Initialize
        medias = new ArrayList<>();
        selectedMedia = new ArrayList<>();

        // Operatio
        this.path = path;
        this.name = name;
    }

    public Album(String path, String name, long id, int count) {
        this(path, name);
        this.id = id;
        this.count = count;
    }

    public Album(Cursor cursor) {
        /**
         * Sometime, we didn't get four all paramaters. I only transfer one paramater
         * to divide into four all paramaters.
         *
         * Notice: cursor.getString(3)
         * We need to have method to process data above.
         * So we create final class with method static and receive paramater above.
         * It's so easy for you to do that.
         *
         * Specify data belong to String => So we have StringUtils.
         */
         this(
                 StringUtils.getBucketPathByImagePath(cursor.getString(3)),
                 cursor.getString(1),
                 cursor.getLong(0),
                 cursor.getInt(2)
         );
    }

    /**
     * We are working with Album
     * - Access local memory in device to get data
     * - Knowing all attribute [information system] to do that
     */

    /**
     * How can do you understand code?
     * => you need to write Unit Test and test your code
     * => Especially, it helps all people understand. This looks like tutorial code
     * @return
     */
    public static String[] getProjection() {
        return new String[] {
            MediaStore.Files.FileColumns.PARENT,
            MediaStore.Images.Media.BUCKET_DISPLAY_NAME,
            "count(*)",
            MediaStore.Images.Media.DATA,
            "max(" + MediaStore.Images.Media.DATE_MODIFIED + ")"
        };
    }


}
