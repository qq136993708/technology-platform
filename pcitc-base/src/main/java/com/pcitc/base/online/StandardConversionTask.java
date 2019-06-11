package com.pcitc.base.online;

import static com.pcitc.base.online.office.OfficeUtils.cast;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.pcitc.base.online.document.DocumentFamily;
import com.pcitc.base.online.document.DocumentFormat;
import com.pcitc.base.online.office.OfficeException;

import com.sun.star.lang.XComponent;
import com.sun.star.util.XRefreshable;

public class StandardConversionTask extends AbstractConversionTask {

    private final DocumentFormat outputFormat;

    private Map<String,?> defaultLoadProperties;
    private DocumentFormat inputFormat;

    public StandardConversionTask(File inputFile, File outputFile, DocumentFormat outputFormat) {
        super(inputFile, outputFile);
        this.outputFormat = outputFormat;
    }

    public void setDefaultLoadProperties(Map<String, ?> defaultLoadProperties) {
        this.defaultLoadProperties = defaultLoadProperties;
    }

    public void setInputFormat(DocumentFormat inputFormat) {
        this.inputFormat = inputFormat;
    }

    @Override
    protected void modifyDocument(XComponent document) throws OfficeException {
        XRefreshable refreshable = cast(XRefreshable.class, document);
        if (refreshable != null) {
            refreshable.refresh();
        }
    }

    @Override
    protected Map<String,?> getLoadProperties(File inputFile) {
        Map<String,Object> loadProperties = new HashMap<String,Object>();
        if (defaultLoadProperties != null) {
            loadProperties.putAll(defaultLoadProperties);
        }
        if (inputFormat != null && inputFormat.getLoadProperties() != null) {
            loadProperties.putAll(inputFormat.getLoadProperties());
        }
        return loadProperties;
    }

    @Override
    protected Map<String,?> getStoreProperties(File outputFile, XComponent document) {
        DocumentFamily family = OfficeDocumentUtils.getDocumentFamily(document);
        return outputFormat.getStoreProperties(family);
    }

}
