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
	//한개의 파일 업로드시 MultipartFile 매개변수로 받는다.
	//여러개의 파일을 업로드시 배열로 받으면 된다.
	@RequestMapping(value = "/upload.do", method = RequestMethod.POST)
	public String upload(MultipartFile file, HttpServletRequest request) throws IllegalStateException, IOException {
		//경로는 브라우저가 접근해야하기 때문에 webapp/resources 안에 넣는다.
		//톰캣은 특정 경로에 복사해서 사용하기 때문에 경로를 절대 경로로 위치 시키기때문에 바로 반영이 되지 않는다.(개발한정)
		//아래에 상세한 이유 기제
		/*
		개발환경에서 워크스페이스에 둔 프로젝트를 was로 실행시 실제 프로젝트 위치는 워크스페이스가 아니라
		was가 실행하는 위치 어딘가에 프로젝트를 복사해서 사용하게 된다.
		이때 업로드 파일 경로를 워크스페이스내의 프로젝트 절대 경로를 사용하게 되면 was가 바라보는 위치로 
		파일을 복사하기까지 시간차가 발생하므로 즉시 반영이 되지 못한다.
		업로드 위치를 실제 톰캣이 사용하는 프로젝트의 리얼 경로를 사용하게 되면 시간차가 발생하지 않아 즉시 반영이 가능하다.
		(개발환경 한정)
		*/
		String path = request.getSession().getServletContext().getRealPath("/resources/upload");
		System.out.println(path);
		
		File dir = new File(path); //path가 존재하는지 여부 확인
		if(!dir.exists()) { //디렉토리 위치가 존재하지 않으면 위치 생성
			dir.mkdirs();
		}
		
		if(!file.getOriginalFilename().isEmpty()) {//화면에서 넘어온 파일이 존재하면 true
			file.transferTo(new File(path,file.getOriginalFilename())); 
			//파일은 복사할 때 호출하는 transferTo 메서드
			//화면에서 넘어온 파일을 path 위치에 새로 쓰는 로직
		} else {
			System.out.println("업로드할 파일이 존재하지 않습니다.");
		}
		
		return "redirect:/file/sample.do";
	}
	
}
