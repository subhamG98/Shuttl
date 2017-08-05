package subham.com.shuttlassignment.Activity;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import subham.com.shuttlassignment.Adapters.PostAdapter;
import subham.com.shuttlassignment.Model.Post;
import subham.com.shuttlassignment.R;

public class FeedActivity extends AppCompatActivity {
    RecyclerView rvPosts;
    ArrayList<Post> posts=new ArrayList<>();
    DatabaseReference mdatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
        posts.add(new Post("John","https://www.holidify.com/images/compressed/4709.jpg","People","Lorem ipsum dolor sit and because complete it.",new Date(1501909233855l),"Lorem ipsum dolor sit and because complete it.Lorem ipsum dolor sit and because complete it.Lorem ipsum dolor sit and because complete it.Lorem ipsum dolor sit and because complete it.","Like"));
        posts.add(new Post("Happen","","Quote","You have to make it happen!",new Date(1501577379000l),"Lorem ipsum dolor sit and because complete it.Lorem ipsum dolor sit and because complete it.Lorem ipsum dolor sit and because complete it.Lorem ipsum dolor sit and because complete it.","Like"));
        posts.add(new Post("Sierra","http://thewirecutter.com/wp-content/uploads/2016/09/sierra-blog-lede-630.jpg","People","Lorem ipsum dolor sit and because complete it.",new Date(1501577379000l),"Lorem ipsum dolor sit and because complete it.Lorem ipsum dolor sit and because complete it.Lorem ipsum dolor sit and because complete it.Lorem ipsum dolor sit and because complete it.","Like"));
        posts.add(new Post("Gupta","http://thewirecutter.com/wp-content/uploads/2016/09/sierra-blog-lede-630.jpg","Place","",new Date(1501909233855l),"dwhhlfdoisdibkacsgsda","Like"));
        FragmentManager fr=getSupportFragmentManager();
        rvPosts=(RecyclerView)findViewById(R.id.rvPosts);
        rvPosts.setLayoutManager(new LinearLayoutManager(this));
        Collections.sort(posts, new Comparator<Post>() {
            public int compare(Post o1, Post o2) {
                if (o1.getTime() == null || o2.getTime() == null)
                    return 0;
                return o1.getTime().compareTo(o2.getTime());
            }
        });


        final PostAdapter postAdapter= new PostAdapter(posts,this,fr);
        rvPosts.setAdapter(postAdapter);
        String data="";


//        mdatabase= FirebaseDatabase.getInstance().getReference();
//        mdatabase.child("Posts").addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
//                String postid=dataSnapshot.getKey();
//                Post post=dataSnapshot.getValue(Post.class);
//                posts.add(0,post);
//                postAdapter.notifyDataSetChanged();
//                progressDialog.dismiss();
//            }
//
//            @Override
//            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
//
//            }
//
//            @Override
//            public void onChildRemoved(DataSnapshot dataSnapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
//
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });

    }
}
