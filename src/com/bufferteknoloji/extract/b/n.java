package com.bufferteknoloji.extract.b;

import java.text.NumberFormat;
import javax.swing.JFormattedTextField;
import javax.swing.text.NumberFormatter;
 
public final class n
  extends JFormattedTextField
{
  private static NumberFormat a;
//  private static NumberFormat a = ;
  private static NumberFormatter b;
  
  public n()
  {
    super(b);
    addFocusListener(new o(this));
  }
  
  static
  {
    (b = new NumberFormatter(a)).setValueClass(Integer.class);
    b.setAllowsInvalid(false);
    b.setCommitsOnValidEdit(true);
  }
}
