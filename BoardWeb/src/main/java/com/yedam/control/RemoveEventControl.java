package com.yedam.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.EventVO;

public class RemoveEventControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = req.getParameter("title");
		String start = req.getParameter("start");

		BoardService svc = new BoardServiceImpl();
		EventVO event = new EventVO();
		
		event.setTitle(title);
		event.setStart(start);
		
		Map<String, Object> map = new HashMap<>();
		Gson gson = new GsonBuilder().create();
		
		if (svc.removeEvent(event)) {
			map.put("retCode", "Success");
		} else {
			map.put("retCode", "Fail");
		}
		
		String json = gson.toJson(map);
		System.out.println(json);
		resp.getWriter().print(json);


	}

}
