package extend;

public class PrintQRChar {
	
	public static void printQR(boolean[][] codes){
        String white_block = "\033[0;37;47m  ";
        String black_block = "\033[0;37;40m  ";
        String new_line = "\033[0m\n";
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
        System.out.println(sb.toString());
	}
}
