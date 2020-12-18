package com.example.devocional.ui;

import android.content.Context;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;
import android.widget.Toast;

import com.example.devocional.MainActivity;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class Archive {
    public static void deArray_Archivo(ArrayList<String> people, Context ctx) {
        FileOutputStream fos = null;
        try {
            fos = ctx.openFileOutput(MainActivity.FILE_NAME, MODE_PRIVATE);
            for (String p : people) {
                String coma = p+",";
                fos.write(coma.getBytes());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static ArrayList<String> deArchivo_Array(Context ctx) {
        ArrayList<String> re = new ArrayList<>();
        FileInputStream fis = null;
        try {
            fis = ctx.openFileInput(MainActivity.FILE_NAME);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;
            text = br.readLine();
            if(text != null){
                String[] aja = text.toString().split(",");
                for (String s: aja) {
                    re.add(s);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return re;
    }
}
