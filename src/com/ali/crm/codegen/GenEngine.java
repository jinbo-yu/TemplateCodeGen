package com.ali.crm.codegen;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

public class GenEngine {
    private static final Logger  log           = Logger.getLogger(GenEngine.class);
    private static final Pattern TABLE_PATTERN = Pattern
                                                       .compile("^.*\\s*create\\s+.*table\\s+([^\\(]*)(\\s*.*|\\s*\\(.*)$");

    private VelocityEngine getVelocityEngine(String templateBaseDir) throws Exception {
        VelocityEngine ve = new VelocityEngine();
        Properties pp = new Properties();
        pp.setProperty("resource.loader", "file");
        pp.setProperty("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.FileResourceLoader");
        pp.setProperty("file.resource.loader.path", templateBaseDir);
        pp.setProperty(VelocityEngine.RUNTIME_LOG, templateBaseDir + File.separator + "velocity.log");
        String velocityProperties = templateBaseDir + File.separator + "velocity.properties";
        File f = new File(velocityProperties);
        if (f.exists()) {
            log.info("init with file:" + velocityProperties);
            FileInputStream is = new FileInputStream(f);
            pp.load(is);
        }
        ve.init(pp);
        return ve;
    }

    public String renderString(String templateStr, VelocityContext rendContext) {
        try {
            File file = File.createTempFile("tmp", ".vm");
            Writer writer = new FileWriter(file);
            writer.write(templateStr);
            writer.flush();
            writer.close();

            File fileOut = File.createTempFile("tmp", ".out");
            VelocityEngine ve = this.getVelocityEngine(file.getParent());
            rendTemplate(ve, file.getName(), rendContext, fileOut);
            StringBuffer strBuf = new StringBuffer();
            char[] buf = new char[1024];
            Reader in = new FileReader(fileOut);
            int count = in.read(buf);
            while (count > 0) {
                strBuf.append(buf, 0, count);
                count = in.read(buf);
            }
            in.close();
            templateStr = new String(strBuf);
            try {
                file.delete();
                fileOut.delete();
            } catch (Exception e) {
                log.error("", e);
            }
        } catch (Exception e) {
            log.error("", e);
            throw new RuntimeException(e.getMessage());
        }
        return templateStr;
    }

    private boolean createFileIfNotExist(File file) throws IOException {
        File parent = file.getParentFile();
        if (parent != null && !parent.exists()) {
            parent.mkdirs();
        }
        if (!file.exists()) {
            file.createNewFile();
        }
        return true;
    }

    private void rendTemplate(VelocityEngine engine, String templateFile, VelocityContext context, File responseFile) {
        try {
            Template template = engine.getTemplate(templateFile);
            if (template != null) {
                createFileIfNotExist(responseFile);
                Writer response = new OutputStreamWriter(new FileOutputStream(responseFile), Charset
                        .forName((String) engine.getProperty(VelocityEngine.OUTPUT_ENCODING)));
                template.merge(context, response);
                response.flush();
                response.close();
            }
        } catch (Exception ex) {
            log.error("", ex);
            throw new RuntimeException(ex);
        }
    }

    public String renderOnStrStr(String valueStr, String templateStr) {
        if (valueStr == null) {
            return null;
        }
        Map<String, Object> infos = prepareInfo(valueStr);
        Formator FMT = new Formator();
        VelocityContext myContext = new VelocityContext();
        myContext.put("FMT", FMT);
        for (String key : infos.keySet()) {
            myContext.put(key, infos.get(key));
        }
        return renderString(templateStr, myContext);
    }

    private Map<String, Object> prepareInfo(String str) {
        Map<String, Object> infos = new HashMap<String, Object>();
        String[] line = str.split("\n");
        String splitStr = " ";
        List<Map<String, String>> values = new ArrayList<Map<String, String>>();
        for (int i = 0; i < line.length; i++) {
            String aLine = line[i].trim().replaceAll("\t", "").toLowerCase();
            Map<String, String> map = new HashMap<String, String>();
            if (aLine.length() > 2) {
                Matcher matcher = TABLE_PATTERN.matcher(aLine);
                if (matcher.matches()) {
                    String table = matcher.group(1);
                    infos.put("table", table);
                } else {
                    int oldLen = 1;
                    int newLen = 0;
                    while (oldLen != newLen) {
                        oldLen = aLine.length();
                        aLine = aLine.replaceAll(splitStr + splitStr, splitStr);
                        newLen = aLine.length();
                    }
                    String[] cols = aLine.split(splitStr);
                    for (int j = 0; j < cols.length; j++) {
                        map.put("c" + j, cols[j].trim());
                    }
                    values.add(map);
                }
            }
            if(values.size()>1){
                infos.put("values", values);
            }
        }
        return infos;
    }
}
