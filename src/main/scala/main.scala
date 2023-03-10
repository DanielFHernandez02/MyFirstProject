import play.api.libs.json._
import com.opencsv.CSVReader
import java.io.FileReader
import java.io.PrintWriter
import scala.collection.convert.ImplicitConversions.`collection AsScalaIterable`

object CsvToJson {
  def main(args: Array[String]): Unit = {
    val reader = new CSVReader(new FileReader("D:\\ProyectoScala\\src\\main\\scala\\categories.csv"))
    val rows = reader.readAll().toList
    reader.close()
    val header = rows.head
    val data = rows.tail.map(row => header.zip(row).toMap)
    val jsonData = Json.toJson(data)
    println(Json.prettyPrint(jsonData))
  }
}