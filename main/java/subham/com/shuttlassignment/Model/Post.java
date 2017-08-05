package subham.com.shuttlassignment.Model;

import java.util.Date;
import java.util.HashMap;

/**
 * Created by admin on 8/5/2017.
 */

public class Post {
    String name;
    String imageUrl;
    String title;
    String text;
    Date time;
    String description;
    String like;
    //HashMap<String,Boolean> like;



    public Post(String name, String imageUrl, String title, String text, Date time, String description,String like) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.title = title;
        this.text = text;
        this.time = time;
        this.description = description;
        this.like = "Like";
    }

    public String getName() {

        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public Date getTime() {
        return time;
    }

    public String getDescription() {
        return description;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like=like;

    }


}
