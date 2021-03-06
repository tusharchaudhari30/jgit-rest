package com.tushar.dev.config;

import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class GitProperties {

    private String uriRepository(String project) {
        return new StringBuilder(getBaseDirectory(project))
                .append(File.separator).append(".git").toString();
    }

    public String getBaseDirectory(String projectName) {
        return new StringBuilder(System.getProperty("user.home"))
                .append(File.separator).append("projects")
                .append(File.separator).append(projectName)
                .toString();
    }

    public File getBaseGitDir(String projectName) {
        return new File(uriRepository(projectName));
    }

    public List<File> createFolder(String projectName, List<String> folderNames) throws IOException {
        List<File> gitkeep = new ArrayList<>();
        for (String name : folderNames) {
            String folderLocation = new StringBuilder(getBaseDirectory(projectName))
                    .append(File.separator)
                    .append(name)
                    .toString();
            File folder = new File(folderLocation);
            boolean dir = folder.mkdirs();
            if (dir) {
                File gitKeep = new File(
                        new StringBuilder(folderLocation)
                                .append(File.separator)
                                .append(".gitkeep").toString());
                gitKeep.createNewFile();
                gitkeep.add(gitKeep);
            }
        }
        return gitkeep;
    }


    public String uriAbsoluteRepository(String project) {
        return new StringBuilder(System.getProperty("user.home"))
                .append(File.separator).append(project).toString();
    }

    public Repository getRepository(String projectName) throws IOException {
        return new FileRepositoryBuilder()
                .setGitDir(getBaseGitDir(projectName))
                .readEnvironment()
                .setup()
                .findGitDir()
                .build();
    }
}
