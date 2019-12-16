package com.pcitc.utils;

import java.io.InputStream;

import org.activiti.bpmn.model.BpmnModel;
import org.activiti.engine.ProcessEngine;
import org.activiti.image.impl.DefaultProcessDiagramGenerator;

public class BpmnModelImageUtil {

	
	
	public static InputStream getBpmnModelInputStream(ProcessEngine processEngine,BpmnModel bpmnModel)throws Exception
	{
		//ProcessDiagramGenerator processDiagramGenerator = new DefaultProcessDiagramGenerator();
        InputStream inputStream  =processEngine.getProcessEngineConfiguration().getProcessDiagramGenerator().generateJpgDiagram(bpmnModel);
        
		
		/*
		 * processEngine.getProcessEngineConfiguration().getProcessDiagramGenerator().
		 * generateDiagram(bpmnModel, "png",
		 * processEngine.getProcessEngineConfiguration().getActivityFontName(),
		 * processEngine.getProcessEngineConfiguration().getLabelFontName(),
		 * processEngine.getProcessEngineConfiguration().getClassLoader(),1.0);
		 */
        /**
		InputStream inputStream  =processEngine.getProcessEngineConfiguration().getProcessDiagramGenerator().generateDiagram(bpmnModel, "png",  
				processEngine.getProcessEngineConfiguration().getActivityFontName(), 
				processEngine.getProcessEngineConfiguration().getLabelFontName(), 
				processEngine.getProcessEngineConfiguration().getLabelFontName(), 
				processEngine.getProcessEngineConfiguration().getClassLoader(), 1.0d);
				
				*/
        
		/*
		 * InputStream inputStream = processDiagramGenerator.generateDiagram(bpmnModel,
		 * "png", Collections.<String>emptyList(), Collections.<String>emptyList(),
		 * "WenQuanYi Micro Hei", "WenQuanYi Micro Hei", null, 1.0);
		 */
		//OutputStream out=null;
		//IOUtils.copy(inputStream, out);
		
        return inputStream;
	}
	
}
