package br.com.caelum.testeviewpager.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.caelum.testeviewpager.R;

/**
 * Created by matheus on 04/11/15.
 */
public class MeuAdapter extends RecyclerView.Adapter {

    private List<Integer> numeros;

    public MeuAdapter(List<Integer> numeros) {
        this.numeros = numeros;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista, parent, false);

        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.numero.setText(String.valueOf(numeros.get(position)));
    }

    @Override
    public int getItemCount() {
        return numeros.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView numero;

        public ViewHolder(View itemView) {
            super(itemView);

            numero = (TextView) itemView.findViewById(R.id.item);


        }
    }
}
