package com.bufferteknoloji.extract.b;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

final class j
  implements ItemListener
{
  private b paramb;

j(b paramb) {
	this.paramb = paramb;}
  
  public final void itemStateChanged(ItemEvent paramItemEvent)
  {
	  paramb.a(paramItemEvent);
//    this.a.a(paramItemEvent);
  }
}
