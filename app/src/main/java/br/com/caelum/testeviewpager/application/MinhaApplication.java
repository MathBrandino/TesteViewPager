package br.com.caelum.testeviewpager.application;

import android.app.Application;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by matheus on 04/11/15.
 */
public class MinhaApplication extends Application {

    private List<Integer> integers;

    public MinhaApplication() {
        integers = new ArrayList<>();
    }

    public List<Integer> getIntegers() {
        Log.i("tamanha", "" + integers.size());
        return integers;
    }


}
