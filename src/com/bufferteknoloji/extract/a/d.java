package com.bufferteknoloji.extract.a;

import com.itextpdf.text.pdf.PdfReader;

public class d
{
  private int a;
  private String b;
  
  public static int a(String paramString)
  {
    int i = -1;
    PdfReader localPdfReader = null;
    try
    {
      i = (localPdfReader = new PdfReader(paramString)).getNumberOfPages();
    }
    catch (Exception localException) {}finally
    {
      localPdfReader.close();
    }
    return i;
  }
  
  public static int a(String paramString, char paramChar)
  {
    paramChar = '\000';
    for (int i = 0; i < paramString.length(); i++) {
      if (paramString.charAt(i) == '\n') {
        paramChar++;
      }
    }
    return paramChar;
  }
  
  public void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void b(String paramString)
  {
    this.b = paramString;
  }
  
  public int a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.b;
  }
}
