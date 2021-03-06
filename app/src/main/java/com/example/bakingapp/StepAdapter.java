package com.example.bakingapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bakingapp.data.Step;

import java.util.List;

public class StepAdapter extends RecyclerView.Adapter<StepAdapter.StepHolder> {

    private List<Step> mSteps;
    private RecyclerClickListener mListener;

    public StepAdapter(List<Step> steps, RecyclerClickListener listener ) {
        mSteps = steps;
        mListener = listener;
    }

    @NonNull
    @Override
    public StepHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_step, parent, false);

        return new StepHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull StepHolder holder, int position) {
        Step step = mSteps.get(position);
        String shortDescription = mSteps.get(position).getShortDescription();
        holder.setShortDescription(shortDescription);
    }

    @Override
    public int getItemCount() {
        return mSteps.size();
    }

    public class StepHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private RecyclerClickListener mRecyclerClickListener;
        private TextView mStepTextView;

        StepHolder(View itemView, RecyclerClickListener listener) {
            super(itemView);
            mRecyclerClickListener = listener;
            mStepTextView = itemView.findViewById(R.id.step_text_view);
            mStepTextView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            mRecyclerClickListener.onClick(v, getAdapterPosition());
        }

        public void setShortDescription(String description) {
            mStepTextView.setText(description);
        }
    }
}
