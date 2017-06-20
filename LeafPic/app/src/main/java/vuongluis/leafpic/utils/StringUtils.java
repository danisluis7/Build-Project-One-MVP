package vuongluis.leafpic.utils;

/**
 * Created by vuongluis on 6/19/2017.
 */

public final class StringUtils {

    // The data isn't format string or we need to get right data
    public static String getBucketPathByImagePath(String path) {
        /**
         * Give me an example with path
         * Ex: C:\Users\vuongluis\Documents\Build-Project-One-MVP
         */
        String splitDirSystemPath[] = path.split("/");
        String temp = "";
        for (int i = 0; i < splitDirSystemPath.length - 1; i++)
            temp += splitDirSystemPath[i] + "/";
        temp = temp.substring(0, splitDirSystemPath.length - 1);
        return temp;
    }
}
