@import gg.jte.Content
@import org.example.hexlet.dto.users.UserPage
@param UserPage page

@template.layout.layout(
    content = @`
        <h1>${page.getUsers().get(0).getName()}</h1>
        <a href="/users">Назад к списку пользователей</a>
    `
)