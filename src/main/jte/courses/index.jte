@import gg.jte.Content
@import org.example.hexlet.dto.courses.CoursePage
@import org.example.hexlet.NamedRoutes
@param CoursePage page

@template.layout.page(
    page = page,
    content = @`
        <h1>Список курсов</h1>
        <form action="/courses" method="get">
            <input type="search" required name="term" value="${page.getTerm()}" />
            <input type="submit" value="Искать">
        </form>

        @if(page.getCourses().isEmpty())
            <p>Пока не добавлено ни одного курса</p>
        @else
            @for(var course : page.getCourses())
               <div>
                   <h2><a href="${NamedRoutes.coursePath(course.getId())}">${course.getName()}</a></h2>
                   <p>${course.getDescription()}</p>
               </div>
            @endfor
        @endif
    `
)