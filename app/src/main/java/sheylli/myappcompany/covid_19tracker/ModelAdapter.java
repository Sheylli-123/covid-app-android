package sheylli.myappcompany.covid_19tracker;




import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ModelAdapter extends RecyclerView.Adapter<ModelAdapter.ViewHolder>{

    @NonNull
    private ArrayList<Model>modelArrayList;
    private Context context;
    public ModelAdapter(@NonNull ArrayList<Model>statemodelArrayList, Context context){
        this.modelArrayList=statemodelArrayList;
        this.context=context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.testing,parent,false);
        return new ModelAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  ViewHolder holder, int position) {
        Model model=modelArrayList.get(position);

        holder.listState.setText(model.getSname());
        holder.listDistrict.setText(model.getDname());
        holder.Activecases.setText(String.valueOf(model.getActive()));
        holder.Confirmedcases.setText(String.valueOf(model.getConfirmed()));
        holder.Deceasedcases.setText(String.valueOf(model.getDeceased()));
        holder.Recoveredcases.setText(String.valueOf(model.getRecovered()));


    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView listState;
        TextView listDistrict;
        TextView Activecases;
        TextView Confirmedcases;
        TextView Recoveredcases;
        TextView Deceasedcases;

        public ViewHolder(@NonNull  View itemView) {
            super(itemView);

            listState = itemView.findViewById(R.id.listState);
            listDistrict = itemView.findViewById(R.id.listdistrict);
            Activecases = itemView.findViewById(R.id.Activecases);
            Confirmedcases = itemView.findViewById(R.id.Confirmedcases);
            Recoveredcases = itemView.findViewById(R.id.Recoveredcases);
            Deceasedcases = itemView.findViewById(R.id.Deceasedcases);

        }
    }
}

