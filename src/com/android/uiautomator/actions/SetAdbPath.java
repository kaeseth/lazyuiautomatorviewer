package com.android.uiautomator.actions;

import com.android.uiautomator.AdbPath;
import com.android.uiautomator.DebugBridge;
import com.android.uiautomator.OpenDialog;
import com.android.uiautomator.SetAdbPathDialog;
import com.android.uiautomator.UiAutomatorModel;
import com.android.uiautomator.UiAutomatorViewer;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.eclipse.swt.widgets.Display;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;

/*
 * auther:kaeseth
 * 设置adb路径的动作
 */
public class SetAdbPath extends Action {

	private UiAutomatorViewer mViewer;

    public SetAdbPath(UiAutomatorViewer viewer) {
        super("&Setup");

        mViewer = viewer;
    }
	@Override
	public void run() {
		SetAdbPathDialog d = new SetAdbPathDialog(Display.getDefault().getActiveShell());
        if (d.open() != OpenDialog.OK) {
            return;
        }
        String temp=d.getAdbPathText();
        AdbPath.set(temp);
        //重新初始化
        DebugBridge.init();
	}
}
