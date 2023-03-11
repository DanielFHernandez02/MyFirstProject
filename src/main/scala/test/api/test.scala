import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Route
import akka.actor.ActorSystem
import akka.stream.Materializer
import scala.concurrent.ExecutionContext
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route


object Server extends App {
  implicit val system = ActorSystem("my-system")
  implicit val materializer = Materializer(system)
  implicit val ec: ExecutionContext = system.dispatcher


  val route: Route = path("MyFirstApi") {
    get {
      complete("Es poco pero es trabajo honesto")
    }
  }

  val bindingFuture = Http().newServerAt("localhost", 8080).bind(route)

  println(s"Server online at http://localhost:8080/")
}
