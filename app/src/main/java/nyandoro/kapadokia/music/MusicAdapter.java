package nyandoro.kapadokia.music;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MusicAdapter extends ArrayAdapter<Horizontal_music_list> {

    public MusicAdapter(Context context, ArrayList<Horizontal_music_list> musicList){

        //here we initialize the array adapter's internal storage for the context and the list.
        //The second argument is used when an array adapter is populating a single TextView,
        //because this is a custom adapter for two TextViews and ImageView, the adapter is not
        //going to use this second argument, thus it has no value, hence we use zero

        super(context,0, musicList);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;

        //check if a view is being reused, otherwise inflate the view
        if (listItemView ==null){

            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.horizontal_list_item,parent,false);
        }

      //get object located at this position in the list
        Horizontal_music_list currentPlaylistItem =getItem(position);

        //image init
        ImageView imageView =listItemView.findViewById(R.id.playlist_image);

        //check if the array contains image id, to prevent crashing
        if (currentPlaylistItem.hasImage()){
            //we get the image resource id from the adapter
            //then we set the id to the ImageView
            imageView.setImageResource(currentPlaylistItem.getImageResourceId());
        }
        else {
            //if the image is not there, we set the visibility marker to GONE
            imageView.setVisibility(View.GONE);
        }

        //textView init
        TextView textView = listItemView.findViewById(R.id.playlist_text);
        textView.setText(currentPlaylistItem.getPlaylistName());

        return listItemView;
    }
}
