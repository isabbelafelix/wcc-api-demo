import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.get

fun main(){

    val userDao = UserDao()

    val app = Javalin.create().apply {
        exception(Exception::class.java) { e, ctx -> e.printStackTrace()}
        error(404) { ctx -> ctx.json("NOT FOUND")}
    }.start(7000)


    app.routes {
        get("/users") { ctx ->
            ctx.json(userDao.users)
        }

        get("/users/{user-id}") { ctx ->
            ctx.json(userDao.findById(ctx.pathParam("user-id").toInt())!!)
        }
    }














//    val app = Javalin.create().start(7000)
//    app.get("/wcc") { ctx -> ctx.result("Olá Deevas =)")}
















//    val isabela = User("Isabela", "isabela@wcc.com", 28)
//
//    val newNomeIsabela = isabela.copy("Isab")
//
//    println(isabela)
//    println(newNomeIsabela)
}


