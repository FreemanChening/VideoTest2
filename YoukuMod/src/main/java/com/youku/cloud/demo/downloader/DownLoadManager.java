package com.youku.cloud.demo.downloader;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.youku.cloud.player.VideoDefinition;
import com.youku.cloud.utils.PlayerUiUtile;
import com.youku.download.DownInfo;
import com.youku.download.DownLoaderListener;
import com.youku.download.IDownLoadDelegate;

import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;

public class DownLoadManager {

	private IDownLoadDelegate downLoadDelegate;

	private DownLoadManager() {
		downLoadDelegate= PlayerUiUtile.getInstance().getDownLoadDelegate();
	}

	private static class SingletonHolder {// 构造线程安全的单例
		public final static DownLoadManager instance = new DownLoadManager();
	}

	public final static DownLoadManager getInstance() {
		return SingletonHolder.instance;
	}

	public boolean addNewPrivateDownLoad(String vid,String password, String name, VideoDefinition videoDefinition) {
		// TODO Auto-generated method stub
		return downLoadDelegate.addNewPrivateDownLoad(vid, password,false, name, videoDefinition);
	}
	public boolean addNewPrivateDownLoad(String vid, String password,boolean ismd5, String name, VideoDefinition videoDefinition) {
		// TODO Auto-generated method stub
		return downLoadDelegate.addNewPrivateDownLoad(vid, password, ismd5,name, videoDefinition);
	}
	public boolean addNewDownLoad(String vid, String name, VideoDefinition videoDefinition) {
		// TODO Auto-generated method stub
		return downLoadDelegate.addNewDownLoad(vid, "", name, videoDefinition);
	}
	public boolean deleteDownLoad(String vid) {
		// TODO Auto-generated method stub
		return downLoadDelegate.deleteDownLoad(vid);
	}

	public DownInfo getDownInfoByVid(String vid) {
		// TODO Auto-generated method stub
		return downLoadDelegate.getDownInfoByVid(vid);
	}

	public List<DownInfo> getDownInfos() {
		// TODO Auto-generated method stub
		return downLoadDelegate.getDownInfos();
	}

	public String getSaveAbsolutePath() {
		// TODO Auto-generated method stub
		return downLoadDelegate.getSaveAbsolutePath();
	}

	public boolean retryDownLoad(String vid) {
		// TODO Auto-generated method stub
		return downLoadDelegate.retryDownLoad(vid);
	}

	public void setDownLoaderListener(DownLoaderListener listener) {
		// TODO Auto-generated method stub
		downLoadDelegate.setDownLoaderListener(listener);
	}

	public void setSaveAbsolutePath(String path) {
		// TODO Auto-generated method stub
		downLoadDelegate.setSaveAbsolutePath(path);
	}

	public void setStartWhenPrepared(boolean arg0) {
		// TODO Auto-generated method stub
		downLoadDelegate.setStartWhenPrepared(arg0);
	}

	public boolean startDownLoad(String vid) {
		// TODO Auto-generated method stub
		return downLoadDelegate.startDownLoad(vid);
	}

	public boolean stopDownLoad(String vid) {
		// TODO Auto-generated method stub
		return downLoadDelegate.stopDownLoad(vid);
	}

}
