package com.pcitc.utils;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;

import javax.imageio.ImageIO;

import org.activiti.bpmn.model.BpmnModel;
import org.activiti.editor.language.json.converter.BpmnJsonConverter;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.image.exception.ActivitiImageException;
import org.activiti.image.impl.DefaultProcessDiagramGenerator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class ImageGenerator {
	
	

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
	
	
	public static InputStream getBpmnModelInputStream(RepositoryService repositoryService,ProcessEngine processEngine,String modelId)
	{
		
		ObjectNode modelNode = null;
        try {
            modelNode = (ObjectNode) new ObjectMapper()
            .readTree(repositoryService.getModelEditorSource(modelId));
        } catch (IOException e) {
            e.printStackTrace();
        }
        BpmnModel bpmnModel = new BpmnJsonConverter().convertToBpmnModel(modelNode);
        InputStream inputStream =   processEngine.getProcessEngineConfiguration().getProcessDiagramGenerator().generateJpgDiagram(bpmnModel);
        
        return inputStream;
	}
	
	
	
	public static InputStream getBpmnModelInputStream2(RepositoryService repositoryService,ProcessEngine processEngine,String modelId)
	{
		
		
		ObjectNode modelNode = null;
        try {
            modelNode = (ObjectNode) new ObjectMapper()
            .readTree(repositoryService.getModelEditorSource(modelId));
        } catch (IOException e) {
            e.printStackTrace();
        }
        BpmnModel bpmnModel = new BpmnJsonConverter().convertToBpmnModel(modelNode);
        
       /**
        InputStream inputStream =  processEngine.getProcessEngineConfiguration().getProcessDiagramGenerator().generateDiagram(
        		bpmnModel, "png", 
        		"WenQuanYi Micro Hei", 
        		"WenQuanYi Micro Hei", 
        		"WenQuanYi Micro Hei", 
        		processEngine.getProcessEngineConfiguration().getClassLoader());
     
        
        
        */
        
        InputStream inputStream =  processEngine.getProcessEngineConfiguration().getProcessDiagramGenerator().generateDiagram(
        		bpmnModel, "png", 
        		processEngine.getProcessEngineConfiguration().getActivityFontName(), 
        		processEngine.getProcessEngineConfiguration().getLabelFontName(), 
        		processEngine.getProcessEngineConfiguration().getLabelFontName(), 
        		processEngine.getProcessEngineConfiguration().getClassLoader());
        
        
        
        
        
        
        
		/*
		 * ProcessDiagramGenerator processDiagramGenerator = new
		 * DefaultProcessDiagramGenerator(); InputStream inputStream =
		 * processDiagramGenerator.generateDiagram(bpmnModel, "png",
		 * Collections.<String>emptyList(), Collections.<String>emptyList(),
		 * "WenQuanYi Micro Hei", "WenQuanYi Micro Hei", null, 1.0);
		 * 
		 * 
		 * InputStream inputStream =
		 * processEngine.getProcessEngineConfiguration().getProcessDiagramGenerator().
		 * generateJpgDiagram(bpmnModel);
		 */
        
       // ProcessDiagramGenerator processDiagramGenerator= processEngine.getProcessEngineConfiguration().getProcessDiagramGenerator();
		/*
		 * InputStream inputStream =
		 * processEngine.getProcessEngineConfiguration().getProcessDiagramGenerator().
		 * generateDiagram(bpmnModel, "png",
		 * 
		 * processEngine.getProcessEngineConfiguration().getActivityFontName(),
		 * processEngine.getProcessEngineConfiguration().getLabelFontName(),
		 * processEngine.getProcessEngineConfiguration().getClassLoader(),1.0 );
		 */
	
	
	
	
		//ProcessDiagramGenerator processDiagramGenerator = new DefaultProcessDiagramGenerator();
        //InputStream inputStream  =processDiagramGenerator.generateJpgDiagram(bpmnModel);
        
		
		/*
		 * processEngine.getProcessEngineConfiguration().getProcessDiagramGenerator().
		 * generateDiagram(bpmnModel, "png",
		 * processEngine.getProcessEngineConfiguration().getActivityFontName(),
		 * processEngine.getProcessEngineConfiguration().getLabelFontName(),
		 * processEngine.getProcessEngineConfiguration().getClassLoader(),1.0);
		 */
		/*
		 * InputStream inputStream
		 * =processEngine.getProcessEngineConfiguration().getProcessDiagramGenerator().
		 * generateDiagram(bpmnModel, "png",
		 * processEngine.getProcessEngineConfiguration().getActivityFontName(),
		 * processEngine.getProcessEngineConfiguration().getLabelFontName(),
		 * processEngine.getProcessEngineConfiguration().getLabelFontName(),
		 * processEngine.getProcessEngineConfiguration().getClassLoader());
		 */
        
		/*
		 * InputStream inputStream = processDiagramGenerator.generateDiagram(bpmnModel,
		 * "png", Collections.<String>emptyList(), Collections.<String>emptyList(),
		 * "WenQuanYi Micro Hei", "WenQuanYi Micro Hei", null, 1.0);
		 */
        return inputStream;
	}
	
	

}
