@import org.example.hexlet.utilities.NamedRoutes
@import org.example.hexlet.dto.users.UserPage
@param UserPage page

@template.layout.page(
title = page.getUser().getName(),
content = @`
        <div>
            <h1>${page.getUser().getName()}</h1>
        </div>
        <div>
            <a>${page.getUser().getEmail()}</a>
        </div>
        <div>
            <a href="${NamedRoutes.editUserPath(page.getUser().getId())}">edit</a>
        </div>
    `
)