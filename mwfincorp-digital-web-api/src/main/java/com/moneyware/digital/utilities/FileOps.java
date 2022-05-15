package com.moneyware.digital.utilities;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringJoiner;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.moneyware.digital.dto.FileUploadDTO;
import com.moneyware.digital.property.DocumentStorageProperty;

@Component
public class FileOps {

	private final Path docStorageLocation;

	private static final Map<String, String> map = new LinkedHashMap<>();
	static {
		map.put("COMMENT", "COMMENT");
		map.put("GROUP_FIELD_NAME", "Timestamp");
		map.put("GROUP_FIELD_NAME", "CUSTOMER_ID");
		map.put("GROUP_FIELD_NAME", "DOCUMENT_TYPE");
		map.put("GROUP_FILENAME", "GROUP_FILE_NAME");
	}

	@Autowired
	public FileOps(DocumentStorageProperty documentStorageProperty) throws IOException {
		this.docStorageLocation = Paths
				.get(System.getProperty("user.home"), documentStorageProperty.getUploadDirectory()).toAbsolutePath()
				.normalize();
		Files.createDirectories(this.docStorageLocation);
	}

	public CompletableFuture<Boolean> saveFileToDisc(String fIdxName, FileUploadDTO fileData) {
		try {
			Files.write(Paths.get(this.docStorageLocation.toString(), fIdxName + ".txt"),
					getFileContentPayload(fileData).getBytes());
			return CompletableFuture.completedFuture(true);
		} catch (IOException e) {
			return CompletableFuture.completedFuture(false);
		}

	}

	private String getFileContentPayload(FileUploadDTO fileData) {

		StringWriter stringWriter = getStringWriter();
		PrintWriter writer = new PrintWriter(stringWriter, true);

		for (Map.Entry<String, String> entry : map.entrySet()) {
			if (entry.getValue().equalsIgnoreCase("COMMENT")) {
				writer.println(new StringJoiner(":").add(entry.getValue()).add(fileData.getComment()).toString());
			}
			if (entry.getValue().equalsIgnoreCase("Timestamp")) {
				writer.println(new StringJoiner(":").add(entry.getKey()).add(entry.getValue()).toString());
				writer.println(new StringJoiner(":").add("GROUP_FIELD_VALUE")
						.add(DateUtils.toStringFromDate(fileData.getTimestamp())).toString());

			}
			if (entry.getValue().equalsIgnoreCase("CUSTOMER_ID")) {
				writer.println(new StringJoiner(":").add(entry.getKey()).add(entry.getValue()).toString());
				writer.println(new StringJoiner(":").add("GROUP_FIELD_VALUE").add(String.valueOf(fileData.getCustId()))
						.toString());
			}
			if (entry.getValue().equalsIgnoreCase("DOCUMENT_TYPE")) {
				writer.println(new StringJoiner(":").add(entry.getKey()).add(entry.getValue()).toString());
				writer.println(new StringJoiner(":").add("GROUP_FIELD_VALUE").add(String.valueOf(fileData.getDocType()))
						.toString());
			}
			if (entry.getValue().equalsIgnoreCase("GROUP_FILE_NAME")) {
				writer.println(new StringJoiner(":").add(entry.getKey()).add(fileData.getFilename()).toString());
			}

		}

		return stringWriter.toString();

	}

	private StringWriter getStringWriter() {
		return new StringWriter();
	}

	public static void main(String[] args) {
		StringWriter stringWriter = new StringWriter();
		PrintWriter writer = new PrintWriter(stringWriter, true);
		writer.println("line1");
		writer.println("line2");
		writer.println("line3");
		System.out.println(stringWriter.toString());

		Path p = Paths.get("/abc/cde", "/bv.txt");
		System.out.println(p.toAbsolutePath().normalize());
	}

}
