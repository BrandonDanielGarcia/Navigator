package com.example.g8s21navigetor.ui;

import android.util.JsonReader;
import android.util.JsonToken;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ParseJson {
    public List<MyAppModel> readJsonStream(InputStream in) throws IOException {
        JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
        try {
            return readRecetasArray(reader);
        } finally {
            reader.close();
        }
    }

    public List<MyAppModel> readRecetasArray(JsonReader reader) throws IOException {
        List<MyAppModel> recetas = new ArrayList<MyAppModel>();

        reader.beginArray();
        while (reader.hasNext()) {
            recetas.add(readReceta(reader));
        }
        reader.endArray();
        return recetas;
    }

    public MyAppModel readReceta(JsonReader reader) throws IOException {
        String nombre = null, pronunciacion= null,significado= null,dieta= null,altura= null,periodo= null,mya= null,info= null;

        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("id")) {

            } else if (name.equals("name")) {
                nombre = reader.nextString();
            } else if (name.equals("pronunciation")) {
                pronunciacion = reader.nextString();
            } else if (name.equals("meaningOfName")) {
                significado = reader.nextString();
            } else if (name.equals("diet")) {
                dieta = reader.nextString();
            } else if (name.equals("length")) {
                altura = reader.nextString();
            } else if (name.equals("period")) {
                periodo = reader.nextString();
            } else if (name.equals("mya")) {
                mya = reader.nextString();
            } else if (name.equals("info") && reader.peek() != JsonToken.NULL) {
                info = reader.nextString();
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return new MyAppModel(nombre, pronunciacion,significado,dieta,altura,periodo,mya,info);
    }
}
