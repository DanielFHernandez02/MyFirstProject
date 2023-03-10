import scala.io.Source
import io.circe._
import io.circe.parser._

object CsvJson{
  def main(args: Array[String]): Unit = {
val csvString = Source.fromFile("D:\\ProyectoScala\\src\\main\\scala\\categories.csv").getLines.mkString("\n")
val rows = csvString.split("\n").toList
val headers = rows.head.split(",").toList
val data = rows.tail.map(_.split(",").toList).map(headers.zip(_).toMap)

// convertir la lista de mapas a JSON
val json = Json.fromValues(data.map(row => {
  Json.fromFields(row.map { case (k, v) => (k, Json.fromString(v)) })
}))
 println(json.spaces2)
}
}
