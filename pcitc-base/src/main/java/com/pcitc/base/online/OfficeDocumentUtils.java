package com.pcitc.base.online;

import static com.pcitc.base.online.office.OfficeUtils.*;

import com.pcitc.base.online.document.DocumentFamily;
import com.pcitc.base.online.office.OfficeException;


import com.sun.star.lang.XComponent;
import com.sun.star.lang.XServiceInfo;

class OfficeDocumentUtils {

    private OfficeDocumentUtils() {
        throw new AssertionError("utility class must not be instantiated");
    }

    public static DocumentFamily getDocumentFamily(XComponent document) throws OfficeException {
        XServiceInfo serviceInfo = cast(XServiceInfo.class, document);
        if (serviceInfo.supportsService("com.sun.star.text.GenericTextDocument")) {
            // NOTE: a GenericTextDocument is either a TextDocument, a WebDocument, or a GlobalDocument
            // but this further distinction doesn't seem to matter for conversions
            return DocumentFamily.TEXT;
        } else if (serviceInfo.supportsService("com.sun.star.sheet.SpreadsheetDocument")) {
            return DocumentFamily.SPREADSHEET;
        } else if (serviceInfo.supportsService("com.sun.star.presentation.PresentationDocument")) {
            return DocumentFamily.PRESENTATION;
        } else if (serviceInfo.supportsService("com.sun.star.drawing.DrawingDocument")) {
            return DocumentFamily.DRAWING;
        } else {
            throw new OfficeException("document of unknown family: " + serviceInfo.getImplementationName());
        }
    }

}
