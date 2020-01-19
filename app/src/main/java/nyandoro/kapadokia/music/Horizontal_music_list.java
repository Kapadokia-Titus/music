package nyandoro.kapadokia.music;

import android.widget.ImageView;
import android.widget.TextView;

public class Horizontal_music_list {

    //variable inits
    private String name;
    private int imageResourceId = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED= -1;


    //create a an empty constructor with no parameters to allow access to this class

    public Horizontal_music_list(){

    }

    //an overloaded constructor to accept parameter inputs
    public Horizontal_music_list(String Musicname, int imageView){

        name = Musicname;
        this.imageResourceId = imageView;
    }

    public String getPlaylistName() {
        return name;
    }

    public void setPlaylistName(String name) {
        this.name = name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageView) {
        this.imageResourceId = imageView;
    }

    public boolean hasImage(){
        return imageResourceId !=NO_IMAGE_PROVIDED;
    }
}
