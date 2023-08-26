package com.kh.opendata.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class OpenAPIController {
	
	public static final String SERVICEKEY = "H9G94mdzAruRWO4Jpm%2FW0CblSoyJgqoNrJUGt2O6Px3i9Wa%2Fv9kYaPGBcJbeH%2BA0UqlkNhl6%2B9nptXTYmJrQCg%3D%3D";
	
	// json형식으로 대기오염 OpenAPI 활용하기
	@ResponseBody
	//@RequestMapping(value="air", produces="application/json; charset=UTF-8")
	public String airMethod(String location) throws IOException{
		
		// OpenAPI 서버로 요청하고자 하는 url 작성
		String url = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty";
		url += "?serviceKey="+SERVICEKEY; //  서비스키 추가
		// 서비스키가 제대로 부여되지 않았을 경우 => SERVICE_KEY_IS_NOT_REGISTERED_ERROR
		url += "&sidoName="+URLEncoder.encode(location,"UTF-8"); // 지역명 추가(한글이 들어가면 인코딩 처리해야됨)
		url += "&returnType=json"; // 리턴타입
		url += "&numOfRows=100";
		
		// 1. 작성된 url 정보를 넣어 URL 객체 생성
		URL requestUrl = new URL(url);
		
		// 2. 생성된 URL 객체로 URLConnection 생성
		HttpURLConnection urlConn = (HttpURLConnection)requestUrl.openConnection();
		
		// 3. 요청 시 필요한 Header 설정
		urlConn.setRequestMethod("GET");
		
		// 4. 해당 OpenAPI 서버로 요청 후 입력스트림을 통해서 응답 데이터 읽어옴
		BufferedReader br = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
		
		String responseText = "";
		String line;
		while( (line = br.readLine()) != null) {
			responseText += line;
		}
		
		// 5. 다 사용한 스트림 반납 및 연결 해제
		br.close();
		urlConn.disconnect();
		
		System.out.println(responseText);
		return responseText;
	}
	
	// xml형식으로 대기오염 OpenAPI 활용하기
	@ResponseBody
	@RequestMapping(value="air", produces="text/xml; charset=UTF-8")
	public String airPollution(String location) throws IOException {
		
		// OpenAPI 서버로 요청하고자 하는 url 작성
		String url = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty";
		url += "?serviceKey="+SERVICEKEY; //  서비스키 추가
		url += "&sidoName="+URLEncoder.encode(location,"UTF-8"); // 지역명 추가(한글이 들어가면 인코딩 처리해야됨)
		url += "&returnType=xml"; // 리턴타입
		url += "&numOfRows=100";
		
		// 1. 작성된 url 정보를 넣어 URL 객체 생성
		URL requestUrl = new URL(url);
		
		// 2. 생성된 URL 객체로 URLConnection 생성
		HttpURLConnection urlConn = (HttpURLConnection)requestUrl.openConnection();
		
		// 3. 요청 시 필요한 Header 설정
		urlConn.setRequestMethod("GET");
		
		// 4. 해당 OpenAPI 서버로 요청 후 입력스트림을 통해서 응답 데이터 읽어옴
		BufferedReader br = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
		
		String responseText = "";
		String line;
		while( (line = br.readLine()) != null) {
			responseText += line;
		}
		
		// 5. 다 사용한 스트림 반납 및 연결 해제
		br.close();
		urlConn.disconnect();
		
		System.out.println(responseText);
		return responseText;
		
	}
	
	// xml형식으로 지진해일 대피 OpenApi 활용하기
	@ResponseBody
	@RequestMapping(value="shelter", produces="text/xml; charset=UTF-8")
	public String shelterList() throws IOException{
		
		// OpenAPI 서버로 요청하고자 하는 url 작성
		String url = "http://apis.data.go.kr/1741000/TsunamiShelter3/getTsunamiShelter1List";
		url += "?serviceKey="+SERVICEKEY; //  서비스키 추가
		url += "&pageNo=1"; // 페이지번호
		url += "&numOfRows=100"; // 한페이지 결과 수
		url += "&type=xml"; // 리턴타입
		
		// 1. 작성된 url 정보를 넣어 URL 객체 생성
		URL requestUrl = new URL(url);
		
		// 2. 생성된 URL 객체로 URLConnection 생성
		HttpURLConnection urlConn = (HttpURLConnection)requestUrl.openConnection();
		
		// 3. 요청 시 필요한 Header 설정
		urlConn.setRequestMethod("GET");
		
		// 4. 해당 OpenAPI 서버로 요청 후 입력스트림을 통해서 응답 데이터 읽어옴
		BufferedReader br = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
		
		String responseText = "";
		String line;
		while( (line = br.readLine()) != null) {
			responseText += line;
		}
		
		// 5. 다 사용한 스트림 반납 및 연결 해제
		br.close();
		urlConn.disconnect();
		
		System.out.println(responseText);
		return responseText;
	}
}
