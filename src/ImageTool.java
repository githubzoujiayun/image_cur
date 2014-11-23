import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;


public class ImageTool {

	
	//指定大小缩放，
	public static  void curImg_size(int width,int height){
		try {
			/*
			 * size(width,height) 若图片横比200小，高比300小，不变
			 * 若图片横比200小，高比300大，高缩小到300，图片比例不变 若图片横比200大，高比300小，横缩小到200，图片比例不变
			 * 若图片横比200大，高比300大，图片按比例缩小，横为width或高为height
			 */
			Thumbnails.of("f:/img_cur/erensun.jpg").size(width, height).toFile("f:/img_cur/erensun_200.jpg");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//按比例缩放
	public static void curImg_bl(double bl){
		try {
		
			Thumbnails.of("f:/img_cur/erensun.jpg").scale(bl).toFile("f:/img_cur/erensun_scale.jpg");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//添加水印
	public static void curImg_sy(){
		try {
			/**
			 * watermark(位置，水印图，透明度)
			 * outputQuality(图片质量)//过低的话图片很模糊
			 * keepAspectRatio(false)：false不按比例来，直接按照设定的宽，高来。如果不写这句的话，则按照比例来，按高来缩放宽的比例，高这里为500，但是宽会被按比例来设定，不一定是400.
			 */
			//Thumbnails.of("f:/img_cur/erensun.jpg").size(400, 500)
			//.watermark(Positions.BOTTOM_RIGHT,ImageIO.read(new File("f:/img_cur/1.png")), 0.4f)
				//	.outputQuality(0.8f).toFile("f:/img_cur/erensun_sy3.jpg");
			Thumbnails.of("f:/img_cur/erensun.jpg").size(400, 500).keepAspectRatio(false).watermark(
					Positions.CENTER,ImageIO.read(new File("f:/img_cur/1.png")), 0.4f)
					.outputQuality(0.8f).toFile("f:/img_cur/erensun_sy_center4.jpg");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 裁剪
	 * 
	 * @throws IOException
	 */
	private void test6() throws IOException {
		/**
		 * 图片中心400*400的区域
		 */
		Thumbnails.of("images/test.jpg").sourceRegion(Positions.CENTER, 400,
				400).size(200, 200).keepAspectRatio(false).toFile(
				"C:/image_region_center.jpg");
		/**
		 * 图片右下400*400的区域
		 */
		Thumbnails.of("images/test.jpg").sourceRegion(Positions.BOTTOM_RIGHT,
				400, 400).size(200, 200).keepAspectRatio(false).toFile(
				"C:/image_region_bootom_right.jpg");
		/**
		 * 指定坐标
		 */
		Thumbnails.of("images/test.jpg").sourceRegion(600, 500, 400, 400).size(
				200, 200).keepAspectRatio(false).toFile(
				"C:/image_region_coord.jpg");
	}
	
	/**
	 * 转化图像格式
	 * 
	 * @throws IOException
	 */
	private void test7() throws IOException {
		/**
		 * outputFormat(图像格式)
		 */
		Thumbnails.of("images/test.jpg").size(1280, 1024).outputFormat("png")
				.toFile("C:/image_1280x1024.png");
		Thumbnails.of("images/test.jpg").size(1280, 1024).outputFormat("gif")
				.toFile("C:/image_1280x1024.gif");
	}
	
	
}
