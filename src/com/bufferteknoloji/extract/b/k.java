package com.bufferteknoloji.extract.b;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

final class k implements ActionListener {
	private b paramb;

	k(b paramb) {
		this.paramb = paramb;
	}

	public final void actionPerformed(ActionEvent paramActionEvent) {
		paramb.dispose();
	}
}
