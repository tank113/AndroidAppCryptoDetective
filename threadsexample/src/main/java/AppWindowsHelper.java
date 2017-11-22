public class AppWindowsHelper {

        public static void main(String[] args)
        {
            AppWindows appWindows = new AppWindows();
            Thread wordThread = new Thread(appWindows, "TestCase1");
            Thread paintThread = new Thread(appWindows, "Testcase2");
            wordThread.start();
            paintThread.start();
        }
    }


