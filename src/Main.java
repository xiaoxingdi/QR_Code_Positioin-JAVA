package qrcode;

import java.util.ArrayList;
import java.util.List;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;



public class Main {
	
	static {  
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);  
        //注意程序运行的时候需要在VM option添加该行 指明opencv的dll文件所在路径  
        //-Djava.library.path=$PROJECT_DIR$\opencv\x64  
    }  
	public static void main(String[] args) {
		Mat src=new Mat();
		Mat grayImage=new Mat();
		Mat edges=new Mat();
		Mat hierarchy=new Mat();
		Detector dector=new Detector();
		Mat srcImg=Imgcodecs.imread("G:/ImgaeTest/qr10.png");
		Mat distimg=dector.testAction(srcImg);
		ImageViewer ima=new ImageViewer(distimg ,"输出图片");
	     ima.imshow();
		 /*
		  * 以下是通过轮廓嵌套的方式查找
		  */
	     /* 
		 Imgproc.cvtColor(srcImg, grayImage, Imgproc.COLOR_BGR2GRAY);
	    	Imgproc.GaussianBlur(grayImage, grayImage, new Size(3,3), 0);
	    	Imgproc.threshold(grayImage, grayImage, 0, 255, Imgproc.THRESH_OTSU);
	    	Imgproc.Canny(grayImage, edges, 100, 200);
	    	List<MatOfPoint> pointlist=new ArrayList<MatOfPoint>();
	    	Imgproc.findContours(edges, pointlist, hierarchy, Imgproc.RETR_TREE, Imgproc.CHAIN_APPROX_SIMPLE);
	    	//System.out.println(hierarchy.dump());
	    	List<Integer> found=new ArrayList();
	    	for(int i=0;i<pointlist.size();i++) {
	    		int k=i;
	    		int c=0;
	    		while(hierarchy.get(0, k)[2]!=-1) {
	    			k=(int)hierarchy.get(0, k)[2];
	    			c=c+1;
	    		}
	    		if(c>=5) {
	    			found.add(i);
	    		}
	    	}
	    	for(int i=0;i<found.size();i++) {
	    		src=srcImg.clone();
	    		Imgproc.drawContours(src, pointlist, found.get(i), new Scalar(0, 255, 0), 3);
	    		ImageViewer ima=new ImageViewer(src ,"输出图片");
	   	     ima.imshow();
	    	}*/
	}

}
