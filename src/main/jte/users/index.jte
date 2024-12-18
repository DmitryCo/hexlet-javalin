@import gg.jte.Content
@import org.example.hexlet.dto.users.UserPage
@import org.example.hexlet.NamedRoutes
@param UserPage page

@template.layout.page(
    page = page,
    content = @`
    <h1>Список пользователей</h1>
    <p>Welcome to the users page.</p>
    @if(page.getUsers().isEmpty())
        <p>Пока не добавлено ни одного пользователя</p>
    @else
        @for(var user : page.getUsers())
            <div>
                <a href="${NamedRoutes.usersPath(user.getId())}">
                ${user.getName()}
                </a>
            </div>
        @endfor
    @endif
    `
)