package com.bufferteknoloji.extract.b;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

final class f
  extends DefaultTableCellRenderer
{
  private b paramb;

f(b paramb) {
	this.paramb = paramb;}
  
  public final Component getTableCellRendererComponent(JTable paramJTable, Object paramObject, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2)
  {
//    (paramJTable = new JLabel(String.valueOf(paramObject))).setOpaque(true);
    JLabel jLabel = new JLabel(String.valueOf(paramObject));
	jLabel.setOpaque(true);
	jLabel.setHorizontalAlignment(0);
//    paramJTable.setFont(b.a(this.a));
    if (paramInt1 % 2 == 0) {
//      paramJTable.setBackground(b.b(this.a));
    } else {
      paramJTable.setBackground(Color.white);
    }
    if (paramBoolean1) {
//      paramJTable.setBackground(b.c(this.a));
    }
    return paramJTable;
  }
}
