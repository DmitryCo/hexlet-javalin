<!-- src/main/jte/courses/show.jte -->
@import org.example.hexlet.dto.courses.CoursePage
@param CoursePage page

<html>
    <head>
        <meta charset="utf-8" />
        <title>${page.getHeader()}</title>
    </head>
    <body>
        <h1>${page.getCourses().get(0).getName()}</h1>
        <p>${page.getCourses().get(0).getDescription()}</p>
        <a href="/courses">Назад к списку курсов</a>
    </body>
</html>
