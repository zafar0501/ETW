package in.microlan.www.perfectmatrimony.common.validationMessage;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import in.microlan.www.perfectmatrimony.R;
import in.microlan.www.perfectmatrimony.common.presenter.IResultView;

public class ValidationAdapter extends RecyclerView.Adapter<ValidationAdapter.ValidationViewHolder> {

    private List<String> errorList = new ArrayList<>();
    private IResultView showErrorMessageListener;
    private Context context;

    public ValidationAdapter(Context context, List<String> errorList, IResultView showErrorMessage) {
        this.errorList = errorList;
        this.showErrorMessageListener = showErrorMessage;
        this.context = context;
    }

    @Override
    public ValidationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.validation_recycler_view_item_row, parent, false);

        ValidationViewHolder holder = new ValidationViewHolder(view);
        holder.textView_closeoption.setTag(holder);
        return holder;
    }

    @Override
    public void onBindViewHolder(ValidationViewHolder holder, int position) {
        String errorMessage = errorList.get(position);
        holder.textView_errormessage.setText(errorMessage);

        if (errorMessage.equalsIgnoreCase(AppsValidationMessage.fingerPrintAuthIdEnabled)) {
            holder.llItemRow.setBackgroundColor(ContextCompat.getColor(context, R.color.midGreen));
        } else if (errorMessage.equalsIgnoreCase(AppsValidationMessage.fingerPrintAuthDisabled)) {
            holder.llItemRow.setBackgroundColor(ContextCompat.getColor(context, R.color.gunMetal));
        } else {
            holder.llItemRow.setBackgroundColor(ContextCompat.getColor(context, R.color.tomato));
        }


    }

    @Override
    public int getItemCount() {
        if (errorList != null) {
            return errorList.size();
        } else {
            return 0;
        }
    }

    class ValidationViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textView_errormessage, textView_closeoption;
        LinearLayout llItemRow;

        ValidationViewHolder(View view) {
            super(view);
            llItemRow = view.findViewById(R.id.validation_linearlayout);
            textView_errormessage = view.findViewById(R.id.txt_validation_item_row_title);
            textView_closeoption = view.findViewById(R.id.txt_validation_item_row_close);
            textView_closeoption.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            if (errorList.size() > 0) {
                errorList.remove(getAdapterPosition());
                showErrorMessageListener.displayErrorList(errorList);
            }
        }
    }

}

