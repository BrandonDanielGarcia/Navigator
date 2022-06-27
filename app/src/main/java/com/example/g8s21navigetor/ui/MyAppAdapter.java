package com.example.g8s21navigetor.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.g8s21navigetor.R;

import java.util.List;

public class MyAppAdapter extends ArrayAdapter<MyAppModel> {
    private List<MyAppModel> mList;
    private Context mContext;
    private int resourceLayout;

    public MyAppAdapter(@NonNull Context context, int resource, List<MyAppModel> objects) {
        super(context, resource, objects);
        this.mList = objects;
        this.mContext = context;
        this.resourceLayout = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if(view == null){
            view = LayoutInflater.from(mContext).inflate(resourceLayout,null);

        }

        MyAppModel modelo =  mList.get(position);
        TextView nombre = view.findViewById(R.id.txtNombre);
        nombre.setText(modelo.getNombre());
        TextView pronunciacion = view.findViewById(R.id.txtPronunciacion);
        pronunciacion.setText(modelo.getPronunciacion());
        TextView significado = view.findViewById(R.id.txtSignificado);
        significado.setText(modelo.getSignificado());
        TextView dieta = view.findViewById(R.id.txtDieta);
        dieta.setText(modelo.getDieta());
        TextView altura = view.findViewById(R.id.txtAltura);
        altura.setText(modelo.getAltura());
        TextView periodo = view.findViewById(R.id.txtPeriodo);
        periodo.setText(modelo.getPeriodo());
        TextView mya = view.findViewById(R.id.txtMya);
        mya.setText(modelo.getMya());
        TextView info = view.findViewById(R.id.txtInfo);
        info.setText(modelo.getInfo());
        return view;
    }
}
