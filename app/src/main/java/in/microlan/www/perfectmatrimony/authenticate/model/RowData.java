package in.microlan.www.perfectmatrimony.authenticate.model;

import android.widget.ArrayAdapter;

import in.microlan.www.perfectmatrimony.utility.HelperUtility;

/**
 * Created by Shefali on 2/4/2016.
 */
public class RowData {
    int position;
    String key;
    String value;

    public RowData(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public RowData(int position, String value) {
        this.position = position;
        this.value = value;
    }

    public RowData(int position, String key, String value) {
        this.position = position;
        this.key = key;
        this.value = value;
    }





    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    public static RowData getSpinnerRowDataByValue(String state, ArrayAdapter<RowData> arrayAdapter) {
        if (HelperUtility.isBlank(state)) {
            return null;
        }
        if (arrayAdapter == null) {
            return null;
        }
        for (int i = 0; i < arrayAdapter.getCount(); i++) {
            if (arrayAdapter.getItem(i).getValue().equalsIgnoreCase(state)) {
                return arrayAdapter.getItem(i);
            }
        }
        return null;
    }

     public static RowData getSpinnerRowDataById(String state, ArrayAdapter<RowData> arrayAdapter) {
         if (HelperUtility.isBlank(state)) {
             return null;
         }
        for (int i = 0; i < arrayAdapter.getCount(); i++) {
            if (arrayAdapter.getItem(i).getKey().equalsIgnoreCase(state)) {
                return arrayAdapter.getItem(i);
            }
        }
        return null;
    }
}
