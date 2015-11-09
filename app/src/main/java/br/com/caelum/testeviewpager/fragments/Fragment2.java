package br.com.caelum.testeviewpager.fragments;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import br.com.caelum.testeviewpager.MainActivity;
import br.com.caelum.testeviewpager.R;
import br.com.caelum.testeviewpager.adapter.MeuAdapter;
import br.com.caelum.testeviewpager.application.MinhaApplication;

/**
 * Created by matheus on 03/11/15.
 */
public class Fragment2 extends Fragment {

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public void setRecyclerView(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }

    public MinhaApplication getApplication() {
        return application;
    }

    public void setApplication(MinhaApplication application) {
        this.application = application;
    }

    public RecyclerView.LayoutManager getLayoutManager() {
        return layoutManager;
    }

    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        this.layoutManager = layoutManager;
    }

    public boolean isMeuBoolean() {
        return meuBoolean;
    }

    public void setMeuBoolean(boolean meuBoolean) {
        this.meuBoolean = meuBoolean;
    }

    private RecyclerView recyclerView;
    private MinhaApplication application;
    private RecyclerView.LayoutManager layoutManager;
    private boolean meuBoolean = true;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler_fragment, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        layoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(layoutManager);
        MainActivity activity = (MainActivity) getActivity();
        application = activity.getMinhaApplication();

        recyclerView.setAdapter(new MeuAdapter(application.getIntegers()));

        return view;
    }


}
