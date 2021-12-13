package git;

import java.io.File;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.Status;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.junit.Test;

public class GitTest {

    @Test
    public void test() throws GitAPIException {
        System.out.println("test");
        Git myGitRepo = Git.init().setDirectory(new File("C:\\allen\\gitgroup\\worktrunk\\")).call();
        Status status = myGitRepo.status().call();
        System.out.println("Untracked 對應 Added");
        for (String file : status.getUntracked()) {
            System.out.println("Untracked 未簽入;" + file);
        }
        System.out.println("Missing 對應 Removed");
        for (String file : status.getMissing()) {
            System.out.println("Missing 未簽入;" + file);
        }
        System.out.println("Modified 對應 changed");
        for (String modifiedFile : status.getModified()) {
            System.out.println("Modified 修改未stage - " + modifiedFile);
        }
        for (String file : status.getRemoved()) {
            System.out.println("Removed 移除;" + file);
        }
        for (String file : status.getConflicting()) {
            System.out.println("Conflicting 衝突;" + file);
        }
        for (String file : status.getAdded()) {
            System.out.println("Added 新增：" + file);
        }
        for (String file : status.getChanged()) {
            System.out.println("changed ：" + file);
        }
//        System.out.println("UncommittedChanges = 保含新增刪除和異動");
//        for (String file : status.getUncommittedChanges()) {
//            System.out.println("UncommittedChanges ;" + file);
//        }
        System.out.println("test end");
    }

}
