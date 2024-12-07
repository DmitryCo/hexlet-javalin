@import gg.jte.Content
@param Content content

<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <title>Hexlet Javalin Example</title>
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
            ${content}
        </main>
        <footer>
            <p>View my profile on <a href="https://github.com/DmitryCo" target="_blank">GitHub</a></p>
        </footer>
    </body>
</html>