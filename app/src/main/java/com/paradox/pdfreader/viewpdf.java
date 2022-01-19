package com.paradox.pdfreader;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;

public class viewpdf extends AppCompatActivity {


    PDFView pdfView;
    int position = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpdf);

        pdfView = (PDFView) findViewById(R.id.pdfView2);

        position= getIntent().getIntExtra("position",-1);


        displayPDF();
    }

    private void displayPDF() {

        pdfView.fromFile(MainActivity.fileList.get(position))
                .enableSwipe(true)
                .swipeHorizontal(false)
                .enableAnnotationRendering(true)
                .scrollHandle(new DefaultScrollHandle(this))
                .load();
    }
}