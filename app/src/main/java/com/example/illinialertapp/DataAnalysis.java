package com.example.illinialertapp;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.charts.PieChart;
import java.util.Map;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;



import java.util.ArrayList;
public class DataAnalysis extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_analysis);
        PieChart piechart = findViewById(R.id.pieChart);
        setupPieChart(piechart);

        Button btnBack = findViewById(R.id.Backhome_data);
        btnBack.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                finish();
            }
        });
    }
    private void setupPieChart(PieChart piechart)
    {
        Map<String, Integer> typeCount = DataManager.getTypeCount();
        ArrayList<PieEntry> entries = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : typeCount.entrySet())
        {
            entries.add(new PieEntry(entry.getValue(), entry.getKey()));
        }

        PieDataSet dataSet = new PieDataSet(entries, "Incident Types");
        //int[] colors = new int[] { Color., Color.MAGENTA, Color.GREEN, Color.BLUE, Color.BLUE, Color.YELLOW};
        int[] colors = new int[]
                {Color.rgb(255, 216, 177),
                        Color.rgb(255, 196, 140),
                        Color.rgb(255, 171, 109),
                        Color.rgb(255, 155, 89),
                        Color.rgb(255, 127, 80),
                        Color.rgb(255, 153, 102)};
        dataSet.setColors(colors);
        dataSet.setValueTextSize(14f);
        PieData pieData = new PieData(dataSet);
        piechart.setData(pieData);
        piechart.getDescription().setEnabled(false);
        piechart.invalidate();
    }
}

