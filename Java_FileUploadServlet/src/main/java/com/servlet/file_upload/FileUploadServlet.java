package com.servlet.file_upload;//import javax.servlet.*;
//import javax.servlet.http.*;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;


//import javax.servlet.annotation.*;

/* The Java file upload Servlet example */
@WebServlet(name = "FileUploadServlet", urlPatterns = { "/fileuploadservlet" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
		maxFileSize = 1024 * 1024 * 10, // 10 MB
		maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class FileUploadServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/* Receive file uploaded to the Servlet from the HTML5 form */

		Part filePart = request.getPart("file");
		String fileName = filePart.getSubmittedFileName();

		for (Part part : request.getParts()) {

			part.write("C:\\upload\\" + fileName);

		}

		response.getWriter().print("The file uploaded sucessfully.");
		
		//test steps
		//create a folder named upload in C drive
		//In the browser, type the url: http://localhost:8081/Java_FileUploadServlet/input.html

	}

}
