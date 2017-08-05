package subham.com.shuttlassignment.Adapters;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import subham.com.shuttlassignment.Activity.DetailedPostActivity;
import subham.com.shuttlassignment.Fragments.DateFragment;
import subham.com.shuttlassignment.MainActivity;
import subham.com.shuttlassignment.Model.Post;
import subham.com.shuttlassignment.R;

/**
 * Created by admin on 8/5/2017.
 */

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder>{
    ArrayList<Post> posts;
    Context context;
    FragmentManager fr;
    String time="";
    public PostAdapter(ArrayList<Post> posts, Context context,FragmentManager fr) {
        this.posts = posts;
        this.context = context;
        this.fr=fr;
    }

    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView=li.inflate(R.layout.list_post,parent,false);
        return new PostViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final PostViewHolder holder, int position) {
        final Post post=posts.get(position);
        if(position==0){


            holder.tvDate.setVisibility(View.VISIBLE);
            holder.tvDate.setText(post.getTime().toString().substring(0,10));

        }

        else if(!post.getTime().equals(posts.get(position-1).getTime())){
            holder.tvDate.setVisibility(View.VISIBLE);
            holder.tvDate.setText(post.getTime().toString().substring(0,10));
        }
        holder.tvTitle.setText(post.getTitle());
        if(post.getImageUrl().equals("")){
            holder.imgPost.getLayoutParams().height=0;
            holder.imgPost.getLayoutParams().width=0;
            holder.tvText.setTextSize(TypedValue.COMPLEX_UNIT_SP,22);
            holder.tvText.setText(post.getText());

        }
        else if(post.getText().equals("")){
            holder.imgPost.getLayoutParams().width= FrameLayout.LayoutParams.WRAP_CONTENT;
            holder.imgPost.getLayoutParams().height=FrameLayout.LayoutParams.WRAP_CONTENT;

            holder.tvText.setVisibility(View.GONE);


            Picasso.with(context).load(post.getImageUrl()).into(holder.imgPost);
        }
        else {
            holder.tvText.setText(post.getText());
            Picasso.with(context).load(post.getImageUrl()).fit().centerInside().into(holder.imgPost);
        }
        holder.tvName.setText("From "+post.getName());
        holder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, DetailedPostActivity.class);
                intent.putExtra("Title",post.getTitle());
                intent.putExtra("Name",post.getName());
                intent.putExtra("Text",post.getText());
                intent.putExtra("Description",post.getDescription());
                intent.putExtra("ImageUrl",post.getImageUrl());
                intent.putExtra("Like",post.getLike());
                intent.putExtra("Time",post.getTime().toString());
                context.startActivity(intent);
            }
        });

        if(post.getLike().equals("Like")){
            holder.btLike.setBackgroundColor(Color.parseColor("#33b5e5"));
            holder.btLike.setTextColor(Color.parseColor("#D3D3D3"));
            holder.btLike.setText("Unlike");

        }
        else{
            holder.btLike.setBackgroundColor(Color.parseColor("#D3D3D3"));
            holder.btLike.setTextColor(Color.parseColor("#33b5e5"));
            holder.btLike.setText("Like");


        }


        holder.btLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(holder.btLike.getText().equals("Like")){
                    holder.btLike.setBackgroundColor(Color.parseColor("#33b5e5"));
                    holder.btLike.setTextColor(Color.parseColor("#D3D3D3"));
                    holder.btLike.setText("Unlike");
                    post.setLike("Unlike");

                }
                else{
                    holder.btLike.setBackgroundColor(Color.parseColor("#D3D3D3"));
                    holder.btLike.setTextColor(Color.parseColor("#33b5e5"));
                    holder.btLike.setText("Like");
                    post.setLike("Like");


                }
            }
        });

        /*
        if(post.getLike().get(userId)== true){
            holder.btLike.setBackgroundColor(Color.parseColor("#33b5e5"));
            holder.btLike.setTextColor(Color.parseColor("#D3D3D3"));
            holder.btLike.setText("Unlike");
        }
        holder.btLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(post.getLike().get(userId)== true){
                    post.getLike().put(userId,false);
                }
                else {
                    post.getLike().put(userId, true);
                }
                DatabaseReference db= FirebaseDatabase.getInstance().getReference();
               db.child("Posts").child()
            }
        });
*/
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    class PostViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle,tvText,tvName,tvDate;
        ImageView imgPost;
        Button btLike;
        View rootView;

        public PostViewHolder(View itemView) {
            super(itemView);
            tvTitle= (TextView) itemView.findViewById(R.id.tvTitle);
            tvText= (TextView) itemView.findViewById(R.id.tvText);
            tvName= (TextView) itemView.findViewById(R.id.tvName);
            imgPost= (ImageView) itemView.findViewById(R.id.imgPostImg);
            btLike=(Button)itemView.findViewById(R.id.btLike);
            tvDate=(TextView) itemView.findViewById(R.id.tvDate);
            rootView=itemView;
//            rootView=itemView.findViewById(R.id.View);
        }
    }
}
