package com.bufferteknoloji.extract.b;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.io.File;
import java.io.PrintStream;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import net.miginfocom.swing.MigLayout;

public class b
  extends JFrame
{
  private JTextField a;
  private JTable b;
  private n c;
  private JProgressBar d;
  private n e;
  private final JFileChooser f = new JFileChooser(new File("."));
  private final JPopupMenu g = com.bufferteknoloji.extract.a.a.a();
  private FontMetrics h;
  private final Color i = Color.orange;
  private final Color j = Color.lightGray;
  private a k;
  private Font l;
  private DefaultTableModel m = new c(this);
  private DefaultTableCellRenderer n = new f(this);
  private DefaultTableCellRenderer o = new g(this);
  
  public b()
  {
	 Object localObject1;
    setIconImage(Toolkit.getDefaultToolkit().getImage(b.class.getResource("/resource/app.png")));
    e();
    b localb = this;
    setDefaultCloseOperation(3);
    localb.setTitle("PDF Highlight Extractor");
    localb.getContentPane().setLayout(new MigLayout("", "[grow]", "[][grow,fill][fill][fill]"));
    ((JPanel) (localObject1 = new JPanel())).setOpaque(false);
    ((JPanel)localObject1).setBorder(new LineBorder(Color.LIGHT_GRAY));
    localb.getContentPane().add((Component)localObject1, "cell 0 0,grow");
    ((JPanel)localObject1).setLayout(new MigLayout("", "[fill][grow,fill][fill][fill]", "[fill][36:n,fill]"));
    Object localObject2 = new JLabel("Path To Pdf File");
    ((JPanel)localObject1).add((Component)localObject2, "cell 0 0");
    localb.a = new JTextField();
    localb.a.setFont(new Font("Tahoma", 1, 12));
    ((JPanel)localObject1).add(localb.a, "cell 1 0");
    localb.a.setColumns(10);
    ((JButton)(localObject2 = new JButton())).setIcon(new ImageIcon(b.class.getResource("/resource/search.png")));
    ((JButton)localObject2).addActionListener(new h(localb));
    ((JPanel)localObject1).add((Component)localObject2, "cell 2 0");
    ((JButton) (localObject2 = new JButton("Extract"))).setIcon(new ImageIcon(b.class.getResource("/resource/extract.png")));
    ((JButton)localObject2).addActionListener(new i(localb));
    ((JPanel)localObject1).add((Component)localObject2, "cell 3 0");
    localObject2 = new JLabel("Pages");
    ((JPanel)localObject1).add((Component)localObject2, "cell 0 1,alignx trailing");
    localb.c = new n();
    localb.c.setFont(new Font("Tahoma", 1, 12));
    localb.c.setMinimumSize(new Dimension(80, 0));
    localb.c.setEditable(false);
    localb.c.setEnabled(false);
    localb.c.setHorizontalAlignment(0);
    ((JPanel)localObject1).add(localb.c, "flowx,cell 1 1,growx 0,alignx left");
    localObject2 = new JLabel("to");
    ((JPanel)localObject1).add((Component)localObject2, "cell 1 1,growx 0,alignx left");
    localb.e = new n();
    localb.e.setFont(new Font("Tahoma", 1, 12));
    localb.e.setMinimumSize(new Dimension(80, 0));
    localb.e.setEditable(false);
    localb.e.setEnabled(false);
    localb.e.setHorizontalAlignment(0);
    ((JPanel)localObject1).add(localb.e, "cell 1 1,growx 0,alignx left");
    ((JCheckBox)(localObject2 = new JCheckBox("All Pages"))).setSelected(true);
    ((JCheckBox)localObject2).addItemListener(new j(localb));
    ((JPanel)localObject1).add((Component)localObject2, "cell 1 1");
    localb.b = new JTable();
    localb.b.setOpaque(false);
    localb.b.setAutoResizeMode(3);
    localb.b.setRowSelectionAllowed(true);
    localb.b.setSelectionMode(0);
    ((JScrollPane)(localObject1 = new JScrollPane(localb.b))).getViewport().setOpaque(false);
    localb.getContentPane().add((Component)localObject1, "cell 0 1,grow");
    localb.d = new JProgressBar();
    localb.getContentPane().add(localb.d, "cell 0 2,growx");
    ((JPanel)(localObject1 = new JPanel())).setLayout(new MigLayout("insets 0", "[right][grow][right][right]", "[36px]"));
    ((JPanel)localObject1).setOpaque(false);
    ((JPanel)localObject1).setBorder(new LineBorder(Color.LIGHT_GRAY));
    localb.getContentPane().add((Component)localObject1, "cell 0 3,grow");
    ((JButton)(localObject2 = new JButton("Close"))).setIcon(new ImageIcon(b.class.getResource("/resource/close.png")));
    ((JButton)localObject2).addActionListener(new k(localb));
    JButton localJButton1;
    (localJButton1 = new JButton("Text")).setIcon(new ImageIcon(b.class.getResource("/resource/txt.png")));
    localJButton1.addActionListener(new l(localb));
    JButton localJButton2;
    (localJButton2 = new JButton("Excel")).setIcon(new ImageIcon(b.class.getResource("/resource/excel.png")));
    localJButton2.addActionListener(new m(localb));
    JButton localJButton3;
    (localJButton3 = new JButton()).setBorderPainted(false);
    localJButton3.setContentAreaFilled(false);
    localJButton3.addMouseListener(new d(localb));
    localJButton3.setIcon(new ImageIcon(b.class.getResource("/resource/paypal_donate.gif")));
    localJButton3.setComponentPopupMenu(localb.g);
    ((JPanel)localObject1).add(localJButton3, "cell 0 0");
    ((JPanel)localObject1).add(localJButton2, "cell 1 0,alignx right,aligny center");
    ((JPanel)localObject1).add(localJButton1, "cell 2 0,alignx left,aligny center");
    ((JPanel)localObject1).add((Component)localObject2, "cell 3 0,growx 0,alignx right,aligny center");
    localb.setSize(800, 600);
    localb.setLocationRelativeTo(null);
    localb = this;
    this.m.addColumn("Page");
    localb.m.addColumn("Text");
    localb.b.setModel(localb.m);
    ((TableColumn)(localObject1 = localb.b.getColumnModel().getColumn(0))).setMinWidth(100);
    ((TableColumn)localObject1).setMaxWidth(100);
    ((TableColumn)localObject1).setCellRenderer(localb.n);
    ((TableColumn)localObject1).setCellRenderer(localb.n);
    ((TableColumn)(localObject2 = localb.b.getColumnModel().getColumn(1))).setCellRenderer(localb.o);
    localb = this;
    Object localObject3 = new JTextArea();
    localb.h = ((JTextArea)localObject3).getFontMetrics(((JTextArea)localObject3).getFont());
    localObject2 = new JLabel();
    localb.l = ((JLabel)localObject2).getFont().deriveFont(1);
    System.out.println("PASSOU AQUI");
  }
  
  private static void e()
  {
    try
    {
      UIManager.LookAndFeelInfo[] arrayOfLookAndFeelInfo;
      int i1 = (arrayOfLookAndFeelInfo = UIManager.getInstalledLookAndFeels()).length;
      for (int i2 = 0; i2 < i1; i2++)
      {
        UIManager.LookAndFeelInfo localLookAndFeelInfo = arrayOfLookAndFeelInfo[i2];
        if ("Nimbus".equals(localLookAndFeelInfo.getName()))
        {
          UIManager.setLookAndFeel(localLookAndFeelInfo.getClassName());
          return;
        }
      }
      return;
    }
    catch (Exception localException1)
    {
      try
      {
        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        return;
      }
      catch (Exception localException2) {}
    }
  }
  
  protected final void a()
  {
    e locale = new e(this);
    this.f.setFileFilter(locale);
    this.f.setFileSelectionMode(0);
    int i1;
    if ((i1 = this.f.showDialog(this, "Choose .pdf File")) == 0)
    {
      File localFile = this.f.getSelectedFile();
      this.a.setText(localFile.getAbsolutePath());
      int i2 = com.bufferteknoloji.extract.a.d.a(this.f.getSelectedFile().getAbsolutePath());
      this.c.setText("1");
      this.e.setText(String.valueOf(i2));
    }
  }
  
  protected final void b()
  {
    File localFile;
    if (((localFile = this.f.getSelectedFile()) == null) || (!localFile.exists()))
    {
      a(".pdf file couldn't be found !!!");
      return;
    }
    int[] arrayOfInt = f();
    this.k = new a(this.d, this.b, localFile.getAbsolutePath(), arrayOfInt[0], arrayOfInt[1]);
    this.k.done();
  }
  
  private int[] f()
  {
    int i1;
    try
    {
      i1 = Integer.parseInt(this.c.getValue().toString());
    }
    catch (Exception localException1)
    {
      i1 = -1;
    }
    int i2;
    try
    {
      i2 = Integer.parseInt(this.e.getValue().toString());
    }
    catch (Exception localException2)
    {
      i2 = -1;
    }
    return new int[] { i1, i2 };
  }
  
  protected final void a(ItemEvent paramItemEvent)
  {
//    paramItemEvent = paramItemEvent.getStateChange() == 2 ? 1 : 0;
//    this.c.setEditable(paramItemEvent);
//    this.c.setEnabled(paramItemEvent);
//    this.e.setEditable(paramItemEvent);
//    this.e.setEnabled(paramItemEvent);
//    if (paramItemEvent == 0)
//    {
//      this.c.setValue(null);
//      this.e.setValue(null);
//    }
	  
	    this.c.setEditable(paramItemEvent.getStateChange() == 2);
	    this.c.setEnabled(paramItemEvent.getStateChange() == 2);
	    this.e.setEditable(paramItemEvent.getStateChange() == 2);
	    this.e.setEnabled(paramItemEvent.getStateChange() == 2);
	    if (paramItemEvent.getStateChange() == 2)
	    {
	      this.c.setValue(null);
	      this.e.setValue(null);
	    }
  }
  
  private boolean g()
  {
    boolean bool;
    if (bool = (this.k != null) && (this.k.a() != null) ? true : false) {
      a(".pdf file should be chosen !!!");
    }
    return bool;
  }
  
  protected final void c()
  {
    Object localObject1 = this;
    boolean bool;
    if (!(bool = g())) {
      return;
    }
    try
    {
      List localList = this.k.a();
      localObject1 = ((File)(localObject1 = File.createTempFile("export_", ".xls"))).getAbsolutePath();
      WritableSheet localWritableWorkbook;
      localObject1 = new File((String)localObject1);
      WritableWorkbook workbook = Workbook.createWorkbook((File) localObject1);
      WritableSheet localWritableSheet = (localWritableWorkbook = workbook.createSheet("Highlights", 0));
      for (int i1 = 0; i1 < localList.size(); i1++)
      {
        Object localObject2 = (com.bufferteknoloji.extract.a.d)localList.get(i1);
        Label localLabel = new Label(0, i1, String.valueOf(((com.bufferteknoloji.extract.a.d)localObject2).a()));
        localObject2 = new Label(1, i1, ((com.bufferteknoloji.extract.a.d)localObject2).b());
        localWritableSheet.addCell(localLabel);
        localWritableSheet.addCell((WritableCell)localObject2);
      }
      workbook.write();
      workbook.close();
      Desktop localDesktop;
      (localDesktop = Desktop.getDesktop()).open((File)localObject1);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected final void d()
  {
    Object localObject = this;
    boolean bool;
    if (!(bool = g())) {
      return;
    }
    try
    {
      List localList = this.k.a();
      localObject = ((File)(localObject = File.createTempFile("export_", ".txt"))).getAbsolutePath();
      localObject = new File((String)localObject);
      PrintStream localPrintStream = new PrintStream((File)localObject);
      for (int i1 = 0; i1 < localList.size(); i1++)
      {
        com.bufferteknoloji.extract.a.d locald = (com.bufferteknoloji.extract.a.d)localList.get(i1);
        localPrintStream.println(locald.b());
      }
      localPrintStream.close();
      Desktop localDesktop;
      (localDesktop = Desktop.getDesktop()).open((File)localObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void a(String paramString)
  {
    JOptionPane.showMessageDialog(this, paramString, "Warning !!!", 2);
  }
}
