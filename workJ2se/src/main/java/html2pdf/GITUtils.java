package html2pdf;

import org.apache.commons.io.FileUtils;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.transport.CredentialsProvider;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.*;

public class GITUtils {
    public static File diff(EnvConfig env, String newCommit, String oldCommit) throws IOException {
        List<String> shContent = new ArrayList<>();
        shContent.add("#!/bin/bash");
        shContent.add("cd " + env.dir);

        File shFile = new File(new File(EnvConfig.BASH_PATH).getParentFile(), "_diff.sh");
        File outFile = new File(new File(EnvConfig.BASH_PATH).getParentFile(), "_patch.diff");

        shContent.add(MessageFormat.format("git diff {1} {2} > {3}", oldCommit, newCommit, toLinuxPath(outFile)));
        FileUtils.writeLines(shFile, shContent);
        System.out.println("shell file ok");
        String out = CommandUtils.runCommand(EnvConfig.BASH_PATH, "-c", shFile.getPath().replaceAll("\\\\", "/"));
        System.out.println(out);
        return outFile;
    }

    public static String toLinuxPath(File file) {
        //"c:\xxxx\xxx" -> "c/xxx/xxx"
        return "/" + file.getPath().replaceAll("\\\\", "/").replace(":", "");
    }

    public static Map<String, Ref> fetchGitBranches(String gitUrl) throws GitAPIException {
        TreeMap<String, Ref> nameAndHashMap = new TreeMap<>();
        CredentialsProvider cp = new UsernamePasswordCredentialsProvider(EnvConfig.GIT_ACCOUNT, EnvConfig.GIT_PWD);
        Collection<Ref> refs = Git.lsRemoteRepository()
                .setHeads(true)
                .setRemote(gitUrl)
                .setCredentialsProvider(cp)
                .call();
        for (Ref ref : refs) {
            nameAndHashMap.put(ref.getName().substring(ref.getName().lastIndexOf("/") + 1), ref);
        }
        return nameAndHashMap;
    }
}
