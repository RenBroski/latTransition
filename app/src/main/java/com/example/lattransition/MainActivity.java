package com.example.lattransition;

import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    Button button;
    int currentImageIndex = 0; // Menyimpan indeks gambar saat ini

    // Array untuk menyimpan drawable gambar
    int[] images = {R.drawable.trans_bapa, R.drawable.trans_mama, R.drawable.trans_kakak};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        button = findViewById(R.id.button);

        // Mengatur gambar pertama di ImageView
        imageView.setImageResource(images[currentImageIndex]);

        button.setOnClickListener(v -> {
            // Hitung indeks gambar berikutnya
            currentImageIndex = (currentImageIndex + 1) % images.length; // Berputar dalam array

            // Atur gambar ke ImageView dengan transisi
            imageView.setImageResource(images[currentImageIndex]);
            ((TransitionDrawable) imageView.getDrawable()).startTransition(3000); // 3 detik transisi
        });
    }
}
