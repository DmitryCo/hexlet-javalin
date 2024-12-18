@import gg.jte.Content
@import org.example.hexlet.NamedRoutes
@import org.example.hexlet.dto.main.BasePage
@param Content content
@param BasePage page = null

<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <title>Hexlet Javalin Example</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    </head>
    <body>
        <header>
            <h1>Welcome to Hexlet</h1>
            <nav>
                <ul>
                    <li><a href="/">Home</a></li>
                    <li><a href="/users">Users</a></li>
                    <li><a href="/courses">Courses</a></li>
                </ul>
            </nav>
        </header>
        <main>
        @if(page != null && page.getFlash() != null)
        <div class="alert alert-success" role="alert">
            <p>${page.getFlash()}</p>
        </div>
        @endif
            ${content}
        </main>
        <footer>
            <p>View my profile on <a href="https://github.com/DmitryCo" target="_blank">GitHub</a></p>
        </footer>
    </body>
</html>