@import gg.jte.Content
@import org.example.hexlet.dto.users.UserPage
@param UserPage page

@template.layout.layout(
    content = @`
    <h1>Users List</h1>
    <p>Welcome to the users page.</p>
    @if(page.getUsers().isEmpty())
        <p>Пока не добавлено ни одного пользователя</p>
    @else
        @for(var user : page.getUsers())
            <div>
                <a href="/users/${user.getId()}">
                ${user.getName()}
                </a>
            </div>
        @endfor
    @endif
    `
)