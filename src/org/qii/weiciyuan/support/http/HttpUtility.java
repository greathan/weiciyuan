package org.qii.weiciyuan.support.http;


import org.qii.weiciyuan.support.error.WeiboException;
import org.qii.weiciyuan.support.file.FileDownloaderHttpHelper;
import org.qii.weiciyuan.support.file.FileUploaderHttpHelper;

import java.util.Map;

public class HttpUtility {

    private static HttpUtility httpUtility = new HttpUtility();

    private HttpUtility() {
    }

    public static HttpUtility getInstance() {
        return httpUtility;
    }


    public String executeNormalTask(HttpMethod httpMethod, String url, Map<String, String> param) throws WeiboException {
        return new JavaHttpUtility().executeNormalTask(httpMethod, url, param);
    }

    public boolean executeDownloadTask(String url, String path, FileDownloaderHttpHelper.DownloadListener downloadListener) {
        return new JavaHttpUtility().doGetSaveFile(url, path, downloadListener);
    }

    public boolean executeUploadTask(String url, Map<String, String> param, String path, FileUploaderHttpHelper.ProgressListener listener) throws WeiboException {
        return new JavaHttpUtility().doUploadFile(url, param, path, listener);
    }
}

