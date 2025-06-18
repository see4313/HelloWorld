package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

public class SignUpControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		// GET방식요청=화면을 출력기준
		// POST방식요청=회원등록
		if (req.getMethod().equals("GET")) {
			req.getRequestDispatcher("member/signUp.tiles").forward(req, resp);

		} else if (req.getMethod().equals("POST")) {
			// DB에 insert
			// images 폴더에 업로드

			// 1)요청정보 2)업로드경로 3)최대크기 4)파일명인코딩 5)리네임정책(서버에 똑같은이름의 파일이 있을떄 새로운이름만들어서 업로드)
			String savePath = req.getServletContext().getRealPath("images"); // 이미지파일을 찾아가기 위함(톰캣을 활용)
			MultipartRequest mr = new MultipartRequest(
					req,                           // 1)요청정보
					savePath,                      // 2)업로드경로
					1024 * 1024 * 5,               // 3)최대크기 (5MB)
					"UTF-8",                       // 4)파일명인코딩
					new DefaultFileRenamePolicy() // 5)리네임정책
			);
			// DB입력.
			String id = mr.getParameter("userId");
			String pw = mr.getParameter("userPw");
			String name = mr.getParameter("userName");
			String img = mr.getFilesystemName("userImg");
			
			// parameter 셋팅
			MemberVO member = new MemberVO();
			member.setMemberId(id);
			member.setMemberName(name);
			member.setPassword(pw);
			member.setImg(img);
			
			MemberService svc = new MemberServiceImpl();
			if(svc.addMember(member)) {
				resp.sendRedirect("boardList.do");
			}

		}

	}

}
