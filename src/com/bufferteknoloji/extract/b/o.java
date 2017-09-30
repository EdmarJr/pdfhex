package com.bufferteknoloji.extract.b;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.SwingUtilities;

final class o extends FocusAdapter {
	private n paramn;

	o(n paramn) {
		this.paramn = paramn;
	}
	
	

	public n getParamn() {
		return paramn;
	}



	public void setParamn(n paramn) {
		this.paramn = paramn;
	}



	public final void focusGained(FocusEvent paramFocusEvent) {
		SwingUtilities.invokeLater(new p(this));
	}
}
