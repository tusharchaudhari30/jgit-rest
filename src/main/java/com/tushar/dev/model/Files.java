package com.tushar.dev.model;


public class Files {

    private String fileName;
    private boolean folder;
    private String path;

    public Files() {
    }

    public Files(String fileName, boolean folder, String path) {
        this.fileName = fileName;
        this.folder = folder;
        this.path = path;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public boolean isFolder() {
        return folder;
    }

    public void setFolder(boolean folder) {
        this.folder = folder;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
