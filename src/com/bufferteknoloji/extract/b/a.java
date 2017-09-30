/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.bufferteknoloji.extract.b;
 
import com.bufferteknoloji.extract.CharsetDetector;
import com.bufferteknoloji.extract.a.d;
import com.itextpdf.awt.geom.Rectangle2D;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfArray;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfNumber;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.FilteredTextRenderListener;
import com.itextpdf.text.pdf.parser.LocationTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import com.itextpdf.text.pdf.parser.RegionTextRenderFilter;
import com.itextpdf.text.pdf.parser.RenderFilter;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;

/**
 * @author Edmar
 *
 */
public final class a extends SwingWorker {
	private JProgressBar a;
	private JTable b;
	private String c;
	private int d;
	private int e;
	private List f;
	private int g = 0;

	public a(JProgressBar paramJProgressBar, JTable paramJTable, String paramString, int paramInt1, int paramInt2) {
		this.a = paramJProgressBar;
		this.b = paramJTable;
		this.c = paramString;
		this.d = paramInt1;
		this.e = paramInt2;
	}

	private Integer b() {
		Object localObject;
		try {
			 File f = new File(this.c);

		        String[] charsetsToBeTested = {"UTF-8", "windows-1253", "ISO-8859-7"};

		        CharsetDetector cd = new CharsetDetector();
		        Charset charset = cd.detectCharset(f, charsetsToBeTested);
		        System.out.println(charset);
			PdfReader pdfReader = new PdfReader(this.c);
			localObject = pdfReader;
			this.f = a((PdfReader) localObject);
		} catch (Exception localException) {
			localException.printStackTrace();
		}
		return ((Integer) Integer.valueOf(1));
	}

	protected final void done() {
		super.done();
		this.a.setValue(0);
		DefaultTableModel localDefaultTableModel;
		Object localObject1;
		a thisA = (a) (localObject1 = this);
		
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		defaultTableModel.addColumn("Página");
		defaultTableModel.addColumn("Texto");
		localDefaultTableModel = (DefaultTableModel) thisA.b.getModel();
		(localDefaultTableModel = (DefaultTableModel) thisA.b.getModel()).setRowCount(0);
		if(f == null)
			b();
		List lista = ((a) localObject1).f;
		int i = 0;
		for (Object object : lista) {
			Object itemLinha = (d) object;
			System.out.println("estamos aqui:" + i);
			Object[] listaDeItens = new Object[] { Integer.valueOf(((d) itemLinha).a()), ((d) itemLinha).b() };
			defaultTableModel.addRow(listaDeItens);
			i++;
		}
		thisA.b.setModel(defaultTableModel);
//		localObject1 = lista.iterator();
//		while (((Iterator) localObject1).hasNext()) {
//			Object localObject2 = (d) ((Iterator) localObject1).next();
//			System.out.println(((Iterator) localObject1).);
//			localObject2 = new Object[] { Integer.valueOf(((d) localObject2).a()), ((d) localObject2).b() };
//			localDefaultTableModel.addRow((Object[]) localObject2);
//		}
		System.out.println("aaaaa");
	}

	@SuppressWarnings("unchecked")
	private List a(PdfReader paramPdfReader) {
		ArrayList localArrayList = new ArrayList();
		int i = paramPdfReader.getNumberOfPages();
		this.a.setMaximum(this.e - this.d + 1);
		int i3 = i;
		int i1 = this.e;
		int l;
		if ((l = this.d) <= 1)
			l = 1;
		if ((i1 <= 0) || (i1 > i3))
			i1 = i3;
		if (l > i1) {
			int i2 = i1;
			i1 = l;
			l = i2;
		}
		int[] arrayOfInt = { l, i1 };
		this.d = arrayOfInt[0];
		this.e = arrayOfInt[1];
		for (int f1 = this.d; f1 <= this.e; ++f1) {
			this.a.setValue(this.g++);
			publish(new Void[0]);
			a locala;
			i1 = (locala = this).e - locala.d + 1;
			double d1;
			setProgress((int) Math.round(d1 = locala.g * 100.0D / i1));
			PdfArray localPdfArray;
			if ((localPdfArray = paramPdfReader.getPageN(f1).getAsArray(PdfName.ANNOTS)) == null)
				continue;
			for (int j = 0; j < localPdfArray.size(); ++j) {
				Object localObject1;
				PdfName localPdfName = ((PdfDictionary) (localObject1 = localPdfArray.getAsDict(j))).getAsName(PdfName.SUBTYPE);
				if (!(PdfName.HIGHLIGHT.equals(localPdfName)))
					continue;
				localObject1 = (PdfArray) ((PdfDictionary) localObject1).get(PdfName.QUADPOINTS);
				String texto = "";
				for (int k = 0; k < ((PdfArray) localObject1).size(); k += 8) {
					float f2 = ((PdfArray) localObject1).getAsNumber(k).floatValue();
					float f3 = ((PdfArray) localObject1).getAsNumber(k + 1).floatValue();
					float f4 = ((PdfArray) localObject1).getAsNumber(k + 6).floatValue();
					float f5 = ((PdfArray) localObject1).getAsNumber(k + 7).floatValue();
					Object localObject2 = new Rectangle(f2, f3, f4, f5);
					Object localObject3 = localObject2;
					f3 = f1;
					localObject2 = paramPdfReader;
					RegionTextRenderFilter localRegionTextRenderFilter = new RegionTextRenderFilter((com.itextpdf.text.Rectangle) localObject3);
					FilteredTextRenderListener localFilteredTextRenderListener = new FilteredTextRenderListener(
							new LocationTextExtractionStrategy(), new RenderFilter[] { localRegionTextRenderFilter });
					try {
						localObject2 = localObject2 = PdfTextExtractor.getTextFromPage((PdfReader) localObject2, f1,
								localFilteredTextRenderListener);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					texto += (String) localObject2;
				}
				d locald;
				(locald = new d()).a(f1);
				locald.b((String) texto);
				localArrayList.add(locald);
			}
		}
		return ((List) (List) localArrayList);
	}

	public static byte[] encode(byte[] arr, String fromCharsetName) {
	    return encode(arr, Charset.forName(fromCharsetName), Charset.forName("UTF-8"));
	}

	public static byte[] encode(byte[] arr, String fromCharsetName, String targetCharsetName) {
	    return encode(arr, Charset.forName(fromCharsetName), Charset.forName(targetCharsetName));
	}

	public static byte[] encode(byte[] arr, Charset sourceCharset, Charset targetCharset) {

	    ByteBuffer inputBuffer = ByteBuffer.wrap( arr );

	    CharBuffer data = sourceCharset.decode(inputBuffer);

	    ByteBuffer outputBuffer = targetCharset.encode(data);
	    byte[] outputData = outputBuffer.array();

	    return outputData;
	}
	public final List a() {
		return this.f;
	}

	@Override
	protected Object doInBackground() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}