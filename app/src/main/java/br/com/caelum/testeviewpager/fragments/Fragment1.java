package br.com.caelum.testeviewpager.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import br.com.caelum.testeviewpager.MainActivity;
import br.com.caelum.testeviewpager.R;
import br.com.caelum.testeviewpager.application.MinhaApplication;

/**
 * Created by matheus on 03/11/15.
 */
public class Fragment1 extends Fragment {

    private ListView listView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment, container, false);

        listView = (ListView) view.findViewById(R.id.lista);

        MainActivity activity = (MainActivity) getActivity();

        MinhaApplication application = activity.getMinhaApplication();


        carregaLista(application.getIntegers());


        return view;
    }

    private void carregaLista(List<Integer> integers) {
        ArrayAdapter<Integer> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_expandable_list_item_1, integers);

        listView.setAdapter(adapter);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
        menu.close();
    }
}
