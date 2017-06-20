package vuongluis.leafpic;

import android.provider.MediaStore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import vuongluis.leafpic.model.album.Album;

/**
 * Created by vuongluis on 6/20/2017.
 */

public class AndroidAlbumTest {

    // Attribute of class
    private String name, path;
    private long id = -1, dateModified;
    private int count = -1, currentMediaIndex = 0;

    private boolean selected = false;
    // public AlbumSettings settings;

    private ArrayList<MediaStore.Audio.Media> medias;

    private ArrayList<MediaStore.Audio.Media> selectedMedia;

    private Album albums;

    @Before
    public void setUp() throws Exception {
        albums = new Album();
    }

    @Test
    public void shouldShowValueWhenGetProjection() throws Exception {
        System.out.println("Paramater 1:" +Album.getProjection()[0]);
        System.out.println("Paramater 2:" +Album.getProjection()[1]);
        System.out.println("Paramater 3:" +Album.getProjection()[2]);
        System.out.println("Paramater 4:" +Album.getProjection()[3]);
        System.out.println("Paramater 5:" +Album.getProjection()[4]);
    }

    @Test
    public void checkValueWhenGetProjection() throws Exception {
        Assert.assertEquals("parent",Album.getProjection()[0]);
        Assert.assertEquals("bucket_display_name",Album.getProjection()[1]);
        Assert.assertEquals("count(*)",Album.getProjection()[2]);
        Assert.assertEquals("_data",Album.getProjection()[3]);
        Assert.assertEquals("max(date_modified)",Album.getProjection()[4]);
    }
}

