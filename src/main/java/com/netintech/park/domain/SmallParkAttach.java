package com.netintech.park.domain;

import com.netintech.core.web.domain.BaseEntity;

public class SmallParkAttach extends BaseEntity {

    private Long id;
    private Long parkId;
    private String fileUuid;
    private String fileName;
    private String fileAlias;
    private String filePath;
    private String delFlag;

    public SmallParkAttach() {

    }

    public SmallParkAttach(Long parkId, String fileUuid, String fileName, String fileAlias, String filePath, String delFlag) {
        this.parkId = parkId;
        this.fileUuid = fileUuid;
        this.fileName = fileName;
        this.fileAlias = fileAlias;
        this.filePath = filePath;
        this.delFlag = delFlag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParkId() {
        return parkId;
    }

    public void setParkId(Long parkId) {
        this.parkId = parkId;
    }

    public String getFileUuid() {
        return fileUuid;
    }

    public void setFileUuid(String fileUuid) {
        this.fileUuid = fileUuid;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileAlias() {
        return fileAlias;
    }

    public void setFileAlias(String fileAlias) {
        this.fileAlias = fileAlias;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }
}
