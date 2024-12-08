@import gg.jte.Content
@import org.example.hexlet.dto.courses.CoursePage
@param CoursePage page

@template.layout.layout(
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
                   <h2><a href="/courses/${course.getId()}">${course.getName()}</a></h2>
                   <p>${course.getDescription()}</p>
               </div>
            @endfor
        @endif
    `
)