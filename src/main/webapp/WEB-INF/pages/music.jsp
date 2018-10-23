<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
	<head>
		<meta charset="utf-8">

		<title>笔筒云——内测版</title>

		<meta name="viewport" content="width=800, user-scalable=no">

		<link rel="stylesheet" href="static/css/demo.css">
	</head>

	<body>

		<div class="meny">
			<h2>云盘资源分类</h2>
			<ul>
				<br>
				<li><a href="showAll"><img src="static/img/all.png" height="22" width="20">  总目录</a></li>
				<br><br>
				<li><a href="showPhoto"><img src="static/img/photo.png" height="22" width="20">  图片</a></li>
				<br><br>				<li><a href="showDoc"><img src="static/img/file.png" height="22" width="20">  文件</a></li>
				<br><br>
				<li><a href="showMusic"><img src="static/img/music.png" height="22" width="20">  音乐</a></li>
				<br><br>
				<li><a href="showVideo"><img src="static/img/video.png" height="22" width="20">  视频</a></li>
				<br><br>
				<li><a href="showZip"><img src="static/img/zip.png" height="22" width="20">  压缩包</a></li>
				<br><br>
				<li><a href="showOther"><img src="static/img/other.png" height="22" width="20">  其他文件</a></li>
				<br><br>
				<li><a href="upload"><img src="static/img/other.png" height="22" width="20">  文件上传</a></li>
			</ul>
		</div>

		<div class="meny-arrow"></div>

		<div class="contents">
			<c:forEach items="${sessionScope.music_list }" var="music">
				<a href="${music.file_url }">${music.file_name }</a>
				<br>
			</c:forEach>
		</div>

		<script src="static/js/meny.js"></script>
		<script>
			// Create an instance of Meny
			var meny = Meny.create({
				// The element that will be animated in from off screen
				menuElement: document.querySelector( '.meny' ),

				// The contents that gets pushed aside while Meny is active
				contentsElement: document.querySelector( '.contents' ),

				// [optional] The alignment of the menu (top/right/bottom/left)
				position: Meny.getQuery().p || 'left',

				// [optional] The height of the menu (when using top/bottom position)
				height: 200,

				// [optional] The width of the menu (when using left/right position)
				width: 260,

				// [optional] Distance from mouse (in pixels) when menu should open
				threshold: 40,

				// [optional] Use mouse movement to automatically open/close
				mouse: true,

				// [optional] Use touch swipe events to open/close
				touch: true
			});

			// API Methods:
			// meny.open();
			// meny.close();
			// meny.isOpen();

			// Events:
			// meny.addEventListener( 'open', function(){ console.log( 'open' ); } );
			// meny.addEventListener( 'close', function(){ console.log( 'close' ); } );

			// Embed an iframe if a URL is passed in
			if( Meny.getQuery().u && Meny.getQuery().u.match( /^http/gi ) ) {
				var contents = document.querySelector( '.contents' );
				contents.style.padding = '0px';
				contents.innerHTML = '<div class="cover"></div><iframe src="'+ Meny.getQuery().u +'" style="width: 100%; height: 100%; border: 0; position: absolute;"></iframe>';
			}
		</script>

		

	</body>
</html>