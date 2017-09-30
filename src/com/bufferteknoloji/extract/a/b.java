package com.bufferteknoloji.extract.a;

import javax.swing.JMenuItem;

final class b
  extends JMenuItem
{
  public b(String paramString)
  {
    super("$" + paramString);
    addActionListener(new c(this));
  }
}
