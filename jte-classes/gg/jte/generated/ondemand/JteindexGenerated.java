package gg.jte.generated.ondemand;
import org.example.hexlet.dto.main.MainPage;
public final class JteindexGenerated {
	public static final String JTE_NAME = "index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,3,3,6,6,9,9,10,10,10,12,12,15,15,17,17,19,19,19,19,19,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, MainPage page) {
		jteOutput.writeContent("\r\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n        <h1>Home page</h1>\r\n        <div>\r\n            ");
				if (page.getCurrentUser() != null) {
					jteOutput.writeContent("\r\n                Welcome, ");
					jteOutput.setContext("div", null);
					jteOutput.writeUserContent(page.getCurrentUser());
					jteOutput.writeContent(".\r\n                To log out, delete the JSESSIONID cookie from your browser\r\n            ");
				}
				jteOutput.writeContent("\r\n        </div>\r\n        <div>\r\n            ");
				if (!page.isVisited()) {
					jteOutput.writeContent("\r\n                <a>This message showed once. If you want to see it again, delete cookie</a>\r\n            ");
				}
				jteOutput.writeContent("\r\n        </div>\r\n    ");
			}
		}, "Main Page");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		MainPage page = (MainPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
