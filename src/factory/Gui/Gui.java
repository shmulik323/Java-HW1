package factory.Gui;

import javax.swing.SwingUtilities;

public class Gui implements Runnable{
	private static Mainframe frame;

		public static void main(String[] args) {
			
			SwingUtilities.invokeLater(new Runnable() {

				@Override
				public void run() {
					frame = new Mainframe();

				}
			});
		

		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
}
