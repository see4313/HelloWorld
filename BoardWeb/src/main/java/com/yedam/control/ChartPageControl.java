package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;

public class ChartPageControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 경로 => WEB-INF/jsp/chart/chart.jsp
		// url활용 => chart/chart.tiles
		req.getRequestDispatcher("chart/chart.tiles").forward(req, resp);

	}

}
