package com.bufferteknoloji.extract.b;

import java.io.File;

import javax.swing.filechooser.FileFilter;

final class e
  extends FileFilter
{
  private b paramb;

e(b paramb) {
		this.paramb = paramb;
	  
	  
  }
  
  public final String getDescription()
  {
    return null;
  }
  
  public final boolean accept(File paramFile)
  {
    int i;
    return (!paramFile.isDirectory()) & paramFile.getName().toLowerCase().endsWith(".pdf");
  }
}
