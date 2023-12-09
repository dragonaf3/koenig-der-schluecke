package com.example.koenigderschluecke.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import com.example.koenigderschluecke.R;
import com.example.koenigderschluecke.model.Karte;

import java.util.List;

public class KartenStapelView extends View {

    private List<Karte> kartenStapel;
    private Bitmap kartenBild;

    public KartenStapelView(Context context, AttributeSet attrs) {
        super(context, attrs);
        kartenBild = BitmapFactory.decodeResource(getResources(), R.drawable.bier);

        int gewuenschteBreite = 90; // Beispielsweise 100 Pixel
        int gewuenschteHoehe = 140; // Beispielsweise 150 Pixel

        kartenBild = Bitmap.createScaledBitmap(kartenBild, gewuenschteBreite, gewuenschteHoehe, false);

    }

    public void setKartenStapel(List<Karte> kartenStapel) {
        this.kartenStapel = kartenStapel;
        invalidate(); // Zeichnet die Ansicht neu
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        int radius = Math.min(getWidth(), getHeight()) / 3;

        for (int i = 0; i < kartenStapel.size(); i++) {
            double winkel = 2 * Math.PI * i / kartenStapel.size();
            int x = centerX + (int) (radius * Math.cos(winkel)) - (kartenBild.getWidth() / 2);
            int y = centerY + (int) (radius * Math.sin(winkel)) - (kartenBild.getHeight() / 2);

            canvas.drawBitmap(kartenBild, x, y, null);
        }
    }
}
