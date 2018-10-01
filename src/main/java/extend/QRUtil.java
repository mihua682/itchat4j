package extend;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.imageio.ImageIO;

import com.swetake.util.Qrcode;

import jp.sourceforge.qrcode.QRCodeDecoder;

public class QRUtil {
	
	static String commandStr;
	
	public static String getCommandStr() {
		return commandStr;
	}

	public static void setCommandStr(String commandStr) {
		QRUtil.commandStr = commandStr;
	}

	public static void printQR(byte[] bytes) {
		String result = null;
		ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        BufferedImage bufferedImage;
		try {
			bufferedImage = ImageIO.read(in);
	        QRCodeDecoder codeDecoder = new QRCodeDecoder();
	        result = new String(codeDecoder.decode(new MyQRCodeImage(bufferedImage)), "utf-8");
	        System.out.println(result);
	        creatCode(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void creatCode(String content) throws UnsupportedEncodingException {
		Qrcode qrcode = new Qrcode();
		qrcode.setQrcodeEncodeMode('B');
		qrcode.setQrcodeVersion(3);
		qrcode.setQrcodeErrorCorrect('M');
		
		byte[] codeOut = null;
		codeOut = content.getBytes("utf-8");
		boolean[][] codes = qrcode.calQrcode(codeOut);
		wtiteChar(codes);
	}
	public static void wtiteChar(boolean[][] codes){
        String white_block = "\033[0;37;47m  ";
        String black_block = "\033[0;37;40m  ";
        String new_line = "\033[0m\n";
//        	String white_block = "▇";
//            String black_block = "  ";
//            String new_line = "\n";
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < codes.length; i++) {
			for (int j = 0; j < codes[i].length; j++) {
				if(codes[i][j]){
					sb.append(black_block);
				}else{
					sb.append(white_block);
				}
			}
			sb.append(new_line);
		}
        commandStr = sb.toString();
        System.out.println(commandStr);
	}
}
