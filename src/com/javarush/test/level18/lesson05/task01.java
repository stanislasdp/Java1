package lesson05;
/* ��������� ������
��������� ���������������� � ������������ � ������������
��������� ������:
1. ���������� ��� ����� ������ ����� � ������ ����� ������.
2. ��������� ������ �����-������
���������: 4 ������
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class task01 
{

	 public static void main(String[] args) throws IOException {
	        FileInputStream inputStream = new FileInputStream("c:/data.txt");
	        // ������� �����-������-����-�-����
	        FileOutputStream outputStream = new FileOutputStream("c:/result.txt");

	        if (inputStream.read() > 0) {
	            //������ ���� ���� ����� ������
	            byte[] buffer = new byte[inputStream.available()];
	            int count = inputStream.read(buffer);
	            outputStream.write(buffer, 0, count);
	        }

	        inputStream.close();
	        outputStream.flush();
	        outputStream.close();
	    }
}
