package com.example.koenigderschluecke.network;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PixelFormat;
import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import android.media.Image;
import android.media.ImageReader;
import android.media.projection.MediaProjection;
import android.os.Handler;
import android.os.HandlerThread;

import java.nio.ByteBuffer;

public class ScreenCapture {

    private MediaProjection mediaProjection;
    private VirtualDisplay virtualDisplay;
    private ImageReader imageReader;
    private Handler backgroundHandler;
    private HandlerThread handlerThread;

    public ScreenCapture(Context context, MediaProjection mediaProjection) {
        this.mediaProjection = mediaProjection;
        handlerThread = new HandlerThread("ScreenCaptureThread");
        handlerThread.start();
        backgroundHandler = new Handler(handlerThread.getLooper());
        imageReader = ImageReader.newInstance(1280, 720, PixelFormat.RGBA_8888, 2);

        virtualDisplay = mediaProjection.createVirtualDisplay("ScreenCapture",
                1280, 720, context.getResources().getDisplayMetrics().densityDpi,
                DisplayManager.VIRTUAL_DISPLAY_FLAG_AUTO_MIRROR,
                imageReader.getSurface(), null, backgroundHandler);
    }

    public void startCapture(OnImageCapturedListener listener) {
        imageReader.setOnImageAvailableListener(reader -> {
            Image image = reader.acquireLatestImage();
            if (image != null) {
                Image.Plane[] planes = image.getPlanes();
                ByteBuffer buffer = planes[0].getBuffer();
                int width = image.getWidth();
                int height = image.getHeight();
                Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                bitmap.copyPixelsFromBuffer(buffer);
                image.close();
                listener.onImageCaptured(bitmap);
            }
        }, backgroundHandler);
    }

    public interface OnImageCapturedListener {
        void onImageCaptured(Bitmap bitmap);
    }

    public void stopCapture() {
        virtualDisplay.release();
        imageReader.setOnImageAvailableListener(null, null);
        handlerThread.quitSafely();
    }
}

