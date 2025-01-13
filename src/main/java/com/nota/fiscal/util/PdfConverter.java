package com.nota.fiscal.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.io.OutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.util.ResourceUtils;

public class PdfConverter {

	public static void convertByteStreamToPdf(byte[] byteArray) {

		try {
			OutputStream out = new FileOutputStream("C:\\Temp\\xitlab\\out.pdf");
			out.write(byteArray);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static byte[] convertPDFtoByteStream() throws IOException {
		//Path path = Paths.get("C:\\Temp\\xitlab\\notafiscal.pdf");
		
		File file = ResourceUtils.getFile("classpath:notafiscal.pdf");
		Path path = file.toPath();
		return Files.readAllBytes(path);
	}

	public static void readPdfFileFromResource() {

		try {
			
			File file = ResourceUtils.getFile("classpath:notafiscal.pdf");

			file.toPath();

		} catch (Exception e) {
		}

	}

}
