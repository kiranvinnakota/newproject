package com.calibrage.a3ffarmerapp.Activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.calibrage.a3ffarmerapp.Adapters.LabourRecommendationAdapter;
import com.calibrage.a3ffarmerapp.Adapters.RecommendationAdapter;
import com.calibrage.a3ffarmerapp.Model.RecommendationModel;
import com.calibrage.a3ffarmerapp.R;

public class LabourRecommendationsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_labour_recommendations);
        RecommendationModel[] myListData = new RecommendationModel[] {
                new RecommendationModel("Plot252019","2 hectare ","Chinnakoduru","Near Shiavalayam"),
                new RecommendationModel("Plot242019","1 hectare  ","Dundigal","Opposite govt school"),
                new RecommendationModel("Plot232019","3 hectare ","Baswapur","Flowers market"),
                new RecommendationModel("Plot222019","4 hectare  ","Medipally","Main road"),

        };

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LabourRecommendationAdapter adapter = new LabourRecommendationAdapter(this,myListData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        DisplayActionBar();
    }
    private void DisplayActionBar() {
        final ActionBar abar = getSupportActionBar();
        abar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#2980B9")));
        // abar.setBackgroundDrawable(getResources().getDrawable(R.drawable.actionbar_background));//line under the action bar
        View viewActionBar = getLayoutInflater().inflate(R.layout.toolbar_all, null);
        ActionBar.LayoutParams params = new ActionBar.LayoutParams(//Center the textview in the ActionBar !
                ActionBar.LayoutParams.WRAP_CONTENT,
                ActionBar.LayoutParams.MATCH_PARENT,
                Gravity.CENTER);
        TextView textviewTitle = (TextView) viewActionBar.findViewById(R.id.custom_action_bar_title);
        textviewTitle.setText(R.string.labour);
/*        String header ="<b><font color='#1748DB'>" + getString(R.string.app_vzit) + "</font><b><font color='#32be16'>" + getString(R.string.app_doc) + "</font>";

        textviewTitle.setText(Html.fromHtml(header));*/

        abar.setCustomView(viewActionBar, params);
        abar.setDisplayShowCustomEnabled(true);
        abar.setDisplayShowTitleEnabled(false);

        abar.setDisplayHomeAsUpEnabled(true);

        abar.setHomeButtonEnabled(true);

        abar.show();

    }
}
