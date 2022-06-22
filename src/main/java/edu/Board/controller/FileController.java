package edu.Board.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping(value = "/file")
@Controller
public class FileController {

	@RequestMapping(value = "/sample.do")
	public String sample() {
		
		return "file/sample";
		
	}
	//�Ѱ��� ���� ���ε�� MultipartFile �Ű������� �޴´�.
	//�������� ������ ���ε�� �迭�� ������ �ȴ�.
	@RequestMapping(value = "/upload.do", method = RequestMethod.POST)
	public String upload(MultipartFile file, HttpServletRequest request) throws IllegalStateException, IOException {
		//��δ� �������� �����ؾ��ϱ� ������ webapp/resources �ȿ� �ִ´�.
		//��Ĺ�� Ư�� ��ο� �����ؼ� ����ϱ� ������ ��θ� ���� ��η� ��ġ ��Ű�⶧���� �ٷ� �ݿ��� ���� �ʴ´�.(��������)
		//�Ʒ��� ���� ���� ����
		/*
		����ȯ�濡�� ��ũ�����̽��� �� ������Ʈ�� was�� ����� ���� ������Ʈ ��ġ�� ��ũ�����̽��� �ƴ϶�
		was�� �����ϴ� ��ġ ��򰡿� ������Ʈ�� �����ؼ� ����ϰ� �ȴ�.
		�̶� ���ε� ���� ��θ� ��ũ�����̽����� ������Ʈ ���� ��θ� ����ϰ� �Ǹ� was�� �ٶ󺸴� ��ġ�� 
		������ �����ϱ���� �ð����� �߻��ϹǷ� ��� �ݿ��� ���� ���Ѵ�.
		���ε� ��ġ�� ���� ��Ĺ�� ����ϴ� ������Ʈ�� ���� ��θ� ����ϰ� �Ǹ� �ð����� �߻����� �ʾ� ��� �ݿ��� �����ϴ�.
		(����ȯ�� ����)
		*/
		String path = request.getSession().getServletContext().getRealPath("/resources/upload");
		System.out.println(path);
		
		File dir = new File(path); //path�� �����ϴ��� ���� Ȯ��
		if(!dir.exists()) { //���丮 ��ġ�� �������� ������ ��ġ ����
			dir.mkdirs();
		}
		
		if(!file.getOriginalFilename().isEmpty()) {//ȭ�鿡�� �Ѿ�� ������ �����ϸ� true
			file.transferTo(new File(path,file.getOriginalFilename())); 
			//������ ������ �� ȣ���ϴ� transferTo �޼���
			//ȭ�鿡�� �Ѿ�� ������ path ��ġ�� ���� ���� ����
		} else {
			System.out.println("���ε��� ������ �������� �ʽ��ϴ�.");
		}
		
		return "redirect:/file/sample.do";
	}
	
}
