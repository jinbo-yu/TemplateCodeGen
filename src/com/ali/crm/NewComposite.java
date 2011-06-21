package com.ali.crm;

import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.SWT;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class NewComposite extends org.eclipse.swt.widgets.Composite {
	private Composite composite1;
	private Composite composite2;
	private Text text2;
	private Label label2;
	private Text text1;
	private Label label1;

	/**
	* Auto-generated main method to display this
	* org.eclipse.swt.widgets.Composite inside a new Shell.
	*/
	public static void main(String[] args) {
		showGUI();
	}

	/**
	* Auto-generated method to display this
	* org.eclipse.swt.widgets.Composite inside a new Shell.
	*/
	public static void showGUI() {
		Display display = Display.getDefault();
		Shell shell = new Shell(display);
		NewComposite inst = new NewComposite(shell, SWT.NULL);
		Point size = inst.getSize();
		shell.setLayout(new FillLayout());
		shell.layout();
		if(size.x == 0 && size.y == 0) {
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

	public NewComposite(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	private void initGUI() {
		try {
			this.setLayout(new FormLayout());
			this.setSize(576, 429);
			{
				composite2 = new Composite(this, SWT.NONE);
				FormLayout composite2Layout = new FormLayout();
				FormData composite2LData = new FormData();
				composite2LData.width = 560;
				composite2LData.height = 210;
				composite2LData.left =  new FormAttachment(0, 1000, 7);
				composite2LData.top =  new FormAttachment(441, 1000, 0);
				composite2LData.right =  new FormAttachment(1000, 1000, -9);
				composite2LData.bottom =  new FormAttachment(1000, 1000, -30);
				composite2.setLayoutData(composite2LData);
				composite2.setLayout(composite2Layout);
				{
					text1 = new Text(composite2, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
					FormData text1LData = new FormData();
					text1LData.width = 547;
					text1LData.height = 196;
					text1LData.left =  new FormAttachment(0, 1000, 0);
					text1LData.top =  new FormAttachment(0, 1000, 14);
					text1LData.right =  new FormAttachment(1000, 1000, -7);
					text1LData.bottom =  new FormAttachment(1000, 1000, 0);
					text1.setLayoutData(text1LData);
					text1.setText("text1");
				}
				{
					label1 = new Label(composite2, SWT.NONE);
					FormData label1LData = new FormData();
					label1LData.width = 28;
					label1LData.height = 14;
					label1LData.left =  new FormAttachment(0, 1000, 0);
					label1LData.top =  new FormAttachment(0, 1000, 0);
					label1.setLayoutData(label1LData);
					label1.setText("\u8f93\u51fa:");
				}
			}
			{
				composite1 = new Composite(this, SWT.NONE);
				FormLayout composite1Layout = new FormLayout();
				FormData composite1LData = new FormData();
				composite1LData.width = 560;
				composite1LData.height = 182;
				composite1LData.left =  new FormAttachment(0, 1000, 7);
				composite1LData.top =  new FormAttachment(0, 1000, 7);
				composite1LData.right =  new FormAttachment(1000, 1000, -9);
				composite1LData.bottom =  new FormAttachment(441, 1000, 0);
				composite1.setLayoutData(composite1LData);
				composite1.setLayout(composite1Layout);
				{
					text2 = new Text(composite1, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
					FormData text2LData = new FormData();
					text2LData.width = 547;
					text2LData.height = 161;
					text2LData.left =  new FormAttachment(0, 1000, 0);
					text2LData.top =  new FormAttachment(0, 1000, 21);
					text2LData.right =  new FormAttachment(1000, 1000, -7);
					text2LData.bottom =  new FormAttachment(1000, 1000, 0);
					text2.setLayoutData(text2LData);
					text2.setText("text2");
				}
				{
					label2 = new Label(composite1, SWT.NONE);
					FormData label2LData = new FormData();
					label2LData.width = 28;
					label2LData.height = 14;
					label2LData.left =  new FormAttachment(0, 1000, 0);
					label2LData.top =  new FormAttachment(0, 1000, 0);
					label2.setLayoutData(label2LData);
					label2.setText("\u6a21\u677f:");
				}
			}
			this.layout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
