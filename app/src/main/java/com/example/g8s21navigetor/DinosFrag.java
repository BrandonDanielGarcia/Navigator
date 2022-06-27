package com.example.g8s21navigetor;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.g8s21navigetor.ui.MyAppAdapter;
import com.example.g8s21navigetor.ui.MyAppModel;
import com.example.g8s21navigetor.ui.ParseJson;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class DinosFrag extends Fragment {

    private DinosViewModel mViewModel;

    public static DinosFrag newInstance() {
        return new DinosFrag();
    }
    List<MyAppModel> list = new ArrayList<>();
    MyAppAdapter mAdapter;
    ParseJson parse;
    InputStream is;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        InputStream is = getResources().openRawResource(R.raw.dinos);
        try {
            // re = readJsonStream(is);
            parse = new ParseJson();
            list = parse.readJsonStream(is);
            mAdapter = new MyAppAdapter(DinosFrag.this.getContext(),R.layout.dino_rows,list);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return inflater.inflate(R.layout.dinos_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(DinosViewModel.class);
        // TODO: Use the ViewModel


    }

}