package pdf.pdfbox;

import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;

import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.PageRanges;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.printing.PDFPageable;
import org.apache.pdfbox.printing.PDFPrintable;

public class Ex202列印 {

	public static void main(String[] args) throws Exception {
		Ex101pdModel e = new Ex101pdModel();
		e.$5pdfBox內建字型();// z:/005內建字型.pdf
		PDDocument doc = PDDocument.load(new File("z:/005內建字型.pdf"));

		// $1列簡單的列印(doc);// 預設用xps列印，會彈出給你儲存檔案的地方，實體的應該就直接出來了
		// $2列印n到m頁(doc);
		// $3列印有彈介面設定(doc);//做得很像window的java介面
		// $4列印有彈java介面設定加預設n到m頁(doc);//比較難看的java介面
		$6客製頁面大小和分頁的列印(doc);// 分頁好像沒有出來，怪怪的
	}

	/**
	 * Prints the document at its actual size. This is the recommended way to print.
	 */
	private static void $1列簡單的列印(PDDocument document) throws IOException, PrinterException {
		PrinterJob job = PrinterJob.getPrinterJob();
		job.setPageable(new PDFPageable(document));
		job.print();
	}

	/**
	 * Prints using custom PrintRequestAttribute values.
	 */
	private static void $2列印n到m頁(PDDocument document) throws IOException, PrinterException {
		PrinterJob job = PrinterJob.getPrinterJob();
		job.setPageable(new PDFPageable(document));

		PrintRequestAttributeSet attr = new HashPrintRequestAttributeSet();
		attr.add(new PageRanges(2, 2)); // pages 1 to 1

		job.print(attr);
	}

	/**
	 * Prints with a print preview dialog.
	 */
	private static void $3列印有彈介面設定(PDDocument document) throws IOException, PrinterException {
		PrinterJob job = PrinterJob.getPrinterJob();
		job.setPageable(new PDFPageable(document));

		if (job.printDialog()) {
			job.print();
		}
	}

	/**
	 * Prints with a print preview dialog and custom PrintRequestAttribute values.
	 */
	private static void $4列印有彈java介面設定加預設n到m頁(PDDocument document) throws IOException, PrinterException {
		PrinterJob job = PrinterJob.getPrinterJob();
		job.setPageable(new PDFPageable(document));

		PrintRequestAttributeSet attr = new HashPrintRequestAttributeSet();
		attr.add(new PageRanges(2, 2)); // pages 1 to 1

		if (job.printDialog(attr)) {
			job.print(attr);
		}
	}

	/**
	 * Prints using a custom page size and custom margins.
	 */
	private static void $6客製頁面大小和分頁的列印(PDDocument document) throws IOException, PrinterException {
		PrinterJob job = PrinterJob.getPrinterJob();
		job.setPageable(new PDFPageable(document));

		// define custom paper
		Paper paper = new Paper();
		paper.setSize(306, 396); // 1/72 inch
		paper.setImageableArea(0, 0, paper.getWidth(), paper.getHeight()); // no margins

		// custom page format
		PageFormat pageFormat = new PageFormat();
		pageFormat.setPaper(paper);

		// override the page format
		Book book = new Book();
		// append all pages
		book.append(new PDFPrintable(document), pageFormat, document.getNumberOfPages());
		job.setPageable(book);

		job.print();
	}
}
