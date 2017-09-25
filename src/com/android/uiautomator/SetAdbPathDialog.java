package com.android.uiautomator;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import java.io.File;
import com.android.uiautomator.AdbPath;

/*
 * auther:kaeseth
 * 设置adb路径的面板
 */
public class SetAdbPathDialog extends Dialog {
	private static final int FIXED_TEXT_FIELD_WIDTH = 300;
    private static final int DEFAULT_LAYOUT_SPACING = 10;
    private Text AdbPathText;
    private String adbIndex;

	public SetAdbPathDialog(Shell parentShell) {
		super(parentShell);
		// TODO Auto-generated constructor stub
	}
	
	@Override
    protected Control createDialogArea(Composite parent) {
	
		Composite container = (Composite) super.createDialogArea(parent);
		GridLayout gl_container = new GridLayout(1, false);
        gl_container.verticalSpacing = DEFAULT_LAYOUT_SPACING;
        gl_container.horizontalSpacing = DEFAULT_LAYOUT_SPACING;
        gl_container.marginWidth = DEFAULT_LAYOUT_SPACING;
        gl_container.marginHeight = DEFAULT_LAYOUT_SPACING;
        container.setLayout(gl_container);
        
        Group openAdbPathGroup = new Group(container, SWT.NONE);
        openAdbPathGroup.setLayout(new GridLayout(2, false));
        openAdbPathGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        openAdbPathGroup.setText("Adb Path");
        
        AdbPathText = new Text(openAdbPathGroup, SWT.BORDER);
        
        Button openAdbPathButton = new Button(openAdbPathGroup, SWT.NONE);
        openAdbPathButton.setText("...");
        openAdbPathButton.addListener(SWT.Selection, new Listener() {
            @Override
            public void handleEvent(Event event) {
            	handleOpenAdbIndex();
            }
        });
        
		return container;
	}
	private void handleOpenAdbIndex() {
		DirectoryDialog fd = new DirectoryDialog(getShell(), SWT.OPEN);
        fd.setText("Open Adb parent index");
        String adbIndexPath=fd.open();
        if(adbIndexPath==null||adbIndexPath.equals("")) {
        	return;
        }
        this.adbIndex=adbIndexPath;
        this.AdbPathText.setText(adbIndexPath);
    }
	public String getAdbPathText() {
		return this.adbIndex;
	}
}
