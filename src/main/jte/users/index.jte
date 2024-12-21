@import org.example.hexlet.utilities.NamedRoutes
@import org.example.hexlet.dto.users.UsersPage
@import org.example.hexlet.repository.UserRepository
@param UsersPage page

@template.layout.page(
title = "Users",
content = @`
    <h1>Users</h1>
    <form action="${NamedRoutes.usersPath()}?term=" method="get">
        <input type="search" name="term" value="${page.getTerm()}" placeholder="Name" />
        <input type="submit" value="Search" />
    </form>
    @if(UserRepository.size() == 0)
        <p>Users not found</p>
    @else
        <table class="table table-striped">
            @for(var user : UserRepository.search(page.getTerm()))
                <tr>
                    <td>${user.getId()}</td>
                    <td>
                        <a href="${NamedRoutes.userPath(user.getId())}">${user.getName()}</a>
                    </td>
                    <td>
                        <p>${user.getEmail()}</p>
                    </td>
                </tr>
            @endfor
        </table>
    @endif
`
)