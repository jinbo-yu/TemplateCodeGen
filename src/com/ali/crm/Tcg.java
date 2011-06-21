package com.ali.crm;

import java.io.File;
import java.io.FileInputStream;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.ali.crm.codegen.GenEngine;
import com.cloudgarden.resource.SWTResourceManager;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class Tcg extends org.eclipse.swt.widgets.Composite {

    {
        // Register as a resource user - SWTResourceManager will
        // handle the obtaining and disposing of resources
        SWTResourceManager.registerResourceUser(this);
    }

    private SashForm    sashForm1;
    private Composite   composite1;
    private Composite   composite2;
    private Button      btnTemplateFromFile;
    private Button      btnValueFromFile;
    private Button      btnRend;
    private Label       label5;
    private ProgressBar progressBar1;
    private Label       label4;
    private Text        cmpOutput;
    private Label       label3;
    private Text        cmpTemplate;
    private Label       label2;
    private Text        cmpValues;
    private Label       label1;
    private Composite   composite3;
    private SashForm    sashForm2;

    /**
     * Auto-generated main method to display this
     * org.eclipse.swt.widgets.Composite inside a new Shell.
     */
    public static void main(String[] args) {
        showGUI();
    }

    /**
     * Auto-generated method to display this org.eclipse.swt.widgets.Composite
     * inside a new Shell.
     */
    public static void showGUI() {
        Display display = Display.getDefault();
        Shell shell = new Shell(display);
        Tcg inst = new Tcg(shell, SWT.NULL);
        Point size = inst.getSize();
        shell.setLayout(new FillLayout());
        shell.layout();
        if (size.x == 0 && size.y == 0) {
            inst.pack();
            shell.pack();
        } else {
            Rectangle shellBounds = shell.computeTrim(0, 0, size.x, size.y);
            shell.setSize(shellBounds.width, shellBounds.height);
        }
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
    }

    public Tcg(org.eclipse.swt.widgets.Composite parent, int style) {
        super(parent, style);
        initGUI();
    }

    private void initGUI() {
        try {
            this.setLayout(new FormLayout());
            this.setSize(700, 400);
            {
                btnRend = new Button(this, SWT.PUSH | SWT.CENTER);
                FormData button1LData = new FormData();
                button1LData.width = 56;
                button1LData.height = 21;
                button1LData.right = new FormAttachment(1000, 1000, -7);
                button1LData.bottom = new FormAttachment(1000, 1000, -7);
                btnRend.setLayoutData(button1LData);
                btnRend.setText("\u786e\u5b9a");
                btnRend.addMouseListener(new MouseAdapter() {
                    public void mouseUp(MouseEvent evt) {
                        btnRendMouseUp(evt);
                    }
                });
            }
            {
                label5 = new Label(this, SWT.BORDER);
                FormData label5LData = new FormData();
                label5LData.width = 306;
                label5LData.height = 19;
                label5LData.left = new FormAttachment(0, 1000, 56);
                label5LData.bottom = new FormAttachment(1000, 1000, -7);
                label5LData.right = new FormAttachment(1000, 1000, -168);
                label5.setLayoutData(label5LData);
                label5.setText("label5");
                label5.setFont(SWTResourceManager.getFont("Tahoma", 9, 0, false, false));
            }
            {
                FormData progressBar1LData = new FormData();
                progressBar1LData.width = 89;
                progressBar1LData.height = 19;
                progressBar1LData.bottom = new FormAttachment(1000, 1000, -7);
                progressBar1LData.right = new FormAttachment(1000, 1000, -70);
                progressBar1 = new ProgressBar(this, SWT.NONE);
                progressBar1.setLayoutData(progressBar1LData);
            }
            {
                label4 = new Label(this, SWT.BORDER);
                FormData label4LData = new FormData();
                label4LData.width = 40;
                label4LData.height = 19;
                label4LData.left = new FormAttachment(0, 1000, 7);
                label4LData.bottom = new FormAttachment(1000, 1000, -7);
                label4.setLayoutData(label4LData);
                label4.setText("Status:");
                label4.setFont(SWTResourceManager.getFont("Tahoma", 9, 0, false, false));
            }
            {
                FormData sashForm1LData = new FormData();
                sashForm1LData.width = 518;
                sashForm1LData.height = 434;
                sashForm1LData.left = new FormAttachment(0, 1000, 7);
                sashForm1LData.top = new FormAttachment(0, 1000, 7);
                sashForm1LData.bottom = new FormAttachment(1000, 1000, -35);
                sashForm1LData.right = new FormAttachment(1000, 1000, -7);
                sashForm1 = new SashForm(this, SWT.HORIZONTAL | SWT.H_SCROLL);
                sashForm1.setLayoutData(sashForm1LData);
                {
                    composite1 = new Composite(sashForm1, SWT.NONE);
                    FormLayout composite1Layout = new FormLayout();
                    composite1.setLayout(composite1Layout);
                    {
                        cmpValues = new Text(composite1, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
                        FormData text1LData = new FormData();
                        text1LData.width = 308;
                        text1LData.height = 315;
                        text1LData.left =  new FormAttachment(0, 1000, 3);
                        text1LData.top =  new FormAttachment(0, 1000, 21);
                        text1LData.right =  new FormAttachment(1000, 1000, -1);
                        text1LData.bottom =  new FormAttachment(1000, 1000, 0);
                        cmpValues.setLayoutData(text1LData);
                        cmpValues.setText("");
                        cmpValues.setFont(SWTResourceManager.getFont("Courier", 8, 0, false, false));
                        cmpValues.addKeyListener(new KeyAdapter() {
                            public void keyReleased(KeyEvent evt) {
                                cmpValuesKeyReleased(evt);
                            }
                        });
                    }
                    {
                        btnValueFromFile = new Button(composite1, SWT.PUSH | SWT.CENTER);
                        FormData btnValueFromFileLData = new FormData();
                        btnValueFromFileLData.width = 49;
                        btnValueFromFileLData.height = 21;
                        btnValueFromFileLData.top = new FormAttachment(0, 1000, 0);
                        btnValueFromFileLData.left = new FormAttachment(0, 1000, 42);
                        btnValueFromFile.setLayoutData(btnValueFromFileLData);
                        btnValueFromFile.setText(">>");
                        btnValueFromFile.addMouseListener(new MouseAdapter() {
                            public void mouseUp(MouseEvent evt) {
                                btnValueFromFileMouseUp(evt);
                            }
                        });
                    }
                    {
                        label1 = new Label(composite1, SWT.NONE);
                        FormData label1LData = new FormData();
                        label1LData.width = 36;
                        label1LData.height = 14;
                        label1LData.left = new FormAttachment(0, 1000, 0);
                        label1LData.top = new FormAttachment(0, 1000, 0);
                        label1.setLayoutData(label1LData);
                        label1.setText("Values");
                    }
                }
                {
                    sashForm2 = new SashForm(sashForm1, SWT.VERTICAL | SWT.V_SCROLL);
                    {
                        composite2 = new Composite(sashForm2, SWT.NONE);
                        FormLayout composite2Layout = new FormLayout();
                        composite2.setLayout(composite2Layout);
                        {
                            btnTemplateFromFile = new Button(composite2, SWT.PUSH | SWT.CENTER);
                            FormData btnTemplateFromFileLData = new FormData();
                            btnTemplateFromFileLData.width = 49;
                            btnTemplateFromFileLData.height = 21;
                            btnTemplateFromFileLData.left = new FormAttachment(0, 1000, 49);
                            btnTemplateFromFileLData.top = new FormAttachment(0, 1000, 0);
                            btnTemplateFromFile.setLayoutData(btnTemplateFromFileLData);
                            btnTemplateFromFile.setText(">>");
                            btnTemplateFromFile.addMouseListener(new MouseAdapter() {
                                public void mouseUp(MouseEvent evt) {
                                    btnTemplateFromFileMouseUp(evt);
                                }
                            });
                        }
                        {
                            cmpTemplate = new Text(composite2, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
                            FormData text2LData = new FormData();
                            text2LData.width = 253;
                            text2LData.height = 196;
                            text2LData.left = new FormAttachment(0, 1000, 0);
                            text2LData.top = new FormAttachment(0, 1000, 21);
                            text2LData.right = new FormAttachment(1000, 1000, 1);
                            text2LData.bottom = new FormAttachment(1000, 1000, 2);
                            cmpTemplate.setLayoutData(text2LData);
                            cmpTemplate.setText("");
                            cmpTemplate.setFont(SWTResourceManager.getFont("Courier", 10, 0, false, false));
                            cmpTemplate.addKeyListener(new KeyAdapter() {
                                public void keyReleased(KeyEvent evt) {
                                    cmpTemplateKeyReleased(evt);
                                }
                            });
                        }
                        {
                            label2 = new Label(composite2, SWT.NONE);
                            FormData label2LData = new FormData();
                            label2LData.width = 48;
                            label2LData.height = 14;
                            label2LData.left = new FormAttachment(0, 1000, 0);
                            label2LData.top = new FormAttachment(0, 1000, 0);
                            label2.setLayoutData(label2LData);
                            label2.setText("Template");
                        }
                    }
                    {
                        composite3 = new Composite(sashForm2, SWT.NONE);
                        FormLayout composite3Layout = new FormLayout();
                        composite3.setLayout(composite3Layout);
                        {
                            cmpOutput = new Text(composite3, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
                            FormData text3LData = new FormData();
                            text3LData.width = 253;
                            text3LData.height = 203;
                            text3LData.left = new FormAttachment(0, 1000, 0);
                            text3LData.top = new FormAttachment(0, 1000, 14);
                            text3LData.bottom = new FormAttachment(1000, 1000, 0);
                            text3LData.right = new FormAttachment(1000, 1000, 0);
                            cmpOutput.setLayoutData(text3LData);
                            cmpOutput.setFont(SWTResourceManager.getFont("Courier", 8, 0, false, false));
                            cmpOutput.setText("");
                            cmpOutput.addKeyListener(new KeyAdapter() {
                                public void keyReleased(KeyEvent evt) {
                                    cmpOutputKeyReleased(evt);
                                }
                            });
                        }
                        {
                            label3 = new Label(composite3, SWT.NONE);
                            FormData label3LData = new FormData();
                            label3LData.width = 44;
                            label3LData.height = 14;
                            label3LData.left = new FormAttachment(0, 1000, 0);
                            label3LData.top = new FormAttachment(0, 1000, 0);
                            label3.setLayoutData(label3LData);
                            label3.setText("Result");
                        }
                    }
                }
            }
            this.layout();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void btnValueFromFileMouseUp(MouseEvent evt) {
        String newValues = getStringFromFile();
        if (newValues != null) {
            cmpValues.setText(newValues);
        }
    }

    private void btnTemplateFromFileMouseUp(MouseEvent evt) {
        String newValues = getStringFromFile();
        if (newValues != null) {
            cmpTemplate.setText(newValues);
        }
    }

    private String getStringFromFile() {
        FileDialog fileDialog = new FileDialog(this.getShell());
        String fileName = fileDialog.open();
        String content = null;
        if (fileName != null) {
            File file = new File(fileName);
            if (file.isFile()) {
                StringBuffer result = new StringBuffer();
                try {
                    FileInputStream in = new FileInputStream(file);
                    try {
                        byte[] buf = new byte[1024 * 128];
                        int count = in.read(buf);
                        while (count > 0) {
                            result.append(new String(buf, 0, count));
                            count = in.read(buf);
                        }
                    } catch (Exception e) {
                        result.append("\nError:" + e.getMessage());
                    } finally {
                        in.close();
                    }
                } catch (Exception e) {
                    result.append("\nError:" + e.getMessage());
                }
                content = result.toString();
            }
        }
        fileDialog = null;

        return content;
    }

    private void cmpTemplateKeyReleased(KeyEvent evt) {
        selectAll(evt);
    }

    private void selectAll(KeyEvent evt) {
        if ((evt.stateMask & SWT.CTRL) != 0 && (evt.character == 0x01)) {
            ((Text) evt.getSource()).selectAll();
        }
    }

    private void cmpValuesKeyReleased(KeyEvent evt) {
        selectAll(evt);
    }

    private void cmpOutputKeyReleased(KeyEvent evt) {
        selectAll(evt);
    }

    private void btnRendMouseUp(MouseEvent evt) {
        btnRend.setEnabled(false);
        GenEngine engine = new GenEngine();
        String result = null;
        try {
            result = engine.renderOnStrStr(cmpValues.getText(), cmpTemplate.getText());
        } catch (Exception e) {
            result = e.getMessage();
        }
        cmpOutput.setText(result == null ? "" : result);
        btnRend.setEnabled(true);
    }

}
