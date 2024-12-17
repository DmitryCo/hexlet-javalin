@import gg.jte.Content
@import org.example.hexlet.NamedRoutes

<!-- sessions/build.jte -->
<!-- Нужно не забыть добавить маршрут в NamedRoutes -->
<form action="${NamedRoutes.sessionsPath()}" method="post">
  <input type="text" placeholder="name" name="name" />
  <input type="password" placeholder="Password" name="password" />
  <input type="submit" />
</form