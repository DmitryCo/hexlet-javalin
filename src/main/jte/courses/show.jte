@import gg.jte.Content
@import org.example.hexlet.dto.courses.CoursePage
@param CoursePage page

@template.layout.page(
    content = @`
        <h1>${page.getCourses().get(0).getName()}</h1>
        <p>${page.getCourses().get(0).getDescription()}</p>
        <a href="/courses">Назад к списку курсов</a>
    `
)