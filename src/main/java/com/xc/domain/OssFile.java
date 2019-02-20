package com.xc.domain;

/**
 * OSSFile
 * 
 * @author star
 * @date 2018/9/18 上午11:27
 */
public class OssFile extends BaseDO {
    private static final long serialVersionUID = -8352691983113844334L;

    private String            fileName;

    private String            url;

    public OssFile(String fileName, String url) {
        this.fileName = fileName;
        this.url = url;
    }

    public String getFileName() {
        return fileName;
    }

    public String getUrl() {
        return url;
    }
}
