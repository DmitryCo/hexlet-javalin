package gg.jte.generated.ondemand.users;
import org.example.hexlet.utilities.NamedRoutes;
import org.example.hexlet.dto.users.UsersPage;
import org.example.hexlet.repository.UserRepository;
public final class JteindexGenerated {
	public static final String JTE_NAME = "users/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,3,3,5,5,8,8,10,10,10,10,11,11,11,11,11,11,11,11,11,14,14,16,16,18,18,20,20,20,22,22,22,22,22,22,22,22,22,22,22,22,25,25,25,28,28,30,30,31,31,31,31,31,3,3,3,3};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UsersPage page) {
		jteOutput.writeContent("\r\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n    <h1>Users</h1>\r\n    <form action=\"");
				jteOutput.setContext("form", "action");
				jteOutput.writeUserContent(NamedRoutes.usersPath());
				jteOutput.setContext("form", null);
				jteOutput.writeContent("?term=\" method=\"get\">\r\n        <input type=\"search\" name=\"term\"");
				var __jte_html_attribute_0 = page.getTerm();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("input", "value");
					jteOutput.writeUserContent(__jte_html_attribute_0);
					jteOutput.setContext("input", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" placeholder=\"Name\" />\r\n        <input type=\"submit\" value=\"Search\" />\r\n    </form>\r\n    ");
				if (UserRepository.size() == 0) {
					jteOutput.writeContent("\r\n        <p>Users not found</p>\r\n    ");
				} else {
					jteOutput.writeContent("\r\n        <table class=\"table table-striped\">\r\n            ");
					for (var user : UserRepository.search(page.getTerm())) {
						jteOutput.writeContent("\r\n                <tr>\r\n                    <td>");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(user.getId());
						jteOutput.writeContent("</td>\r\n                    <td>\r\n                        <a");
						var __jte_html_attribute_1 = NamedRoutes.userPath(user.getId());
						if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
							jteOutput.writeContent(" href=\"");
							jteOutput.setContext("a", "href");
							jteOutput.writeUserContent(__jte_html_attribute_1);
							jteOutput.setContext("a", null);
							jteOutput.writeContent("\"");
						}
						jteOutput.writeContent(">");
						jteOutput.setContext("a", null);
						jteOutput.writeUserContent(user.getName());
						jteOutput.writeContent("</a>\r\n                    </td>\r\n                    <td>\r\n                        <p>");
						jteOutput.setContext("p", null);
						jteOutput.writeUserContent(user.getEmail());
						jteOutput.writeContent("</p>\r\n                    </td>\r\n                </tr>\r\n            ");
					}
					jteOutput.writeContent("\r\n        </table>\r\n    ");
				}
				jteOutput.writeContent("\r\n");
			}
		}, "Users");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		UsersPage page = (UsersPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
