package br.com.caelum.testeviewpager.fragments;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import br.com.caelum.testeviewpager.R;

/**
 * Created by matheus on 09/11/15.
 */
public class Fragment3 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LinearLayout view = new LinearLayout(getActivity());
        ImageView imageView = new ImageView(getActivity());

        Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.caelum);
        bm = Bitmap.createScaledBitmap(bm, 300, 300, true);
        imageView.setImageBitmap(bm);
        view.addView(imageView);

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
        menu.close();
    }
}
