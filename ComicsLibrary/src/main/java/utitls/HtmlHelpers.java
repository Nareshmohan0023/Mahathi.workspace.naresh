package utitls;

public class HtmlHelpers {
		
	public static String error(String errMessage) {
		StringBuilder error = new StringBuilder();
		error.append("<script type = \"text/javascript\">");
		error.append("alert('Invalid "+errMessage+"!');");
		error.append("location='home?action=redirect';");
		error.append("</script>");
		return error.toString();
	}

	public static String back() {
		StringBuilder back = new StringBuilder();		
		back.append("<form action=\"home\" method=\"post\">");
		back.append("<button type =submit name=action value=redirect>");
		back.append("Back</button>");
		back.append("</form>");
		return back.toString();
	}
}
