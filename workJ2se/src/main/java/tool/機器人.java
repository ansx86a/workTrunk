package tool;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

/**
 * 此範例跑起來是滑鼠位移配合打字，不過中文字不行啊，只能打鍵盤上的字
 *
 * @author ai
 */
public class 機器人 {
    Robot robot = new Robot();

    public static void main(String[] args) throws AWTException {
        new 機器人();
    }

    public 機器人() throws AWTException {
        robot.setAutoDelay(40);
        robot.setAutoWaitForIdle(true);

        robot.delay(4000);
        robot.mouseMove(40, 130);
        robot.delay(500);

        leftClick();
        robot.delay(500);
        leftClick();

        robot.delay(500);
        type("Hello, world");

        robot.mouseMove(40, 160);
        robot.delay(500);

        leftClick();
        robot.delay(500);
        leftClick();

        robot.delay(500);
        type("This is a test of the Java Robot class");

        robot.delay(50);
        type(KeyEvent.VK_DOWN);

        robot.delay(250);
        type("Four score and seven years ago, our fathers ...");

        robot.delay(1000);
        System.exit(0);
    }

    private void leftClick() {
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.delay(200);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        robot.delay(200);
    }

    private void type(int i) {
        robot.delay(40);
        robot.keyPress(i);
        robot.keyRelease(i);
    }

    private void type(String s) {
        byte[] bytes = s.getBytes();
        for (byte b : bytes) {
            int code = b;
            // keycode only handles [A-Z] (which is ASCII decimal [65-90])
            if (code > 96 && code < 123)
                code = code - 32;
            robot.delay(40);
            robot.keyPress(code);
            robot.keyRelease(code);
        }
    }

    private void 未測測的複製貼上() {
        String filePath = "";
        try {
            Robot robot = new Robot();
            StringSelection ss = new StringSelection(filePath);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
            robot.delay(3000);

            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);

            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.delay(3000);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.delay(3000);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
