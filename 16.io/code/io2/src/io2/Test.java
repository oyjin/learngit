package io2;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import com.aowin.io.object.Student;

public class Test {
	public static void main(String[] args) throws Exception{
		//��ȡ�ļ��е�student����
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("src\\a.txt"));
		Object obj = in.readObject();
		if(obj instanceof Student) {
			Student s = (Student) obj;
			System.out.println(s);
		}
		in.close();
	}

}
