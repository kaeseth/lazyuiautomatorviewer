package com.android.uiautomator;

import java.io.*;

/*
 * auther:kaeseth
 * adbÂ·¾¶»º´æ
 */
public class AdbPath {

	private static String adbIndex="";
	public static boolean init() {
		String line=null;
		String temp=null;
		File f=new File("adbIndex.conf");
		FileReader  fr=null;
		if(!f.exists()) {
			return false;
		}
		try {
			fr=new FileReader(f);
			BufferedReader br=new BufferedReader(fr);
			
			while((line=br.readLine())!=null) {
				temp=line;
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(fr!=null) {
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		if(temp==null||temp.equals("")){
			return false;
		}
		else {
			adbIndex=temp;
		}
		return true;
	}
	public static boolean set(String value) {
		FileWriter fw=null;
		if(value==null||value.equals("")) {
			return false;
		}
		File f=new File("adbIndex.conf");
		if(!f.exists()) {
			try {
				f.createNewFile();
			}catch(Exception ex) {
				ex.printStackTrace();
				return false;
			}
		}
		adbIndex=value;
		try {
			fw=new FileWriter(f);
			fw.write(value);
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(fw!=null) {
				try {
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return true;
	}
	public static String get() {
		return adbIndex;
	}
}
