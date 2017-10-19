package in.microlan.www.perfectmatrimony.common.validationMessage;

import android.app.Activity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

import in.microlan.www.perfectmatrimony.common.presenter.IResultView;
import in.microlan.www.perfectmatrimony.utility.ErrorMessageUtility;


public class ValidationManager {

    private static List<String> validationModelList = null;
    private static ValidationManager validationManager = null;

    public static ValidationManager getValidationMessageInstance() {

        if (validationManager == null) {
            validationManager = new ValidationManager();
            validationModelList = new ArrayList<>();
        }
        return validationManager;
    }

    public static RecyclerView setValidationRecyclerView(Activity activity, int rcvErrorListId) {

        RecyclerView recyclerView = activity.findViewById(rcvErrorListId);

        LinearLayoutManager errorLinearLayoutManager = new LinearLayoutManager(activity);
        errorLinearLayoutManager.setReverseLayout(true);
        errorLinearLayoutManager.setStackFromEnd(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), errorLinearLayoutManager.getOrientation()));
        recyclerView.setLayoutManager(errorLinearLayoutManager);
        recyclerView.setVisibility(View.VISIBLE);
        return recyclerView;
    }

    public static RecyclerView setValidationRecyclerView(Activity activity, RecyclerView recyclerView) {

        LinearLayoutManager errorLinearLayoutManager = new LinearLayoutManager(activity);
        errorLinearLayoutManager.setReverseLayout(true);
        errorLinearLayoutManager.setStackFromEnd(true);
        //recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), errorLinearLayoutManager.getOrientation()));
        recyclerView.setLayoutManager(errorLinearLayoutManager);
        recyclerView.setVisibility(View.VISIBLE);
        return recyclerView;
    }

    public void setValidationError(int customErrorCode, IResultView showErrorMessageListener) {

        //on basis of custom code, we will fetch the user defined message in the list
        String message = ErrorMessageUtility.getUserDefinedMessage(customErrorCode);

        if (message == null) {
            showErrorMessageListener.displayErrorList(validationModelList);
        } else {
            validationModelList.remove(message);
            validationModelList.add(message);
            if (validationModelList.size() > 3) {
                //remove the 3rd position
                validationModelList.remove(0);
            }
            showErrorMessageListener.displayErrorList(validationModelList);
        }
    }

    public static void clearValidationMessageList(boolean isClear) {
        if (isClear) {
            if (validationModelList != null)
                validationModelList.clear();
        }
    }

    public static boolean isErrorListHasError() {

        return validationModelList != null && validationModelList.size() > 0;
    }

    public static void DisplayValidationError(IResultView showErrorMessageListener) {
        showErrorMessageListener.displayErrorList(validationModelList);
    }

    public static List<String> getErrorMessageList() {
        return validationModelList;
    }

}
