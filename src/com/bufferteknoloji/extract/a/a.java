package com.bufferteknoloji.extract.a;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import javax.swing.JPopupMenu;

public final class a
{
  private static final LinkedHashMap a;
  
  private static String b(String paramString)
  {
    a.put("amount", paramString);
    paramString = "https://www.paypal.com/cgi-bin/webscr?";
    int i = 1;
    Iterator localIterator = a.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (i == 0) {
        paramString = paramString + "&";
      }
      i = 0;
      paramString = paramString + str + "=" + (String)a.get(str);
    }
    return paramString;
  }
  
  public static JPopupMenu a()
  {
    JPopupMenu localJPopupMenu;
    (localJPopupMenu = new JPopupMenu()).add(new b("1.00"));
    localJPopupMenu.add(new b("2.00"));
    localJPopupMenu.add(new b("3.00"));
    localJPopupMenu.add(new b("4.00"));
    localJPopupMenu.add(new b("5.00"));
    return localJPopupMenu;
  }
  
  static
  {
    (a = new LinkedHashMap()).put("cmd", "_donations");
    a.put("business", "UXHM74FWCRADQ");
    a.put("lc", "GB");
    a.put("item_name", "buffer-teknoloji");
    a.put("item_number", "pdf-highlight-extractor");
    a.put("amount", "2.00");
    a.put("currency_code", "USD");
    a.put("bn", "PP-DonationsBF:btn_donate_LG.gif:NonHosted");
  }
}
