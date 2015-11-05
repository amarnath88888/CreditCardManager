package com.techkings.creditmgmt.index;

import java.awt.Dimension;
import java.awt.Toolkit;

public class RecallHomePage {
	public static void onClose() {
		HomePageLayout homePageLayout = new HomePageLayout();
		Dimension screenSize = Toolkit.getDefaultToolkit()
				.getScreenSize();
		final int HEIGHT = 300;
		final int WIDTH = 300;
		homePageLayout
				.setBounds(((screenSize.width / 2) - (WIDTH / 2)),
						((screenSize.height / 2) - (HEIGHT / 2)),
						WIDTH, HEIGHT);
		homePageLayout.setVisible(true);
	}
}
