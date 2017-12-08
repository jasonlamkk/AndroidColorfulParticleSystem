package com.github.cleonids;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;

import com.github.cleonids.modifiers.ParticleModifier;

import java.util.List;

public class Particle {

    public static final int RGB_MAX = 255;
    public static final int ALPHA_MAX = 255;
    public float mCurrentX;
    public float mCurrentY;
    public float mScale = 1f;
    public int mAlpha = 255;
    public float startScale = 1f;//added
    public float endScale = 1f;//added
    public int startSize = 0;//added
    public int endSize = 0;//added
    public float mInitialRotation = 0f;
    public float mRotationSpeed = 0f;
    public float mSpeedX = 0f;
    public float mSpeedY = 0f;
    public float mAccelerationX;
    public float mAccelerationY;
    public int startRed;
    public int startGreen;
    public int startBlue;
    public int endRed;
    public int endGreen;
    public int endBlue;
    public int redValue;
    public int greenValue;
    public int blueValue;
    public int startAlpha;
    public int endAlpha;
    public boolean hasColorFilter = false;
    protected Bitmap mImage;
    protected long mStartingMillisecond;
    private Matrix mMatrix;
    private Paint mPaint;
    private float mInitialX;
    private float mInitialY;
    private float mRotation;
    private long mTimeToLive;
    private int mBitmapHalfWidth;
    private int mBitmapHalfHeight;
    private List<ParticleModifier> mModifiers;
    private PorterDuffColorFilter filter = null;//new PorterDuffColorFilter(Color.rgb(0,0,0), PorterDuff.Mode.SRC_ATOP);

    protected Particle() {
        mMatrix = new Matrix();
        mPaint = new Paint();

        startRed = RGB_MAX;
        startGreen = RGB_MAX;
        startBlue = RGB_MAX;
        endRed = RGB_MAX;
        endGreen = RGB_MAX;
        endBlue = RGB_MAX;
        redValue = RGB_MAX;
        greenValue = RGB_MAX;
        blueValue = RGB_MAX;
        startAlpha = ALPHA_MAX;
        endAlpha = ALPHA_MAX;
    }

    public Particle(Bitmap bitmap) {
        this();
        mImage = bitmap;
        endSize = startSize = Math.max(bitmap.getWidth(), bitmap.getHeight());
        startScale = 1f;
        endScale = 1f;
    }

    public void init() {
        mScale = 1;
        mAlpha = 255;
    }

    public void configure(long timeToLive, float emiterX, float emiterY) {
        mBitmapHalfWidth = mImage.getWidth() / 2;
        mBitmapHalfHeight = mImage.getHeight() / 2;

        int wh = Math.max(mBitmapHalfWidth, mBitmapHalfHeight) * 2;
        if (wh > 0) {
            startScale = (float) startSize / (float) wh;
            endScale = (float) endSize / (float) wh;
        } else {
            startScale = 1;
            endScale = 1;
        }
        mInitialX = emiterX - mBitmapHalfWidth;
        mInitialY = emiterY - mBitmapHalfHeight;
        mCurrentX = mInitialX;
        mCurrentY = mInitialY;

        mTimeToLive = timeToLive;
    }

    public boolean update(long milliseconds) {
        long realMilliseconds = milliseconds - mStartingMillisecond;
        if (realMilliseconds > mTimeToLive) {
            return false;
        }

//        float realSeconds = (float)realMilliseconds/1000;
        float timePercent = (float) realMilliseconds / mTimeToLive;

        mScale = startScale + timePercent * (endScale - startScale);

        mCurrentX = mInitialX + mSpeedX * realMilliseconds + mAccelerationX * realMilliseconds * realMilliseconds;
        mCurrentY = mInitialY + mSpeedY * realMilliseconds + mAccelerationY * realMilliseconds * realMilliseconds;
        mRotation = mInitialRotation + mRotationSpeed * realMilliseconds / 1000;

        for (int i = 0; i < mModifiers.size(); i++) {
            mModifiers.get(i).apply(this, realMilliseconds);
        }
        if (hasColorFilter) {
            redValue = startRed + (int) (timePercent * (endRed - startRed));
            greenValue = startGreen + (int) (timePercent * (endGreen - startGreen));
            blueValue = startBlue + (int) (timePercent * (endBlue - startBlue));
            mAlpha = startAlpha + (int) (timePercent * (endAlpha - startAlpha));
            filter = new PorterDuffColorFilter(Color.argb(mAlpha, redValue, greenValue, blueValue), PorterDuff.Mode.SRC_IN);
        }
        return true;
    }

    public void draw(Canvas c) {
        mMatrix.reset();
        mMatrix.postRotate(mRotation, mBitmapHalfWidth, mBitmapHalfHeight);
        mMatrix.postScale(mScale, mScale, mBitmapHalfWidth, mBitmapHalfHeight);
        mMatrix.postTranslate(mCurrentX, mCurrentY);
        if (filter != null /* && hasColorFilter*/)
            mPaint.setColorFilter(filter);
        mPaint.setAlpha(mAlpha);
        c.drawBitmap(mImage, mMatrix, mPaint);
    }

    public Particle activate(long startingMillisecond, List<ParticleModifier> modifiers) {
        mStartingMillisecond = startingMillisecond;
        // We do store a reference to the list, there is no need to copy, since the modifiers do not carte about states
        mModifiers = modifiers;
        return this;
    }
}
