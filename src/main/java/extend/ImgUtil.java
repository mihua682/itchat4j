package extend;

import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class ImgUtil {

	  public static BufferedImage zoomImage(BufferedImage bufImg,int w,int h) throws Exception {
	        
	        double wr=0,hr=0;

	        Image Itemp = bufImg.getScaledInstance(w, h, bufImg.SCALE_SMOOTH);//设置缩放目标图片模板
	        
	        wr=w*1.0/bufImg.getWidth();     //获取缩放比例
	        hr=h*1.0 / bufImg.getHeight();

	        AffineTransformOp ato = new AffineTransformOp(AffineTransform.getScaleInstance(wr, hr), null);
	        Itemp = ato.filter(bufImg, null);
	        return (BufferedImage) Itemp;
	    }
	  
}
