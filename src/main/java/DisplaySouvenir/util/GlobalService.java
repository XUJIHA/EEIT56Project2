package DisplaySouvenir.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialBlob;

public class GlobalService {
	public static final int IMAGE_FILENAME_LENGTH = 20;
	static public Map<String, String> readMimeTypeData() {
    	Map<String, String> mimeRepo = new HashMap<>();
    	InputStream is = null;
    	try {
    		try {
    			is = new FileInputStream("data/mimeTypeTable.csv");
    		} catch(Exception e) {
    			System.out.println("發生例外：" + e.getMessage());
    			return null; 
    		}
			BufferedReader br = new BufferedReader(
					new InputStreamReader(is)
					);
			System.out.println("br=" + br);
			String line = "";
			while ((line = br.readLine())!= null) {
				//System.out.println("line=" + line);
				String[] sa = line.split(",");
				mimeRepo.put(sa[2].toLowerCase(), sa[1].toLowerCase());
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return mimeRepo;
    	
    }
	// 為了測試本類別的其他方法而準備的main()方法。
	public static void main(String[] args) throws Exception {
		
	}
	
	// 本方法調整fileName的長度小於或等於maxLength。
	// 如果fileName的長度小於或等於maxLength，直接傳回fileName
	// 否則保留最後一個句點與其後的附檔名，縮短主檔名使得fileName的總長度
	// 等於maxLength。
	public static String adjustFileName(String fileName, int maxLength) {
		int length = fileName.length();
		if (length <= maxLength) {
			return fileName;
		}
		int n = fileName.lastIndexOf(".");
		int sub = fileName.length() - n - 1;
		fileName = fileName.substring(0, maxLength - 1 - sub) + "." + fileName.substring(n + 1);
		return fileName;
	}

	public static String getFileName(final Part part) {
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}

	
	public static Blob fileToBlob(String imageFileName) throws IOException, SQLException {
		File imageFile = new File(imageFileName);
		long size = imageFile.length();
		byte[] b = new byte[(int) size];
		SerialBlob sb = null;
		try (FileInputStream fis = new FileInputStream(imageFile);) {
			fis.read(b);
			sb = new SerialBlob(b);
		}
		return sb;
	}

	
	public static Blob fileToBlob(InputStream is, long size) throws IOException, SQLException {
		byte[] b = new byte[(int) size];
		SerialBlob sb = null;
		is.read(b);
		sb = new SerialBlob(b);
		return sb;
	}

	public static String extractFileName(String pathName) throws IOException, SQLException {
		return pathName.substring(pathName.lastIndexOf("/") + 1);
	}
}