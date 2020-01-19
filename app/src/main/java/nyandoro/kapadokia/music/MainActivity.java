package nyandoro.kapadokia.music;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ImageView imageView1;
    //set default love value
    int loveCount = 0;

    //global variable of mediaPlayer
    private MediaPlayer mediaPlayer;


    Button pause_button;
    Button play_button;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //pause button
       pause_button = findViewById(R.id.pause_button);
        play_button = findViewById(R.id.play_button);
         //media player file
        mediaPlayer = MediaPlayer.create(this, R.raw.alice_kimanzi);
        /**
         * handling playlist items
         * putting the information in a horizontal recycler adapter
         * get the custom data item that will display the information horizontally...
         * i.e, the playlist picture and its corresponding name
         */

        ArrayList<Horizontal_music_list> playlistItem = new ArrayList<>();
        playlistItem.add(new Horizontal_music_list("malibu",R.drawable.ngoma1));
        playlistItem.add(new Horizontal_music_list("perez",R.drawable.ngoma2));
        playlistItem.add(new Horizontal_music_list("matriano",R.drawable.ngoma3));
        playlistItem.add(new Horizontal_music_list("malibu",R.drawable.ngoma1));
        playlistItem.add(new Horizontal_music_list("perez",R.drawable.ngoma2));
        playlistItem.add(new Horizontal_music_list("matriano",R.drawable.ngoma3));

     MusicAdapter adapter = new MusicAdapter(this, playlistItem);
        ListView listView =findViewById(R.id.playlist_items);
        //set orientation to vertical

        listView.setAdapter(adapter);

    }


    //function to be performed when the love image is clicked
    public void favouriteMusic(View view) {

        imageView1 = findViewById(R.id.love_image);


          imageView1.setImageResource(R.drawable.ic_favorite);

          //add the value then set it to the textView
          loveCount++;
          TextView textView = findViewById(R.id.love_text);
          textView.setText("" +loveCount);



    }


    public void playButton(View view) {

        mediaPlayer.start();

        play_button.setVisibility(View.GONE);
        pause_button.setVisibility(View.VISIBLE);
    }

    public void pauseButton(View view) {


        mediaPlayer.pause();

        pause_button.setVisibility(View.GONE);
        play_button.setVisibility(View.VISIBLE);

    }
    public void seekBar (View view) {


        mediaPlayer.seekTo(10000);



    }
}

