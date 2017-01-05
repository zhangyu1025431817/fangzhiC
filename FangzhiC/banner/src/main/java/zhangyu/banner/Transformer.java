package zhangyu.banner;

import android.support.v4.view.ViewPager.PageTransformer;

import zhangyu.banner.transformer.AccordionTransformer;
import zhangyu.banner.transformer.BackgroundToForegroundTransformer;
import zhangyu.banner.transformer.CubeInTransformer;
import zhangyu.banner.transformer.CubeOutTransformer;
import zhangyu.banner.transformer.DefaultTransformer;
import zhangyu.banner.transformer.DepthPageTransformer;
import zhangyu.banner.transformer.FlipHorizontalTransformer;
import zhangyu.banner.transformer.FlipVerticalTransformer;
import zhangyu.banner.transformer.ForegroundToBackgroundTransformer;
import zhangyu.banner.transformer.RotateDownTransformer;
import zhangyu.banner.transformer.RotateUpTransformer;
import zhangyu.banner.transformer.ScaleInOutTransformer;
import zhangyu.banner.transformer.StackTransformer;
import zhangyu.banner.transformer.TabletTransformer;
import zhangyu.banner.transformer.ZoomInTransformer;
import zhangyu.banner.transformer.ZoomOutSlideTransformer;
import zhangyu.banner.transformer.ZoomOutTranformer;


public class Transformer {
    public static Class<? extends PageTransformer> Default = DefaultTransformer.class;
    public static Class<? extends PageTransformer> Accordion = AccordionTransformer.class;
    public static Class<? extends PageTransformer> BackgroundToForeground = BackgroundToForegroundTransformer.class;
    public static Class<? extends PageTransformer> ForegroundToBackground = ForegroundToBackgroundTransformer.class;
    public static Class<? extends PageTransformer> CubeIn = CubeInTransformer.class;
    public static Class<? extends PageTransformer> CubeOut = CubeOutTransformer.class;
    public static Class<? extends PageTransformer> DepthPage = DepthPageTransformer.class;
    public static Class<? extends PageTransformer> FlipHorizontal = FlipHorizontalTransformer.class;
    public static Class<? extends PageTransformer> FlipVertical = FlipVerticalTransformer.class;
    public static Class<? extends PageTransformer> RotateDown = RotateDownTransformer.class;
    public static Class<? extends PageTransformer> RotateUp = RotateUpTransformer.class;
    public static Class<? extends PageTransformer> ScaleInOut = ScaleInOutTransformer.class;
    public static Class<? extends PageTransformer> Stack = StackTransformer.class;
    public static Class<? extends PageTransformer> Tablet = TabletTransformer.class;
    public static Class<? extends PageTransformer> ZoomIn = ZoomInTransformer.class;
    public static Class<? extends PageTransformer> ZoomOut = ZoomOutTranformer.class;
    public static Class<? extends PageTransformer> ZoomOutSlide = ZoomOutSlideTransformer.class;
}
