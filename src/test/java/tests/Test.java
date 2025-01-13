package tests;

import com.nota.fiscal.util.PdfConverter;

public class Test {

	public static void main(String[] args) {

		try {

			byte[] array = PdfConverter.convertPDFtoByteStream();
			
			PdfConverter.convertByteStreamToPdf(array);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
