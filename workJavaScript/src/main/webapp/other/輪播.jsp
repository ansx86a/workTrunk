<%@ page language="java" contentType="text/html; charset=BIG5" pageEncoding="BIG5"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>
</head>
<body>
	<pre>
Owl Carousel
����ѷӺ���http://www.owlcarousel.owlgraphic.com/
�Y�峹:http://www.wfublog.com/2016/04/owl-carousel-jquery-slider-cdn.html

swiper
�v���Q�Ϊ�swiper������������Ʀ��ֳt�A�Pı�WOwl Carousel����j�j�B�e��
http://idangero.us/swiper/demos/#.WAhn2FV96R0

</pre>
	<link rel="stylesheet"
		href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.0.0-beta.2.4/assets/owl.carousel.min.css"></link>
	<link rel="stylesheet"
		href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.0.0-beta.2.4/assets/owl.theme.default.min.css"></link>
	<script src='https://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js'></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.0.0-beta.2.4/owl.carousel.min.js"></script>

	<h1>�򥻽d��</h1>
	<div class="owl-carousel" id="test1">
		<div class="item">
			<h4>1</h4>
		</div>
		<div class="item">
			<h4>2</h4>
		</div>
		<div class="item">
			<h4>3</h4>
		</div>
		<div class="item">
			<h4>4</h4>
		</div>
		<div class="item">
			<h4>5</h4>
		</div>
		<div class="item">
			<h4>6</h4>
		</div>
		<div class="item">
			<h4>7</h4>
		</div>
		<div class="item">
			<h4>8</h4>
		</div>
		<div class="item">
			<h4>9</h4>
		</div>
		<div class="item">
			<h4>10</h4>
		</div>
		<div class="item">
			<h4>11</h4>
		</div>
		<div class="item">
			<h4>12</h4>
		</div>
	</div>
	<h1>�W���۪��Y�d��</h1>
	<div class="owl-carousel" id="test2">
		<div class="item">
			<a target="_blank" href="�s�����}"><img src="�Ϥ����}" /></a>
		</div>
		<div class="item">
			<a target="_blank" href="http://www.wfublog.com/2014/10/member-system-pilot-run.html"><img
				src="http://1.bp.blogspot.com/-BHZxe8vmiIg/VC_l0m3xGNI/AAAAAAAAKSk/M_ERXsduEjU/s1600/member-services.jpg" /></a>
		</div>
		<div class="item">
			<a target="_blank" href="http://www.wfublog.com/2014/04/wfu-blog-domain-anniversary.html"><img
				src="http://1.bp.blogspot.com/-dxTG02G5GdM/U7_kBt8bXqI/AAAAAAAAJ04/doIhYOUMMsw/s1600/wfublog.jpg" /></a>
		</div>
		<div class="item">
			<a target="_blank" href="http://www.wfublog.com/2014/04/blogger-mobile-template-or-responsive-web-design.html"><img
				src="http://4.bp.blogspot.com/-RNalqNdTFA8/U0Jf3IdlfLI/AAAAAAAAJL0/1_bZHJBepVA/s1600/Blogger-Responsive-Web-Designing.jpg" /></a>
		</div>
	</div>



	<script>
		//$('.owl-carousel').owlCarousel({
		$('#test1').owlCarousel({
			loop : true,
			margin : 10,
			nav : true,
			responsive : {
				0 : {
					items : 1
				},
				600 : {
					items : 3
				},
				1000 : {
					items : 5
				}
			}
		})
		$("#test2").owlCarousel({
			items : 2, // �@�������X�Ӷ���
			loop : true, // �`������
			margin : 10, // �P�k��Ϥ����Z��
			nav : true, // �ɯ��r
			autoplay : true, // �۰ʽ���
			autoplayTimeout : 1000, // �����ɶ�
			autoplayHoverPause : true
		// �ƹ��g�L�ɼȰ�
		})
	</script>
</body>
</html>