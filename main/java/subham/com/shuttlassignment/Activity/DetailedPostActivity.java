package subham.com.shuttlassignment.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import subham.com.shuttlassignment.Model.Post;
import subham.com.shuttlassignment.R;

public class DetailedPostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_post);

        Intent i = this.getIntent();
        TextView title=(TextView)findViewById(R.id.title);
        title.setText(i.getStringExtra("Title"));
        TextView name=(TextView)findViewById(R.id.name);
        name.setText("From : "+i.getStringExtra("Name"));
        TextView name1=(TextView)findViewById(R.id.name1);
        name1.setText(i.getStringExtra("Name"));

        TextView time=(TextView)findViewById(R.id.date);
        time.setText(i.getStringExtra("Time"));

        final Button btLike= (Button) findViewById(R.id.btLike);

        TextView description=(TextView)findViewById(R.id.description);
        description.setText(i.getStringExtra("Description"));
        if(i.getStringExtra("Like").equals("Like")){
            btLike.setBackgroundColor(Color.parseColor("#33b5e5"));
            btLike.setTextColor(Color.parseColor("#D3D3D3"));
            btLike.setText("Unlike");

        }
        else{
            btLike.setBackgroundColor(Color.parseColor("#D3D3D3"));
            btLike.setTextColor(Color.parseColor("#33b5e5"));
            btLike.setText("Like");


        }

        btLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btLike.getText().equals("Like")){
                    btLike.setBackgroundColor(Color.parseColor("#33b5e5"));
                    btLike.setTextColor(Color.parseColor("#D3D3D3"));
                    btLike.setText("Unlike");

                }
                else{
                    btLike.setBackgroundColor(Color.parseColor("#D3D3D3"));
                    btLike.setTextColor(Color.parseColor("#33b5e5"));
                    btLike.setText("Like");



                }
            }
        });



        ImageView image=(ImageView)findViewById(R.id.image);



        Log.d("Image==","=="+i.getStringExtra("ImageUrl"));
        if(i.getStringExtra("ImageUrl").equals("") || i.getStringExtra("ImageUrl").equals(null)){
            image.setVisibility(View.GONE);

        }else {
            Picasso.with(this).load(i.getStringExtra("ImageUrl")).fit().centerInside().into(image);
        }
    }
}
