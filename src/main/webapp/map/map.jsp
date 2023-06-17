<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=8f818416cdc1d84e70d4b7d23e7f86e3&libraries=services"></script>
</head>
<body>
	<input type="hidden" id="param" value="${param.place }">
	<div id="map" style="width:500px;height:400px;"></div>
	
	<script type="text/javascript">
		let place = document.getElementById('param')?.value;
		let container = document.getElementById('map');
		let options = {
				center: new kakao.maps.LatLng(33.450701, 126.570667),
				level: 3
		}
		
		let map = new kakao.maps.Map(container, options);
		console.log(place);
		
		let geocoder = new kakao.maps.services.Geocoder();
		
		geocoder.addressSearch(place, function(result, status){
			 if (status === kakao.maps.services.Status.OK) {

			        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
			     	// 정상적으로 검색이 완료됐으면
			        // 결과값으로 받은 위치를 마커로 표시합니다
			        var marker = new kakao.maps.Marker({
			            map: map,
			            position: coords
			        });

			        // 인포윈도우로 장소에 대한 설명을 표시합니다
			        var infowindow = new kakao.maps.InfoWindow({
			            content: '<div style="width:150px;text-align:center;padding:6px 0;">'+ place +'</div>'
			        });
			        infowindow.open(map, marker);

			        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
			        map.setCenter(coords);
			    } 
		})
		
	</script>
	
</body>
</html>