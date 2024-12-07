@import gg.jte.Content
@import org.example.hexlet.dto.users.UserPage
@param UserPage page

@content {
    <h1>Users List</h1>
    <p>Welcome to the users page.</p>
    @if(page.getUsers().isEmpty())
        <p>Пока не добавлено ни одного пользователя</p>
    @else
        @for(var user : page.getUsers())
            <div>
                <a href="/users/${page.getUsers().getId()}">
                ${user.getUsers().getFirstName()} ${user.getUsers().getLastName()}
                </a>
            </div>
        @endfor
    @endif
}