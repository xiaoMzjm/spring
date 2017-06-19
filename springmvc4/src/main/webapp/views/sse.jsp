<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
<meta charset="UTF-8">
<meta name="content-type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>

<body>
	<div>
		<script type="text/javascript">
			if(!!window.EventSource) {
				var source = new EventSource('push');
				s = '';
				
				// 有数据推送
				source.addEventListener('message' , function(e) {
					s = e.data;
					console.info(s);
				});
				
				// 建立连接
				source.addEventListener('open' , function(e){
					console.info("连接打开");
				},false);
				
				// 连接关闭
				source.addEventListener('error' , function(e){
					if(e.readyState == EventSource.CLOSED) {
						console.info("连接关闭");
					}
					else {
						console.info(e.readyState);
					}
				})
			}
			else {
				alert('您的浏览器不支持sse');
			}
		</script>
	</div>
</body>
</html>