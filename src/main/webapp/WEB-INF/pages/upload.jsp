<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			<article>
				<body>
				    <div align="center">
				        <h2 style="color:orangered;">基于OSS的上传文件页面</h2>
				    </div>
				    <br/>
				    <form action="/upload" enctype="multipart/form-data" method="post">
				        <div class="form-group" id="group">
				            <label for="exampleInputFile">File input</label>
				            <input type="file" id="exampleInputFile" name="file">
				        </div>
				        <button type="submit" class="btn btn-default" id="submit">上传</button>
				    </form>
				</body>
<!-- 				<h1>Meny</h1>
				<p>
					A three dimensional and space efficient menu.
				</p>
				<p>
					Move your mouse towards the arrow &mdash; or swipe in from the arrow if you're on a touch device &mdash; to open.	
				</p>
				<p>
					Meny can be positioned on any side of the screen: <br>
					 <a href="www.baidu.com">top</a>
					 - <a href="#">right</a>
					 - <a href="#">bottom</a>
					 - <a href="#">left</a>
				</p>
				<p>
					Instructions and download .
				</p>
				<p>
					The name, <em>Meny</em>, is swedish.
				</p>
				<small>
					Created by hakim.se</a>
				</small> -->
			</article>

			

			
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