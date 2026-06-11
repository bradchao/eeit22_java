<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>九九乘法表</h1>
		<hr />
		<table border="1" width="100%">
			<tr>
				<%
					for (int j=2; j<=5; j++){
						out.print("<td>");
						for (int i=1; i<=9; i++){
							int r = j * i;
							out.print(String.format("%d x %d = %d<br />\n", j, i, r));
						}
						out.print("</td>");
					}
				%>
			</tr>
			<tr>
				<td>
					2 x 1 = 2<br />
					2 x 1 = 2<br />
					2 x 1 = 2<br />
					2 x 1 = 2<br />
				</td>
				<td>
					2 x 1 = 2<br />
					2 x 1 = 2<br />
					2 x 1 = 2<br />
					2 x 1 = 2<br />
				</td>
				<td>
					2 x 1 = 2<br />
					2 x 1 = 2<br />
					2 x 1 = 2<br />
					2 x 1 = 2<br />
				</td>
				<td>
					2 x 1 = 2<br />
					2 x 1 = 2<br />
					2 x 1 = 2<br />
					2 x 1 = 2<br />
				</td>
			</tr>
		</table>
	</body>
</html>