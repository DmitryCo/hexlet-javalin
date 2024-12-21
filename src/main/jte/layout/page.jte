@import gg.jte.Content
@import org.example.hexlet.utilities.NamedRoutes
@param Content content
@param String title

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
          crossorigin="anonymous">
    <title>${title}</title>
</head>
<body>
<div class="b-example-divider"></div>

<div class="container">
    <header class="d-flex justify-content-center py-3">
        <ul class="nav nav-pills">
            <li class="nav-item"><a href="${NamedRoutes.mainPath()}" class="nav-link active" aria-current="page">Home</a></li>
            <li class="nav-item"><a href="${NamedRoutes.coursesPath()}" class="nav-link">Courses</a></li>
            <li class="nav-item"><a href="${NamedRoutes.usersPath()}" class="nav-link">Users</a></li>
            <li class="nav-item"><a href="${NamedRoutes.buildUserPath()}" class="nav-link">Registration</a></li>
            <li class="nav-item"><a href="${NamedRoutes.buildSessionPath()}" class="nav-link">Login</a></li>
        </ul>
    </header>
</div>

<div class="mx-auto p-4 py-md-5" align="center">
    ${content}
</div>

<div class="container">
    <footer class="d-flex flex-wrap justify-content-between align-items-center py-3 my-4 border-top">
        <div class="col-md-4 d-flex align-items-center">
            <a href="/" class="mb-3 me-2 mb-md-0 text-muted text-decoration-none lh-1">
                <svg class="bi" width="30" height="24"><use xlink:href="#bootstrap"/></svg>
            </a>
            <a href="https://github.com/DmitryCo" class="text-muted">My GitHub</a>
        </div>
    </footer>
</div>
</body>
</html>