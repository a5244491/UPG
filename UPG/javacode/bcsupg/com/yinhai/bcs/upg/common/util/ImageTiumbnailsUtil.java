//package com.yinhai.bcs.upg.common.util;
//
//import java.awt.image.BufferedImage;
//import java.io.ByteArrayOutputStream;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//
//import javax.imageio.ImageIO;
//
//import net.coobird.thumbnailator.Thumbnails;
//
//import com.yinhai.sysframework.exception.AppException;
//
//public class ImageTiumbnailsUtil {
//	
//	/**
//	 * 图片压缩
//	 * @param file 文件名称
//	 * @param fileType 文件类型
//	 * @param os 输出流
//	 * @param x 宽
//	 * @param y 高
//	 * @throws AppException
//	 * @throws FileNotFoundException
//	 * @throws IOException
//	 */
//	public static void thumbnailImage(File file,
//			String fileType,ByteArrayOutputStream os,int x,int y) throws AppException, FileNotFoundException, IOException {
//		BufferedImage thumbnail = Thumbnails.of(new FileInputStream(file))
//				.size(x, y).keepAspectRatio(true).asBufferedImage();// 文件根据规定大小按比例缩压缩
//		if (!ImageIO.write(thumbnail, fileType, os)) {
//			throw new AppException("文件压缩失败");
//		}
//	}
//}
