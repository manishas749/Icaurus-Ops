package com.icarus.customviews;

import android.content.Context;
import android.graphics.Canvas;

import me.dm7.barcodescanner.core.IViewFinder;
import me.dm7.barcodescanner.core.ViewFinderView;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

/**
 * Created by Monika Rana on 28/04/2020
 */
public class ZXingBarcodeScannerView extends ZXingScannerView {

    public ZXingBarcodeScannerView(Context context) {
        super(context);
    }

    @Override
    protected IViewFinder createViewFinderView(Context context) {
        return new CustomViewFinderView(context);
    }

    //make changes in CustomViewFinderView to customise the Viewfinder
//Check ViewFinderView class for more modifications
//to change viewFinder's colours override appropriate values in Colors.xml
    class CustomViewFinderView extends ViewFinderView {


        public CustomViewFinderView(Context context) {
            super(context);
            setSquareViewFinder(true);
            setBorderStrokeWidth(8);
        }

        @Override
        public void drawLaser(Canvas canvas) {
            //do nothing for no laser, even remove super call
        }

    }
}
