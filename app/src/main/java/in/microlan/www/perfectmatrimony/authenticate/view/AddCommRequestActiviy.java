package in.microlan.www.perfectmatrimony.authenticate.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import in.microlan.www.perfectmatrimony.R;
import in.microlan.www.perfectmatrimony.authenticate.model.RowData;
import in.microlan.www.perfectmatrimony.common.base.BaseActivity;

/**
 * Created by Shefali on 11/11/17.
 */

public class AddCommRequestActiviy extends BaseActivity implements View.OnClickListener {
    private Toolbar toolbar;
    private ImageView back_Img, ivShare;
    TextView toolbarTitle;
    private Spinner spinnerCategory, spinnerCountry, spinnerCity, spinnerState;
    ArrayList<RowData> arrLstCategory, arrLstCountry, arrLstCity, arrLstState;
    ArrayAdapter<RowData> arrAdapCategory, arrAdapCountry, arrAdapCity, arrAdapState;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        InitView();
    }

    @Override
    public void InitView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        back_Img = toolbar.findViewById(R.id.menu_back);
        ivShare = toolbar.findViewById(R.id.ivShare);
        toolbarTitle = toolbar.findViewById(R.id.toolbarTitle);

        spinnerCategory = (Spinner) findViewById(R.id.spinnerCategory);
        spinnerCountry = (Spinner) findViewById(R.id.spinnerCountry);
        spinnerCity = (Spinner) findViewById(R.id.spinnerCity);
        spinnerState = (Spinner) findViewById(R.id.spinnerState);
        arrLstCategory = new ArrayList<>();
        arrLstCountry = new ArrayList<>();
        arrLstCity = new ArrayList<>();
        arrLstState = new ArrayList<>();

        spinnerData();


        toolbarTitle.setText("Request Help");
        back_Img.setOnClickListener(this);
        ivShare.setVisibility(View.GONE);
    }

    private void spinnerData() {
        arrLstCategory.add(new RowData(0, "Category"));
        arrLstCategory.add(new RowData(1, "Category 1"));
        arrLstCategory.add(new RowData(2, "Category 2"));
        arrLstCategory.add(new RowData(3, "Category 3"));
        arrLstCategory.add(new RowData(4, "Category 4"));
        arrLstCategory.add(new RowData(5, "Category 5"));

        arrLstCountry.add(new RowData(0, "Country"));
        arrLstCountry.add(new RowData(1, "Country 1"));
        arrLstCountry.add(new RowData(2, "Country 2"));
        arrLstCountry.add(new RowData(3, "Country 3"));
        arrLstCountry.add(new RowData(4, "Country 4"));
        arrLstCountry.add(new RowData(5, "Country 5"));


        arrLstCity.add(new RowData(0, "City"));
        arrLstCity.add(new RowData(1, "City 1"));
        arrLstCity.add(new RowData(2, "City 2"));
        arrLstCity.add(new RowData(3, "City 3"));
        arrLstCity.add(new RowData(4, "City 4"));
        arrLstCity.add(new RowData(5, "City 5"));

        arrLstState.add(new RowData(0, "State "));
        arrLstState.add(new RowData(1, "State 1"));
        arrLstState.add(new RowData(2, "State 2"));
        arrLstState.add(new RowData(3, "State 3"));
        arrLstState.add(new RowData(4, "State 4"));
        arrLstState.add(new RowData(5, "State 5"));

        arrAdapCategory = new ArrayAdapter<RowData>(this, R.layout.simple_spinner_item, arrLstCategory);
        arrAdapCategory.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arrAdapCategory.notifyDataSetChanged();
        spinnerCategory.setAdapter(arrAdapCategory);
        spinnerCategory.setOnItemSelectedListener(categoryListener);

        arrAdapCountry = new ArrayAdapter<RowData>(this, R.layout.simple_spinner_item, arrLstCountry);
        arrAdapCountry.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arrAdapCountry.notifyDataSetChanged();
        spinnerCountry.setAdapter(arrAdapCountry);
        spinnerCountry.setOnItemSelectedListener(countryListener);

        arrAdapCity = new ArrayAdapter<RowData>(this, R.layout.simple_spinner_item, arrLstCity);
        arrAdapCity.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arrAdapCity.notifyDataSetChanged();
        spinnerCity.setAdapter(arrAdapCity);
        spinnerCity.setOnItemSelectedListener(countryListener);

        arrAdapState = new ArrayAdapter<RowData>(this, R.layout.simple_spinner_item, arrLstState);
        arrAdapState.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arrAdapState.notifyDataSetChanged();
        spinnerState.setAdapter(arrAdapState);
        spinnerState.setOnItemSelectedListener(countryListener);
    }

    private final AdapterView.OnItemSelectedListener categoryListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            String categoryKey = ((RowData) arrLstCategory.get(position)).getKey();
            String categoryValue = ((RowData) arrLstCategory.get(position)).getValue();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };
    private final AdapterView.OnItemSelectedListener countryListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            String categoryKey = ((RowData) arrLstCountry.get(position)).getKey();
            String categoryValue = ((RowData) arrLstCountry.get(position)).getValue();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_add_comm_help;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.menu_back:
                Intent intent = new Intent(AddCommRequestActiviy.this, NewsFeedActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
                AddCommRequestActiviy.this.finish();
                break;
        }
    }
}