package com.pcitc.utils;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.activiti.bpmn.model.BpmnModel;
import org.activiti.image.exception.ActivitiImageException;

public class ImageGenerator {
	
	 public static BufferedImage createImage(BpmnModel bpmnModel)
	 {
	        ProcessDiagramGenerator diagramGenerator = new ProcessDiagramGenerator();
	        BufferedImage diagramImage = diagramGenerator.generatePngImage(bpmnModel, 1.0);
	        return diagramImage;
	    }
	 
	    public static BufferedImage createImage(BpmnModel bpmnModel, double scaleFactor) {
	        ProcessDiagramGenerator diagramGenerator = new ProcessDiagramGenerator(scaleFactor);
	        BufferedImage diagramImage = diagramGenerator.generatePngImage(bpmnModel, scaleFactor);
	        return diagramImage;
	    }

	public static byte[] createByteArrayForImage(BufferedImage image, String imageType)
	{
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			ImageIO.write(image, imageType, out);
		} catch (IOException e) {
			throw new ActivitiImageException("Error while generating byte array for process image", e);
		} finally 
		{
			try 
			{
				if (out != null) 
				{
					out.close();
				}
			} catch (IOException ignore) {
			}
		}
		return out.toByteArray();

	}
	public static byte[] getBpmnModelImage(BpmnModel bpmnModel)
	{
		BufferedImage image= createImage( bpmnModel);
		byte[] bytea=createByteArrayForImage( image, null);
		return bytea;
	}
	
	
	

}
