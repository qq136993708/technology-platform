package com.pcitc.base.online;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FilenameUtils;
import com.pcitc.base.online.document.DefaultDocumentFormatRegistry;
import com.pcitc.base.online.document.DocumentFormat;
import com.pcitc.base.online.document.DocumentFormatRegistry;
import com.pcitc.base.online.office.OfficeException;
import com.pcitc.base.online.office.OfficeManager;

import com.sun.star.document.UpdateDocMode;

public class OfficeDocumentConverter {

    private final OfficeManager officeManager;
    private final DocumentFormatRegistry formatRegistry;

    private Map<String,?> defaultLoadProperties = createDefaultLoadProperties();

    public OfficeDocumentConverter(OfficeManager officeManager) {
        this(officeManager, new DefaultDocumentFormatRegistry());
    }

    public OfficeDocumentConverter(OfficeManager officeManager, DocumentFormatRegistry formatRegistry) {
        this.officeManager = officeManager;
        this.formatRegistry = formatRegistry;
    }

    private Map<String,Object> createDefaultLoadProperties() {
        Map<String,Object> loadProperties = new HashMap<String,Object>();
        loadProperties.put("Hidden", true);
        loadProperties.put("ReadOnly", true);
        loadProperties.put("UpdateDocMode", UpdateDocMode.QUIET_UPDATE);
        return loadProperties;
    }

    public void setDefaultLoadProperties(Map<String, ?> defaultLoadProperties) {
        this.defaultLoadProperties = defaultLoadProperties;
    }

    public DocumentFormatRegistry getFormatRegistry() {
        return formatRegistry;
    }

    public void convert(File inputFile, File outputFile) throws OfficeException {
        String outputExtension = FilenameUtils.getExtension(outputFile.getName());
        DocumentFormat outputFormat = formatRegistry.getFormatByExtension(outputExtension);
        convert(inputFile, outputFile, outputFormat);
    }

    public void convert(File inputFile, File outputFile, DocumentFormat outputFormat) throws OfficeException {
        String inputExtension = FilenameUtils.getExtension(inputFile.getName());
        DocumentFormat inputFormat = formatRegistry.getFormatByExtension(inputExtension);
        StandardConversionTask conversionTask = new StandardConversionTask(inputFile, outputFile, outputFormat);
        conversionTask.setDefaultLoadProperties(defaultLoadProperties);
        conversionTask.setInputFormat(inputFormat);
        officeManager.execute(conversionTask);
    }

}
