package com.bufferteknoloji.extract.b;

import com.bufferteknoloji.extract.a.d;
import java.awt.Color;
import java.awt.Component;
import java.awt.FontMetrics;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableCellRenderer;

final class g
  extends DefaultTableCellRenderer
{
  private b paramb;

g(b paramb) {
	this.paramb = paramb;}
  
  public final Component getTableCellRendererComponent(JTable paramJTable, Object paramObject, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2)
  {
//    (paramBoolean2 = new JTextArea()).setBorder(null);
    JTextArea jTextArea = new JTextArea();
    jTextArea.setBorder(null);
    jTextArea.setOpaque(true);
    jTextArea.setWrapStyleWord(false);
    jTextArea.setLineWrap(true);
    if (paramObject != null)
    {
      paramInt2 = d.a((String)paramObject, '\n');
//      paramInt2 = b.d(this.a).getHeight() * (paramInt2 + 1) + 5;
      paramInt2 = paramb.getHeight() * (paramInt2 + 1) + 5;
      paramJTable.setRowHeight(paramInt1, paramInt2);
      jTextArea.setText((String)paramObject);
    }
    if (paramInt1 % 2 == 0) {
//      jTextArea.setBackground(b.b(this.a));
    } else {
      jTextArea.setBackground(Color.white);
    }
    if (paramBoolean1) {
//      jTextArea.setBackground(b.c(this.a));
    }
    return jTextArea;
  }
}
