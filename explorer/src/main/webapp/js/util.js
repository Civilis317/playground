var documentBase = window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));

function logout()
{
	document.location.href = documentBase + "/logout";
}