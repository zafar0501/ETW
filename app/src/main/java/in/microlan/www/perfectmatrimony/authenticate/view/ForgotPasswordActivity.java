package in.microlan.www.perfectmatrimony.authenticate.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;

import java.util.List;

import in.microlan.www.perfectmatrimony.R;
import in.microlan.www.perfectmatrimony.common.base.BaseActivity;
import in.microlan.www.perfectmatrimony.common.presenter.IResultView;
import in.microlan.www.perfectmatrimony.common.validationMessage.ValidationAdapter;
import in.microlan.www.perfectmatrimony.common.validationMessage.ValidationManager;


public class ForgotPasswordActivity extends BaseActivity implements IResultView, View.OnClickListener {
    private Context context = ForgotPasswordActivity.this;
    private Button btn_forgot;
    private EditText edt_mble_num, edt_mble_otp;
    //For the Validation we use Recycleview & ScrollView for UI Display
    private RecyclerView rcvValidationMessage;
    private ScrollView scvloginScroll;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        InitView();
    }

    @Override
    public void InitView() {

        edt_mble_num = (EditText) findViewById(R.id.edt_mobile_number);
        edt_mble_otp = (EditText) findViewById(R.id.edt_mobile_otp);
        btn_forgot = (Button) findViewById(R.id.btn_forgot);

        btn_forgot.setOnClickListener(this);

        //Initialization of Validation instance
        ValidationManager.getValidationMessageInstance();

        scvloginScroll = (ScrollView) findViewById(R.id.scv_fpassword_scroll);


        rcvValidationMessage = ValidationManager.setValidationRecyclerView(this);

        //On basis of server message, get will pass the custom code in the method
        // new ValidationManager().setValidationError(ErrorMessageUtility.getCustomErrorCode(AppsValidationMessage.ICommonError.NO_INTERNET), this);


    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_forgot_password;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return false;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_forgot: {
                startActivity(new Intent(context, LoginActivity.class));
                finish();

            }
            break;
        }
    }

    @Override
    public void showResult(Object listDO) {

    }

    @Override
    public void onDisplayMessage(String message) {

    }

    @Override
    public void showResultList(List resultDOList) {

    }

    @Override
    public void displayErrorList(List errorList) {
        ValidationAdapter validationAdapter = new ValidationAdapter(errorList, this);
        rcvValidationMessage.setAdapter(validationAdapter);
        scvloginScroll.scrollTo(0, 0);
        validationAdapter.notifyDataSetChanged();
    }
}
