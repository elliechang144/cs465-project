package com.example.illinialertapp;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageButton;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.components.AxisBase;

import java.util.ArrayList;
import java.util.Map;

public class DataAnalysis extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_analysis);
        PieChart piechart = findViewById(R.id.pieChart);
        setupPieChart(piechart);

        BarChart barChart = findViewById(R.id.barChart);
        setupBarChart(barChart);

        ImageButton btnBack = findViewById(R.id.Backhome_data);
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
    private void setupBarChart(BarChart barChart) {
        Map<String, Integer> dataMap = DataManager.getTypeCount();
        ArrayList<BarEntry> entries = new ArrayList<>();
        final ArrayList<String> labels = new ArrayList<>();

        int index = 0;
        for (Map.Entry<String, Integer> entry: dataMap.entrySet())
        {
            entries.add(new BarEntry(index, entry.getValue()));
            labels.add(entry.getKey());
            index++;
        }

        BarDataSet dataSet = new BarDataSet(entries, "Data Set Label");
        dataSet.setColors(new int[] {
                Color.rgb(255, 216, 177),
                Color.rgb(255, 196, 140),
                Color.rgb(255, 171, 109),
                Color.rgb(255, 155, 89),
                Color.rgb(255, 127, 80),
                Color.rgb(255, 153, 102)
        });
        dataSet.setValueTextSize(14f);


        BarData barData = new BarData(dataSet);
        barChart.setData(barData);
        barChart.getDescription().setEnabled(false);


        YAxis leftAxis = barChart.getAxisLeft();
        leftAxis.setGranularity(1f);
        leftAxis.setGranularityEnabled(true);
        leftAxis.setAxisMinimum(0f);
        leftAxis.setAxisMaximum(10f);

        leftAxis.setValueFormatter(new ValueFormatter()
        {
            @Override
            public  String getAxisLabel(float value, AxisBase axis)
            {
                return  super.getAxisLabel(value,axis) + "uint";
            }

        });
        YAxis rightAxis = barChart.getAxisRight();
        rightAxis.setEnabled(false);

        XAxis xAxis = barChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1f);
        xAxis.setDrawAxisLine(true);
        xAxis.setDrawGridLines(false);
        xAxis.setLabelRotationAngle(-45);

        xAxis.setValueFormatter(new ValueFormatter()
        {
            @Override
            public  String getAxisLabel(float value, AxisBase axis)
            {
                return  labels.get((int) value);
            }

        });
        barChart.getLegend().setEnabled(false);
        barChart.invalidate();
    }

}

