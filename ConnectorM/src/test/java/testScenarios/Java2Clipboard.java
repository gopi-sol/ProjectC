package testScenarios;

import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;

public class Java2Clipboard implements ClipboardOwner {
    @SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {
      Java2Clipboard jc = new Java2Clipboard();
      jc.toClipboard();
      Frame f = new Frame
         ("Open a text editor and paste the message from Java");
      f.setSize(600,10);
      f.show();
    }

    @SuppressWarnings("deprecation")
	public void toClipboard() {
      SecurityManager sm = System.getSecurityManager();
      if (sm != null) {
        try {
           sm.checkSystemClipboardAccess();
           }
        catch (Exception e) {e.printStackTrace();}
        }
      Toolkit tk = Toolkit.getDefaultToolkit();
      StringSelection st = 
           new StringSelection("Hello world from Java");
      Clipboard cp = tk.getSystemClipboard();
      cp.setContents(st, this);
    }

    public void lostOwnership(Clipboard clip, Transferable tr) { 
       System.out.println("Lost Clipboard Ownership?!?");
    }

	
}
