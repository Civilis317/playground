<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Login error</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />

</head>
<body onload="document.getElementById('username_field').focus();">
	<div id="totalDiv">
		<div id="containerDiv">

			<div id="headerDiv">
				<img src="img/headerLogoEindhoven.png">
			</div>

			<div id="formDivTop">
				<p>
					Welkom bij VVE Eindhoven.<br /> Op deze pagina dient u in te loggen voordat u met de applicatie kunt werken.
				</p>
				
				<h2 style="font-color: red;">Authenticatie mislukt, probeert u het nog eens...</h2>

			</div>

			<div id="formDivBottom">
				<p>
				<form method=post action="j_security_check">
					<table>
						<tr>
							<td>Username:</td>
							<td><input id="username_field" type="text" name="j_username"></td>
						</tr>
						<tr>
							<td>Password:</td>
							<td><input type="password" name="j_password"></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td><input type="submit" value="Login"></td>
						</tr>


					</table>
					</p>
				</form>

			</div>

			<div id="footerDiv">
				<img src="img/logo_eindhoven.jpg" height="80%" style="float: right;">
			</div>

		</div>

	</div>
</body>
</html>
