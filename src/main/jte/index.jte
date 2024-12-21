@import org.example.hexlet.dto.main.MainPage
@param MainPage page

@template.layout.page(
    title = "Main Page",
    content = @`
        <h1>Home page</h1>
        <div>
            @if(page.getCurrentUser() != null)
                Welcome, ${page.getCurrentUser()}.
                To log out, delete the JSESSIONID cookie from your browser
            @endif
        </div>
        <div>
            @if(!page.isVisited())
                <a>This message showed once. If you want to see it again, delete cookie</a>
            @endif
        </div>
    `
)