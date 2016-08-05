package com.begin.util;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.krysalis.barcode4j.impl.code39.Code39Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.krysalis.barcode4j.tools.UnitConv;
 
public class Barcode {
 
	/**
	 * @see 生成条形码
	 * @param code  条形码内容
	 * @param path  图片生成路径
	 * @param fileName  图片名称
	 */
	public static void generate(String code,String path,String fileName){
		 try {
	            //Create the barcode bean
	            Code39Bean bean = new Code39Bean();
	             
	            final int dpi = 150;
	             
	            //Configure the barcode generator
	            bean.setModuleWidth(UnitConv.in2mm(1.0f / dpi)); //makes the narrow bar 
	                                                             //width exactly one pixel
	            bean.setWideFactor(3);
	            bean.doQuietZone(false);
	             
	            //Open output file
	            File outputFile = new File(path+"/"+fileName);
	            OutputStream out = new FileOutputStream(outputFile);
	            try {
	                //Set up the canvas provider for monochrome JPEG output 
	                BitmapCanvasProvider canvas = new BitmapCanvasProvider(
	                        out, "image/png", dpi, BufferedImage.TYPE_BYTE_BINARY, false, 0);
	             
	                //Generate the barcode
	                bean.generateBarcode(canvas, code);
	                //Signal end of generation
	                canvas.finish();
	            } finally {
	                out.close(); 
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        
	}
    public static void main(String[] args) {
    	//generate("900000001000","d:\\","out.png");
    	//90000000001---90000001000，新华书店会员卡
    	//
    	 System.out.println("9000000000"+generate1());

    	
    }
 
    public static int generate1(){
    	java.util.Random random=new java.util.Random();// 定义随机类
    	int result=random.nextInt(1000);
    	return result+1;  
    }
    
    
    
}