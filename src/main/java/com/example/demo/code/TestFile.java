package com.example.demo.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TestFile {
	
	
	public static void main(String[] args) {
		
		//获得对应文件的file
		InputFileContext("C:/Users/华为/Desktop/学习/socket/file.txt","C:/Users/华为/Desktop/学习/socket/file-copy.txt");
	
	}
	
	

	public static void InputFileContext(String fileUrl,String copy) {
		
		BufferedReader bufferedReader = null;
		BufferedWriter bufferedWriter = null;
	    boolean creatFileFlag = false;
	    
		File file = new File(fileUrl);
		File copyFile = new File(copy);
		
		if(file.exists()&&file.isFile()) {
			try {
				
				if(!copyFile.exists()) {
				    	creatFileFlag = copyFile.createNewFile();
				}
				
				//创建文件输入流
				InputStream fileInput = new FileInputStream(file);
			
				//将文件输入流读取成InputStreamReader缓冲流
				InputStreamReader fileReader = new InputStreamReader(fileInput,"GBK");
				
				//将InputStreamReader转化为BufferedReader
				bufferedReader = new BufferedReader(fileReader);
		        
			  
				//创建文件输出流
				FileOutputStream fileOut = new FileOutputStream(copyFile);
				
				//将文件输入流读取成outputStreamWriter缓冲流
				OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOut);
				
				//将OutputStreamWriter转化为BufferedWriter
				bufferedWriter = new BufferedWriter(outputStreamWriter);
				String str = null;
				while((str = bufferedReader.readLine())!=null) {
					System.out.println(str);
					if(creatFileFlag) {
						bufferedWriter.write(str);
						bufferedWriter.newLine();
					}
					else {
						System.out.println("文件创建失败，无法读入内容");
					}
				}
				System.out.println("文件读入成功");
				bufferedReader.close();
				if(copyFile.exists()) {
					System.out.println("文件复制成功");
				}
				bufferedWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}
	}

}
